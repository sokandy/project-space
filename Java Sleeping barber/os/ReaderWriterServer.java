/**
 * ReaderWriterServer.java
 *
 * This class creates the reader and writer threads and
 * the database they will be using to coordinate access.
 *
 */
 
public class ReaderWriterServer 
{  
   public static void main(String args[])
   {
      Database server = new Database();
      
      Reader[] readerArray = new Reader[NUM_OF_READERS];
      Writer writerArray = new Writer(1, server);

      for (int i = 0; i < NUM_OF_READERS; i++)
      {
         readerArray[i] = new Reader(i, server);
      }
      System.out.println("All Customer threads started");
      for (int i = 0; i < NUM_OF_READERS; i++)
      {
         readerArray[i].start();
      }

         writerArray.start();


   }
 
   private static final int NUM_OF_READERS = 8;
}
