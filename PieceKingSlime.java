/**
 *  Description: This is the King Slime piece it extends the Blue slime piece.
 *  If it dies you loose the game. All other stuff it can do is the same as the
 *  piece blue slime (spawn, move, recruit, etc.)
 *   @author Tyler Hecht, Eli Brignac
 *    @version 1.0
 *     Email : thecht@udel.edu, ebrignac@udel.edu
 *      Class : CISC 181-080
 *       Lab : CISC 181-080
 *
 */
public class PieceKingSlime extends PieceBlueSlime {
    //Constructor
    public PieceKingSlime(char symbol, String teamColor, int numAttacks, boolean hidden, boolean original) {
        super(symbol, teamColor, numAttacks, hidden, original);
    }

    //default constructor
    public PieceKingSlime() {
        this('K', "- -", 0, false, true);
    }

    /**
     * Can attack the 8 adjacent squares diagonals included
     * @param fromSquareRow the row the piece is on
     * @param fromSquareCol the column the piece is on
     * @param toSquareRow   the row the piece will move to
     * @param toSquareCol   the column the piece will move to
     * @return if the piece can attack there
     */
    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        //any of the 8 nearest squares
        //since the distance will only be 0, 1, sqrt2, sqrt3, etc, the +0.01 should handle rounding errors
        return Math.sqrt(Math.pow(fromSquareRow - toSquareRow, 2) + Math.pow(fromSquareCol - toSquareCol, 2)) <= Math.sqrt(2) + 0.01;
    }

    /**
     *prints "BOING"
     */
    @Override
    public void speak() {
        System.out.println("BOING");
    }
}