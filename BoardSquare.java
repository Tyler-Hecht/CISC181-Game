/**
 * Description: the class for each square on the board
 * @author Tyler He
 * @version 1.0
 * Email : thecht@u
 * Class : CISC 181
 * Lab : CISC 181-0
 *
 */
public class BoardSquare {
    private boolean empty;
    private Piece piece;
    private String color;
    private boolean slimed;
    private int plySinceSlimed;
    private boolean bombed;

    //constructor
    public BoardSquare(String color) {
        this.color = color;
        this.empty = true;
        this.slimed = false;
    }

    //Getters and setters
    public Piece getPiece() {
        return piece;
    }
    public String getSquareColor() {
        return color;
    }
    public boolean isEmpty() {
        return empty;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
        this.empty = false;
    }


    /**This function removes the piece on the particular square its on
     * @return the piece that is on this square
     */
    public Piece removePiece() {
        Piece tmp = piece;
        this.piece = null;
        this.empty = true;
        return tmp;
    }

    /**
     * @return A string of the piece this is called on.
     * If the piece is null it returns -------
     * otherwise it returns the toString method call of the piece this was called on
     */
    @Override
    public String toString() {

        if (piece == null) {
            if (this.slimed) {
                return "$$$$$$$";
            } else {
                return "-------";
            }
        } else if (this.slimed) {
            return "$" + piece.toString() + "$";
        } else {
            return "-" + piece.toString() + "-";
        }
    }

    //Getter and setter
    public boolean isSlimed() {
        return slimed;
    }
    public void setSlimed(boolean slimed) {
        this.slimed = slimed;
        if (slimed) {
            plySinceSlimed = 0;
        }
    }

    /**
     * Updates the slimed square to make sure it disapears in
     * 10 ply moves
     */
    public void updatePlySinceSlimed() {
        if (slimed) {
            this.plySinceSlimed++;
        }
        if (this.plySinceSlimed >= 10) {
            this.plySinceSlimed = 0;
            this.slimed = false;
        }
    }

    //getter and setter
    public boolean isBombed(){return this.bombed;}
    public void setBombed(boolean bombed){this.bombed = bombed;}


}