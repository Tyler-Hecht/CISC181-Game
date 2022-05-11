/**
 *  Description: This is the Spawn action it spawns a new piece it is an extension
 *  of the abstract action class.
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */
public class ActionSpawn extends Action {

    //Constructor
    public ActionSpawn(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        super(game, rowFrom, columnFrom, rowTo, columnTo);
    }

    /**
     * This method performs the Spawn action.
     * It spawns a new version of the piece on the from square onto the to square
     */
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