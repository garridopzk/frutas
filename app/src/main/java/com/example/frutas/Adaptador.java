package com.example.frutas;

import android.app.Activity;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Adaptadorfrutas {
    private final Activity context;
    private final String[] nombre;
    private final String[] precio;
    private final String[] total;
    private final Integer[] image;

    public Adaptadorfrutas (NonNull Activity context,String[] nombre,String[] precio,String[] total,Integer[] image){
        super(context,R.layout.item,nombre);
        this.context= context;

    }

}
