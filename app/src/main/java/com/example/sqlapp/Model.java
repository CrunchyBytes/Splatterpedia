package com.example.sqlapp;

import android.app.Activity;

import java.util.LinkedList;

public abstract class Model
{
     static Database myDatabase;
     static LinkedList<Person> persons;
     static Activity activity;
     //

     public static void initialize(Activity anActivity)
     {
          // The Activity is the Context
          activity = anActivity;
     }//end initialize


     public static void showPersonsList()
     {
          int i;
          //
          // show results in the console
          System.out.println("======== PERSONS =========");
          i=0;
          while(i < Model.persons.size())
          {
               System.out.println(Model.persons.get(i));
               i = i + 1;
          }//end while
          System.out.println("===========================");
     }//end showPersonsList
}//end Model
