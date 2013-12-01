package fr.iutvalence.java.mp.Battleship;


/**
 * A Ship is an array of ShipArea :  a ship is divided in several part 
 * @author begous
 * 
 */
public class Ship 
{
    /**
     * Positions : contain area ship (in order or in disorder)
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
     * Getter for positions (a ship)
     * @return positions
     */
    public ShipArea[] getPositions()
    {
        return this.positions;
    }

    // TODO (fix) finish writing comment (exception)
    /**
     * Research if targeted area is contained in the ship and if yes, touched it
     * 
     * @param c  coordinate of targeted area
     * @return true if ship is hit, else false (coordinate not found in the ship)
     * @throws BadCoordinatesException 
     */
    public boolean isHitAt(Coordinates c)  throws BadCoordinatesException
    {
        if ( c.getColumn() < 0 && c.getColumn() > Battle.DEFAULT_GRID_SIZE && c.getLine() < 0 && c.getLine() > Battle.DEFAULT_GRID_SIZE)
            throw new BadCoordinatesException();
        
        for (int i=0; i < this.positions.length; i++ )
        {
            if (this.positions[i].getPosition() == c)
            {
                this.positions[i].setHit(true);
                return true;
            }
        }
        return false;
    }

    
    /**
     * Research if a ship is sunk : if all ship areas are hit.
     * @return ship condition (sank or not)
     */
    public boolean isShipSunk()
    {         
        for (int i=0; i < this.positions.length; i++ )
        {
            if (!this.positions[i].isHit())
            {
                return false;
            }
        }
        return true;
    }

}
