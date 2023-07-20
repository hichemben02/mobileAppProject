package com.example.project.models;

import com.example.project.models.Scene;

import java.io.Serializable;
import java.util.List;

public class Story implements Serializable {
    private int image;
    private String title, description;
    private List<Scene> scenesList;
    private boolean isFavorite;
    private int id = 0;

    public Story(int image, List<Scene> sceneList, String title, String description){
        this.image = image;
        this.scenesList = sceneList;
        this.title = title;
        this.description = description;
        this.isFavorite = false;
        this.id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public void setImage(int image){
        this.image = image;
    }

    public int getImage(){
        return this.image;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setScenesList(List<Scene> scenesList) {
        this.scenesList = scenesList;
    }

    public List<Scene> getScenesList(){
        return this.scenesList;
    }

}
