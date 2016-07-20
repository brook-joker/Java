package MyServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream.GetField;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * �ļ�������
 * @author Kirito
 *
 */
public class FileUtil {
	//��������Ŀ¼
	public static final String SERVER_HOMEDIR = "F:\\ftp/server";
	//�ͻ�����Ŀ¼
	public static final String CLIENT_HOMEDIR = "F:\\ftp/client";
	//�������Ӷ˿�
	static Socket socket;
	
	/**
	 * ����������µ��ļ�Ŀ¼
	 * @throws IOException
	 */
	public static void fileListDirection() throws IOException{
		fileListDirection(SERVER_HOMEDIR);
	}
	
	/**
	 * ��ȡ������Ŀ¼�µ��ļ��嵥
	 * @param filename
	 * @throws IOException 
	 */
	public static void fileListDirection(String filename) throws IOException{
		ServerSocket serverSocket  = new ServerSocket(1022);
		Socket socket = serverSocket.accept();
		OutputStream dos =socket.getOutputStream();
		print("�������Ӵ�");	
		@SuppressWarnings("unused")
		List<String> mList = new ArrayList<String>();
		Format simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = "";
		File file = new File(filename);
		File[] fileListFiles = file.listFiles();
		str+=filename+"Ŀ¼�µ��ļ�����:"+fileListFiles.length+"\n";
		for (int i = 0; i < fileListFiles.length; i++) {
		  if (fileListFiles[i].isFile()) {		
			  str+="��     ����"+simpleFormat.format(fileListFiles[i].lastModified())+"\t"+fileListFiles[i].length()
					  +"\t"+fileListFiles[i]+"\n";
		  }
		  if (fileListFiles[i].isDirectory()) {
		    str+="�ļ��У�"+simpleFormat.format(fileListFiles[i].lastModified())+"\t"+fileListFiles[i].length()
					  +"\t"+fileListFiles[i]+"\n";
		  }
		}
		dos.write(str.getBytes());
		dos.flush();
		dos.close();
		socket.close();
		serverSocket.close();
	}
	
	/**
	 * �����ļ�
	 * @param fileIn
	 * @return
	 * @throws Exception 
	 */
	public static void downLoad(String fileIn) throws Exception{
		downLoad(fileIn, CLIENT_HOMEDIR+"\\"+fileIn);
	}
	
	/**
	 * �����ļ�
	 * get remote-file[local-file] �� ��Զ���������ļ� remote-file ��������Ӳ�̵� local-file ��
	 * @param fileIn       Ҫ���ص��ļ�Ŀ¼
	 * @param fileOutPut   ���ص�ָ�����ļ�Ŀ¼
	 * @throws Exception 
	 */
	public static void downLoad(String fileIn,String fileOutPut) throws Exception{
		String filePath  = SERVER_HOMEDIR+"//"+fileIn;
		//���ݳ�����
		ServerSocket serverSocket  = new ServerSocket(1022);
		Socket socket = serverSocket.accept();
		OutputStream dos =socket.getOutputStream();
		print("�������Ӵ�");		
		File file = new File(filePath);
		if(!file.exists()){
			dos.write("450error".getBytes());
			dos.flush();
			String str = clientInfoBack(socket);
			System.out.println("�ͻ���:"+str);
			Server.addMsgToList("�ͻ���:"+str);
			serverSocket.close();
			socket.close();
			return;
			
		}
		FileInputStream fis = new FileInputStream(file);
		//��ȡ�ļ���
		String filename = file.getName();
		print("�������ļ���:"+filename);
		dos.write(filename.getBytes());
		dos.flush();
		//��ȡ�ͻ��˵�ȷ����Ϣ
		String info  = clientInfoBack(socket);
		if(info.equals("ok")){
			byte[] by=new byte[1024];  
		    int len;  
		    while((len=fis.read(by))!=-1)  
		    {  
		    	dos.write(by, 0, len);  
		    }  
		}else{
			System.out.println("�ͻ���:"+info);
			Server.addMsgToList("�ͻ���:"+info);
		}
		socket.shutdownOutput();
		String string = clientInfoBack(socket);
		System.out.println("�ͻ���:"+string);
		Server.addMsgToList("�ͻ���:"+string);
		serverSocket.close();
		socket.close();
		fis.close();
	}
	
	public static String clientInfoBack(Socket sock) throws Exception  //��ȡ�ͻ��˵ķ�����Ϣ  
	{  
	    InputStream sockIn = sock.getInputStream(); //����socket������  
	    byte[] bufIn =new byte[1024];  
	    int lenIn=sockIn.read(bufIn);            //���ͻ��˷��ص���Ϣд��bufIn�ֽڻ�����  
	    String info=new String(bufIn,0,lenIn);  
	    return info;  
	}  
	/**
	 * �ϴ��ļ�
	 * @throws Exception 
	 */
	public static void upLoad(String fileName) throws Exception{
		upLoad(fileName, SERVER_HOMEDIR+"//"+fileName);
	}
	/**
	 * �ϴ��ļ�
	 * @param fileName
	 * @param serverPath
	 * @return
	 * @throws Exception 
	 */
	public static void upLoad(String fileName,String serverPath) throws Exception{
		String filePath  = CLIENT_HOMEDIR+"//"+fileName;
		//������������
		 socket = new Socket(GetMyIPAddr.getLocalHostAddress(),1022);
		//���ܿͻ��˵���Ϣ
		InputStream sockIn = socket.getInputStream();
		File file = getClientFileName(sockIn);
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
		      writeOutInfo(socket,"�ϴ��ɹ�!");   //�ļ����ճɹ�����ͻ��˷���һ����Ϣ  
		      print("�ļ����ճɹ�!");  //����˴�ӡһ��  
		      fos.close();  
		      socket.close();
	     }
	}
	 public static File getClientFileName(InputStream sockIn) throws Exception //��ȡ�ļ���������  
	  {    
		//��ȡ�ͻ��˻ط����ļ���,���ж���F�̴���ͬ���ļ������  
	    byte[] bufName=new byte[1024];  
	    int lenInfo =0;  
	    lenInfo = sockIn.read(bufName);  //��ȡ�ļ���  
	    String fileName = new String(bufName,0,lenInfo);
	    if(fileName.equals("450error")){
	    	print("�ļ�������,�Ͽ�����������.");  
	    	return null;  
	    }    
	    File dir = new File(FileUtil.SERVER_HOMEDIR);    //�浽F:\\ftp/server  
	    File[] files=dir.listFiles();   //����Ŀ¼  
	    for(File f:files)  
	    {  
	      if(!f.isDirectory())  //����������ĸ��ļ�����һ��Ŀ¼�Ļ�  
	      {   
	        if(f.getName().equals(fileName))  //�ж��Ƿ���ͬ���ļ�  
	        {  
	          print(f.getName()+"�ļ��Ѵ���,�Ͽ���������.");  
	          writeOutInfo(socket,"������ �Ѵ���ͬ���ļ�!"); //�������ͻ��˵���Ϣ  
	          return null;         
	        }  
	      }  
	    }  
	    print("���ͻ��˷������ļ�("+fileName+")�浽"+FileUtil.SERVER_HOMEDIR);       
	    File file= new File(dir+"//"+fileName);    
	    if(file.createNewFile())  
	    {   
	      print("�ɹ������ļ�("+fileName+" )׼��д������");	  
	      writeOutInfo(socket,"ok");    //���߿ͻ���,��ʼ�������ݰ�    
	      return file;  
	    }  
	    else  
	    {  
	      return null; //�������Ӳ�����˵�ԭ�򴴽��ļ�ʧ�ܵĻ�  
	    }  
	  }
	 /**
	  * ��������д������
	  * @param sock
	  * @param infoStr
	  * @throws Exception
	  */
	 public static void writeOutInfo(Socket sock,String infoStr)throws Exception//����Ϣ�����������  
	  {  
	    OutputStream sockOut = sock.getOutputStream();  
	    sockOut.write(infoStr.getBytes());  
	  }  
	/**
	 * PWD����
	 * @return
	 */
	public static String getHomeDir(){
		return SERVER_HOMEDIR;
	}
	/**
	 * CUDP����
	 * @return
	 */
	public static String getHomeParentDir(){
		return new File(SERVER_HOMEDIR).getParent();
	}
	public static void print(String msg) {
		System.out.println("������:"+msg);
		Server.addMsgToList("������:"+msg);
	}
}
