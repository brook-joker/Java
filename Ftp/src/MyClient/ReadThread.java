package MyClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import MyServer.FileUtil;
import MyServer.GetMyIPAddr;
/**
 * �������Է������˵���Ϣ
 * @author Kirito
 *
 */
public class ReadThread extends Thread{
	Socket mSocket;
	DataInputStream  is = null;
	DataOutputStream dos = null;
	
	public ReadThread(Socket socket) throws IOException{
		this.mSocket = socket;
		is = new DataInputStream(mSocket.getInputStream());
		dos = new DataOutputStream(mSocket.getOutputStream());
	}
	
	public void run() {
		// TODO Auto-generated method stub
		String str;
		try {
			while((str = is.readUTF())!=null){
				if(str.equalsIgnoreCase("bye")){
					System.out.println("�Ѿ���������Ͽ�����.");
					Client.addMsgToList("�Ѿ���������Ͽ�����.");
		    		dos.writeUTF("bye");  
		            dos.flush();
		            mSocket.close();
		            dos.close();
		            is.close();
		            Client.cancelThread();
					break;
				}else{
					Client.printServer(str);
					//׼���������Է��������ļ�
					if(str.equals("225get")){
						//������������
						Socket socket = new Socket(GetMyIPAddr.getLocalHostAddress(),1022);
						//���ܷ���������Ϣ
						InputStream sockIn = socket.getInputStream();
						File file = getClientFileName(socket,sockIn);
						 if(file==null)  
					     {  
					        writeOutInfo(socket,"����ͬ���ļ����ȡ�ļ�ʧ��,����˶Ͽ���������!");  
					        socket.close(); 					          
					     }else{			
						      FileOutputStream fos= new FileOutputStream(file); //����д��Ӳ��  
						      byte[] bufFile = new byte[1024*1024];   //�������ݵĻ���  
						      int len=0;  
						      while(true)  
						      {  
							        len=sockIn.read(bufFile); //��������  
							        if(len!=-1)  
							        {  
							          fos.write(bufFile,0,len); //д��Ӳ���ļ�  
							        }  
							        else  
							        {  
							          break;  
							        }  
						      }  
						      writeOutInfo(socket,"���سɹ�!");   //�ļ����ճɹ�����ͻ��˷���һ����Ϣ  
						      System.out.println("�ļ����ճɹ�!");  //����˴�ӡһ��  
						      Client.addMsgToList("�ļ����ճɹ�!");
						      fos.close();  
						      socket.close(); 
					     }
					  }else if(str.equals("open")){ 															
						 upLoad(is.readUTF());
					  }else if(str.equals("list")){
						  showList();
					  }
					}
				}		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void showList() throws Exception {
		// TODO Auto-generated method stub
		//������������
		Socket socket = new Socket(GetMyIPAddr.getLocalHostAddress(),1022);
		//���ܷ���������Ϣ
		String string = serveInfoBack(socket);
		String[] strings = string.split("\n");
		for (int i = 0; i < strings.length; i++) {
			Client.printServer(strings[i]);
		}
		socket.close();
	}
	

	public static void upLoad(String fileName) throws Exception{
		String filePath = FileUtil.CLIENT_HOMEDIR+"//"+fileName;
		ServerSocket serverSocket  = new ServerSocket(1022);
		Socket socket = serverSocket.accept();
		OutputStream dos =socket.getOutputStream();
		System.out.println("׼���ϴ��ļ���....");
		Client.addMsgToList("׼���ϴ��ļ���....");
		//���ܷ������ط�����Ϣ
		File file = new File(filePath);
		if(!file.exists()){
			dos.write("450error".getBytes());
			dos.flush();
			String string  = serveInfoBack(socket);
			System.out.println("������:"+string);
			Client.addMsgToList(string);
			serverSocket.close();
			socket.close();
			return;
			
		}else{
			dos.write(fileName.getBytes());
			dos.flush();
		}
		FileInputStream fis = new FileInputStream(file);
		//��ȡ�ͻ��˵�ȷ����Ϣ
		String info  = serveInfoBack(socket);
		if(info.equals("ok")){
			byte[] by=new byte[1024];  
		    int len;  
		    while((len=fis.read(by))!=-1)  
		    {  
		    	dos.write(by, 0, len);  
		    }  
		}else{
			System.out.println("������:"+info);
			Client.addMsgToList("������:"+info);
		}
		socket.shutdownOutput();
		String string = serveInfoBack(socket);
		System.out.println("������:"+string);
		Client.addMsgToList("������:"+string);
		serverSocket.close();
		socket.close();
		fis.close();
	}
	
	
	 public static File getClientFileName(Socket socket,InputStream sockIn) throws Exception //��ȡ�ļ���������  
	 {    
	    //��ȡ�������ط����ļ���,���ж���F�̴���ͬ���ļ������  
	    byte[] bufName=new byte[1024];  
	    int lenInfo =0;  
	    lenInfo = sockIn.read(bufName);  //��ȡ�ļ���  
	    String fileName = new String(bufName,0,lenInfo);  
	    if(fileName.equals("450error")){
	    	System.out.println("�ļ�������,�Ͽ�����������.");
	    	Client.addMsgToList("�ļ�������,�Ͽ�����������.");
	    	return null;  
	    }
	    
	    File dir = new File(FileUtil.CLIENT_HOMEDIR);    //�浽F:\\ftp/client  
	    File[] files=dir.listFiles();   //����Ŀ¼  
	    for(File f:files)  
	    {  
	      if(!f.isDirectory())  //����������ĸ��ļ�����һ��Ŀ¼�Ļ�  
	      {   
	        if(f.getName().equals(fileName))  //�ж��Ƿ���ͬ���ļ�  
	        {  
	          System.out.println(f.getName()+"�ļ��Ѵ���,�Ͽ���������.");
	          Client.addMsgToList(f.getName()+"�ļ��Ѵ���,�Ͽ���������.");
	          writeOutInfo(socket,"�ͻ����Ѵ���ͬ���ļ�!"); //�������ͻ��˵���Ϣ  
	          return null;         
	        }  
	      }  
	    }  
	    System.out.println("���������������ļ�("+fileName+")�浽"+FileUtil.CLIENT_HOMEDIR);       
	    Client.addMsgToList("���������������ļ�("+fileName+")�浽"+FileUtil.CLIENT_HOMEDIR);
	    File file= new File(dir+"//"+fileName);    
	    if(file.createNewFile())  
	    {   
	      System.out.println("�ɹ������ļ�("+fileName+" )׼��д������");
	      Client.addMsgToList("�ɹ������ļ�("+fileName+" )׼��д������");
	      writeOutInfo(socket,"ok");    //���߿ͻ���,��ʼ�������ݰ�    
	      return file;  
	    }  
	    else  
	    {  
	      return null; //�������Ӳ�����˵�ԭ�򴴽��ļ�ʧ�ܵĻ�  
	    }  
	  } 
	 public static void writeOutInfo(Socket sock,String infoStr)throws Exception//����Ϣ�����������  
	  {  
	    OutputStream sockOut = sock.getOutputStream();  
	    sockOut.write(infoStr.getBytes());  
	  }  
	public static String serveInfoBack(Socket sock) throws Exception  //��ȡ�ͻ��˵ķ�����Ϣ  
	{  
	    InputStream sockIn = sock.getInputStream(); //����socket������  
	    byte[] bufIn =new byte[1024];  
	    int lenIn=sockIn.read(bufIn);            //���ͻ��˷��ص���Ϣд��bufIn�ֽڻ�����  
		    String info=new String(bufIn,0,lenIn);  
		    return info;  
		}  
}  
