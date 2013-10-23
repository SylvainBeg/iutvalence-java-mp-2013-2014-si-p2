package fr.iutvalence.java.mp.Battleship;


// TODO (fix) detail comment, it is not understandable as is
/**
 * Declaration a ship which contains areas.
 * @author begous
 *
 */
public class Ship
{    
    /**
     * Ship array : contain area ship (in order or in disorder)
     */
    // TODO (fix) rename field (more explicit)
    private ShipArea[] shipArray;
    
    // TODO (fix) detail comment (how is the ship once created?)
    /**
     * Initialize a ship.
     * @param ship array which contains a ship
     */
    // TODO (fix) rename parameter(this is not a ship)
    public Ship(ShipArea[] ship)
    {
        this.shipArray = ship;
    }
    
    /**
     * Research if targeted area is contained in the ship and if yes, touched it
     * @param  c  coordinate of targeted area
     * @return true if ship is hit, else false (coordinate not found in the ship) 
     */
    // TODO (fix) comply with naming conventions
    // TODO (fix) rename method (Is...)
    public boolean ShipIsHit(Coordinates c)
    {
        int i = 0;
        while (i < this.shipArray.length && this.shipArray[i].getC() != c)
        {
            i = i+1;
        }
        
        if (i < this.shipArray.length)
        {
            this.shipArray[i].setHit(true);
            return true;
        }
        // TODO (fix) simplify
        else
        {
            return false;
        }
    }
}
