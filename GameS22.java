/**
 *  Description: This is an extension of the Game object, and it represents
 *  the game that we are making in class as a group.
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */
public class GameS22 extends Game {
    //Constructor
    public GameS22(int numRows, int numColumns, Team team1, Team team2) {
        super(numRows, numColumns, team1, team2);
    }

    /**
     * This method checks if the game has ended by if either team has no pieces left
     * @return If the game has ended
     */
    public boolean isGameEnded() {
        return !team1.hasKingSlime() || !team2.hasKingSlime();
    }

    /**
     * This method returns if there was a winner
     * @return If there is a winner or not
     */
    public boolean isAWinner() {
        return this.isGameEnded() && (team1.hasKingSlime() || team2.hasKingSlime());
    }

    /**Returns the winner of the game
     * @return The winner of the two teams
     */
    public Team getWinner() {
        if (isAWinner()) {
            if (team1.hasKingSlime()) {
                return team1;
            } else {
                return team2;
            }
        } else {
            return null;
        }
    }

}