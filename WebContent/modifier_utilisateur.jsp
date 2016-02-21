<%@page import="Dao.DaoUtilisateur"%>
<%@page import="Bo.Utilisateur"%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@page import="java.util.*"%>
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
</head>

<body style="padding-top: 0px">
<table width="100%" border="0" >
  <tr>
    <td height="97"> <%@ include file="menu.html" %> </td>
  </tr>
  <tr>
    <td><p>&nbsp;</p>
    <p>&nbsp;</p>

    <form id="form1" name="form1" method="post" action="S7" class="long" >
     <center>
     
       <table width="438"  style="border:1px solid black;">
       
           <%
           Vector<Utilisateur>vi=new Vector<Utilisateur>();
           vi.addAll(DaoUtilisateur.getDaoUtilisateur().getUtilisateurByID(String.valueOf(session.getAttribute("nom_prenom"))));
           for(Utilisateur uti:vi){

                String nom=uti.getNom() ;
                String prenom=uti.getPrenom() ;
                String login=uti.getLogin();

                 
                   %>
                   
                   
         <tr>
           <td height="31" colspan="5" style="text-align:center; font-family:Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#000080; font-weight:bold ">Modifier utilisateur </td>
         </tr>
         <tr>
           <td>&nbsp;</td>
           <td colspan="2" id="label">Login</td>
           <td colspan="2" id="label"><label>
             <input name="txt_login" type="text" id="txt_login" value="<%= login %>" />
           </label></td>
         </tr>
         <tr>
           <td height="29" rowspan="2">&nbsp;</td>
           <td height="31" colspan="2" id="label">Mot de passe </td>
           <td colspan="2" id="label"><input name="txt_password" type="text" id="txt_password" /></td>
         </tr>
         <tr>
           <td height="28" colspan="2" id="label">Confirmer Mot de passe </td>
           <td colspan="2" id="label"><input name="txt_password2" type="text" id="txt_password2" /></td>
         </tr>
         <tr>
           <td height="30">&nbsp;</td>
           <td colspan="2" id="label">Nom</td>
           <td colspan="2"  id="label"><input name="txt_nom" type="text" id="txt_nom" value="<%= nom %>" /></td>
         </tr>
         <tr>
           <td height="28">&nbsp;</td>
           <td colspan="2" id="label">Pr&eacute;nom</td>
           <td colspan="2" id="label"><input name="txt_prenom" type="text" id="txt_prenom" value="<%= prenom %>" /></td>
         </tr>
         <tr>
           <td width="36" height="33">&nbsp;</td>
           <td width="42">&nbsp;</td>
           <td width="114"><input type="submit" name="Submit2" value="Modifier" class="button" style="width:80px"/></td>
           <td width="80"><label>
             <input type="submit" name="Submit" value="Annuler" class="button" style="width: 80px"/>
           </label></td>
           <td width="98">&nbsp;</td>
         </tr>
         
         <% }  %>
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
