package com.example.sqlapp;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class MyLibrary
{


    public static void retractKeyboardWhenActionDone(Activity activity, TextView textView)
    {
        textView.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event)
            {
                InputMethodManager inputMethodManager;
                //
                if (actionId == EditorInfo.IME_ACTION_DONE)
                {
                    inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(textView.getRootView().getWindowToken(),0);
                    return true;
                }// end if
                return false;
            }//end onEditorAction
        });
    }//end retractKeyboardWhenActionDone

}//end MyLibrary
