public class ActionSlime extends Action {

    //Constructor
    public ActionSlime(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        super(game, rowFrom, columnFrom, rowTo, columnTo);
    }

    @Override
    public void performAction() {
        BoardSquare toSquare = this.game.getGameBoard().getSquares()[rowTo][columnTo];
        toSquare.setSlimed(true);
    }
}