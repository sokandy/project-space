/**
 * Customer.java
 *
 * A Customer to the Salon.
 *
 */

public class Customer extends Thread
{
   public Customer(int r, Salon sal)
   {
      id = r;
      salon = sal;
   }

   public void run()
   {
     while (true)
      {
       salon.startCustomer(id);
   
      }
   }
   
   private Salon salon;
   private int   id;
}
