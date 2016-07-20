 package launcher;

import map.Background;

/**
 * Created by Kirito on 2015/10/10.
 */
public class TrafficSystem
{
   public static void main(String[] args)
   {
	  new Thread(new Runnable() {
		
		public void run() {
			// TODO Auto-generated method stub
			 new Background();
		}
	}).start();
	  
   }
}
