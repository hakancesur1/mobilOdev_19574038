package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userName = (EditText) findViewById(R.id.name_EditText);
        final EditText password = (EditText) findViewById(R.id.password_EditText);
        final Button loginButton = (Button) findViewById(R.id.login_button);

        userList = User.getUserList();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPassword(userName.getText().toString(), password.getText().toString())){
                    Intent helloAndroidIntent = new Intent(MainActivity.this,Menu.class);
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                    startActivity(helloAndroidIntent);
                }
                else {
                    userName.setText("");
                    password.setText("");
                }
            }
        });
    }

    private boolean checkPassword(String userName, String password){
        for (int i=0; i<userList.size(); i++)
        {
            if(userName.equalsIgnoreCase(userList.get(i).getUserName()) && password.equalsIgnoreCase(userList.get(i).getPassword()))
                return true;
        }
        Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_LONG).show();
        return  false;
    }

}
