public class PieceEvilMinion extends PieceMinion implements Attacker, Recruiter {
    private boolean hungry;
    private int numAttacks;
    final public int MAX_NUM_ATTACKS = 3;

    public PieceEvilMinion(char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        updateHungry();
    }
    public PieceEvilMinion() {
        this('E', "- -", 0, 0, 0, false, true);
    }

    public boolean canAttack() {
        return hungry;
    }
    public int getNumAttacks() {
        return numAttacks;
    }
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return super.validMovePath(fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }

    public void updateHungry() {
        this.hungry = this.numAttacks < MAX_NUM_ATTACKS;
    }

    public void speak() {
        System.out.println("Roar!");
    }
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return super.validMovePath(fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }
    @Override
    public boolean validRecruitPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return super.validMovePath(fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }

    public PieceEvilMinion spawn() {
        this.numTimesSpawned++;
        return new PieceEvilMinion(Character.toLowerCase(this.symbol), this.teamColor, 1, 0, 0, false, false);
    }
    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return super.validMovePath(fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }
}