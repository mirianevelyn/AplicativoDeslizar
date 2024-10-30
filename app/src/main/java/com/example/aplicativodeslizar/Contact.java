package com.example.aplicativodeslizar;

public class Contact {
    private String name;
    private String number;
    private int imageResource;

    public Contact(String name, String number, int imageResource) {
        this.name = name;
        this.number = number;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getImageResource() {
        return imageResource;
    }
}
