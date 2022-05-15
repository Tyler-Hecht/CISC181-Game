import java.util.ArrayList;
import java.util.Collections;

public class Team {
    private String teamColor;
    private ArrayList<Piece> pieces;

    public Team(String teamColor, ArrayList<Piece> pieces) {
        this.teamColor = teamColor;
        this.pieces = pieces;
    }

    public String getTeamColor() {
        return teamColor;
    }
    public ArrayList<Piece> getTeamPieces() {
        return pieces;
    }

    public void removePieceFromTeam(Piece piece) {
        pieces.remove(piece);
    }

    public void addPieceToTeam(Piece piece) {
        piece.setTeamColor(teamColor);
        pieces.add(piece);
    }

    public String toString() {
        Collections.sort(pieces);
        String pieceStrings = "";
        for(Piece piece : pieces) {
            pieceStrings += piece.toString() + "   ";
        }
        return "Team " + teamColor + " pieces:\n" + pieceStrings;
    }

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