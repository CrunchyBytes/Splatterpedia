// Original code provided by Dr. Gerardo Ayala

package com.example.app160046;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper
{
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myDatabase001.db";

    private static final String SQL_CREATE_ENTRIES =
                    "CREATE TABLE " + DatabaseSchema.TABLE_NAME + " (" +
                    DatabaseSchema._ID + " INTEGER PRIMARY KEY," +
                    DatabaseSchema.ICON + " BLOB," +
                    DatabaseSchema.NAME + " TEXT, " +
                    DatabaseSchema.STATUS + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseSchema.TABLE_NAME;

    ////////////////////////////////////////////////////////////////////////////

    public DatabaseHelper(Context context)
    {

    }//end constructor


    ////////////////////////////////////////////////////////////////////////////


    public void onCreate(SQLiteDatabase db)
    {

    }//end onCreate

}//end class