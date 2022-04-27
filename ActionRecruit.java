public class ActionRecruit extends Action {
    public ActionRecruit(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        super(game, rowFrom, columnFrom, rowTo, columnTo);
    }

    @Override
    public void performAction() {
        BoardSquare fromSquare = this.game.getGameBoard().getSquares()[rowFrom][columnFrom];
        BoardSquare toSquare = this.game.getGameBoard().getSquares()[rowTo][columnTo];
        Piece piece = fromSquare.getPiece();
        Piece recruitedPiece = toSquare.getPiece();
        fromSquare.getPiece().speak();
        this.game.getOpponentTeam().removePieceFromTeam(recruitedPiece);
        this.game.getCurrentTeam().addPieceToTeam(recruitedPiece);
        this.game.changeTurn();
    }
}
