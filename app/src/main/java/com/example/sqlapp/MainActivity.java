package com.example.sqlapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.provider.BaseColumns;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

/*  Activity: The entry point for an app's interaction
    with the user.

    AppCompatActivity: Base class for activities that
    wish to use some of the newer platform features
    on older Android devices (i.e., setSupporActionBar(Toolbar)

    Main activity: The first screen to appear when the
    user launches the app.
    From there, the main activity might launch other
    activities that provide screens for related tasks
 */
public class MainActivity extends AppCompatActivity
{

    @Override
    /*
        Where the activity is initialized; called when
        the activity is starting.
        Where most initialization should go (i.e.,
        setContentView(int) -> inflate activity's UI,
        findViewById(int) -> Programmatically interact
        with widgets.

        Bundle: Mapping from String keys to various
        Parcelable values
     */
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
            Toolbar: Standard toolbar for use within application content.
            (generalization of action bars for use within application
            layouts)
            ActionBar: Primary toolbar within activity that may display
            the activity title, application-level navigation affordances,
            and other interactive items
            Appears at the top of an activity's window when the activity
            uses the AppCompat's theme (or one of its descendant themes).
         */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.addArtworkButton);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // Initialize the Model
        Model.initialize(this);
    }//end onCreate


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }//end onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }//end if

        return super.onOptionsItemSelected(item);
    }//end onOptionsItemSelected


    /*

    private void updates()
    {
        Model.myDatabase.updateDB(this, "Kotoko", "Mariya");
        Model.persons = Model.myDatabase.selectAll(this);
        Model.showPersonsList();
    }//end updates
     */

}//end class