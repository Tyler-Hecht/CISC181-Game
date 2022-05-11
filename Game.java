/**
 *  Description: This is an abstract superclass of pieces of a game
 *  @author Tyler Hecht, Eli Brignac
 *  @version 1.0
 *  Email : thecht@udel.edu, ebrignac@udel.edu
 *  Class : CISC 181-080
 *  Lab : CISC 181-080
 *
 */

import java.util.Collections;

public abstract class Game {
    protected GameBoard board;
    protected Team team1;
    protected Team team2;
    protected String turn;

    /**
     * This method initializes a game board.
     * @param numRows the amount of rows you want the game board to have
     * @param numColumns the amount of columns you want the game board to have
     */
    private void initializeGameBoard(int numRows, int numColumns) {
        this.board = new GameBoard(numRows, numColumns);
        for (Piece piece : team1.getTeamPieces()) {
            board.findRandomEmptySpace().setPiece(piece);
        }
        for (Piece piece : team2.getTeamPieces()) {
            board.findRandomEmptySpace().setPiece(piece);
        }
    }
    //Constructor
    public Game(int numRows, int numColumns, Team team1, Team team2) {
        this.turn = team1.getTeamColor();
        this.team1 = team1;
        this.team2 = team2;
        initializeGameBoard(numRows, numColumns);
    }

    //Getters
    public GameBoard getGameBoard() {
        return board;
    }

    public Team getCurrentTeam() {
        if (team1.getTeamColor() == turn) {
            return team1;
        } else {
            return team2;
        }
    }

    public Team getOpponentTeam() {
        if (team1.getTeamColor() == turn) {
            return team2;
        } else {
            return team1;
        }
    }

    public boolean isTurn(Team team) {
        return team.getTeamColor() == turn;
    }

    public BoardSquare[][] getBoardSquares() {
        return board.getSquares();
    }

    /**
     * This function changes the turn of the players.
     */
    public void changeTurn() {
        if (turn == team1.getTeamColor()) {
            this.turn = team2.getTeamColor();
        } else {
            this.turn = team1.getTeamColor();
        }
    }

    /**
     * @return A string of the game board
     */
    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();

    }

    /**
     * @return checks if the team is a winner or not
     */
    abstract boolean isAWinner();

    /**this is a getter for the Winning Team
     * @return
     */
    abstract Team getWinner();

    /**
     * @return This returns if the game has ended
     */
    abstract boolean isGameEnded();

}