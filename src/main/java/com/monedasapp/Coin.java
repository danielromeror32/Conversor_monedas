package com.monedasapp;

import java.util.ArrayList;
import java.util.Arrays;

public class Coin {

    private int country;
    private Double value;

    private Double finalChange;

    ArrayList<Double> exchanges = new ArrayList<>(Arrays.asList
            (0.0, 17.08, 4051.22 , 284.13, 0.91));


    //    public Coin() {
//    }
    public Coin(int country, Double value) {
        this.country = country;
        this.value = value;

    }

    public Double conversion (){
        Double valuePositionCountry = exchanges.get(this.country);
        finalChange = this.value * valuePositionCountry;
        return finalChange;
    }



}
