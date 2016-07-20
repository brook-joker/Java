	package MyServer;

import java.awt.Container;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Server extends JFrame{
	private static final long serialVersionUID = 1L;
	ServerSocket server_connect = null;
	//连接端口
	Socket sc_connect = null;
	//传输端口
	Socket sc_transport = null;
	//客户端数量
	static int count = 0;
	//线程池
	static Hashtable<String,ClientServerThread> mList = 
			new Hashtable<String,ClientServerThread>();
	//UI组件
	Container con;
	//发送按钮
	JButton mSend;
	//输入框
	JTextField mEdit;
	//消息列表
	static List mLists = new List(20);
	//文字样式
	private Font defaultFont = new Font("微软雅黑", Font.PLAIN, 14);
	
	public Server(){
		initGui();
		try {
			//开启连接端口
			server_connect = new ServerSocket(1021);
			System.out.println("FTP服务器开启成功,正在监听中....");
			addMsgToList("FTP服务器开启成功,正在监听中....");
			new ServerThread().start();
			while(true){
				sc_connect = server_connect.accept();
				count++; //统计客户端的数量
				ClientServerThread thread = new ClientServerThread(sc_connect,sc_transport,count);
				thread.start();
				//将线程加入线程池		
				mList.put(count+"", thread);
				System.out.println("当前客户端的数量: " + count);
				addMsgToList("当前客户端的数量: " + count);
				InetAddress address = sc_connect.getInetAddress();
				System.out.println("新加入的客户端的IP:" + address.getHostAddress()+"正在请求连接...");		
				addMsgToList("新加入的客户端的IP:" + address.getHostAddress()+"正在请求连接...");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 杀死对应线程
	 * @param index
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void killThread(int index) throws IOException, InterruptedException{
		if(index>0&&mList.containsKey(index+"")){	
			//找到对应线程 停止它		
			ClientServerThread thread = (ClientServerThread)mList.get(index+"");
			thread.cancelThread();
			thread.interrupt();
			thread.join();
			mList.remove(index+"");
			System.out.println(index+"线程已停止");
			addMsgToList(index+"线程已停止");
			count--;
		}else {
			System.out.println(index+"线程不存在");
			addMsgToList(index+"线程不存在");
		}
	}
	
	public void initGui(){
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
		
		mSend = new JButton();
		mSend.setBounds(470, 500, 60, 30);
		mSend.setText("发送");
		con.add(mSend);
		mSend.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String string = mEdit.getText().toString();
				addMsgToList(string);
				String[] str= string.split(" ");
				//kill index
				if(str[0].equalsIgnoreCase("kill")){
					if(str.length==2){
						Integer i = Integer.valueOf(str[1]);
						try {
							Server.killThread(i);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}else{
					System.out.println("未知指令.");
					addMsgToList("无效指令");
				}
			}
		});
		mLists.setBounds(23, 40, 550, 450);
		mLists.setFont(defaultFont);
		con.add(mLists);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void addMsgToList(String msg){
		mLists.add(msg);
	}
	public static void main(String[] args){
		new Server();
	}
}
