/**
 * Database.java
 *
 * This class contains the methods the readers and writers will use
 * to coordinate access to the database. Access is coordinated using semaphores.
 *
 */

public class Database
{  
   public Database() {
      waitCount = 0;
      numChairs = 4;
      
      mutex = new Semaphore(1);
      cutting = new Semaphore(0);
      barber = new Semaphore(0);
      customer = new Semaphore(0);
   }

   // readers and writers will call this to nap
   public static void napping() {
     int sleepTime = (int) (NAP_TIME * Math.random() );
     try { Thread.sleep(sleepTime*1000); }
     catch(InterruptedException e) {}
   }


   public void startRead(int id) {
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
         cutting.V();

      } else {
         System.out.println("Customer " + id + " room full, waiting=" + waitCount);
         mutex.V();
      }

   }

   public void startWrite() {
      // add your code
      customer.P();
      mutex.P();
      waitCount--;
      barber.V();
      System.out.println("Barber has customer, waiting=" + waitCount);
      mutex.V();
      System.out.println("Barber cutting hair");
      cutting.P();
//    this.napping();

   }


   // the number of active readers
   private int waitCount;
   private int numChairs;
   Semaphore mutex;
   Semaphore cutting;
   Semaphore barber;
   Semaphore customer;
    
   private static final int NAP_TIME = 15;
}
