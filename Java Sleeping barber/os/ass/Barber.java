/**
 * Barber.java
 *
 * A barber to the salon.
 *
 */

public class Barber extends Thread
{
   public Barber(int w, Salon sal) {
      barberNum = w;
      salon = sal;
   }

   public void run() {
     while (true)
      {
       System.out.println("Barber free, waiting for a customer");
       
       salon.startBarber();
       
      }
   }
   
   private Salon salon;
   private int   barberNum;
}
