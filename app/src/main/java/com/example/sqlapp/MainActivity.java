// Original code provided by Dr. Gerardo Ayala San Martín

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
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

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

        FloatingActionButton addArtworkButton = findViewById(R.id.addArtworkButton);
        addArtworkButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                NavController navController;
                //
                navController = NavHostFragment.findNavController(FirstFragment.this);
                navController.navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        // Initialize the Model
        Model.initialize(this);


    }//end onCreate

}//end class