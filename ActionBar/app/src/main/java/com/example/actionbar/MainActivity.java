package com.example.actionbar;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.picture);
        actionBar.setTitle(" Welcome");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    //Make a call to make action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //call getMenuInflater and inflate a specific resource: R.menu.main (in which main.xml)
        // and pass along the menu parameter
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }


    //Make menu button works

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.download:
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.refresh:
                Toast.makeText(MainActivity.this, "refreshing", Toast.LENGTH_LONG).show();
                break;
            case R.id.send:
                Toast.makeText(MainActivity.this, "sending", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
