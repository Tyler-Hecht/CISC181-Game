public interface Attacker {
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int numAttacks);
    public abstract boolean validAttackPath(int rower, int columner, int rowee, int columnee);
}
