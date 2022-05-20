/**
 *  Description: This is the team class which is a list of the pieces of the teams
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class Team {
    private String teamColor;
    private ArrayList<Piece> pieces;

    //Constructor
    public Team(String teamColor, ArrayList<Piece> pieces) {
        this.teamColor = teamColor;
        this.pieces = pieces;
    }

    //Setter
    public String getTeamColor() {
        return teamColor;
    }
    public ArrayList<Piece> getTeamPieces() {
        return pieces;
    }

    /**
     * This method removes a piece from the team it is called on
     * @param piece the piece you want to be removed
     */
    public void removePieceFromTeam(Piece piece) {
        pieces.remove(piece);
    }

    /**
     * This method adds a piece to your team
     * @param piece The piece you want to be added to the team
     */
    public void addPieceToTeam(Piece piece) {
        piece.setTeamColor(teamColor);
        pieces.add(piece);
    }

    /**
     * @return a String of your team color followed by a string of all
     * the strings of all the pieces on your team.
     */
    public String toString() {
        Collections.sort(pieces);
        String pieceStrings = "";
        for(Piece piece : pieces) {
            pieceStrings += piece.toString() + "   ";
        }
        return "Team " + teamColor + " pieces:\n" + pieceStrings;
    }

    /**
     * checks if the team has the king slime piece or not.
     * @return if the team has the the king slime piece on it or not
     */
    public boolean hasKingSlime() {
        boolean found = false;
        for (Piece piece : this.pieces) {
            if (piece instanceof PieceKingSlime) {
                found = true;
                break;
            }
        }
        return found;
    }

}