<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
if(session.getAttribute("nom_prenom")!=null){    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Reporting | Pyramide des ages par services</title>



<link href="calendar/calendar-brown.css" type=text/css rel=stylesheet>
<SCRIPT src="calendar/calendar.js" type=text/javascript></SCRIPT>
<SCRIPT src="calendar/calendar-fr.js" type=text/javascript></SCRIPT>
<SCRIPT src="calendar/calendar-setup.js" type=text/javascript></SCRIPT>

  



   <link rel='stylesheet' type='text/css' href='css/styles1.css' />
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

    <form id="form1" name="form1" method="post" action="S2" class="long" >
     <center>
     
 <table width="394" align="center" style="border:1px solid black; text-align:center">
       
        <tr style="border:1px; text-align:center">
          <td height="28" colspan="3" style="font-family:Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#000080; font-weight:bold "><span class="style2">Zone recherche </span></td>
        </tr>
        
        
        <tr>
          <td width="39" height="28" id="label">&nbsp;</td>
          <td width="121" id="label" style="text-align:left">Date d&eacute;but</td>
          <td width="218" style="border:0px" id="label">
          
          

           <input name="txtdate" type="text" id="txtdate" size="10" width="30px"/> 
           <img style="cursor:pointer" src="calendar/calendar.gif" name="imgda" id="imgda" />
           
          
          
          
          
          </td>
          
        </tr>
             
        <tr>
          <td height="30" id="label"  style="border:0px">&nbsp;</td>
          <td height="30" id="label"  style="border:0px; text-align:left">Date Fin </td>
          <td  style="border:0px" id="label">
          
              
          <input name="txtdateD" type="text" id="txtdateD" size="10" width="30px"/> 
		  <img style="cursor:pointer" src="calendar/calendar.gif" name="imgda2" id="imgda2" /> 
			  
			  
   </td>
   
              <script type=text/javascript>
	Calendar.setup(
		{
			inputField : "txtdate", // ID of the input field
			ifFormat : "%d-%m-%Y", // the date format
			button : "imgda" // ID of the button
		}
	);
 </script>
	        
	        <script type=text/javascript>
	Calendar.setup(
		{
			inputField : "txtdateD", // ID of the input field
			ifFormat : "%d-%m-%Y", // the date format
			button : "imgda2" // ID of the button
		}
	);
 </script>
   
        </tr>
        <tr>
          <td height="31"  style="border:0px;">&nbsp;</td>
          <td height="31"  style="border:0px;">&nbsp;</td>
          <td height="31"  style="border:0px;"><input type="submit" name="rechercher_pyramide_age" value="Entrer"  id="button" style="width:80px;text-align:center"/></td>
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
