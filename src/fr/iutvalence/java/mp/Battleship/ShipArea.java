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
    // TODO (fix) rename field (more explicit with regards to what a shipArea is)
    private Coordinates couple;

    /**
     * Contains area condition : if player touched area, it's True
     */
    private boolean hit;

    // TODO (fix) rewrite comment (shipArea is not a couple of coordinates)
    /**
     * ShipArea has a couple of coordinate, give in parameter, which defines
     * this position in the grid and it has the boolean False in "hit"
     * 
     * @param c
     *            : area coordinate
     */
    public ShipArea(Coordinates c)
    {
        this.couple = c;
        this.hit = false;
    }

    // TODO (fix) rewrite comment (not understandable)
    /**
     * Say if ship is hit An area is hit
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
     * @param hit
     *            new condition of area
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
    // TODO (fix) rename method (more explicit with regards to what a shipArea is)
    public Coordinates getCouple()
    {
        return this.couple;
    }

}
