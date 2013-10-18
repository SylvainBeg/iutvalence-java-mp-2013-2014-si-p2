package fr.iutvalence.java.mp.Battleship;


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
    private ShipArea[] shipArray;
    
    /**
     * Initialize a ship.
     * @param ship : array which contains a ship
     */
    public Ship(ShipArea[] ship)
    {
        this.shipArray = ship;
    }
    
    /**
     * Research if targeted area is contained in the ship and if yes, touched it
     * @param  c : coordinate of targeted area
     * @return Boolean : true if ship is hit, else false (coordinate not found in the ship) 
     */
    public boolean ShipIsHit(Coordinate c)
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
        else
        {
            return false;
        }
    }
}
