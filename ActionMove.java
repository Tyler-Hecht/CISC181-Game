/**
 *  Description: This is the move action that moves a piece it is an extention
 *  of the abstract action class
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */
public class ActionMove extends Action {

    //Constructor
    public ActionMove(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        super(game, rowFrom, columnFrom, rowTo, columnTo);
    }

    /**
     * This method perfomes the Move action.
     * It moves the piece on a square to another square
     */
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