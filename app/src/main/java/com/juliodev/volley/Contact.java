package com.juliodev.volley;


import android.graphics.drawable.Drawable;
import android.net.Uri;

public class Contact {

    private String name;
    private String email;
    private String gender;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Contact() {
        this.name = "";
        this.email = "";
        this.gender = "";
        this.image = "";
    }

    public Contact(String name, String email, String gender, String image) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.image = image;
    }

}
