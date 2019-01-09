package com.example.android.quakereport;

import java.text.DecimalFormat;

import android.graphics.drawable.GradientDrawable;
import android.app.Activity;
//import android.support.v4.content.ContextCompat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

    //THis is one of default constructor of EarthquakeAdapter class, put in 2 input
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquake) {
        super(context, 0, earthquake);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View lisItemView = convertView;
        if (lisItemView == null) {
            lisItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        //Get the (@link Earthquake object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        //Find the TextView in the list_item.xml layout with the magnitude
        TextView magnitudeTexView = (TextView) lisItemView.findViewById(R.id.magnitude);

        //Get the magnitude_text_view from the current Earthquake object and set this text on the magnitude_text_view
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        // Display the magnitude of the current earthquake in that TextView
        magnitudeTexView.setText(formattedMagnitude);
        //  magnitudeTexView.setText(currentEarthquake.getMagnitude());
// about this line of code, start from the parenthesis, on currentEarthquake object, we use method getMagnitude to get the String in magnitude, It then become input for the etText method call on the magnitudeTextView
        String originalLocation = currentEarthquake.getLocation();
        String primaryLocation;
        String locationOffset;
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }
        TextView primaryLocationView = (TextView) lisItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) lisItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);


        //Creat a new Date object from the time in Milliseconds of the earthQuake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
        //Find the TextView with view ID Date
        TextView dateView = (TextView) lisItemView.findViewById(R.id.date);
        //Format the date String (i.e. "Mar 3, 1984"
        String formattedDate = formatDate(dateObject);
        //Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);


        //Find the TextView with view ID time
        TextView timeView = (TextView) lisItemView.findViewById(R.id.time);
        //Format the time string(i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        //Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTexView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        //Return the list item view that is now showing the appropriate data
        return lisItemView;


    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


}
