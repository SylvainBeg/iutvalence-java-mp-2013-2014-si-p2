package fr.iutvalence.java.mp.Battleship;

import java.util.Random;

/**
 * Manage location of a ship for one player
 * @author begous
 *
 */
public class PlayerLocationShip
{

    /**
     * player ship
     */
    private Ship ships[];

    
   /**
    * Creates ships of a player
    */
    public PlayerLocationShip()
    {       
        this.ships = new Ship[Battle.DEFAULT_NUMBER_OF_SHIPS];

    }
    
    /**
     * return player ships
     * @return player ships
     */
    public Ship[] getShips()
    {
        return this.ships;
    }
   
    
    /**
     * place a ship in the grid
     * 
     * @param shipSize
     *            :area number of ship to create
     * @return ship : a ship area array (ready to be place in the grid )
     * @throws TooMuchAttemptsException : exception throws if we have try too much attempts to place a ship
     */
    public Ship addShip(int shipSize) throws TooMuchAttemptsException
    {
        Random r = new Random();
        
        // TODO FIXED declare hard-coded values as constant (not as local variables)
        
        
        int direction = r.nextInt(1); // 0 : horizontal and 1 : vertical
        
        ShipArea[] ship = new ShipArea[shipSize];
       
        Ship constructingShip;
        
        for ( int attempt = 0; attempt < Battle.MAXIMAL_ATTEMPT; attempt++)
        {
            
            Coordinates position = null;
            // location of the first area
                
            int x = 1 + r.nextInt(Battle.DEFAULT_GRID_SIZE - shipSize);
            int y = 1 + r.nextInt(Battle.DEFAULT_GRID_SIZE - 1);
            if ( x < 0 && x > Battle.DEFAULT_GRID_SIZE && y < 0 && y > Battle.DEFAULT_GRID_SIZE)  continue;

            if (direction == Battle.POSITION_VERTICAl)
            {
                int t;
                t=x;
                x=y;
                y=t;
            }
            
            position = new Coordinates(x, y);
            ship[0] = new ShipArea(position);
            
            // construction of ship
            int cursor = 1;
            while (cursor < shipSize)
            {
                ship[cursor] = new ShipArea(position);
                cursor = cursor + 1;
                if (direction == Battle.POSITION_VERTICAl)
                {
                    x = x + 1;
                }
                else 
                {
                   y = y + 1;
                }
                position = new Coordinates(x, y);
            }
                                              
            constructingShip = new Ship(ship);      
              
           if (!shipCanBePlace(constructingShip))
           {
               return constructingShip;
           }
       }   
       
        throw new TooMuchAttemptsException();
        
    }
        
    
    
    // TODO FIXED rename method (more explicit)
    /**
     * Check if all positions of a ship at place are free or not.
     * @param shipAtPlace ; it's a ship at place
     * @return it can be placed or not (all positions are free)
     */
    private boolean shipCanBePlace(Ship shipAtPlace)
    {
        int i;
        for (i=0; i<shipAtPlace.getPositions().length; i++)
        {
            for (int j=0; j < this.ships.length; j++  )
            {
                for (int k=0; k < this.ships[j].getPositions().length; k++)
                {
                    if (shipAtPlace.getPositions()[i].getPosition() ==  
                                 this.ships[j].getPositions()[k].getPosition())
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
