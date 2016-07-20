package echo;
/**
 * Ô¿³×
 * @author Kirito
 *
 */
class Key implements Runnable{
	Back f = new Back();
	Key(Back f){
		this.f = f;
	}
	
	public void run() {
		while(true){
			System.out.println("");
			if(f.role.getX() <= 20 &&
					(f.role.getY() <= 310 && f.role.getY() >= 250)){
				f.Key.setVisible(false);
				f.getkey.setVisible(true);
				f.keyFlag = 1;
			}
			if(f.keyFlag == 1 && f.role.getX() >= 1080 && f.role.getY() >= 210)
				f.Door.setIcon(f.door2);
		}
	}

}
