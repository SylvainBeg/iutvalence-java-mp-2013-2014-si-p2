package fr.iutvalence.java.mp.Battleship;


// TODO (think about it) is this class really useful (needs a discussion!)
/**
 * It's a case of game grid.
 * @author begous
 *
 */
public class Area
{
    // TODO (fix) declare constants for relevant values
    /**
     * 0 : empty area
     * 1 : contain ship
     */
   private boolean contain;
   
   // TODO (fix) finish writing comment
   /**
    * 0 : area not hit
    * 1 : area hit
    */
   private boolean hit;

   // TODO (fix) finish writing comment
   /**
    * 1 : contain ship and area hit
    */
   private boolean sink;
   

   // TODO FIXED write a "real" comment
   /**
    *  Initialize an area : empty, not hit, not sink
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
