public class GameS22 extends Game {
    public GameS22(int numRows, int numColumns, Team team1, Team team2) {
        super(numRows, numColumns, team1, team2);
    }

    public boolean isGameEnded() {
        return team1.getTeamPieces().size() == 0 || team2.getTeamPieces().size() == 0;
    }
    public boolean isAWinner() {
        return this.isGameEnded() && (team1.getTeamPieces().size() > 0 || team2.getTeamPieces().size() > 0);
    }
    public Team getWinner() {
        if (isAWinner()) {
            if (team1.getTeamPieces().size() > 0) {
                return team1;
            } else {
                return team2;
            }
        } else {
            return null;
        }
    }

}
