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

public class SecondFragment extends Fragment
{
    View view;
    // References to the GUI components
    TextView nameTextView;
    TextView ageTextView;
    TextView newNameTextView;
    Button queryButton;
    Button deleteButton;
    Button showAllButton;
    Button updateButton;
    Button backButton;
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
        nameTextView = (TextView) view.findViewById(R.id.nameTextViewQuery);
        newNameTextView = (TextView) view.findViewById(R.id.newNameTextView);
        ageTextView = (TextView) view.findViewById(R.id.ageTextViewQuery);
        queryButton = (Button)  view.findViewById(R.id.buttonQuery);
        deleteButton = (Button)  view.findViewById(R.id.buttonDelete);
        showAllButton = (Button)  view.findViewById(R.id.selectAllButton);
        updateButton = (Button)  view.findViewById(R.id.buttonUpdate);
        //
        backButtonSetOnClickListener(view);
        showAllButtonSetOnClickListener(view);
        queryButtonSetOnClickListener(view);
        deleteButtonSetOnClickListener(view);
        //
        MyLibrary.retractKeyboardWhenActionDone(Model.activity, nameTextView);
        MyLibrary.retractKeyboardWhenActionDone(Model.activity, newNameTextView);
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


    private void showAllButtonSetOnClickListener(View view)
    {
        showAllButton = view.findViewById(R.id.selectAllButton);
        showAllButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Model.persons = Model.myDatabase.selectAll(Model.activity);
                Model.showPersonsList();
            }//end onClick
        });
    }//end showAllButtonSetOnClickListener


    private void queryButtonSetOnClickListener(View view)
    {
        queryButton = view.findViewById(R.id.buttonQuery);
        queryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String aName;
                int age;
                Person person;
                //
                aName = nameTextView.getText().toString();
                Model.persons = Model.myDatabase.selectWhereNameIs(Model.activity, aName);
                person = Model.persons.get(0);
                age = person.getAge();
                ageTextView.setText(String.valueOf(age));
            }//end onClick
        });
    }//end queryButtonSetOnClickListener


    private void deleteButtonSetOnClickListener(View view)
    {
        deleteButton = view.findViewById(R.id.buttonDelete);
        deleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Model.myDatabase.deleteFromDB(Model.activity, nameTextView.getText().toString());
            }//end onClick
        });
    }//end deleteButtonSetOnClickListener


}//end Fragment