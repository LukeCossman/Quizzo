package com.hfad.quizzo_lc;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This fragment displays the quiz questions to be
 * answers by the user
 * @author Luke Cossman
 */
public class PracticeFragment extends Fragment {

    private int currentNum; //the index of which question is active
    private int score; //the number of correct answers

    /**
     * Helper function to display toasts
     * @param text - text inside of toast
     */
    private void toast(String text)
    {
        Context context = getActivity().getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Save current question and score when device is rotated
     * @param savedInstanceState
     */
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("CURRENT", currentNum);
        savedInstanceState.putInt("SCORE", score);
    }

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
        View view = inflater.inflate(R.layout.fragment_practice, container, false);

        //Get questions from previous fragment
        ArrayList<Question> questions = PracticeFragmentArgs.fromBundle(requireArguments()).getQuestions();

        //Get handles on all xml objects
        TextView txtProgress = view.findViewById(R.id.txt_progress);
        TextView txtGenrePractice = view.findViewById(R.id.txt_genre_practice);
        TextView txtQuestion = view.findViewById(R.id.txt_question);
        RadioGroup grpOptions = view.findViewById(R.id.grp_options);
        RadioButton radOne = view.findViewById(R.id.rad_one);
        RadioButton radTwo = view.findViewById(R.id.rad_two);
        RadioButton radThree = view.findViewById(R.id.rad_three);
        RadioButton radFour = view.findViewById(R.id.rad_four);
        RadioButton radFive = view.findViewById(R.id.rad_five);
        Button btnSubmit = view.findViewById(R.id.btn_submit);

        //Gets saved instance information
        boolean random;
        if (savedInstanceState != null)
        {
            currentNum = savedInstanceState.getInt("CURRENT");
            score = savedInstanceState.getInt("SCORE");
            random = false; //if the screen is being rotated, the
                            //options shouldn't be scrambled
        }
        else
        {
            currentNum = 0;
            score = 0;
            random = true; //if it's a new question, the
                           //options should be scrambled
        }

        int totalQuestions = questions.size(); //total number of questions to be answered

        String progress = currentNum+1 + " / " + totalQuestions; //string that displays progress
        Question currentQuestion = questions.get(currentNum); //get current question object

        //Set the text for the text views
        txtProgress.setText(progress);
        txtGenrePractice.setText(currentQuestion.getGenre());
        txtQuestion.setText(currentQuestion.getQuestion());

        //Create arraylist of all the radio buttons
        ArrayList<RadioButton> rads = new ArrayList<RadioButton>();
        rads.add(radOne);
        rads.add(radTwo);
        rads.add(radThree);
        rads.add(radFour);
        rads.add(radFive);

        //Make all radio buttons inviisble
        for (RadioButton r : rads)
        {
            r.setVisibility(View.INVISIBLE);
        }

        //Show only the necessary number of radio buttons and set their text
        ArrayList<String> options = currentQuestion.getOptions(random);
        for (int i = 0; i < options.size(); i++)
        {
            rads.get(i).setVisibility(View.VISIBLE);
            rads.get(i).setText(options.get(i));
        }


        View v = view; //save view to be used in onClick so it doesn't use the
                       //onClick view
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Question currentQuestion = questions.get(currentNum); //getQuestion object

                //get chosen radio button and check if its correct or not
                RadioButton chosen = v.findViewById(grpOptions.getCheckedRadioButtonId());
                if (chosen.getText().toString().equals(currentQuestion.getAnswer()))
                {
                    score += 1;
                    toast("Correct");
                }
                else
                {
                    toast("Incorrect");
                }
                toast(currentQuestion.getFollowUp()); //show follow up fact

                currentNum += 1; //increment index

                //If quiz not done yet
                if (currentNum < totalQuestions)
                {
                    //Do previous steps, but for new question
                    String progress = currentNum+1 + " / " + totalQuestions;
                    currentQuestion = questions.get(currentNum);

                    txtProgress.setText(progress);
                    txtGenrePractice.setText(currentQuestion.getGenre());
                    txtQuestion.setText(currentQuestion.getQuestion());

                    ArrayList<RadioButton> rads = new ArrayList<RadioButton>();
                    rads.add(radOne);
                    rads.add(radTwo);
                    rads.add(radThree);
                    rads.add(radFour);
                    rads.add(radFive);

                    grpOptions.clearCheck();
                    for (RadioButton r : rads)
                    {
                        r.setVisibility(View.INVISIBLE);
                    }

                    ArrayList<String> options = currentQuestion.getOptions(true);
                    for (int i = 0; i < options.size(); i++)
                    {
                        rads.get(i).setVisibility(View.VISIBLE);
                        rads.get(i).setText(options.get(i));
                    }

                }
                else //if quiz is done
                {
                    //Move to next fragment, passing the score and total questions safe args
                    PracticeFragmentDirections.ActionPracticeFragmentToQuizCompleteFragment action =
                            PracticeFragmentDirections.actionPracticeFragmentToQuizCompleteFragment(score, questions.size());
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });

        return view;
    }


}