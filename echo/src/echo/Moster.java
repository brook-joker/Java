package echo;

import javax.swing.ImageIcon;
/**
 * 怪物资源图片的导入
 * @author Kirito
 *
 */
public class Moster
{
	public ImageIcon[] moster_left=new ImageIcon[10];
	public ImageIcon[] moster_right=new ImageIcon[10];
	public Moster()
	{
		setMoster_left();
		setMoster_right();
	}
	public void setMoster_left() {
		this.moster_left[0]= new ImageIcon("Image/l_skeleton_stand.png");
		this.moster_left[1]= new ImageIcon("Image/l_skeleton_walk01.png");
		this.moster_left[2]= new ImageIcon("Image/l_skeleton_walk02.png");
		this.moster_left[3]= new ImageIcon("Image/l_skeleton_walk03.png");
		this.moster_left[4]= new ImageIcon("Image/l_skeleton_walk04.png");
		this.moster_left[5]= new ImageIcon("Image/l_skeleton_walk05.png");
		this.moster_left[6]= new ImageIcon("Image/l_skeleton_attack01.png");
		this.moster_left[7]= new ImageIcon("Image/l_skeleton_attack02.png");
		this.moster_left[8]= new ImageIcon("Image/l_skeleton_attack03.png");
		this.moster_left[9]= new ImageIcon("Image/l_skeleton_attack04.png");
	}
	public void setMoster_right() {
		this.moster_right[0] = new ImageIcon("Image/enemy_skeleton_stand.png");
		this.moster_right[1] = new ImageIcon("Image/enemy_skeleton_walk01.png");
		this.moster_right[2] = new ImageIcon("Image/enemy_skeleton_walk02.png");
		this.moster_right[3] = new ImageIcon("Image/enemy_skeleton_walk03.png");
		this.moster_right[4] = new ImageIcon("Image/enemy_skeleton_walk04.png");
		this.moster_right[5] = new ImageIcon("Image/enemy_skeleton_walk05.png");
		this.moster_right[6] = new ImageIcon("Image/enemy_skeleton_attack01.png");
		this.moster_right[7] = new ImageIcon("Image/enemy_skeleton_attack02.png");
		this.moster_right[8] = new ImageIcon("Image/enemy_skeleton_attack03.png");
		this.moster_right[9] = new ImageIcon("Image/enemy_skeleton_attack04.png");
		
	}
	
}
