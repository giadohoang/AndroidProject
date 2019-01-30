package com.example.customedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    //Create an auto complee object
  AutoCompleteTextView etFirstName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect the auto complete object with item on xml
        etFirstName =(AutoCompleteTextView) findViewById(R.id.etFirstName);
//list suggestions (data)
        String[] names= {"James", "John","Jim","Jennie","Jen","Jenny"};
//plugin the object with list of suggestion, using build in design of auto complete
     //   ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, names);

//Use custom design on auto complete
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.custom_design_autocomplete, names);


//atleast need 1 match letter to trigger the suggestion
        etFirstName.setThreshold(1);
        //set adapter
        etFirstName.setAdapter(arrayAdapter);


    }
}
