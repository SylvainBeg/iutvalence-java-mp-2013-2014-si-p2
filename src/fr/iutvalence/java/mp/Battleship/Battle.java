package fr.iutvalence.java.mp.Battleship;

import java.util.Random;

/**
 * It's a session. That represents a new game.
 * @author begous
 *
 */

public class Battle
{
    /**
     * Default number of ship 
     */
    private final static int DEFAULT_SHIPS_AMOUNT = 5;
    
    // TODO FIXED comply with naming conventions
    // TODO FIXED move constants declarations before fields
    /**
     * Default length of grid
     */
    private final static int GRID_LENGTH = 10;
    
    
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
     *  Player 1 grid with player1Grid[0][0] : area A1
     * each area contains a number which defines its condition
     * 0 : empty and not hit
     * 1 : contains ship and not hit
     * 2 : empty and hit
     * 3 : contains ship and hit
     */
    private int[][] player1Grid;
    
    /**
     *  Player 2 grid with player1Grid[0][0] : area A1
     */
    private int[][] player2Grid;
    
    
    
    // TODO FIXED initial field values should be set in constructors
    /**
     * Begin a game
     */
    public Battle()
    {
        this.numberOfTurns = 0;
        this.player1Score = 0;
        this.player2Score = 0;
        
        // TODO (fix) Javadoc comment are not allowed inside methods
        /**
         * Player 1 grid with player1Grid[0][0] : area A1
         * each area contains a number which defines its condition
         */
        // TODO (fix) simplify
        int player1Grid[][] = new int[Battle.GRID_LENGTH][Battle.GRID_LENGTH] ; 
        
        this.player1Grid = player1Grid;
        
        // TODO (fix) Javadoc comment are not allowed inside methods 
        /**
         * Player 2 grid with player2Grid[0][0] : area A1
         * each area contains a number which defines its condition
         */
        // TODO (fix) simplify
        int player2Grid[][] = new int[Battle.GRID_LENGTH][Battle.GRID_LENGTH] ;
        
        this.player2Grid = player2Grid;
    }
    
    /**
     * return player 1 score
     * @return player 1 score
     */
    public int getPlayer1Score()
    {
        return this.player1Score;
    }
    
    /**
     * return player 2 score
     * @return player 2 score
     */
    public int getPlayer2Score()
    {
        return this.player2Score;
    }
    
    /**
     * return turn number
     * @return turn number
     */
    public int getNumberOfTurns()
    {
        return this.numberOfTurns;
    }
    
    /**
     * Add a turn
     */
    public void updateTurn()
    {
        this.numberOfTurns = this.numberOfTurns +1;
    }
    
    // TODO (fix) let the constant be public and remove his getter
    /**
     * return ships default number, in order to calculate number of ships alive
     * @return ships default number
     */
    public int getShips_DEFAUT()
    {
        return  Battle.DEFAULT_SHIPS_AMOUNT;
    }
    
    /**
     * When the player 1 sink ship at player 2
     */
    public void updatePlayer1Score()
    {
        this.player1Score = this.player1Score +1;
    }
    
    /**
     * When the player 2 sink ship at player 1
     */
    public void updatePlayer2Score()
    {
        this.player2Score = this.player2Score +1;
    }
    
    /**
     * fill area : a ship contains this area
     * @param x : line number
     * @param y : column number
     * @param player : grid number to modify
     */
    public void location(int x, int y, int player)
    {
        if (player == 1)
        {
            this.player1Grid[x][y] = 1;
        }
        else 
        {
            this.player2Grid[x][y] = 1;
        }
    }
    
    /**
     * An area is hit
     * @param x : line number
     * @param y : column number
     * @param player : grid number to modify
     */
    public void areaHit(int x, int y, int player)
    {
        
        if (player == 1)
        {
            if (this.player1Grid[x][y] != 1)
            {
                this.player1Grid[x][y] = 2;
            }
            else 
            {
                this.player2Grid[x][y] = 3;
            }
        }
        else
        {    
            if (this.player2Grid[x][y] != 1)
            {
                this.player2Grid[x][y] = 2;
            }
            else 
            {
                this.player2Grid[x][y] = 3;
            } 
        }
    }
 
    
    // TODO (fix) the class Battle should only have one public  method called "play"
    /**
     * The main : execute the program
     * @param args
     */
    public void play()
    {
        Random r = new Random();
        int x;
        int y;
        
        ShipArea ship[] = new ShipArea[1];

      
        
    }
    
    
    
    
    
    
    
    
    
}
