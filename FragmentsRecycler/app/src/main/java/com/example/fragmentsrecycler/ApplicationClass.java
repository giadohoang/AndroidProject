package com.example.fragmentsrecycler;

import android.app.Application;

import java.util.ArrayList;

//When the app running, this will be the very first thing run
//Remember to update: android:name=".ApplicationClass" on androidmanifest
//Use this class and make it run before main method and close after main method
//This help information can be retained
public class ApplicationClass extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
         super.onCreate();

         people = new ArrayList<>();
         people.add(new Person("John Doe", "1234578"));
        people.add(new Person("Andy New", "675645241"));
        people.add(new Person("Beth Craigs", "65376434"));
        people.add(new Person("Linda Ann", "78966700"));


    }
}
