/**
 *  Description: These are the rules of the game and checks if everything makes sense.
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */

import java.util.ArrayList;

public class Rules {
    /**
     * This checks if the action being called is valid
     * @param game The Game that is being played
     * @param rowFrom The row that the piece doing the action is on
     * @param columnFrom The column that the piece doing the action is on
     * @param rowTo The row the piece doing the action is doing the action on
     * @param columnTo The column the piece doing the action is doing the action on
     * @param actionType The type of action being done by this piece
     * @return whether or not the piece can execute this action
     */
    public static boolean checkValidAction(GameS22 game, int rowFrom, int columnFrom, int rowTo, int columnTo, char actionType) {
        Piece piece = game.getGameBoard().getSquares()[rowFrom][columnFrom].getPiece();
        if (actionType == 'Q') {
            return (piece instanceof PieceKingSlime) && game.getGameBoard().findRandomEmptyUnslimedSpace() != null;
        }
        //square is in bounds
        if (!(game.getGameBoard().inBounds(rowFrom, columnFrom) && game.getGameBoard().inBounds(rowTo, columnTo))) {
            return false;
        }
        //same square
        if (rowFrom == rowTo && columnFrom == columnTo) {
            return false;
        }
        BoardSquare fromSquare = game.getGameBoard().getSquares()[rowFrom][columnFrom];
        BoardSquare toSquare = game.getGameBoard().getSquares()[rowTo][columnTo];
        if (fromSquare.isEmpty()) {
            return false;
        }
        //from square piece is on current team
        if (!piece.getTeamColor().equals(game.getCurrentTeam().getTeamColor())) {
            return false;
        }
        //actual stuff
        if (actionType == 'M') {
            if (!(piece.validMovePath(rowFrom, columnFrom, rowTo, columnTo))) {
                return false;
            }
            if (!(piece instanceof PieceBlueSlime) && toSquare.isSlimed()) {
                return false;
            }
            return toSquare.isEmpty();
        } else if (actionType == 'S') {
            if (!(piece.validSpawnPath(rowFrom, columnFrom, rowTo, columnTo))) {
                return false;
            }
            if (piece.getSymbol() == 'H' || piece.getSymbol() == 'M' || piece.getSymbol() == 'E') {
                if(piece.getSymbol() == 'M'){
                    if(!(game.getGameBoard().isNearestCorner(rowFrom, columnFrom, rowTo, columnTo))){
                        return false;
                    }
                }
                return toSquare.isEmpty() && piece.canSpawn() && !(toSquare.isSlimed());
            } else {
                return false;
            }
        } else if (actionType == 'R') {
            if (!(piece.validRecruitPath(rowFrom, columnFrom, rowTo, columnTo))) {
                return false;
            }
            if (piece.getSymbol() == 'H' || piece.getSymbol() == 'M' || piece.getSymbol() == 'E' || piece.getSymbol() == 'S') {
                if (!(toSquare.isEmpty())) {
                    if (piece.getSymbol() == 'S' && !(toSquare.getPiece() instanceof PieceBlueSlime)) {
                        return false;
                    } else if (toSquare.isSlimed() && !((toSquare.getPiece()) instanceof PieceBlueSlime)) {
                        return false;
                    }
                    return !(toSquare.getPiece().getTeamColor().equals(piece.getTeamColor()));
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else if (actionType == 'A') {
            if (!(piece.validAttackPath(rowFrom, columnFrom, rowTo, columnTo))) {
                return false;
            }
            if (!(toSquare.isEmpty())) {
                if (piece.getSymbol() == 'B') {
                    return !(toSquare.getPiece().getTeamColor().equals(piece.getTeamColor())) && ((PieceBuzz) piece).canAttack();
                } else if (piece.getSymbol() == 'H' || piece.getSymbol() == 'S') {
                    return !(toSquare.getPiece().getTeamColor().equals(piece.getTeamColor()));
                } else if (piece.getSymbol() == 'E') {
                    if (!toSquare.getPiece().getTeamColor().equals(fromSquare.getPiece().getTeamColor())) {
                        return ((PieceEvilMinion) piece).canAttack();
                    } else {
                        return ((PieceEvilMinion) piece).canAttack() && toSquare.getPiece() instanceof PieceMinion;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public static void main(String[] arg){
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

        // create a game
        GameS22 game = new GameS22(6,6,teamA,teamB);

        // clear Piece off the board
        for(int row = 0; row < game.getGameBoard().getNumRows();row++){
            for (int col = 0; col < game.getGameBoard().getNumColumns(); col++){
                game.getGameBoard().getSquares()[row][col].removePiece();
            }
        }
        System.out.println(game);

        // load your pieces in specific locations of your choice
        game.getGameBoard().getSquares()[0][0].setPiece(piecesTeamA.get(0));
        game.getGameBoard().getSquares()[0][1].setPiece(piecesTeamA.get(1));
        game.getGameBoard().getSquares()[0][2].setPiece(piecesTeamA.get(2));
        game.getGameBoard().getSquares()[0][3].setPiece(piecesTeamA.get(3));
        game.getGameBoard().getSquares()[2][0].setPiece(piecesTeamB.get(0));
        game.getGameBoard().getSquares()[2][1].setPiece(piecesTeamB.get(1));
        game.getGameBoard().getSquares()[2][2].setPiece(piecesTeamB.get(2));
        game.getGameBoard().getSquares()[2][3].setPiece(piecesTeamB.get(3));

        System.out.println(game);

        // Test some moves that should be valid
        // Test some moves that are invalid

        // This should be a valid move
        System.out.println(Rules.checkValidAction(game,
                0,0,
                1,4,'M'));

        // To Square isn't empty - should not be a valid move
        System.out.println(Rules.checkValidAction(game,
                0,0,
                0,1,'M'));
        // This isn't current team's piece - should not be valid
        System.out.println(Rules.checkValidAction(game,
                2,0,
                0,5,'M'));


        // You can change the turn to test the other team pieces
        game.changeTurn();

        System.out.println(Rules.checkValidAction(game,
                2,0,
                0,5,'M'));


    }
}