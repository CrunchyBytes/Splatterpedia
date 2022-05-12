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

public class FirstFragment extends Fragment
{
    View view;
    // Java references to GUI components
    TextView nameTextView;
    TextView ageTextView;
    Button goToQueriesButton;
    Button insertButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // create the view by inflating the layout for this fragment
        view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }//end onCreateView


    // Initialize the view
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //
        initializeView();
    }//end onViewCreated


    private void initializeView()
    {
        nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        ageTextView = (TextView) view.findViewById(R.id.ageTextView);
        goToQueriesButtonSetOnClickListener(view);
        insertButtonSetOnClickListener(view);
        MyLibrary.retractKeyboardWhenActionDone(Model.activity, ageTextView);
    }//end initializeView


    private void goToQueriesButtonSetOnClickListener(View view)
    {
        goToQueriesButton = view.findViewById(R.id.goToQueriesButton);
        goToQueriesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                NavController navController;
                //
                navController = NavHostFragment.findNavController(FirstFragment.this);
                navController.navigate(R.id.action_FirstFragment_to_SecondFragment);
            }//end onClick
        });
    }//end goToQueriesButtonSetOnClickListener


    private void insertButtonSetOnClickListener(View view)
    {
        insertButton = view.findViewById(R.id.insertButton);
        insertButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Person person;
                String age;
                //
                age = ageTextView.getText().toString();
                person = new Person(nameTextView.getText().toString(), Integer.parseInt(age));
                // The Context is the activity
                Model.myDatabase.insertIntoDB(Model.activity, person);
            }//end onClick
        });
    }//end insertButtonSetOnClickListener



}//end Fragment