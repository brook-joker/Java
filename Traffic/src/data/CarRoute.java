package data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * 小车的行车路线
 * @author Kirito
 *
 */
public class CarRoute 
{
   public int rand0,rand1,rand2,rand3,rand4,rand5;
   
   public ArrayList p0()
   {
	  rand0=new Random().nextInt(5)+1; //随机出1-5的数字
	  if(rand0==1)
		  return p0Top1();
	  if(rand0==2)
		  return p0Top2();
	  if(rand0==3)
		  return p0Top3();
	  if(rand0==4)
		  return p0Top4();
	  if(rand0==5)
		  return p0Top5();
      return null;	   
   }
   public ArrayList p1()
   {
     rand1=new Random().nextInt(5)+1; //随机出1-5的数字
     if(rand1==1)		
    	return p1Top0();
     if(rand1==2)
	    return p1Top2();
     if(rand1==3)
	    return p1Top3();
     if(rand1==4)
	    return p1Top4();
     if(rand1==5)
    	return p1Top5();	   
	   return null;
   } 
   public ArrayList p2()
   {
	   rand2=new Random().nextInt(5)+1; //随机出1-5的数字
	   if(rand2==1)		
	    	return p2Top0();
	   if(rand2==2)
		    return p2Top1();
       if(rand2==3)
		    return p2Top3();
       if(rand2==4)
		    return p2Top4();
       if(rand2==5)
	    	return p2Top5();	    
       return null;
   }
   public ArrayList p3()
   {
	   rand3=new Random().nextInt(5)+1; //随机出1-5的数字
	   if(rand3==1)		
	    	return p3Top0();
	   if(rand3==2)
		    return p3Top1();
       if(rand3==3)
		    return p3Top2();
       if(rand3==4)
		    return p3Top4();
       if(rand3==5)
	    	return p3Top5();	    
       return null;
   }
   public ArrayList p4()
   {
	   rand4=new Random().nextInt(5)+1; //随机出1-5的数字
	   if(rand4==1)		
	    	return p4Top0();
	   if(rand4==2)
		    return p4Top1();
       if(rand4==3)
		    return p4Top2();
       if(rand4==4)
		    return p4Top3();
       if(rand4==5)
	    	return p4Top5();	    
       return null;
   }  
   public ArrayList p5()
   {
	  rand5=new Random().nextInt(5)+1; //随机出1-5的数字
	   if(rand5==1)		
	    	return p5Top0();
	   if(rand5==2)
		    return p5Top1();
       if(rand5==3)
		    return p5Top2();
       if(rand5==4)
		    return p5Top3();
       if(rand5==5)
	    	return p5Top4();	    
       return null;
   }  
   
   private ArrayList p0Top1()
   {
	  ArrayList list = new ArrayList();
	  Point p0 = new Point(220,278);
	  Point p1 = new Point(253,518);
	  Point p2 = new Point(253,533);
	  Point p3 = new Point(275,520);
	  Point p4 = new Point(275,0);
	  list.add(p0);
	  list.add(p1);
	  list.add(p2);
	  list.add(p3);
	  list.add(p4);
	  return list;   
   }
   private ArrayList p0Top2()
   {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(960,278);
	   Point p1 = new Point(980,258);
	   Point p2 = new Point(960,255);
	   Point p3 = new Point(730,255);
	   Point p4 = new Point(725,233);
	   Point p5 = new Point(725,0);
	   list.add(p0);
	   list.add(p1);
	   list.add(p2);
	   list.add(p3);
	   list.add(p4);
	   list.add(p5);	   
	   return list;   
   }
   private ArrayList p0Top3()
   {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(1000,278);
	   list.add(p0);
	   return list;   
   }
   private ArrayList p0Top4()
   {	   
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(680,278);
	   Point p1= new Point(703,550);
	   list.add(p0);
	   list.add(p1);
	   return list;   
   }
   private ArrayList p0Top5()
   {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(220,278);
	   Point p1= new Point(253,550);
	   list.add(p0);
	   list.add(p1);
	   return list;   
   }
  
   private ArrayList p1Top0() 
   {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(253,240);
	   Point p1 = new Point(0,255);
	   list.add(p0);
	   list.add(p1);
	   return list;
   }
   private ArrayList p1Top2()
   {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(253,240);
	   Point p1 = new Point(0,278);
	   Point p2 = new Point(703,278);
	   Point p3 = new Point(703,530);
	   Point p4 = new Point(725,520);
	   list.add(p0);
	   list.add(p1);
	   list.add(p2);
	   list.add(p3);
	   list.add(p4);
	   return list;
   }
   private ArrayList p1Top3() 
   {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(253,240);
	   Point p1 = new Point(0,278);
	   list.add(p0);
	   list.add(p1);
	   return list;
	   
   }
   private ArrayList p1Top4()
   {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(253,240);
	   Point p1 = new Point(0,278);
	   Point p2 = new Point(703,278);
	   list.add(p0);
	   list.add(p1);
	   list.add(p2);
	   return list;
   }
   private ArrayList p1Top5() 
   {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(253,550);
	   list.add(p0);
	   return list;
   }
   
   private ArrayList p2Top0() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(703,240);
	   Point p1 = new Point(0,255);
	   list.add(p0);
	   list.add(p1);
	   return list;
	}
   private ArrayList p2Top1() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(703,240);
	   Point p1 = new Point(275,255);
	   list.add(p0);
	   list.add(p1);
	   return list;
	}
   private ArrayList p2Top3() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(703,530);
	   Point p1 = new Point(725,520);
	   Point p2 = new Point(725,278);
	   list.add(p0);
	   list.add(p1);
	   list.add(p2);
	   return list;
	}
   private ArrayList p2Top4() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(703,550);
	   list.add(p0);
	   return list;
	}
   private ArrayList p2Top5() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(703,240);
	   Point p1 = new Point(253,0);
	   list.add(p0);
	   list.add(p1);
	   return list;
	}
   
   private ArrayList p3Top0() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(0,255);
	   list.add(p0);
	   return list;
	}
   private ArrayList p3Top1() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(275,255);
	   list.add(p0);
	   return list;
	}
   private ArrayList p3Top2() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(725,255);
	   list.add(p0);
	   return list;
	}
   private ArrayList p3Top4() {
	   ArrayList list4 = new ArrayList();
	   Point a = new Point(725,255);
	   Point b = new Point(703,0);
	   Point c= new Point(703,550);
	   list4.add(a);
	   list4.add(b);
	   list4.add(c);
	   return list4;
	}
   private ArrayList p3Top5() {
	   ArrayList list5 = new ArrayList();
	   Point p50 = new Point(275,255);
	   Point p51 = new Point(253,0);
	   Point p52 = new Point(253,550);
	   list5.add(p50);
	   list5.add(p51);
	   list5.add(p52);
	   return list5;
	}
	
   private ArrayList p4Top0() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(725,278);
	   Point p1 = new Point(980,260);
	   Point p2 = new Point(950,255);	   
	   list.add(p0);
	   list.add(p1);
	   list.add(p2);
	   return list;
	}
   private ArrayList p4Top1() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(725,278);
	   Point p1 = new Point(980,260);
	   Point p2 = new Point(950,255);	 
	   Point p3 = new Point(275,243);
	   list.add(p0);
	   list.add(p1);
	   list.add(p2);
	   list.add(p3);
	   return list;
	}
   private ArrayList p4Top2() {
	   return null;
	}
   private ArrayList p4Top3() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(725,278);
	   list.add(p0);
	   return list;
		
	}
   private ArrayList p4Top5() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(725,278);
	   Point p1 = new Point(980,260);
	   Point p2 = new Point(950,255);	 
	   Point p3 = new Point(275,243);
	   Point p4 = new Point(253,0);
	   list.add(p0);
	   list.add(p1);
	   list.add(p2);
	   list.add(p3);
	   list.add(p4);
	   return list;
	}
   
   
   private ArrayList p5Top0() {
	   ArrayList list = new ArrayList();
	   Point p1 = new Point(253,0);
	   Point p2 = new Point(253,240);
	   Point p3 = new Point(230,255);	
	   list.add(p1);
	   list.add(p2);
	   list.add(p3);
	   return list;
	}
   private ArrayList p5Top1() {
		// TODO Auto-generated method stub
		return null;
	}
   private ArrayList p5Top2() {
	   ArrayList list = new ArrayList();
	   Point p0 = new Point(275,278);
	   Point p1 = new Point(975,260);
	   Point p2 = new Point(960,255);
	   Point p3 = new Point(725,255);
	   list.add(p0);
	   list.add(p1);
	   list.add(p2);
	   list.add(p3);
	   return list;
	}
   private ArrayList p5Top3() {
	   ArrayList list = new ArrayList();
	   Point p1 = new Point(275,278);
	   list.add(p1);
	   return list;
	}
   private ArrayList p5Top4() {
	   ArrayList list = new ArrayList();
	   Point p1 = new Point(275,280);
	   Point p2 = new Point(703,278);	
	   list.add(p1);
	   list.add(p2);
	   return list;
	}
}
