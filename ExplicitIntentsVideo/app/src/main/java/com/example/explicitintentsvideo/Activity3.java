package com.example.explicitintentsvideo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText etSurname;
    Button btnSubmit, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        etSurname = findViewById(R.id.etSurname);

        btnSubmit =findViewById(R.id.btnSubmit);

        btnCancel = findViewById(R.id.btnCancel);


        //If user click submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etSurname.getText().toString().isEmpty()){
                    Toast.makeText(Activity3.this,"Please enter all fields!", Toast.LENGTH_SHORT);
                }
                else{
                    String surname = etSurname.getText().toString().trim();

                    Intent intent = new Intent();
                    intent.putExtra("surname", surname);
                    //Send intent back to Main Activity
                    setResult(RESULT_OK, intent);
                    Activity3.this.finish();
                }
            }
        });


        //If user click cancel button
        //Following code act the same way if we click back button
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setResult(RESULT_CANCELED);
                Activity3.this.finish();

            }
        });
    }
}
