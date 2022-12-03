package com.example.pokemon_project;


public class DataModel {

    String name;
    String description;
    String fullDescription;
    int id_;
    int image;

    public DataModel(String name, String description, String fullDescription, int id_, int image) {
        this.name = name;
        this.description = description;
        this.fullDescription = fullDescription;
        this.id_ = id_;
        this.image=image;
    }


    public String getName() {
        return name;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public String getVersion() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }
}