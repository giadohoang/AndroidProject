package com.example.magicidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText etID;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
        tvResult.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idNumber = etID.getText().toString().trim();

                String dob = idNumber.substring(0,6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;
                if(gender < 5){
                    sGender = getString(R.string.female);
                }
                else{
                    sGender = getString(R.string.male);
                }

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;
                if(nationality ==0){
                    sNationality = getString(R.string.saCitizen);
                }
                else{
                    sNationality = getString(R.string.permanentResident);
                }

                String text = getString(R.string.dob) + dob +"\n" +
                        getString(R.string.gender) + sGender + "\n"+
                        getString(R.string.nationality) + sNationality;
                tvResult.setText(text);

                tvResult.setVisibility(View.VISIBLE);
            }
        });
    }


}
