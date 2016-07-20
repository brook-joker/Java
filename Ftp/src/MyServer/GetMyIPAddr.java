package MyServer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * ��ȡ���ص�ip��ַ
 * @author Kirito
 *
 */
public class GetMyIPAddr {
	public static InetAddress getLocalHostAddress() {
		try {
			for (Enumeration<NetworkInterface> nis = NetworkInterface
					.getNetworkInterfaces(); nis.hasMoreElements();) {
				NetworkInterface ni = nis.nextElement();
				if (ni.isLoopback() || ni.isVirtual() || !ni.isUp())
					continue;
				for (Enumeration<InetAddress> ias = ni.getInetAddresses(); ias
						.hasMoreElements();) {
					InetAddress ia = ias.nextElement();
					if (ia instanceof Inet6Address)
						continue;
					return ia;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	public static InetAddress getLocalHostIPV6Address() {
//		try {
//			for (Enumeration<NetworkInterface> nis = NetworkInterface
//					.getNetworkInterfaces(); nis.hasMoreElements();) {
//				NetworkInterface ni = nis.nextElement();
//				if (ni.isLoopback() || ni.isVirtual() || !ni.isUp())
//					continue;
//				for (Enumeration<InetAddress> ias = ni.getInetAddresses(); ias
//						.hasMoreElements();) {
//					InetAddress ia = ias.nextElement();
//					if (ia instanceof Inet6Address)
//						return ia;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public static void main(String[] args) throws UnknownHostException {
//		InetAddress myaddr = getLocalHostAddress();
//
//		System.out.println("������ַ" + myaddr.getHostAddress());
//		InetAddress myaddrV6 = getLocalHostIPV6Address();
//
//		System.out.println("my addr=" + myaddrV6.getHostAddress());

		// ���IPv4��ַ
		//InetAddress ipv4Address1 = InetAddress.getByName("1.2.3.4");
		//System.out.println("ipv4Address1: " + ipv4Address1.getHostAddress());
		//InetAddress ipv4Address2 = InetAddress.getByName("www.ibm.com");
		//System.out.println("ipv4Address2: " + ipv4Address2.getHostAddress());
		// ���IPv6��ַ
		//InetAddress ipv6Address1 = InetAddress.getByName("abcd:123::22ff");
		//System.out.println("ipv6Address1: " + ipv6Address1.getHostAddress());
		// �������ȫ����IP��ַ
//		InetAddress Addresses[] = InetAddress.getAllByName(InetAddress
//				.getLocalHost().getHostName());
//		for (InetAddress address : Addresses)
//			System.out.println("������ַ��" + address.getHostAddress());
//		System.out.println("����MAC��ַ��"+GetMyIPAddr.getMACAddress("192.168.1.123"));
//		try {
//			System.out.println(getMACAddress(getLocalHostAddress()));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	public static String getMACAddress(String ipAddress) {
//		String str = "", strMAC = "", macAddress = "";
//		try {
//			Process pp = Runtime.getRuntime().exec("nbtstat -a " + ipAddress);
//			InputStreamReader ir = new InputStreamReader(pp.getInputStream());
//			LineNumberReader input = new LineNumberReader(ir);
//			for (int i = 1; i < 100; i++) {
//				str = input.readLine();
//				if (str != null) {
//					if (str.indexOf("MAC ��ַ") > 1) {
//						strMAC = str.substring(str.indexOf("MAC ��ַ") + 9,
//								str.length());
//						System.out.println(str.indexOf("MAC ��ַ"));
//						break;
//					}
//				}
//			}
//		} catch (IOException ex) {
//			return "Can't Get MAC Address!";
//		}
//		//
//		if (strMAC.length() < 17) {
//			return "Error!";
//		}
//		macAddress = strMAC.substring(0, 2) + "" + strMAC.substring(3, 5)
//				+ "" + strMAC.substring(6, 8) + "" + strMAC.substring(9, 11)
//				+ "" + strMAC.substring(12, 14) + ""
//				+ strMAC.substring(15, 17);
//		//
//		return macAddress;
//	}
//
//	private static String getMACAddress(InetAddress ia) throws Exception {
//		// �������ӿڶ��󣨼������������õ�mac��ַ��mac��ַ������һ��byte�����С�
//		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
//		// ��������ǰ�mac��ַƴװ�� String
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < mac.length; i++) {
//			if (i != 0) {
//				sb.append("-");
//			}
//			// mac[i] & 0xFF ��Ϊ�˰�byteת��Ϊ������
//			String s = Integer.toHexString(mac[i] & 0xFF);
//			sb.append(s.length() == 1 ? 0 + s : s);
//		}
//		// ���ַ�������Сд��ĸ��Ϊ��д��Ϊ�����mac��ַ������
//		return sb.toString().toUpperCase();
//	}
//	public static String getMACAddress()  {
//		InetAddress ia=getLocalHostAddress();
//		try {
//			return getMACAddress(ia);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
}
