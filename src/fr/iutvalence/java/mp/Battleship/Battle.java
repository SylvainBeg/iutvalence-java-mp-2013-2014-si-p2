package fr.iutvalence.java.mp.Battleship;

import java.util.Random;

/**
 * This class represents a new naval battle game.
 * @author begous
 *
 */

public class Battle
{
    /**
     * Default number of ships
     */
    public final static int DEFAULT_NUMBER_OF_SHIPS = 5;
    
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
     * player ship list
     */
    private Ship[] arrayShip;
    
   /* 
    /**
     *  Player 1 grid with player1Grid[0][0] : area A1
     * each area contains a number which defines its condition
     * 0 : empty and not hit
     * 1 : contains ship and not hit
     * 2 : empty and hit
     * 3 : contains ship and hit
     *
    private int[][] player1Grid;
    
    /**
     *  Player 2 grid with player1Grid[0][0] : area A1
     *
    private int[][] player2Grid;
    */
    
    
    // TODO FIXED initial field values should be set in constructors
    /**
     * Begin a game
     */
    public Battle()
    {
        this.numberOfTurns = 0;
        
        this.player1Score = 0;
        this.player2Score = 0;
        
        

        
        
        
        /*this.player1Grid = new int[Battle.GRID_LENGTH][Battle.GRID_LENGTH] ; 
        this.player2Grid =  new int[Battle.GRID_LENGTH][Battle.GRID_LENGTH] ;
        */
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
    
   
    
    // TODO fixed the class Battle should have **** only one public method **** called "play"

    
    public void play()
    {

      
        
    }
    
    /**
     * 
     * Research in ships the targeted area. Target the ship with Ship.isHitArea and update ship
     * @param  c  coordinate of targeted area
     * @return true if coordinate found and so sip hit, else false (coordinate not found in the ship) 
     */
    public boolean isHitShip(Coordinates c)
    {
        
    }
    
    
    
    
    
    
}
