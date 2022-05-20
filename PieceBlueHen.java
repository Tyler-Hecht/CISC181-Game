/**
 *  Description: This is a PieceBlueHen class that extends the abstract Piece Class
 *  @author Tyler Hecht, Eli Brignac
 *  @version 1.0
 *  Email : thecht@udel.edu, ebrignac@udel.edu
 *  Class : CISC 181-080
 *  Lab : CISC 181-080
 *
 */
public class PieceBlueHen extends Piece implements Attacker, Recruiter {
    private int numAttacks;
    private int numRecruits;
    private boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    //Constructor
    public PieceBlueHen (char symbol, String teamColor, int numAttacks, int numRecruits, boolean hidden, boolean original){
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    //default constructor
    public PieceBlueHen ()  {
        this('H',"NON",
                0,0,
                false,true);
    }

    //getters and setters
    public int getNumAttacks()    {
        return this.numAttacks;
    }
    public int getNumRecruits(){
        return this.numRecruits;
    }
    public boolean canFly()    {
        return this.flies;
    }
    public void setNumAttacks(int numAttacks)    {
        this.numAttacks = numAttacks;
        updateFly();
    }


    /**
     * If it can fly it can spawn to any path. If not, then it can spawn to one space in
     * any direction including diagonals.
     * @param fromSquareRow int: this is the row that the piece is currently on
     * @param fromSquareCol int: this is the column that the piece is currently on
     * @param toSquareRow int: this is the row the piece is moving to
     * @param toSquareCol int: this is the column that the piece is moving to
     * @return if the piece can spawn to that particular square
     */
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (this.canFly()) {
            return true;
        }
        //diagonal
        return Math.abs(fromSquareRow-toSquareRow)==1 && Math.abs(fromSquareCol-toSquareCol)==1;
    }

    /**
     * This is a prototype of the method validSpawnPath that has the same name
     * for differnet pieces but the logic inside will be differnt for each piece
     * @param fromSquareRow int: this is the row that the piece is currently on
     * @param fromSquareCol int: this is the column that the piece is currently on
     * @param toSquareRow int: this is the row that the piece is moving to
     * @param toSquareCol int: this is the column that the piece is moving to
     * @return if its possible to spawn to the toSquareRow and toSquareCol
     */
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (this.canFly()) {
            return true;
        }
        //left or right
        return (fromSquareRow==toSquareRow) && Math.abs(fromSquareCol-toSquareCol)==1;
    }

    /**
     * This method check if a recruit path is possible or not for a PieceBlueHen. If
     * it can fly it can then recruit any piece on the board. If it can't then
     * it can only move one space up or down and one space left or right.
     * @param fromSquareRow int: this is the row that the piece is currently on
     * @param fromSquareCol int: this is the column that the piece is currently on
     * @param toSquareRow int: this is the row that the piece is moving to
     * @param toSquareCol int: this is the column that the piece is moving to
     * @return if its possible to recruit the piece or not
     */
    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (this.canFly()) {
            return true;
        }
        //up or down
        return (fromSquareCol==toSquareCol) && Math.abs(fromSquareRow - toSquareRow)==1;
    }

    /**
     * This method checks if a move path is possible or not for a PieceBlueHen. It can move
     * to any of the 8 nearest squares.
     * @param fromSquareRow int: this is the row that the piece is currently on
     * @param fromSquareCol int: this is the column that the piece is currently on
     * @param toSquareRow   int: this is the row that the piece is moving to
     * @param toSquareCol   int: this is the column that the piece is moving to
     * @return a boolean of if the piece can move to the position toSquareRow toSquareCol
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (this.canFly()) {
            return true;
        }
        //any of the 8 nearest squares
        //since the distance will only be 0, 1, sqrt2, sqrt3, etc, the +0.01 should handle rounding errors
        return Math.sqrt(Math.pow(fromSquareRow-toSquareRow,2)+Math.pow(fromSquareCol-toSquareCol,2)) <= Math.sqrt(2) + 0.01;
    }

    //Setter
    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    /**
     * This method updates the var flies and sets it to ture of false
     */
    private void updateFly()    {
        this.flies = (this.numAttacks < MAX_NUM_ATTACKS);
    }

    /**
     * This method prints "Go UD!"
     */
    public void speak(){
        System.out.println("Go UD!");
    }

    /**This method spawns a new PieceBlueHen that is based off of the one it's called on
     * @return a new PieceBlueHen object with the same properties of the PieceBlueHen object it is called on.
     */
    public PieceBlueHen spawn() {
        return new PieceBlueHen(Character.toLowerCase(this.symbol), this.teamColor,this.numAttacks,this.numRecruits, false,false);
    }

    /**
     * This method returns wether or not the PieceBlueHen can spawn
     * @return boolean if it can spawn or not
     */
    public boolean canSpawn(){
        return true;
    }
}