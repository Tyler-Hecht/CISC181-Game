/**
 *  Description: This provides a text base interface for the player
 *  to play the game.
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */

import java.util.Scanner;

public class TextView {
    private int rowFrom;
    private int columnFrom;
    private int rowTo;
    private int columnTo;
    private char actionType;

    //Getters
    public int getRowFrom() {
        return rowFrom;
    }
    public int getColumnFrom() {
        return columnFrom;
    }
    public int getRowTo() {
        return rowTo;
    }
    public int getColumnTo() {
        return columnTo;
    }
    public char getActionType() {
        return actionType;
    }

    /**
     * This method returns if the user an int between the boundaries they specify
     * @param min This is an integer that represents the lower bound of the interval that we want the user to input between
     * @param max This is a second integer that represents the upper bound of the interval that we want the user to input between
     * @param scnr This is a scanner that will get the users input
     * @return
     * If the user inputs a number between the given bounds then this function returns that number
     */
    public static int getValidInt(int min, int max, Scanner scnr) {
        Boolean valid = false;
        int input = 0;
        while (!valid) {
            System.out.println("Enter an integer between " + min + " and " + max);
            if (scnr.hasNextInt()) {
                input = scnr.nextInt();
                if (input >= min && input <= max) {
                    valid = true;
                }
            } else {
                scnr = new Scanner(System.in);
            }
        }
        return input;
    }

    /**
     * This method gets teh users Action Type
     * @param scnr this is a Scanner type that will take in the users inputs
     *
     * @return
     *   this will return the character A,M,R, or S, depends on what the user last inputed
     *   (if they inputed a M then it returns M)
     */
    public static char getUsersNextActionType(Scanner scnr) {
        Boolean valid = false;
        char input = 'A';
        while (!valid) {
            System.out.println("Enter one of the following: A, M, R, S");
            input = scnr.next().toUpperCase().charAt(0);
            if (input == 'A' || input == 'M' || input == 'R' || input == 'S') {
                valid = true;
            } else {
                scnr = new Scanner(System.in);
            }
        }
        return input;
    }

    /**
     * This method scans for the players next action
     * @param game The game that is being played
     */
    public void getNextPlayersAction(GameS22 game) {
        Scanner scnr = new Scanner(System.in);
        this.actionType = getUsersNextActionType(scnr);
        System.out.println("Input the from square row.");
        scnr = new Scanner(System.in);
        //The minus 1 for the num of rows & columns is because in java counting starts at 0
        this.rowFrom = getValidInt(0, game.getGameBoard().getNumRows()-1, scnr);
        System.out.println("Input the from square column");
        scnr = new Scanner(System.in);
        this.columnFrom = getValidInt(0, game.getGameBoard().getNumColumns()-1, scnr);
        System.out.println("Input the to square row");
        scnr = new Scanner(System.in);
        this.rowTo = getValidInt(0, game.getGameBoard().getNumRows()-1, scnr);
        System.out.println("Input the to square column");
        scnr = new Scanner(System.in);
        this.columnTo = getValidInt(0, game.getGameBoard().getNumColumns()-1, scnr);
    }

    /**
     * This method prints out the game as a string
     * @param game The game that is being played
     */
    public void updateView(Game game) {
        System.out.println(game.toString());
    }

    /**
     * This method prints that the game is over and whoever won the game.
     * @param game The game that is beign played
     */
    public void printEndOfGameMessage(Game game) {
        System.out.println("Game over. " + game.getWinner() + " team won.");
    }
}