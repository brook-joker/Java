package echo;
/**
 * ��������
 * ������û�м�
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
