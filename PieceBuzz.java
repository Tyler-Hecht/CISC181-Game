/**
 *  Description: This is a PieceBuzz class that extends the abstract Piece Class
 *  @author Tyler Hecht, Eli Brignac
 *  @version 1.0
 *  Email : thecht@udel.edu, ebrignac@udel.edu
 *  Class : CISC 181-080
 *  Lab : CISC 181-080
 *
 */

public class PieceBuzz extends Piece implements Attacker {
    private int numAttacks;
    private int numTimesBeenAttacked;
    private boolean workingLaser;

    //Constructor
    public PieceBuzz(char symbol, String teamColor, int numAttacks, int numTimesBeenAttacked, boolean workingLaser, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
    }

    //default constructor
    public PieceBuzz(){
        this('B',"- -", 0,0, true, false, true);
    }

    //Setters
    public int getNumAttacks() {
        return numAttacks;
    }
    public int getNumTimesBeenAttacked() {
        return numTimesBeenAttacked;
    }
    public boolean canAttack(){
        return workingLaser;
    }
    public void setWorkingLaser(boolean workingLaser) {
        this.workingLaser = workingLaser;
    }
    public void setNumAttacks(int numAttacks)  {
     this.numAttacks = numAttacks;
    }


    /**
     * Can attack any num of space left or right OR it can attack 2 spaces
     * up or down the column its in
     * @param fromSquareRow the row the piece is on
     * @param fromSquareCol the col the piece is on
     * @param toSquareRow the row the piece will go to
     * @param toSquareCol the col the piece will go to
     * @return bool if it can attack the square
     */
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return (fromSquareCol == toSquareCol) || (fromSquareRow == toSquareRow && Math.abs(fromSquareCol - toSquareCol) <= 2);
    }

    /**
     * This method increases numTimesBeenAttacked by 1 and sets workingLaser to false;
     */
    public void updateNumTimesBeenAttacked(){
        this.numTimesBeenAttacked += 1;
        this.workingLaser = false;
    }
    /**
     * This method prints "To Infinity and Beyond!"
     */
    public void speak(){
        System.out.println("To Infinity and Beyond!");
    }
    /**
     * This method tells you if this Piece can spawn
     * @return Returns a null
     */
    public Piece spawn(){
        return null;
    }

    /**
     * This me
     * @return
     */
    public boolean canSpawn(){
        return false;
    }

    /**
     * This method determins if a piece can move from one position of the board to another
     * @param fromSquareRow int: this is the row that the piece is currently on
     * @param fromSquareCol int: this is the column that the piece is currently on
     * @param toSquareRow   int: this is the row that the piece is moving to
     * @param toSquareCol   int: this is the column that the piece is moving to
     * @return a boolean if the piece can move to toSquareRow and toSquareCol
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true;
    }

    /**
     * This method will always return false because piece buzz cannot spawn.
     * @return false
     */
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return false;
    }

    /**
     * This method will always return false becaue piece buzz cannot recruit
     * @return false
     */
    public boolean validRecruitPath(int rowFrom, int columnFrom, int rowTo, int columnTo) {return false;}

}
