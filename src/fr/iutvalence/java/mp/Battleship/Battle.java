package fr.iutvalence.java.mp.Battleship;

import java.util.Random;

/**
 * It's a session. That represents a new game.
 * @author begous
 *
 */

public class Battle
{
    
    // TODO FIXED move constants declarations before fields
    // TODO FIXED fix comment
    /**
     * Default number of ship 
     */
    private final static int SHIPS_DEFAULT = 5;
    
    // TODO FIXED comply with naming conventions
    // TODO FIXED move constants declarations before fields
    /**
     * Default length of grid
     */
    private final static int GRID_LENGTH = 10;
    
    
    /**
     * Player 1 score ; number of ships sank at player 2 
     */
    private int scorePlayer1;

    /**
     * Player 2 score ; number of ships sank at player 1 ; computer or human ?
     */
    private int scorePlayer2;
    
    
    // TODO (fix) rename field
    /**
     * Number of turns
     */
    private int nbTurn;
    
    
    /**
     *  Player 1 grid with player1Grid[0][0] : area A1
     * each area contains a number which defines its condition
     * 0 : empty and not hit
     * 1 : contains ship and not hit
     * 2 : empty and hit
     * 3 : contains ship and hit
     */
    private int[][] grid1;
    
    /**
     *  Player 2 grid with player1Grid[0][0] : area A1
     */
    private int[][] grid2;
    
    
    
    // TODO FIXED initial field values should be set in constructors
    /**
     * Begin a game
     */
    public Battle()
    {
        this.nbTurn = 0;
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
        
     // TODO FIXED initialize fields in constructors only
        /**
         * Player 1 grid with player1Grid[0][0] : area A1
         * each area contains a number which defines its condition
         */
        int player1Grid[][] = new int[Battle.GRID_LENGTH][Battle.GRID_LENGTH] ; 
        
        this.grid1 = player1Grid;
        
        
        /**
         * Player 2 grid with player2Grid[0][0] : area A1
         * each area contains a number which defines its condition
         */
        int player2Grid[][] = new int[Battle.GRID_LENGTH][Battle.GRID_LENGTH] ;
        
        this.grid2 = player2Grid;
    }
    
    
    
    
    /**
     * return player 1 score
     * @return player 1 score
     */
    public int getScorePlayer1()
    {
        return this.scorePlayer1;
    }
    
    /**
     * return player 2 score
     * @return player 2 score
     */
    public int getScorePlayer2()
    {
        return this.scorePlayer2;
    }
    
    /**
     * return turn number
     * @return turn number
     */
    public int getNbTurn()
    {
        return this.nbTurn;
    }
    
    /**
     * Add a turn
     */
    public void updateTurn()
    {
        this.nbTurn = this.nbTurn +1;
    }
    
    /**
     * return ships default number, in order to calculate number of ships alive
     * @return ships default number
     */
    public int getShips_DEFAUT()
    {
        return  Battle.SHIPS_DEFAULT;
    }
    
    /**
     * When the player 1 sink ship at player 2
     */
    public void updateScore1()
    {
        this.scorePlayer1 = this.scorePlayer1 +1;
    }
    
    /**
     * When the player 2 sink ship at player 1
     */
    public void updateScore2()
    {
        this.scorePlayer2 = this.scorePlayer2 +1;
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
            this.grid1[x][y] = 1;
        }
        else 
        {
            this.grid2[x][y] = 1;
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
            if (this.grid1[x][y] != 1)
            {
                this.grid1[x][y] = 2;
            }
            else 
            {
                this.grid2[x][y] = 3;
            }
        }
        else
        {    
            if (this.grid2[x][y] != 1)
            {
                this.grid2[x][y] = 2;
            }
            else 
            {
                this.grid2[x][y] = 3;
            } 
        }
    }
 
    
    // TODO (fix) move the main to another class (called Main for example)
    // TODO (think about it) the class Battle should only have one public  method called "play"
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
