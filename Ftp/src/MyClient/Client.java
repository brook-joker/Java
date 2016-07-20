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
	//�˿�����
	Socket sc_connect = null;
	//����������
	DataInputStream is = null;
	//���������
	DataOutputStream os = null;
	//��������༭��ļ����ַ���
	String str = null;
	//�����������ָ����߳�
	static Thread s;
	//��ȡ�������˷��ص���Ϣ
	static Thread c;
	//������
	Container con;
	//���Ͱ�ť
	JButton mSend;
	//����༭��
	JTextField mEdit;
	//��Ϣ�б�
	static List mLists = new List(20);
	//������ʽ
	private Font defaultFont = new Font("΢���ź�", Font.PLAIN, 14);
	
	@SuppressWarnings("deprecation")
	public Client() {
		// TODO Auto-generated method stub
		initGui();
		try {
			//�˿�1021 ��Ϊ���Ӷ˿�
			sc_connect = new Socket(GetMyIPAddr.getLocalHostAddress(),1021);
			is = new DataInputStream(sc_connect.getInputStream());
			os = new DataOutputStream(sc_connect.getOutputStream());
			printClient("�������ӷ�����");
			printServer(is.readUTF());
			c =  new ReadThread(sc_connect);
			c.start();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �رս��ܺ������߳�
	 */
	public static void cancelThread(){
		if(s!=null&&c!=null){
			s.interrupt();
			c.interrupt();
		}
	}
	/**
	 * ���������������
	 * @param msg
	 */
	public void sendToServer(String msg){
		try {
			if(sc_connect.isClosed()){
				System.out.println("�Ѿ���������Ͽ�����");
				addMsgToList("�Ѿ���������Ͽ�����");
				os.close();
				Client.cancelThread();
			}
			if(msg.equals("bye")){
				System.out.println("������������Ͽ�����...");
				addMsgToList("������������Ͽ�����...");
				os.writeUTF(msg);
				os.flush();
				os.close();			
				System.out.println("�Ͽ����ӳɹ�");
				addMsgToList("�Ͽ����ӳɹ�");
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
	 * ��ӡ�ͻ��˵���Ϣ
	 * @param msg
	 */
	public void printClient(String msg){
		System.out.println("�ͻ��� :"+msg);
		addMsgToList("�ͻ��� :"+msg);
	}
	/**
	 * ��ӡ�������˵���Ϣ
	 * @param msg
	 */
	public static void printServer(String msg){
		System.out.println("������:"+msg);
		addMsgToList("������:"+msg);
	}
	/**
	 * ��ʼ������
	 */
	public void initGui(){
		this.setBounds(200, 200, 600, 600);
		con = this.getContentPane();
		con.setLayout(null);
		//title
		this.setTitle("FTP�ͻ���");
		this.setFont(defaultFont);
		
		JLabel ipLab=new JLabel();
		ipLab.setFont(defaultFont);
		ipLab.setBounds(200,5,350,30);
		con.add(ipLab);
		ipLab.setText("�ͻ��˵�IP��ַΪ"+GetMyIPAddr.getLocalHostAddress().getHostAddress());
		
		mEdit = new JTextField();
		mEdit.setBounds(40, 500, 400, 30);
		con.add(mEdit);
		
		mSend = new JButton();
		mSend.setBounds(470, 500, 60, 30);
		mSend.setText("����");
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
	 * ���ܷ���:����Ϣ������ӵ�list��
	 * @param msg
	 */
	public static void addMsgToList(String msg){
		mLists.add(msg);
	}
	public static void main(String[] args){
		new Client();
	}
}
