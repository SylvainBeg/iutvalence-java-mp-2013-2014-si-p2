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
    
    PlayerLocationShip player1;
    
    public static void main(String[] args)
    {
          
        PlayerLocationShip player1 = new PlayerLocationShip();
        
// Adapter le code  ....
        
        try{
            this.ships[0] = this.addShip(2);
            this.ships[1] = this.addShip(3);
            this.ships[2] = this.addShip(3);
            this.ships[3] = this.addShip(4);
            this.ships[4] = this.addShip(5);
        }
        catch (TooMuchAttemptsException e) {
            System.out.println("Erreur, impossible de placer l'ensemble des bateaux.");
        }

    }
}
