package com.hfad.quizzo_lc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * This fragment displays the home screen
 * and allows the user to practice a quiz
 * or add a question
 * @author Luke Cossman
 */
public class HomeFragment extends Fragment {

    /**
     * Creates the view of the fragment
     * @param inflater - inflates view
     * @param container - ??
     * @param savedInstanceState - bundle with score and current question
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Get java handles to xml objects
        Spinner spnGenre = view.findViewById(R.id.spn_genre);
        Button btnPractice = view.findViewById(R.id.btn_practice);
        Button btnAdd = view.findViewById(R.id.btn_add);

        //Set up the spinner of genres to choose from
        List<String> genres = Database.getGenres(); //make arraylist of genres
        genres.add("All"); //add the "all" option
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_item, genres); //Create an array adapter with arraylist
        spnGenre.setAdapter(adapter); //attach adapter to spinner
        adapter.notifyDataSetChanged(); //notify of data change

        //Add logic to practice button
        btnPractice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String genre = spnGenre.getSelectedItem().toString(); //get selected genre
                ArrayList<Question> questions = Database.retrieveQuestionsWithGenre(genre); //get questions in that genre

                //Attach question to navigation action
                HomeFragmentDirections.ActionHomeFragmentToPracticeFragment action =
                        HomeFragmentDirections.actionHomeFragmentToPracticeFragment(questions);

                //Move to next fragment
                Navigation.findNavController(view).navigate(action);
            }
        });

        //Add logic to add question button that moves to that fragment
        btnAdd.setOnClickListener(Navigation.createNavigateOnClickListener(
            R.id.action_homeFragment_to_addQuestionFragment));

        return view;
    }
}