package com.example.explicitintentsvideo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAct2, btnAct3;
    TextView tvResult;

    //Go to onclicklistener for activity 3 for more detail
    final int ACTIVITY3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        tvResult = findViewById(R.id.tvResult);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter all field!", Toast.LENGTH_SHORT).show();
                }
                else{
                    String name =etName.getText().toString().trim();

                    Intent intent = new Intent(MainActivity.this, com.example.explicitintentsvideo.Activity2.class );
                    //Put into intent a key (or the name of the data) "key" and the value (the data itself) along: name
                    intent.putExtra("key", name);
                    startActivity(intent);
                }

            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new intent, which goes to Activity3.class
                Intent intent = new Intent(MainActivity.this, com.example.explicitintentsvideo.Activity3.class);
                //Using unique request code (ACTIVITY3) so that if we have more than one different activities
                //We need to identify which one is coming back
                startActivityForResult(intent, ACTIVITY3 );


            }
        });

    }


    //When click submit on Activity3, it send back to Main Activity
    //requescode is unique value to identify activity
    //Resultcode is either Result_OK or Result_Canceled
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==ACTIVITY3){

            if(resultCode ==RESULT_OK){
            tvResult.setText(data.getStringExtra("surname"));
            }
            //If user decide not to click submit but to go back to main screen
            if(resultCode == RESULT_CANCELED){
            tvResult.setText("No data Received");
            }
        }
    }
}
