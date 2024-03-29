package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner repeatGame = new Scanner(System.in);
        String thisGame;

        do {
    String[][] tictactoe = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    Scanner user1 = new Scanner(System.in);
    Scanner user2 = new Scanner(System.in);
    Scanner input = new Scanner(System.in);

    System.out.println("Hello player 1, please choose if you want to play x or 0:");
    String UserOne = input.nextLine();
    String UserTwo = "0x";
    if (UserOne.equals("x")) {
        System.out.println("You chose 'x', player 2 will be playing '0' ! ");
        UserTwo = "0";
        System.out.println("------------------------------------");

    }
    if (UserOne.equals("0")) {
        System.out.println("You chose '0', player 2 will be playing 'x' ! ");
        UserTwo = "x";
        System.out.println("------------------------------------");

    }
    if (!UserOne.equals("0") && !UserOne.equals("x")) {
        System.out.println("Can't choose anything but x or 0, you will go as 0 ");

        System.out.println(" player 2 will be playing 'x' !");
        UserOne = "0";
        UserTwo = "x";
        System.out.println("------------------------------------");

    }


    boolean Repeat = true;
    do {

        UserOneUpdateMatrix(tictactoe, user1, UserOne);

        System.out.println("------------------");
        printMatrix(tictactoe);
        System.out.println("------------------");

        if (!checkMatrix(tictactoe)) {
            printMatrix(tictactoe);
            System.out.println("------------------");
            break;
        }
        UserTwoUpdateMatrix(tictactoe, user2, UserTwo);

        System.out.println("------------------");
        printMatrix(tictactoe);
        System.out.println("------------------");

        if (!checkMatrix(tictactoe)) {
            printMatrix(tictactoe);
            System.out.println("------------------");
            break;
        }
    } while (Repeat); // change this to a separate function that does the loop until its false.

    System.out.println("The game is OVER. Would you like to play again? (n/y)");
     thisGame = repeatGame.nextLine();
if (!thisGame.equals("y") && !thisGame.equals("n")) {
    do {
    System.out.println("Wrong input. please select letter n or y");
        thisGame = repeatGame.nextLine();
    } while (!thisGame.equals("y") && !thisGame.equals("n"));
}
if (thisGame.equals("y")) {
    System.out.println("------------------------------------");
    System.out.println("STARTING NEW GAME");
}

} while (thisGame.equals("y"));



// HAVE TO MAKE THE GAME STOP AFTER IT FILLS THE MATRIX.                 *DONE
// how to make the game repeat itself after it finishes                   *DONE
        // how to make the array element scan more simplistic and automatized
        // to add player names and game score counting system
        // might have to make an if statement for repeatGame,thisGame as if it is true or not, therefore creating a separate function.
        // make a reminder that reminds us which symbol we are playing, x or 0   *DONE
        // make another error message if player goes out of array baundries     *DONE
        // make binded keys for each coordinate, like 1 is [0,0] and so on.
        // add to the database and create player names.
    }

    private static void UserOneUpdateMatrix(String[][] matrix, Scanner user1, String UserOne) {
        for (int i = 0; i< 1; i++) {
            System.out.println("Player one, you are playing "+ UserOne);
            System.out.println("player One, please choose the array coordinate:");
            int array = user1.nextInt();
            if (array <= matrix.length) {
                for (int j = 0; j < 1; j++) {
            System.out.println("player One, please choose the column coordinate:");
            int column = user1.nextInt();

            if (column <= matrix[array].length) {

                if (!matrix[array][column].equals(" ")) {
                    i--;
                    System.out.println("field already TAKEN. have to choose again...");
                } else {
                    matrix[array][column] = UserOne;
                }
            }
            else {
                j--;
                System.out.println("out of column borders, try again...");
            }
                }
        }
            else {
                i--;
                System.out.println("out of array borders, try again...");
            }
        }
    }
// to make coming back from columns and arrays back to the same thing, not everything from new, probably have to
    // do separate for loops for both.
    private static void UserTwoUpdateMatrix(String[][] matrix, Scanner user2, String UserTwo) {
        for (int i = 0; i< 1; i++) {
            System.out.println("Player two, you are playing "+ UserTwo);
            System.out.println("please choose the array coordinate:");
            int array = user2.nextInt();
            if (array <= matrix.length) {
                for (int j = 0; j < 1; j++) {
                    System.out.println("please choose the column coordinate:");
                    int column = user2.nextInt();
                    if (column <= matrix[array].length) {
                        if (!matrix[array][column].equals(" ")) {
                            i--;
                            System.out.println("field already TAKEN. have to choose again...");
                        } else {
                            matrix[array][column] = UserTwo;
                        }
                    }
                    else {
                        j--;
                        System.out.println("out of column borders, try again...");
                    }
                    }
                }
            else {
                i--;
                System.out.println("out of array borders, try again...");
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {

            String line = String.join("   ", matrix[i]);
            System.out.println(line);
        }
    }

  /*  private static boolean MatrixBaundries(String[][] matrix) {


    } */
    private static boolean checkMatrix(String[][] matrix) {

        if (matrix[0][0].equals("x") && matrix[0][1].equals("x") && matrix[0][2].equals("x") ) {
            System.out.println("three x symbols in a row, you won");
            return false;

        }
        if (matrix[0][0].equals("0") && matrix[0][1].equals("0") && matrix[0][2].equals("0") ) {
            System.out.println("three 0 symbols in a row, you won");
            return false;

        }
        if (matrix[1][0].equals("x") && matrix[1][1].equals("x") && matrix[1][2].equals("x") ) {
            System.out.println("three x symbols in a row, you won");
            return false;


        }
        if (matrix[1][0].equals("0") && matrix[1][1].equals("0") && matrix[1][2].equals("0") ) {
            System.out.println("three 0 symbols in a row, you won");
            return false;

        }
        if (matrix[2][0].equals("x") && matrix[2][1].equals("x") && matrix[2][2].equals("x") ) {
            System.out.println("three x symbols in a row, you won");
            return false;

        }
        if (matrix[2][0].equals("0") && matrix[2][1].equals("0") && matrix[2][2].equals("0") ) {
            System.out.println("three 0 symbols in a row, you won");
            return false;

        }

        if (matrix[0][0].equals("x") && matrix[1][0].equals("x") && matrix[2][0].equals("x") ) {
            System.out.println("three x symbols in a row, you won");
            return false;

        }
        if (matrix[0][0].equals("0") && matrix[1][0].equals("0") && matrix[2][0].equals("0") ) {
            System.out.println("three 0 symbols in a row, you won");
            return false;

        }
        if (matrix[0][1].equals("x") && matrix[1][1].equals("x") && matrix[2][1].equals("x") ) {
            System.out.println("three x symbols in a row, you won");
            return false;

        }
        if (matrix[0][1].equals("0") && matrix[1][1].equals("0") && matrix[2][1].equals("0") ) {
            System.out.println("three 0 symbols in a row, you won");
            return false;

        }
        if (matrix[0][2].equals("x") && matrix[1][2].equals("x") && matrix[2][2].equals("x") ) {
            System.out.println("three x symbols in a row, you won");
            return false;

        }
        if (matrix[0][2].equals("0") && matrix[1][2].equals("0") && matrix[2][2].equals("0") ) {
            System.out.println("three 0 symbols in a row, you won");
            return false;

        }
        if (matrix[0][0].equals("x") && matrix[1][1].equals("x") && matrix[2][2].equals("x") ) {
            System.out.println("three x symbols in a row, you won");
            return false;


        }
        if (matrix[0][0].equals("0") && matrix[1][1].equals("0") && matrix[2][2].equals("0") ) {
            System.out.println("three 0 symbols in a row, you won");
            return false;


        }
        if (matrix[2][0].equals("x") && matrix[1][1].equals("x") && matrix[0][2].equals("x") ) {
            System.out.println("three x symbols in a row, you won");
            return false;

        }
        if (matrix[2][0].equals("0") && matrix[1][1].equals("0") && matrix[0][2].equals("0") ) {
            System.out.println("three 0 symbols in a row, you won");
            return false;

        }
        int sum = 0;
           for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!matrix[i][j].equals(" ")) {
                sum = sum+1;

                }

}
            }
        if (sum == 9) {
            System.out.println("Board is full, no winners here. game over");
            return false;
        }
        // use different method for this
       // System.out.println("Board is full, no winners here. game over");
       // return false;
        return true;
    }
}