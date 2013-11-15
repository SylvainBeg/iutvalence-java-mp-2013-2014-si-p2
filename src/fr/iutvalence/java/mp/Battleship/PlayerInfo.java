package fr.iutvalence.java.mp.Battleship;

/**
 * Class represeting data associated to a player (score, ships)
 * @author begous
 *
 */
public class PlayerInfo
{
    /**
     * Player score ; number of enemy ships sunk
     */
    private int score;
    
    /**
     * player ships
     */
    private final Ship[] ships;

    
    /**
     * Creates a new player info instance, with given ship (and a initial score of 0 points)
     * @param ships player ships
     */
    public PlayerInfo(Ship[] ships)
    {
        super();
        this.score = 0;
        this.ships = ships;
    }


    
    /**
     * Getter for ships number
     * @return ships number
     */
    public int getShipsNumber()
    {
        return this.ships.length;
    }
    
    
    /**
     * Getter for player score
     * @return player score
     */
    public int getScore()
    {
        return this.score;
    }

    /**
     * Increments player score with a given amount of points
     * @param amountOfPoints amount of points
     */
    public void incrementScore(int amountOfPoints)
    {
        this.score += amountOfPoints; 
    }
    /**
     * Getter for player ships
     * @return player ships
     */
    public Ship[] getShips()
    {
        return this.ships;
    }

}
