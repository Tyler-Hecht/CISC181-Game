public abstract class Action {
    // THis is a comment
    protected GameS22 game;
    protected int rowFrom;
    protected int columnFrom;
    protected int rowTo;
    protected int columnTo;

    public Action(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        this.game = game;
        this.rowFrom = rowFrom;
        this.columnFrom = columnFrom;
        this.rowTo = rowTo;
        this.columnTo = columnTo;
    }

    public abstract void performAction();
}
