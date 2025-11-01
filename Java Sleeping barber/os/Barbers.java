public class Barber extends Thread
{
   public Barber(Database db)
   {
      server = db;
   }

   public void run()
   {
   int c;

     while (true)
      {
       System.out.println("barber is sleeping.");
       Database.napping();

//       System.out.println("reader " + readerNum + " wants to read.");
       server.startBarber();
   
       // you have access to read from the database
       System.out.println("barber is Wake up");
       Database.napping();
       
       server.endBarber();
       System.out.println("Hair cut complete, customer leave the shop");
      }
   }
   
   private Database	server;
//   private int       readerNum;
}
