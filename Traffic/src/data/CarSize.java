package data;

/**
 * 水平小车的长度和宽度  l
 * 垂直小车的水平和宽度  h
 * @author Kirito
 *
 */
public class CarSize 
{
    public int lCarL,lCarH,hCarL,hCarH;

    public CarSize()
    {
    	this.setlCarL(40);
    	this.setlCarH(20);
    	this.sethCarL(20);
    	this.sethCarH(30);
    }
	public int getlCarL() {
		return lCarL;
	}

	public void setlCarL(int lCarL) {
		this.lCarL = lCarL;
	}

	public int getlCarH() {
		return lCarH;
	}

	public void setlCarH(int lCarH) {
		this.lCarH = lCarH;
	}

	public int gethCarL() {
		return hCarL;
	}

	public void sethCarL(int hCarL) {
		this.hCarL = hCarL;
	}

	public int gethCarH() {
		return hCarH;
	}

	public void sethCarH(int hCarH) {
		this.hCarH = hCarH;
	}
    
}
