package fr.iutvalence.java.mp.Battleship;

/**
 * It's a session. That represents a new game.
 * @author begous
 *
 */
public class Battle
{
    // FIXED TODO (think about it) does it makes sense to let the visibility as public ?
    /**
     * Player 1 score ; number of ships sank at player 2 
     */
    private int scorePlayer1;

    // FIXED TODO (think about it) does it makes sense to let the visibility as public ?
    // FIXED TODO (think about it) the game can only be played by an IA and a human ?
    /**
     * Player 2 score ; number of ships sank at player 1 ; computer or human ?
     */
    private int scorePlayer2;
    
    
    // TODO FIXED rename field
    /**
     * Number of turns
     */
    private int nbTurn;
    
    /**
     * Default number of battle 
     */
    private final static int Ships_DEFAULT = 5;
    
    /**
     * Default length of grid
     */
    private final static int gridLength = 10;
    
    /**
     * Player 1 grid
     */
    private int[][] player1Grid = new Area [Battle.gridLength][Battle.gridLength];
    
    
    
    // TODO (fix) initial field values should be set in constructors
    /**
     * Begin a game
     */
    public Battle()
    {
        this.nbTurn = 0;
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
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
        return  Battle.Ships_DEFAULT;
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
    
    
    
}
