package echo;
/**
 * 设置声音
 * 好像是没有加
 * @author Kirito
 *
 */
class sound implements Runnable{
	Back f = new Back();
	sound(Back f){
		this.f = f;
	}
	

	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				if(f.getSight == 1)
						f.soundWave();
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
