package com.hfad.quizzo_lc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * This app simulates a quiz, allowing users to answer
 * questions based on a genre or even add their own questions
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Creates the main activity view that holds the various
     * fragments
     * @param savedInstanceState - bundle of information
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}