package com.example.toshiba.retrofitandroidtutorial;

/**
 * Created by Toshiba on 02/10/2018.
 */

public class User {

    private int id;
    private String email;
    private String name;
    private String school;

    public User(int id, String email, String name, String school) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }
}
