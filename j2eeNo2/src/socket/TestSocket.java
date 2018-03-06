package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class TestSocket {
	public static void main(String[] args) throws UnknownHostException,IOException {
		//��ȡ����IP��ַ
		InetAddress host = InetAddress.getLocalHost();
		String ip= host.getHostAddress();
		System.out.println("����ip��ַ��"+ip);
		
		//ʹ��java ִ��ping����
		Process p1 = Runtime.getRuntime().exec("ping " + "192.168.233.1");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br1.readLine()) != null) {
            if (line.length() != 0)
                sb.append(line + "\r\n");
        }
        System.out.println("����ָ��ص���Ϣ�ǣ�");
        System.out.println(sb.toString());
        
        //�жϱ������ж��ٿ��õ�ip��ַ
        List<String> ipList=new ArrayList<String>();
        for (int ipEnd = 1; ipEnd <= 255; ipEnd++) {
        	Process p2 = Runtime.getRuntime().exec("ping " + "192.168.233."+ipEnd);
        	BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        	if (br2!=null) {
        		System.out.println("�Ѿ���ɣ�"+ipEnd+"��ip����");
			}
        	String message = null;
        	int i=1;
        	while ((message=br2.readLine())!=null) {
				if (i==9 && message.contains("(0% ��ʧ)")) {
					ipList.add("192.168.2."+ipEnd);
				}
				i++;
			}
        	br2=null;
		}
        
        System.out.println("����ip��ַ��������");
        for (String ipAddress : ipList) {
			System.out.println(ipAddress);
		}
        System.out.println("�ܹ��У�"+ipList.size()+"����ַ");
        
	}
}
