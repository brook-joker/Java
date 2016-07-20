package MyServer;

import java.awt.Container;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * 服务器UI设计类
 * @author Kirito
 *
 */
@SuppressWarnings("serial")
public class MyServerGui extends JFrame{
	Container con;
	JButton mSend;
	JTextField mEdit;
	List mList = new List(20);
	private Font defaultFont = new Font("微软雅黑", Font.PLAIN, 14);
	public MyServerGui(){
		super();
		this.setBounds(200, 200, 600, 600);
		con = this.getContentPane();
		con.setLayout(null);
		//title
		this.setTitle("FTP服务器v1.0");
		this.setFont(defaultFont);
		
		JLabel ipLab=new JLabel();
		ipLab.setFont(defaultFont);
		ipLab.setBounds(200,5,350,30);
		con.add(ipLab);
		ipLab.setText("服务器的IP地址为"+GetMyIPAddr.getLocalHostAddress().getHostAddress());
		
		mEdit = new JTextField();
		mEdit.setBounds(40, 500, 400, 30);
		mEdit.setText("请输入指令");
		con.add(mEdit);
//		mEdit.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				mList.add(mEdit.getText().toString());
//			}
//		});
		
		mSend = new JButton();
		mSend.setBounds(470, 500, 60, 30);
		mSend.setText("发送");
		con.add(mSend);
		mSend.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String string = mEdit.getText().toString();
				if(string!=null)
				  mList.add(string);
			}
		});
		
		mList.setBounds(23, 40, 550, 450);
		mList.setFont(defaultFont);
		con.add(mList);
				
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new MyServerGui();
	}

}	
