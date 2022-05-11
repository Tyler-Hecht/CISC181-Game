public class PieceBuzz extends Piece implements Attacker {
    private int numAttacks;
    private int numTimesBeenAttacked;
    private boolean workingLaser;

    public PieceBuzz(char symbol, String teamColor, int numAttacks, int numTimesBeenAttacked, boolean workingLaser, boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
    }

    public PieceBuzz(){
        this('B',"- -", 0,0, true, false, true);
    }

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

    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return (fromSquareCol == toSquareCol) || (fromSquareRow == toSquareRow && Math.abs(fromSquareCol - toSquareCol) <= 2);
    }

    public void updateNumTimesBeenAttacked(){
        this.numTimesBeenAttacked += 1;
        this.workingLaser = false;
    }

    public void speak(){
        System.out.println("To Infinity and Beyond!");
    }

    public Piece spawn(){
        return null;
    }
    public boolean canSpawn(){
        return false;
    }
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true;
    }
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return false;
    }

}
