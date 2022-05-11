public class PieceBlueHen extends Piece implements Attacker, Recruiter {
    private int numAttacks;
    private int numRecruits;
    private boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    public PieceBlueHen (char symbol, String teamColor, int numAttacks, int numRecruits, boolean hidden, boolean original){
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    public PieceBlueHen ()  {
        this('H',"NON",
                0,0,
                false,true);
    }

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

    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (this.canFly()) {
            return true;
        }
        //diagonal
        return Math.abs(fromSquareRow-toSquareRow)==1 && Math.abs(fromSquareCol-toSquareCol)==1;
    }
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (this.canFly()) {
            return true;
        }
        //left or right
        return (fromSquareRow==toSquareRow) && Math.abs(fromSquareCol-toSquareCol)==1;
    }
    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (this.canFly()) {
            return true;
        }
        //up or down
        return (fromSquareCol==toSquareCol) && Math.abs(fromSquareRow-toSquareRow)==1;
    }
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if (this.canFly()) {
            return true;
        }
        //any of the 8 nearest squares
        //since the distance will only be 0, 1, sqrt2, sqrt3, etc, the +0.01 should handle rounding errors
        return Math.sqrt(Math.pow(fromSquareRow-toSquareRow,2)+Math.pow(fromSquareCol-toSquareCol,2)) <= Math.sqrt(2) + 0.01;
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }


    private void updateFly()    {
        this.flies = (this.numAttacks < MAX_NUM_ATTACKS);
    }
    public void speak(){
        System.out.println("Go UD!");
    }

    public PieceBlueHen spawn() {
        return new PieceBlueHen(Character.toLowerCase(this.symbol), this.teamColor,this.numAttacks,this.numRecruits, false,false);
    }
    public boolean canSpawn(){
        return true;
    }
}