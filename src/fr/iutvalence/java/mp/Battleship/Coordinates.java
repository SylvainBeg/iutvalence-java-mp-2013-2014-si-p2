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
     * Column number
     */
    private final int column;

    /**
     * Row number
     */
    private final int row;

    /**
     * Represents an unique position in the grid with a column number and a row number (given a parameter).
     * 
     * @param column0 : column number
     * @param row0 : row number
     */
    public Coordinates(int column0, int row0) 
    {
       
        this.column = column0;
        this.row = row0;
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
     * return row number
     * 
     * @return row number
     */
    public int getLine()
    {
        return this.row;
    }
}
