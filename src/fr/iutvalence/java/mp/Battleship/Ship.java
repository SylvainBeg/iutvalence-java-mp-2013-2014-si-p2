package fr.iutvalence.java.mp.Battleship;

import java.util.Scanner;

/**
 * Declaration a ship which contains areas.
 * @author begous
 *
 */
public class Ship
{
    // TODO (fix) detail comment
    /**
     * area number of ship
     */
    private int nbArea;
    
    /**
     * Initialize a ship.
     * @param area : area number of ship
     */
    public Ship(int area)
    {
        this.nbArea = area;    
    }
    
    // TODO (fix) the ship must not have any explicit dependency to keyboard
    /**
     * Place a ship on the player grid for a real player
     */
    public void location()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Vous allez placer un bateau de deux cases :");
        
        System.out.println("Veuillez saisir le numéro de ligne de la première case :");
        int x = sc.nextInt();
        System.out.println("Veuillez saisir le numéro de colonne de la seconde case :");
        int y = sc.nextInt();
        
        game.grid1.location(x, y);
        
        System.out.println("Vous avez saisi : " + x + y);
    }
    
}
