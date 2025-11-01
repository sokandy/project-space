/**
 * Reader.java
 *
 * A reader to the database.
 *
 */

public class Reader extends Thread
{
   public Reader(int r, Database db)
   {
      id = r;
      server = db;
   }

   public void run()
   {
     while (true)
      {
       server.startRead(id);
   
      }
   }
   
   private Database	server;
   private int       id;
}
