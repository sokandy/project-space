import java.awt.*;
import java.io.*;
import java.lang.*;

public class Checkmo {
	
  public static void main(String[] args) throws Exception {
      
      BufferedInputStream in = new BufferedInputStream(new
      FileInputStream("modata.txt")); 
      BufferedReader inw = new BufferedReader(new InputStreamReader(in));
      
      String inline;
      String moname[] = new String[100];
      int mosize[] = new int[100];
      String notfd[] = new String[51];
      int i=0;
      int pos=0;
        
      inline = inw.readLine();
      while (inline != null) {     
      
        File f = new File(".\\mo\\" + inline);
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
        if (i > 0){
      	  for (int j = 0; j < i; j++)
      	  System.out.println(notfd[j] + " doesn't exist");
        } 
        else
          System.out.println("All file exist");
  }
}