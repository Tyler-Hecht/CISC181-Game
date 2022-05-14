/**
 *  Description: This is the Controller class that allows you to
 *  interact with the game and play the game
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */

import java.util.ArrayList;

public class Controller {
    private GameS22 game;
    private TextView textView;

    /**
     * This method sets up a game by giving both teams pieces that are randomly set up on the board.
     * @return A Game to be played
     */
    public GameS22 setUpGameModel(){
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",2,1,
                true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",3,
                9,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",1,
                1,4,false, true));
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);
        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",3,
                9,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",2,1,
                true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",1,
                1,4,false, true));
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);
        // Create an instance of the game
        return new GameS22(8, 8,teamA, teamB);
    }

    //Constructor
    public Controller() {
        this.game = this.setUpGameModel();
        this.textView = new TextView();
        this.textView.updateView(this.game);
    }

    /**
     * This method causes an action to occur.
     * @param rowFrom This is the row of the piece that will carry out the action
     * @param columnFrom This is the column of the piece that will carry out the action
     * @param rowTo This is the row the action will take place on
     * @param columnTo This is the column the action will take place on
     * @param actionType This is the type of action that will take place
     */
    public void carryOutAction(int rowFrom, int columnFrom, int rowTo, int columnTo, char actionType) {
        Action action;
        if (actionType == 'M') {
            action = new ActionMove(this.game, rowFrom, columnFrom, rowTo, columnTo);
        } else if (actionType == 'S') {
            action = new ActionSpawn(this.game, rowFrom, columnFrom, rowTo, columnTo);
        } else if (actionType == 'R') {
            action = new ActionRecruit(this.game, rowFrom, columnFrom, rowTo, columnTo);
        } else if (actionType == 'A') {
            action = new ActionAttack(this.game, rowFrom, columnFrom, rowTo, columnTo);
        } else if (actionType == 'Q') {
            action = new ActionSlime(this.game, rowFrom, columnFrom, rowTo, columnTo);
        } else {
            return;
        }
        action.performAction();
        for (BoardSquare[] squares : game.getGameBoard().getSquares()) {
            for (BoardSquare square : squares) {
                square.updatePlySinceSlimed();
            }
        }
    }

    /**
     * This method runs and plays the game
     * Have fun playing!
     */
    public void playGame() {
        boolean ended = false;
        while (!ended) {
            boolean valid = false;
            while (!valid) {
                this.textView.getNextPlayersAction(this.game);
                valid = Rules.checkValidAction(this.game, this.textView.getRowFrom(), this.textView.getColumnFrom(), this.textView.getRowTo(), this.textView.getColumnTo(), this.textView.getActionType());
            }
            this.carryOutAction(this.textView.getRowFrom(), this.textView.getColumnFrom(), this.textView.getRowTo(), this.textView.getColumnTo(), this.textView.getActionType());
            System.out.println(game.toString());
            ended = game.isGameEnded();
        }
        this.textView.printEndOfGameMessage(game);
    }

    //Main method
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.playGame();
    }

}