package com.example.sqlapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.app160046.Artwork;
import com.google.android.material.snackbar.Snackbar;

public class SecondFragment extends Fragment
{
    View view;
    // References to the GUI components
    TextView nameTextView;
    TextView statusTextView;
    Button uploadButton;
    Button backButton;
    Button addButton;
    //

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_second, container, false);
        return view;
    }//end onCreateView


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        initializeView();
    }//end onViewCreated


    private void initializeView()
    {
        nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        statusTextView = (TextView) view.findViewById(R.id.statusTextView);

        backButton = (Button) view.findViewById(R.id.backButton);
        uploadButton = (Button) view.findViewById(R.id.buttonUploadImage);
        addButton = (Button) view.findViewById(R.id.buttonAddArtwork);

        backButtonSetOnClickListener(view);
        addArtworkButtonSetOnClickListener(view);
    }//end initializeView



    //// SET ON CLICK LISTENERS //////////////////////////////////////////////////////

    private void backButtonSetOnClickListener(View view)
    {
        backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                NavController navController;
                //
                navController = NavHostFragment.findNavController(SecondFragment.this);
                navController.navigate(R.id.action_SecondFragment_to_FirstFragment);
            }//end onClick
        });
    }//end backButtonSetOnClickListener

    private void addArtworkButtonSetOnClickListener(View view)
    {
        addButton = view.findViewById(R.id.buttonAddArtwork);
        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Artwork artwork;
                String name;
                String status;
                //
                name = nameTextView.getText().toString();
                status = statusTextView.getText().toString();
                artwork = new Artwork(name, status);
                // The Context is the activity
                Model.myDatabase.insertIntoDB(Model.activity, artwork);

                Snackbar.make(view, "Artwork successfully added to the database", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }//end onClick
        });
    }//end insertButtonSetOnClickListener

}//end Fragment