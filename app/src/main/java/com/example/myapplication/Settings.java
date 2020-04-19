package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Settings extends AppCompatActivity {

    EditText name,surname,age,height,weight;
    RadioButton male,female;
    Button save,back;
    Switch screenMode;

    public static final String MyPreferences = "MyPrefs";
    public static final String NamePreferences="nameKey";
    public static final String SurnamePreferences="surnameKey";
    public static final String GenderPreferences="genderKey";
    public static final String AgePreferences="ageKey";
    public static final String HeightPreferences="heightKey";
    public static final String WeightPreferences="weightKey";
    public static final String ScreenModePreferences="screenModeKey";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        name=(EditText)findViewById(R.id.name_EditText);
        surname=(EditText)findViewById(R.id.surnameText);
        age=(EditText)findViewById(R.id.ageText);
        height=(EditText)findViewById(R.id.heightText);
        weight=(EditText)findViewById(R.id.weightText);
        male=(RadioButton)findViewById(R.id.maleButton);
        female=(RadioButton)findViewById(R.id.femaleButton);
        screenMode=(Switch)findViewById(R.id.screenModeSwitch);
        save=(Button)findViewById(R.id.saveButton);
        back=(Button)findViewById(R.id.backButton);

        screenMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b=screenMode.isChecked();
                ConstraintLayout constraintLayout=(ConstraintLayout)findViewById(R.id.constraitLayoutOne);
                if(b)
                    constraintLayout.setBackgroundColor(Color.WHITE);
                else
                    constraintLayout.setBackgroundColor(Color.parseColor("#8BC34A"));
            }
        });

        sharedPreferences=getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        name.setText(sharedPreferences.getString(NamePreferences, ""));
        surname.setText(sharedPreferences.getString(SurnamePreferences, ""));

        if(sharedPreferences.getString(GenderPreferences,"").equalsIgnoreCase("Male"))
            male.setChecked(true);
        if(sharedPreferences.getString(GenderPreferences,"").equalsIgnoreCase("Female"))
            female.setChecked(true);

        age.setText(sharedPreferences.getString(AgePreferences, ""));
        height.setText(sharedPreferences.getString(HeightPreferences, ""));
        weight.setText(sharedPreferences.getString(WeightPreferences, ""));

        String Value=sharedPreferences.getString(ScreenModePreferences,"");
        if(Value.equalsIgnoreCase("ON"))
        {
            ConstraintLayout constraintLayout=(ConstraintLayout)findViewById(R.id.constraitLayoutOne);
            constraintLayout.setBackgroundColor(Color.WHITE);
            screenMode.setChecked(true);
        }
        else {
            ConstraintLayout constraintLayout=(ConstraintLayout)findViewById(R.id.constraitLayoutOne);
            constraintLayout.setBackgroundColor(Color.parseColor("#8BC34A"));
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HelloAndroidIntent =new Intent(Settings.this, Menu.class);
                startActivity(HelloAndroidIntent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String nameString = name.getText().toString();
                                        String surnameString = surname.getText().toString();
                                        String ageString = age.getText().toString();
                                        String heighString = height.getText().toString();
                                        String weightString = weight.getText().toString();
                                        String genderString;
                                        String screenModeString = "";

                                        boolean durum1 = male.isChecked();
                                        boolean durum2 = female.isChecked();
                                        boolean durum3 = screenMode.isChecked();

                                        if (durum1)
                                            genderString = "Male";
                                        else if (durum2)
                                            genderString = "Female";
                                        else
                                            genderString = "Unknown";

                                        if (!durum3)
                                            screenModeString = "OFF";
                                        else if (durum3)
                                            screenModeString = "ON";

                                        SharedPreferences.Editor editor = sharedPreferences.edit();

                                        editor.putString(NamePreferences, nameString);
                                        editor.putString(SurnamePreferences, surnameString);
                                        editor.putString(AgePreferences, ageString);
                                        editor.putString(HeightPreferences, heighString);
                                        editor.putString(WeightPreferences, weightString);
                                        editor.putString(GenderPreferences, genderString);
                                        editor.putString(ScreenModePreferences, screenModeString);

                                        editor.commit();

                                        Toast.makeText(Settings.this, "Saved", Toast.LENGTH_LONG).show();

                                    }
                                }
        );
    }
}
