/**
 * Writer.java
 *
 * A writer to the database.
 *
 */

public class Writer extends Thread
{
   public Writer(int w, Database db) {
      writerNum = w;
      server = db;
   }

   public void run() {
     while (true)
      {
       System.out.println("Barber free, waiting for a customer");
       
       server.startWrite();
       
      }
   }
   
   private Database  server;
   private int       writerNum;
}
