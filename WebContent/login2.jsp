<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
	<head>
	<title>Authentification</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	
	<script>
	function valider(){
		frm=document.formvalidation
		if (frm.txtlogin.value=="" || frm.txtpassword.value=="") return false
		frm.submit()
	}
	</script>
	
	<style type="text/css">

		#logina{
			width:250px;
			height:310px;
			/*background: url(images/slogo.jpg) 0 75px;*/
			background-repeat:no-repeat;
			padding:10px;
			border: 1px solid #663300;
		}
		#chapms{
			font-family:Verdana, Arial, Helvetica, sans-serif;
			font-size:10px;
			font-weight:bold;
			color:#666666;
			text-align:right;
			padding-right:3px;
		}
		.button {
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 10px;
			font-weight: bold;
			color: #FFFFFF;
			background-color: #663300;
			height: 20px;
			cursor:pointer;
			width:60px;
			border: 1px solid #663300;
			margin-right:3px;
		}
		.zonetexte {
			margin:2px;
			width:90%;
			border: 1px solid #9DACBF;
			font-family:Verdana, Arial, Helvetica, sans-serif;
			font-size:10px;
		}

    .Style1 {font-size: 36px}
    </style>
	</head>
	
	<body onLoad="document.formvalidation.txtlogin.focus()">
	<br>

	<form method="post">
	  <p align="center" class="Style1">&nbsp;</p>
	  <table width="260px"  border="0" cellspacing="0" cellpadding="0" align="center">
	  <tr>
		<td align="right" style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#663300; font-weight:bold ">Authentification</td>
	  </tr>
	  <tr>
		<td id="logina" valign="bottom" align="center">
		
			<table width="209"  border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="11" colspan="2" id="chapms"></td>
				</tr>
				<tr>
				  <td width="40%" height="11" id="chapms">Login</td>
			      <td width="60%"><input type="text" name="txtlogin" id="txtlogin" class="zonetexte"></td>
			  </tr>
				<tr>
					<td height="26" id="chapms">Mot de passe </td>
					<td>
						<input type="password" name="txtpassword" id="txtpassword" class="zonetexte">					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right">
					<input type="submit" name="cmdvalider" id="cmdvalider" value=" Valider " class="button">					</td>
				</tr>
		  </table>
	
		
		</td>
	  </tr>
	</table>
	<input type="hidden" name="txtactions" id="txtactions" value="pass">
	</form>
	</body>
	</html>