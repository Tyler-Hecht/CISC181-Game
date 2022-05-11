public class BoardSquare {
    private boolean empty;
    private Piece piece;
    private String color;

    public BoardSquare(String color) {
        this.color = color;
        this.empty = true;
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
            return "-------";
        } else {
            return "-" + piece.toString() + "-";
        }
    }
}