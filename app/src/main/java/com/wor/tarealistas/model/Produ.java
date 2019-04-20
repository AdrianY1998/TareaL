package com.wor.tarealistas.model;

import com.google.gson.annotations.Expose;

public class Produ {

    @Expose
    private int id;

    @Expose
    private String name;

    @Expose
    private int price;

    @Expose
    private int image;

    public Produ(int id, String nombre, int precio, int imagen) {
        this.id = id;
        this.name = nombre;
        this.price = precio;
        this.image = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
