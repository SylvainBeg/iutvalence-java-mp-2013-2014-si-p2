package fr.iutvalence.java.mp.Battleship;

/**
 * Represents a coordinate : an area
 * @author begous
 *
 */
public class Coordinate
{
    /**
     * Columns number
     */
    private final int x;
    
    /**
     * Lines number
     */
    private final int y;
    
    /**
     * Ship coordinate
     * @param x : column number
     * @param y : line number
     */
    public Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;        
    }

    // TODO FIXED write comment
    /**
     * return column number
     * @return int : column number
     */
    public int getX()
    {
        return this.x;
    }

    
    // TODO FIXED write comment
    /**
     * return line number
     * @return int : line number
     */
    public int getY()
    {
        return this.y;
    }
}
