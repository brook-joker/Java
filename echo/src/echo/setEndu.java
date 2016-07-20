package echo;

import javax.swing.ImageIcon;
/**
 * …Ë÷√Œª“∆Ω· ¯
 * @author Kirito
 *
 */
class setEndu implements Runnable{
	Back f = new Back();
	setEndu(Back f){
		this.f = f;
	}


	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("ok");
			f.endurL.setIcon(f.a[f.endurI]);
		}
	}
}
