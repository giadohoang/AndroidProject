package com.example.temperaturecricket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Button btnSubmit;
    TextView tvResult;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.inputNumber);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
        tvResult.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.0");

        btnSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(etInput.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter all fields",Toast.LENGTH_SHORT);
                }
                else{

                    String input = etInput.getText().toString().trim();

                    int value = Integer.parseInt(input);

                    double result = (value/3.0) + 4;

                    String answer = "The approximate temperature outside is " + formatter.format(result) + " degrees Celsius";

                    tvResult.setText(answer);

                    tvResult.setVisibility(View.VISIBLE);

                }
                }
        });

    }
}
