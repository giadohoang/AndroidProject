package com.example.android.quakereport;

import android.location.Location;

public class Earthquake {
    /** Magnitude of the earthquake*/
    private double mMagnitude;
    /** Location of the earthquake*/
    private String mLocation;
    /** Day that the earthquake take place*/
    private String mDay;
    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    private String mUrl;

    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url){
            mMagnitude= magnitude;
            mLocation = location;
            mTimeInMilliseconds = timeInMilliseconds;
            mUrl = url;
    }

    public double getMagnitude(){return mMagnitude;}

    public String getLocation() {return mLocation;}

    public long getTimeInMilliseconds(){ return mTimeInMilliseconds;}

    public String getUrl() {return mUrl; }
}
