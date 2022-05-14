public class BoardSquare {
    private boolean empty;
    private Piece piece;
    private String color;
    private boolean slimed;
    private int plySinceSlimed;

    public BoardSquare(String color) {
        this.color = color;
        this.empty = true;
        this.slimed = false;
    }

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

    public Piece removePiece() {
        Piece tmp = piece;
        this.piece = null;
        this.empty = true;
        return tmp;
    }

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

    public boolean isSlimed() {
        return slimed;
    }
    public void setSlimed(boolean slimed) {
        this.slimed = slimed;
        if (slimed) {
            plySinceSlimed = 0;
        }
    }
    public void updatePlySinceSlimed() {
        if (slimed) {
            this.plySinceSlimed++;
        }
        if (this.plySinceSlimed >= 10) {
            this.plySinceSlimed = 0;
            this.slimed = false;
        }
    }
}