/**
 *  Description: THis is the piece minion class
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */
public class PieceMinion extends Piece implements Recruiter {
    protected int numRecruits;
    protected int numTimesSpawned;

    public static int MAX_NUM_SPAWNED = 3;

    //CONSTRUCTOR
    public PieceMinion(char symbol, String teamColor, int numRecruits, int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }
    //default constructor
    public PieceMinion(){
        this('M',"- -", 0,0, false,true);
    }

    //getter and setters
    public int getNumRecruits() {
        return numRecruits;
    }
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public void setNumRecruits(int numRecruits) {
       this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return (fromSquareCol == toSquareCol) || ((fromSquareRow == toSquareRow) && Math.abs(fromSquareRow - toSquareRow) <= 2);
    }

    /**
     * prints Bello
     */
    public void speak(){
        System.out.println("Bello!");
    }


    /**
     * Spawns a new piece minion with a lowercase m
     * @return a new piece minon
     */
    public PieceMinion spawn() {
        this.numTimesSpawned++;
        return new PieceMinion(Character.toLowerCase(this.symbol), this.teamColor,1, 0, false, false);
    }

    /**
     * Can recruit any num of spaces up and down, or it can move 2 spaces
     * left or right.
     * @param fromSquareRow int: this is the row that the piece is currently on
     * @param fromSquareCol int: this is the column that the piece is currently on
     * @param toSquareRow   int: this is the row that the piece is moving to
     * @param toSquareCol   int: this is the column that the piece is moving to
     * @return if the piece can move there
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return (fromSquareCol == toSquareCol) || ((fromSquareRow == toSquareRow) && Math.abs(fromSquareRow - toSquareRow) <= 2);
    }

    /**
     * if the num times spawned < max times spawned
     * @return if it can spawn
     */
    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }


    /**
     * Spawns in the nearest empty corner of the board.
     * @param fromSquareRow the row the piece is on
     * @param fromSquareCol the column the piece is on
     * @param toSquareRow the row the piece will act uppon
     * @param toSquareCol the column the piece will act uppon
     * @return if the piece can spawn there
     */
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true;
    }

    /**
     * The minion piece cannot attack.
     * Returns false
     */
    public boolean validAttackPath(int rowFrom, int columnFrom, int rowTo, int columnTo) {return false;}

}
