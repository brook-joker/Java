package echo;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;
/**
 * 地图加载及人物移动
 * @author Kirito
 *
 */


class Back extends JFrame implements KeyListener{
//	Image db = null;
	String s[] = new String[10];
	String e[] = new String[40];
	Moster mos = new Moster();
	Move[] move = new Move[10];
	ImageIcon a[] = new ImageIcon[40];
	ImageIcon dark = new ImageIcon("./src/echo/dark.png");
	ImageIcon right = new ImageIcon("./src/echo/lead.png");
	ImageIcon left = new ImageIcon("./src/echo/lead0.png");
	ImageIcon lead2 = new ImageIcon("./src/echo/lead2.png");
	ImageIcon lead3 = new ImageIcon("./src/echo/lead3.png");
	ImageIcon listen1 = new ImageIcon("./src/echo/listen1.png");
	ImageIcon listen2 = new ImageIcon("./src/echo/listen2.png");
	ImageIcon floor = new ImageIcon("./src/echo/floor.png");
	ImageIcon game =new ImageIcon("./src/echo/gameover.jpg");
	ImageIcon boom=new ImageIcon("Image/boom.png");
	ImageIcon key = new ImageIcon("./src/echo/key.png");
	ImageIcon door1 = new ImageIcon("./src/echo/door1.png");
	ImageIcon door2 = new ImageIcon("./src/echo/door2.png");
	ImageIcon endu = new ImageIcon("./src/echo/endur/200.png");
	ImageIcon skill1 = new ImageIcon("./src/echo/a.jpg");
	ImageIcon skill2 = new ImageIcon("./src/echo/b.jpg");
	JLabel role,back,wave,Key,getkey,Door,endurL,gameover,Skill1,Skill2;
	JLabel[] moster = new JLabel[5];
	int getSight = 0,dirFlag = 0,keyFlag = 0,endurFlag = 0,skill1f = 0,skill2f = 0;
	int x = 0,y = 20,endur = 200;
	int moster_x,moster_y;
	int increment = 10,descend = 5,close;
	int[] flag={0,0,0,0,0};
	boolean f1=true,f2=true,listener=false;
	int endurI = 40;
	ArrayList l;
	Point p;
	Back() {
		super("echo");
		setSize(1200, 800);
		setResizable(true);
//		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		Skill1 =new JLabel(skill1);
//		Skill1.setBounds(50, 700, 40, 40);
//		this.add(Skill1);
		
		gameover =new JLabel();
		gameover.setBounds(0, 0, 1200, 800);
		this.add(gameover);
		
		gameover =new JLabel();
		gameover.setBounds(600, 400, 120, 50);
		this.add(gameover);
		
		role=new JLabel(right);
		role.setBounds(x,y,55,75);
		this.add(role);
		
//		endurL=new JLabel(endu);
//		endurL.setBounds(x+35,y+100,35,10);
//		this.add(endurL);
		
		getkey = new JLabel(key);
		getkey.setBounds(1100,20,40,83);
		this.add(getkey);
		getkey.setVisible(false);
		
		wave=new JLabel(dark);
		wave.setBounds(x - 1200,y - 800,2400,1600);
		this.add(wave);
		
		l=init();
		for(int i=0;i<5;i++)
		{
			p=(Point) l.get(i);
			move[i] = new Move(p.x,p.y);
			if(i%2==0)
			{
				move[i].direction=1;
				moster[i]= new JLabel(mos.moster_left[i]);				
			}
			else
			{
				move[i].direction=3;
				moster[i]= new JLabel(mos.moster_right[i]);
			}
			moster[i].setBounds(move[i].x, move[i].y, 40, 60);
			this.add(moster[i]);
		}
		
		
		Door=new JLabel(door1);
		Door.setBounds(1120,318,40,83);
		this.add(Door);
		
		Key=new JLabel(key);
		Key.setBounds(20,350,24,24);
		this.add(Key);
		
		back=new JLabel(floor);
		back.setBounds(0,0,1200,800);
		this.add(back);
		
		for(int i = 0;i <= s.length-1;i++)
			s[i] = "./src/echo/soundwave/"+String.valueOf(i)+".png";
		for(int i = 0;i <= e.length-1;i++){
			e[i] = "./src/echo/endur/"+String.valueOf(i*5)+".png";
			a[i] = new ImageIcon(e[i]);
		}
		setLayout(null);
	}
	
	public void soundWave() throws InterruptedException{
		int i = 0;
		if(dirFlag == 0)
			role.setIcon(listen1);
		else
			role.setIcon(listen2);
		while(i < s.length){
			ImageIcon temp = new ImageIcon(s[i]);
			wave.setIcon(temp);
			i++;
			Thread.sleep(100);
		}
		if(dirFlag == 0)
			role.setIcon(right);
		else
			role.setIcon(left);
		wave.setIcon(dark);
		getSight = 0;
	}	
	
	public boolean Move(int x,int y){
		boolean f = true;
		if(x < 0 || x > 1100)
			f = false;	
		if(y < 20 || y > 660)
			f = false;
		if(y >= 42 && y <= 160 &&  x <= 250)
			f = false;
		if(y >= 42 && y <= 160 &&  x >= 370)
			f = false;
		if(y >= 210 && y <= 328 &&  x >= 80 && x <= 1060)
			f = false;
		if(y >= 210 && y <= 328 &&  x > 1080){
			if(keyFlag == 1)
				f = true;
			else
				f = false;
		}
		if(y >= 320 && y <= 438 &&  x < 130)
			f = false;
		if(y >= 360 && y <= 568 &&  x >= 380)
			f = false;
		if(y >= 618 &&  x >= 360 && x <= 470)
			f = false;
		if(endur == 0)
			f = false;
		return f;	
	}
	
	 public void endurance(){
			if(endur >= 5){
				endur -= descend;
				endurI--;
				endurL.setIcon(a[endurI]);
				endurFlag = 1;
			}
		}
	  /**
	   * 接收键盘输入
	   */
	  public void keyPressed(KeyEvent e) {
	        // TODO Auto-generated method stub
	        switch(e.getKeyCode()){   
	            case KeyEvent.VK_LEFT: 
	            	if(getSight == 0){
	            		if(Move(x - increment, y)){
//	            			endurance();
	            			x -= increment;
	            		}
	            		dirFlag = 1;
	            		role.setIcon(lead3);
	            	}
	                break ;  
	            case KeyEvent.VK_RIGHT:  
	            	if(getSight == 0){
	            		if(Move(x + increment, y)){
//		            		endurance();
	            			x += increment;
	            		}
	            		dirFlag = 0;
	            		role.setIcon(lead2);
	            	}
	                break ;  
	            case KeyEvent.VK_UP:  
	            	if(getSight == 0){
	            		if(Move(x, y - increment)){
//	            			endurance();
	            			y -= increment;
	            		}
	            		if(dirFlag == 0)
	            			role.setIcon(lead2);
	            		else
	            			role.setIcon(lead3);
	            	}
	                break;  
	            case KeyEvent.VK_DOWN:  
	            	if(getSight == 0){
	            		if(Move(x, y + increment)){
//	            			endurance();
	            			y += increment;
	            		}
	            		if(dirFlag == 0)
	            			role.setIcon(lead2);
	            		else
	            			role.setIcon(lead3);
	            	}
	                break;  
	            case KeyEvent.VK_SPACE: 
	            	getSight = 1;
//	            	if(skill1f == 1)
//	            		getSight = 0;
	            	break;
	        }
    		wave.setBounds(x - 1200,y - 800,2400,1600);
	        role.setLocation(x , y);
	        endurL.setLocation(x+35,y+100);
	    }
	  
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		 switch(e.getKeyCode()){   
         case KeyEvent.VK_LEFT: 
        	if(getSight == 0)
             	role.setIcon(left);
        	endurFlag = 0;
             break ;  
         case KeyEvent.VK_RIGHT:  
         	if(getSight == 0)
         		role.setIcon(right);
         	endurFlag = 0;
             break ;  
         case KeyEvent.VK_UP:  
         	if(getSight == 0){
         		if(dirFlag == 0)
        			role.setIcon(right);
        		else
        			role.setIcon(left);
         	}
         	endurFlag = 0;
         	break;
         case KeyEvent.VK_DOWN:  
          	if(getSight == 0){
          		if(dirFlag == 0)
         			role.setIcon(right);
         		else
         			role.setIcon(left);
          	}
          	endurFlag = 0;
          	break;
         case KeyEvent.VK_SPACE: 
//         	skill1f = 1;
         	break;
     }
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 判断是否死亡
	 * @return
	 */
	public boolean judge()
	{
		for(int i=0;i<5;i++)
		{
			if(Math.abs(move[i].y-y)<60&&Math.abs(move[i].x-x)<60)
			{
				close=i;
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * 设置怪物开始移动
	 */
	public void start()
	{
	  while(f1)
	  {
		   
		   if(move[0].direction==1)
		   {
			try {
				   Thread.sleep(30);
				   if(judge()&&close==0)
				   {
					   moster[0].setIcon(mos.moster_left[flag[0]+5]);
					   moster[0].setBounds(move[0].toLeft(), move[0].y, 40, 50);
					   
					   role.setIcon(boom);
					   role.setLocation(x , y);
					   
					   gameover.setIcon(game);
					   gameover.setBounds(0,0,1200,800);
					   break;
				   }
				   else
				   {
					   moster[0].setIcon(mos.moster_left[flag[0]]);
					   moster[0].setBounds(move[0].toLeft(), move[0].y, 40, 50);
				   }		   	
				   flag[0]++;
				   if(flag[0]==5)
					   flag[0]=0;
			       if(move[0].x==0)
			       {
			    	   flag[0]=0;
			    	   move[0].direction=3;  
			       }
			     } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();}
		   }
		   if(move[0].direction==3)
		   {
			 try {
				     Thread.sleep(30);
				     if(judge()&&close==0)
				     {
				    	 moster[0].setIcon(mos.moster_right[flag[0]+5]);
				    	 moster[0].setBounds(move[0].toRight(), move[0].y, 40, 50);	
				    	 role.setIcon(boom);
						 role.setLocation(x , y);
						   
						 gameover.setIcon(game);
						 gameover.setBounds(0,0,1200,800);
						 break;
				     }
				     else
		    	     {
				    	 moster[0].setIcon(mos.moster_right[flag[0]]);
				    	 moster[0].setBounds(move[0].toRight(), move[0].y, 40, 50);	
		    	     }
				    
				     flag[0]++;
				  if(flag[0]==5)
					  flag[0]=0;
				  if(move[0].x==1150)
					  move[0].direction=1;  
			     } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();}
		   }
		 //------------------------------------------------------
		   if(move[1].direction==1)
		    {
			  try {
				   Thread.sleep(30);
				   if(judge()&&close==1)
				   {
					   moster[1].setIcon(mos.moster_left[flag[1]+5]);
					   moster[1].setBounds(move[1].toLeft(), move[1].y, 40, 50);
					   
					   role.setIcon(boom);
					   role.setLocation(x , y);
					   
					   gameover.setIcon(game);
					   gameover.setBounds(0,0,1200,800);
					   break;
				   }
				   else
				   {
					   moster[1].setIcon(mos.moster_left[flag[1]]);
					   moster[1].setBounds(move[1].toLeft(), move[1].y, 40, 50);	
				   }
				   flag[1]++;
				   if(flag[1]==5)
					   flag[1]=0;
			       if(move[1].x==5)
			       {
			    	   flag[1]=0;
			    	   move[1].direction=3;  
			       }
			     } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();}
		   }
		   if(move[1].direction==3)
		   {
			   try {
				     Thread.sleep(30);
				     if(judge()&&close==1){
				    	 moster[1].setIcon(mos.moster_right[flag[1]+5]);
					     moster[1].setBounds(move[1].toRight(), move[1].y, 40, 50);	
					     
					     role.setIcon(boom);
						   role.setLocation(x , y);
						   
						   gameover.setIcon(game);
						   gameover.setBounds(0,0,1200,800);
						   break;
				     }
				     else{
				    	 moster[1].setIcon(mos.moster_right[flag[1]]);
					     moster[1].setBounds(move[1].toRight(), move[1].y, 40, 50);	
				     }
		    	     
				     flag[1]++;
				  if(flag[1]==5)
					  flag[1]=0;
				  if(move[1].x==1155)
					  move[1].direction=1;  
			     } catch (InterruptedException e) {
			    	 e.printStackTrace();}
			     }
		   //------------------------------------------------------
		   if(move[2].direction==1)
		    {
			  try {
				   Thread.sleep(30);
				   if(judge()&&close==2){
					   moster[2].setIcon(mos.moster_left[flag[2]+5]);
					   moster[2].setBounds(move[2].toLeft(), move[2].y, 40, 50);	
					   
					   role.setIcon(boom);
					   role.setLocation(x , y);
					   
					   gameover.setIcon(game);
					   gameover.setBounds(0,0,1200,800);
					   break;
				   }
				   else{
					   moster[2].setIcon(mos.moster_left[flag[2]]);
					   moster[2].setBounds(move[2].toLeft(), move[2].y, 40, 50);	
				   }
				   
				   flag[2]++;
				   if(flag[2]==5)
					   flag[2]=0;
			       if(move[2].x==230)
			       {
			    	   flag[2]=0;
			    	   move[2].direction=3;  
			       }
			     } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();}
		   }
		   if(move[2].direction==3)
		   {
			   try {
				     Thread.sleep(30);
				     if(judge()&&close==2){
				    	 moster[2].setIcon(mos.moster_right[flag[2]+5]);
					     moster[2].setBounds(move[2].toRight(), move[2].y, 40, 50);
					     
					     role.setIcon(boom);
						   role.setLocation(x , y);

						   gameover.setIcon(game);
						   gameover.setBounds(0,0,1200,800);
						   break;
						   
				     }
				     else{
				    	 moster[2].setIcon(mos.moster_right[flag[2]]);
					     moster[2].setBounds(move[2].toRight(), move[2].y, 40, 50);
				     }
		    	     	
				     flag[2]++;
				  if(flag[2]==5)
					  flag[2]=0;
				  if(move[2].x==1150)
				  {
					  flag[2]=0;
					  move[2].direction=1;  
				  }
			     } catch (InterruptedException e) {
			    	 e.printStackTrace();}
		}
		   if(move[3].direction==1)
		    {
			  try {
				   Thread.sleep(30);
				   if(judge()&&close==3){
					   moster[3].setIcon(mos.moster_left[flag[3]+5]);
					   moster[3].setBounds(move[3].toLeft(), move[3].y, 40, 50);
					   
					   role.setIcon(boom);
					   role.setLocation(x , y);
					   
					   gameover.setIcon(game);
					   gameover.setBounds(0,0,1200,800);
					   break;
				   }
				   else{
					   moster[3].setIcon(mos.moster_left[flag[3]]);
					   moster[3].setBounds(move[3].toLeft(), move[3].y, 40, 50);
				   }
				   	
				   flag[3]++;
				   if(flag[3]==5)
					   flag[3]=0;
			       if(move[3].x==0)
			       {
			    	   flag[3]=0;
			    	   move[3].direction=3;  
			       }
			     } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();}
		   }
		   if(move[3].direction==3)
		   {
			   try {
				     Thread.sleep(30);
				     if(judge()&&close==3){
				    	 moster[3].setIcon(mos.moster_right[flag[3]+5]);
					     moster[3].setBounds(move[3].toRight(), move[3].y, 40, 50);	
					     
					     role.setIcon(boom);
						   role.setLocation(x , y);
						   
						   gameover.setIcon(game);
						   gameover.setBounds(600,400,140,60);
						   break;
				     }
				     else{
				    	 moster[3].setIcon(mos.moster_right[flag[3]]);
					     moster[3].setBounds(move[3].toRight(), move[3].y, 40, 50);	
				     }	    	    
				     flag[3]++;
				  if(flag[3]==5)
					  flag[3]=0;
				  if(move[3].x==1150)
				  {
					  flag[3]=0;
					  move[3].direction=1;  
				  }
			     } catch (InterruptedException e) {
			    	 e.printStackTrace();}
		    }
		   if(move[4].direction==1)
		    {
			  try {
				   Thread.sleep(30);
				   if(judge()&&close==4){
					   moster[4].setIcon(mos.moster_left[flag[4]+5]);
					   moster[4].setBounds(move[4].toLeft(), move[4].y, 40, 50);
					   
					   role.setIcon(boom);
					   role.setLocation(x , y);
					   
					   gameover.setIcon(game);
					   gameover.setBounds(0,0,1200,800);
					   break;
				   }
				   else{
					   moster[4].setIcon(mos.moster_left[flag[4]]);
					   moster[4].setBounds(move[4].toLeft(), move[4].y, 40, 50);
				   }
				   	
				   flag[4]++;
				   if(flag[4]==5)
					   flag[4]=0;
			       if(move[4].x==540)
			       {
			    	   flag[4]=0;
			    	   move[4].direction=3;  
			       }
			     } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();}
		   }
		   if(move[4].direction==3)
		   {
			   try {
				     Thread.sleep(30);
				     if(judge()&&close==4){
				    	 moster[4].setIcon(mos.moster_right[flag[4]+5]);
					     moster[4].setBounds(move[4].toRight(), move[4].y, 40, 50);
					     
					     role.setIcon(boom);
						   role.setLocation(x , y);
						   
						   gameover.setIcon(game);
						   gameover.setBounds(0,0,1200,800);
						   break;
				     }
				     else{
				    	 moster[4].setIcon(mos.moster_right[flag[4]]);
					     moster[4].setBounds(move[4].toRight(), move[4].y, 40, 50);
				     }	    	     	
				     flag[4]++;
				  if(flag[4]==5)
					  flag[4]=0;
				  if(move[4].x==1150)
				  {
					  flag[4]=0;
					  move[4].direction=1;  
				  }
			     } catch (InterruptedException e) {
			    	 e.printStackTrace();}
		    }
	  }//end while
	}//end start	   
 	/**
 	 * 怪物出生点初始化    	
 	 * @return
 	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList init()
	{
		ArrayList list = new ArrayList();
		Point p1 = new Point(1100,80);
		Point p2 = new Point(75,240);
		Point p3 = new Point(1100,390);
		Point p4 = new Point(10,640);
		Point p5 = new Point(1100,550);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		return list;
	}
		Point point = new Point();

}