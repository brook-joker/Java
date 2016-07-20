package data;

/**
 * 红绿灯时间
 * @author Kirito
 *
 */
public class LightTime 
{
 
   private int redTF,redTR,greenTF,greenTR;
   
   
   public int getRedTF() {
		return redTF;
	}
	public void setRedTF(int redTF) {
		this.redTF = redTF;
	}
	public int getRedTR() {
		return redTR;
	}
	public void setRedTR(int redTR) {
		this.redTR = redTR;
	}
	public int getGreenTF() {
		return greenTF;
	}
	public void setGreenTF(int greenTF) {
		this.greenTF = greenTF;
	}
	public int getGreenTR() {
		return greenTR;
	}
	public void setGreenTR(int greenTR) {
		this.greenTR = greenTR;
	}
   public LightTime(int x,int y,int z,int h)
   {
		this.setRedTF(x);
		this.setGreenTF(y);
		this.setRedTR(z);
		this.setGreenTR(h);
		
   }
   public void red1go()
   {
	   new Thread(new Runnable() {
		
		public void run() {
			// TODO Auto-generated method stub
			  try {
				     Thread.sleep(5000);
				     redTF--;
			     } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}).start();
	  
   }
   
   public void green1go()
   {
	   new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				  try {
					     Thread.sleep(5000);
					     greenTF--;
				     } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		  
   }
   public void red2go()
   {
	   new Thread(new Runnable() {
		
		public void run() {
			// TODO Auto-generated method stub
			  try {
				     Thread.sleep(5000);
				     redTR--;
			     } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}).start();
	  
   }
   
   public void green2go()
   {
	   new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				  try {
					     Thread.sleep(5000);
					     greenTR--;
				     } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		  
   }
   
  
}
