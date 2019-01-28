package com.example.fragments;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {
    TextView tvDescription;
   String[] descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//MainActivity is hosting the fragment so it can call the tvDescription TextView on detail fragment and reference it right here in main
        tvDescription = findViewById(R.id.tvDescription);

        //get resources from arrays.xml in Resources\values
        descriptions = getResources().getStringArray(R.array.descriptions);

        //Check if the phone is in portrait mode
        if(findViewById(R.id.layout_portrait) != null){

            FragmentManager manager = this.getSupportFragmentManager();
//When in portrait mode, we should show only the list and hide the detail so that information is displayed properly
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

        //Check if the phone is in landscape mode
        if(findViewById(R.id.layout_land) != null){
            FragmentManager manager = this.getSupportFragmentManager();
//When in landscape mode, we have enough land to show the list and the detail
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(descriptions[index]);
//When in portrait mode
        if(findViewById(R.id.layout_portrait) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            //Here we have to switch which one need to be showed once the item on the list is clicked
            //.addToBackStack(null) allows us to go back to list view from a description view
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }

    }
}
