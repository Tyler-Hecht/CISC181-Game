/**
 *  Description:
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */
public class ActionSlime extends Action {

    //Constructor
    public ActionSlime(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        super(game, rowFrom, columnFrom, rowTo, columnTo);
    }

    /**
     * This slimes the square making only slimes allowed to go on it
     */
    @Override
    public void performAction() {
        BoardSquare fromSquare = this.game.getGameBoard().getSquares()[rowFrom][columnFrom];
        BoardSquare toSquare = this.game.getGameBoard().findRandomEmptyUnslimedSpace();
        toSquare.setSlimed(true);
        fromSquare.getPiece().speak();
        this.game.changeTurn();
    }
}