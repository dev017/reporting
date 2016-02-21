<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java"
	import="java.sql.*,Dao.*,Bo.*" errorPage=""%>
<%
	if (session.getAttribute("nom_prenom") != null) {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Liste des utilisateurs</title>

<link href="calendar/calendar-brown.css" type=text/css rel=stylesheet>
<SCRIPT src="calendar/calendar.js" type=text/javascript></SCRIPT>
<SCRIPT src="calendar/calendar-fr.js" type=text/javascript></SCRIPT>
<SCRIPT src="calendar/calendar-setup.js" type=text/javascript></SCRIPT>

<link rel='stylesheet' type='text/css' href='css/styles1.css' />
<style type="text/css">
<!--
.style2 {
	font-size: 13px
}
-->
</style>
</head>

<body style="padding-top: 0px">
	<table width="100%" border="0">
		<tr>
			<td height="97"><%@ include file="menu.html"%>
			</td>
		</tr>
		<tr>
			<td><p>&nbsp;</p>
				<p>&nbsp;</p>

					<center>


						<form id="form1" name="form1" method="get" action="S8">
							<table width="897" border="1">
								<tr>
									<td width="151">Nom</td>
									<td width="165">Pr&eacute;nom</td>
									<td width="207">Login</td>
									<td width="306">Password</td>
									<td colspan="2">&nbsp;</td>
								</tr>

								<%
									DaoUtilisateur dao = new DaoUtilisateur();
										for (Utilisateur u : dao.getAllUsers()) {
								%>

								<tr>
									<td><%=u.getNom()%></td>
									<td><%=u.getPrenom()%></td>
									<td><%=u.getLogin()%>;</td>
									<td><%=u.getPassword()%></td>
									<a href="S8?method=update&id=<%=u.getId()%>"><td width="14">M</a>
									</td>
									<td width="14"><a href="S8?method=delete&id=<%=u.getId()%>">S</a></td>
								</tr>

								<%
									}
								%>
							</table>
						</form>


					</center>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p></td>
		</tr>
		<tr>
			<td><%@ include file="footer.html"%></td>
		</tr>
	</table>

</body>
<%
	} else {
%><jsp:forward page="login.jsp"></jsp:forward>
<%
	}
%>
</html>
