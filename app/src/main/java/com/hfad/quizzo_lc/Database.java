package com.hfad.quizzo_lc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class houses a database of genres, and questions
 * per those genres
 * @author Luke Cossman
 */
public class Database {

    private static ArrayList<Question> questions; //arraylist of questions
    private static ArrayList<String> genres; //arraylist of genres

    /**
     * Loads up the data if it hasnt been already
     */
    public static void load()
    {
        if (questions == null)
        {
            populate();
        }
    }

    /**
     * Fills up database with pre-generated questions and genres
     */
    private static void populate()
    {
        Question q;
        questions = new ArrayList<Question>();
        genres = new ArrayList<String>();
        ArrayList<String> answers = new ArrayList<String>();

        genres.add("Geography");
        genres.add("Video Games");
        genres.add("Animals");
        genres.add("Sports");

        answers.add("Pacific");
        answers.add("Atlantic");
        answers.add("Arctic");
        answers.add("Indian");
        q = new Question("Geography",
                "Which ocean is the largest?",
                clone(answers),
                "Pacific",
                "The Pacific Ocean stretches to an astonishing 63.8 million square miles!");
        questions.add(q);
        answers.clear();

        answers.add("192");
        answers.add("195");
        answers.add("193");
        answers.add("197");
        q = new Question("Geography",
                "How many countries are in the world?",
                clone(answers),
                "195",
                "Africa has the most countries of any continent with 54.");
        questions.add(q);
        answers.clear();

        answers.add("Mississippi");
        answers.add("Nile");
        answers.add("Congo");
        answers.add("Amazon");
        q = new Question("Geography",
                "What is the name of the longest river in the world?",
                clone(answers),
                "Nile",
                "Explorer John Hanning Speke discovered the source of the Nile on August 3rd, 1858.");
        questions.add(q);
        answers.clear();

        answers.add("United States");
        answers.add("China");
        answers.add("Japan");
        answers.add("India");
        q = new Question("Geography",
                "Which country has the largest population?",
                clone(answers),
                "China",
                "Shanghai is the most populated city in China with a population of 24,870,895.");
        questions.add(q);
        answers.clear();

        answers.add("Mars");
        answers.add("Mercury");
        answers.add("Venus");
        answers.add("Jupiter");
        q = new Question("Geography",
                "What planet is closest to Earth?",
                clone(answers),
                "Venus",
                "Even though Venus is the closest, the planet is still ~38 million miles from Earth!");
        questions.add(q);
        answers.clear();

        answers.add("Sega");
        answers.add("Nintendo");
        answers.add("Sony");
        answers.add("Atari");
        q = new Question("Video Games",
                "Which company created the famous plumber Mario",
                clone(answers),
                "Nintendo",
                "Nintendo created Mario in 1981 for the arcade game Donkey Kong.");
        questions.add(q);
        answers.clear();

        answers.add("Sonic");
        answers.add("Tails");
        answers.add("Knuckles");
        answers.add("Amy");
        q = new Question("Video Games",
                "What is the name of the famous video game character who is a blue hedgehog?",
                clone(answers),
                "Sonic",
                "In some official concept art, Sonic was originally meant to be a rabbit.");
        questions.add(q);
        answers.clear();

        answers.add("Wii Sports");
        answers.add("Grand Theft Auto V");
        answers.add("Tetris");
        answers.add("Minecraft");
        q = new Question("Video Games",
                "As of 2022, which of the following is the best selling video game of all time?",
                clone(answers),
                "Minecraft",
                "As of 2022, Minecraft has sold over 238 million units.");
        questions.add(q);
        answers.clear();

        answers.add("Place 3 milk, 2 sugar, 1 egg, and 3 wheat in the 3x3 crafting grid");
        answers.add("Place 2 milk, 3 sugar, 2 eggs, and 3 wheat in the 3x3 crafting grid");
        answers.add("Place 3 milk, 5 sugar, 6 eggs, and 3 wheat in the 3x6 crafting grid");
        answers.add("Place 1 milk, 1 sugar, 1 egg, and 1 wheat in the 1x1 crafting grid");
        q = new Question("Video Games",
                "How do you craft a cake in Minecraft",
                clone(answers),
                "Place 3 milk, 2 sugar, 1 egg, and 3 wheat in the 3x3 crafting grid",
                "Cake is the only food that has to be placed for players to eat it.");
        questions.add(q);
        answers.clear();

        answers.add("Diddy Kong");
        answers.add("Donkey Kong Jr.");
        answers.add("Dixie Kong");
        answers.add("Papa Kong");
        q = new Question("Video Games",
                "Who is Donkey Kong's son?",
                clone(answers),
                "Donkey Kong Jr.",
                "Donkey Kong Jr. appeared as a playable character in Super Mario Kart for the SNES celebrating the" +
                        " 10th anniversary of his arcade game.");
        questions.add(q);
        answers.clear();

        answers.add("1");
        answers.add("5");
        answers.add("4");
        answers.add("10");
        q = new Question("Video Games",
                "How many Xenoblade Chronicles have been created?",
                clone(answers),
                "5",
                "Xenoblade Chronicles was originally going to be titled 'Monado: Beginning of the World" +
                        " and was not intended to be an entry of the Xeno series.");
        questions.add(q);
        answers.clear();

        answers.add("Black");
        answers.add("White");
        answers.add("Pink");
        answers.add("Brown");
        q = new Question("Animals",
                "What colour is a polar bear's skin?",
                clone(answers),
                "Black",
                "Polar bear fur is actually hollow and transparent!");
        questions.add(q);
        answers.clear();

        answers.add("Man-o-war");
        answers.add("Box Jellyfish");
        answers.add("Irukandji Jellyfish");
        answers.add("Sea Nettle");
        q = new Question("Animals",
                "Which jellyfish has the most painful sting?",
                clone(answers),
                "Irukandji Jellyfish",
                "Some jellyfish are functionally immortal.");
        questions.add(q);
        answers.clear();

        answers.add("True");
        answers.add("False");
        q = new Question("Animals",
                "Hyenas scavenge more than lions do.",
                clone(answers),
                "False",
                "Lions actually scavenge for food more than they hunt it.");
        questions.add(q);
        answers.clear();

        answers.add("Grizzly Bear");
        answers.add("Polar Bear");
        answers.add("Raccoon");
        answers.add("Cat");
        answers.add("Spectacled Bear");
        q = new Question("Animals",
                "What is the giant panda's closest relative?",
                clone(answers),
                "Spectacled Bear",
                "Despite common belief, molecular studies show that pandas are closer to bears" +
                        " than raccoons.");
        questions.add(q);
        answers.clear();

        answers.add("Hippo");
        answers.add("Sloth");
        answers.add("Bats");
        answers.add("Elk");
        answers.add("Fish");
        q = new Question("Animals",
                "Which of these animals cannot swim?",
                clone(answers),
                "Hippo",
                "Hippos are the world's most dangerous land animal.");
        questions.add(q);
        answers.clear();

        answers.add("Eagles");
        answers.add("Packers");
        answers.add("Cowboys");
        answers.add("76ers");
        answers.add("Ravens");
        q = new Question("Sports",
                "Who won the first superbowl in NFL history?",
                clone(answers),
                "Packers",
                "The Packers have won the NFL championship 4 times.");
        questions.add(q);
        answers.clear();

        answers.add("1");
        answers.add("2");
        answers.add("Infinite");
        answers.add("7");
        answers.add("3");
        q = new Question("Sports",
                "How many NFL teams play in New Jersey and New York?",
                clone(answers),
                "3",
                "The Giants and Jets both play in New Jersey, but are New York Based. " +
                        "The Buffalo Bills are the only team that actually plays in New York.");
        questions.add(q);
        answers.clear();

        answers.add("50");
        answers.add("100");
        answers.add("75");
        answers.add("60");
        q = new Question("Sports",
                "How many points did Kobe Bryant score in his last NBA game?",
                clone(answers),
                "60",
                "Kobe scored 60+ five times during his career.");
        questions.add(q);
        answers.clear();

        answers.add("28");
        answers.add("7");
        answers.add("23");
        answers.add("13");
        q = new Question("Sports",
                "How many gold medals has Michael Phelps been awared in his olympic career?",
                clone(answers),
                "23",
                "Michael Phelps is the most successful olympian, owning the most medals and" +
                        " most gold medals of any athlete");
        questions.add(q);
        answers.clear();

        answers.add("Michael Jordan");
        answers.add("Magic Johnson");
        answers.add("Bill Russel");
        answers.add("Lebron James");
        q = new Question("Sports",
                "What player has the most NBA championships in NBA history?",
                clone(answers),
                "Bill Russel",
                "Bill Russel won the NBA championship 11 times in his career!");
        questions.add(q);
        answers.clear();

        answers.add("Venus Williams");
        answers.add("Roger Federer");
        answers.add("Rafael Nadal");
        answers.add("Serena Williams");
        answers.add("Novak Djokovic");
        q = new Question("Sports",
                "Who has earned more Grand Slam single titles during the open era in tennis?",
                clone(answers),
                "Serena Williams",
                "Serena and Venus Williams won 14 Grand Slam Doubles titles and three doubles gold medals at the Olympics");
        questions.add(q);
        answers.clear();

    }

    /**
     * Retrieves questions that fall under the given genre
     * @param genre - genre to retrieve questions from (could be all)
     * @return arraylist of questions
     */
    public static ArrayList<Question> retrieveQuestionsWithGenre(String genre)
    {
        ArrayList<Question> request; //arraylist to be filled with genre-matching questions

        //if asked for all, just give all questions
        if (genre.toLowerCase().equals("all"))
        {
            request = clone(questions);
        }
        else //else, get specific genre
        {
            request = new ArrayList<Question>();
            for (Question q : questions)
            {
                if (q.getGenre().equals(genre))
                {
                    request.add(q);
                }
            }
        }
        Collections.shuffle(request); //scramble order of questions
        return request;
    }

    /**
     * Add a question to the database
     * @param q - question to be added
     */
    public static void addQuestion(Question q)
    {
        questions.add(q);
    }

    /**
     * Add a genre to the database
     * @param g - genre to be added
     */
    public static void addGenre(String g)
    {
        genres.add(g);
    }

    /**
     * Get all genres in database
     * @return arraylist of genres
     */
    public static ArrayList<String> getGenres()
    {
        return clone(genres);
    }

    /**
     * Clones an arraylist so editing it in one place
     * does not affect it in another
     * @param original - arraylist to be cloned
     * @param <T> - template type (string, question, etc)
     * @return identical but different arraylist
     */
    private static <T> ArrayList<T> clone(ArrayList<T> original)
    {
        ArrayList<T> copy = new ArrayList<T>();
        for (T s : original)
        {
            copy.add(s);
        }
        return copy;
    }



}
