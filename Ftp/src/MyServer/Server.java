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
	//���Ӷ˿�
	Socket sc_connect = null;
	//����˿�
	Socket sc_transport = null;
	//�ͻ�������
	static int count = 0;
	//�̳߳�
	static Hashtable<String,ClientServerThread> mList = 
			new Hashtable<String,ClientServerThread>();
	//UI���
	Container con;
	//���Ͱ�ť
	JButton mSend;
	//�����
	JTextField mEdit;
	//��Ϣ�б�
	static List mLists = new List(20);
	//������ʽ
	private Font defaultFont = new Font("΢���ź�", Font.PLAIN, 14);
	
	public Server(){
		initGui();
		try {
			//�������Ӷ˿�
			server_connect = new ServerSocket(1021);
			System.out.println("FTP�����������ɹ�,���ڼ�����....");
			addMsgToList("FTP�����������ɹ�,���ڼ�����....");
			new ServerThread().start();
			while(true){
				sc_connect = server_connect.accept();
				count++; //ͳ�ƿͻ��˵�����
				ClientServerThread thread = new ClientServerThread(sc_connect,sc_transport,count);
				thread.start();
				//���̼߳����̳߳�		
				mList.put(count+"", thread);
				System.out.println("��ǰ�ͻ��˵�����: " + count);
				addMsgToList("��ǰ�ͻ��˵�����: " + count);
				InetAddress address = sc_connect.getInetAddress();
				System.out.println("�¼���Ŀͻ��˵�IP:" + address.getHostAddress()+"������������...");		
				addMsgToList("�¼���Ŀͻ��˵�IP:" + address.getHostAddress()+"������������...");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ɱ����Ӧ�߳�
	 * @param index
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void killThread(int index) throws IOException, InterruptedException{
		if(index>0&&mList.containsKey(index+"")){	
			//�ҵ���Ӧ�߳� ֹͣ��		
			ClientServerThread thread = (ClientServerThread)mList.get(index+"");
			thread.cancelThread();
			thread.interrupt();
			thread.join();
			mList.remove(index+"");
			System.out.println(index+"�߳���ֹͣ");
			addMsgToList(index+"�߳���ֹͣ");
			count--;
		}else {
			System.out.println(index+"�̲߳�����");
			addMsgToList(index+"�̲߳�����");
		}
	}
	
	public void initGui(){
		this.setBounds(200, 200, 600, 600);
		con = this.getContentPane();
		con.setLayout(null);
		//title
		this.setTitle("FTP������v1.0");
		this.setFont(defaultFont);
		
		JLabel ipLab=new JLabel();
		ipLab.setFont(defaultFont);
		ipLab.setBounds(200,5,350,30);
		con.add(ipLab);
		ipLab.setText("��������IP��ַΪ"+GetMyIPAddr.getLocalHostAddress().getHostAddress());
		
		mEdit = new JTextField();
		mEdit.setBounds(40, 500, 400, 30);
		mEdit.setText("������ָ��");
		con.add(mEdit);
		
		mSend = new JButton();
		mSend.setBounds(470, 500, 60, 30);
		mSend.setText("����");
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
					System.out.println("δָ֪��.");
					addMsgToList("��Чָ��");
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
