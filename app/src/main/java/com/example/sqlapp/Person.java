package com.example.sqlapp;

public class Person
{
    private String name;
    private int age;


    public Person(String aName, int anAge)
    {
        name = aName;
        age = anAge;
    }//end constructor


    public String getName()
    {
        return name;
    }//end getName


    public int getAge()
    {
        return age;
    }//end getAge


    public String toString()
    {
        String string;
        //
        string = "(" + name + ", " + age + ").";
        return string;
    }//end toString


}//end class
