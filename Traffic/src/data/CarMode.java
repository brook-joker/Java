package data;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 小车的类型
 * @author Kirito
 *
 */
public class CarMode 
{
    public Image map;
    
    public Image p0TR,p0TL,p0TT,p0TB,p1TR,p1TL,p1TT,p1TB,p2TR,p2TL,p2TT,p2TB,
                 p3TR,p3TL,p3TT,p3TB,p4TR,p4TL,p4TT,p4TB,p5TR,p5TL,p5TT,p5TB;
    
    public CarMode()
    {
  	  try{		               
            p0TT = ImageIO.read(new File("Image/T0.png"));
            p0TB = ImageIO.read(new File("Image/B0.png"));
            p0TL = ImageIO.read(new File("Image/L0.png"));
            p0TR = ImageIO.read(new File("Image/R0.png"));
            
            p1TT = ImageIO.read(new File("Image/T1.png"));
            p1TB = ImageIO.read(new File("Image/B1.png"));
            p1TL = ImageIO.read(new File("Image/L1.png"));
            p1TR = ImageIO.read(new File("Image/R1.png"));
            
            
            p2TT = ImageIO.read(new File("Image/T2.png"));
            p2TB = ImageIO.read(new File("Image/B2.png"));
            p2TL = ImageIO.read(new File("Image/L2.png"));
            p2TR = ImageIO.read(new File("Image/R2.png"));
            
            p3TT = ImageIO.read(new File("Image/T3.png"));
            p3TB = ImageIO.read(new File("Image/B3.png"));
            p3TL = ImageIO.read(new File("Image/L3.png"));
            p3TR = ImageIO.read(new File("Image/R3.png"));
            
            p4TT = ImageIO.read(new File("Image/T4.png"));
            p4TB = ImageIO.read(new File("Image/B4.png"));
            p4TL = ImageIO.read(new File("Image/L4.png"));
            p4TR = ImageIO.read(new File("Image/R4.png"));
            
            p5TT = ImageIO.read(new File("Image/T5.png"));
            p5TB = ImageIO.read(new File("Image/B5.png"));
            p5TL = ImageIO.read(new File("Image/L5.png"));
            p5TR = ImageIO.read(new File("Image/R5.png"));
            
            map = ImageIO.read(new File("Image/map.png"));
	      }catch(Exception e){
		 e.printStackTrace();
	      }
    }
    
    
    
    public Image getP0TR() {
		return p0TR;
	}
	public Image getP0TL() {
		return p0TL;
	}
	public Image getP0TT() {
		return p0TT;
	}
	public Image getP0TB() {
		return p0TB;
	}
	public Image getP1TR() {
		return p1TR;
	}
	public Image getP1TL() {
		return p1TL;
	}
	public Image getP1TT() {
		return p1TT;
	}
	public Image getP1TB() {
		return p1TB;
	}
	public Image getP2TR() {
		return p2TR;
	}
	public Image getP2TL() {
		return p2TL;
	}
	public Image getP2TT() {
		return p2TT;
	}
	public Image getP2TB() {
		return p2TB;
	}
	public Image getP3TR() {
		return p3TR;
	}
	public Image getP3TL() {
		return p3TL;
	}
	public Image getP3TT() {
		return p3TT;
	}
	public Image getP3TB() {
		return p3TB;
	}
	public Image getP4TR() {
		return p4TR;
	}
	public Image getP4TL() {
		return p4TL;
	}
	public Image getP4TT() {
		return p4TT;
	}
	public Image getP4TB() {
		return p4TB;
	}
	public Image getP5TR() {
		return p5TR;
	}
	public Image getP5TL() {
		return p5TL;
	}
	public Image getP5TT() {
		return p5TT;
	}
	public Image getP5TB() {
		return p5TB;
	}
	public Image getMap() {
		return map;
	}
	
}
