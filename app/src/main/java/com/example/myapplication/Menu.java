package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Menu extends AppCompatActivity {

    public static final String MyPreferences = "MyPrefs";
    public static final String Name1="nameKey";
    public static final String Surname1="surnameKey";
    public static final String Gender1="genderKey";
    public static final String Height1="heightKey";
    public static final String Weight1="weightKey";
    public static final String screenMode1="screenModeKey";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        sharedPreferences=getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        String value = sharedPreferences.getString(screenMode1, "");
        if(value.equalsIgnoreCase("ON"))
        {
            ConstraintLayout constraintLayout=(ConstraintLayout)findViewById(R.id.constraitLayoutTwo);
            constraintLayout.setBackgroundColor(Color.WHITE);
        }
        else {
            ConstraintLayout constraintLayout=(ConstraintLayout)findViewById(R.id.constraitLayoutTwo);
            constraintLayout.setBackgroundColor(Color.parseColor("#8BC34A"));
        }

        Button emailButton = (Button)findViewById(R.id.sendEmailButton);
        Button sensorButton = (Button)findViewById(R.id.sensorsButton) ;
        Button settingButton = (Button)findViewById(R.id.settingsButton);
        Button userListButton = (Button)findViewById(R.id.userListButton);

        View.OnClickListener emailButtonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HelloAndroidIntent =new Intent(Menu.this,EmailSend.class);
                startActivity(HelloAndroidIntent);
            }
        };

        emailButton.setOnClickListener(emailButtonClick);

        sensorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HelloAndroidIntent =new Intent(Menu.this, Sensors.class);
                startActivity(HelloAndroidIntent);
            }
        });

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HelloAndroidIntent = new Intent (Menu.this,Settings.class);
                startActivity(HelloAndroidIntent);
            }
        });
    userListButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent HelloAndroidIntent =new Intent(Menu.this, UserList.class);
            startActivity(HelloAndroidIntent);
        }
    });
    };
}
