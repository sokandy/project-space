/**
 * Salon.java
 *
 * This class contains the methods the customers and barber will use
 * to coordinate access to the salon. Access is coordinated using semaphores.
 *
 */

public class Salon
{  
   public Salon() {
      waitCount = 0;
      numChairs = 4;
      
      mutex = new Semaphore(1);
      barber_chair = new Semaphore(0);
      barber = new Semaphore(0);
      customer = new Semaphore(0);
   }

   // customers and barber will call this to nap
   public static void napping() {
     int sleepTime = (int) (NAP_TIME * Math.random() );
     try { Thread.sleep(sleepTime*1000); }
     catch(InterruptedException e) {}
   }


   public void startCustomer(int id) {
      this.napping();
      mutex.P();
      if (waitCount < numChairs) {
         waitCount++;
         System.out.println("Customer " + id + " in room, waiting=" + waitCount);
         customer.V();
         mutex.V();
         barber.P();
         this.napping();
         System.out.println("Customer " + id + " getting haircut" );
         this.napping();
         System.out.println("Customer " + id + " finished haircut");
         barber_chair.V();

      } else {
         System.out.println("Customer " + id + " room full, waiting=" + waitCount);
         mutex.V();
      }

   }

   public void startBarber() {
      customer.P();
      mutex.P();
      waitCount--;
      barber.V();
      System.out.println("Barber has customer, waiting=" + waitCount);
      mutex.V();
      System.out.println("Barber cutting hair");
      barber_chair.P();
//    this.napping();

   }


   private int waitCount;
   private int numChairs;
   Semaphore mutex;
   Semaphore barber_chair;
   Semaphore barber;
   Semaphore customer;
    
   private static final int NAP_TIME = 20;
}
