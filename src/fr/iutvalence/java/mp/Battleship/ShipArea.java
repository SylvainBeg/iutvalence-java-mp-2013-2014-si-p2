package fr.iutvalence.java.mp.Battleship;

/**
 * Represents an area of ship. A ship is composed to some "ShipArea"
 * @author begous
 *
 */
public class ShipArea
{
    /**
     * area coordinate
     */
   // TODO (fix) rename field (more explicit)
    private Coordinates c;


    // TODO (fix) rewrite comment (not clear)
    /**
     * Contains area condition : hit or not
     */
    private boolean hit;
    
    // TODO (fix) rewrite comment. Do not say that it initializes a ship
    // but how the ship looks like once initialized
    /**
     * Initialize a ShipArea
     * @param c : area coordinate 
     */
    public ShipArea(Coordinates c)
    {
        this.c = c;
        this.hit = false;
    }

    
    /**
     * Say if ship is hit An area is hit
     * @return hit or not
     */
    public boolean isHit()
    {
        return this.hit;
    }


    /**
     * Hit an area
     * @param hit new condition of area
     */
    public void setHit(boolean hit)
    {
        this.hit = hit;
    }

    /**
     * return area coordinate 
     * @return Coordinate : area coordinate
     */
    // TODO (fix) rename method (more explicit)
    public Coordinates getC()
    {
        return this.c;
    }
 
    

}
