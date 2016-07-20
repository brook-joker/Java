package MyClient;

import java.awt.Container;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import MyServer.GetMyIPAddr;

public class Client extends JFrame{
	private static final long serialVersionUID = 1L;
	//端口连接
	Socket sc_connect = null;
	//数据输入流
	DataInputStream is = null;
	//数据输出流
	DataOutputStream os = null;
	//用来保存编辑框的键入字符串
	String str = null;
	//向服务器输入指令的线程
	static Thread s;
	//读取服务器端返回的消息
	static Thread c;
	//主布局
	Container con;
	//发送按钮
	JButton mSend;
	//输入编辑框
	JTextField mEdit;
	//消息列表
	static List mLists = new List(20);
	//字体样式
	private Font defaultFont = new Font("微软雅黑", Font.PLAIN, 14);
	
	@SuppressWarnings("deprecation")
	public Client() {
		// TODO Auto-generated method stub
		initGui();
		try {
			//端口1021 作为连接端口
			sc_connect = new Socket(GetMyIPAddr.getLocalHostAddress(),1021);
			is = new DataInputStream(sc_connect.getInputStream());
			os = new DataOutputStream(sc_connect.getOutputStream());
			printClient("正在连接服务器");
			printServer(is.readUTF());
			c =  new ReadThread(sc_connect);
			c.start();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 关闭接受和输入线程
	 */
	public static void cancelThread(){
		if(s!=null&&c!=null){
			s.interrupt();
			c.interrupt();
		}
	}
	/**
	 * 发送命令给服务器
	 * @param msg
	 */
	public void sendToServer(String msg){
		try {
			if(sc_connect.isClosed()){
				System.out.println("已经与服务器断开连接");
				addMsgToList("已经与服务器断开连接");
				os.close();
				Client.cancelThread();
			}
			if(msg.equals("bye")){
				System.out.println("正在与服务器断开连接...");
				addMsgToList("正在与服务器断开连接...");
				os.writeUTF(msg);
				os.flush();
				os.close();			
				System.out.println("断开连接成功");
				addMsgToList("断开连接成功");
				Client.cancelThread();				
			}else{
				os.writeUTF(msg);
				os.flush();
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	/**
	 * 打印客户端的消息
	 * @param msg
	 */
	public void printClient(String msg){
		System.out.println("客户端 :"+msg);
		addMsgToList("客户端 :"+msg);
	}
	/**
	 * 打印服务器端的消息
	 * @param msg
	 */
	public static void printServer(String msg){
		System.out.println("服务器:"+msg);
		addMsgToList("服务器:"+msg);
	}
	/**
	 * 初始化布局
	 */
	public void initGui(){
		this.setBounds(200, 200, 600, 600);
		con = this.getContentPane();
		con.setLayout(null);
		//title
		this.setTitle("FTP客户端");
		this.setFont(defaultFont);
		
		JLabel ipLab=new JLabel();
		ipLab.setFont(defaultFont);
		ipLab.setBounds(200,5,350,30);
		con.add(ipLab);
		ipLab.setText("客户端的IP地址为"+GetMyIPAddr.getLocalHostAddress().getHostAddress());
		
		mEdit = new JTextField();
		mEdit.setBounds(40, 500, 400, 30);
		con.add(mEdit);
		
		mSend = new JButton();
		mSend.setBounds(470, 500, 60, 30);
		mSend.setText("发送");
		con.add(mSend);
		mSend.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String string  =  mEdit.getText().toString();
				addMsgToList(string);
				sendToServer(string);
			}
		});
		
		mLists.setBounds(23, 40, 550, 450);
		mLists.setFont(defaultFont);
		con.add(mLists);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * 功能方法:将消息内容添加到list上
	 * @param msg
	 */
	public static void addMsgToList(String msg){
		mLists.add(msg);
	}
	public static void main(String[] args){
		new Client();
	}
}
