package fr.iutvalence.java.mp.Battleship;

import java.util.Scanner;

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
            e.printStackTrace();
        }

        Battle game = new Battle(player1ShipsConfigurator.getShips(), player2ShipsConfigurator.getShips());

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose game mode : ");
        System.out.println("1 : play against the computer ");
        System.out.println("2 : simulation of game (computer against computer)");
        int gameMode = sc.nextInt();

        switch(gameMode) 
        {
        case 1:
            winner = game.play();
            if (winner == 1)
            {
                System.out.println("You are the best !! Congratulations ! :)");
            }
            else
            {
                System.out.println("Defeat ...");
            }
            break;
        case 2:
            winner = game.playAuto();
            if (winner == 1)
            {
                System.out.println("Victory of computer 1 !");
            }
            else
            {
                System.out.println("Victory of computer 2 !");
            }
            break;

        }



    }
}
