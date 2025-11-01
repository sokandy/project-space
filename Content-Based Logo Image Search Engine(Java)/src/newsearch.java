/*
 * Imsearch.java (requires Java 1.2+)
 */

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.lang.*;

public class newsearch {
	
  public newsearch(String que,int isize){	
    try
    {
    ColorModel cm = ColorModel.getRGBdefault();
    short r[][];
    short g[][];
    short b[][];
    int rh,bh,gh;
    int Top = isize; 
    int indexsize = 1000;
    int arry[][][] = new int[4][4][4];
    double bin[] = new double[64];
    double diff[] = new double[indexsize];
    String topx[] = new String[Top];
    

    //Get Image
    Image image = Toolkit.getDefaultToolkit().getImage(que);
    MediaTracker mediaTracker = new MediaTracker(new Container());
    mediaTracker.addImage(image, 0);
    mediaTracker.waitForID(0);
 //   System.out.println("Done. Step1");
    //Put to rgb array
    int width = image.getWidth(null);
    int height = image.getHeight(null);
    r = new short[width][height];
    g = new short[width][height];
    b = new short[width][height];		
    
    int pels[] = new int[width * height];
	cm = ColorModel.getRGBdefault();

	PixelGrabber grabber = 
			new PixelGrabber(
				image, 0, 0, 
				width, height, pels, 0, width);

	try {grabber.grabPixels();}
	catch (InterruptedException e){};
	int i = 0;
	for (int x = 0; x < width; x++)
		for (int y = 0; y < height; y++) {
			i = x + y * width;
			b[x][y] = (short)cm.getBlue(pels[i]);
			g[x][y] = (short)cm.getGreen(pels[i]);
			r[x][y] = (short)cm.getRed(pels[i]);
			rh = (int)(r[x][y] & 0xC0 ) / 64;
			bh = (int)(b[x][y] & 0xC0 ) / 64;
			gh = (int)(g[x][y] & 0xC0 ) / 64;
			arry[rh][gh][bh]++;
		}
		
        
    //    System.out.println("Done. Step2");
        int j = 0;
  	for (int x = 0; x < 4; x++){
		for (int y = 0; y < 4; y++) {
			for (int z = 0; z < 4; z++) {
			bin[j] = (double) arry[x][y][z] / (width * height); 
			j++;
			}
		}
		
	}
//	System.out.println("Done. Step3");
	
	//Read the index of Bin from IMindex.txt for comparsion
        BufferedInputStream in = new BufferedInputStream(new
        FileInputStream("..\\logodb\\IMindex.txt")); 
        BufferedReader inw = new BufferedReader(new InputStreamReader(in));
        
        String inline;
        int pos = -1;
        double t=0.0;
        // Take the different of user image and IMindex file[64]
        // And put this value in the array diff[]. 
        for (int c=0; c<indexsize; c++) {        
          inline = inw.readLine();
          for (int y=0; y <64; y++) {  // 64 bin
	       	pos = inline.indexOf(",");
        	t = bin[y] - (Double.parseDouble(inline.substring(0, pos)));
        	// take absolute value
        	if (t < 0){ 
        	  t = t * -1;
          	}
          	diff[c] = diff[c] + t;
          	inline = inline.substring(pos + 1);
          }
   	  t =0.0;
	  pos = -1;
	}
	inw.close();
	
	double min = 100.0;
        int minno = 0;
        String fname;
        for (int e=0; e<Top; e++) {
        	fname = null;
		for (int d=0; d<indexsize; d++) {
	   		if (diff[d] < min) {
	   		min = diff[d];
	   		minno = d;
	   		}
		}
	if (minno < 10)
    		fname = "tm" + "00" + minno + ".gif";
    	else if ((minno < 100) && (minno >= 10))
    		fname = "tm" + "0" + minno + ".gif";
    	else if ((minno < 1000) && (minno >= 100))
    		fname = "tm" + minno + ".gif";
	topx[e] = "..\\logodb\\" + fname;
	diff[minno] = diff[minno] + 100;
	min = 100.0;
//	System.out.println("Min:" +e+":" +minno);
	}
	Viewer a;
	for (int e=0; e<Top; e++) 
	   a = new Viewer(topx[e],"No." + (e+1)); 
//    System.out.println("Done.");
//    System.exit(0);

  }
    catch (Exception e) {e.printStackTrace();}
  }

  
}
