public class ActionSlime extends Action {

    //Constructor
    public ActionSlime(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        super(game, rowFrom, columnFrom, rowTo, columnTo);
    }

    @Override
    public void performAction() {
        BoardSquare fromSquare = this.game.getGameBoard().getSquares()[rowFrom][columnFrom];
        BoardSquare toSquare = this.game.getGameBoard().findRandomEmptyUnslimedSpace();
        toSquare.setSlimed(true);
        fromSquare.getPiece().speak();
        this.game.changeTurn();
    }
}