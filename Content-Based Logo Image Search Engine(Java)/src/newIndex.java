/*
 * Imsearch.java (requires Java 1.2+)
 */

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.lang.*;

public class newIndex {
	
  public newIndex(int isize){
    try
    {
	

    ColorModel cm = ColorModel.getRGBdefault();
    int indexsize = isize; 
    short r[][];
    short g[][];
    short b[][];
    int rh,bh,gh;
    short rgb[][];
    String floc = "..\\logoDB"; 
    int arry[][][][] = new int[indexsize][4][4][4];
    double bin[][] = new double[indexsize][64];
    String fname=null;
    
    BufferedOutputStream out = new BufferedOutputStream(new
        FileOutputStream(floc + "\\" + "IMindex.txt")); 
    Writer outw = new BufferedWriter(new OutputStreamWriter(out));
    
    //Fomat filename
    for (int a = 0; a < indexsize; a++) {
    	if (a < 10)
    		fname = "tm" + "00" + a + ".gif";
    	else if ((a < 100) && (a >= 10))
    		fname = "tm" + "0" + a + ".gif";
    	else if ((a < 1000) && (a >= 100))
    		fname = "tm" + a + ".gif";
    

	fname = floc + "\\" + fname;
    //Get Image
    Image image = Toolkit.getDefaultToolkit().getImage(fname);
    MediaTracker mediaTracker = new MediaTracker(new Container());
    mediaTracker.addImage(image, 0);
    mediaTracker.waitForID(0);
    
    //Put to rgb array
    int width = image.getWidth(null);
    int height = image.getHeight(null);
    r = new short[width][height];
    g = new short[width][height];
    b = new short[width][height];		
    rgb = new short[width][height];
    
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
			arry[a][rh][gh][bh]++;
		}
		
        int j = 0;
        for (int x = 0; x < 4; x++){
		for (int y = 0; y < 4; y++) {
			for (int z = 0; z < 4; z++) {
			bin[a][j] = (double) arry[a][x][y][z] / (width * height); 
			outw.write(bin[a][j] + ",");
			j++;
			}
		}
		
	}
	outw.write("\n");
   }
	outw.close();
  }
    catch (Exception e) {e.printStackTrace();}
  }
  
}
