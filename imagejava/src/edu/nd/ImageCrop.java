package edu.nd;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageCrop {
	
	
	public static void main(String[] args) {
		new ImageCrop();
	}
	
	public ImageCrop() {
		String folder = "foldername";
		String filename = "filename";
		try {
			//2550 x 3300
			//1495 x 2094
			
			for(int i=1;i<=25;i++) {
				String convention = "";
				if(i<10) {
					
					convention = convention + "0";
				}
				convention = convention + i;
				
				//Original file resolution
				Rectangle rect = new Rectangle(1495, 2094);
				
				BufferedImage bi = ImageIO.read(new File(folder + "1156_0"+convention+".jpg"));
				File outputfile = new File(folder + filename + convention + ".png");
				BufferedImage bi2 = crop(bi, rect);
				
				//File size you want to crop
				int new_w = 449; //* 0.33
				int new_h = 628;
				Image save = bi2.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH);
				
				
						//yourImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
				ImageIO.write(getRenderedImage(save), "png", outputfile);
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//BufferedImage bi = getMyImage();
	    //File outputfile = new File("saved.png");
	    //ImageIO.write(bi, "png", outputfile);
		
	}
	public BufferedImage getRenderedImage(Image in) {
        int w = in.getWidth(null);
        int h = in.getHeight(null);
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage out = new BufferedImage(w, h, type);
        Graphics2D g2 = out.createGraphics();
        g2.drawImage(in, 0, 0, w, h, null);
        //out.drawImage(in, 0, 0, null);
        //out.
        g2.dispose();
        return out;
    }
	
	public BufferedImage crop(BufferedImage src, Rectangle rect) throws Exception
	{
	    //BufferedImage dest = new BufferedImage(rect.getWidth(), rect.getHeight(), BufferedImage.TYPE_INT_RGB);
		BufferedImage dest = new BufferedImage((int)rect.getWidth(), (int)rect.getHeight(), BufferedImage.TYPE_INT_RGB);
	    Graphics g = dest.getGraphics();
	    
	    g.drawImage(src, -(2550-1495), 0, null);
	    g.dispose();
	    
	    return dest;
	}
}
