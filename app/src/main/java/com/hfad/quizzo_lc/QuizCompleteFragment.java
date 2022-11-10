package com.hfad.quizzo_lc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * This fragment displays the user's
 * final score
 */
public class QuizCompleteFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_quiz_complete, container, false);

        //Get java handles for xml objects
        TextView txtScore = view.findViewById(R.id.txt_score);
        TextView txtMessage = view.findViewById(R.id.txt_message);

        //Get score and number of questions from previous fragment
        int score = QuizCompleteFragmentArgs.fromBundle(requireArguments()).getScore();
        int total = QuizCompleteFragmentArgs.fromBundle(requireArguments()).getTotal();

        double percentage = score / (total + 0.0); //calculate percentage correct

        //Display number of correct questions out of total
        String msg = score + " / " + total;
        txtScore.setText(msg);

        //Display message based on above or below 70% correct
        if (percentage > 0.7)
        {
            msg = "Great job!";
        }
        else
        {
            msg = "Better luck next time!";
        }
        txtMessage.setText(msg);

        return view;
    }
}