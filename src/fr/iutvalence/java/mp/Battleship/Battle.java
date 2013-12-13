package fr.iutvalence.java.mp.Battleship;

import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a new naval battle game.
 * 
 * @author begous
 * 
 */
public class Battle
{
    /**
     * Default number of ships
     */
    public final static int DEFAULT_NUMBER_OF_SHIPS = 5;

    /**
     * Default size of grid
     */
    public final static int DEFAULT_GRID_SIZE = 10;

    /**
     * result of shot : if any ship is not hit
     */
    private final static int MISSED = 0;

    /**
     * result of shot : if a ship is hit (but not sunk)
     */
    private final static int TOUCHED = 1;

    /**
     * result of shot : if a ship is touched and sunk
     */
    private final static int TOUCHED_AND_SUNK = 2;

    /**
     * indicate that ship position is vertical
     */
    public final static int POSITION_VERTICAl = 1;

    /**
     * number of maximal attempt to test the location of ship
     */
    public final static int MAXIMAL_ATTEMPT = 15;


    /**
     * Informations about players
     */
    private PlayerInfo[] players;


    /**
     * Initialize a game (initialize scores and turn number)
     * 
     * @param shipsP1
     *            player 1 ships to create
     * @param shipsP2
     *            player 2 ships to create
     */
    public Battle(Ship[] shipsP1, Ship[] shipsP2)
    {
        this.players = new PlayerInfo[3];      // voir comment faire ici

        this.players[1] = new PlayerInfo(shipsP1);
        this.players[2] = new PlayerInfo(shipsP2);
    }



    // TODO FIXED finish writing comment (exception), and rewrite it (unclear)
    /**
     * A shot is launched by a player. Return result of shot.
     * For that, we research in ships the targeted area. If at this position there is a ship, then we hit
     * the ship with Ship.isHitArea().
     * 
     * @param position
     *            position of targeted area
     * @param playerNumberTargeted
     *            : number of player who is targeted
     *@param playerNumberTargeter
     *            : number of player who target
     * @return result of hit : MISSED : position not found in ships 
     *       TOUCHED : position found (and so ship hit and update) 
     *       TOUCHED_AND_SUNK : position found (and so ship hit and update) 
     *        and all areas are touched
     * @throws BadCoordinatesException : exception throws if isHitAt() throws an exception (coordinates are not in the grid)
     */
    // TODO FIXED rename this method (it is much more related to the processing of one shot)
    private int shot(Coordinates position, int playerNumberTargeted, int playerNumberTargeter) throws BadCoordinatesException 
    {
        // TODO FIXED declare constants instead of using these local variables

        for (int i = 0; i < this.players[playerNumberTargeted].getNumberOfShips(); i++)
        {

            if (this.players[playerNumberTargeted].getShips()[i].isHitAt(position))
            {
                if (this.players[playerNumberTargeted].getShips()[i].isShipSunk())
                {
                    if (this.players[playerNumberTargeted].getShips()[i].getIfShipSunk())
                    {
                        return MISSED;   // ship already sunk
                    }
                    else
                    {
                        this.players[playerNumberTargeter].incrementScore(1);
                        this.players[playerNumberTargeted].getShips()[i].updateShipSunk();
                        return TOUCHED_AND_SUNK;
                    }
                }
                return TOUCHED;
            }
        }

        return MISSED;   
    }





    /**
     * research if a game is won by a player : if player 1 is targeted then we
     * analyze player 2 score (and inversely)
     * 
     * @param nbPlayer
     *            : number of player which come to touch a ship
     * @return boolean : game condition : game won or not by a player (nbPlayer)
     *         : all adverse player ships are sank
     */
    private boolean isGameWon(int nbPlayer)
    {
        // TODO (fix) simplify
        if (Battle.DEFAULT_NUMBER_OF_SHIPS  == this.players[nbPlayer].getScore())
        {
            return true;
        }
        return false;

    }




    /**
     * Launch the game (player against computer)
     * @return player number who win
     */
    public int play()
    {
        Scanner sc = new Scanner(System.in);

        int numberRealPlayer = 1;  // Player who play against computer

        int numberCurrentPlayer = 1; // It's the player1 who start
        int numberAdversePlayer = 2;

        System.out.println("Your ship :");
        this.players[1].printShips();


        System.out.println("                                                                                    *****  Your shot *****");
        System.out.println("                                                                                                                                    ***** Shot adverse *****");


        while (true) {
            if (numberCurrentPlayer == numberRealPlayer)
            {
                int x, y;
                do {
                    System.out.println("Veuillez saisir l'abscisse de la case à viser :");
                    x = sc.nextInt();
                    System.out.println("Veuillez saisir l'ordonnée de la case à viser :");
                    y = sc.nextInt();

                } while (!(x > 0 && x <= Battle.DEFAULT_GRID_SIZE && y > 0 && y <= Battle.DEFAULT_GRID_SIZE));
                Coordinates target = new Coordinates(x,y);
                try {
                    int resultOfShot = this.shot(target, numberAdversePlayer, numberCurrentPlayer);
                    switch(resultOfShot) 
                    {
                    case MISSED:
                        System.out.println("                                                                                    Target : "+x+" ; "+y+"   -->   Missed !");
                        break;
                    case TOUCHED:
                        System.out.println("                                                                                    Target : "+x+" ; "+y+"   -->   Touched !");
                        break;
                    case TOUCHED_AND_SUNK:
                        System.out.println("                                                                                    Target : "+x+" ; "+y+"   -->   Touched and sunk !!");
                        break;
                    }
                }
                catch (BadCoordinatesException e) 
                { 
                }
            }
            else  // computer which play
            {
                Random r = new Random();
                int x = 1 + r.nextInt(Battle.DEFAULT_GRID_SIZE);
                int y = 1 + r.nextInt(Battle.DEFAULT_GRID_SIZE);

                Coordinates target = new Coordinates(x,y);

                try {
                    int resultOfShot = this.shot(target, numberAdversePlayer, numberCurrentPlayer);
                    switch(resultOfShot) 
                    {
                    case MISSED:
                        System.out.println("                                                                                                                                    Target : "+x+" ; "+y+"   -->   Yes! : The adverse missed you !");
                        break;
                    case TOUCHED:
                        System.out.println("                                                                                                                                   Target : "+x+" ; "+y+"   -->    Be careful : You are touched !");
                        break;
                    case TOUCHED_AND_SUNK:
                        System.out.println("                                                                                                                                    Target : "+x+" ; "+y+"   -->   Ouch! : one of your ship is sunk !!");
                        break;
                    }
                }
                catch (BadCoordinatesException e) 
                { 
                }

            }

            if (this.isGameWon(numberCurrentPlayer))
            {
                return numberCurrentPlayer;
            }
            this.players[numberCurrentPlayer].printGrid();

            int number = numberCurrentPlayer;
            numberCurrentPlayer = numberAdversePlayer;
            numberAdversePlayer = number;

        }


    }













    /**
     * Launch game (computer against computer)
     * @return player number who win
     */

    public int playAuto()
    {

        Scanner sc = new Scanner(System.in);

        int numberCurrentPlayer = 1; // It's the player1 who start
        int numberAdversePlayer = 2;

        System.out.println("Player 1 ship :");
        this.players[1].printShips();
        System.out.println("Player 2 ship :");


        System.out.println("                                                                                    ***** Computer 1 *****");
        System.out.println("                                                                                                                                    ***** Computer 2 *****");


        while (true) {

            Random r = new Random();
            int x = 1 + r.nextInt(Battle.DEFAULT_GRID_SIZE);
            int y = 1 + r.nextInt(Battle.DEFAULT_GRID_SIZE);

            Coordinates target = new Coordinates(x,y);

            try {
                int resultOfShot = this.shot(target, numberAdversePlayer, numberCurrentPlayer);

                if (numberCurrentPlayer == 1)
                {
                    switch(resultOfShot) 
                    {
                    case MISSED:
                        System.out.println("                                                                                    Target : "+x+" ; "+y+"   -->    Missed !");
                        break;
                    case TOUCHED:
                        System.out.println("                                                                                    Target : "+x+" ; "+y+"   -->    Touched  !");
                        break;
                    case TOUCHED_AND_SUNK:
                        System.out.println("                                                                                    Target : "+x+" ; "+y+"   -->    Touched and sunk !!");
                        break;
                    }
                }
                else
                {
                    switch(resultOfShot) 
                    {
                    case MISSED:
                        System.out.println("                                                                                                                                   Target : "+x+" ; "+y+"   -->   Missed !");
                        break;
                    case TOUCHED:
                        System.out.println("                                                                                                                                   Target : "+x+" ; "+y+"   -->   Touched !");
                        break;
                    case TOUCHED_AND_SUNK:
                        System.out.println("                                                                                                                                   Target : "+x+" ; "+y+"   -->   Touched and sunk !!");
                        break;
                    }
                }
            }
            catch (BadCoordinatesException e) 
            { 
            }


            if (this.isGameWon(numberCurrentPlayer))
            {
                return numberCurrentPlayer;
            }
            int number = numberCurrentPlayer;
            numberCurrentPlayer = numberAdversePlayer;
            numberAdversePlayer = number;

        }




















    }

}
