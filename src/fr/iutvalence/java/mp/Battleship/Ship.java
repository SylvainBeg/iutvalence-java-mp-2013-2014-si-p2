package fr.iutvalence.java.mp.Battleship;

import java.util.Random;

// TODO  FIXED detail comment, it is not understandable as is
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
    // TODO FIXED rename field (more explicit with regards to the game)
    private ShipArea[] boat;

    // TODO FIXED rewrite comment (how is the ship once created?)
    /**
     * Initialize a ship with a ship area array (ship free in the grid) in parameter
     * @param ship : a ship (ship area array) ready to be place
     */
    public Ship(ShipArea[] ship)
    {
        // TODO FIXED  all fields must be initialized       
        this.boat = ship;
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
        int i = 0;
        while (i < this.boat.length && this.boat[i].getPosition() != c)
        {
            i = i + 1;
        }

        if (i < this.boat.length)
        {
            this.boat[i].setHit(true);
            return true;
        }
        // TODO (fix) simplify
        else
        {
            return false;
        }
    }

    
    /**
     * Research if a ship is sank : if all ship areas are hit.
     * @return ship condition (sank or not)
     */
    public boolean SankShip()
    {  
        int i =0;
        
        while (i < this.boat.length && this.boat[i].isHit() )
        {
                i = i+1;
        }
        
        if (i < this.boat.length)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}
