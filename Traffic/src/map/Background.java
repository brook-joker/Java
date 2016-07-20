package map;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;



public class Background 
{
	public static JFrame jFrame;
    public Graphics g;
    public Background()
    {
    	jFrame=new JFrame(); 
        Map map =new Map();
        map.init();
        jFrame.setTitle("交通仿真");
        jFrame.setBackground(Color.DARK_GRAY);    
        jFrame.getContentPane().add(map);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1004,580);   
        jFrame.setVisible(true); 
        jFrame.setResizable(false);
        while(true)
        {  
        	try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.repaint();
		} 
        
    }
}
