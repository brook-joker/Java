package map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

import data.CarLocation;
import data.CarMode;
import data.CarRoute;
import data.CarSize;
import data.LightTime;
import serviceInterface.CarLocationService;
import serviceInterface.TimePause;
import serviceInterface.TimeService;

/**
 * 鍦板浘涓婃墍鏈変俊鎭殑闆嗗悎
 * 灏忚溅 绾㈢豢鐏�
 * @author Kirito
 *
 */
public class Map extends JPanel 
{

	private static final long serialVersionUID = 1L;
	public CarMode carstyle;
	public CarLocation[] car=new CarLocation[12];
	public CarLocationService service;
	public TimeService time;
	public LightTime light;
	public CarRoute route,route1;
	public CarSize size;
	public TimePause pause;
	public ArrayList[] list = new ArrayList[12];
	public Point[] p = new Point[12];
	public int[] rand = new int[12];
	public boolean flag00,flag01,flag70,flag71,
			       flag10,flag11,flag80,flag81,
			       flag20,flag21,flag90,flag91,
				   flag30,flag31,flag100,flag101,
				   flag40,flag41,flag110,flag111,
				   flag50,flag51,
				   flag60,flag61;
	
	public Map()
	{		
        size = new CarSize();
		service = new CarLocationService();
		carstyle = new CarMode();
		route= new CarRoute();
		light = new LightTime(20,25,20,25);	
	}
	/**
	 * 绘制红绿灯
	 * @param g
	 */
	public void initLightL(Graphics g)
	{
		if(light.getRedTF()>0)
		{
	           light.red1go();
			   g.setColor(Color.red);
			   g.fillArc(200,210, 30, 30, 0, 360);
			   g.fillArc(310,310, 30, 30, 0, 360);
			       
			   g.setColor(Color.green);
			   g.fillArc(200,310, 30, 30, 0, 360);
			   g.fillArc(310,210, 30, 30, 0, 360);			       
		}
		else 
		{
			if(light.getGreenTF()>0)
			{
				light.green1go();					  
			    g.setColor(Color.red);
				g.fillArc(200,310, 30, 30, 0, 360);
				g.fillArc(310,210, 30, 30, 0, 360);				  
			    g.setColor(Color.GREEN);
				g.fillArc(200,210, 30, 30, 0, 360);
				g.fillArc(310,310, 30, 30, 0, 360);

			}
			else
			{				
				light.setRedTF(20);
				light.setGreenTF(25);
				light.red1go();
				   g.setColor(Color.red);
				   g.fillArc(200,210, 30, 30, 0, 360);
				   g.fillArc(310,310, 30, 30, 0, 360);
				       
				   g.setColor(Color.green);
				   g.fillArc(200,310, 30, 30, 0, 360);
				   g.fillArc(310,210, 30, 30, 0, 360);	
			}
		}	
	}
	
	public void initLightR(Graphics g)
	{
		if(light.getRedTR()>0)
		{
	           light.red2go();
			   g.setColor(Color.red);
			   g.fillArc(650,210, 30, 30, 0, 360);
			   g.fillArc(760,310, 30, 30, 0, 360);
			       
			   g.setColor(Color.green);
			   g.fillArc(650,310, 30, 30, 0, 360);
			   g.fillArc(760,210, 30, 30, 0, 360);			       
		}
		else 
		{
			if(light.getGreenTR()>0)
			{
				light.green2go();					  
				   g.setColor(Color.green);
				   g.fillArc(650,210, 30, 30, 0, 360);
				   g.fillArc(760,310, 30, 30, 0, 360);
				       
				   g.setColor(Color.red);
				   g.fillArc(650,310, 30, 30, 0, 360);
				   g.fillArc(760,210, 30, 30, 0, 360);	

			}
			else
			{				
				light.setRedTR(20);
				light.setGreenTR(25);
				light.red2go();
				   g.setColor(Color.red);
				   g.fillArc(650,210, 30, 30, 0, 360);
				   g.fillArc(760,310, 30, 30, 0, 360);
				       
				   g.setColor(Color.green);
				   g.fillArc(650,310, 30, 30, 0, 360);
				   g.fillArc(760,210, 30, 30, 0, 360);
			}
		}	
	}
	
	public void init()
	{
		initp0();initp1();initp2();initp3();initp4();initp5();
		initp6();initp7();initp8();initp9();initp10();initp11();
	}
	public void initp0()
	{
		flag00=true;
		flag01=true;
		p[0]=null;
		car[0]=new CarLocation(service.p0);
		list[0]=route.p0();
		rand[0]=route.rand0;
	}
	public void initp1()
	{
		flag10= true;
		flag11=true;
		p[1]=null;
		car[1]=new CarLocation(service.p1);
		list[1]=route.p1();
		rand[1]=route.rand1;
	}
	public void initp2()
	{
		flag20= true;
		flag21=true;
		p[2]=null;
		car[2]=new CarLocation(service.p2);
		list[2]=route.p2();
		rand[2]=route.rand2;
	}
	public void initp3()
	{
		flag30= true;
		flag31=true;
		p[3]=null;
		car[3]=new CarLocation(service.p3);
		list[3]=route.p3();
		rand[3]=route.rand3;
	}
	public void initp4()
	{
		flag40= true;
		flag41=true;
		p[4]=null;
		car[4]=new CarLocation(service.p4);
		list[4]=route.p4();
		rand[4]=route.rand4;
	}
	public void initp5()
	{
		flag50= true;
		flag51=true;
		p[5]=null;
		car[5]=new CarLocation(service.p5);
		list[5]=route.p5();
		rand[5]=route.rand5;
	}
	public void initp6()
	{
		flag60= true;
		flag61=true;
		p[6]=null;
		car[6]=new CarLocation(service.p0);
		car[6].setX(-40);
		list[6]=route.p0();
		rand[6]=route.rand0;
	}	
	public void initp7()
	{
		flag70= true;
		flag71=true;
		p[7]=null;
		car[7]=new CarLocation(service.p1);
		car[7].setY(-50);
		list[7]=route.p1();
		rand[7]=route.rand1;
	}
	public void initp8()
	{
		flag80= true;
		flag81=true;
		p[8]=null;
		car[8]=new CarLocation(service.p2);
		car[8].setY(-50);
		list[8]=route.p2();
		rand[8]=route.rand2;
	
	}
	public void initp9()
	{
		flag90= true;
		flag91=true;
		p[9]=null;
		car[9]=new CarLocation(service.p3);
		car[9].setX(1000);
		list[9]=route.p3();
		rand[9]=route.rand3;
	}
	public void initp10()
	{
		flag100= true;
		flag101=true;
		p[10]=null;
		car[10]=new CarLocation(service.p4);
		car[10].setY(560);
		list[10]=route.p4();
		rand[10]=route.rand4;
	}
	public void initp11()
	{
		flag110= true;
		flag111=true;
		p[11]=null;
		car[11]=new CarLocation(service.p5);
		car[11].setY(560);
		list[11]=route.p5();
		rand[11]=route.rand5;
	}
	
	
	
	
	public void paint(Graphics g)
	{		
	       bg1(g); 	    
           carRunP0(g);	   
	       carRunP1(g);
	       carRunP2(g);        
	       carRunP3(g);
           carRunP4(g); 
           carRunP5(g);
 	       carRunP6(g);
           carRunP7(g);
           carRunP8(g);
           carRunP9(g);
	       carRunP10(g);
           carRunP11(g);
         
	}
	public void carRunP0(Graphics g)
	{ 	
		    destination(g);
			if(rand[0]==1)
			{ 
				/**
				 * 姘村钩鍚戝彸妫�娴�
				 */
               	if(car[0].getX()<=220)
               	{   
               		if(levelR(0))
               		{
               			g.drawImage(carstyle.getP0TR(), car[0].getX(), car[0].getY(), size.getlCarL(),size.getlCarH(), null);              
               		}
               		else
               	    {
               			g.drawImage(carstyle.getP0TR(), car[0].moveToRight(), car[0].getY(), size.getlCarL(),size.getlCarH(), null);              
               	    }
               	}
               	else
               	{
               		p[0] = (Point) list[0].get(1);
               		car[0].setX(p[0].x);
               		/**
               		 *  鍨傜洿鍚戜笅妫�娴�
               		 */
               		if(flag00)
               		{
               			if(verticalB(0))
               			{
               			   g.drawImage(carstyle.getP0TB(),car[0].getX(),car[0].getY(), size.gethCarL(),size.gethCarH(),null); 
               			}
               			else	
               			   g.drawImage(carstyle.getP0TB(),car[0].getX(),car[0].moveToBottom(), size.gethCarL(),size.gethCarH(),null);              	
               			if(car[0].getY()==p[0].y)
               				flag00=false;
               		}
               		else 
               		{
               			if(flag01)
               			{
               				p[0] = (Point) list[0].get(2);
               				car[0].setX(p[0].x);car[0].setY(p[0].y);
               				if(!start5())
               				{
               				   g.drawImage(carstyle.getP0TR(),car[0].getX(),car[0].getY(),size.getlCarL(),size.getlCarH(),null);           			             		
               			       flag01=false;
               				}              			
               			}              			               			             			
               			else
               			{
               				p[0] = (Point) list[0].get(3);
               				car[0].setX(p[0].x);
               				/**
               				 * 鍨傜洿鍚戜笂妫�娴嬨�佺孩缁跨伅妫�娴�
               				 */
               				if(car[0].getY()>0)
               				{
               					if(verticalT(0))
               					   g.drawImage(carstyle.getP0TT(),car[0].getX(),car[0].getY(),size.gethCarL(),size.gethCarH(),null);
               				    else if(car[0].getY()==308&&light.getRedTF()>0)
               					   g.drawImage(carstyle.getP0TT(),car[0].getX(),car[0].getY(),size.gethCarL(),size.gethCarH(),null);            						
                   				else
                   				   g.drawImage(carstyle.getP0TT(),car[0].getX(),car[0].moveToTop(),size.gethCarL(),size.gethCarH(),null);
               				}
               				else
               				{
               				    initp0();              				   
               				}               				
               			}                       
               		}
               	}
			}
			if(rand[0]==2)
			{
				 p[0] = (Point) list[0].get(0);
				 if(flag00)
				 {
					 /**
        			  * 鍨傜洿鍚戝彸妫�娴嬨�佺孩缁跨伅妫�娴�
        			  */
					 if(levelR(0))
						 g.drawImage(carstyle.getP0TR(),car[0].getX(),car[0].getY(),size.getlCarL(),size.getlCarH(),null);
				     else if((car[0].getX()==200&&light.getRedTF()<0)||(car[0].getX()==650&&light.getRedTR()<0))
						 g.drawImage(carstyle.getP0TR(),car[0].getX(),car[0].getY(),size.getlCarL(),size.getlCarH(),null);
					 else
					     g.drawImage(carstyle.getP0TR(),car[0].moveToRight(),car[0].getY(),size.getlCarL(),size.getlCarH(),null);				   
				     if(car[0].getX()==p[0].x)
                     {
				    	 p[0] = (Point) list[0].get(1);
				    	 car[0].setX(p[0].x);car[0].setY(p[0].y);
				    	 if(!start3())
						 {
				    		 g.drawImage(carstyle.getP0TT(),car[0].getX(),car[0].getY(),size.gethCarL(),size.gethCarH(),null);					
				    		 flag00=false;
						 }
				    	 
                     }
				 }
				 else
				 {
					 if(flag01)
					 {
						 p[0] = (Point) list[0].get(2);
						 car[0].setY(p[0].y);
						 /**
						  * 姘村钩鍚戝乏妫�娴�
						  */
						 if(levelL(0))
							 g.drawImage(carstyle.getP0TL(),car[0].getX(),car[0].getY(),size.getlCarL(),size.getlCarH(),null);					
						 else	 
						 {   g.drawImage(carstyle.getP0TL(),car[0].moveToLeft(),car[0].getY(),size.getlCarL(),size.getlCarH(),null);					
						     p[0] = (Point) list[0].get(3);
						     if(car[0].getX()==p[0].x)											
						     {
							   p[0] = (Point) list[0].get(4);
							   car[0].setY(p[0].y);
							   flag01=false;
						     }
						 }
					 }					 
					 else
					{
						 p[0] = (Point) list[0].get(4);
						 car[0].setX(p[0].x);
						 if(car[0].getY()>0)
						 {
							/**
							 * 鍨傜洿鍚戜笂妫�娴�
							 */
							 if(verticalT(0))
								 g.drawImage(carstyle.getP0TT(),car[0].getX(),car[0].getY(),size.gethCarL(),size.gethCarH(),null);
							 else	 
							     g.drawImage(carstyle.getP0TT(),car[0].getX(),car[0].moveToTop(),size.gethCarL(),size.gethCarH(),null); 
						 }							 
						 else
						 {
							 initp0();
						 }
					}
				 }
			}
			if(rand[0]==3)
			{
				p[0] = (Point) list[0].get(0);
				 if(car[0].getX()<p[0].x)
				 {
					 /**
					  * 姘村钩鍚戝彸妫�娴嬨�佺孩缁跨伅妫�娴�
					  */
					 if(levelR(0))
						 g.drawImage(carstyle.getP0TR(),car[0].getX(),car[0].getY(),size.getlCarL(),size.getlCarH(),null);					 
					 else if((car[0].getX()==200&&light.getRedTF()<0)||(car[0].getX()==650&&light.getRedTR()<0))
						 g.drawImage(carstyle.getP0TR(),car[0].getX(),car[0].getY(),size.getlCarL(),size.getlCarH(),null);
					 else
					     g.drawImage(carstyle.getP0TR(),car[0].moveToRight(),car[0].getY(),size.getlCarL(),size.getlCarH(),null);				
				 }
				 else
				 {
					 initp0();
				 }
				
			}
			if(rand[0]==4)
			{
				p[0] = (Point) list[0].get(0);
			 	if(car[0].getX()<=(int)p[0].getX())
               	{   
			 		/**
					 * 姘村钩鍚戝彸妫�娴嬨�佺孩缁跨伅妫�娴�
				     */
			 		if(levelR(0))
			 			 g.drawImage(carstyle.getP0TR(),car[0].getX(),car[0].getY(),size.getlCarL(),size.getlCarH(),null);
			 	    else if((car[0].getX()==200&&light.getRedTF()<0))
						 g.drawImage(carstyle.getP0TR(),car[0].getX(),car[0].getY(),size.getlCarL(),size.getlCarH(),null);
			 		else
               		     g.drawImage(carstyle.getP0TR(),car[0].moveToRight(),car[0].getY(), size.getlCarL(),size.getlCarH(), null);
               	}
			 	else
			 	{
			 		p[0] = (Point) list[0].get(1);	
           			car[0].setX(p[0].x);
               		if(car[0].getY()<p[0].y)
               		{
               			/**
               			 * 鍨傜洿鍚戜笅妫�娴�
               			 */
               			if(verticalB(0))
               				g.drawImage(carstyle.getP0TB(),car[0].getX(),car[0].getY(), size.gethCarL(),size.gethCarH(),null);
               			else	
               		    	g.drawImage(carstyle.getP0TB(),car[0].getX(),car[0].moveToBottom(), size.gethCarL(),size.gethCarH(),null);
               		}
               		else
               		{
               			initp0();              
               		}
			 	}
			}
			if(rand[0]==5)
			{
				p[0] = (Point) list[0].get(0);
			   	if(car[0].getX()<=p[0].x)
               	{
			   		/**
			   		 * 姘村钩鍚戝彸妫�娴�
			   		 */
			   		if(levelR(0))
			   			g.drawImage(carstyle.getP0TR(),car[0].getX(), car[0].getY(), size.getlCarL(),size.getlCarH(), null);
			   		else
               		    g.drawImage(carstyle.getP0TR(),car[0].moveToRight(), car[0].getY(), size.getlCarL(),size.getlCarH(), null);
               	}
               	else
               	{
               		 p[0] = (Point) list[0].get(1);
               		 car[0].setX(p[0].x);
               		 if(car[0].getY()<p[0].y)
               		 {  
               			/**
               			 * 鍨傜洿鍚戜笅妫�娴� 
               			 */
               			if(verticalB(0))
               			   g.drawImage(carstyle.getP0TB(),car[0].getX(),car[0].getY(), size.gethCarL(),size.gethCarH(),null);
               			else
               			   g.drawImage(carstyle.getP0TB(),car[0].getX(),car[0].moveToBottom(), size.gethCarL(),size.gethCarH(),null);
               		 }
               		 else
               		 {
               			 initp0();
               		 }
               	}	
          		
			}
			
	}
	public void carRunP1(Graphics g)
	{		
		if(rand[1]==1)
		{
            p[1] = (Point) list[1].get(0);
			if(car[1].getY()<=p[1].y)
			{
       			/**
       			 * 鍨傜洿鍚戜笅妫�娴� 
       			 */
				if(verticalB(1))
				   g.drawImage(carstyle.p1TB,car[1].getX(),car[1].getY(), size.gethCarL(),size.gethCarH(), null);
				else	
				   g.drawImage(carstyle.p1TB,car[1].getX(),car[1].moveToBottom(), size.gethCarL(),size.gethCarH(), null);
			}
			else
			{
				p[1] = (Point) list[1].get(1);
				car[1].setY(p[1].y);
				if(car[1].getX()>0)
				{
					 /**
					  * 姘村钩鍚戝乏妫�娴�
					  */
					if(levelL(1))
						g.drawImage(carstyle.p1TL, car[1].getX(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);
					else	
				    	g.drawImage(carstyle.p1TL, car[1].moveToLeft(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);
				}
				else
				{
					initp1();
				}
			}
		}
		if(rand[1]==2)
		{
			if(flag10)
			{
				 p[1] = (Point) list[1].get(0);
			  	 if(car[1].getY()<=p[1].y)
			  	 {
            	    /**
            		 * 鍨傜洿鍚戜笅妫�娴� 
            		 */
			  		if(verticalB(1))
					    g.drawImage(carstyle.p1TB,car[1].getX(),car[1].getY(), size.gethCarL(),size.gethCarH(), null);
			  		else
				     	g.drawImage(carstyle.p1TB,car[1].getX(),car[1].moveToBottom(), size.gethCarL(),size.gethCarH(), null); 		
				 }
				 else
				 {
					 car[1].setY(255);
					 if(car[1].getX()>10) 
					 {
						 /**
						  * 姘村钩鍚戝乏妫�娴�
						  */
						 if(levelL(1))
							g.drawImage(carstyle.p1TL, car[1].getX(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);
					     else
						    g.drawImage(carstyle.p1TL, car[1].moveToLeft(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);
					 }
					 else
					 {
						 car[1].setX(0);car[1].setY(260);
						 if(!start0())
						 {
							 g.drawImage(carstyle.p1TB, car[1].getX(),car[1].getY(), size.gethCarL(),size.gethCarH(), null);
						     flag10=false;
						 }
					 }			     			  			     			     
				 }
			}
			else
			{
			   if(car[1].getX()<=680)
			   {
				   p[1] = (Point) list[1].get(1);
				   car[1].setY(p[1].y);
				   /**
					* 姘村钩鍚戝彸妫�娴嬨�佺孩缁跨伅妫�娴�
				    */
				   if(levelR(1))
					   g.drawImage(carstyle.p1TR, car[1].getX(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);				   
				   else if(car[1].getX()==200&&light.getRedTF()<0)
					   g.drawImage(carstyle.p1TR, car[1].getX(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);
				   else
				       g.drawImage(carstyle.p1TR, car[1].moveToRight(),car[1].getY(), size.getlCarL(),size.getlCarH(), null);
			     
			   }
			   else
			   {
				   if(flag11)
				   {
					   if(car[1].getY()<((Point) list[1].get(3)).y)
					   {
						   p[1] = (Point) list[1].get(2);
						   car[1].setX(p[1].x);
						   /**
	               			* 鍨傜洿鍚戜笅妫�娴� 
	               		    */
						   if(verticalB(1))
							   g.drawImage(carstyle.p1TB,car[1].getX(),car[1].getY() , size.gethCarL(),size.gethCarH(), null);
						   else
							   g.drawImage(carstyle.p1TB,car[1].getX(),car[1].moveToBottom() , size.gethCarL(),size.gethCarH(), null);
						   
					   }
					   else
					   {
						   p[1] = (Point) list[1].get(3);
						   car[1].setX(p[1].x);car[1].setY(p[1].y);
						   if(!start4())
						   {
							   g.drawImage(carstyle.p1TR, car[1].getX(),car[1].getY(), size.lCarL, size.lCarH, null);						
							   flag11=false;
						   }						  
					   }
				   }
				   else
				   {
					   p[1] = (Point) list[1].get(4);
					   car[1].setX(p[1].x);
					   if(car[1].getY()>0)
					   {
   						  /**
		        		   * 鍨傜洿鍚戜笂妫�娴嬨�佺孩缁跨伅妫�娴�
    	        		   */
				          if(verticalT(1))
						     g.drawImage(carstyle.p1TT, car[1].getX(), car[1].getY(), size.hCarL, size.hCarH, null);
					      else if(car[1].getY()==310&&light.getRedTR()>0)
						     g.drawImage(carstyle.p1TT, car[1].getX(), car[1].getY(), size.hCarL, size.hCarH, null);
						  else	    
						     g.drawImage(carstyle.p1TT, car[1].getX(), car[1].moveToTop(), size.hCarL, size.hCarH, null);						 
					   }
					   else
					   {
						   initp1();
					   }
					  
				   }
				  
			   }			  				  			    
			}
		}
		if(rand[1]==3)
		{
			if(flag10)
			{
				p[1] = (Point) list[1].get(0);
			  	 if(car[1].getY()<=p[1].y)
			  	 {
			  		/**
            		 * 鍨傜洿鍚戜笅妫�娴� 
            		 */
			  		if(verticalB(1))
			  		    g.drawImage(carstyle.p1TB,car[1].getX(),car[1].getY(), size.gethCarL(),size.gethCarH(), null);					
			  		else	
					    g.drawImage(carstyle.p1TB,car[1].getX(),car[1].moveToBottom(), size.gethCarL(),size.gethCarH(), null);					
				 }
				 else
				 {
					if(car[1].getX()>10) 
					{
						car[1].setY(255);
						/**
						 * 姘村钩鍚戝乏妫�娴�
						 */
						if(levelL(1))
							 g.drawImage(carstyle.p1TL, car[1].getX(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);
						else	
						     g.drawImage(carstyle.p1TL, car[1].moveToLeft(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);
					}
					else
					{
						car[1].setX(0);car[1].setY(260);
						if(!start0())
						{
							g.drawImage(carstyle.p1TB, car[1].getX(),car[1].getY(), size.gethCarL(),size.gethCarH(), null);
							flag10=false;
						}
					}
				    			     			  			     			     
				 }
			}
			else
			{
				   p[1] = (Point) list[1].get(1);
				   if(car[1].getX()<1000)
				   {
					   car[1].setY(p[1].y);
				 		/**
						 * 姘村钩鍚戝彸妫�娴嬨�佺孩缁跨伅妫�娴�
					     */
					   if(levelR(1)) 
						   g.drawImage(carstyle.p1TR, car[1].getX(),car[1].getY(), size.getlCarL(),size.getlCarH(), null);
					   else if(car[1].getX()==200&&light.getRedTF()<0)
						   g.drawImage(carstyle.p1TR, car[1].getX(),car[1].getY(), size.getlCarL(),size.getlCarH(), null);
					   else if(car[1].getX()==650&&light.getRedTR()<0)
						   g.drawImage(carstyle.p1TR, car[1].getX(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);
					   else     
					       g.drawImage(carstyle.p1TR, car[1].moveToRight(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);  			  			    
				   }
				   else
				   {
					   initp1();
				   }
			}
			
		}
		if(rand[1]==4)
		{
			if(flag10)
			{
				p[1] = (Point) list[1].get(0);
			  	 if(car[1].getY()<=p[1].y)
			  	 {
			  		/**
            		 * 鍨傜洿鍚戜笅妫�娴� 
            		 */
			  		 if(verticalB(1))
			  			g.drawImage(carstyle.p1TB,car[1].getX(),car[1].getY(), size.gethCarL(),size.gethCarH(), null);				
			  		 else	 
				    	g.drawImage(carstyle.p1TB,car[1].getX(),car[1].moveToBottom(), size.gethCarL(),size.gethCarH(), null);				
				 }
				 else
				 {
					if(car[1].getX()>10) 
					{
						car[1].setY(255);
						/**
						 * 姘村钩鍚戝乏妫�娴�
						 */
						if(levelL(1))
							g.drawImage(carstyle.p1TL,car[1].getX(),car[1].getY(), size.getlCarL(),size.getlCarH(), null);
						else	
					    	g.drawImage(carstyle.p1TL,car[1].moveToLeft(),car[1].getY(), size.getlCarL(),size.getlCarH(), null);
					}
					else
					{
						car[1].setX(0);car[1].setY(260);
						if(!start0())
						{
							g.drawImage(carstyle.p1TB, car[1].getX(),car[1].getY(), size.gethCarL(),size.gethCarH(), null);
							flag10=false;
						}
					}
				    			     			  			     			     
				 }
			}
			else
			{
			   if(car[1].getX()<=680)
			   {
				   p[1] = (Point) list[1].get(1);
				   car[1].setY(p[1].y);
				   /**
					* 姘村钩鍚戝彸妫�娴嬨�佺孩缁跨伅妫�娴�
				    */
				   if(levelR(1))
					   g.drawImage(carstyle.p1TR, car[1].getX(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);
				   else if(car[1].getX()==200&&light.getRedTF()<0)
					   g.drawImage(carstyle.p1TR, car[1].getX(), car[1].getY(), size.getlCarL(),size.getlCarH(), null);
				   else
				       g.drawImage(carstyle.p1TR, car[1].moveToRight(), car[1].getY(),size.getlCarL(),size.getlCarH(), null);
			   }
			   else
			   {
				   p[1] = (Point) list[1].get(2);
				   car[1].setX(p[1].x);
				   if(car[1].getY()<550)
				    {
					   /**
              		    * 鍨傜洿鍚戜笅妫�娴� 
              			*/
					   if(verticalB(1))
						  g.drawImage(carstyle.p1TB,car[1].getX(),car[1].getY(), size.gethCarL(),size.gethCarH(), null);
					   else	     
					      g.drawImage(carstyle.p1TB,car[1].getX(),car[1].moveToBottom() , size.gethCarL(),size.gethCarH(), null);
				    }
				   else
				   {
					   initp1();
				   }
			   }			  				  			    
			}
		}
		if(rand[1]==5)
		{
			
			p[1] = (Point) list[1].get(0);
			if(car[1].getY()<=p[1].y)
			{
				/**
    			 * 鍨傜洿鍚戜笅妫�娴嬨�佺孩缁跨伅妫�娴�
    			 */
				if(verticalB(1))
					g.drawImage(carstyle.p1TB,car[1].getX(),car[1].getY(), size.gethCarL(),size.gethCarH(), null);		   
			    else if(car[1].getY()==220&&light.getRedTF()>0)
					g.drawImage(carstyle.p1TB,car[1].getX(),car[1].getY(), size.gethCarL(),size.gethCarH(), null);		   
				else
			    	g.drawImage(carstyle.p1TB,car[1].getX(),car[1].moveToBottom(), size.gethCarL(),size.gethCarH(), null);		   
			}
			else
			{
				initp1();
			}
		}
		
	}
	public void carRunP2(Graphics g)
	{
		if(rand[2]==1)
		{
			p[2] = (Point) list[2].get(0);
			if(car[2].getY()<=p[2].y)
			{
				/**
       			 * 鍨傜洿鍚戜笅妫�娴� 
       			 */
				if(verticalB(2))
					g.drawImage(carstyle.getP2TB(),car[2].getX(),car[2].getY() ,size.hCarL,size.hCarH,null);			   
				else	
			    	g.drawImage(carstyle.getP2TB(),car[2].getX(),car[2].moveToBottom() ,size.hCarL,size.hCarH,null);			   
			}
			else
			{
				p[2] = (Point) list[2].get(1);
				car[2].setY(p[2].y);
				if(car[2].getX()>0)
				{
					/**
					 * 姘村钩鍚戝乏妫�娴嬨�佺孩缁跨伅妫�娴�
				     */
					if(levelL(2))
						g.drawImage(carstyle.getP2TL(),car[2].getX(),car[2].getY() ,size.lCarL,size.lCarH,null);
				    else if(car[2].getX()==303&&light.getRedTF()<0)
						g.drawImage(carstyle.getP2TL(),car[2].getX(),car[2].getY() ,size.lCarL,size.lCarH,null);
					else	
					    g.drawImage(carstyle.getP2TL(),car[2].moveToLeft(),car[2].getY(),size.lCarL,size.lCarH,null);			
				}
				else
				{
					initp2();
				}
			}
		}
		if(rand[2]==2)
		{
			if(flag20)
			{
				p[2] = (Point) list[2].get(0);
				if(car[2].getY()<=p[2].y)
				{
					/**
           			 * 鍨傜洿鍚戜笅妫�娴� 
           			 */
					if(verticalB(2))
						g.drawImage(carstyle.getP2TB(),car[2].getX(),car[2].getY() ,size.hCarL,size.hCarH,null);			   
					else	
				    	g.drawImage(carstyle.getP2TB(),car[2].getX(),car[2].moveToBottom() ,size.hCarL,size.hCarH,null);
				}
				else
				{
					p[2] = (Point) list[2].get(1);
					car[2].setY(p[2].y);
					if(car[2].getX()>p[2].x)
					{
						/**
						 * 姘村钩鍚戝乏妫�娴�
						 */
						if(levelL(2))
						   g.drawImage(carstyle.getP2TL(),car[2].getX(),car[2].getY() ,size.lCarL,size.lCarH,null);				
						else
						   g.drawImage(carstyle.getP2TL(),car[2].moveToLeft(),car[2].getY() ,size.lCarL,size.lCarH,null);	    
					}
					else
					{
						g.drawImage(carstyle.getP2TL(),car[2].getX(),car[2].getY() ,size.lCarL,size.lCarH,null);				
						flag20=false;
						car[2].setX(p[2].x);
					}
				}
			}
		    else
		    {
		    	if(car[2].getY()>0)
	          	{
		    		/**
					 * 鍨傜洿鍚戜笂妫�娴�
					 */
		    		if(verticalT(2))
		    			g.drawImage(carstyle.getP2TT(), car[2].getX(),car[2].getY(), size.hCarL, size.hCarH,null);
		    		else	
		    		    g.drawImage(carstyle.getP2TT(), car[2].getX(),car[2].moveToTop(), size.hCarL, size.hCarH,null);
	          	}
		    	else
		    	{
		    		initp2();
		    	}
		    }
		}
		if(rand[2]==3)
		{
			if(flag20)
			{
				p[2] = (Point) list[2].get(0);
				if(car[2].getY()<p[2].y)
				{
					/**
					 * 姘村钩鍚戝乏妫�娴嬨�佺孩缁跨伅妫�娴�
				     */
				    if(levelL(2))	
				    	g.drawImage(carstyle.getP2TB(), car[2].getX(),car[2].getY(), size.hCarL, size.hCarH,null);
				    else if(car[2].getY()==220&&light.getRedTR()>0)
						g.drawImage(carstyle.getP2TB(), car[2].getX(),car[2].getY(), size.hCarL, size.hCarH,null);
					else	
					    g.drawImage(carstyle.getP2TB(), car[2].getX(),car[2].moveToBottom(), size.hCarL, size.hCarH,null);
				}
				else
				{
					if(!start4())
					{
					   g.drawImage(carstyle.getP2TR(), car[2].getX(),car[2].getY(), size.lCarL, size.lCarH,null);
		               flag20=false;
					}
				}
			}
			else
			{
				p[2] = (Point) list[2].get(1);				
				if(car[2].getY()>((Point) list[2].get(2)).y)
				{
					car[2].setX(p[2].x);
					/**
					 * 鍨傜洿鍚戜笂妫�娴�
					 */
					if(verticalT(2))
						g.drawImage(carstyle.getP2TT(),car[2].getX(),car[2].getY(), size.hCarL, size.hCarH,null);
					else	
					    g.drawImage(carstyle.getP2TT(),car[2].getX(),car[2].moveToTop(), size.hCarL, size.hCarH,null);
				}
				else
				{
					p[2] = (Point) list[2].get(2);
					car[2].setY(p[2].y);
					if(car[2].getX()<1000)
					{
						/**
				   		 * 姘村钩鍚戝彸妫�娴�
				   		 */
						if(levelR(2))
							g.drawImage(carstyle.getP2TR(),car[2].getX(),car[2].getY(), size.lCarL, size.lCarH,null);
						else	
						    g.drawImage(carstyle.getP2TR(),car[2].moveToRight(),car[2].getY(), size.lCarL, size.lCarH,null);
					}
					else
					{
						initp2();
					}
				}
			}
			
		}
		if(rand[2]==4)
		{
			p[2] = (Point) list[2].get(0);
			if(car[2].getY()<p[2].y)
			{
				/**
    			 * 鍨傜洿鍚戜笅妫�娴嬨�佺孩缁跨伅妫�娴�
    			 */
				if(verticalB(2))
					g.drawImage(carstyle.getP2TB(), car[2].getX(),car[2].getY(), size.hCarL, size.hCarH,null);
			    else if(car[2].getY()==220&&light.getRedTR()>0)
					g.drawImage(carstyle.getP2TB(), car[2].getX(),car[2].getY(), size.hCarL, size.hCarH,null);
				else	
				    g.drawImage(carstyle.getP2TB(), car[2].getX(),car[2].moveToBottom(), size.hCarL, size.hCarH,null);
			}
			else
			{
				initp2();
			}
		}
		if(rand[2]==5)
		{
			if(flag20)
			{
				p[2] = (Point) list[2].get(0);
				if(car[2].getY()<=p[2].y)
				{
					/**
           			 * 鍨傜洿鍚戜笅妫�娴� 
           			 */
					if(verticalB(2))
						g.drawImage(carstyle.getP2TB(),car[2].getX(),car[2].getY() ,size.hCarL,size.hCarH,null);
					else	
					    g.drawImage(carstyle.getP2TB(),car[2].getX(),car[2].moveToBottom() ,size.hCarL,size.hCarH,null);
				}
				else
				{
					car[2].setY(255);
					if(car[2].getX()>278)
					{
						 /**
						  * 姘村钩鍚戝乏妫�娴�
						  */
						if(levelL(2))
							g.drawImage(carstyle.getP2TL(),car[2].getX(),car[2].getY() ,size.lCarL,size.lCarH,null);					
						else	
						   g.drawImage(carstyle.getP2TL(),car[2].moveToLeft(),car[2].getY() ,size.lCarL,size.lCarH,null);					
					}
					else
					{
						g.drawImage(carstyle.getP2TL(),car[2].getX(),car[2].getY() ,size.lCarL,size.lCarH,null);					
						flag20=false;
					}
				}
			}
		    else
		    {
		    	p[2] = (Point) list[2].get(1);
		    	if(flag21)
		    	{
		    		if(car[2].getY()>p[2].y)
		    		{
						car[2].setX(275);
						/**
						 * 鍨傜洿鍚戜笂妫�娴�
						 */
						if(verticalT(2))
							g.drawImage(carstyle.getP2TT(), car[2].getX(),car[2].getY(), size.hCarL, size.hCarH,null);
						else	
			    		    g.drawImage(carstyle.getP2TT(), car[2].getX(),car[2].moveToTop(), size.hCarL, size.hCarH,null);
			     
			    	}
			    	else
			    	{
			    		car[2].setX(p[2].x);car[2].setY(p[2].y);
			    		if(!start1())
			    		{
			    			g.drawImage(carstyle.getP2TL(),car[2].getX(),car[2].getY(), size.lCarL, size.lCarH,null);		        
				          	flag21=false;
			    		}
			    	}
		    	}
		    	else  		
		    	{
		    		if(car[2].getY()<550)
		    		{
		    			car[2].setX(p[2].x);
		    			/**
	        			 * 鍨傜洿鍚戜笅妫�娴嬨�佺孩缁跨伅妫�娴�
	        			 */
		    			if(verticalB(2))
		    			   g.drawImage(carstyle.getP2TB(),car[2].getX(),car[2].getY(), size.hCarL, size.hCarH,null);
		    			else if(car[2].getY()==220&&light.getRedTR()>0)
		    			   g.drawImage(carstyle.getP2TB(),car[2].getX(),car[2].getY(), size.hCarL, size.hCarH,null);
					    else	
			    		   g.drawImage(carstyle.getP2TB(),car[2].getX(),car[2].moveToBottom(), size.hCarL, size.hCarH,null);
		    		}
		    		else
		    		{
		    			initp2();
		    		}					   
		    	}		                 
		    }
		}
	}
	public void carRunP3(Graphics g)
	{
		if(rand[3]==1)
		{
			p[3]=(Point) list[3].get(0);
			if(car[3].getX()>p[3].x)
			{
				/**
				 * 姘村钩鍚戝乏妫�娴嬨�佺孩缁跨伅妫�娴�
			     */
			    if(levelL(3))
			    	g.drawImage(carstyle.getP3TL(), car[3].getX(), car[3].getY(), size.lCarL, size.lCarH, null);
			    else if(car[3].getX()==750&&light.getRedTR()<0)
					g.drawImage(carstyle.getP3TL(), car[3].getX(), car[3].getY(), size.lCarL, size.lCarH, null);
				else if(car[3].getX()==300&&light.getRedTR()<0)
					g.drawImage(carstyle.getP3TL(), car[3].getX(), car[3].getY(), size.lCarL, size.lCarH, null);
				else		
				    g.drawImage(carstyle.getP3TL(), car[3].moveToLeft(), car[3].getY(), size.lCarL, size.lCarH, null);
			}
			else
			{
				initp3();
			}
		}
		if(rand[3]==2)
		{
			p[3]=(Point) list[3].get(0);
			if(car[3].getX()>p[3].x)
			{
				/**
				 * 姘村钩鍚戝乏妫�娴嬨�佺孩缁跨伅妫�娴�
			     */
				if(levelL(3))
					g.drawImage(carstyle.getP3TL(), car[3].getX(), car[3].getY(), size.lCarL, size.lCarH, null);  	
			    else if(car[3].getX()==750&&light.getRedTR()<0)
					g.drawImage(carstyle.getP3TL(), car[3].getX(), car[3].getY(), size.lCarL, size.lCarH, null);
				else
				    g.drawImage(carstyle.getP3TL(), car[3].moveToLeft(), car[3].getY(), size.lCarL, size.lCarH, null);
			    
			}
			else
			{
				if(car[3].getY()>0)
				{
					car[3].setX(p[3].x);
					/**
					 * 鍨傜洿鍚戜笂妫�娴�
					 */
					if(verticalT(3))
					   g.drawImage(carstyle.getP3TT(), car[3].getX(), car[3].getY(), size.hCarL, size.hCarH, null);
					else	
					   g.drawImage(carstyle.getP3TT(), car[3].getX(), car[3].moveToTop(), size.hCarL, size.hCarH, null);
				}
				else
				{
					initp3();
				}
			}
		}
		if(rand[3]==3)
		{
			p[3]=(Point) list[3].get(0);
			if(car[3].getX()>p[3].x)
			{
				/**
				 * 姘村钩鍚戝乏妫�娴�
				 */
				if(levelL(3))
				   g.drawImage(carstyle.getP3TL(), car[3].getX(), car[3].getY(), size.lCarL, size.lCarH, null);	
				else 	
				   g.drawImage(carstyle.getP3TL(), car[3].moveToLeft(), car[3].getY(), size.lCarL, size.lCarH, null);
			}
			else
			{
				if(car[3].getY()>0)
				{
					car[3].setX(p[3].x);
					/**
					 * 鍨傜洿鍚戜笂妫�娴�
					 */
					if(verticalT(3))
						g.drawImage(carstyle.getP3TT(), car[3].getX(), car[3].getY(), size.hCarL, size.hCarH, null);
					else	
					    g.drawImage(carstyle.getP3TT(), car[3].getX(), car[3].moveToTop(), size.hCarL, size.hCarH, null);
				}
				else
				{
					initp3();
				}
			}
		}
		if(rand[3]==4)
		{
			if(flag30)
			{
				p[3]=(Point) list[3].get(0);
				if(car[3].getX()>p[3].x)
				{
					 /**
					  * 姘村钩鍚戝乏妫�娴�
					  */
					if(levelL(3))
						g.drawImage(carstyle.getP3TL(), car[3].getX(), car[3].getY(), size.lCarL, size.lCarH, null);
					else	
					    g.drawImage(carstyle.getP3TL(), car[3].moveToLeft(), car[3].getY(), size.lCarL, size.lCarH, null);
				}
				else
				{
				    if(car[3].getY()>0)
				    {
				    	car[3].setX(p[3].x);
				    	/**
						 * 鍨傜洿鍚戜笂妫�娴�
						 */
				    	if(verticalT(3))
				    		g.drawImage(carstyle.getP3TT(), car[3].getX(), car[3].getY(), size.hCarL, size.hCarH, null);
				    	else	
				    	   g.drawImage(carstyle.getP3TT(), car[3].getX(), car[3].moveToTop(), size.hCarL, size.hCarH, null);
				    }
				    else
				    {
				    	p[3]=(Point) list[3].get(1);
				    	car[3].setX(p[3].x);car[3].setY(p[3].y);
				    	if(!start2())
				    	{
				    		g.drawImage(carstyle.getP3TL(),car[3].getX(),car[3].getY(), size.lCarL, size.lCarH, null);
					    	flag30=false;
				    	}
				    }	    	
					
				}
			}
			else
			{
				p[3]=(Point) list[3].get(2);
				if(car[3].getY()<p[3].y)
				{
					car[3].setX(p[3].x);
					/**
        			 * 鍨傜洿鍚戜笅妫�娴嬨�佺孩缁跨伅妫�娴�
        			 */
					if(verticalB(3))
						g.drawImage(carstyle.getP3TB(), car[3].getX(), car[3].getY(), size.hCarL, size.hCarH, null);
					else if(car[3].getY()==220&&light.getRedTR()>0)
						g.drawImage(carstyle.getP3TB(), car[3].getX(), car[3].getY(), size.hCarL, size.hCarH, null);
					else	
				       g.drawImage(carstyle.getP3TB(), car[3].getX(), car[3].moveToBottom(), size.hCarL, size.hCarH, null);
				
				}
				else
				{
					initp3();
				}
			}
			
		}
		if(rand[3]==5)
		{
			if(flag30)
			{
				p[3]=(Point) list[3].get(0);
				if(car[3].getX()>p[3].x)
				{
					/**
					 * 姘村钩鍚戝乏妫�娴嬨�佺孩缁跨伅妫�娴�
				     */
					if(levelL(3))
						g.drawImage(carstyle.getP3TL(), car[3].getX(), car[3].getY(), size.lCarL, size.lCarH, null);
				    else if(car[3].getX()==750&&light.getRedTR()<0)
						g.drawImage(carstyle.getP3TL(), car[3].getX(), car[3].getY(), size.lCarL, size.lCarH, null);
					else	
					   g.drawImage(carstyle.getP3TL(), car[3].moveToLeft(), car[3].getY(), size.lCarL, size.lCarH, null);
				   
				}
				else
				{
				    if(car[3].getY()>0)
				    {
				    	car[3].setX(p[3].x);
				    	/**
						 * 鍨傜洿鍚戜笂妫�娴�
						 */
				    	if(verticalT(3))
				    	   g.drawImage(carstyle.getP3TT(), car[3].getX(), car[3].getY(), size.hCarL, size.hCarH, null);
				    	else	
				    	   g.drawImage(carstyle.getP3TT(), car[3].getX(), car[3].moveToTop(), size.hCarL, size.hCarH, null);
				    }
				    else
				    {
				    	p[3]=(Point) list[3].get(1);
				    	car[3].setX(p[3].x);car[3].setY(p[3].y);
				    	if(!start1())
				    	{
				    		g.drawImage(carstyle.getP3TL(),car[3].getX(),car[3].getY(), size.lCarL, size.lCarH, null);
					    	flag30=false;
				    	}
				    }	    									
				}
			}
			else
			{
				p[3]=(Point) list[3].get(2);
				if(car[3].getY()<p[3].y)
				{ 
					car[3].setX(p[3].x);
					/**
           			 * 鍨傜洿鍚戜笅妫�娴� 銆佺孩缁跨伅妫�娴�
           			 */
					if(verticalB(3))
					  g.drawImage(carstyle.getP3TB(),car[3].getX(), car[3].getY(), size.hCarL, size.hCarH, null);
					else if(car[3].getY()==220&&light.getRedTF()>0)
					  g.drawImage(carstyle.getP3TB(),car[3].getX(), car[3].getY(), size.hCarL, size.hCarH, null);
				    else	
					  g.drawImage(carstyle.getP3TB(),car[3].getX(), car[3].moveToBottom(), size.hCarL, size.hCarH, null);
				}
				else
				{
					initp3();
				}		  
			}
		}
	}
	public void carRunP4(Graphics g)
	{
		if(rand[4]==1)
		{
			 if(flag40)
			 {
				 p[4] = (Point) list[4].get(0);
	            	if(car[4].getY()>p[4].y)
	    			{
	            		if(verticalT(4))
	            			 g.drawImage(carstyle.getP4TT(), car[4].getX(),car[4].getY(), size.hCarL,size.hCarH, null);
	            		else	
	    				     g.drawImage(carstyle.getP4TT(), car[4].getX(),car[4].moveToTop(), size.hCarL,size.hCarH, null);
	    			 
	    			}
	    			else
	    			{			
	    			    if(car[4].getX()<970)
	    				{
	    			    	car[4].setY(p[4].y);
	    			    	if(levelR(4))
	    			    	   g.drawImage(carstyle.getP4TR(), car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);
	    			    	else	
	    					   g.drawImage(carstyle.getP4TR(), car[4].moveToRight(),car[4].getY(), size.lCarL,size.lCarH, null);
	    			   	}
	    				else
	    				{
	    					p[4] = (Point) list[4].get(1);
	    					car[4].setX(p[4].x);car[4].setY(p[4].y);
	    					if(!start3())
	    					{
	    						g.drawImage(carstyle.getP4TT(),car[4].getX(),car[4].getY(), size.hCarL,size.hCarH, null);
		    					flag40=false;
	    					}
	    				}
	    			 
	    			}
				}
			 else
			 {
				 p[4] = (Point) list[4].get(2);
				 if(car[4].getX()>=0)
				 {
					 car[4].setY(p[4].y);
					 if(levelL(4))
						 g.drawImage(carstyle.getP4TL(),car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);	            	
					 else if(car[4].getX()==750&&light.getRedTR()<0)
						 g.drawImage(carstyle.getP4TL(),car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);	            	
					 else if(car[4].getX()==300&&light.getRedTR()<0)
						 g.drawImage(carstyle.getP4TL(), car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);	            	 
					 else  
					     g.drawImage(carstyle.getP4TL(), car[4].moveToLeft(),car[4].getY(), size.lCarL,size.lCarH, null);	            	
				 }
				 else
				{
					 initp4();
				}
			 }
		}
		if(rand[4]==2)
		{
			 if(flag40)
			 {
				 p[4] = (Point) list[4].get(0);
	            	if(car[4].getY()>p[4].y)
	    			{
	            		if(verticalT(4))
	            			g.drawImage(carstyle.getP4TT(),car[4].getX(),car[4].getY(), size.hCarL,size.hCarH, null);
	            		else	
	    			    	g.drawImage(carstyle.getP4TT(),car[4].getX(),car[4].moveToTop(), size.hCarL,size.hCarH, null);
	    			 
	    			}
	    			else
	    			{			
	    			    if(car[4].getX()<970)
	    				{
	    			    	car[4].setY(p[4].y);
	    			    	if(levelR(4))
	    			    	   g.drawImage(carstyle.getP4TR(), car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);
	    			    	else	
	    					   g.drawImage(carstyle.getP4TR(), car[4].moveToRight(),car[4].getY(), size.lCarL,size.lCarH, null);
	    			   	}
	    				else
	    				{
	    					p[4] = (Point) list[4].get(1);
	    					car[4].setX(p[4].x);car[4].setY(p[4].y);
	    					if(!start3())
	    					{
	    						g.drawImage(carstyle.getP4TT(),car[4].getX(),car[4].getY(),size.hCarL,size.hCarH, null);
		    					flag40=false;
	    					}
	    				}
	    			 
	    			}
				}
	            else
	            {
	            	p[4] = (Point) list[4].get(2);
	            	if(car[4].getX()>((Point) list[4].get(3)).x)
	            	{
	            		car[4].setY(p[4].y);
	            		if(levelL(4))
	            			 g.drawImage(carstyle.getP4TL(), car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);
	            		else if(car[4].getX()==750&&light.getRedTR()<0)
							 g.drawImage(carstyle.getP4TL(), car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);	            	
	            		else
	            		     g.drawImage(carstyle.getP4TL(), car[4].moveToLeft(),car[4].getY(), size.lCarL,size.lCarH, null);
	            	  
	            	}
	            	else
	            	{
	            		p[4] = (Point) list[4].get(3);
	            		if(car[4].getY()>0)
	            		{
	            			car[4].setX(p[4].x);
	            			if(verticalT(4))
	            			   g.drawImage(carstyle.getP4TT(), car[4].getX(),car[4].getY(), size.hCarL,size.hCarH, null);
	            			else	
	            			   g.drawImage(carstyle.getP4TT(), car[4].getX(),car[4].moveToTop(), size.hCarL,size.hCarH, null);
	            		}
	            		else
	            		{
	            			initp4();
	            		}
	            	}
	            }
		}
		if(rand[4]==3)
		{
            if(car[4].getY()>0)
            {
            	if(verticalT(4))
            		g.drawImage(carstyle.getP4TT(),car[4].getX(),car[4].getY(),size.hCarL,size.hCarH,null);
                else if(car[4].getY()==300&&light.getRedTR()>0)
            		g.drawImage(carstyle.getP4TT(),car[4].getX(),car[4].getY(),size.hCarL,size.hCarH,null);
            	else
            		g.drawImage(carstyle.getP4TT(),car[4].getX(),car[4].moveToTop(),size.hCarL,size.hCarH,null);
            }
            else
            {
            	initp4();
            }	
		}
		if(rand[4]==4)
		{
			p[4] = (Point) list[4].get(0);
			if(car[4].getY()>p[4].y)
			{
				if(verticalT(4))
				   g.drawImage(carstyle.getP4TT(),car[4].getX(),car[4].getY(), size.hCarL,size.hCarH, null);
				else	
				   g.drawImage(carstyle.getP4TT(),car[4].getX(),car[4].moveToTop(), size.hCarL,size.hCarH, null);		 
			}
			else
			{
				if(car[4].getX()<1000)
				{
					car[4].setY(p[4].y);
					if(levelR(4))
					   g.drawImage(carstyle.getP4TR(), car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);
					else	
					   g.drawImage(carstyle.getP4TR(), car[4].moveToRight(),car[4].getY(), size.lCarL,size.lCarH, null);
				}
				else
				{
					initp4();
				}
			}
		}
		if(rand[4]==5)
		{
			if(flag40)
			{
				p[4] = (Point) list[4].get(0);
	            	if(car[4].getY()>p[4].y)
	    			{
	            		if(verticalT(4))
	            			g.drawImage(carstyle.getP4TT(), car[4].getX(),car[4].getY(), size.hCarL,size.hCarH, null);
	            		else	
	    			     	g.drawImage(carstyle.getP4TT(), car[4].getX(),car[4].moveToTop(), size.hCarL,size.hCarH, null);
	    			}
	    			else
	    			{			
	    			    if(car[4].getX()<970)
	    				{
	    			    	car[4].setY(p[4].y);
	    			    	if(levelR(4))
	    			    		g.drawImage(carstyle.getP4TR(), car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);
	    			    	else	 
	    				    	g.drawImage(carstyle.getP4TR(), car[4].moveToRight(),car[4].getY(), size.lCarL,size.lCarH, null);
	    			   	}
	    				else
	    				{
	    					p[4] = (Point) list[4].get(1);
	    					car[4].setX(p[4].x);car[4].setY(p[4].y);
	    					if(!start3())
	    					{
	    						g.drawImage(carstyle.getP4TT(), car[4].getX(),car[4].getY(), size.hCarL,size.hCarH, null);
	 	    					flag40=false;
	    					}	    					
	    				}	    			  
	    			}
				}
	            else
	            {
	            	if(flag41)
	            	{
	            		p[4] = (Point) list[4].get(2);		
	            		if(car[4].getX()>((Point) list[4].get(3)).x)
		            	{
	            			car[4].setY(p[4].y);
	            			if(levelL(4))
	            				 g.drawImage(carstyle.getP4TL(), car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);	           
	            			else if(car[4].getX()==750&&light.getRedTR()<0)
								 g.drawImage(carstyle.getP4TL(), car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);	            	
		            		else
		            		     g.drawImage(carstyle.getP4TL(), car[4].moveToLeft(),car[4].getY(), size.lCarL,size.lCarH, null);	            	
		            	}
		            	else
		            	{
		            		p[4] = (Point) list[4].get(3);
		            		car[4].setX(p[4].x);
		            		if(car[4].getY()>0)
		            	    {
		            			if(verticalT(4))
		            				 g.drawImage(carstyle.getP4TT(), car[4].getX(),car[4].getY(), size.hCarL,size.hCarH, null);
		            			else	
		            			    g.drawImage(carstyle.getP4TT(), car[4].getX(),car[4].moveToTop(), size.hCarL,size.hCarH, null);
		            	    }
		            		else
		            		{
		            			p[4] = (Point) list[4].get(4);
		            			car[4].setX(p[4].x);car[4].setY(p[4].y);
		            			if(!start1())
		            			{
		            				g.drawImage(carstyle.getP4TL(), car[4].getX(),car[4].getY(), size.lCarL,size.lCarH, null);		        
			            		    flag41=false;
		            			} 		            			
		            		}
		            	
		            	}
	            	}
	            	else
	            	{
	            		if(car[4].getY()<550)
	            		{
	            			car[4].setX(p[4].x);
	            			if(verticalB(4))
	            				g.drawImage(carstyle.getP4TB(), car[4].getX(),car[4].getY(), size.hCarL,size.hCarH, null);
	            			else if(car[4].getY()==220&&light.getRedTF()>0)
	            				g.drawImage(carstyle.getP4TB(), car[4].getX(),car[4].getY(), size.hCarL,size.hCarH, null);
	            			else	
	            			   g.drawImage(carstyle.getP4TB(), car[4].getX(),car[4].moveToBottom(), size.hCarL,size.hCarH, null);
	            		}
	            		else
	            		{
	            			initp4();	            	 
	            		}
	            	}
	            	
	            }
		}
	}
	public void carRunP5(Graphics g)
	{
		if(rand[5]==1)
		{
			if(flag50)
			{
				if(car[5].getY()>0)
				{
					if(verticalT(5))
						g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].getY(), size.hCarL, size.hCarH, null);			
				    else if(car[5].getY()==300&&light.getRedTF()>0)
					   g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].getY(), size.hCarL, size.hCarH, null);			
					else	
			    	   g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].moveToTop(), size.hCarL, size.hCarH, null);			
			    }
			    else
			    {
			    	p[5] = (Point) list[5].get(0);
			    	car[5].setX(p[5].x);car[5].setY(p[5].y);
			    	if(!start1())
			    	{
			    		g.drawImage(carstyle.getP5TL(), car[5].getX(),car[5].getY(), size.lCarL, size.lCarH, null);		   
				    	flag50=false;
			    	}			    	
			    }
			}
			else
			{
				p[5] = (Point) list[5].get(1);
				if(car[5].getY()<p[5].y)
				{
					car[5].setX(p[5].x);
					if(verticalB(5))
						g.drawImage(carstyle.getP5TB(), car[5].getX(),car[5].getY(), size.hCarL, size.hCarH, null);
					else	
					    g.drawImage(carstyle.getP5TB(), car[5].getX(),car[5].moveToBottom(), size.hCarL, size.hCarH, null);		    	
					car[5].setX(((Point) list[5].get(2)).x);
				}
				else
				{
					p[5] = (Point) list[5].get(2);
					if(car[5].getX()>0)
					{
						car[5].setY(p[5].y);
						if(levelL(5))
							g.drawImage(carstyle.getP5TL(), car[5].getX(),car[5].getY(), size.lCarL, size.lCarH, null);
						else	
						    g.drawImage(carstyle.getP5TL(), car[5].moveToLeft(),car[5].getY(), size.lCarL, size.lCarH, null);
					}
					else
					{
						initp5();						
					}
				}
			}
		   
		}
		if(rand[5]==2)
		{
			if(car[5].getY()>0)
		    {
				if(verticalT(5))
				   g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].getY(), size.hCarL, size.hCarH, null);
			    else if(car[5].getY()==300&&light.getRedTF()>0)
				   g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].getY(), size.hCarL, size.hCarH, null);			
				else	
		    	   g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].moveToTop(), size.hCarL, size.hCarH, null);	    	
		    }
			else
			{
				initp5();
			}
		}
		if(rand[5]==3)
		{
			if(flag50)
			{
				p[5] = (Point) list[5].get(0);
				if(car[5].getY()>280)
				{
					if(verticalT(5))
						g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].getY(), size.hCarL, size.hCarH, null);
					else	
					   g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].moveToTop(), size.hCarL, size.hCarH, null);   	
				}
				else
				{
					if(car[5].getX()<960)
					{
						car[5].setY(p[5].y);
						if(levelR(5))
							 g.drawImage(carstyle.getP5TR(), car[5].getX(),car[5].getY(), size.lCarL, size.lCarH, null);
						else if(car[5].getX()==655&&light.getRedTR()<0)
							 g.drawImage(carstyle.getP5TR(), car[5].getX(),car[5].getY(), size.lCarL, size.lCarH, null);
						else	
					         g.drawImage(carstyle.getP5TR(), car[5].moveToRight(),car[5].getY(), size.lCarL, size.lCarH, null);	    	  
					}
					else
					{
						p[5] = (Point) list[5].get(1);
						car[5].setX(p[5].x);car[5].setY(p[5].y);
						if(!start3())
						{
							g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].getY(), size.hCarL, size.hCarH, null);							        		
			        		flag50=false;
						}		
					}
				}
			}
			else
			{
				p[5] = (Point) list[5].get(3);
				if(car[5].getX()>p[5].x)
				{
					car[5].setY(p[5].y);
					p[5] = (Point) list[5].get(2);
					if(levelL(5))
						g.drawImage(carstyle.getP5TL(), car[5].getX(),car[5].getY(), size.lCarL, size.lCarH, null);
					else	
					   g.drawImage(carstyle.getP5TL(), car[5].moveToLeft(),car[5].getY(), size.lCarL, size.lCarH, null);			    				    	
				}
				else
				{
					car[5].setX(p[5].x);
					if(car[5].getY()>0)
					{
						if(verticalT(5))
							g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].getY(), size.hCarL, size.hCarH, null);	
						else	
						   g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].moveToTop(), size.hCarL, size.hCarH, null);					
					}
					else
					{
						initp5();
					}
				}
			}			
		}
		if(rand[5]==4)
		{
			p[5] = (Point) list[5].get(0);
			if(car[5].getY()>p[5].y)
			{
				if(verticalT(5))
					g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].getY(), size.hCarL, size.hCarH, null);
				else	
			    	g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].moveToTop(), size.hCarL, size.hCarH, null);  	
			}
			else
			{
				if(car[5].getX()<1000)
				{
					car[5].setY(p[5].y);
					if(levelR(5))
						 g.drawImage(carstyle.getP5TR(), car[5].getX(),car[5].getY(), size.lCarL, size.lCarH, null);
					else if(car[5].getX()==655&&light.getRedTR()<0)
						 g.drawImage(carstyle.getP5TR(), car[5].getX(),car[5].getY(), size.lCarL, size.lCarH, null);
					else	
					     g.drawImage(carstyle.getP5TR(), car[5].moveToRight(),car[5].getY(), size.lCarL, size.lCarH, null);			    	
				}
				else
				{
					initp5();
				}
			}
		}
		if(rand[5]==5)
		{
			if(flag50)
			{
				p[5] = (Point) list[5].get(0);
				if(car[5].getY()>p[5].y)
				{
					if(verticalT(5))
					    	g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].getY(), size.hCarL, size.hCarH, null);
					else	
				    	   g.drawImage(carstyle.getP5TT(), car[5].getX(),car[5].moveToTop(), size.hCarL, size.hCarH, null);
			    
				}
				else
				{
					p[5] = (Point) list[5].get(1);
					car[5].setY(p[5].y);
					if(car[5].getX()<678)
					{
						if(levelR(5))
							 g.drawImage(carstyle.getP5TR(), car[5].getX(),car[5].getY(), size.lCarL, size.lCarH, null);
						else	
						     g.drawImage(carstyle.getP5TR(), car[5].moveToRight(),car[5].getY(), size.lCarL, size.lCarH, null);				
					}
					else
						flag50=false;				
				}
			}
			else
			{ 
				car[5].setX(p[5].x);
				if(car[5].getY()<550)
				{
					if(verticalB(5))
						 g.drawImage(carstyle.getP5TB(), car[5].getX(),car[5].getY(), size.hCarL, size.hCarH, null);
					else	
					   g.drawImage(carstyle.getP5TB(), car[5].getX(),car[5].moveToBottom(), size.hCarL, size.hCarH, null);
				}
				else
				{
					initp5();
				}
			}
			
		}
	}
	public void carRunP6(Graphics g)
	{ 	
			if(rand[6]==1)
			{ 
               	if(car[6].getX()<=220)
               	{   	 
               		if(levelR(6))
               			g.drawImage(carstyle.getP5TR(),car[6].getX(),car[6].getY(), size.getlCarL(),size.getlCarH(), null);
               		else	
               	       g.drawImage(carstyle.getP5TR(),car[6].moveToRight(),car[6].getY(), size.getlCarL(),size.getlCarH(), null);              
               	}
               	else
               	{
               		p[6] = (Point) list[6].get(1);
               		if(flag60)
               		{
               			car[6].setX(p[6].x);
               			if(verticalB(6))
               			   g.drawImage(carstyle.getP5TB(),car[6].getX(),car[6].getY(), size.gethCarL(),size.gethCarH(),null);
               			else	
               			   g.drawImage(carstyle.getP5TB(),car[6].getX(),car[6].moveToBottom(), size.gethCarL(),size.gethCarH(),null);           	
               			if(car[6].getY()==p[6].y)
               				flag60=false;
               		}
               		else 
               		{
               			if(flag61)
               			{
               				p[6] = (Point) list[6].get(2);
               				car[6].setX(p[6].x);car[6].setY(p[6].y);
               				if(!start5())
               				{
               				    g.drawImage(carstyle.getP5TR(),car[6].getX(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);        
                  			    flag61=false;
               				}            			 
               			}              			               			             			
               			else
               			{
               				p[6] = (Point) list[6].get(3);
               				if(car[6].getY()>0)
               				{
               					car[6].setX(p[6].x);
               					if (verticalT(6))
               					   g.drawImage(carstyle.getP5TT(),car[6].getX(),car[6].getY(),size.gethCarL(),size.gethCarH(),null);
               					else if(car[6].getY()==308&&light.getRedTF()>0)
               					   g.drawImage(carstyle.getP5TT(),car[6].getX(),car[6].getY(),size.gethCarL(),size.gethCarH(),null);
                   				else
                   				   g.drawImage(carstyle.getP5TT(),car[6].getX(),car[6].moveToTop(),size.gethCarL(),size.gethCarH(),null);
               				}
               				else
               				{
               				    initp6();              				   
               				}               				
               			}                       
               		}
               	}
			}
			if(rand[6]==2)
			{
				p[6] = (Point) list[6].get(0);
				 if(flag60)
				 {
					 if(levelR(6))
						 g.drawImage(carstyle.getP5TR(),car[6].getX(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);
				     else if(car[6].getX()==200&&light.getRedTF()<0)
						 g.drawImage(carstyle.getP5TR(),car[6].getX(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);
					 else  if(car[6].getX()==650&&light.getRedTR()<0)
						 g.drawImage(carstyle.getP5TR(),car[6].getX(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);
					 else
					    g.drawImage(carstyle.getP5TR(),car[6].moveToRight(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);				   
				     if(car[6].getX()==p[6].x)
                     {
				    	 p[6] = (Point) list[6].get(1);
				    	 car[6].setX(p[6].x);car[6].setY(p[6].y);
				    	 if(!start3())
				    	 {
							 g.drawImage(carstyle.getP5TT(),car[6].getX(),car[6].getY(),size.gethCarL(),size.gethCarH(),null);					
					    	 flag60=false; 
				    	 }
                     }
				 }
				 else
				 {
					 if(flag61)
					 {
						 p[6] = (Point) list[6].get(2);
						 car[6].setY(p[6].y);
						 if(levelL(6))
							 g.drawImage(carstyle.getP5TL(),car[6].getX(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);
						 else	 
						     g.drawImage(carstyle.getP5TL(),car[6].moveToLeft(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);					
						 p[6] = (Point) list[6].get(3);
						 if(car[6].getX()==p[6].x)											
						 {
							 p[6] = (Point) list[6].get(4);
							 car[6].setY(p[6].y);
							 flag61=false;
						 }
					 }					 
					 else
					 {
						 p[6] = (Point) list[6].get(4);
						 car[6].setX(p[6].x);
						 if(car[6].getY()>0)
						 {
							 if(verticalT(6))
								 g.drawImage(carstyle.getP5TT(),car[6].getX(),car[6].getY(),size.gethCarL(),size.gethCarH(),null);
							 else	 
							     g.drawImage(carstyle.getP5TT(),car[6].getX(),car[6].moveToTop(),size.gethCarL(),size.gethCarH(),null);
						 }
						 else
						 {
							 initp6();
						 }
					}
				 }
			}
			if(rand[6]==3)
			{
				p[6] = (Point) list[6].get(0);
				 if(car[6].getX()<p[6].x)
				 {
					 if(levelR(6))
						 g.drawImage(carstyle.getP5TR(),car[6].getX(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);
				     else if(car[6].getX()==200&&light.getRedTF()<0)
						 g.drawImage(carstyle.getP5TR(),car[6].getX(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);
					 else  if(car[6].getX()==650&&light.getRedTR()<0)
						 g.drawImage(carstyle.getP5TR(),car[6].getX(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);
					 else
					     g.drawImage(carstyle.getP5TR(),car[6].moveToRight(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);				
				 }
				 else
				 {
					 initp6();
				 }		
			}
			if(rand[6]==4)
			{
				p[6] = (Point) list[6].get(0);
			 	if(car[6].getX()<=p[6].x)
               	{   
			 		if(levelR(6))
			 			 g.drawImage(carstyle.getP5TR(),car[6].getX(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);
			    	else if(car[6].getX()==200&&light.getRedTF()<0)
						 g.drawImage(carstyle.getP5TR(),car[6].getX(),car[6].getY(),size.getlCarL(),size.getlCarH(),null);
			 		else
               		     g.drawImage(carstyle.getP5TR(), car[6].moveToRight(), car[6].getY(), size.getlCarL(),size.getlCarH(), null);
               	}
			 	else
			 	{
			 		p[6] = (Point) list[6].get(1);	
               		if(car[6].getY()<p[6].y)
               		{
               			if(verticalB(6))
               				g.drawImage(carstyle.getP5TB(),p[6].x,car[6].getY(), size.gethCarL(),size.gethCarH(),null);
               			else
               		    	g.drawImage(carstyle.getP5TB(),p[6].x,car[6].moveToBottom(), size.gethCarL(),size.gethCarH(),null);
               		}
               		else
               		{
               			initp6();              
               		}
			 	}
			}
			if(rand[6]==5)
			{
				p[6] = (Point) list[6].get(0);
			   	if(car[6].getX()<=p[6].x)
               	{   	
			   		if(levelR(6))
			   		    g.drawImage(carstyle.getP5TR(), car[6].getX(), car[6].getY(), size.getlCarL(),size.getlCarH(), null);
			   		else	
               		    g.drawImage(carstyle.getP5TR(), car[6].moveToRight(), car[6].getY(), size.getlCarL(),size.getlCarH(), null);
               	}
               	else
               	{
               		 p[6] = (Point) list[6].get(1);
               		 car[6].setX(p[6].x);
               		 if(car[6].getY()<p[6].y)
               		 {             
               			if(verticalB(6))
               			   g.drawImage(carstyle.getP5TB(),car[6].getX(),car[6].getY(), size.gethCarL(),size.gethCarH(),null);
               			else	
               			   g.drawImage(carstyle.getP5TB(),car[6].getX(),car[6].moveToBottom(), size.gethCarL(),size.gethCarH(),null);
               		 }
               		 else
               		 {
               			 initp6();
               		 }
               	}		
			}
	}
	public void carRunP7(Graphics g)
	{		
		if(rand[7]==1)
		{
            p[7] = (Point) list[7].get(0);
			if(car[7].getY()<=p[7].y)
			{
				if(verticalB(7))
					 g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].getY(), size.gethCarL(),size.gethCarH(), null);
				else	
				     g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].moveToBottom(), size.gethCarL(),size.gethCarH(), null);
			}
			else
			{
				p[7] = (Point) list[7].get(1);
				car[7].setY(p[7].y);
				if(car[7].getX()>0)
				{
					if(levelL(7))
						g.drawImage(carstyle.getP3TL(), car[7].getX(), car[7].getY(), size.getlCarL(),size.getlCarH(), null);
					else	
					   g.drawImage(carstyle.getP3TL(), car[7].moveToLeft(), car[7].getY(), size.getlCarL(),size.getlCarH(), null);
				}
				else
				{
					initp7();
				}
			}
		}
		if(rand[7]==2)
		{
			if(flag70)
			{
				 p[7] = (Point) list[7].get(0);
			  	 if(car[7].getY()<=p[7].y)
			  	 {
			  		 if(verticalB(7))
			  			g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].getY(), size.gethCarL(),size.gethCarH(), null); 
			  		 else	 
				     	g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].moveToBottom(), size.gethCarL(),size.gethCarH(), null);				
				 }
				 else
				 {
					 car[7].setY(255);
					 if(car[7].getX()>10) 
					 {
						 if(levelL(7))
							 g.drawImage(carstyle.getP3TL(), car[7].getX(), car[7].getY(), size.getlCarL(),size.getlCarH(), null); 
						 else	 
						    g.drawImage(carstyle.getP3TL(), car[7].moveToLeft(), car[7].getY(), size.getlCarL(),size.getlCarH(), null);
					 }
					 else
					 {
						 car[7].setX(0);car[7].setY(260);
						 if(!start0())
						 {
							 g.drawImage(carstyle.getP3TB(), car[7].getX(),car[7].getY(), size.gethCarL(),size.gethCarH(), null);
							 flag70=false; 
						 }
					 }			     			  			     			     
				 }
			}
			else
			{
			   if(car[7].getX()<=680)
			   {
				   p[7] = (Point) list[7].get(1);
				   car[7].setY(p[7].y);
				   if(levelR(7))
					   g.drawImage(carstyle.getP3TR(), car[7].getX(), car[7].getY(), size.getlCarL(),size.getlCarH(), null); 
				   else if(car[7].getX()==200&&light.getRedTF()<0)
					   g.drawImage(carstyle.getP3TR(), car[7].getX(), car[7].getY(), size.getlCarL(),size.getlCarH(), null);
				   else
				       g.drawImage(carstyle.getP3TR(), car[7].moveToRight(),car[7].getY(), size.getlCarL(),size.getlCarH(), null);
			     
			   }
			   else
			   {
				   if(flag71)
				   {
					   if(car[7].getY()<((Point) list[7].get(3)).y)
					   {
						   p[7] = (Point) list[7].get(2);
						   car[7].setX(p[7].x);
						   if(verticalB(7))
							   g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].getY(), size.gethCarL(),size.gethCarH(), null); 
						   else	   
						       g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].moveToBottom() , size.gethCarL(),size.gethCarH(), null);				   
					   }
					   else
					   {
						   p[7] = (Point) list[7].get(3);
						   car[7].setX(p[7].x);car[7].setY(p[7].y);
						   if(!start4())
						   {
							   g.drawImage(carstyle.getP3TR(), car[1].getX(),car[7].getY(), size.lCarL, size.lCarH, null);						
							   flag71=false; 
						   }
					   }
				   }
				   else
				   {
					   p[7] = (Point) list[7].get(4);
					   car[7].setX(p[7].x);
					   if(car[7].getY()>0)
					   {
						    if(verticalT(7))
						    	g.drawImage(carstyle.getP3TT(), car[7].getX(), car[7].getY(), size.hCarL, size.hCarH, null);
					        else if(car[7].getY()==310&&light.getRedTR()>0)
					     	   g.drawImage(carstyle.getP3TT(), car[7].getX(), car[7].getY(), size.hCarL, size.hCarH, null);
						    else	    
						       g.drawImage(carstyle.getP3TT(), car[7].getX(), car[7].moveToTop(), size.hCarL, size.hCarH, null);
							 
					   }
					   else
					   {
						   initp7();
					   }
					  
				   }
				  
			   }			  				  			    
			}
		}
		if(rand[7]==3)
		{
			if(flag70)
			{
				p[7] = (Point) list[7].get(0);
			  	 if(car[7].getY()<=p[7].y)
			  	 {
			  		 if(verticalB(7))
			  			g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].getY(), size.gethCarL(),size.gethCarH(), null);
			  		 else	 
					    g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].moveToBottom(), size.gethCarL(),size.gethCarH(), null);
					
				 }
				 else
				 {
					if(car[7].getX()>10) 
					{
						car[7].setY(255);
						if(levelL(7))
							g.drawImage(carstyle.getP3TL(), car[7].getX(), car[7].getY(), size.getlCarL(),size.getlCarH(), null);
						else	
						    g.drawImage(carstyle.getP3TL(), car[7].moveToLeft(), car[7].getY(), size.getlCarL(),size.getlCarH(), null);
					}
					else
					{
						car[7].setX(0);car[7].setY(260);
						if(!start0())
						{
							g.drawImage(carstyle.getP3TB(), car[7].getX(),car[7].getY(), size.gethCarL(),size.gethCarH(), null);
							flag70=false;	
						}
					}				    			     			  			     			     
				 }
			}
			else
			{
				p[7] = (Point) list[7].get(1);
				   if(car[7].getX()<1000)
				   {
					   car[7].setY(p[7].y);
					   if(levelR(7))
						   g.drawImage(carstyle.getP3TR(), car[7].getX(),car[7].getY(), size.getlCarL(),size.getlCarH(), null);
					   else if(car[7].getX()==200&&light.getRedTF()<0)
						   g.drawImage(carstyle.getP3TR(), car[7].getX(),car[7].getY(), size.getlCarL(),size.getlCarH(), null);
					   else if(car[7].getX()==650&&light.getRedTR()<0)
						   g.drawImage(carstyle.getP3TR(), car[7].getX(), car[7].getY(), size.getlCarL(),size.getlCarH(), null);
					   else     
					       g.drawImage(carstyle.getP3TR(), car[7].moveToRight(), car[7].getY(), size.getlCarL(),size.getlCarH(), null);  			  			    
				   }
				   else
				   {
					   initp7();
				   }
			}
			
		}
		if(rand[7]==4)
		{
			if(flag70)
			{
				p[7] = (Point) list[7].get(0);
			  	 if(car[7].getY()<=p[7].y)
			  	 {
			  		 if(verticalB(7))
			  			g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].getY(), size.gethCarL(),size.gethCarH(), null); 
			  		 else	 
				     	g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].moveToBottom(), size.gethCarL(),size.gethCarH(), null);
					
				 }
				 else
				 {
					if(car[7].getX()>10) 
					{
						car[7].setY(255);
						if(levelL(7))
							g.drawImage(carstyle.getP3TL(),car[7].getX(),car[7].getY(), size.getlCarL(),size.getlCarH(), null);
						else	
						    g.drawImage(carstyle.getP3TL(),car[7].moveToLeft(),car[7].getY(), size.getlCarL(),size.getlCarH(), null);
					}
					else
					{
						car[7].setX(0);car[7].setY(260);
						if(!start0())
						{
							g.drawImage(carstyle.getP3TB(), car[7].getX(),car[7].getY(), size.gethCarL(),size.gethCarH(), null);
							flag70=false;
						}
					}				    			     			  			     			     
				 }
			}
			else
			{
			   if(car[7].getX()<=680)
			   {
				   p[7] = (Point) list[7].get(1);
				   car[7].setY(p[7].y);
				   if(levelR(7))
					   g.drawImage(carstyle.getP3TR(), car[7].getX(), car[7].getY(), size.getlCarL(),size.getlCarH(), null);
				   else if(car[7].getX()==200&&light.getRedTF()<0)
					   g.drawImage(carstyle.getP3TR(), car[7].getX(), car[7].getY(), size.getlCarL(),size.getlCarH(), null);
				   else
				       g.drawImage(carstyle.getP3TR(), car[7].moveToRight(), car[7].getY(),size.getlCarL(),size.getlCarH(), null);
			   }
			   else
			   {
				   p[7] = (Point) list[7].get(2);
				   car[7].setX(p[7].x);
				   if(car[7].getY()<550)
				   {
					   if(verticalB(7))
						   g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].getY(), size.gethCarL(),size.gethCarH(), null);
					   else	   
					       g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].moveToBottom() , size.gethCarL(),size.gethCarH(), null);
				   }
				   else
				   {
					   initp7();
				   }
			   }			  				  			    
			}
		}
		if(rand[7]==5)
		{
			
			p[7] = (Point) list[7].get(0);
			if(car[7].getY()<=p[7].y)
			{
				if(verticalB(7))
					g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].getY(), size.gethCarL(),size.gethCarH(), null);		   
			    else if(car[7].getY()==220&&light.getRedTF()>0)
					g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].getY(), size.gethCarL(),size.gethCarH(), null);		   
				else
			    	g.drawImage(carstyle.getP3TB(),car[7].getX(),car[7].moveToBottom(), size.gethCarL(),size.gethCarH(), null);		   
			}
			else
			{
				initp7();
			}
		}
		
	}
	public void carRunP8(Graphics g)
	{
		if(rand[8]==1)
		{
			p[8] = (Point) list[8].get(0);
			if(car[8].getY()<=p[8].y)
			{
				if(verticalB(8))
					g.drawImage(carstyle.getP4TB(),car[8].getX(),car[8].getY() ,size.hCarL,size.hCarH,null);
				else	
				   g.drawImage(carstyle.getP4TB(),car[8].getX(),car[8].moveToBottom() ,size.hCarL,size.hCarH,null);   
			}
			else
			{
				p[8] = (Point) list[8].get(1);
				car[8].setY(p[8].y);
				if(car[8].getX()>0)
				{
					if(levelL(8))
						g.drawImage(carstyle.getP4TL(),car[8].getX(),car[8].getY() ,size.lCarL,size.lCarH,null);	
				    else if(car[8].getX()==303&&light.getRedTF()<0)
						g.drawImage(carstyle.getP4TL(),car[8].getX(),car[8].getY() ,size.lCarL,size.lCarH,null);
					else	
					    g.drawImage(carstyle.getP4TL(),car[8].moveToLeft(),car[8].getY(),size.lCarL,size.lCarH,null);		
				}
				else
				{
					initp8();
				}
			}
		}
		if(rand[8]==2)
		{
			if(flag80)
			{
				p[8] = (Point) list[8].get(0);
				if(car[8].getY()<=p[8].y)
				{
					if(verticalB(8))
					    g.drawImage(carstyle.getP4TB(),car[8].getX(),car[8].getY() ,size.hCarL,size.hCarH,null);
					else	
					    g.drawImage(carstyle.getP4TB(),car[8].getX(),car[8].moveToBottom() ,size.hCarL,size.hCarH,null);			    
				}
				else
				{
					p[8] = (Point) list[8].get(1);
					car[8].setY(p[8].y);
					if(car[8].getX()>p[8].x)
					{
						if(levelL(8))
							g.drawImage(carstyle.getP4TL(),car[8].getX(),car[8].getY() ,size.lCarL,size.lCarH,null);	    
						else	
						    g.drawImage(carstyle.getP4TL(),car[8].moveToLeft(),car[8].getY() ,size.lCarL,size.lCarH,null);	    
					}
					else
					{
						g.drawImage(carstyle.getP4TL(),car[8].getX(),car[8].getY() ,size.lCarL,size.lCarH,null);				
						flag80=false;
						car[8].setX(p[8].x);
					}
				}
			}
		    else
		    {
		    	if(car[8].getY()>0)
		    	{	
	                if(verticalT(8))
	                   g.drawImage(carstyle.getP4TT(), car[8].getX(),car[8].getY(), size.hCarL, size.hCarH,null);
	                else	
		    		   g.drawImage(carstyle.getP4TT(), car[8].getX(),car[8].moveToTop(), size.hCarL, size.hCarH,null);
		    	}
	            else
		    	{
		    		initp8();
		    	}
		    }
		}
		if(rand[8]==3)
		{
			if(flag80)
			{
				p[8] = (Point) list[8].get(0);
				if(car[8].getY()<p[8].y)
				{
					if(verticalB(8))
						g.drawImage(carstyle.getP4TB(), car[8].getX(),car[8].getY(), size.hCarL, size.hCarH,null);
				    else if(car[8].getY()==220&&light.getRedTR()>0)
						g.drawImage(carstyle.getP4TB(), car[8].getX(),car[8].getY(), size.hCarL, size.hCarH,null);
					else	
					    g.drawImage(carstyle.getP4TB(), car[8].getX(),car[8].moveToBottom(), size.hCarL, size.hCarH,null);
				}
				else
				{
					if(!start4())
					{
						g.drawImage(carstyle.getP4TR(), car[8].getX(),car[8].getY(), size.lCarL, size.lCarH,null);
			          	flag80=false;
					}
				}
			}
			else
			{
				p[8] = (Point) list[8].get(1);				
				if(car[8].getY()>((Point) list[8].get(2)).y)
				{
					car[8].setX(p[8].x);
					if(verticalT(8))
						g.drawImage(carstyle.getP4TT(),car[8].getX(),car[8].getY(), size.hCarL, size.hCarH,null);	
					else	
					    g.drawImage(carstyle.getP4TT(),car[8].getX(),car[8].moveToTop(), size.hCarL, size.hCarH,null);
				}
				else
				{
					p[8] = (Point) list[8].get(2);
					car[8].setY(p[8].y);
					if(car[8].getX()<1000)
					{
						if(levelR(8))
							g.drawImage(carstyle.getP4TR(),car[8].getX(),car[8].getY(), size.lCarL, size.lCarH,null);
						else	
					    	g.drawImage(carstyle.getP4TR(),car[8].moveToRight(),car[8].getY(), size.lCarL, size.lCarH,null);
					}
					else
					{
						initp8();
					}
				}
			}
			
		}
		if(rand[8]==4)
		{
			p[8] = (Point) list[8].get(0);
			if(car[8].getY()<p[8].y)
			{
				if(verticalB(8))
					g.drawImage(carstyle.getP4TB(), car[8].getX(),car[8].getY(), size.hCarL, size.hCarH,null);
			    else if(car[8].getY()==220&&light.getRedTR()>0)
					g.drawImage(carstyle.getP4TB(), car[8].getX(),car[8].getY(), size.hCarL, size.hCarH,null);
				else	
				    g.drawImage(carstyle.getP4TB(), car[8].getX(),car[8].moveToBottom(), size.hCarL, size.hCarH,null);
			}
			else
			{
				initp8();
			}
		}
		if(rand[8]==5)
		{
			if(flag80)
			{
				p[8] = (Point) list[8].get(0);
				if(car[8].getY()<=p[8].y)
				{
					if(verticalB(8))
						g.drawImage(carstyle.getP4TB(),car[8].getX(),car[8].getY(),size.hCarL,size.hCarH,null);
					else	
					    g.drawImage(carstyle.getP4TB(),car[8].getX(),car[8].moveToBottom() ,size.hCarL,size.hCarH,null);
				}
				else
				{
					car[8].setY(255);
					if(car[8].getX()>278)
					{	
						if(levelL(8))
							g.drawImage(carstyle.getP4TL(),car[8].getX(),car[8].getY() ,size.lCarL,size.lCarH,null);					
						else	
						    g.drawImage(carstyle.getP4TL(),car[8].moveToLeft(),car[8].getY() ,size.lCarL,size.lCarH,null);					
					}
					else
					{
						g.drawImage(carstyle.getP4TL(),car[8].getX(),car[8].getY() ,size.lCarL,size.lCarH,null);					
						flag80=false;
					}
				}
			}
		    else
		    {
		    	p[8] = (Point) list[8].get(1);
		    	if(flag81)
		    	{
		    		if(car[8].getY()>p[8].y)
		    		{
						car[8].setX(275);
						if(verticalT(8))
							 g.drawImage(carstyle.getP4TT(), car[8].getX(),car[8].getY(), size.hCarL, size.hCarH,null);
						else	
			    		    g.drawImage(carstyle.getP4TT(), car[8].getX(),car[8].moveToTop(), size.hCarL, size.hCarH,null);
			     
			    	}
			    	else
			    	{
			    		car[8].setX(p[8].x);car[8].setY(p[8].y);
			    		if(!start1())
			    		{
				    		g.drawImage(carstyle.getP4TL(),car[8].getX(),car[8].getY(), size.lCarL, size.lCarH,null);		        
				          	flag81=false;
			    		}
			    	}
		    	}
		    	else  		
		    	{
		    		if(car[8].getY()<550)
		    		{
		    			car[8].setX(p[8].x);
		    			if(verticalB(8))
		    			   g.drawImage(carstyle.getP4TB(),car[8].getX(),car[8].getY(), size.hCarL, size.hCarH,null);
		    			else if(car[8].getY()==220&&light.getRedTR()>0)
		    			   g.drawImage(carstyle.getP4TB(),car[8].getX(),car[8].getY(), size.hCarL, size.hCarH,null);
					    else	
			    		   g.drawImage(carstyle.getP4TB(),car[8].getX(),car[8].moveToBottom(), size.hCarL, size.hCarH,null);
		    		}
		    		else
		    		{
		    			initp8();
		    		}
					   
		    	}
		    	
	               
		    }
		}
	}	
	public void carRunP9(Graphics g)
	{
		if(rand[9]==1)
		{
			p[9]=(Point) list[9].get(0);
			if(car[9].getX()>p[9].x)
			{
				if(levelL(9))
					g.drawImage(carstyle.getP2TL(), car[9].getX(), car[9].getY(), size.lCarL, size.lCarH, null);	
		    	else if(car[9].getX()==750&&light.getRedTR()<0)
					g.drawImage(carstyle.getP2TL(), car[9].getX(), car[9].getY(), size.lCarL, size.lCarH, null);
				else if(car[9].getX()==300&&light.getRedTR()<0)
					g.drawImage(carstyle.getP2TL(), car[9].getX(), car[9].getY(), size.lCarL, size.lCarH, null);
				else		
				   g.drawImage(carstyle.getP2TL(), car[9].moveToLeft(), car[9].getY(), size.lCarL, size.lCarH, null);
			}
			else
			{
				initp9();
			}
		}
		if(rand[9]==2)
		{
			p[9]=(Point) list[9].get(0);
			if(car[9].getX()>p[9].x)
			{
				if(levelL(9))
					g.drawImage(carstyle.getP2TL(), car[9].getX(), car[9].getY(), size.lCarL, size.lCarH, null);
				else if(car[9].getX()==750&&light.getRedTR()<0)
					g.drawImage(carstyle.getP2TL(), car[9].getX(), car[9].getY(), size.lCarL, size.lCarH, null);
				else
				    g.drawImage(carstyle.getP2TL(), car[9].moveToLeft(), car[9].getY(), size.lCarL, size.lCarH, null);
			    
			}
			else
			{
				if(car[9].getY()>0)
				{
					car[9].setX(p[9].x);
					if(verticalT(9))
						 g.drawImage(carstyle.getP2TT(), car[9].getX(), car[9].getY(), size.hCarL, size.hCarH, null);
					else	
					     g.drawImage(carstyle.getP2TT(), car[9].getX(), car[9].moveToTop(), size.hCarL, size.hCarH, null);
				}
				else
				{
					initp9();
				}
			}
		}
		if(rand[9]==3)
		{
			p[9]=(Point) list[9].get(0);
			if(car[9].getX()>p[9].x)
			{
				if(levelL(9))
					 g.drawImage(carstyle.getP2TL(), car[9].getX(), car[9].getY(), size.lCarL, size.lCarH, null);
				else	
				     g.drawImage(carstyle.getP2TL(), car[9].moveToLeft(), car[9].getY(), size.lCarL, size.lCarH, null);
			}
			else
			{
				if(car[9].getY()>0)
				{
					car[9].setX(p[9].x);
					if(verticalT(9))
						 g.drawImage(carstyle.getP2TT(), car[9].getX(), car[9].getY(), size.hCarL, size.hCarH, null);
					else	
					     g.drawImage(carstyle.getP2TT(), car[9].getX(), car[9].moveToTop(), size.hCarL, size.hCarH, null);
				}
				else
				{
					initp9();
				}
			}
		}
		if(rand[9]==4)
		{
			if(flag90)
			{
				p[9]=(Point) list[9].get(0);
				if(car[9].getX()>p[9].x)
				{
					if(levelL(9))
						g.drawImage(carstyle.getP2TL(), car[9].getX(), car[9].getY(), size.lCarL, size.lCarH, null);
					else	
					    g.drawImage(carstyle.getP2TL(), car[9].moveToLeft(), car[9].getY(), size.lCarL, size.lCarH, null);
				}
				else
				{
				    if(car[9].getY()>0)
				    {
				    	car[9].setX(p[9].x);
				    	if(verticalT(9))
				    		 g.drawImage(carstyle.getP2TT(), car[9].getX(), car[9].getY(), size.hCarL, size.hCarH, null);
				    	else	
				    	    g.drawImage(carstyle.getP2TT(), car[9].getX(), car[9].moveToTop(), size.hCarL, size.hCarH, null);
				    }
				    else
				    {
				    	p[9]=(Point) list[9].get(1);
				    	car[9].setX(p[9].x);car[9].setY(p[9].y);
				    	if(!start2())
				    	{
					    	g.drawImage(carstyle.getP2TL(),car[9].getX(),car[9].getY(), size.lCarL, size.lCarH, null);
					    	flag90=false;
				    	}
				    }	    						
				}
			}
			else
			{
				p[9]=(Point) list[9].get(2);
				if(car[9].getY()<p[9].y)
				{
					car[9].setX(p[9].x);
					if(verticalB(9))
						g.drawImage(carstyle.getP2TB(), car[9].getX(), car[9].getY(), size.hCarL, size.hCarH, null);
					else if(car[9].getY()==220&&light.getRedTR()>0)
						g.drawImage(carstyle.getP2TB(), car[9].getX(), car[9].getY(), size.hCarL, size.hCarH, null);
					else	
				        g.drawImage(carstyle.getP2TB(), car[9].getX(), car[9].moveToBottom(), size.hCarL, size.hCarH, null);
				
				}
				else
				{
					initp9();
				}
			}
			
		}
		if(rand[9]==5)
		{
			if(flag90)
			{
				p[9]=(Point) list[9].get(0);
				if(car[9].getX()>p[9].x)
				{
					if(levelL(9))
						g.drawImage(carstyle.getP2TL(), car[9].getX(), car[9].getY(), size.lCarL, size.lCarH, null);
				    else if(car[9].getX()==750&&light.getRedTR()<0)
						g.drawImage(carstyle.getP2TL(), car[9].getX(), car[9].getY(), size.lCarL, size.lCarH, null);
					else	
					    g.drawImage(carstyle.getP2TL(), car[9].moveToLeft(), car[9].getY(), size.lCarL, size.lCarH, null);				   
				}
				else
				{
				    if(car[9].getY()>0)
				    {
				    	car[9].setX(p[9].x);
				    	if(verticalT(9))
				    		g.drawImage(carstyle.getP2TT(), car[9].getX(), car[9].getY(), size.hCarL, size.hCarH, null);
				    	else	
				    	   g.drawImage(carstyle.getP2TT(), car[9].getX(), car[9].moveToTop(), size.hCarL, size.hCarH, null);
				    }
				    else
				    {
				    	p[9]=(Point) list[9].get(1);
				    	car[9].setX(p[9].x);car[9].setY(p[9].y);
				    	if(!start1())
				    	{
					    	g.drawImage(carstyle.getP2TL(),car[9].getX(),car[9].getY(), size.lCarL, size.lCarH, null);
					    	flag90=false;
				    	}
				    }	    											
				}
			}
			else
			{
				p[9]=(Point) list[9].get(2);
				if(car[9].getY()<p[9].y)
				{ 
					car[9].setX(p[9].x);
					if(verticalB(9))
						 g.drawImage(carstyle.getP2TB(),car[9].getX(), car[9].getY(), size.hCarL, size.hCarH, null);
					else if(car[9].getY()==220&&light.getRedTF()>0)
					     g.drawImage(carstyle.getP2TB(),car[9].getX(), car[9].getY(), size.hCarL, size.hCarH, null);
				    else	
					      g.drawImage(carstyle.getP2TB(),car[9].getX(), car[9].moveToBottom(), size.hCarL, size.hCarH, null);
				}
				else
				{
					initp9();
				}
			  
			}
		}
	}
	public void carRunP10(Graphics g)
	{
		if(rand[10]==1)
		{
			 if(flag100)
			 {
				 p[10] = (Point) list[10].get(0);
	            	if(car[10].getY()>p[10].y)
	    			{
	            		if(verticalT(10))
	            			 g.drawImage(carstyle.getP1TT(), car[10].getX(),car[10].getY(), size.hCarL,size.hCarH, null);
	            		else	
	    				    g.drawImage(carstyle.getP1TT(), car[10].getX(),car[10].moveToTop(), size.hCarL,size.hCarH, null);    			 
	    			}
	    			else
	    			{			
	    			    if(car[10].getX()<970)
	    				{
	    			    	car[10].setY(p[10].y);
	    			    	if(levelR(10))
	    			    		g.drawImage(carstyle.getP1TR(), car[10].getX(),car[10].getY(), size.lCarL,size.lCarH, null);
	    			    	else	
	    					    g.drawImage(carstyle.getP1TR(), car[10].moveToRight(),car[10].getY(), size.lCarL,size.lCarH, null);
	    			   	}
	    				else
	    				{
	    					p[10] = (Point) list[10].get(1);
	    					car[10].setX(p[10].x);car[10].setY(p[10].y);
	    					if(!start3())
	    					{
		    					g.drawImage(carstyle.getP1TT(),car[10].getX(),car[10].getY(), size.hCarL,size.hCarH, null);
		    					flag100=false;
	    					}
	    				}	    			 
	    			}
				}
			 else
			 {
				 p[10] = (Point) list[10].get(2);
				 if(car[10].getX()>=0)
				 {
					 car[10].setY(p[10].y);
					 if(levelL(10))
						 g.drawImage(carstyle.getP1TL(),car[10].getX(),car[10].getY(), size.lCarL,size.lCarH, null);	            	
					 else if(car[10].getX()==750&&light.getRedTR()<0)
						 g.drawImage(carstyle.getP1TL(),car[10].getX(),car[10].getY(), size.lCarL,size.lCarH, null);	            	
					 else if(car[4].getX()==300&&light.getRedTR()<0)
						 g.drawImage(carstyle.getP1TL(), car[10].getX(),car[10].getY(), size.lCarL,size.lCarH, null);	            	 
					 else  
					     g.drawImage(carstyle.getP1TL(), car[10].moveToLeft(),car[10].getY(), size.lCarL,size.lCarH, null);	            	
				 }
				 else
				{
					 initp10();
				}
			 }
		}
		if(rand[10]==2)
		{
			 if(flag100)
			 {
				 p[10] = (Point) list[10].get(0);
	            	if(car[10].getY()>p[10].y)
	    			{
	            		if(verticalT(10))
	            			g.drawImage(carstyle.getP1TT(), car[10].getX(),car[10].getY(), size.hCarL,size.hCarH, null);	
	            		else	
	    				   g.drawImage(carstyle.getP1TT(), car[10].getX(),car[10].moveToTop(), size.hCarL,size.hCarH, null);	    			 
	    			}
	    			else
	    			{			
	    			    if(car[10].getX()<970)
	    				{
	    			    	car[10].setY(p[10].y);
	    			    	if(levelR(10))
	    			    		g.drawImage(carstyle.getP1TR(), car[10].getX(),car[10].getY(), size.lCarL,size.lCarH, null);
	    			    	else	
	    					    g.drawImage(carstyle.getP1TR(), car[10].moveToRight(),car[10].getY(), size.lCarL,size.lCarH, null);
	    			   	}
	    				else
	    				{
	    					p[10] = (Point) list[10].get(1);
	    					car[10].setX(p[10].x);car[10].setY(p[10].y);
	    					if(!start3())
	    					{
		    					g.drawImage(carstyle.getP1TT(),car[10].getX(),car[10].getY(),size.hCarL,size.hCarH, null);
		    					flag100=false;
	    					}
	    				}
	    			 
	    			}
				}
	            else
	            {
	            	p[10] = (Point) list[10].get(2);
	            	if(car[10].getX()>((Point) list[10].get(3)).x)
	            	{
	            		car[10].setY(p[10].y);
	            		if(levelL(10))
	            			 g.drawImage(carstyle.getP1TL(), car[10].getX(),car[10].getY(), size.lCarL,size.lCarH, null);	            	
	            		else if(car[10].getX()==750&&light.getRedTR()<0)
							 g.drawImage(carstyle.getP1TL(), car[10].getX(),car[10].getY(), size.lCarL,size.lCarH, null);	            	
	            		else
	            		     g.drawImage(carstyle.getP1TL(), car[10].moveToLeft(),car[10].getY(), size.lCarL,size.lCarH, null);
	            	  
	            	}
	            	else
	            	{
	            		p[10] = (Point) list[10].get(3);
	            		if(car[10].getY()>0)
	            		{
	            			car[10].setX(p[10].x);
	            			if(verticalT(10))
	            				 g.drawImage(carstyle.getP1TT(), car[10].getX(),car[10].getY(), size.hCarL,size.hCarH, null);
	            			else	
	            			     g.drawImage(carstyle.getP1TT(), car[10].getX(),car[10].moveToTop(), size.hCarL,size.hCarH, null);
	            		}
	            		else
	            		{
	            			initp10();
	            		}
	            	}
	            }
		}
		if(rand[10]==3)
		{
            if(car[10].getY()>0)
            {
            	if(verticalT(10))
            		g.drawImage(carstyle.getP1TT(),car[10].getX(),car[10].getY(),size.hCarL,size.hCarH,null);
                else if(car[10].getY()==300&&light.getRedTR()>0)
            		g.drawImage(carstyle.getP1TT(),car[10].getX(),car[10].getY(),size.hCarL,size.hCarH,null);
            	else
            		g.drawImage(carstyle.getP1TT(),car[10].getX(),car[10].moveToTop(),size.hCarL,size.hCarH,null);
            }
            else
            {
            	initp10();
            }
			
		}
		if(rand[10]==4)
		{
			p[10] = (Point) list[10].get(0);
			if(car[10].getY()>p[10].y)
			{
				if(verticalT(10))
					g.drawImage(carstyle.getP1TT(),car[10].getX(),car[10].getY(), size.hCarL,size.hCarH, null);				 
				else	
			    	g.drawImage(carstyle.getP1TT(),car[10].getX(),car[10].moveToTop(), size.hCarL,size.hCarH, null);			 
			}
			else
			{
				if(car[10].getX()<1000)
				{
					car[10].setY(p[10].y);
					if(levelR(10))
						g.drawImage(carstyle.getP1TR(), car[10].getX(),car[10].getY(), size.lCarL,size.lCarH, null);
					else	
					    g.drawImage(carstyle.getP1TR(), car[10].moveToRight(),car[10].getY(), size.lCarL,size.lCarH, null);
				}
				else
				{
					initp10();
				}
			}
		}
		if(rand[10]==5)
		{
			if(flag100)
			{
				p[10] = (Point) list[10].get(0);
	            	if(car[10].getY()>p[10].y)
	    			{
	            		if(verticalT(10))
	            			 g.drawImage(carstyle.getP1TT(), car[10].getX(),car[10].getY(), size.hCarL,size.hCarH, null);
	            		else	
	    				    g.drawImage(carstyle.getP1TT(), car[10].getX(),car[10].moveToTop(), size.hCarL,size.hCarH, null);	    			
	    			}
	    			else
	    			{			
	    			    if(car[10].getX()<970)
	    				{
	    			    	car[10].setY(p[10].y);
	    			    	if(levelR(10))
	    			    		 g.drawImage(carstyle.getP1TR(), car[10].getY(),car[10].getY(), size.lCarL,size.lCarH, null);	
	    			    	else	
	    					     g.drawImage(carstyle.getP1TR(), car[10].moveToRight(),car[10].getY(), size.lCarL,size.lCarH, null);
	    			   	}
	    				else
	    				{
	    					p[10] = (Point) list[10].get(1);
	    					car[10].setX(p[10].x);car[10].setY(p[10].y);
	    					if(!start3())
	    					{
		    					g.drawImage(carstyle.getP1TT(), car[10].getX(),car[10].getY(), size.hCarL,size.hCarH, null);
		    					flag100=false;
	    					}
	    				}	    			  
	    			}
				}
	            else
	            {
	            	if(flag101)
	            	{
	            		p[10] = (Point) list[10].get(2);		
	            		if(car[10].getX()>((Point) list[10].get(3)).x)
		            	{
	            			car[10].setY(p[10].y);
	            			if(levelL(10))
	            				 g.drawImage(carstyle.getP1TL(), car[10].getX(),car[10].getY(), size.lCarL,size.lCarH, null);	            	
	            			else if(car[10].getX()==750&&light.getRedTR()<0)
								 g.drawImage(carstyle.getP1TL(), car[10].getX(),car[10].getY(), size.lCarL,size.lCarH, null);	            	
		            		else
		            		     g.drawImage(carstyle.getP1TL(), car[10].moveToLeft(),car[10].getY(), size.lCarL,size.lCarH, null);	            	
		            	}
		            	else
		            	{
		            		p[10] = (Point) list[10].get(3);
		            		car[10].setX(p[10].x);
		            		if(car[10].getY()>0)
		            	    {
		            			if(verticalT(10))
		            				g.drawImage(carstyle.getP1TT(), car[10].getX(),car[10].getY(), size.hCarL,size.hCarH, null);
		            			else	
		            			    g.drawImage(carstyle.getP1TT(), car[10].getX(),car[10].moveToTop(), size.hCarL,size.hCarH, null);
		            	    }
		            		else
		            		{
		            			p[10] = (Point) list[10].get(4);
		            			car[10].setX(p[10].x);car[10].setY(p[10].y);
		            			if(!start1())
		            			{
			            			g.drawImage(carstyle.getP1TL(), car[10].getX(),car[10].getY(), size.lCarL,size.lCarH, null);		        
			            		    flag101=false;	
		            			}
		            		}		            	
		            	}
	            	}
	            	else
	            	{
	            		if(car[10].getY()<550)
	            		{
	            			car[10].setX(p[10].x);
	            			if(verticalB(10))
	            				g.drawImage(carstyle.getP1TB(), car[10].getX(),car[10].getY(), size.hCarL,size.hCarH, null);
	            			else if(car[10].getY()==220&&light.getRedTF()>0)
	            				g.drawImage(carstyle.getP1TB(), car[10].getX(),car[10].getY(), size.hCarL,size.hCarH, null);
	            			else	
	            			    g.drawImage(carstyle.getP1TB(), car[10].getX(),car[10].moveToBottom(), size.hCarL,size.hCarH, null);
	            		}
	            		else
	            		{
	            			initp10();	            	 
	            		}
	            	}
	            	
	            }
		}
	}
	public void carRunP11(Graphics g)
	{
		if(rand[11]==1)
		{
			if(flag110)
			{
				if(car[11].getY()>0)
				{
					if(verticalT(11))
						 g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].getY(), size.hCarL, size.hCarH, null);			
				    else if(car[11].getY()==300&&light.getRedTF()>0)
						  g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].getY(), size.hCarL, size.hCarH, null);			
					else	
			    	      g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].moveToTop(), size.hCarL, size.hCarH, null);			
			    }
			    else
			    {
			    	p[11] = (Point) list[11].get(0);
			    	car[11].setX(p[11].x);car[11].setY(p[11].y);
			    	if(!start1())
			    	{
				    	g.drawImage(carstyle.getP0TL(), car[11].getX(),car[11].getY(), size.lCarL, size.lCarH, null);		   
				    	flag110=false;
			    	}
			    }
			}
			else
			{
				p[11] = (Point) list[11].get(1);
				if(car[11].getY()<p[11].y)
				{
					car[11].setX(p[11].x);
					if(verticalB(11))
						 g.drawImage(carstyle.getP0TB(), car[11].getX(),car[11].getY(), size.hCarL, size.hCarH, null);		    	
					else	
					     g.drawImage(carstyle.getP0TB(), car[11].getX(),car[11].moveToBottom(), size.hCarL, size.hCarH, null);		    	
					car[11].setX(((Point) list[11].get(2)).x);
				}
				else
				{
					p[11] = (Point) list[11].get(2);
					if(car[11].getX()>0)
					{
						car[11].setY(p[11].y);
						if(levelL(11))
							g.drawImage(carstyle.getP0TL(), car[11].getX(),car[11].getY(), size.lCarL, size.lCarH, null);
						else	
						    g.drawImage(carstyle.getP0TL(), car[11].moveToLeft(),car[11].getY(), size.lCarL, size.lCarH, null);
					}
					else
					{
						initp11();						
					}
				}
			}
		   
		}
		if(rand[11]==2)
		{
			if(car[11].getY()>0)
		    {
				if(verticalT(11))
					g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].getY(), size.hCarL, size.hCarH, null);			
			    else if(car[11].getY()==300&&light.getRedTF()>0)
				   g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].getY(), size.hCarL, size.hCarH, null);			
				else	
		    	   g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].moveToTop(), size.hCarL, size.hCarH, null);	    	
		    }
			else
			{
				initp11();
			}
		}
		if(rand[11]==3)
		{
			if(flag110)
			{
				p[11] = (Point) list[11].get(0);
				if(car[11].getY()>280)
				{
					if(verticalT(11))
						 g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].getY(), size.hCarL, size.hCarH, null);			    	
					else	
					    g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].moveToTop(), size.hCarL, size.hCarH, null);			    	
				}
				else
				{
					if(car[11].getX()<960)
					{
						car[11].setY(p[11].y);
						if(levelR(11))
							 g.drawImage(carstyle.getP0TR(), car[11].getX(),car[11].getY(), size.lCarL, size.lCarH, null);
						else if(car[11].getX()==655&&light.getRedTR()<0)
							 g.drawImage(carstyle.getP0TR(), car[11].getX(),car[11].getY(), size.lCarL, size.lCarH, null);
						else	
					       g.drawImage(carstyle.getP0TR(), car[11].moveToRight(),car[11].getY(), size.lCarL, size.lCarH, null);
			    	  
					}
					else
					{
						p[11] = (Point) list[11].get(1);
						car[11].setX(p[11].x);car[11].setY(p[11].y);
						if(!start3())
						{
							g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].getY(), size.hCarL, size.hCarH, null);							        		
			        		flag110=false;
						}
					}
				}
			}
			else
			{
				p[11] = (Point) list[11].get(3);
				if(car[11].getX()>p[11].x)
				{
					car[11].setY(p[11].y);
					p[11] = (Point) list[11].get(2);
					if(levelL(11))
						 g.drawImage(carstyle.getP0TL(), car[11].getX(),car[11].getY(), size.lCarL, size.lCarH, null);			    				 
					else	
					     g.drawImage(carstyle.getP0TL(), car[11].moveToLeft(),car[11].getY(), size.lCarL, size.lCarH, null);			    				    	
				}
				else
				{
					car[11].setX(p[11].x);
					if(car[11].getY()>0)
					{
						if(verticalT(11))
							g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].getY(), size.hCarL, size.hCarH, null);
						else	
						    g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].moveToTop(), size.hCarL, size.hCarH, null);					
					}
					else
					{
						initp11();
					}
				}
			}			
		}
		if(rand[11]==4)
		{
			p[11] = (Point) list[11].get(0);
			if(car[11].getY()>p[11].y)
			{
				if(verticalT(11))
					g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].getY(), size.hCarL, size.hCarH, null);
				else	
				    g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].moveToTop(), size.hCarL, size.hCarH, null);
		    	
			}
			else
			{
				if(car[11].getX()<1000)
				{
					car[11].setY(p[11].y);
					if(levelR(11))
						g.drawImage(carstyle.getP0TR(), car[11].getX(),car[11].getY(), size.lCarL, size.lCarH, null);
					else if(car[11].getX()==655&&light.getRedTR()<0)
						g.drawImage(carstyle.getP0TR(), car[11].getX(),car[11].getY(), size.lCarL, size.lCarH, null);
					else	
					    g.drawImage(carstyle.getP0TR(), car[11].moveToRight(),car[11].getY(), size.lCarL, size.lCarH, null);			    	
				}
				else
				{
					initp11();
				}
			}
		}
		if(rand[11]==5)
		{
			if(flag110)
			{
				p[11] = (Point) list[11].get(0);
				if(car[11].getY()>p[11].y)
				{
					if(verticalT(11))
						g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].getY(), size.hCarL, size.hCarH, null);
					else	
				     	g.drawImage(carstyle.getP0TT(), car[11].getX(),car[11].moveToTop(), size.hCarL, size.hCarH, null);			    
				}
				else
				{
					p[11] = (Point) list[11].get(1);
					car[11].setY(p[11].y);
					if(car[11].getX()<678)
					{
						if(levelR(11))
							g.drawImage(carstyle.getP0TR(), car[11].getX(),car[11].getY(), size.lCarL, size.lCarH, null);					
						else	
						    g.drawImage(carstyle.getP0TR(), car[11].moveToRight(),car[11].getY(), size.lCarL, size.lCarH, null);				
					}
					else
						flag110=false;				
				}
			}
			else
			{ 
				car[11].setX(p[11].x);
				if(car[11].getY()<550)
				{
				    if(verticalB(11))
				    	 g.drawImage(carstyle.getP0TB(), car[11].getX(),car[11].getY(), size.hCarL, size.hCarH, null);
				    else	
					     g.drawImage(carstyle.getP0TB(), car[11].getX(),car[11].moveToBottom(), size.hCarL, size.hCarH, null);
				}
				else
				{
					initp11();
				}
			}
			
		}
	}
	
    /**
     * 水平向右检测
     * @param n
     * @return
     */
	public boolean levelR(int n)
	{
	   
	   for(int i=0;i<12;i++)
	   {
	
			   if((car[i].x-car[n].x<51)&&(car[i].x-car[n].x>0)&&(car[i].y==car[n].y))
			   {
				   return true;
			   }
	   }
       return false;
	}
	/**
     * 水平向左检测
     * @param n
     * @return
     */
	public boolean levelL(int n)
	{
	   for(int i=0;i<12;i++)
	   {
			 
			   if((car[n].x-car[i].x<51)&&(car[n].x-car[i].x>0)&&(car[i].y==car[n].y))
			   {
				   return true;
			   }

	   }
       return false;
	}
	/**
     * 垂直向上检测
     * @param n
     * @return
     */
	public boolean verticalT(int n)
	{
	   for(int i=0;i<12;i++)
	   {
			   if((car[n].y-car[i].y<40)&&(car[n].y-car[i].y>0)&&(car[i].x==car[n].x))
			   {
				   return true;
			   }
	   }
       return false;
	}
	/**
     * 垂直向下检测
     * @param n
     * @return
     */
	public boolean verticalB(int n)
	{
	   for(int i=0;i<12;i++)
	   {
			   if(car[i].y-car[n].y<40&&car[i].y-car[n].y>0&&car[n].x==car[i].x)
			   {
				   return true;
			   }
	   }
       return false;
	}
	//浜ゅ弶妫�娴�
	public boolean cross(int n)
	{
		for(int i=0;i<12;i++)
		{
			if(i==n)
				i++;
			else
			{
				if(Math.abs(car[i].y-car[n].y)<50)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	//鍑虹敓鍦版娴� 0-5鍏�6涓矾鍙�
	public boolean start0()
	{
		if((car[0].getX()==service.p0.x&&car[0].getY()==service.p0.y)||(car[6].getX()==service.p0.x&&car[6].getY()==service.p0.y))
			return true;
		return false;
	}
	public boolean start1()
	{
		if((car[1].getX()==service.p1.x&&car[1].getY()==service.p1.y)||(car[7].getX()==service.p1.x&&car[7].getY()==service.p1.y))
			return true;
		return false;
	}
	public boolean start2()
	{
		if((car[2].getX()==service.p2.x&&car[2].getY()==service.p2.y)||(car[8].getX()==service.p2.x&&car[8].getY()==service.p2.y))
			return true;
		return false;
	}
	public boolean start3()
	{
		if((car[3].getX()==service.p3.x&&car[3].getY()==service.p3.y)||(car[9].getX()==service.p3.x&&car[9].getY()==service.p3.y))
			return true;
		return false;
	}
	public boolean start4()
	{
		if((car[5].getX()==service.p4.x&&car[4].getY()==service.p4.y)||(car[10].getX()==service.p4.x&&car[10].getY()==service.p4.y))
			return true;
		return false;
	}
	public boolean start5()
	{
		if((car[5].getX()==service.p5.x&&car[5].getY()==service.p5.y)||(car[11].getX()==service.p5.x&&car[11].getY()==service.p5.y))
			return true;
		return false;
	}
	//鏍囨敞鍑虹洰鐨勫湴
	public void destination(Graphics g)
	{
		if(rand[0]==1)
		{
			g.drawImage(carstyle.p0TT,300,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[0]==2)
		{
			g.drawImage(carstyle.p0TT,750,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[0]==4)
		{
			g.drawImage(carstyle.p0TB,680,520,size.hCarL,size.hCarH,null);
		}
		else if(rand[0]==5)
		{
			g.drawImage(carstyle.p0TB,230,520,size.hCarL,size.hCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p0TR,960,300,size.lCarL,size.lCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		if(rand[1]==1)
		{
			g.drawImage(carstyle.p1TL,0,230,size.lCarL,size.lCarH,null);
		}
		else if(rand[1]==2)
		{
			g.drawImage(carstyle.p1TT,770,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[1]==4)
		{
			g.drawImage(carstyle.p1TB,660,520,size.hCarL,size.hCarH,null);
		}
		else if(rand[1]==5)
		{
			g.drawImage(carstyle.p1TB,210,520,size.hCarL,size.hCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p1TR,960,320,size.lCarL,size.lCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		if(rand[2]==1)
		{
			g.drawImage(carstyle.p2TL,0,210,size.lCarL,size.lCarH,null);
		}
		else if(rand[2]==2)
		{
			g.drawImage(carstyle.p2TT,320,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[2]==4)
		{
			g.drawImage(carstyle.p2TB,640,520,size.hCarL,size.hCarH,null);
		}
		else if(rand[2]==5)
		{
			g.drawImage(carstyle.p2TB,190,520,size.hCarL,size.hCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p2TR,960,340,size.lCarL,size.lCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		if(rand[3]==1)
		{
			g.drawImage(carstyle.p3TL,0,190,size.lCarL,size.lCarH,null);
		}
		else if(rand[3]==2)
		{
			g.drawImage(carstyle.p3TT,340,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[3]==4)
		{
			g.drawImage(carstyle.p3TB,620,520,size.hCarL,size.hCarH,null);
		}
		else if(rand[3]==5)
		{
			g.drawImage(carstyle.p3TB,170,520,size.hCarL,size.hCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p3TT,790,0,size.hCarL,size.hCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		if(rand[4]==1)
		{
			g.drawImage(carstyle.p4TL,0,170,size.lCarL,size.lCarH,null);
		}
		else if(rand[4]==2)
		{
			g.drawImage(carstyle.p4TT,360,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[4]==4)
		{
			g.drawImage(carstyle.p4TR,960,360,size.lCarL,size.lCarH,null);
		}
		else if(rand[4]==5)
		{
			g.drawImage(carstyle.p4TB,150,520,size.hCarL,size.hCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p4TT,810,0,size.hCarL,size.hCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		if(rand[5]==1)
		{
			g.drawImage(carstyle.p5TL,0,150,size.lCarL,size.lCarH,null);
		}
		else if(rand[5]==2)
		{
			g.drawImage(carstyle.p5TT,380,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[5]==4)
		{
			g.drawImage(carstyle.p5TR,960,380,size.lCarL,size.lCarH,null);
		}
		else if(rand[5]==5)
		{
			g.drawImage(carstyle.p5TB,600,520,size.hCarL,size.hCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p5TT,830,0,size.hCarL,size.hCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		if(rand[6]==1)
		{
			g.drawImage(carstyle.p5TT,400,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[6]==2)
		{
			g.drawImage(carstyle.p5TT,850,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[6]==3)
		{
			g.drawImage(carstyle.p5TR,960,400,size.lCarL,size.lCarH,null);
		}
		else if(rand[6]==4)
		{
			g.drawImage(carstyle.p5TB,580,520,size.hCarL,size.hCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p5TB,130,520,size.hCarL,size.hCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		if(rand[7]==1)
		{
			g.drawImage(carstyle.p3TL,0,130,size.lCarL,size.lCarH,null);
		}
		else if(rand[7]==2)
		{
			g.drawImage(carstyle.p3TT,870,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[7]==3)
		{
			g.drawImage(carstyle.p3TR,960,420,size.lCarL,size.lCarH,null);
		}
		else if(rand[7]==4)
		{
			g.drawImage(carstyle.p3TB,560,520,size.hCarL,size.hCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p3TB,110,520,size.hCarL,size.hCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		if(rand[8]==1)
		{
			g.drawImage(carstyle.p4TL,0,110,size.lCarL,size.lCarH,null);
		}
		else if(rand[8]==2)
		{
			g.drawImage(carstyle.p4TT,420,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[8]==3)
		{
			g.drawImage(carstyle.p4TR,960,440,size.lCarL,size.lCarH,null);
		}
		else if(rand[8]==4)
		{
			g.drawImage(carstyle.p4TB,540,520,size.hCarL,size.hCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p4TB,90,520,size.hCarL,size.hCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		if(rand[9]==1)
		{
			g.drawImage(carstyle.p2TL,0,90,size.lCarL,size.lCarH,null);
		}
		else if(rand[9]==2)
		{
			g.drawImage(carstyle.p2TT,440,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[9]==3)
		{
			g.drawImage(carstyle.p2TT,890,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[9]==4)
		{
			g.drawImage(carstyle.p2TB,520,520,size.hCarL,size.hCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p2TB,70,520,size.hCarL,size.hCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		if(rand[10]==1)
		{
			g.drawImage(carstyle.p1TL,0,70,size.lCarL,size.lCarH,null);
		}
		else if(rand[10]==2)
		{
			g.drawImage(carstyle.p1TT,460,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[10]==3)
		{
			g.drawImage(carstyle.p1TT,910,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[10]==4)
		{
			g.drawImage(carstyle.p1TR,960,460,size.lCarL,size.lCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p1TB,70,520,size.hCarL,size.hCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		if(rand[11]==1)
		{
			g.drawImage(carstyle.p0TL,0,50,size.lCarL,size.lCarH,null);
		}
		else if(rand[11]==2)
		{
			g.drawImage(carstyle.p0TT,480,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[11]==3)
		{
			g.drawImage(carstyle.p0TT,930,0,size.hCarL,size.hCarH,null);
		}
		else if(rand[11]==4)
		{
			g.drawImage(carstyle.p0TR,960,480,size.lCarL,size.lCarH,null);
		}
		else
		{
			g.drawImage(carstyle.p0TB,500,520,size.hCarL,size.hCarH,null);
		}
		/*-------------------------鍗庝附鐨勫垎鍓茬嚎---------------------------------*/
		
		
		
	}
	public void bg1(Graphics g)
	{
		g.drawImage(carstyle.getMap(),0,0,null);
		g.setColor(Color.darkGray);
		g.drawArc(200,210, 30, 30, 0, 360);
		g.drawArc(200,310, 30, 30, 0, 360);
		g.drawArc(310,210, 30, 30, 0, 360);
		g.drawArc(310,310, 30, 30, 0, 360);
		
		
		g.drawArc(650,210, 30, 30, 0, 360);
		g.drawArc(650,310, 30, 30, 0, 360);
		
		g.drawArc(760,210, 30, 30, 0, 360);
		g.drawArc(760,310, 30, 30, 0, 360);
	    initLightL(g);	
	    initLightR(g);	
	}
    /**
     * 绘制地图
     * @param g
     */
	
	public void bg(Graphics g)
	{
		
		g.setColor(Color.BLACK);	
		g.drawLine(0, 250, 200, 250);
		g.drawLine(250, 0, 250, 200);
		g.drawArc(150, 150, 100, 100, 270, 90); 
		   			
		g.drawLine(0, 300, 200, 300);
	    g.drawLine(250,350, 250, 550);
		g.drawArc(150, 300, 100, 100, 0, 90);
		   		   		
	    g.drawLine(300, 0, 300, 200);
	    g.drawLine(350,250,650,250);
	    g.drawArc(300, 150, 100, 100, 180, 90);
	    		    
	    g.drawLine(300, 350, 300, 550);
	    g.drawLine(350, 300,650,300);
	    g.drawArc(300, 300, 100, 100, 90, 90);
								
		g.drawLine(700, 0, 700, 200);
		g.drawArc(600, 150, 100, 100,270, 90);
		
		g.drawLine(700,350,700,550);
		g.drawArc(600, 300, 100, 100,0, 90);
								
		g.drawLine(750, 0,750,200);
		g.drawLine(800, 250, 1000, 250);
		g.drawArc(750, 150, 100, 100,180, 90);
								
		g.drawLine(750, 350, 750, 550);
		g.drawLine(800,300,1000,300);
		g.drawArc(750, 300, 100, 100,90, 90);
								
	    g.setColor(Color.black);
		g.drawLine(20,275,200,275);
		g.drawLine(350,275,650,275);
		g.drawLine(725,20,725,200);
		g.drawLine(275,20,275,200);
		g.drawLine(725,350,725,530);
		g.drawLine(275,350,275,530);
		g.drawLine(800,275,980,275);

		g.fillArc(150, 150, 100, 100, 270, 90);
		g.fillRect(0, 0, 250, 200);
		g.fillRect(0, 200, 200, 50);
		
		g.fillArc(150, 300, 100, 100, 0, 90);
		g.fillRect(0, 300, 200, 250);
		g.fillRect(200,350, 50,200);
		
		g.fillArc(300, 150, 100, 100, 180, 90);
		g.fillArc(300, 300, 100, 100, 90, 90);
		g.fillArc(600, 150, 100, 100,270, 90);
		g.fillArc(600, 300, 100, 100,0, 90);
		
		g.fillRect(350, 200, 300, 50);
		g.fillRect(300, 0, 400,200);
		
		g.fillRect(350, 300, 300, 50);
		g.fillRect(300, 350, 400,200);
		
		g.fillArc(750, 150, 100, 100,180, 90);
		g.fillRect(750, 0, 250, 200);
		g.fillRect(800, 200, 200, 50);
        
		g.fillArc(750, 300, 100, 100,90, 90);
		g.fillRect(800, 300, 200, 50);
		g.fillRect(750, 350, 250, 200);

	}

	
}