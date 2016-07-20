package serviceInterface;

public class TimePause 
{
	public int i=1;
	
    public int getI() {
    	p();
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void p()
    {
    	new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
    }
}
