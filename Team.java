import java.util.ArrayList;

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
        String pieceStrings = "";
        for(Piece piece : pieces) {
            pieceStrings += piece.toString() + "   ";
        }
        return "Team " + teamColor + " pieces:\n" + pieceStrings;
    }

}
