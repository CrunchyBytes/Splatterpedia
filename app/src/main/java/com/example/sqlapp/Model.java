package com.example.sqlapp;

import android.app.Activity;

import java.util.LinkedList;

public abstract class Model
{
     static Database myDatabase;
     static LinkedList<Artwork> artworks;
     static Activity activity;

     public static void initialize(Activity anActivity)
     {
          // The Activity is the Context
          activity = anActivity;
     }//end initialize

}//end Model
