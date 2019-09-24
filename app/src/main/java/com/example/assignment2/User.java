package com.example.assignment2;

public class User extends Registeration{
    String email;
    String password;

    User (){

    }
    public User(String email,String password){
        this.email=email;
        this.password=password;

    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }



    }
