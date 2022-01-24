package com.company;

import java.util.Scanner;

public class Main {

    public static String[][] demoGround = new String[8][8];

    public static String USER = "User";
    public static String COMPUTER = "Computer";
    public static int COMPUTER_WINS = 1;
    public static int USER_WINS = 2;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        GameGround gameGround = new GameGround();
        gameGround.makeGroundReady();

        while (true) {
            System.out.println("--------------------------");
            System.out.println("Welcome to 4-in-line game");
            System.out.println("--------------------------");
            System.out.println("Who start the game? ");
            System.out.println("-- 1. Me");
            System.out.println("-- 2. Computer");
            System.out.print("Who? (1/2) ");
            int starter = input.nextInt();

            if (starter == 1){
                ScoreBoard.whoBegin = USER;
                gameControl();
            }else if (starter == 2){
                ScoreBoard.whoBegin = COMPUTER;
                ScoreBoard.gameTurn++;
                gameControl();
            }
            break;
        }
    }

    public static void gameControl(){

        while (true) {
            System.out.println("GameTurn" + ScoreBoard.gameTurn);
            if (ScoreBoard.gameTurn % 2 == 0) {          // --> User turn
                System.out.println("User turn ->");
                ScoreBoard.gameTurn++;
                printDemoGround();
                userChoose();

                if (refereeCheck()) newRound();

            } else {                                     // --> Computer turn
                System.out.println("Computer turn ->");

                AI ai = new AI();
                if (!GameGround.performStep(ai.drawSituations(), COMPUTER)) continue;
                ScoreBoard.gameTurn++;

                if (refereeCheck()) newRound();
            }
        }
    }

    private static void newRound() {
        Scanner input = new Scanner(System.in);
        printDemoGround();

        while (true) {
            System.out.print("Do you want to continue playing? (y/n) ");
            String answer = input.next();
            if (answer.equals("y") || answer.equals("Y")){
                GameGround gameGround = new GameGround();
                gameGround.makeGroundReady();

                if (ScoreBoard.whoBegin.equals(USER)){
                    ScoreBoard.whoBegin = COMPUTER;
                    ScoreBoard.gameTurn = 1;
                }else if (ScoreBoard.whoBegin.equals(COMPUTER)){
                    ScoreBoard.whoBegin = USER;
                    ScoreBoard.gameTurn = 0;
                }
                break;
            }else if (answer.equals("n") || answer.equals("N")){
                System.out.println("Have good time ;)");
                System.exit(0);
            }
        }
    }

    private static boolean refereeCheck(){
        Referee referee = new Referee();
        int situation = referee.check();
        if (situation == USER_WINS){
            System.out.println("Referee Note = " + USER + " Wins!");
            ScoreBoard scoreBoard = new ScoreBoard();
            scoreBoard.userWins();
            System.out.println("**** Score Board ****");
            System.out.println("--> " + USER + " = " + ScoreBoard.userScore);
            System.out.println("--> " + COMPUTER + " = " + ScoreBoard.PCScore);
            return true;
        }else if (situation == COMPUTER_WINS){
            System.out.println("Referee Note = " + COMPUTER + " Wins!");
            ScoreBoard scoreBoard = new ScoreBoard();
            scoreBoard.PCWins();
            System.out.println("**** Score Board ****");
            System.out.println("--> " + USER + " = " + ScoreBoard.userScore);
            System.out.println("--> " + COMPUTER + " = " + ScoreBoard.PCScore);
            return true;
        }
        return false;
    }

    private static void userChoose() {
        System.out.print("Choose your column (1/8): ");

        Scanner input = new Scanner(System.in);
        int userStep = input.nextInt();
        if (userStep > 0 && userStep < 9) {
            if (!GameGround.performStep(userStep, USER)){
                System.out.println("This column is Full!");
                userChoose();
            }
        }else {
            System.out.println("This column is NOT valid!");
            userChoose();
        }
    }

    public static void updateDemoGround(){
        GameGround gameGround = new GameGround();
        demoGround = gameGround.getGameGround();
    }

    public static void printDemoGround() {
        updateDemoGround();

        System.out.print(" - - - - - - - - \n");
        for (int i = 0; i < 8; i++){
            System.out.print("|");
            for (int j = 0; j < 8; j++){
                System.out.print(demoGround[i][j]);
                if (j != 7) System.out.print(" ");
            }
            System.out.print("|\n");
        }
        System.out.print(" - - - - - - - - \n");
        System.out.print(" 1 2 3 4 5 6 7 8 \n\n");
    }
}
