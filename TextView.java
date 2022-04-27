import java.util.Scanner;

public class TextView {
    private int rowFrom;
    private int columnFrom;
    private int rowTo;
    private int columnTo;
    private char actionType;

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

    public void getNextPlayersAction(GameS22 game) {
        Scanner scnr = new Scanner(System.in);
        this.actionType = getUsersNextActionType(scnr);
        System.out.println("from square row?");
        scnr = new Scanner(System.in);
        this.rowFrom = getValidInt(0, game.getGameBoard().getNumRows()-1, scnr);
        System.out.println("from square column?");
        scnr = new Scanner(System.in);
        this.columnFrom = getValidInt(0, game.getGameBoard().getNumColumns()-1, scnr);
        System.out.println("to square row?");
        scnr = new Scanner(System.in);
        this.rowTo = getValidInt(0, game.getGameBoard().getNumRows()-1, scnr);
        System.out.println("to square column?");
        scnr = new Scanner(System.in);
        this.columnTo = getValidInt(0, game.getGameBoard().getNumColumns()-1, scnr);
    }

    public void updateView(Game game) {
        System.out.println(game.toString());
    }

    public void printEndOfGameMessage(Game game) {
        System.out.println("Game over. " + game.getWinner() + " team won.");
    }
}
