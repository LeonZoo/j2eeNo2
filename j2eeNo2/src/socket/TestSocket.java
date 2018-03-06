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
		//获取本机IP地址
		InetAddress host = InetAddress.getLocalHost();
		String ip= host.getHostAddress();
		System.out.println("本机ip地址："+ip);
		
		//使用java 执行ping命令
		Process p1 = Runtime.getRuntime().exec("ping " + "192.168.233.1");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br1.readLine()) != null) {
            if (line.length() != 0)
                sb.append(line + "\r\n");
        }
        System.out.println("本次指令返回的消息是：");
        System.out.println(sb.toString());
        
        //判断本网段有多少可用的ip地址
        List<String> ipList=new ArrayList<String>();
        for (int ipEnd = 1; ipEnd <= 255; ipEnd++) {
        	Process p2 = Runtime.getRuntime().exec("ping " + "192.168.233."+ipEnd);
        	BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        	if (br2!=null) {
        		System.out.println("已经完成："+ipEnd+"个ip测试");
			}
        	String message = null;
        	int i=1;
        	while ((message=br2.readLine())!=null) {
				if (i==9 && message.contains("(0% 丢失)")) {
					ipList.add("192.168.2."+ipEnd);
				}
				i++;
			}
        	br2=null;
		}
        
        System.out.println("如下ip地址可以连接");
        for (String ipAddress : ipList) {
			System.out.println(ipAddress);
		}
        System.out.println("总共有："+ipList.size()+"个地址");
        
	}
}
