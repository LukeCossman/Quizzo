package com.hfad.quizzo_lc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a question
 * @author Luke Cossman
 */
public class Question {

    private String genre; //genre of the question
    private String question; //the question itself
    private ArrayList<String> options; //the options the user can pick from
    private String answer; //the correct answer
    private String followUp; //a fun follow up fact

    /**
     * Question constructor
     * @param g - String genre
     * @param q - String question
     * @param o - ArrayList of options
     * @param a - String answer
     * @param f - String fact
     */
    public Question(String g, String q, ArrayList<String> o, String a, String f)
    {
        genre = g;
        question = q;
        options = o;
        answer = a;
        followUp = f;
    }

    /**
     * Get the question's genre
     * @return genre
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Get the question
     * @return question
     */
    public String getQuestion()
    {
        return question;
    }

    /**
     * Get the options
     * @param random - true if scrambled, else false
     * @return
     */
    public ArrayList<String> getOptions(boolean random)
    {
        if (random)
        {
            Collections.shuffle(options); //scrambles order of options
        }
        return options;
    }

    /**
     * Get the correct answer
     * @return answer
     */
    public String getAnswer()
    {
        return answer;
    }

    /**
     * Get the follow up fact
     * @return fact
     */
    public String getFollowUp()
    {
        return followUp;
    }

    /**
     * toString (used for debugging)
     * @return information of question
     */
    public String toString()
    {
        return "Genre: " + genre +
                "\nQuestion: " + question +
                "\nOptions: " + options +
                "\nAnswer: " + answer +
                "\nFollow Up: " + followUp;
    }

}
