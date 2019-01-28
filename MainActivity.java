package com.example.intentschallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCreateNewContact;
    ImageView ivface,ivPhone,ivWeb,ivLoc;
    String name = "", number = "", web="", map="",mood ="";

    final int CREATECONTACT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateNewContact = findViewById(R.id.btnCreateNewContact);
        ivface = findViewById(R.id.ivface);
        ivPhone = findViewById(R.id.ivPhone);
        ivWeb = findViewById(R.id.ivWeb);
        ivLoc = findViewById(R.id.ivLoc);

        ivface.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivLoc.setVisibility(View.GONE);


      /*
        btnCreateNewContact.setOnClickListener(new View.OnClickListener() {

                //Create a new intent, which goes to Activity3.class
                Intent intent = new Intent(MainActivity.this, com.example.intentschallenge.CreateContact.class);
                //Using unique request code (ACTIVITY3) so that if we have more than one different activities
                //We need to identify which one is coming back
                startActivityForResult(intent, CREATECONTACT );

        });
*/
      btnCreateNewContact.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this, com.example.intentschallenge.CreateContact.class);
              startActivityForResult(intent, CREATECONTACT );

          }
      });

      ivPhone.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel: " + number));
            startActivity(intent);
          }
      });

      ivWeb.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www." + web));
              startActivity(intent);
          }
      });

      ivLoc.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q= " + map));
              startActivity(intent);
          }
      });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CREATECONTACT){
            if(resultCode == RESULT_OK){
                ivface.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivLoc.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                number = data.getStringExtra("number");
                web= data.getStringExtra("web");
                map = data.getStringExtra("location");
                mood = data.getStringExtra("mood");


                if(mood.equals("happy")){
                    ivface.setImageResource(R.drawable.smile);
                }
                else if (mood.equals("neutral")){
                    ivface.setImageResource(R.drawable.neutral);
                }
                else{
                    ivface.setImageResource(R.drawable.sad);
                }
            }
            else{
                Toast.makeText(this,"No data passed through",Toast.LENGTH_SHORT).show();
            }
        }
    }


}
