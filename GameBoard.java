/**
 *  Description: This is an abstract superclass of pieces of a game
 *  @author Tyler Hecht, Eli Brignac
 *  @version 1.0
 *  Email : thecht@udel.edu, ebrignac@udel.edu
 *  Class : CISC 181-080
 *  Lab : CISC 181-080
 *
 */
public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    //Constructor
    public GameBoard(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    //Getters and setters
    public int getNumRows() {
        return numRows;
    }
    public int getNumColumns() {
        return numColumns;
    }
    public BoardSquare[][] getSquares() {
        return squares;
    }

    /**
     * This method returns if the tile position inputed is within the board or not.
     * @param row The row postition of the tile
     * @param column The column position of the tile
     * @return boolean if the tile in the row column position is on the board
     */
    public boolean inBounds(int row, int column) {
        return row < numRows && column < numColumns && row >= 0 && column >= 0;
    }

    /**
     * This method creates an empty board with alternating color spaces
     */
    private void setUpEmptyBoard() {
        boolean white = true;
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numColumns; j++) {
                if(white) {
                    squares[i][j] = new BoardSquare("white");
                } else {
                    squares[i][j] = new BoardSquare("black");
                }
                white = !white;
            }
            white = !white;
        }
    }

    /**
     * This method chooses an empty board square at random
     * @return an empty board square that was chosen at random
     */
    public BoardSquare findRandomEmptySpace() {
        boolean found = false;
        BoardSquare square = null;
        while (!found) {
            int row = (int) (Math.random() * numRows);
            int column = (int) (Math.random() * numColumns);
            square = squares[row][column];
            found = square.isEmpty();
        }
        return square;
    }

    /**
     * This randomly finds a square that isn't slimed
     * @return a square that ins't slimed
     */
    public BoardSquare findRandomEmptyUnslimedSpace() {
        boolean found = false;
        BoardSquare square = null;
        while (!found) {
            int row = (int) (Math.random() * numRows);
            int column = (int) (Math.random() * numColumns);
            square = squares[row][column];
            found = square.isEmpty() && !(square.isSlimed());
        }
        return square;
    }

    /**
     * This randomly finds a square that isn't bombed
     * @return the square that is empty and unbombed
     */
    public BoardSquare findRandomEmptyUnbombedSpace() {
        boolean found = false;
        BoardSquare square = null;
        while (!found) {
            System.out.print("loop");
            int row = (int) (Math.random() * numRows);
            int column = (int) (Math.random() * numColumns);
            square = squares[row][column];
            found = square.isEmpty() && !(square.isBombed());
        }
        return square;
    }


    /**
     * @return A String of the game board
     */
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

    /**
     * Caluclates the distance between the two squares
     * @param fromRow the row the piece is on
     * @param fromColumn the column the piece is on
     * @param toRow the row the piece is going to
     * @param toColumn the column the piece is going to
     * @return The distance betweeen the square the piece is on and the
     * square the piece is going to
     */
    public double distance(int fromRow, int fromColumn, int toRow, int toColumn){
        double xsquared = Math.pow(fromRow - toRow, 2);
        double ysquared = Math.pow(fromColumn - toColumn, 2);
        return (Math.pow(xsquared + ysquared, .5));
    }


    /**
     * calculates the nearest corner of the board without a piece on it.
     * @param fromRow The row the piece is on
     * @param fromColumn the column the piece is on
     * @param toRow the row of the corner
     * @param toColumn the column of the corner
     * @return if the square inputed is the nearest corner or not
     */
    public boolean isNearestCorner(int fromRow, int fromColumn, int toRow, int toColumn){
        int[][] allCorners = {{0, 0}, {0, numColumns -1 }, {numRows - 1, 0}, {numRows - 1, numColumns - 1 }};

        //Finds the corner that is closest.
        double minDistance = distance(0,0,numRows,numColumns);
        for(int[] corner : allCorners) {
            double newDist = distance(fromRow, fromColumn, corner[0], corner[1]);
            if (minDistance > newDist && newDist != 0) {
                if (squares[corner[0]][corner[1]].getPiece() == null){
                    minDistance = newDist;
                }
            }
        }
        System.out.println(minDistance);
        //Checks if the toRow and toColumn is equal to the corner with the min distance.
        for(int[] corner : allCorners){
            System.out.println("Row, Corner" + corner[0] + ", " + corner[1]);
            if(corner[0] == toRow && corner[1] == toColumn){

                if(Math.abs(minDistance - distance(fromRow, fromColumn, corner[0], corner[1])) < .0001){

                    return true;
                }
            }
        }
        return false;

    }

}