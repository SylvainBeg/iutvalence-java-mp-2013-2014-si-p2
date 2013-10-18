package fr.iutvalence.java.mp.Battleship;

import java.util.Random;

/**
 * Class main which run program 
 * @author begous
 *
 */
public class Main
{
    /**
     * method main : initialize and run program
     * @param args
     */
    public static void main(String[] args)
    {
        Coordinate c1 = new Coordinate(5,2); 
        ShipArea area1 = new ShipArea(c1);
        
        Coordinate c2 = new Coordinate(5,3); 
        ShipArea area2 = new ShipArea(c1);
        
        Coordinate c3 = new Coordinate(5,4); 
        ShipArea area3 = new ShipArea(c2);
        
        ShipArea shipArea1[] = {area1, area2, area3};
        
        Ship ship1 = new Ship(shipArea1);

    }
}
