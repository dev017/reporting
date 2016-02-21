<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<% 
session.removeAttribute("nom_prenom");
%>
<<jsp:forward page="login.jsp"></jsp:forward>