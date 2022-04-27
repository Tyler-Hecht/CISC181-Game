public interface Recruiter {
    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int numRecruits);
    public abstract boolean validRecruitPath(int rower, int columner, int rowee, int columnee);
}
