public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    public GameBoard(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    public int getNumRows() {
        return numRows;
    }
    public int getNumColumns() {
        return numColumns;
    }
    public BoardSquare[][] getSquares() {
        return squares;
    }

    public boolean inBounds(int row, int column) {
        return row < numRows && column < numColumns && row >= 0 && column >= 0;
    }

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

    public BoardSquare findRandomEmptySpace() {
        boolean found = false;
        BoardSquare square = null;
        while (!found) {
            int row = (int) (Math.random() * numRows);
            int column = (int) (Math.random() * numRows);
            square = squares[row][column];
            found = square.isEmpty();
        }
        return square;
    }

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

}
