package com.juliodev.volley;


import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Contact {

    private String name;
    private String email;
    private String gender;
    // Esto le dice a gson el nombre en el api del campo
    @SerializedName("profile_pic")
    @Expose
    private String image;



    @SerializedName("contacts")
    @Expose
    private ArrayList<Contact> allContacts;

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

    public ArrayList<Contact> getAllContacts() {
        return allContacts;
    }

    public void setAllContacts(ArrayList<Contact> allContacts) {
        this.allContacts = allContacts;
    }
}
