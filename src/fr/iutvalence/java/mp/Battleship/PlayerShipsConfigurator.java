package fr.iutvalence.java.mp.Battleship;

import java.util.Random;

/**
 * Manage location of a ship for one player
 * 
 * @author begous
 * 
 */
public class PlayerShipsConfigurator
{

    /**
     * player ship
     */
    private Ship[] ships;

    /**
     * The number of already placed ship in the game
     */
    private int numberOfAlreadyPlacedShips;

    /**
     * Creates ships of a player
     */
    public PlayerShipsConfigurator()
    {
        this.ships = new Ship[Battle.DEFAULT_NUMBER_OF_SHIPS];
        this.numberOfAlreadyPlacedShips = 0;
    }

    /**
     * return player ships
     * 
     * @return player ships
     */
    public Ship[] getShips()
    {
        return this.ships;
    }



    /**
     * place a ship in the grid
     * 
     * @param shipSize
     *            :area number of ship to create
     * @throws TooMuchAttemptsException
     *             : exception throws if we have try too much attempts to place
     *             a ship
     */
    public void addShip(int shipSize) throws TooMuchAttemptsException
    {
        if (this.numberOfAlreadyPlacedShips == this.ships.length)
            return;

        Random r = new Random();

        // TODO FIXED declare hard-coded values as constant (not as local
        // variables)

        int direction = r.nextInt(2); // 0 : horizontal and 1 : vertical

        for (int attempt = 0; attempt < Battle.MAXIMAL_ATTEMPT; attempt++)
        {

            int x, y;
            if (direction != Battle.POSITION_VERTICAl)
            {
                x = 1 + r.nextInt(Battle.DEFAULT_GRID_SIZE - shipSize + 1);
                y = 1 + r.nextInt(Battle.DEFAULT_GRID_SIZE - 1 +1);
                if (x < 0 && x > Battle.DEFAULT_GRID_SIZE && y < 0 && y > Battle.DEFAULT_GRID_SIZE)
                    continue;
            }
            else
            {
                x = 1 + r.nextInt(Battle.DEFAULT_GRID_SIZE - 1 +1);
                y =  1 + r.nextInt(Battle.DEFAULT_GRID_SIZE - shipSize + 1);
                if (x < 0 && x > Battle.DEFAULT_GRID_SIZE && y < 0 && y > Battle.DEFAULT_GRID_SIZE)
                    continue;
            }


            Coordinates position = null; // location of the first area
            position = new Coordinates(x, y);

            ShipArea[] shipAreas = new ShipArea[shipSize];
            shipAreas[0] = new ShipArea(position);

            // construction of ship
            int cursor = 0;
            while (cursor < shipSize)
            {
                shipAreas[cursor] = new ShipArea(position);
                cursor = cursor + 1;
                if (direction == Battle.POSITION_VERTICAl)
                {
                    y = y + 1;
                }
                else
                {
                    x = x + 1;
                }
                position = new Coordinates(x, y);
            }

            Ship shipToBePlaced = new Ship(shipAreas);

            for (int ship = 0;ship <this.numberOfAlreadyPlacedShips;ship++)
                if (shipToBePlaced.overlapsShip(this.ships[ship]))
                    continue;

            this.ships[this.numberOfAlreadyPlacedShips] = shipToBePlaced;

            this.numberOfAlreadyPlacedShips = this.numberOfAlreadyPlacedShips  +1;
            return;

        }

        throw new TooMuchAttemptsException();

    }

}
