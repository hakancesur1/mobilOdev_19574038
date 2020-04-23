package com.example.myapplication;

import java.util.ArrayList;

public class User {

    private String userName, password;
    private int image;

    public User(){}

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static ArrayList<User> getUserList(){
        ArrayList<User> userList = new ArrayList<>();
        int userImages[] =
                {
                        R.drawable.ataturk,
                        R.drawable.iki,
                        R.drawable.uc,
                        R.drawable.dort,
                        R.drawable.bes,
                        R.drawable.altii,
                        R.drawable.yedi,
                        R.drawable.sekizz,
                        R.drawable.dokuz,
                        R.drawable.on,
                        R.drawable.onbir,
                        R.drawable.oniki,
                        R.drawable.onuc,
                        R.drawable.ondort,
                        R.drawable.onbes,
                        R.drawable.onalti,
                        R.drawable.onyedi,
                        R.drawable.onsekiz,
                        R.drawable.ondokuz,
                        R.drawable.yirmi
                };
        User[] users =
                {
                        new User("Atatürk", "1"),
                        new User("Wİnston", "2"),
                        new User("Castro", "3"),
                        new User("Franco", "4"),
                        new User("Gandhi", "5"),
                        new User("Hitler", "6"),
                        new User("Lenin", "7"),
                        new User("Mandela", "8"),
                        new User("Zedong", "9"),
                        new User("Mussolini", "10"),
                        new User("Roosevelt", "11"),
                        new User("Stalin", "12"),
                        new User("Tito", "13"),
                        new User("Obama", "14"),
                        new User("Merkel", "15"),
                        new User("Putin", "16"),
                        new User("Gates", "17"),
                        new User("Papa", "18"),
                        new User("Draghi", "19"),
                        new User("Che", "20")
                };

        for (int i = 0; i < userImages.length; i++) {
            User temp = new User();
            temp.setUserName(users[i].getUserName());
            temp.setPassword(users[i].getPassword());
            temp.setImage(userImages[i]);

            userList.add(temp);
        }

        return userList;
    }
}
