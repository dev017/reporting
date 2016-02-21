<%@page import="Bo.Utilisateur"%>
<%@page import="Dao.DaoUtilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
DaoUtilisateur daou=new DaoUtilisateur();
String login=request.getParameter("txt_login");
String password=request.getParameter("txt_password");
String nom=request.getParameter("txt_nom");
String prenom=request.getParameter("txt_prenom");

Utilisateur u=new Utilisateur(login,password,nom,prenom);
//daou.updateUtilisateur(u);
%>
<jsp:forward page="pyramide_age.jsp"></jsp:forward>
</body>
</html>