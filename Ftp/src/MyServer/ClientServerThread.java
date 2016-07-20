package MyServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

/**
 * �̴߳�����
 * @author Kirito
 *
 */

public class ClientServerThread extends Thread{
	//�ͱ��߳���ص�Socket
	 Socket mSocket;
	 Socket mTrans;
	 String mAddress;
	 int mIndex;
	 InputStream is = null;
	 OutputStream os = null;
	 DataInputStream dis = null;
	 DataOutputStream dos  = null;
	 String str = null,name=null;
	 volatile boolean isStop = false,isFirst = true;
	
	public ClientServerThread(Socket socket,Socket socket2,int index){
		this.mSocket = socket;
		this.mTrans = socket2;
		this.mAddress = mSocket.getInetAddress().getHostAddress();
		this.mIndex = index;
	}
	//�߳̽��еĲ���,��Ӧ�ͻ��˵�����
	public void run(){
		try{
			// ��ͻ��˷�������
	    	os = mSocket.getOutputStream();
	    	dos = new DataOutputStream(os);
	    	   
	    	dos.writeUTF("332:��Ҫ��¼�˻�");  
            dos.flush(); 
            
            // ���տͻ��˵����� 
            while(!isStop){
        		is = mSocket.getInputStream();
            	dis =  new DataInputStream(is);
            	str = dis.readUTF();               	
            	print(str);
            	if(!isFirst){
	            	if(str.equalsIgnoreCase("bye")){
	            		try{
	        				//�ر���Դ
	            			print("�Ѿ���������Ͽ�����");
	                        if (os != null)
	                            os.close();
	                        if (is != null)
	                            is.close();
	                        if (dos != null)
	                            dos.close();
	                        if (dis != null)
	                            dis.close();
	                        if (mSocket != null)
	                            mSocket.close();
	                		dos.flush();
	        			}catch(Exception e){
	        				e.printStackTrace();
	        			}
	            		break;
	            	}else if(str.equals("pwd")){
	            		//��ȡ��������Ŀ¼
	            		dos.writeUTF(FileUtil.getHomeDir());
	            		dos.flush();
	            	}else if(str.equals("list")){
	            		//��ȡ������Ŀ¼�µ��ļ���Ϣ
	            		dos.writeUTF("list");
	            		dos.flush();
	            		FileUtil.fileListDirection();
	            	}else if(str.equals("cdup")){
	            		dos.writeUTF(FileUtil.getHomeParentDir());
	            		dos.flush();
	            	}else if(str.split(" ")[0].equalsIgnoreCase("get")){
	            		String[] strings  = str.split(" ");
	            		//���ص�Ĭ��Ŀ¼��
	            		if(strings.length==2){
	            			dos.writeUTF("225get");
	            			dos.flush();
	            			FileUtil.downLoad(strings[1]);
	            			dos.writeUTF("226:����Ĳ����ļ��Ѿ����");
	            			dos.flush();
	            		}else{
	            			dos.writeUTF("ָ������,�������������.");
		            		dos.flush();
	            		}
	            	}else if(str.split(" ")[0].equalsIgnoreCase("put")){
	            		String[] strings  = str.split(" ");
	            		//�ϴ���������Ĭ��Ŀ¼��
	            		if(strings.length==2){               	
	            			//TODO �ļ��ϴ�
	            			dos.writeUTF("open");
	            			dos.flush();
	            			dos.writeUTF(strings[1]);
	            			dos.flush();
	            			FileUtil.upLoad(strings[1]);
	            		}else{
	            			dos.writeUTF("ָ������,�������������.");
		            		dos.flush();
	            		}
	            	}else{
	            		dos.writeUTF("ָ������,�������������.");
	            		dos.flush();
	            	}
            	}else{
            		isFirst = false;
            	}
            }
            					
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * ��װ�����
	 * @param msg
	 * @throws IOException 
	 */
	public  void print(String msg) throws IOException{
		if(isFirst){
			name = msg;
			System.out.println("��"+mIndex+"���ͻ���"+mAddress+"-"+name+":"+"�Ѿ����ӳɹ�");
			Server.addMsgToList("��"+mIndex+"���ͻ���"+mAddress+"-"+name+":"+"�Ѿ����ӳɹ�");
			dos.writeUTF("230:"+msg+"�û��ѵ�¼�����");
    		dos.flush();
		}else{
			System.out.println("��"+mIndex+"���ͻ���"+mAddress+"-"+name+":"+msg);
			Server.addMsgToList("��"+mIndex+"���ͻ���"+mAddress+"-"+name+":"+msg);
		}
	}
	/**
	 * �ر�����
	 * @throws IOException
	 */
	public void cancelThread() throws IOException{
		this.isStop =true;
        dos.writeUTF("bye");
		dos.flush();
	}
	
	
	
}
