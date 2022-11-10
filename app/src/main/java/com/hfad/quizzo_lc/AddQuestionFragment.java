package com.hfad.quizzo_lc;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This fragment allows the user to add a new question
 * to the database
 * @author Luke Cossman
 */
public class AddQuestionFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_add_question, container, false);

        //Get java handles for xml objects
        EditText edtGenre = view.findViewById(R.id.edt_genre);
        EditText edtQuestion = view.findViewById(R.id.edt_question);
        EditText edtOption1 = view.findViewById(R.id.edt_option1);
        EditText edtOption2 = view.findViewById(R.id.edt_option2);
        EditText edtOption3 = view.findViewById(R.id.edt_option3);
        EditText edtOption4 = view.findViewById(R.id.edt_option4);
        EditText edtOption5 = view.findViewById(R.id.edt_option5);
        EditText edtFact = view.findViewById(R.id.edt_fact);
        Spinner spnCorrect = view.findViewById(R.id.spn_correct);
        Button btnEnter = view.findViewById(R.id.btn_enter);

        //make array of all options
        EditText[] allOptions = {edtOption1, edtOption2, edtOption3, edtOption4, edtOption5};

        //Add button logic to enter button
        btnEnter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ArrayList<String> options = getOptions(allOptions); //get options with text in them
                String correct = spnCorrect.getSelectedItem().toString(); //get correct option

                if (isEmpty(edtGenre)) //If no genre entered, ask for it
                {
                    toast("Please enter a genre!");
                }
                else if (isEmpty(edtQuestion)) //If no question entered, ask for it
                {
                    toast("Please enter a question!");
                }
                else if (options.size() < 2) //If only one or zero options entered, ask for more
                {
                    toast("Please have at least two options!");
                }
                else if (isEmpty(edtFact)) //If no fact entered, ask for it
                {
                    toast("Please enter a follow-up fact!");
                }
                else if (getAnswer(allOptions, correct).equals("")) //if correct answer has not text, ask for it
                {
                    toast("Please mark an existing option as the correct answer");
                }
                else
                {
                    //Get text from all the EditTexts
                    String genre = edtGenre.getText().toString();
                    String question = edtQuestion.getText().toString();
                    String followUp = edtFact.getText().toString();
                    String answer = getAnswer(allOptions, correct);

                    //Create new question object
                    Question newQuestion = new Question(genre, question, options, answer, followUp);

                    //If genre not in database, add it
                    boolean found = false;
                    for (String g : Database.getGenres()) {
                        if (genre.equals(g)) {
                            found = true;
                        }
                    }
                    if (!found)
                        Database.addGenre(genre);

                    //Add question to database
                    Database.addQuestion(newQuestion);

                    //Go back to homescreen
                    Navigation.findNavController(view).
                            navigate(R.id.action_addQuestionFragment_to_homeFragment);

                }
            }
        });

        return view;
    }

    /**
     * Gets the options designated as the answer
     * @param options - array of option edittexts
     * @param search - option to get answer from
     * @return answer, or empty string if not there
     */
    private String getAnswer(EditText[] options, String search)
    {
        String found = ""; //assume not found
        String[] words = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5"};

        //For each option...
        for (int i = 0; i < 5; i++)
        {
            //...if it has text, and that text is equal to what we're looking for...
            if (!isEmpty(options[i]) && search.equals(words[i]))
            {
                //...save its text
                found = options[i].getText().toString();
                break;
            }
        }
        return found;
    }

    /**
     * Helper function to create toast messages
     * @param text - message to be put in toast
     */
    private void toast(String text)
    {
        Context context = getActivity().getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Helped function to decide if edittext is empty or not
     * @param edt - edit text to test
     * @return
     */
    private boolean isEmpty(EditText edt)
    {
        if (edt.getText().toString().equals(""))
            return true;
        else
            return false;
    }

    /**
     * Gets any valid edittext (ie any that aren't empty)
     * @param all - all edit texts
     * @return arraylist of edit texts with text in them
     */
    private ArrayList<String> getOptions(EditText[] all)
    {
        ArrayList<String> options = new ArrayList<String>();
        for (EditText e : all)
        {
            if (!isEmpty(e))
            {
                options.add(e.getText().toString());
            }
        }
        return options;
    }
}