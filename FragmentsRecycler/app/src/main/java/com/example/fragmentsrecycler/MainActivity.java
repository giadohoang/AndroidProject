package com.example.fragmentsrecycler;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {


    TextView tvName, tvTel;
    EditText etName, etTel;
    Button btnAdd;
    ListFrag listFrag;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);
        etName = findViewById(R.id.etName);
        etTel = findViewById(R.id.etTel);
        btnAdd = findViewById(R.id.btnAdd);

        fragmentManager = this.getSupportFragmentManager();
        //Connect listFrag to R.id.listFrag
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.listFrag);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etName.getText().toString().isEmpty() || etTel.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Add new name and number to the list
                    ApplicationClass.people.add(new Person(etName.getText().toString().trim(), etTel.getText().toString().trim()));
                    //Show update success
                    Toast.makeText(MainActivity.this,"Person successfully added",Toast.LENGTH_SHORT).show();

                    //Reset for new input
                    etTel.setText(null);
                    etName.setText(null);

                    //call method notifyDataChanged from ListFrag
                    listFrag.notifyDataChamged();
                }
            }
        });

//Set DetailFrag to start present information at index 0
        onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {
    tvName.setText(ApplicationClass.people.get(index).getName());
    tvTel.setText(ApplicationClass.people.get(index).getTelNr());
    }
}
