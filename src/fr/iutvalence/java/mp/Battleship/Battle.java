package fr.iutvalence.java.mp.Battleship;

/**
 * It's a session. That represents a new game.
 * @author begous
 *
 */
public class Battle
{
    /**
     * player score
     */
    public Score scorePlayer;
    /**
     * Computer score
     */
    public Score scoreComputer;
    
    /**
     * Number of turns
     */
    public int nbTour;
    
    
    
    
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
