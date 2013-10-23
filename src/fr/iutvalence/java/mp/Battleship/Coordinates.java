package fr.iutvalence.java.mp.Battleship;

/**
 * Represents a coordinate : an area
 * @author begous
 *
 */
public class Coordinates
{
    /**
     * Columns number
     */
    private final int x;
    
    /**
     * Lines number
     */
    private final int y;
    
    // TODO (fix) fix comment, this class is not only related to ships
    /**
     * Ship coordinate
     * @param x : column number
     * @param y : line number
     */
    public Coordinates(int x, int y)
    {
        this.x = x;
        this.y = y;        
    }

    /**
     * return column number
     * @return column number
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * return line number
     * @return line number
     */
    public int getY()
    {
        return this.y;
    }
}
