/**
 *  Description: this is the evil minion piece it extends the minion piece
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 */
public class PieceEvilMinion extends PieceMinion implements Attacker, Recruiter {
    private boolean hungry;
    private int numAttacks;
    final public int MAX_NUM_ATTACKS = 3;

    //Constructor
    public PieceEvilMinion(char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        updateHungry();
    }
    //Default constructor
    public PieceEvilMinion() {
        this('E', "- -", 0, 0, 0, false, true);
    }

    //Getters and setters
    public boolean canAttack() {
        return hungry;
    }
    public int getNumAttacks() {
        return numAttacks;
    }
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    /**
     * Can recruit any num of spaces up and down, or it can move 2 spaces
     * left or right.
     * @param fromSquareRow the row the piece is from
     * @param fromSquareCol the column the piece is from
     * @param toSquareRow the row the piece is acting uppon
     * @param toSquareCol the column the piece is acting uppon
     * @return
     */
    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return super.validMovePath(fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }

    /**
     * updates hungry to make sure the numAttacks is less that Max_attacks
     */
    public void updateHungry() {
        this.hungry = this.numAttacks < MAX_NUM_ATTACKS;
    }

    /**
     * Prints Roar!
     */
    public void speak() {
        System.out.println("Roar!");
    }


    /**
     * Can move any num of spaces up and down, or it can move 2 spaces
     * left or right.
     * @param fromSquareRow the row the piece is from
     * @param fromSquareCol the column the piece is from
     * @param toSquareRow the row the piece is acting uppon
     * @param toSquareCol the column the piece is acting uppon
     * @return if it can move to the square
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return super.validMovePath(fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }

    /**
     * Can recruit any num of spaces up and down, or it can move 2 spaces
     * left or right.
     * @param fromSquareRow the row the piece is from
     * @param fromSquareCol the colum the piece is from
     * @param toSquareRow the row the piece is acting uppon
     * @param toSquareCol the column the piece is acting uppon
     * @return if the piece can recruit to this square
     */
    @Override
    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return super.validMovePath(fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }

    /**
     * spawns a new Evil mionion piece
     * @return a new PieceEvilMinion
     */
    public PieceEvilMinion spawn() {
        this.numTimesSpawned++;
        return new PieceEvilMinion(Character.toLowerCase(this.symbol), this.teamColor, 1, 0, 0, false, false);
    }

    /**
     * Can spawn any num of spaces up and down, or it can move 2 spaces
     * left or right.
     * @param fromSquareRow the row the piece is from
     * @param fromSquareCol the colum the piece is from
     * @param toSquareRow the row the piece is acting uppon
     * @param toSquareCol the column the piece is acting uppon
     * @return if the piece can spawn at that square.
     */
    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return super.validMovePath(fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }
}