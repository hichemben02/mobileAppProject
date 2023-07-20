package com.example.project.models;

import java.io.Serializable;

public class Scene implements Serializable {
    private String text;
    private int image;

    public Scene(int image, String text){
        //this.title = title;
        this.image = image;
        this.text = text;
    }

    /*
    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }*/

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }

    public int getImage(){
        return this.image;
    }

    public void setImage(int image){
        this.image = image;
    }
}
