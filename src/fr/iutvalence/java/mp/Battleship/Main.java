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
        
        PlayerLocationShip player1 = new PlayerLocationShip();
        PlayerLocationShip player2 = new PlayerLocationShip();
        

        try{
            player1.getShips()[0] = player1.addShip(2);
            player1.getShips()[1] = player1.addShip(3);
            player1.getShips()[2] = player1.addShip(3);
            player1.getShips()[3] = player1.addShip(4);
            player1.getShips()[4] = player1.addShip(5);
            
            player2.getShips()[0] = player2.addShip(2);
            player2.getShips()[1] = player2.addShip(3);
            player2.getShips()[2] = player2.addShip(3);
            player2.getShips()[3] = player2.addShip(4);
            player2.getShips()[4] = player2.addShip(5);
            
            Battle game = new Battle(player1.getShips(), player2.getShips());  
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
        catch (TooMuchAttemptsException e) {
            System.out.println("Erreur, impossible de placer l'ensemble des bateaux.");
        }

    }
}
