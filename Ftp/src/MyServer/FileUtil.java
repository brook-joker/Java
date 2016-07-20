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
 * 文件操作类
 * @author Kirito
 *
 */
public class FileUtil {
	//服务器主目录
	public static final String SERVER_HOMEDIR = "F:\\ftp/server";
	//客户端主目录
	public static final String CLIENT_HOMEDIR = "F:\\ftp/client";
	//数据连接端口
	static Socket socket;
	
	/**
	 * 传输服务器下的文件目录
	 * @throws IOException
	 */
	public static void fileListDirection() throws IOException{
		fileListDirection(SERVER_HOMEDIR);
	}
	
	/**
	 * 获取服务器目录下的文件清单
	 * @param filename
	 * @throws IOException 
	 */
	public static void fileListDirection(String filename) throws IOException{
		ServerSocket serverSocket  = new ServerSocket(1022);
		Socket socket = serverSocket.accept();
		OutputStream dos =socket.getOutputStream();
		print("数据连接打开");	
		@SuppressWarnings("unused")
		List<String> mList = new ArrayList<String>();
		Format simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = "";
		File file = new File(filename);
		File[] fileListFiles = file.listFiles();
		str+=filename+"目录下的文件数量:"+fileListFiles.length+"\n";
		for (int i = 0; i < fileListFiles.length; i++) {
		  if (fileListFiles[i].isFile()) {		
			  str+="文     件："+simpleFormat.format(fileListFiles[i].lastModified())+"\t"+fileListFiles[i].length()
					  +"\t"+fileListFiles[i]+"\n";
		  }
		  if (fileListFiles[i].isDirectory()) {
		    str+="文件夹："+simpleFormat.format(fileListFiles[i].lastModified())+"\t"+fileListFiles[i].length()
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
	 * 下载文件
	 * @param fileIn
	 * @return
	 * @throws Exception 
	 */
	public static void downLoad(String fileIn) throws Exception{
		downLoad(fileIn, CLIENT_HOMEDIR+"\\"+fileIn);
	}
	
	/**
	 * 下载文件
	 * get remote-file[local-file] ： 将远程主机的文件 remote-file 传至本地硬盘的 local-file 。
	 * @param fileIn       要下载的文件目录
	 * @param fileOutPut   下载到指定的文件目录
	 * @throws Exception 
	 */
	public static void downLoad(String fileIn,String fileOutPut) throws Exception{
		String filePath  = SERVER_HOMEDIR+"//"+fileIn;
		//数据长连接
		ServerSocket serverSocket  = new ServerSocket(1022);
		Socket socket = serverSocket.accept();
		OutputStream dos =socket.getOutputStream();
		print("数据连接打开");		
		File file = new File(filePath);
		if(!file.exists()){
			dos.write("450error".getBytes());
			dos.flush();
			String str = clientInfoBack(socket);
			System.out.println("客户端:"+str);
			Server.addMsgToList("客户端:"+str);
			serverSocket.close();
			socket.close();
			return;
			
		}
		FileInputStream fis = new FileInputStream(file);
		//获取文件名
		String filename = file.getName();
		print("待传输文件名:"+filename);
		dos.write(filename.getBytes());
		dos.flush();
		//获取客户端的确认信息
		String info  = clientInfoBack(socket);
		if(info.equals("ok")){
			byte[] by=new byte[1024];  
		    int len;  
		    while((len=fis.read(by))!=-1)  
		    {  
		    	dos.write(by, 0, len);  
		    }  
		}else{
			System.out.println("客户端:"+info);
			Server.addMsgToList("客户端:"+info);
		}
		socket.shutdownOutput();
		String string = clientInfoBack(socket);
		System.out.println("客户端:"+string);
		Server.addMsgToList("客户端:"+string);
		serverSocket.close();
		socket.close();
		fis.close();
	}
	
	public static String clientInfoBack(Socket sock) throws Exception  //读取客户端的反馈信息  
	{  
	    InputStream sockIn = sock.getInputStream(); //定义socket输入流  
	    byte[] bufIn =new byte[1024];  
	    int lenIn=sockIn.read(bufIn);            //将客户端返回的信息写入bufIn字节缓冲区  
	    String info=new String(bufIn,0,lenIn);  
	    return info;  
	}  
	/**
	 * 上传文件
	 * @throws Exception 
	 */
	public static void upLoad(String fileName) throws Exception{
		upLoad(fileName, SERVER_HOMEDIR+"//"+fileName);
	}
	/**
	 * 上传文件
	 * @param fileName
	 * @param serverPath
	 * @return
	 * @throws Exception 
	 */
	public static void upLoad(String fileName,String serverPath) throws Exception{
		String filePath  = CLIENT_HOMEDIR+"//"+fileName;
		//进行数据连接
		 socket = new Socket(GetMyIPAddr.getLocalHostAddress(),1022);
		//接受客户端的信息
		InputStream sockIn = socket.getInputStream();
		File file = getClientFileName(sockIn);
		 if(file==null)  
	     {  
	        writeOutInfo(socket,"存在同名文件或获取文件失败,服务端断开数据连接!");  
	        socket.close(); 					          
	     }else{			
		      FileOutputStream fos= new FileOutputStream(file); //用来写入硬盘  
		      byte[] bufFile = new byte[1024*1024];   //接收数据的缓存  
		      int len=0;  
		      while(true)  
		      {  
			        len=sockIn.read(bufFile); //接收数据  
			        if(len!=-1)  
			        {  
			          fos.write(bufFile,0,len); //写入硬盘文件  
			        }  
			        else  
			        {  
			          break;  
			        }  
		      }  
		      writeOutInfo(socket,"上传成功!");   //文件接收成功后给客户端反馈一个信息  
		      print("文件接收成功!");  //服务端打印一下  
		      fos.close();  
		      socket.close();
	     }
	}
	 public static File getClientFileName(InputStream sockIn) throws Exception //获取文件名并创建  
	  {    
		//获取客户端回发的文件名,并判断在F盘创建同名文件的情况  
	    byte[] bufName=new byte[1024];  
	    int lenInfo =0;  
	    lenInfo = sockIn.read(bufName);  //获取文件名  
	    String fileName = new String(bufName,0,lenInfo);
	    if(fileName.equals("450error")){
	    	print("文件不存在,断开该数据连接.");  
	    	return null;  
	    }    
	    File dir = new File(FileUtil.SERVER_HOMEDIR);    //存到F:\\ftp/server  
	    File[] files=dir.listFiles();   //遍历目录  
	    for(File f:files)  
	    {  
	      if(!f.isDirectory())  //如果遍历到的该文件不是一个目录的话  
	      {   
	        if(f.getName().equals(fileName))  //判断是否是同名文件  
	        {  
	          print(f.getName()+"文件已存在,断开数据连接.");  
	          writeOutInfo(socket,"服务器 已存在同名文件!"); //反馈给客户端的信息  
	          return null;         
	        }  
	      }  
	    }  
	    print("将客户端发来的文件("+fileName+")存到"+FileUtil.SERVER_HOMEDIR);       
	    File file= new File(dir+"//"+fileName);    
	    if(file.createNewFile())  
	    {   
	      print("成功创建文件("+fileName+" )准备写入数据");	  
	      writeOutInfo(socket,"ok");    //告诉客户端,开始传送数据吧    
	      return file;  
	    }  
	    else  
	    {  
	      return null; //如果由于硬盘满了等原因创建文件失败的话  
	    }  
	  }
	 /**
	  * 往连接中写入数据
	  * @param sock
	  * @param infoStr
	  * @throws Exception
	  */
	 public static void writeOutInfo(Socket sock,String infoStr)throws Exception//将信息反馈给服务端  
	  {  
	    OutputStream sockOut = sock.getOutputStream();  
	    sockOut.write(infoStr.getBytes());  
	  }  
	/**
	 * PWD功能
	 * @return
	 */
	public static String getHomeDir(){
		return SERVER_HOMEDIR;
	}
	/**
	 * CUDP功能
	 * @return
	 */
	public static String getHomeParentDir(){
		return new File(SERVER_HOMEDIR).getParent();
	}
	public static void print(String msg) {
		System.out.println("服务器:"+msg);
		Server.addMsgToList("服务器:"+msg);
	}
}
