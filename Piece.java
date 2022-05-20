/**
 *  Description: This is an abstract superclass of pieces of a game
 *  @author Tyler Hecht, Eli Brignac
 *  @version 1.0
 *  Email : thecht@udel.edu, ebrignac@udel.edu
 *  Class : CISC 181-080
 *  Lab : CISC 181-080
 *
 */

abstract class Piece implements Comparable<Piece>{
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;


    /**
     * This method returns wether the piece passed or the piece
     * called on comes first based off of the symbol of the piece
     * @param piece The piece you want to see if it comes first
     * @return an integer based on if it comes first.
     * if int < 0: the object passed comes second
     * if int == 0: the objects have the same symbols
     * if int > 0: the object passed comes first
     */
    @Override
    public int compareTo(Piece piece) {
        return ((Character) symbol).compareTo((Character) piece.symbol);
    }

    //constructor
    public Piece(char symbol, String teamColor, boolean hidden, boolean original) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }

    //gettters and setters
    public char getSymbol() {
        return symbol;
    }
    public String getTeamColor() {
        return teamColor;
    }
    public boolean isHidden() {
        return hidden;
    }
    public boolean isOriginal() {
        return original;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void setOriginal(boolean original) {
        this.original = original;
    }

    /**
     * This method represents the object at hand as a string of its
     * teamColor and symbol.
     *
     * @return a string of the objects teamColor followed by its Symbol
     */
    @Override
    public String toString() {
        return this.teamColor + " " + this.symbol;
    }

    /**
     * This is a prototype of the method validMovePath that has the same name
     * for differnet pieces but the logic inside will be differnt for each piece
     * @param fromSquareRow int: this is the row that the piece is currently on
     * @param fromSquareCol int: this is the column that the piece is currently on
     * @param toSquareRow int: this is the row that the piece is moving to
     * @param toSquareCol int: this is the column that the piece is moving to
     * @return if its possible to move to the toSquareRow and toSquareCol
     */
    abstract boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);

    /**
     * This method prints a funny thing that is unique to each piece
     */
    public abstract void speak();

    /**
     * This is a prototype method that is unique to each piece
     * @return boolen if the piece can spawn itself or not
     */
    public abstract boolean canSpawn();

    /**
     * spawns a new piece of the same type of the piece its called on.
     * @return The piece that is spawned, THis will vary depending on the
     *          class it is beign called in
     */
    public abstract Piece spawn();

    /**
     * This is a prototype of the method validSpawnPath that has the same name
     * for differnet pieces but the logic inside will be differnt for each piece
     * @param rowFrom int: this is the row that the piece is currently on
     * @param columnFrom int: this is the column that the piece is currently on
     * @param rowTo int: this is the row that the piece is moving to
     * @param columnTo int: this is the column that the piece is moving to
     * @return if its possible to spawn to the toSquareRow and toSquareCol
     */
    abstract boolean validSpawnPath(int rowFrom, int columnFrom, int rowTo, int columnTo);


    /**
     * This is a prototype of the method validRecruitPath that has the same name
     * for differnet pieces but the logic inside will be differnt for each piece
     * @param rowFrom int: this is the row that the piece is currently on
     * @param columnFrom int: this is the column that the piece is currently on
     * @param rowTo int: this is the row that the piece is moving to
     * @param columnTo int: this is the column that the piece is moving to
     * @return if its possible to recruit to the toSquareRow and toSquareCol
     */
    abstract boolean validRecruitPath(int rowFrom, int columnFrom, int rowTo, int columnTo);

    /**
     * This is a prototype of the method validAttackPath that has the same name
     * for differnet pieces but the logic inside will be differnt for each piece
     * @param rowFrom int: this is the row that the piece is currently on
     * @param columnFrom int: this is the column that the piece is currently on
     * @param rowTo int: this is the row that the piece is moving to
     * @param columnTo int: this is the column that the piece is moving to
     * @return if its possible to attack the piece in the toSquareRow and toSquareCol
     */
    abstract boolean validAttackPath(int rowFrom, int columnFrom, int rowTo, int columnTo);
}
