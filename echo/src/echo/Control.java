package echo;
/**
 * Èë¿Ú
 * @author Kirito
 *
 */
public class Control {
	public static void main(String args[]) throws InterruptedException{
		final Back f = new Back();
		f.setVisible(true);
		f.addKeyListener(f);
		new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				f.start();
			}
		}).start();
		new Thread(new sound(f)).start();
		new Thread(new Key(f)).start();
		new Thread(new cooldown(f)).start();
		new Thread(new reendur(f)).start();
		new Thread(new setEndu(f)).start();
	}
}
