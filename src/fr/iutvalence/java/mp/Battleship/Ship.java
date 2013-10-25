package fr.iutvalence.java.mp.Battleship;

import java.util.Random;


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
    // TODO FIXED rename field (more explicit)
    private ShipArea[] array;
    
    // TODO FIXED detail comment (how is the ship once created?)
    /**
     * Initialize a ship then created by locationShip()
     */
    // TODO FIXED rename parameter(this is not a ship)
    public Ship()
    {
    }
    
    /**
     * Research if targeted area is contained in the ship and if yes, touched it
     * @param  c  coordinate of targeted area
     * @return true if ship is hit, else false (coordinate not found in the ship) 
     */
    // TODO FIXED comply with naming conventions
    // TODO FIXED rename method (Is...)
    public boolean isHitArea(Coordinates c)
    {
        int i = 0;
        while (i < this.array.length && this.array[i].getCouple() != c)
        {
            i = i+1;
        }
        
        if (i < this.array.length)
        {
            this.array[i].setHit(true);
            return true;
        }
        // TODO (fix) simplify
        else
        {
            return false;
        }
    }
    
    
    /** place a ship in the grid
     * @param n :area number of ship to create
     * @return array which represents a ship which can be create
     */
    public void locationShip(int n)
    {
        Random r = new Random();
        int position = r.nextInt(1); // 0 : horizontal and 1 : vertical
        int x;
        int y;
        int i = 0;
        Coordinates couple;
        ShipArea[] ship = new ShipArea[n];
        
        if (position == 0)
        {
            x = 1 + r.nextInt(10 - (n-1));
            y = 1 + r.nextInt(10);
            couple = new Coordinates(x, y);
            while (i < n)
            {
                ship[i] = new ShipArea(couple);
                i = i+1;
                x=x+1;
                couple = new Coordinates(x, y);
            }
            this.array = ship;
        }
        else
        {
            x = r.nextInt(9);
            y = 1 + r.nextInt(10 - (n-1));
            couple = new Coordinates(x, y);
            while (i < n)
            {
                ship[i] = new ShipArea(couple);
                i = i+1;
                y=y+1;
                couple = new Coordinates(x, y);
            }
            this.array = ship;
        }
    }
    
    
}
