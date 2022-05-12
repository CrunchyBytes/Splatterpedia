package com.example.sqlapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDatabaseHelper extends SQLiteOpenHelper
{
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myDatabase001.db";

    private static final String SQL_CREATE_ENTRIES =
                    "CREATE TABLE " + MyDatabaseSchema.TABLE_NAME + " (" +
                    MyDatabaseSchema._ID + " INTEGER PRIMARY KEY," +
                    MyDatabaseSchema.NAME + " TEXT," +
                    MyDatabaseSchema.AGE + " INT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MyDatabaseSchema.TABLE_NAME;

    ////////////////////////////////////////////////////////////////////////////

    public MyDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }//end constructor


    ////////////////////////////////////////////////////////////////////////////


    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ENTRIES);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>> creating Database");
    }//end onCreate



    ////////////////////////////////////////////////////////////////////////////

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
        System.out.println(">>>>>>>>>>>>>>>>>>>> upgrading Database");
    }//end onUpgrade


    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onUpgrade(db, oldVersion, newVersion);
        System.out.println(">>>>>>>>>>>>>>>>>>>> downgrading Database");
    }//end onDowngrade

}//end class