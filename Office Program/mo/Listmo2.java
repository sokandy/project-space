import java.awt.*;
import java.io.*;
import java.lang.*;

public class Listmo {
	
 	
  public static void main(String[] args) throws Exception {
      if (args.length != 1) {
        System.err.println("You must input the process date");
        System.exit(1);
      }	
      String dirname=".\\" + args[0] + "\\";    
      BufferedInputStream mo_in = new BufferedInputStream(new
      FileInputStream("c:\\mo\\modata.txt")); 
      BufferedReader mo_inw = new BufferedReader(new InputStreamReader(mo_in));
      
      BufferedInputStream head = new BufferedInputStream(new
      FileInputStream("c:\\mo\\header.rtf")); 
      BufferedReader header = new BufferedReader(new InputStreamReader(head));
      
      BufferedInputStream head1 = new BufferedInputStream(new
      FileInputStream("c:\\mo\\header1.rtf")); 
      BufferedReader header1 = new BufferedReader(new InputStreamReader(head1));
        
      BufferedInputStream foot = new BufferedInputStream(new
      FileInputStream("c:\\mo\\footer.rtf")); 
      BufferedReader footer = new BufferedReader(new InputStreamReader(foot));  
        
      BufferedOutputStream out = new BufferedOutputStream(new
      FileOutputStream("c:\\molist\\molist.rtf")); 
      Writer outw = new BufferedWriter(new OutputStreamWriter(out));
      
      String inline;
      
      inline = header.readLine();
      while (inline != null) {
          outw.write(inline);
          inline = header.readLine();
      }
      header.close();
      
      String pdate = "{\\fs20\\insrsid15156344\\charrsid8925061 \\hich\\af0\\dbch\\af14\\loch\\f0 " + args[0] + "}";
      outw.write(pdate);
      
      inline = header1.readLine();
      while (inline != null) {
          outw.write(inline);
          inline = header1.readLine();
      }
      header1.close();
      
      
      
      
  
      String tar1 ="\\pard \\ql \\li0\\ri0\\widctlpar\\intbl\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0 {\\insrsid15156344 ";
      
      String tar7 ="}\\pard \\ql \\li0\\ri0\\widctlpar\\intbl\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0 ";
      String tar8 ="{\\insrsid15156344 \\trowd \\irow";
      
      
      String tar12 = "\\ts11\\trgaph108\\trleft-108\\trbrdrt\\brdrs\\brdrw10 \\trbrdrl\\brdrs\\brdrw10 \\trbrdrb\\brdrs\\brdrw10 \\trbrdrr\\brdrs\\brdrw10 \\trbrdrh" +
      "\\brdrs\\brdrw10 \\trbrdrv\\brdrs\\brdrw10 \\trftsWidth1\\trpaddl108\\trpaddr108\\trpaddfl3\\trpaddfr3 \\clvertalt\\clbrdrt\\brdrs\\brdrw10 \\clbrdrl\\brdrs\\brdrw10 \\clbrdrb\\brdrs\\brdrw10 \\clbrdrr\\brdrs\\brdrw10 \\cltxlrtb\\clftsWidth3\\clwWidth1647\\clshdrawnil \\cellx1539" +
      "\\clvertalt\\clbrdrt\\brdrs\\brdrw10 \\clbrdrl\\brdrs\\brdrw10 \\clbrdrb\\brdrs\\brdrw10 \\clbrdrr\\brdrs\\brdrw10 \\cltxlrtb\\clftsWidth3\\clwWidth1647\\clshdrawnil \\cellx3186\\clvertalt\\clbrdrt\\brdrs\\brdrw10 \\clbrdrl\\brdrs\\brdrw10 \\clbrdrb\\brdrs\\brdrw10 \\clbrdrr" +
      "\\brdrs\\brdrw10 \\cltxlrtb\\clftsWidth3\\clwWidth1647\\clshdrawnil \\cellx4833\\clvertalt\\clbrdrt\\brdrs\\brdrw10 \\clbrdrl\\brdrs\\brdrw10 \\clbrdrb\\brdrs\\brdrw10 \\clbrdrr\\brdrs\\brdrw10 \\cltxlrtb\\clftsWidth3\\clwWidth1647\\clshdrawnil \\cellx6480\\clvertalt\\clbrdrt" +
      "\\brdrs\\brdrw10 \\clbrdrl\\brdrs\\brdrw10 \\clbrdrb\\brdrs\\brdrw10 \\clbrdrr\\brdrs\\brdrw10 \\cltxlrtb\\clftsWidth3\\clwWidth1647\\clshdrawnil \\cellx8127\\clvertalt\\clbrdrt\\brdrs\\brdrw10 \\clbrdrl\\brdrs\\brdrw10 \\clbrdrb\\brdrs\\brdrw10 \\clbrdrr\\brdrs\\brdrw10 " +
      "\\cltxlrtb\\clftsWidth3\\clwWidth1647\\clshdrawnil \\cellx9774\\clvertalt\\clbrdrt\\brdrs\\brdrw10 \\clbrdrl\\brdrs\\brdrw10 \\clbrdrb\\brdrs\\brdrw10 \\clbrdrr\\brdrs\\brdrw10 \\cltxlrtb\\clftsWidth3\\clwWidth1647\\clshdrawnil \\cellx11421\\clvertalt\\clbrdrt\\brdrs\\brdrw10 " +
      "\\clbrdrl\\brdrs\\brdrw10 \\clbrdrb\\brdrs\\brdrw10 \\clbrdrr\\brdrs\\brdrw10 \\cltxlrtb\\clftsWidth3\\clwWidth1647\\clshdrawnil \\cellx13068\\row }";

      
      for (int t=1; t < 26; t++){
        outw.write(tar1);
        for (int tt=0; tt < 2; tt++){
          inline = mo_inw.readLine();
          if  (inline != null) {     
                File f = new File(dirname + inline);
        	if (f.exists()){
      	           outw.write("\\hich\\af0\\dbch\\af14\\loch\\f0 " + f.getName() + "\\cell " + f.length() + "\\cell ");
      	           outw.write("\\hich\\af0\\dbch\\af14\\loch\\f0 DBS               (   )\\cell \\cell ");
      	    	}
        	else{
          	   outw.write("\\hich\\af0\\dbch\\af14\\loch\\f0 " + inline + "\\cell \\cell ");
      	           outw.write("\\hich\\af0\\dbch\\af14\\loch\\f0 DBS               (   )\\cell \\cell ");
        	}
      	  
          }
        }
        outw.write(tar7);
        outw.write(tar8 + t + "\\irowband" + t);
        outw.write(tar12);
     }
     
     //inline = mo_inw.readLine();
     File f = new File(dirname + "DHBCAPER");
//     if (f.exists()){
     	outw.write(tar1);
     	outw.write("\\hich\\af0\\dbch\\af14\\loch\\f0 " + f.getName() + "\\cell " + f.length() + "\\cell ");
      	outw.write("\\hich\\af0\\dbch\\af14\\loch\\f0 DHB              (   )\\cell \\cell ");
     	outw.write("\\hich\\af0\\dbch\\af14\\loch\\f0 \\cell \\cell \\cell \\cell");
      	outw.write(tar7);
        outw.write(tar8 + 26 + "\\irowband" + 26);
        outw.write(tar12);
 //    }
     
     
     
     inline = footer.readLine();
      while (inline != null) {
          outw.write(inline);
          inline = footer.readLine();
      }
      footer.close();
      outw.close(); 
  }
}