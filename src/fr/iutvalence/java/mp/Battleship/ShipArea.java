package fr.iutvalence.java.mp.Battleship;

/**
 * Represents an area of ship. A ship is composed to some "ShipArea"
 * @author begous
 *
 */
public class ShipArea
{
    // TODO (fix) use Coordinates instead of x and y
    /**
     * columns number (coordinate)
     */
    private final int x;
    
    /**
     * lines number (coordinate)
     */
    private final int y;
    
    /**
     * Contains area condition : hit or not
     */
    private boolean hit;
    
    /**
     * Initialize a ShipArea
     * @param x : columns number
     * @param y : lines number
     */
    public ShipArea(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.hit = false;
    }

    
    /**
     * An area is hit
     * @return boolean : hot or not
     */
    public boolean isHit()
    {
        return hit;
    }


    /**
     * Say if ship is hit
     * @param boolean hit
     */
    public void setHit(boolean hit)
    {
        this.hit = hit;
    }


    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
    
    

}
