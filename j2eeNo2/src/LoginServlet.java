import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
//    public LoginServlet() {
//        System.out.println("LoginServlet 构造方法 被调用");
//    }
// 
//    public void init(ServletConfig config) {
//        System.out.println("init(ServletConfig)");
//    }
//    
//    public void destroy() {
//        System.out.println("destroy()");
//    }
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
        System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + req.getRequestURL());
        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + req.getRequestURI());
        System.out.println("请求行中的参数部分: " + req.getQueryString());
        System.out.println("浏览器所处于的客户机的IP地址: " + req.getRemoteAddr());
        System.out.println("浏览器所处于的客户机的主机名: " + req.getRemoteHost());
        System.out.println("浏览器所处于的客户机使用的网络端口: " + req.getRemotePort());
        System.out.println("服务器的IP地址: " + req.getLocalAddr());
        System.out.println("服务器的主机名: " + req.getLocalName());
        System.out.println("得到客户机请求方式: " + req.getMethod());
		
//        if ("admin".equals(name) && "123".equals(password))
//            req.getRequestDispatcher("success.html").forward(req, resp);
//        else
//			resp.sendRedirect("fail.html");
        
		String html=null;
		
		if ("admin".equals(name) && "123".equals(password))
			html = "<div style='color:green'>登录成功</div>";
		else
			html = "<div style='color:red'>登录失败</div>";
		
		PrintWriter pw=resp.getWriter();
		pw.println(html);
		System.out.println("name:"+name+" password:"+password);
	}
}
