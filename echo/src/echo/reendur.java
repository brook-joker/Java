package echo;

class reendur implements Runnable{
	Back f = new Back();
	
	reendur(Back f){
		this.f = f;
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("ok");
			try {
				if(f.endurFlag == 0 && f.endur < 200){
					f.endur += f.descend;
					Thread.sleep(50);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
