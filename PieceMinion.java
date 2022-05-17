public class PieceMinion extends Piece implements Recruiter {
    protected int numRecruits;
    protected int numTimesSpawned;

    public static int MAX_NUM_SPAWNED = 3;

    public PieceMinion(char symbol, String teamColor, int numRecruits, int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }

    public PieceMinion(){
        this('M',"- -", 0,0, false,true);
    }

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

    public void speak(){
        System.out.println("Bello!");
    }

    public PieceMinion spawn() {
        this.numTimesSpawned++;
        return new PieceMinion(Character.toLowerCase(this.symbol), this.teamColor,1, 0, false, false);
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return (fromSquareCol == toSquareCol) || ((fromSquareRow == toSquareRow) && Math.abs(fromSquareRow - toSquareRow) <= 2);
    }
    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {

        return true;
    }

    public boolean validAttackPath(int rowFrom, int columnFrom, int rowTo, int columnTo) {return false;}

}
