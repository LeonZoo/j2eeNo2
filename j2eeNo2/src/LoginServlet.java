import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
//    public LoginServlet() {
//        System.out.println("LoginServlet ���췽�� ������");
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
		
        System.out.println("�������������ʱ������URL������Э�� ������ �˿�(�����): " + req.getRequestURL());
        System.out.println("����������������Դ�����֣�ȥ����Э���������: " + req.getRequestURI());
        System.out.println("�������еĲ�������: " + req.getQueryString());
        System.out.println("����������ڵĿͻ�����IP��ַ: " + req.getRemoteAddr());
        System.out.println("����������ڵĿͻ�����������: " + req.getRemoteHost());
        System.out.println("����������ڵĿͻ���ʹ�õ�����˿�: " + req.getRemotePort());
        System.out.println("��������IP��ַ: " + req.getLocalAddr());
        System.out.println("��������������: " + req.getLocalName());
        System.out.println("�õ��ͻ�������ʽ: " + req.getMethod());
		
//        if ("admin".equals(name) && "123".equals(password))
//            req.getRequestDispatcher("success.html").forward(req, resp);
//        else
//			resp.sendRedirect("fail.html");
        
		String html=null;
		
		if ("admin".equals(name) && "123".equals(password))
			html = "<div style='color:green'>��¼�ɹ�</div>";
		else
			html = "<div style='color:red'>��¼ʧ��</div>";
		
		PrintWriter pw=resp.getWriter();
		pw.println(html);
		System.out.println("name:"+name+" password:"+password);
	}
}
