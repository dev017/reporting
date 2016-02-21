<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
if(session.getAttribute("nom_prenom")!=null){    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Reporting | Modifier utilisateur</title>
 <link rel='stylesheet' type='text/css' href='css/styles1.css' />
<script type="text/javascript" src="js/mootools.js"></script>
	   <style type="text/css">
<!--
.style2 {font-size: 13px}
-->
   </style>
   
   
   <script>
function formm(){
password=document.getElementById("txt_password").value;
login=document.getElementById("txt_login").value;
nom=document.getElementById("txt_nom").value;
prenom=document.getElementById("txt_prenom").value;

var error=0;
if(password==""){
document.getElementById("txt_password").style.border='solid 1px red';
error=error+1;
}else document.getElementById("txt_password").style.border='solid 1px #000000';


if(login==""){
	document.getElementById("txt_login").style.border='solid 1px red';
	error=error+1;
	}else document.getElementById("txt_login").style.border='';

if(nom==""){
	document.getElementById("txt_nom").style.border='solid 1px red';
	error=error+1;
	}else document.getElementById("txt_nom").style.border='';

if(prenom==""){
	document.getElementById("txt_prenom").style.border='solid 1px red';
	error=error+1;
	}else document.getElementById("txt_prenom").style.border='';


if(error!=0)
	return false;
}
</script>
</head>

<body style="padding-top: 0px">
<table width="100%" border="0" style="padding-top: 0px">
  <tr>
    <td height="97"> <%@ include file="menu.html" %> </td>
  </tr>
  <tr>
    <td><p>&nbsp;</p>
    <p>&nbsp;</p>

   
   
    <form id="form1" name="form1" method="post" action="S3" class="long" >
     <center>
       <table width="362"  style="border:1px solid black;">
         <tr>
           <td height="31" colspan="5" style="text-align:center; font-family:Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#000080; font-weight:bold ">Ajouter utilisateur </td>
         </tr>
         <tr>
           <td>&nbsp;</td>
           <td colspan="2" id="label">Login</td>
           <td colspan="2" id="label"><label>
             <input name="txt_login" type="text" id="txt_login" />
           </label></td>
         </tr>
         <tr>
           <td height="29">&nbsp;</td>
           <td colspan="2" id="label">Mot de passe </td>
           <td colspan="2" id="label"><input name="txt_password" type="text" id="txt_password" /></td>
         </tr>
         <tr>
           <td height="30">&nbsp;</td>
           <td colspan="2" id="label">Nom</td>
           <td colspan="2"  id="label"><input name="txt_nom" type="text" id="txt_nom" /></td>
         </tr>
         <tr>
           <td height="28">&nbsp;</td>
           <td colspan="2" id="label">Pr&eacute;nom</td>
           <td colspan="2" id="label"><input name="txt_prenom" type="text" id="txt_prenom" /></td>
         </tr>
         <tr>
           <td width="35" height="33">&nbsp;</td>
           <td width="36">&nbsp;</td>
           <td width="73"><input type="submit" name="Submit2" value="Modifier" class="button" style="width:80px" onclick="return formm();"/></td>
           <td width="95"><label>
             <input type="submit" name="Submit" value="Annuler" class="button" style="width: 80px"/>
           </label></td>
           <td width="89">&nbsp;</td>
         </tr>
       </table>
     </center>
      </form>
   
   
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
<%}else{ %><jsp:forward page="login.jsp"></jsp:forward><%} %>
</html>
