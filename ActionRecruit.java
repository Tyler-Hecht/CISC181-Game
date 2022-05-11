/**
 *  Description: This is a Recruiting action that is an
 *  extension of the action class
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */
public class ActionRecruit extends Action {
    //Constructor
    public ActionRecruit(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        super(game, rowFrom, columnFrom, rowTo, columnTo);
    }

    /**
     * This method performs the recruit action.
     * The piece on the from square recruits the piece on the to square
     */
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