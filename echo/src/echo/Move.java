package echo;
/**
 * »ÀŒÔ“∆∂Ø
 * @author Kirito
 *
 */
public class Move 
{
   public int x,y,speed=10;
   public int direction; //1-left,2-top,3-right,4-bottom
   public Move() {
	   
   }
   public Move(int x,int y){
	   this.x=x;
	   this.y=y;
   }
   public int toRight()
   {
	  this.direction=3;
	  this.x+=speed;
	  return this.x;
   }
   public int toLeft()
   {
	  this.direction=1;
	  this.x-=speed;
	  return this.x;
   }
   public int toTop()
   {
	  this.direction=2;
	  this.y-=speed;
	  return this.x;
   }
   public int toBottom()
   {
	  this.direction=4;
	  this.y+=speed;
	  return this.x;
   }
}
