package fr.iutvalence.java.mp.Battleship;

/**
 * Class main which run program
 * 
 * @author begous
 * 
 */
public class Main
{
    /**
     * method main : initialize and run program
     * 
     * @param args
     */

    public static void main(String[] args)
    {
        int winner;

        PlayerShipsConfigurator player1ShipsConfigurator = new PlayerShipsConfigurator();
        PlayerShipsConfigurator player2ShipsConfigurator = new PlayerShipsConfigurator();

        try
        {
            player1ShipsConfigurator.addShip(2);
            player1ShipsConfigurator.addShip(3);
            player1ShipsConfigurator.addShip(3);
            player1ShipsConfigurator.addShip(4);
            player1ShipsConfigurator.addShip(5);

            player2ShipsConfigurator.addShip(2);
            player2ShipsConfigurator.addShip(3);
            player2ShipsConfigurator.addShip(3);
            player2ShipsConfigurator.addShip(4);
            player2ShipsConfigurator.addShip(5);
        }
        catch (TooMuchAttemptsException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Battle game = new Battle(player1ShipsConfigurator.getShips(), player2ShipsConfigurator.getShips());
        winner = game.play();

        if (winner == 1)
        {
            System.out.println("Tu as gagné !!.");
        }
        else
        {
            System.out.println("Dommage, tu as perdu ...");
        }

    }
}
