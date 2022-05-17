/**
 *  Description: This is an attack Action it extends the abstract
 *  action class.
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */
public class ActionAttack extends Action {
    //Constructor
    public ActionAttack(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        super(game, rowFrom, columnFrom, rowTo, columnTo);
    }

    /**
     * This method performs the attack action
     * The piece on the from square attacks the piece on the to square
     */
    @Override
    public void performAction() {
        BoardSquare fromSquare = this.game.getGameBoard().getSquares()[rowFrom][columnFrom];
        BoardSquare toSquare = this.game.getGameBoard().getSquares()[rowTo][columnTo];
        Piece piece = fromSquare.getPiece();
        Piece attackedPiece = toSquare.getPiece();
        fromSquare.getPiece().speak();
        toSquare.removePiece();
        if (attackedPiece instanceof PieceBuzz) {
            ((PieceBuzz) attackedPiece).updateNumTimesBeenAttacked();
        }
        //if the piece isn't evil minion, or if it is, isn't attacking its own piece
        if (!(piece instanceof PieceEvilMinion) || !(attackedPiece.getTeamColor().equals(piece.getTeamColor()))) {
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