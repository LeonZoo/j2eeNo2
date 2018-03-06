<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	pageContext.setAttribute("name","page");
	request.setAttribute("name", "request");
	session.setAttribute("name", "session");
	application.setAttribute("name", "application");
 %>
 
 <%=pageContext.getAttribute("name") %><br>
 <%=request.getAttribute("name") %><br>
 <%=session.getAttribute("name") %><br>
 <%=request.getServletContext() %><br>
 <br>
 <a href="getContext.jsp">获取getContext.jsp页面</a>
 <%--<jsp:forward page="getContext.jsp"/> --%>
 <%--response.sendRedirect("getContext.jsp"); --%>
 