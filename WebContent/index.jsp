<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
if(session.getAttribute("nom_prenom")!=null){    
	System.out.println("######## dans IF");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
</head>

<body>
<table width="100%" border="1">
  <tr>
    <td height="97"> <%@ include file="menu.html" %> </td>
  </tr>
  <tr>
    <td><p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p></td>
  </tr>
  <tr>
    <td> <%@ include file="footer.html" %> </td>
  </tr>
</table>
</body>
<%}else{  	System.out.println("######## dans ELSE");
%><jsp:forward page="login.jsp"></jsp:forward><%} %>
</html>
