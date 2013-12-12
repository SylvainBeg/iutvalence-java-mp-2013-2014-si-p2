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
            System.out.println("J1");
            player1ShipsConfigurator.addShip(2);
            player1ShipsConfigurator.addShip(3);
            player1ShipsConfigurator.addShip(3);
            player1ShipsConfigurator.addShip(4); 
            player1ShipsConfigurator.addShip(5);
            
            System.out.println("J2");
            player2ShipsConfigurator.addShip(2);
            player2ShipsConfigurator.addShip(3);
            player2ShipsConfigurator.addShip(3);
            player2ShipsConfigurator.addShip(4);
            player2ShipsConfigurator.addShip(5);
            
            for (int i=0; i<player1ShipsConfigurator.getShips().length; i++) // parcours tous els bateaux
            {
                for(int j=0; j<player1ShipsConfigurator.getShips()[i].getPositions().length; j++) // parcours chaque case
                {
                    System.out.println(player1ShipsConfigurator.getShips()[i].getPositions()[j].isHit()); //affiche
                    System.out.println("-->");
                    System.out.println(player1ShipsConfigurator.getShips()[i].getPositions()[j].getPosition().getColumn());
                    System.out.println("|");
                    System.out.println(player1ShipsConfigurator.getShips()[i].getPositions()[j].getPosition().getLine());
                
                    
                }
                System.out.println("OK !! !");
            }
            System.out.println("OK !");
            
            
            
            
            
            System.out.println(player2ShipsConfigurator.getShips()[1].getPositions()[1].isHit()); //affiche
            
            for (int i=0; i<player2ShipsConfigurator.getShips().length; i++) // parcours tous els bateaux
            {
                for(int j=0; j<player2ShipsConfigurator.getShips()[i].getPositions().length; j++) // parcours chaque case
                {
                    System.out.println(player2ShipsConfigurator.getShips()[i].getPositions()[j].isHit()); //affiche
                    System.out.println("-->");
                }
                System.out.println("OK !! !");
            }
            System.out.println("OK !");
            
            
            
            
            
            
            
            
            
            
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
