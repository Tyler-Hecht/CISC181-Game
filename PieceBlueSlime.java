public class PieceBlueSlime extends Piece implements Attacker, Recruiter {
    private int numAttacks;
    private int numRecruits;

    public PieceBlueSlime(char symbol, String teamColor, int numAttacks, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
    }

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
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        //any of the 8 nearest squares
        //since the distance will only be 0, 1, sqrt2, sqrt3, etc, the +0.01 should handle rounding errors
        return Math.sqrt(Math.pow(fromSquareRow-toSquareRow,2)+Math.pow(fromSquareCol-toSquareCol,2)) <= Math.sqrt(2) + 0.01;
    }
    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        //four adjacent squares
        return Math.abs(fromSquareRow-toSquareRow) + Math.abs(fromSquareCol-toSquareCol) == 1;
    }
    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        //knight moves are always a distance of sqrt5 away
        return Math.abs(Math.sqrt(Math.pow(fromSquareRow-toSquareRow,2) + Math.pow(fromSquareCol-toSquareCol,2)) - Math.sqrt(5)) <= 0.01;
    }

    public void speak() {
        System.out.println("boing");
    }
    public boolean canSpawn() {return true;}
    public Piece spawn() {return new PieceBlueSlime(Character.toLowerCase(this.symbol), this.teamColor,1, false, false);}
}
