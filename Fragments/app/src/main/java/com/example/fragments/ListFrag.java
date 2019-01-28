package com.example.fragments;


import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {

    ItemSelected activity;

    //In order to create a link between clicked item on this left list
    //with the description on other fragment list, we use this interface
    public interface ItemSelected{
        void onItemSelected(int index);
    }


    public ListFrag() {
        // Required empty public constructor
    }


    //THis method is called when the fragment has been associated with the activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;
    }

    //This method is called when onActivity method is finished
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] data = getResources().getStringArray(R.array.pieces);


        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        //when first run the app, the detail from index 0 of the arrayList will be displayed

        //If the phone is in landscape mode, we would need to load the first description(at index 0) to the description fragment
        if(this.getActivity().findViewById(R.id.layout_land) != null){
            activity.onItemSelected(0);
        }
       // activity.onItemSelected(0);
    }

    //When a list item is clicked, we will know exactly where the item is clicked
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       // super.onListItemClick(l, v, position, id);

        activity.onItemSelected(position);
    }
}
