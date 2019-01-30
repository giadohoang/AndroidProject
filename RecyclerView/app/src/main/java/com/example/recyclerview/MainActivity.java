package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;

    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect recycleView object with list on activity_main
        recyclerView = findViewById(R.id.list);

        //make sure the recycle view wont changing
        recyclerView.setHasFixedSize(true);

        btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                people.add(new Person("Susan", "Peters", "plane"));
                myAdapter.notifyDataSetChanged();
            }
        });

        //1. Use this one if we want to display the item vertically
        // layoutManager = new LinearLayoutManager(this);

        //2. Use this ont when we want to display the items on the list horizontally
        //Where reverseLayout = false means we start from 0, true means we start from the end of the list
        //Also on activity_main, we set the list item's height into wrap content so that we can display multiple lists item
       // layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        //3. Use gridLayout manager
        //Where number 5 (after this) represent how many item of rows in the grid
        //Horizonal is how you want to scroll
        layoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);



        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("john", "Rambo", "bus"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Daniel", "Aby", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Daniel", "Aby", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("Daniel", "Aby", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Daniel", "Aby", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("Daniel", "Aby", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Daniel", "Aby", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("Daniel", "Aby", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Daniel", "Aby", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Daniel", "Aby", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("Daniel", "Aby", "plane"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Daniel", "Aby", "plane"));

        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "clicked " + people.get(index).getSurname(), Toast.LENGTH_SHORT).show();
    }
}
