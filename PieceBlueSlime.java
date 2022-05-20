/**
 *  Description: This is the class for the Blue Slime piece. It extends the piece class and is a mob from terraria.
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */
public class PieceBlueSlime extends Piece implements Attacker, Recruiter {
    private int numAttacks;
    private int numRecruits;

    //constructor
    public PieceBlueSlime(char symbol, String teamColor, int numAttacks, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
    }
    //default constructor
    public PieceBlueSlime(){
        this('S',"- -", 0, false,true);
    }

    //getters and setters
    public int getNumRecruits() {return numRecruits;}
    public int getNumAttacks() {
        return numAttacks;
    }
    public void setNumAttacks(int numAttacks)  {
        this.numAttacks = numAttacks;
    }
    public void setNumRecruits(int numRecruits)  {
        this.numRecruits = numRecruits;
    }

    /**
     * The piece blue slime can move to any of the nearest 8 squares.
     * @param fromSquareRow the row the piece is on
     * @param fromSquareCol the column the piece is on
     * @param toSquareRow the row the piece will move to
     * @param toSquareCol the column the piece will move to
     * @return If it can move to that square
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        //any of the 8 nearest squares
        //since the distance will only be 0, 1, sqrt2, sqrt3, etc, the +0.01 should handle rounding errors
        return Math.sqrt(Math.pow(fromSquareRow-toSquareRow,2)+Math.pow(fromSquareCol-toSquareCol,2)) <= Math.sqrt(2) + 0.01;
    }

    /**
     * The piece blue slime can attack the 4 adjacent squares.
     * @param fromSquareRow the row the piece is on
     * @param fromSquareCol the column the piece is on
     * @param toSquareRow the row the piece will move to
     * @param toSquareCol the column the piece will move to
     * @return if the piece can attack that square
     */
    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        //four adjacent squares
        return Math.abs(fromSquareRow-toSquareRow) + Math.abs(fromSquareCol-toSquareCol) == 1;
    }


    /**
     * This piece recurits in the same way a knight from chess moves.
     * @param fromSquareRow the row the piece is on
     * @param fromSquareCol the column the piece is on
     * @param toSquareRow the row the piece will move to
     * @param toSquareCol the column the piece will move to
     * @return if the piece can recruit that square
     */
    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        //knight moves are always a distance of sqrt5 away
        if (!this.original) {
            return false;
        }
        return Math.abs(Math.sqrt(Math.pow(fromSquareRow-toSquareRow,2) + Math.pow(fromSquareCol-toSquareCol,2)) - Math.sqrt(5)) <= 0.01;
    }


    /**
     * This will always return false because the piece blue hen cannot spawn to a desired square
     * it can only spawn when it moves. It spawns a new slime in the spot that it left from.
     * @return false
     */
    public boolean validSpawnPath(int rowFrom, int columnFrom, int rowTo, int columnTo) {return false;}


    /**
     * Prints "boing"
     */
    public void speak() {
        System.out.println("boing");
    }

    /**
     * @return returns true
     */
    public boolean canSpawn() {return true;}

    public Piece spawn() {return new PieceBlueSlime('s', this.teamColor,1, false, false);}
}
