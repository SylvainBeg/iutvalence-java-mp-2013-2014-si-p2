package fr.iutvalence.java.mp.Battleship;

/**
 * Represents an area of ship. A ship is composed to some "ShipArea"
 * 
 * @author begous
 * 
 */
public class ShipArea
{
    /**
     * area coordinate
     */
    private Coordinates position;

    /**
     * Contains area condition : if player touched area, it's True
     */
    private boolean hit;

    /**
     * ShipArea represents ship area and contains a position (given in parameter)
     * in the grid and a condition (not touched at first)
     * 
     * @param c : area coordinate
     */
    public ShipArea(Coordinates c)
    {
        this.position = c;
        this.hit = false;
    }
    
    /**
     * return area condition (touched or not)
     * 
     * @return hit or not
     */
    public boolean isHit()
    {
        return this.hit;
    }

    /**
     * Hit an area
     * 
     * @param hit : new condition of area
     */
    public void setHit(boolean hit)
    {
        this.hit = hit;
    }

    /**
     * return area coordinate
     * 
     * @return Coordinate : area coordinate
     */
    public Coordinates getPosition()
    {
        return this.position;
    }

}
