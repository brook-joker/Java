package echo;
/**
 * 技能CD冷却
 * 最后去掉了
 * 无用类
 * @author Kirito
 *
 */
class cooldown implements Runnable{
	Back f = new Back();
	cooldown(Back f){
		this.f = f;
	}
	
	public void run() {
		while(true){
			if(f.skill1f == 1){
				System.out.println("ok");
//				try {
//					Thread.sleep(3000);
					f.skill1f = 0;
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	}

}
