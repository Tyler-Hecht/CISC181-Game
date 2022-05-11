/**
 *  Description: This is an Interface named recruiter that has some public
 *              abstract methods.
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */
public interface Recruiter {

    /**
     * This is an abstract method that gets the number of Recruits
     * @return An integer of the number of recurites
     */
    public abstract int getNumRecruits();

    /**
     * This is an abstract setter
     * @param numRecruits The number of recrutes you want to set
     */
    public abstract void setNumRecruits(int numRecruits);

    /**
     * This is an abstract method that checks if a recruit path is valid or not.
     * @param rower The row index of the piece doing the recruiting
     * @param columner The column index of the piece doing the recruiting
     * @param rowee The row index of the piece being recruited
     * @param columnee The column index of the piece being recruited
     * @return If the recruit path is valid or not
     */
    public abstract boolean validRecruitPath(int rower, int columner, int rowee, int columnee);
}