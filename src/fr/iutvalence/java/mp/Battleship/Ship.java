package fr.iutvalence.java.mp.Battleship;


/**
 * A Ship is an array of ShipArea :  a ship is divided in several part 
 * @author begous
 * 
 */
public class Ship 
{
    /**
     * Ship array : contain area ship (in order or in disorder)
     */
    private ShipArea[] positions;

    /**
     * Initialize a ship with a ship area array (ship free in the grid) in parameter
     * @param ship : a ship (ship area array) ready to be place
     */
    public Ship(ShipArea[] ship)
    {       
        this.positions = ship;
    }

    /**
     * Research if targeted area is contained in the ship and if yes, touched it
     * 
     * @param c  coordinate of targeted area
     * @return true if ship is hit, else false (coordinate not found in the ship)
     */
    // TODO (fix) use exception to handle bad coordinates
    public boolean isHitAt(Coordinates c)
    {
        // TODO FIXED rewrite the loop as a for
        
        int i;
        for (i=0; i < this.positions.length && this.positions[i].getPosition() != c; i++ )
        {
        }

        if (i < this.positions.length)
        {
            this.positions[i].setHit(true);
            return true;
        }
        // TODO (fix) simplify
        else
        {
            return false;
        }
    }

    
    /**
     * Research if a ship is sunk : if all ship areas are hit.
     * @return ship condition (sank or not)
     */
    public boolean isShipSunk()
    {  
        // TODO FIXED rewrite the loop as a for
        int i;
        for (i=0; i < this.positions.length && this.positions[i].isHit(); i++ )
        {
        }
        
        
        // TODO (fix) simplify
        if (i < this.positions.length)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}
