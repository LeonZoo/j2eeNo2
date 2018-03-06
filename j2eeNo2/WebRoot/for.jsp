<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	List<String> words=new ArrayList<String>();
	words.add("today");
	words.add("is");
	words.add("a");
	words.add("great");
	words.add("day");
 %>

 <table width="200px" align="center" border="1" cellspacing="0">
 <%for(String word : words) {%>
 <tr>
 	<td><%=word %></td>
 </tr>
 <%} %>
 </table>