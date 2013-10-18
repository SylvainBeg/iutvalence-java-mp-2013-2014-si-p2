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
    private Coordinate c;


    /**
     * Contains area condition : hit or not
     */
    private boolean hit;
    
    
    /**
     * Initialize a ShipArea
     * @param c : area coordinate 
     */
    public ShipArea(Coordinate c)
    {
        this.c = c;
        this.hit = false;
    }

    
    /**
     * Say if ship is hit An area is hit
     * @return boolean : hit or not
     */
    public boolean isHit()
    {
        return this.hit;
    }


    /**
     * Hit an area
     * @param hit : new condition of area
     */
    public void setHit(boolean hit)
    {
        this.hit = hit;
    }

    /**
     * return area coordinate 
     * @return Coordinate : area coordinate
     */
    public Coordinate getC()
    {
        return this.c;
    }
 
    

}
