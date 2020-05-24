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
                        R.drawable.gslogo,
                        R.drawable.fblogo,
                        R.drawable.panda,
                        R.drawable.turkcellemocan1,
                        R.drawable.turkcellemocan2,
                        R.drawable.kelebek,
                        R.drawable.papatya,
                        R.drawable.turkcellemocan3,
                        R.drawable.turkcellemocan4,
                        R.drawable.tslogo,
                        R.drawable.bjklogo,
                        R.drawable.gslogo,
                        R.drawable.fblogo,
                        R.drawable.panda,
                        R.drawable.turkcellemocan1,
                        R.drawable.turkcellemocan2,
                        R.drawable.kelebek,
                        R.drawable.papatya,
                        R.drawable.turkcellemocan3,
                        R.drawable.turkcellemocan4
                };
        User[] users =
                {
                        new User("Hakan", "1"),
                        new User("İlker", "2"),
                        new User("Anıl", "3"),
                        new User("Gökhan", "4"),
                        new User("Ege", "5"),
                        new User("Melek", "6"),
                        new User("Fatma", "7"),
                        new User("Çağdaş", "8"),
                        new User("Ahmet", "9"),
                        new User("Mehmet", "10"),
                        new User("Güven", "11"),
                        new User("Ali", "12"),
                        new User("Veli", "13"),
                        new User("Okan", "14"),
                        new User("Murat", "15"),
                        new User("Kaan", "16"),
                        new User("Ferhan", "17"),
                        new User("Fatih", "18"),
                        new User("Mert", "19"),
                        new User("Erdi", "20")
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
