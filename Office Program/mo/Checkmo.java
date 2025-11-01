import java.awt.*;
import java.io.*;
import java.lang.*;

public class Checkmo {
	
  public static void main(String[] args) throws Exception {
      
      if (args.length != 1) {
        System.err.println("You must input the process date");
        System.exit(1);
      }	
      String dirname=".\\" + args[0] + "\\";
      
      BufferedInputStream in = new BufferedInputStream(new
      FileInputStream("c:\\mo\\modata.txt")); 
      BufferedReader inw = new BufferedReader(new InputStreamReader(in));
      
      String inline;
      String moname[] = new String[100];
      int mosize[] = new int[100];
      String notfd[] = new String[51];
      int i=0;
      int pos=0;
        
      inline = inw.readLine();
      while (inline != null) {     
      
        File f = new File(dirname + inline);
        if (f.exists()){
      	  moname[pos] = f.getName();
      	  mosize[pos] = (int) f.length();
      	  pos++;
        }
        else{
          notfd[i] = inline;
          i++;
        }
      	inline = inw.readLine();
      
      }
        System.out.println("Total " + pos + " files found in folder but " + i + " files doesn't exist.");
        if (i > 0){
      	  for (int j = 0; j < i; j++)
      	  System.out.println(notfd[j] + " doesn't exist");
        } 
        else
          System.out.println("All file exist");
        
  }
}