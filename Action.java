/**
 *  Description: This is a class called Action that is an abstract class for the
 *  actions that can be done by the player.
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 */

public abstract class Action {
    protected GameS22 game;
    protected int rowFrom;
    protected int columnFrom;
    protected int rowTo;
    protected int columnTo;

    //Constructor
    public Action(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo) {
        this.game = game;
        this.rowFrom = rowFrom;
        this.columnFrom = columnFrom;
        this.rowTo = rowTo;
        this.columnTo = columnTo;
    }

    /**
     * Abstract method that performs an action
     */
    public abstract void performAction();
}