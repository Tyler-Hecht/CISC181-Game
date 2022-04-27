public class ActionMove extends Action {
    public ActionMove(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        super(game, rowFrom, columnFrom, rowTo, columnTo);
    }

    @Override
    public void performAction() {
        BoardSquare fromSquare = this.game.getGameBoard().getSquares()[rowFrom][columnFrom];
        BoardSquare toSquare = this.game.getGameBoard().getSquares()[rowTo][columnTo];
        Piece piece = fromSquare.getPiece();
        piece.speak();
        fromSquare.removePiece();
        toSquare.setPiece(piece);
        this.game.changeTurn();
    }
}
