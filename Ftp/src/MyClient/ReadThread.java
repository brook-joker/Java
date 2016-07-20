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
 * 接受来自服务器端的信息
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
					System.out.println("已经与服务器断开连接.");
					Client.addMsgToList("已经与服务器断开连接.");
		    		dos.writeUTF("bye");  
		            dos.flush();
		            mSocket.close();
		            dos.close();
		            is.close();
		            Client.cancelThread();
					break;
				}else{
					Client.printServer(str);
					//准备接受来自服务器的文件
					if(str.equals("225get")){
						//进行数据连接
						Socket socket = new Socket(GetMyIPAddr.getLocalHostAddress(),1022);
						//接受服务器的信息
						InputStream sockIn = socket.getInputStream();
						File file = getClientFileName(socket,sockIn);
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
						      writeOutInfo(socket,"下载成功!");   //文件接收成功后给客户端反馈一个信息  
						      System.out.println("文件接收成功!");  //服务端打印一下  
						      Client.addMsgToList("文件接收成功!");
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
		//进行数据连接
		Socket socket = new Socket(GetMyIPAddr.getLocalHostAddress(),1022);
		//接受服务器的信息
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
		System.out.println("准备上传文件中....");
		Client.addMsgToList("准备上传文件中....");
		//接受服务器回发的消息
		File file = new File(filePath);
		if(!file.exists()){
			dos.write("450error".getBytes());
			dos.flush();
			String string  = serveInfoBack(socket);
			System.out.println("服务器:"+string);
			Client.addMsgToList(string);
			serverSocket.close();
			socket.close();
			return;
			
		}else{
			dos.write(fileName.getBytes());
			dos.flush();
		}
		FileInputStream fis = new FileInputStream(file);
		//获取客户端的确认信息
		String info  = serveInfoBack(socket);
		if(info.equals("ok")){
			byte[] by=new byte[1024];  
		    int len;  
		    while((len=fis.read(by))!=-1)  
		    {  
		    	dos.write(by, 0, len);  
		    }  
		}else{
			System.out.println("服务器:"+info);
			Client.addMsgToList("服务器:"+info);
		}
		socket.shutdownOutput();
		String string = serveInfoBack(socket);
		System.out.println("服务器:"+string);
		Client.addMsgToList("服务器:"+string);
		serverSocket.close();
		socket.close();
		fis.close();
	}
	
	
	 public static File getClientFileName(Socket socket,InputStream sockIn) throws Exception //获取文件名并创建  
	 {    
	    //获取服务器回发的文件名,并判断在F盘创建同名文件的情况  
	    byte[] bufName=new byte[1024];  
	    int lenInfo =0;  
	    lenInfo = sockIn.read(bufName);  //获取文件名  
	    String fileName = new String(bufName,0,lenInfo);  
	    if(fileName.equals("450error")){
	    	System.out.println("文件不存在,断开该数据连接.");
	    	Client.addMsgToList("文件不存在,断开该数据连接.");
	    	return null;  
	    }
	    
	    File dir = new File(FileUtil.CLIENT_HOMEDIR);    //存到F:\\ftp/client  
	    File[] files=dir.listFiles();   //遍历目录  
	    for(File f:files)  
	    {  
	      if(!f.isDirectory())  //如果遍历到的该文件不是一个目录的话  
	      {   
	        if(f.getName().equals(fileName))  //判断是否是同名文件  
	        {  
	          System.out.println(f.getName()+"文件已存在,断开数据连接.");
	          Client.addMsgToList(f.getName()+"文件已存在,断开数据连接.");
	          writeOutInfo(socket,"客户端已存在同名文件!"); //反馈给客户端的信息  
	          return null;         
	        }  
	      }  
	    }  
	    System.out.println("将服务器发来的文件("+fileName+")存到"+FileUtil.CLIENT_HOMEDIR);       
	    Client.addMsgToList("将服务器发来的文件("+fileName+")存到"+FileUtil.CLIENT_HOMEDIR);
	    File file= new File(dir+"//"+fileName);    
	    if(file.createNewFile())  
	    {   
	      System.out.println("成功创建文件("+fileName+" )准备写入数据");
	      Client.addMsgToList("成功创建文件("+fileName+" )准备写入数据");
	      writeOutInfo(socket,"ok");    //告诉客户端,开始传送数据吧    
	      return file;  
	    }  
	    else  
	    {  
	      return null; //如果由于硬盘满了等原因创建文件失败的话  
	    }  
	  } 
	 public static void writeOutInfo(Socket sock,String infoStr)throws Exception//将信息反馈给服务端  
	  {  
	    OutputStream sockOut = sock.getOutputStream();  
	    sockOut.write(infoStr.getBytes());  
	  }  
	public static String serveInfoBack(Socket sock) throws Exception  //读取客户端的反馈信息  
	{  
	    InputStream sockIn = sock.getInputStream(); //定义socket输入流  
	    byte[] bufIn =new byte[1024];  
	    int lenIn=sockIn.read(bufIn);            //将客户端返回的信息写入bufIn字节缓冲区  
		    String info=new String(bufIn,0,lenIn);  
		    return info;  
		}  
}  
