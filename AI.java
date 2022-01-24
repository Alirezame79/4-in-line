package com.company;

public class AI {

    int[][] simulatedGameGround = new int[8][8];
    int[][] columnPoint = new int[8][2];


    public int drawSituations(){
        for (int column = 0; column < 8; column++) {
            setGameGround();
            for (int i = 7; i >= 0; i--) {
                if (simulatedGameGround[i][column] == 0) {
                    simulatedGameGround[i][column] = 1;
                    calculatePoint(column);
                    break;
                }
            }
        }

        return chooseColumn();
    }

    private int chooseColumn() {
        int index = -1;
        int userLeastPoint = 999;
        int computerMostPoint = -1;

        for (int i = 0; i < 8; i++){
            if (columnPoint[i][0] < userLeastPoint){
                userLeastPoint = columnPoint[i][0];
                computerMostPoint = columnPoint[i][1];
                index = i;
//                System.out.println(index + "least " + userLeastPoint + "most " + computerMostPoint);
            }else if (columnPoint[i][0] == userLeastPoint
                &&  columnPoint[i][1] > computerMostPoint){
                userLeastPoint = columnPoint[i][0];
                computerMostPoint = columnPoint[i][1];
                index = i;
//                System.out.println(index + "least " + userLeastPoint + "most " + computerMostPoint);
            }
        }
//        System.out.println("index is " + index);
        return index+1;
    }

    private void calculatePoint(int column) {
        columnPoint[column][0] = calUserPoint();
        columnPoint[column][1] = calComputerPoint();
    }

    private int calComputerPoint() {
        int computerPoint = 0;

        ///////////////////////////////// Row
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 5; j++){
                int localPoint = 0;

                if (simulatedGameGround[i][j] == 1){
                    localPoint ++;
//                    System.out.println("ground" + i + j + localPoint);
                }else if (simulatedGameGround[i][j] == 2) continue;

                if (simulatedGameGround[i][j+1] == 1){
                    localPoint ++;
//                    System.out.println("ground" + i + j + localPoint);
                }else if (simulatedGameGround[i][j+1] == 2) continue;

                if (simulatedGameGround[i][j+2] == 1){
                    localPoint ++;
//                    System.out.println("ground" + i + j + localPoint);
                }else if (simulatedGameGround[i][j+2] == 2) continue;

                if (simulatedGameGround[i][j+3] == 1){
                    localPoint ++;
//                    System.out.println("ground" + i + j + localPoint);
                }else if (simulatedGameGround[i][j+3] == 2) continue;

                computerPoint += localPoint;
            }
        }
//        System.out.println("Computer point row = " + computerPoint);

        //////////////////////////////// Column
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 8; j++){
                int localPoint = 0;

                for (int k = i; k < i+4; k++){
                    if (simulatedGameGround[k][j] == 1){
                        localPoint ++;
                    }else if (simulatedGameGround[k][j] == 2){
                        localPoint = 0;
                        continue;
                    }
                }

                computerPoint += localPoint;
            }
        }
//        System.out.println("Computer point column = " + computerPoint);

        //////////////////////////////// Diagonal
        for (int i = 0; i < 5; i++){                                // Downside
            for (int j = 0; j < 5; j++){
                int localPoint = 0;
                int k1 = i;         // double for at same time
                int k2 = j;
                for (int k = 0; k < 4; k++){
                    if (simulatedGameGround[k1][k2] == 1){
                        localPoint ++;
                    }else if (simulatedGameGround[k1][k2] == 2){
                        localPoint = 0;
                    }
                    k1 ++;
                    k2 ++;
                }
                computerPoint += localPoint;
            }
        }
//        System.out.println("Computer point diagonal upside = " + computerPoint);

        //////////////////////////////// Diagonal
        for (int i = 7; i > 2; i--){                                // Upside
            for (int j = 0; j < 5; j++){
                int localPoint = 0;
                int k1 = i;         // double for at same time
                int k2 = j;
                for (int k = 0; k < 4; k++){
                    if (simulatedGameGround[k1][k2] == 1){
                        localPoint ++;
                    }else if (simulatedGameGround[k1][k2] == 2){
                        localPoint = 0;
                    }
                    k1 --;
                    k2 ++;
                }
                computerPoint += localPoint;
            }
        }
//        System.out.println("Computer point diagonal downside = " + computerPoint);

        System.out.println("Computer point = " + computerPoint);
        return computerPoint;
    }

    private int calUserPoint(){
        int computerPoint = 0;

        ///////////////////////////////// Row
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 5; j++){
                int localPoint = 0;
                if (simulatedGameGround[i][j] == 2){
                    localPoint ++;
//                    System.out.println("ground" + i + j + localPoint);
                }else if (simulatedGameGround[i][j] == 1) continue;

                if (simulatedGameGround[i][j+1] == 2){
                    localPoint ++;
//                    System.out.println("ground" + i + j + localPoint);
                }else if (simulatedGameGround[i][j+1] == 1) continue;

                if (simulatedGameGround[i][j+2] == 2){
                    localPoint ++;
//                    System.out.println("ground" + i + j + localPoint);
                }else if (simulatedGameGround[i][j+2] == 1) continue;

                if (simulatedGameGround[i][j+3] == 2){
                    localPoint ++;
//                    System.out.println("ground" + i + j + localPoint);
                }else if (simulatedGameGround[i][j+3] == 1) continue;

                computerPoint += localPoint;
            }
        }
//        System.out.println("Computer point row = " + computerPoint);

        //////////////////////////////// Column
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 8; j++){
                int localPoint = 0;

                for (int k = i; k < i+4; k++){
                    if (simulatedGameGround[k][j] == 2){
                        localPoint ++;
                    }else if (simulatedGameGround[k][j] == 1){
                        localPoint = 0;
                        continue;
                    }
                }

                computerPoint += localPoint;
            }
        }
//        System.out.println("Computer point column = " + computerPoint);

        //////////////////////////////// Diagonal
        for (int i = 0; i < 5; i++){                                // Downside
            for (int j = 0; j < 5; j++){
                int localPoint = 0;
                int k1 = i;         // double for at same time
                int k2 = j;
                for (int k = 0; k < 4; k++){
                    if (simulatedGameGround[k1][k2] == 2){
                        localPoint ++;
                    }else if (simulatedGameGround[k1][k2] == 1){
                        localPoint = 0;
                    }
                    k1 ++;
                    k2 ++;
                }
                computerPoint += localPoint;
            }
        }
//        System.out.println("Computer point diagonal upside = " + computerPoint);

        //////////////////////////////// Diagonal
        for (int i = 7; i > 2; i--){                                // Upside
            for (int j = 0; j < 5; j++){
                int localPoint = 0;
                int k1 = i;         // double for at same time
                int k2 = j;
                for (int k = 0; k < 4; k++){
                    if (simulatedGameGround[k1][k2] == 2){
                        localPoint ++;
                    }else if (simulatedGameGround[k1][k2] == 1){
                        localPoint = 0;
                    }
                    k1 --;
                    k2 ++;
                }
                computerPoint += localPoint;
            }
        }
//        System.out.println("Computer point diagonal downside = " + computerPoint);

        System.out.println("User point = " + computerPoint);
        return computerPoint;
    }

    public void setGameGround(){
        int[][] x = GameGround.gameGround;
        for (int i = 0; i < 8; i++){
            System.arraycopy(x[i], 0, simulatedGameGround[i], 0, 8);
        }
    }

}
