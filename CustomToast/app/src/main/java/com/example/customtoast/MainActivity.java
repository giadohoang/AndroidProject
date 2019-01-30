package com.example.customtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btnToast = findViewById(R.id.btnToast);

    btnToast.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Toast.makeText(MainActivity.this,"Data successfully saved", Toast.LENGTH_LONG).show();

            showToast("Data successfully saved");

        }


    });

    }

    public void showToast(String message){
//Make a connection to the layout toast.xml
        //and gives us access to that layout
        View toastView = getLayoutInflater().inflate(R.layout.toast, (ViewGroup)findViewById(R.id.linearLayout));

        TextView tvToast =  (TextView) toastView.findViewById(R.id.tvToast);

        tvToast.setText(message);

        Toast toast = new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastView);
        //set toast location
        toast.setGravity(Gravity.BOTTOM | Gravity.FILL_HORIZONTAL,0,0);
        toast.show();
    }
}
