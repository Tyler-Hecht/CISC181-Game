public class ActionAttack extends Action {
    public ActionAttack(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        super(game, rowFrom, columnFrom, rowTo, columnTo);
    }

    @Override
    public void performAction() {
        BoardSquare fromSquare = this.game.getGameBoard().getSquares()[rowFrom][columnFrom];
        BoardSquare toSquare = this.game.getGameBoard().getSquares()[rowTo][columnTo];
        Piece piece = fromSquare.getPiece();
        Piece attackedPiece = toSquare.getPiece();
        fromSquare.getPiece().speak();
        toSquare.removePiece();
        //if the piece isn't evil minion, or if it is, isn't attacking its own piece
        if (!(piece instanceof PieceEvilMinion || !attackedPiece.getTeamColor().equals(piece.getTeamColor()))) {
            this.game.getOpponentTeam().removePieceFromTeam(attackedPiece);
            fromSquare.removePiece();
            toSquare.setPiece(piece);
        } else {
            this.game.getCurrentTeam().removePieceFromTeam(attackedPiece);
            Piece newPiece = piece.spawn();
            this.game.getCurrentTeam().addPieceToTeam(newPiece);
            toSquare.setPiece(newPiece);
        }

        this.game.changeTurn();
    }
}
