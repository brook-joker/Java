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
 * 线程处理类
 * @author Kirito
 *
 */

public class ClientServerThread extends Thread{
	//和本线程相关的Socket
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
	//线程进行的操作,响应客户端的请求
	public void run(){
		try{
			// 向客户端发送数据
	    	os = mSocket.getOutputStream();
	    	dos = new DataOutputStream(os);
	    	   
	    	dos.writeUTF("332:需要登录账户");  
            dos.flush(); 
            
            // 接收客户端的数据 
            while(!isStop){
        		is = mSocket.getInputStream();
            	dis =  new DataInputStream(is);
            	str = dis.readUTF();               	
            	print(str);
            	if(!isFirst){
	            	if(str.equalsIgnoreCase("bye")){
	            		try{
	        				//关闭资源
	            			print("已经与服务器断开连接");
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
	            		//获取服务器主目录
	            		dos.writeUTF(FileUtil.getHomeDir());
	            		dos.flush();
	            	}else if(str.equals("list")){
	            		//获取服务器目录下的文件信息
	            		dos.writeUTF("list");
	            		dos.flush();
	            		FileUtil.fileListDirection();
	            	}else if(str.equals("cdup")){
	            		dos.writeUTF(FileUtil.getHomeParentDir());
	            		dos.flush();
	            	}else if(str.split(" ")[0].equalsIgnoreCase("get")){
	            		String[] strings  = str.split(" ");
	            		//下载到默认目录下
	            		if(strings.length==2){
	            			dos.writeUTF("225get");
	            			dos.flush();
	            			FileUtil.downLoad(strings[1]);
	            			dos.writeUTF("226:请求的操作文件已经完成");
	            			dos.flush();
	            		}else{
	            			dos.writeUTF("指令有误,请检查后重新输入.");
		            		dos.flush();
	            		}
	            	}else if(str.split(" ")[0].equalsIgnoreCase("put")){
	            		String[] strings  = str.split(" ");
	            		//上传到服务器默认目录下
	            		if(strings.length==2){               	
	            			//TODO 文件上传
	            			dos.writeUTF("open");
	            			dos.flush();
	            			dos.writeUTF(strings[1]);
	            			dos.flush();
	            			FileUtil.upLoad(strings[1]);
	            		}else{
	            			dos.writeUTF("指令有误,请检查后重新输入.");
		            		dos.flush();
	            		}
	            	}else{
	            		dos.writeUTF("指令有误,请检查后重新输入.");
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
	 * 封装输出类
	 * @param msg
	 * @throws IOException 
	 */
	public  void print(String msg) throws IOException{
		if(isFirst){
			name = msg;
			System.out.println("第"+mIndex+"个客户端"+mAddress+"-"+name+":"+"已经连接成功");
			Server.addMsgToList("第"+mIndex+"个客户端"+mAddress+"-"+name+":"+"已经连接成功");
			dos.writeUTF("230:"+msg+"用户已登录请继续");
    		dos.flush();
		}else{
			System.out.println("第"+mIndex+"个客户端"+mAddress+"-"+name+":"+msg);
			Server.addMsgToList("第"+mIndex+"个客户端"+mAddress+"-"+name+":"+msg);
		}
	}
	/**
	 * 关闭连接
	 * @throws IOException
	 */
	public void cancelThread() throws IOException{
		this.isStop =true;
        dos.writeUTF("bye");
		dos.flush();
	}
	
	
	
}
