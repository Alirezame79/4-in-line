package com.company;

public class ScoreBoard {

    public static int gameTurn = 0;
    public static int PCScore = 0;
    public static int userScore = 0;
    public static String whoBegin = "";

    public void PCWins(){
        PCScore++;
    }

    public void userWins(){
        userScore++;
    }
}
