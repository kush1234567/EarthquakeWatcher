package com.bawp.firstmap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.bawp.firstmap.Activities.MapsActivity;


public class setting extends AppCompatActivity implements View.OnClickListener {

     private Button dark_mode;
     private Button light_mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        dark_mode=findViewById(R.id.night_mode);
        light_mode=findViewById(R.id.light_mode);
        dark_mode.setOnClickListener(this);
        light_mode.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.night_mode:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                finish();
                break;

            case R.id.light_mode:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
                finish();
                break;
        }

    }
}
