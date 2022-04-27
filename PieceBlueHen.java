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

    @Override
    public boolean validAttackPath(int rower, int columner, int rowee, int columnee) {
        return true;
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int rower, int columner, int rowee, int columnee) {
        return true;
    }

    private void updateFly()    {
        if (this.numAttacks < MAX_NUM_ATTACKS){
            this.flies = true;
        }
        else {
            this.flies = false;
        }
    }
    public void speak(){
        System.out.println("Go UD!");
    }

    public PieceBlueHen spawn() {
        PieceBlueHen copyHen = new PieceBlueHen(Character.toLowerCase(this.symbol), this.teamColor,this.numAttacks,this.numRecruits, false,false);
        return copyHen;
    }
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }
    public boolean canSpawn(){
        return true;
    }
}
