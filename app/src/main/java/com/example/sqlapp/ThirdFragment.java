package com.example.app160046;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ThirdFragment extends Fragment
{
    Icon icon;
    TextView nameTextView;
    TextView statusTextView;
    Button editArtworkInDBButton;
    Button deleteArtworkFromDBButton;
    Button backButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

    } //end onCreateView


    // Initialize the view
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {

    }//end onViewCreated


    private void initializeView()
    {

    }//end initializeView


    //// SET ON CLICK LISTENERS //////////////////////////////////////////////////////

    private void editArtworkInDBButtonSetOnClickListener(View view)
    {

    }//end showAllButtonSetOnClickListener

    private void deleteArtworkFromDBButtonSetOnClickListener(View view)
    {

    }//end showAllButtonSetOnClickListener

    private void backButtonSetOnClickListener(View view)
    {

    }//end backButtonSetOnClickListener

}
