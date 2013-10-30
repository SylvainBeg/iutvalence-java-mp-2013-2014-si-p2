package fr.iutvalence.java.mp.Battleship;

// TODO ((fix) rewrite comment (wrong description)
/**
 * Represents a coordinate : an area
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

    // TODO (fix) rewrite comment (not understandable)
    /**
     * Coordinate for a couple which identify an area in the grid
     * 
     * @param column0
     *            : column number
     * @param line0
     *            : line number
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
