package fr.iutvalence.java.mp.Battleship;

/**
 * It's a session. That represents a new game.
 * @author begous
 *
 */
public class Battle
{
    // TODO (think about it) does it makes sense to let the visibility as public ?
    /**
     * player score
     */
    public Score scorePlayer;

    // TODO (think about it) does it makes sense to let the visibility as public ?
    // TODO (think about it) the game can only be played by an IA and a human ?
    /**
     * Computer score
     */
    public Score scoreComputer;
    
    
    // TODO (fix) rename field
    /**
     * Number of turns
     */
    public int nbTour;
    
    
    
    // TODO (fix) initial field values should be set in constructors
    /**
     * Begin a game
     */
    public void start()
    {
        this.nbTour = 0;
        this.scorePlayer.nbShipAlive = 5;
        this.scorePlayer.nbShipDead = 0;
        this.scoreComputer.nbShipAlive = 5;
        this.scoreComputer.nbShipDead = 0;
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
