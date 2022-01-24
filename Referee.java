package com.company;

public class Referee {

    public int[][] gameGround;

    public Referee(){
        this.gameGround = GameGround.gameGround;
    }

    public int check(){
        int rowSituation = checkRow();
        int columnSituation = checkColumn();
        int diagonalSituation = checkDiagonal();
        if (rowSituation != 0){
            return rowSituation;
        }else if (columnSituation != 0){
            return columnSituation;
        }else if (diagonalSituation != 0){
            return diagonalSituation;
        }else {
            return 0;
        }
    }

    private int checkRow(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 5; j++){
                if (gameGround[i][j] == 1
                && gameGround[i][j+1] == 1
                && gameGround[i][j+2] == 1
                && gameGround[i][j+3] == 1){
                    return 1;
                }
                if (gameGround[i][j] == 2
                        && gameGround[i][j+1] == 2
                        && gameGround[i][j+2] == 2
                        && gameGround[i][j+3] == 2){
                    return 2;
                }
            }
        }
        return 0;
    }

    private int checkColumn(){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 8; j++){
                if (gameGround[i][j] == 1
                        && gameGround[i+1][j] == 1
                        && gameGround[i+2][j] == 1
                        && gameGround[i+3][j] == 1){
                    return 1;
                }
                if (gameGround[i][j] == 2
                        && gameGround[i+1][j] == 2
                        && gameGround[i+2][j] == 2
                        && gameGround[i+3][j] == 2){
                    return 2;
                }
            }
        }
        return 0;
    }

    private int checkDiagonal(){
        for (int i = 0; i < 5; i++){                        // Downside
            for (int j = 0; j < 5; j++){
                if (gameGround[i][j] == 1
                        && gameGround[i+1][j+1] == 1
                        && gameGround[i+2][j+2] == 1
                        && gameGround[i+3][j+3] == 1){
                    return 1;
                }
                if (gameGround[i][j] == 2
                        && gameGround[i+1][j+1] == 2
                        && gameGround[i+2][j+2] == 2
                        && gameGround[i+3][j+3] == 2){
                    return 2;
                }
            }
        }

        for (int i = 7; i > 2; i--){                        // Upside
            for (int j = 0; j < 5; j++){
                if (gameGround[i][j] == 1
                        && gameGround[i-1][j+1] == 1
                        && gameGround[i-2][j+2] == 1
                        && gameGround[i-3][j+3] == 1){
                    return 1;
                }
                if (gameGround[i][j] == 2
                        && gameGround[i-1][j+1] == 2
                        && gameGround[i-2][j+2] == 2
                        && gameGround[i-3][j+3] == 2){
                    return 2;
                }
            }
        }

        return 0;
    }
}
