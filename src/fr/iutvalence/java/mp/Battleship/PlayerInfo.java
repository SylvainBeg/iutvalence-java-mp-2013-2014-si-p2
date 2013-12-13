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
    public int getNumberOfShips()
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
    
    /**
     * Print the positions of ships
     */
    public void printShips()
    {
        for (int ship=0; ship<this.ships.length; ship++)
        {
            int shipNumber = ship+1;
            System.out.println("Ship "+shipNumber);
            this.ships[ship].printShip();
            
        }
       
    }
    
    /**
     * Print game grid which represents player ships
     */
    public void printGridWithPlayerShips()
    {
        System.out.println("         1    2    3    4    5    6    7     8    9    10");
        System.out.println("        ");
        for (int line=0; line<10; line++)
        {
            int[] area = new int[Battle.DEFAULT_GRID_SIZE];
            for (int column =0; column<10; column++)
            {
                Coordinates areaCurrent = new Coordinates(column+1,line+1);
                try
                {
                    if (isShipInArea(areaCurrent))
                    {
                        area[column] = 1;
                    }
                    else
                    {
                        area[column] = 0;
                    }
                }
                catch (BadCoordinatesException e) 
                { 
                }
 
            }
            int lineNumber = line+1;
            System.out.println(lineNumber+" |      "+area[0]+"     "+ area[1]+"    " + area[2]+"    " + area[3]+"    " + area[4]+"    " + area[5]+"    " + area[6]+"    " + area[7]+"    " + area[8]+"    " + area[9]);
        }
       
    }
    
    

    
    /**
     * 
     * @param c : area position to test
     * @return area hit or not
     * @throws BadCoordinatesException
     */
    public boolean isShipInArea(Coordinates c)  throws BadCoordinatesException
    {
        if ( c.getColumn() < 0 && c.getColumn() > Battle.DEFAULT_GRID_SIZE && c.getLine() < 0 && c.getLine() > Battle.DEFAULT_GRID_SIZE)
            throw new BadCoordinatesException();
        
        for (int i =0; i<this.ships.length; i++)
        {
            for (int j=0; j < this.ships[i].getPositions().length; j++ )
            {
                if (this.ships[i].getPositions()[j].getPosition().getColumn() == c.getColumn() && this.ships[i].getPositions()[j].getPosition().getLine() == c.getLine())
                {
                    return true;
                }
            }
        }
        return false;         
    }

    

}
