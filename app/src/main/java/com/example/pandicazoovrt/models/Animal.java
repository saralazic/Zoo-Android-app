package com.example.pandicazoovrt.models;

import com.example.pandicazoovrt.tickets.Comment;

public class Animal {
    private String specie;
    private String latin;
    private String descent;
    private String population;
    private String lifespan;
    private int img;
    private Comment[] comments;

    public Animal(String specie, String latin, String descent, String population, String lifespan, int img, Comment[] comments) {
        this.specie = specie;
        this.latin = latin;
        this.descent = descent;
        this.population = population;
        this.lifespan = lifespan;
        this.img = img;
        this.comments = comments;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getDescent() {
        return descent;
    }

    public void setDescent(String descent) {
        this.descent = descent;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getLifespan() {
        return lifespan;
    }

    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
}
