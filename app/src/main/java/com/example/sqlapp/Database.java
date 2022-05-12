package com.example.sqlapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
//
import java.util.LinkedList;

public class Database
{


    public static void insertIntoDB(Context context, Person person)
    {
        MyDatabaseHelper dbHelper;
        SQLiteDatabase db;
        ContentValues values;
        long newRowId;
        //
        dbHelper = new MyDatabaseHelper(context);
        // set the DB in write mode
        db = dbHelper.getWritableDatabase();
        //
        // set values
        values = new ContentValues();
        values.put(MyDatabaseSchema.NAME, person.getName());
        values.put(MyDatabaseSchema.AGE, person.getAge());
        // Insert the new row, returning the primary key value of the new row
        newRowId = db.insert(MyDatabaseSchema.TABLE_NAME, null, values);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> New data inserted at row ID: " + newRowId );
    }//end insertIntoDB



    private static LinkedList<Person> select(Context context, String table, String[] columns,
                                             String selection, String[] selectionArgs, String sortOrder)
    {
        MyDatabaseHelper dbHelper;
        SQLiteDatabase db;
        Cursor cursor;
        LinkedList<Person> result;
        Person person;
        long id;
        String name;
        int age;
        //
        dbHelper = new MyDatabaseHelper(context);
        // set the DB in read mode
        db = dbHelper.getReadableDatabase();

        //make the query and obtain the result list (cursor)
        cursor = db.query(
                MyDatabaseSchema.TABLE_NAME,    // The table to query
                columns,                        // The array of columns to return (pass null to get all)
                selection,                      // The columns for the WHERE clause
                selectionArgs,                  // The values for the WHERE clause
                null,                  // don't group the rows
                null,                   // don't filter by row groups
                sortOrder                       // The sort order
        );

        result = new LinkedList<Person>();

        // scan the result list
        while(cursor.moveToNext())
        {
            id = cursor.getLong(cursor.getColumnIndexOrThrow(MyDatabaseSchema._ID));
            name = cursor.getString(cursor.getColumnIndexOrThrow(MyDatabaseSchema.NAME));
            age = cursor.getInt(cursor.getColumnIndexOrThrow(MyDatabaseSchema.AGE));
            person = new Person(name, age);
            result.add(person);
        }//end while

        // close the cursor
        cursor.close();
        return result;
    }//end select


    public static LinkedList<Person> selectAll(Context context)
    {
        String table;
        String selection;
        String sortOrder;
        LinkedList<Person> result;
        //
        table = MyDatabaseSchema.TABLE_NAME;
        String[] columns =
                {
                        BaseColumns._ID,
                        MyDatabaseSchema.NAME,
                        MyDatabaseSchema.AGE
                };
        // empty selection criteria and empty selection arguments
        selection = "";
        String[] selectionArgs = {};
        // set the sort criteria
        sortOrder = MyDatabaseSchema.NAME + " ASC";
        //
        result = select(context, table, columns, selection, selectionArgs, sortOrder);
        return result;
    }//end selectAll





    public static LinkedList<Person> selectWhereNameIs(Context context, String aName)
    {
        String table;
        String selection;
        String sortOrder;
        LinkedList<Person> result;
        //
        table = MyDatabaseSchema.TABLE_NAME;
        String[] columns =
                {
                        BaseColumns._ID,
                        MyDatabaseSchema.NAME,
                        MyDatabaseSchema.AGE
                };
        // Select WHERE NAME is aName
        selection = MyDatabaseSchema.NAME + " = ?";
        // el valor de aName "se pondrá" en el símbolo ?
        String[] selectionArgs =
                {
                        aName
                };
        // set the sort criteria
        sortOrder = MyDatabaseSchema.NAME + " DESC";
        //
        result = select(context, table, columns, selection, selectionArgs, sortOrder);
        return result;
    }//end selectWhereAgeIs



    public static void deleteFromDB(Context context, String aName)
    {
        MyDatabaseHelper dbHelper;
        SQLiteDatabase db;
        String selection;
        int numberOfDeletedRows;
        //
        dbHelper = new MyDatabaseHelper(context);
        db = dbHelper.getReadableDatabase();

        //
        // the arg values of aName will be the ?
        selection = MyDatabaseSchema.NAME + " = ?";
        //
        String[] selectionArgs =
                {
                        aName
                };
        // set the delete statement
        numberOfDeletedRows = db.delete(MyDatabaseSchema.TABLE_NAME, selection, selectionArgs);
        System.out.println(numberOfDeletedRows + " rows deleted.");
    }//end deleteFromDB



    public static void updateDB(Context context, String oldName, String newName)
    {
        MyDatabaseHelper dbHelper;
        SQLiteDatabase db;
        String selection;
        int numberOrRowsUpdated;
        //
        dbHelper = new MyDatabaseHelper(context);
        db = dbHelper.getWritableDatabase();

        // New value for one column
        String title = newName;
        //
        ContentValues values = new ContentValues();
        values.put(MyDatabaseSchema.NAME, title);
        // Which row to update, based on the title
        selection = MyDatabaseSchema.NAME + " LIKE ?";
        String[] selectionArgs =
                {
                        oldName
                };
        numberOrRowsUpdated = db.update(
                MyDatabaseSchema.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        System.out.println(numberOrRowsUpdated + " rows updated.");
    }//end updateDB

}//end class
