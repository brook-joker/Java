package MyServer;

import java.io.IOException;
import java.util.Scanner;

/**
 * ����:�����������˵�����ָ�� ����ָ��������Ӧ�Ĳ���
 * @author Kirito
 *
 */
public class ServerThread extends Thread{
	public void run() {
		Scanner sc = new Scanner(System.in);
		String string = null;
		while(true){
			string = sc.nextLine();
			String[] str= string.split(" ");
			//kill index
			if(str[0].equalsIgnoreCase("kill")){
				if(str.length==2){
					Integer i = Integer.valueOf(str[1]);
					try {
						Server.killThread(i);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				System.out.println("δָ֪��.");
			}
		}
	}
}
