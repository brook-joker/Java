package data;

import java.awt.Point;
/**
 * 小车的坐标
 * @author Kirito
 *
 */
public class CarLocation 
{
	
	public  int x,y;
    public  int speed=10;
	public CarLocation(){}
	
	public CarLocation(Point p)
	{
		this.x=(int) p.getX();
		this.y=(int) p.getY();
	}
	
	public int moveToRight()
	{
		this.x+=this.speed;
		return this.x;
	}
    public int moveToTop()
    {
    	this.y-=this.speed;
		return this.y;
    }
    public int moveToBottom()
    {
    	this.y+=this.speed;
		return y;
    }
    public int moveToLeft()
    {
    	this.x-=this.speed;
		return this.x;
    }
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
  
}
