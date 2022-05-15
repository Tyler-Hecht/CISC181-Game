public class PieceKingSlime extends PieceBlueSlime {
    public PieceKingSlime(char symbol, String teamColor, int numAttacks, boolean hidden, boolean original) {
        super(symbol, teamColor, numAttacks, hidden, original);
    }

    public PieceKingSlime() {
        this('K', "- -", 0, false, true);
    }

    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        //any of the 8 nearest squares
        //since the distance will only be 0, 1, sqrt2, sqrt3, etc, the +0.01 should handle rounding errors
        return Math.sqrt(Math.pow(fromSquareRow - toSquareRow, 2) + Math.pow(fromSquareCol - toSquareCol, 2)) <= Math.sqrt(2) + 0.01;
    }

    @Override
    public void speak() {
        System.out.println("BOING");
    }
}