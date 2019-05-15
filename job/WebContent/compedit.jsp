<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="services.stateservice"%>
<%@page import="model.statemod"%>
<%@page import="model.qualimod"%>
<%@page import="model.dismod"%>
<%@page import="services.dservice"%>
<%@page import="services.qualiservice"%>
<%@page import="model.skillmod"%>
<%@page import="services.skservice"%>
<%@page import="model.postmod"%>
<%@page import="services.postservices"%>
<%@page import="model.commod"%>
<%@page import="services.comservice"%>
<%@page import="model.vacmod"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.vacservice"%>
<%@page import="model.loginmod"%>
<%@page import="model.usermod"%>
<%@page import="services.userservice"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>edit user</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Seeking Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap-3.1.1.min.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Roboto:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!----font-Awesome----->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!----font-Awesome----->
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
	<div class="container">
	    <div class="navbar-header">
	        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	        </button>
	        <a class="navbar-brand" href="index.jsp"><img src="images/logo.png" alt=""/></a>
	    </div>
	    <!--/.navbar-header-->
	    
	     <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1" style="height: 1px;"> 
	        <ul class="nav navbar-nav">
		        
		        
		       
		     <li><a href="comcom.jsp">back</a></li>
		     
		        
		     
	        </ul>
	    </div>
	    <div class="clearfix"> </div>
	  </div>
	    <!--/.navbar-collapse-->
	</nav>
	<%
	userservice rs8=new userservice();
	   ArrayList<usermod>arr1=rs8.selectAllRegistration();
	   %>
	
 
	
	



<div class="banner">
	<div class="container">
		<div id="search_wrapper">
		 <div id="search_form" class="clearfix">
		<%
int Id=Integer.parseInt(request.getParameter("id"));
System.out.println("jsp test"+Id);
comservice rs=new comservice();
commod rm=rs.selectByid(Id);
%>
	<form method="post"action="comservlet">
<table width="600"border="1">	    	
<tr>
<td colspan="2"><div align="center"><strong>EDIT </strong></div></td>
</tr>
<tr>
<td width="236">Name</td>
<td width="348"><label><input type="text" name="Name"id="textfield1"value="<%=rm.getCname()%>"/></label></td>
</tr>
<tr>
<td>Address</td>
<td align="center">
<label><textarea name="Address"id="textarea"cols="45"rows="5"><%=rm.getCaddress()%></textarea></label></td>
</tr>
<tr>
<td>WEB</td>
<td align="center">
<label><textarea name="web"id="textarea"cols="45"rows="5"><%=rm.getCweb()%></textarea></label></td>
</tr>
<tr>
<td>discription</td>
<td align="center">
<label><textarea name="disc"id="textarea"cols="45"rows="5"><%=rm.getDiscription()%></textarea></label></td>
</tr>
<tr>
<td>contact</td>
<td align="center">
<label><textarea name="cont"id="textarea"cols="45"rows="5"><%=rm.getContact()%></textarea></label></td>
</tr>
<tr>
<td>mail id</td>
<td align="center">
<label><textarea name="mail"id="textarea"cols="45"rows="5"><%=rm.getMailid()%></textarea></label></td>
</tr>





<td><div align="center">
<label><input type="hidden"name="id"value="<%=rm.getCompanyid()%>"/>
<input type="submit"name="operation"id="button1"value="Update"tabindex="8"/>
</label>
</div></td>
</tr>
</table>
</form>
			  </div>
			<div class="clearfix"> </div>
		   </div>
	   </div>
	   <div class="clearfix"> </div>
	 </div>
</div>
<div class="footer">
	<div class="container">
		<div class="col-md-3 grid_3">
			<h4>Navigate</h4>
			<ul class="f_list f_list1">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="login.jsp">Sign In</a></li>
<li><a href="contact.jsp">Contact Us</a></li>
<li><a href="feedback.jsp">Feedback</a></li>
			</ul>
			<ul class="f_list">
				<
				
				
			</ul>
			<div class="clearfix"> </div>
		</div>
		<div class="col-md-3 grid_3">
			<h4>Twitter Widget</h4>
			<div class="footer-list">
			  <ul>
				<li><i class="fa fa-twitter tw1"> </i><p><span class="yellow"><a href="#">@@@@@@@@@</a></span> connect me on twitter</p></li>
			
			  </ul>
			</div>
		</div>
		<div class="col-md-3 grid_3">
			
		</div>
		<div class="col-md-3 grid_3">
			<h4>Sign up for our newsletter</h4>
			<!--<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam.</p>-->
			<form>
				<input type="text" class="form-control" placeholder="Enter your email">
				<button type="button" class="btn red">Subscribe now!</button>
		    </form>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<div class="footer_bottom">	
 
  	<div class="clearfix"> </div>
	<div class="copy">
		<p>Copyright © 2015 Seeking . All Rights Reserved . Design by <a href="prabunsyamsivanandan@gmail.com" target="_blank">Prabun syam</a> </p>
	</div>
  </div>
</div>
</body>
</html>