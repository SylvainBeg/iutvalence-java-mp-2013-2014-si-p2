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

    // TODO (fix) write comment
    public int getX()
    {
        return x;
    }

    // TODO (fix) write comment
    public int getY()
    {
        return y;
    }
}
