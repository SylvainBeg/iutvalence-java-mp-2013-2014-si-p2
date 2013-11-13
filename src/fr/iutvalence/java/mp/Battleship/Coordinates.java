package fr.iutvalence.java.mp.Battleship;

/**
 * Represents a position in the grid with a column number and a line number. This position is the area position (only one).
 * 
 * @author begous
 * 
 */
public class Coordinates
{
    /**
     * Columns number
     */
    private final int column;

    /**
     * Lines number
     */
    private final int line;

    /**
     * Represents an unique position in the grid with a column number and a line number (given a parameter).
     * 
     * @param column0 : column number
     * @param line0 : line number
     */
    public Coordinates(int column0, int line0)
    {
        this.column = column0;
        this.line = line0;
    }

    /**
     * return column number
     * 
     * @return column number
     */
    public int getColumn()
    {
        return this.column;
    }

    /**
     * return line number
     * 
     * @return line number
     */
    public int getLine()
    {
        return this.line;
    }
}
