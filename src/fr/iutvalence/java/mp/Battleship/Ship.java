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
     * Indicate if ship is already sunk or not
     */
    private boolean shipSunk;

    /**
     * Initialize a ship with a ship area array (ship free in the grid) in parameter
     * @param ship : a ship (ship area array) ready to be place
     */
    public Ship(ShipArea[] ship)
    {       
        this.positions = ship;
        this.shipSunk = false;
    }

    /**
     * Getter for positions (a ship)
     * @return positions
     */
    public ShipArea[] getPositions()
    {
        return this.positions;
    }

    /**
     * Indicate if ship is already sunk or not
     * @return if ship is already sunk or not
     */
    public boolean getIfShipSunk()
    {
        return this.shipSunk;
    }


    
    
    // TODO FIXED finish writing comment (exception)
    /**
     * Research if targeted area is contained in the ship and if yes, touched it
     * 
     * @param c  coordinate of targeted area
     * @return true if ship is hit, else false (coordinate not found in the ship)
     * @throws BadCoordinatesException : exception throws if coordinates are not in the grid
     */
    public boolean isHitAt(Coordinates c)  throws BadCoordinatesException
    {
        if ( c.getColumn() < 0 && c.getColumn() > Battle.DEFAULT_GRID_SIZE && c.getLine() < 0 && c.getLine() > Battle.DEFAULT_GRID_SIZE)
            throw new BadCoordinatesException();
        
        for (int i=0; i < this.positions.length; i++ )
        {
            if (this.positions[i].getPosition().getColumn() == c.getColumn() && this.positions[i].getPosition().getLine() == c.getLine())
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
    
    
    /**
     * Ship become in sunk mode
     */
    public void updateShipSunk()
    {         
        this.shipSunk = true;
    }
    
    
    
    /**
     * Research if there is overlaps with the ship in parameter 
     * @param otherShip : ship which will be to compare
     * @return true if the two ships overlap
     */
    public boolean overlapsShip(Ship otherShip)
    {
      
        for (int thisShipPositionIndex = 0; thisShipPositionIndex < this.getPositions().length; thisShipPositionIndex++)
        {
            Coordinates thisPosition = this.getPositions()[thisShipPositionIndex].getPosition();
            
            for (int otherShipPositionIndex = 0; otherShipPositionIndex < otherShip.getPositions().length; otherShipPositionIndex++)
            {
                
                Coordinates otherPosition = otherShip.getPositions()[otherShipPositionIndex].getPosition();
                        
                if ((thisPosition.getColumn() == otherPosition.getColumn()) && (thisPosition.getLine() == otherPosition.getLine())) return true;
            }
        }
        return false;
    }
    
    /**
     * Print the positions of ship
     */
    public void printShip()
    {
        
        for (int cursor=0; cursor<this.positions.length; cursor++)
        {
            int x = this.positions[cursor].getPosition().getColumn();
            int y = this.positions[cursor].getPosition().getLine();
            System.out.println("    ("+x+";"+y+")");
        }
    }

}
