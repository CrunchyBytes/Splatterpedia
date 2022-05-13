package com.example.app160046;

import android.graphics.Bitmap;

public class Artwork
{
    Bitmap image;
    String name;
    String status;  // Not owned, bought, donated

    public Artwork(String name, String status)
    {
        this.name = name;
        this.status = status;
    }
}
