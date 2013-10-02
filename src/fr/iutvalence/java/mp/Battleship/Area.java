package fr.iutvalence.java.mp.Battleship;


/**
 * It's a case of game grid.
 * @author begous
 *
 */
public class Area
{
    /**
     * 0 : empty area
     * 1 : contain ship
     */
   private boolean contain;
   
   /**
    * 0 : area not hit
    * 1 : area hit
    */
   private boolean hit;
   
   /**
    * 1 : contain ship and area hit
    */
   private boolean sink;
   
   
   
   
   /**
    *  Initialize an area
    */
   public Area ()
   {
       this.contain = false;
       this.hit = false;
       this.sink = false;
   }
   
   
   
   /**
    * fill area : a ship contains this area
    */
   public void updateContain()
   {
       this.contain = true;
   }
   
   /**
    * fill area : area is hit
    * When area is hit, update hit and sink (if area contain ship)
    */
   public void areaHit()
   {
       this.hit = true;
       if (this.contain)
       {
           this.sink = true;
       }
   }
   

    
    
}
