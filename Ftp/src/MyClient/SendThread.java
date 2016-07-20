package MyClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SendThread extends Thread{
	
	Socket mSocket;
	DataOutputStream os = null;
	DataInputStream stdIn=null,is = null;
	
	public SendThread(Socket socket) throws IOException{
		this.mSocket = socket;
		os = new DataOutputStream(mSocket.getOutputStream());
		stdIn = new DataInputStream(System.in);
		is = new DataInputStream(mSocket.getInputStream());
	}
	
	public void run() {
		// TODO Auto-generated method stub
		String str="";
		try {
			while(!mSocket.isClosed()&&mSocket.isConnected()){
				str = stdIn.readLine();
				if(mSocket.isClosed()){
					System.out.println("�Ѿ���������Ͽ�����");
					os.close();
					stdIn.close();
					Client.cancelThread();
					break;
				}
				if(str.equals("bye")){
					System.out.println("������������Ͽ�����...");
					os.writeUTF(str);
					os.flush();
					os.close();
					stdIn.close();
					System.out.println("�Ͽ����ӳɹ�");
					Client.cancelThread();
					break;
				}else{
					os.writeUTF(str);
					os.flush();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
