public class ActionSpawn extends Action {
    public ActionSpawn(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        super(game, rowFrom, columnFrom, rowTo, columnTo);
    }

    @Override
    public void performAction() {
        BoardSquare fromSquare = this.game.getGameBoard().getSquares()[rowFrom][columnFrom];
        BoardSquare toSquare = this.game.getGameBoard().getSquares()[rowTo][columnTo];
        Piece piece = fromSquare.getPiece();
        piece.speak();
        Piece spawnedPiece = piece.spawn();
        this.game.getCurrentTeam().addPieceToTeam(spawnedPiece);
        toSquare.setPiece(spawnedPiece);
        this.game.changeTurn();
    }
}
