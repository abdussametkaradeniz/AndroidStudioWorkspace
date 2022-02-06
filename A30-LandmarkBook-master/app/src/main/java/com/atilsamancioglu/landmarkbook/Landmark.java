package com.atilsamancioglu.landmarkbook;

import java.io.Serializable;

public class Landmark implements Serializable {
    String name;
    String country;
    int image;
    //serializable sınıfı bir veriyi bir yere yollarken bunu veriye çevirip sonra tekrar çevirebiliyor aslına
    public Landmark(String name, String country, int image) {
        this.name = name;
        this.country = country;
        this.image = image;
    }
}
