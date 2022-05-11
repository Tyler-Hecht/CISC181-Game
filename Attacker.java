/**
 *  Description: This is an interface named attacker that have public
 *  abstract methods.
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */
public interface Attacker {
    /**
     * This is an abstract getter
     * @return The number of attacks
     */
    public abstract int getNumAttacks();

    /**
     * This is an abstract setter
     * @param numAttacks The number of attacks you want to set
     */
    public abstract void setNumAttacks(int numAttacks);

    /**
     * This checks if the piece has a valid attack path
     * @param rower This is the row index of the piece attacking
     * @param columner This is the column index of the piece attacking
     * @param rowee This is the row index of the piece being attacked
     * @param columnee This is the column index of the piece being attacked
     * @return If the piece can be attacked or not
     */
    public abstract boolean validAttackPath(int rower, int columner, int rowee, int columnee);
}