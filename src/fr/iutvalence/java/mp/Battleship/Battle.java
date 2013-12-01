package fr.iutvalence.java.mp.Battleship;

import java.util.Random;

/**
 * This class represents a new naval battle game.
 * 
 * @author begous
 * 
 */
public class Battle
{
    /**
     * Default number of ships
     */
    private final static int DEFAULT_NUMBER_OF_SHIPS = 5;

    /**
     * Default size of grid
     */
    public final static int DEFAULT_GRID_SIZE = 10;

    // TODO (fix) this should not be declared as a field (it seems to be a local variable)
    /**
     * Number of turns
     */
    private int numberOfTurns;

    /**
     * Informations about players
     */
    private PlayerInfo[] players;

    /**
     * Initialize a game (initialize scores and turn number)
     * 
     * @param shipsP1
     *            player 1 ships to create
     * @param shipsP2
     *            player 2 ships to create
     */
    public Battle(Ship[] shipsP1, Ship[] shipsP2)
    {
        this.numberOfTurns = 0;
        this.players[1] = new PlayerInfo(shipsP1);
        this.players[2] = new PlayerInfo(shipsP2);
    }

    // TODO (fix) remove this (useless)
    /**
     * return turn number
     * 
     * @return turn number
     */
    private int getNumberOfTurns()
    {
        return this.numberOfTurns;
    }

    // TODO (fix) remove this (useless)
    /**
     * Add a turn
     */
    private void updateTurn()
    {
        this.numberOfTurns = this.numberOfTurns + 1;
    }

    public void play()
    {

    }
    

    // TODO (fix) finish writing comment (exception), and rewrite it (unclear)
    /**
     * 
     * Research in ships the targeted area. If it contains in a ship, we target
     * the ship with Ship.isHitArea and update ship
     * 
     * @param position
     *            position of targeted area
     * @param playerNumber
     *            : number of player which is targeted
     * @return result of hit : 0 : Missed position not found in ships 
     *      1 : Touched : position found (and so ship hit and update) 
     *      2 : touched and sunk : position found (and so ship hit and update) 
     *        and all areas are touched
     * @throws BadCoordinatesException 
     */
    // TODO (fix) rename this method (it is much more related to the processing of one shot)
    private int isShipHit(Coordinates position, int playerNumber) throws BadCoordinatesException 
    {
        // TODO (fix) declare constants instead of using these local variables
        int missed = 0;
        int touched = 1;
        int touchedAndSunk = 2;
        
        for (int i = 0; i < this.players[playerNumber].getNumberOfShips(); i++)
        {
                    
            if (this.players[playerNumber].getShips()[i].isHitAt(position))
            {
                if (this.players[playerNumber].getShips()[i].isShipSunk())
                {
                    this.players[playerNumber].incrementScore(1);
                                     
                    return touchedAndSunk;
                }
                return touched;
            }
        }
        return missed;   
    }

    /**
     * place a ship in the grid
     * 
     * @param shipSize
     *            :area number of ship to create
     * @param playerNumber : number of player  which ship is location
     * @return ship : a ship area array (ready to be place in the grid )
     */
    private Ship locationShip(int shipSize, int playerNumber) throws TooMuchAttemptsException
    {
        Random r = new Random();
        
        // TODO (fix) declare hard-coded values as constant (not as local variables)
        int vertical = 1;
        
        int maximaleAttempt = 15;
        
        int direction = r.nextInt(1); // 0 : horizontal and 1 : vertical
        
        ShipArea[] ship = new ShipArea[shipSize];
       
        Ship constructingShip;
        
        for ( int attempt = 0; attempt < maximaleAttempt; attempt++)
        {
            
            Coordinates position = null;
            // location of the first area
                
            int x = 1 + r.nextInt(DEFAULT_GRID_SIZE - shipSize);
            int y = 1 + r.nextInt(DEFAULT_GRID_SIZE - 1);
            if ( x < 0 && x > Battle.DEFAULT_GRID_SIZE && y < 0 && y > Battle.DEFAULT_GRID_SIZE)  continue;

            if (direction == vertical)
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
                if (direction == vertical)
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
              
           if (!freeLocation(constructingShip, playerNumber))
           {
               return constructingShip;
           }
       }   
       
        throw new TooMuchAttemptsException();
        

    }
        
    // TODO (fix) rename method (more explicit)
    /**
     * Check if all positions of a ship at place are free or not.
     * @param shipAtPlace ; it's a ship at place
     * @param playerNumber : number of player which want to place a ship
     * @return it can be placed or not (all positions are free)
     */
    private boolean freeLocation(Ship shipAtPlace, int playerNumber)
    {
        int i;
        for (i=0; i<shipAtPlace.getPositions().length; i++)
        {
            for (int j=0; j < this.players[playerNumber].getShips().length; j++  )
            {
                for (int k=0; k < this.players[playerNumber].getShips()[j].getPositions().length; k++)
                {
                    if (shipAtPlace.getPositions()[i].getPosition() ==  
                                 this.players[playerNumber].getShips()[j].getPositions()[k].getPosition())
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    
    /**
     * research if a game is won by a player : if player 1 is targeted then we
     * analyze player 2 score (and inversely)
     * 
     * @param nbPlayer
     *            : number of player which come to touch a ship
     * @return boolean : game condition : game won or not by a player (nbPlayer)
     *         : all adverse player ships are sank
     */
    private boolean isGameWon(int nbPlayer)
    {
        // TODO (fix) simplify
        if (Battle.DEFAULT_NUMBER_OF_SHIPS  == this.players[nbPlayer].getScore())
        {
            return true;
        }
        return false;

    }
}
