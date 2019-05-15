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
		        
		       
		     
		     <li><a href="useruser.jsp">back</a></li>
		        
		     
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
	
 <%stateservice rs5=new stateservice();
	   ArrayList<statemod>arr=rs5.selectAllRegistration();
	   %>
	
	
<%skservice rs2=new skservice();
	   ArrayList<skillmod>arr3=rs2.selectAllRegistration();
	   %>
<%qualiservice rs3=new qualiservice();
	   ArrayList<qualimod>arr4=rs3.selectAllRegistration();
	   %>
<%dservice rs4=new dservice();
	   ArrayList<dismod>arr5=rs4.selectAllRegistration();
	   %>
<div class="banner">
	<div class="container">
		<div id="search_wrapper">
		 <div id="search_form" class="clearfix">
		<%
int Id=Integer.parseInt(request.getParameter("id"));
System.out.println("jsp test"+Id);
userservice rs=new userservice();
usermod rm=rs.selectByid(Id);
%>
	<form method="post"action="userservlet"enctype="multipart/form-data">
<table width="600"border="1">	    	
<tr>
<td colspan="2"><div align="center"><strong>EDIT </strong></div></td>
</tr>
<tr>
<td width="236">Name</td>
<td width="348"><label><input type="text" name="Name"id="textfield1"value="<%=rm.getName()%>"/></label></td>
</tr>
<tr>
<td>Address</td>
<td align="center">
<label><textarea name="Address"id="textarea"cols="45"rows="5"><%=rm.getAdd()%></textarea></label></td>
<tr>

<tr>
<td width="236">state</td>
<td>
  <select path="state" name="state" id="state" class="form-control input-sm">
                        <option selected="selected" value="<%=rm.getState()%>"><%=rm.getState() %></option>
                        <%for(statemod sm:arr){%>
                        <option value="<%=sm.getSid()%>"><%=sm.getState() %></option>
                    
                   <%} %>
                   </select>
                    </td>
</tr>
<tr>
<td width="236">distict</td>
<td>
  <select path="state" name="dist" id="state" class="form-control input-sm">
                        <option selected="selected" value="<%=rm.getDist() %>"><%=rm.getDist() %></option>
                        <%for(dismod sm:arr5){%>
                        <option value="<%=sm.getDisid()%>"><%=sm.getDistname() %></option>
                    
                   <%} %>
                   </select>
                    </td>
</tr>
<td>Gender</td>
<%if(rm.getGen().equals("male")){ %>
<td align="center"><label>
<input type="radio"name="Gender"id="radio"value="male"checked="checked"/>Male
<input type="radio"name="Gender"id="radio2"value="Female"/>Female
</label></td>
<%}else{ %>
<td align="center"><label>
<input type="radio"name="Gender"id="radio"value="male"/>Male
<input type="radio"name="Gender"id="radio2"value="Female"checked="checked"/>Female

</label></td></tr>

<%} %>
<tr>
<td>dob</td>
<td><label>
<input type="date"name="date"id="textfield5"value="<%=rm.getDob()%>"tabindex="5"/>
</label></td>
</tr>
<tr>
<td>age</td>
<td><label>
<input type="text"name="age"id="textfield5"value="<%=rm.getAge()%>"tabindex="5"/>
</label></td>
</tr>
<tr>
<td>Phone</td>
<td><label>
<input type="text"name="ph"id="textfield5"value="<%=rm.getPh()%>"tabindex="5"/>
</label></td>
</tr>

<tr>
<td width="236">qualification</td>
<td>
  <select path="state" name="qli" id="state" class="form-control input-sm">
                        <option selected="selected" value="<%=rm.getQl()%>"><%=rm.getQl() %></option>
                        <%for(qualimod sm:arr4){%>
                        <option value="<%=sm.getQualificationid()%>"><%=sm.getQualification() %></option>
                    
                   <%} %>
                   </select>
                    </td>
</tr>

<tr>
<td>year of pass</td>
<td><label>
<input type="text"name="yop"id="textfield5"value="<%=rm.getYrp()%>"tabindex="5"/>
</label></td>
</tr>
<td>experience</td>
<%if(rm.getWorkexp().equals("fresher")){ %>
<td align="center"><label>
<input type="radio"name="exp"id="radio"value="fresher"checked="checked"/>fresher
<input type="radio"name="exp"id="radio2"value="exprerienced"/>experienced
</label></td>
<%}else{ %>
<td align="center"><label>
<input type="radio"name="exp"id="radio"value="fresher"/>fresher
<input type="radio"name="exp"id="radio2"value="experienced"checked="checked"/>experienced

</label></td></tr>

<%} %>
<tr>
<td>mail</td>
<td><label>
<input type="text"name="mail"id="textfield5"value="<%=rm.getMail()%>"tabindex="5"/>
</label></td>
</tr>

<td><div align="center">
<label><input type="hidden"name="id"value="<%=rm.getId()%>"/>
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