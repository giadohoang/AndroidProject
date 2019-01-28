package com.example.intentschallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class CreateContact extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etNumber, etWeb, etLoc;
    ImageView ivHappy, ivNeutral, ivSad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ivHappy = findViewById(R.id.ivHappy);
        ivNeutral= findViewById(R.id.ivNeutral);
        ivSad = findViewById(R.id.ivSad);

        etName = findViewById(R.id.etName);
       etNumber = findViewById(R.id.etNumber);
        etWeb = findViewById(R.id.etweb);
        etLoc = findViewById(R.id.etLoc);

        ivSad.setOnClickListener(this);
        ivHappy.setOnClickListener(this);
        ivNeutral.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(etName.getText().toString().isEmpty() ||
                etNumber.getText().toString().isEmpty() ||
                etWeb.getText().toString().isEmpty() ||
                etLoc.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter all fields",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("number", etNumber.getText().toString().trim());
            intent.putExtra("web", etWeb.getText().toString().trim());
            intent.putExtra("location", etLoc.getText().toString().trim());

            if(view.getId() == R.id.ivHappy){
                intent.putExtra("mood", "happy");
            }
            else if(view.getId() == R.id.ivNeutral){
                intent.putExtra("mood", "neutral");
            }
            else{
                intent.putExtra("mood", "sad");
            }

            setResult(RESULT_OK, intent);
            CreateContact.this.finish();
        }

    }
}
