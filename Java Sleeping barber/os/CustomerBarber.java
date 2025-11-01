/**
 * CustomerBarber.java
 *
 * This class creates the customer and barber threads and
 * the salon they will be using to coordinate access.
 *
 */
 
public class CustomerBarber 
{  
   public static void main(String args[])
   {
      Salon salon = new Salon();
      
      Customer[] customerArray = new Customer[NUM_OF_CUSTOMER];
      Barber barber = new Barber(1, salon);

      for (int i = 0; i < NUM_OF_CUSTOMER; i++)
      {
         customerArray[i] = new Customer(i, salon);
      }
      System.out.println("All Customer threads started");
      for (int i = 0; i < NUM_OF_CUSTOMER; i++)
      {
         customerArray[i].start();
      }

         barber.start();


   }
 
   private static final int NUM_OF_CUSTOMER = 8;
}
