package serviceInterface;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import data.CarLocation;

/**
 * 小车出生点
 * @author Kirito
 *
 */
public class CarLocationService extends ServiceAdapter implements Service 
{
    public static int startPoint;
    public CarLocation car;
    public Point p0 = new Point(0,278);
    public Point p1 = new Point(253,0);
    public Point p2 = new Point(703,0);
    public Point p3 = new Point(950,255);
    public Point p4 = new Point(725,520);
    public Point p5 = new Point(275,520);
	public List initPoint()
	{	
		List list = new ArrayList();
		list.add(p0);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
	    return list;	
	}
	 
	public void initCarLocation() {
		// TODO Auto-generated method stub
		super.initCarLocation();
		List list = initPoint();
		//startPoint= new Random().nextInt(6);//0-5
	//	Point p = (Point) list.get(startPoint);
		car = new CarLocation(p0);
		//CarLocation.setCarNum(new Random().nextInt(6)+6);//6-11
		
	}
   
}
