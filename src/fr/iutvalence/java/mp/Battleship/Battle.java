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
    private final static int DEFAULT_GRID_SIZE = 10;

    /**
     * Player 1 score ; number of ships sank at player 2
     */
    private int player1Score;

    /**
     * Player 2 score ; number of ships sank at player 1 ; computer or human ?
     */
    private int player2Score;

    /**
     * Number of turns 
     */
    private int numberOfTurns;

    /**
     * player 1 ship list
     */
    private Ship[] Player1Ship;

    /**
     * player 2 ship list
     */
    private Ship[] Player2Ship;
    
    /**
     * Initialize a game (initialize scores and turn number)
     */
    public Battle()
    {
        this.numberOfTurns = 0;

        this.player1Score = 0;
        this.player2Score = 0;

        /*
         * this.player1Grid = new int[Battle.GRID_LENGTH][Battle.GRID_LENGTH] ;
         * this.player2Grid = new int[Battle.GRID_LENGTH][Battle.GRID_LENGTH] ;
         */
    }

    /**
     * return player 1 score
     * 
     * @return player 1 score
     */
    private int getPlayer1Score()
    {
        return this.player1Score;
    }

    /**
     * return player 2 score
     * 
     * @return player 2 score
     */
    private int getPlayer2Score()
    {
        return this.player2Score;
    }

    /**
     * return turn number
     * 
     * @return turn number
     */
    private int getNumberOfTurns()
    {
        return this.numberOfTurns;
    }

    /**
     * Add a turn
     */
    private void updateTurn()
    {
        this.numberOfTurns = this.numberOfTurns + 1;
    }

    /**
     * When the player 1 sink ship at player 2
     */
    private void updatePlayer1Score()
    {
        this.player1Score = this.player1Score + 1;
    }

    /**
     * When the player 2 sink ship at player 1
     */
    private void updatePlayer2Score()
    {
        this.player2Score = this.player2Score + 1;
    }
    
    public void play()
    {

    }

    /**
     * 
     * Research in ships the targeted area. If it contains in a ship, we target the ship with Ship.isHitArea
     * and update ship
     * 
     * @param position  position of targeted area
     * @param playerNumber : number of player which is targeted
     * @return result of hit : 
     *      0 : Missed  position not found in ships
     *      1 : Touched  : position found (and so ship hit and update)
     *      2 : touched and sunk : position found (and so ship hit and update) and all areas are touched
     */
    
    // Revoir avec les exceptions
    
    private int isShipHit(Coordinates position, int playerNumber)
    {
        int i = 0;
     
        // TODO (think about it) you can reduce redundant code by 
        // using a better data structure for player ships         
        if (playerNumber == 1) // target player 1
        {
            while (i < this.Player1Ship.length  && !this.Player1Ship[i].isHitAt(position))
            {
                i=i+1;
            }
            if (i < this.Player1Ship.length)
            {
                if (this.Player1Ship[i].isShipSunk() )
                {
                    this.updatePlayer2Score();
                    return 2;  // Touched and sank
                }
                // TODO (fix) declare hard-coded values as constants
                return 1; // Touched
            }
            else
            {
                return 0;  // Missed
            }
        }
        else    // target player 2
        {
            while (i < this.Player2Ship.length && !this.Player2Ship[i].isHitAt(position))
            {
                i=i+1;
            }
            if (i < this.Player2Ship.length)
            {
                if (this.Player2Ship[i].isShipSunk() )
                {
                    this.updatePlayer1Score() ;
                    return 2;  // Touched and sank
                }
                return 1; // Touched
            }
            else
            {
                return 0;  // Missed
            }
        }
    }
    
    
    /**
     * place a ship in the grid
     * 
     * @param shipSize :area number of ship to create
     * @return ship : a ship area array  (ready to be place in the grid )
     */
    private ShipArea[] locationShip(int shipSize)
    {
        Random r = new Random();
        // TODO FIXED rename variable (this is not a position)
        int direction = r.nextInt(1); // 0 : horizontal and 1 : vertical
        int x;
        int y;
        
        // TODO FIXED rename variable
        int cursor = 0;
        // TODO FIXED rename variable
        Coordinates position;
        ShipArea[] ship = new ShipArea[shipSize];

        // TODO FIXED declare hard-coded values as constants
        if (direction == 0)
        {
            x = 1 + r.nextInt(DEFAULT_GRID_SIZE -shipSize);
            y = 1 + r.nextInt(DEFAULT_GRID_SIZE-1);
            position = new Coordinates(x, y);
            while (cursor < shipSize)
            {
                ship[cursor] = new ShipArea(position);
                cursor = cursor + 1;
                x = x + 1;
                position = new Coordinates(x, y);
            }
            return ship;
        }
        else
        {
            x = 1 + r.nextInt(DEFAULT_GRID_SIZE-1);
            y = 1 + r.nextInt(DEFAULT_GRID_SIZE - shipSize);
            position = new Coordinates(x, y);
            while (cursor < shipSize)
            {
                ship[cursor] = new ShipArea(position);
                cursor = cursor + 1;
                y = y + 1;
                position = new Coordinates(x, y);
            }
            return ship;
        }
    }
    
    /**
     * research if a game is won by a player : if player 1 is targeted then we analyze player 2 score (and inversely)
     * @param nbPlayer : number of player which come to touch a ship
     * @return boolean : game condition : game won or not by a player (nbPlayer) : all adverse player ships are sank
     */
    private boolean isGameWon(int nbPlayer)
    {
        if (nbPlayer == 1)
        {
            // TODO (fix) simplify
            if (Battle.DEFAULT_NUMBER_OF_SHIPS - this.player1Score == 0)
            {
                return true;
            }
            return false;
        }
        else
        {
            // TODO (fix) simplify
            if (Battle.DEFAULT_NUMBER_OF_SHIPS - this.player2Score == 0)
            {
                return true;
            }
            return false;
        }
    }
}
