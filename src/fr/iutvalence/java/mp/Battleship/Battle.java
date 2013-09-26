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
     * Player 1 score
     */
    public Score scorePlayer1;

    // FIXED TODO (think about it) does it makes sense to let the visibility as public ?
    // FIXED TODO (think about it) the game can only be played by an IA and a human ?
    /**
     * Player 2 score : computer or human 
     */
    public Score scorePlayer2;
    
    
    // TODO FIXED rename field
    /**
     * Number of turns
     */
    public int nbTurn;
    
    /**
     * Default number of battle 
     */
    public final static int Battle_DEFAUT = 5;
    
    // TODO (fix) initial field values should be set in constructors
    /**
     * Begin a game
     */
    public Battle()
    {
        this.nbTour = 0;
        this.scorePlayer1.nbShipAlive = Battle.Battle_DEFAUT;
        this.scorePlayer1.nbShipDead = 0;
        this.scorePlayer2.nbShipAlive = Battle.Battle_DEFAUT;
        this.scorePlayer2.nbShipDead = 0;
    }
    
    /**
     * Restart a game
     */
    public void restart()
    {
    }
    
    /**
     * Exit a game
     */
    public void exit()
    {
    }
}
