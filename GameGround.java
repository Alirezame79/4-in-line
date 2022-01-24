package com.company;

public class GameGround {

    static int[][] gameGround = new int[8][8];

    //  O --> computer  ---> 1
    //  X --> user      ---> 2
    //    --> empty     ---> 0

    public void makeGroundReady(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                gameGround[i][j] = 0;
            }
        }
    }

    public static boolean performStep(int column, String stepMan){
        for (int i = 7; i >= 0; i--){
            if (gameGround[i][column-1] == 0){
                if (stepMan.equals("User")) gameGround[i][column-1] = 2;
                if (stepMan.equals("Computer")) gameGround[i][column-1] = 1;
//                System.out.println("print " + (column) + i + stepMan);
//                printGameGround();
                System.out.println(stepMan + " Place on " + column);
                return true;
            }
        }
        return false;
    }

    public static void printGameGround() {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                System.out.print(gameGround[i][j]);
            }
            System.out.print("\n");
        }
    }

    public String[][] getGameGround(){
        String[][] blankGround = new String[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (gameGround[i][j] == 0){
                    blankGround[i][j] = " ";
                }else if (gameGround[i][j] == 1){
                    blankGround[i][j] = "O";
                }else if (gameGround[i][j] == 2){
                    blankGround[i][j] = "X";
                }
            }
        }
        return blankGround;
    }

    public void setGameGround(String[][] gameGround){
        int[][] exampleMatrix = new int[8][8];

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (gameGround[i][j].equals(" ")){
                    exampleMatrix[i][j] = 0;
                }else if (gameGround[i][j].equals("O")){
                    exampleMatrix[i][j] = 1;
                }else if (gameGround[i][j].equals("X")){
                    exampleMatrix[i][j] = 2;
                }
            }
        }
        this.gameGround = exampleMatrix;
    }
}
