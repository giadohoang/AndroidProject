package com.example.actionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.picture);
        actionBar.setTitle(" Second Activity");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //Allow coming back to the main screen by displaying the back button
        //Also need to update the android manifest file
        /*
            <activity android:name=".Main2Activity">
            <meta-data android:name="android.support.PARENT_ACTIVITY"
                android:value=".MainActivity"></meta-data></activity>
         */
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
