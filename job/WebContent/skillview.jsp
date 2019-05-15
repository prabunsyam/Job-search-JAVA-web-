<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="services.skservice"%>
<%@page import="model.skillmod"%>
<%@page import="model.dismod"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.dservice"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Success a free Job Portal</title>
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
		        <li class="dropdown">
		          <!--   <a href="#" class="dropdown-toggle" data-toggle="dropdown">view<b class="caret"></b></a>
		            <ul class="dropdown-menu">
			            <li><a href="location.html">user</a></li>
			            <li><a href="location.html">companies</a></li>
			            <li><a href="location.html">job post</a></li>
			            <li><a href="location.html">feedbacks</a></li>
			          
		            </ul>
		        </li>
		        
		        <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Add<b class="caret"></b></a>
		            <ul class="dropdown-menu">
			            <li><a href="district.jsp">district</a></li>
			            <li><a href="state.jsp">state</a></li>
			            <li><a href="qualification.jsp">qualification</a></li>
			           
			          
		            </ul>-->
		      <li><a href="admin.jsp">Administrator</a></li>
		    
	        </ul>
	    </div>
	    <div class="clearfix"> </div>
	  </div>
	    <!--/.navbar-collapse-->
	</nav>
	  
	   <%skservice rr=new skservice();
	   ArrayList<skillmod>arr1=rr.selectAllRegistration();
	   %>
<div class="banner">
	<div class="container">
		<div id="search_wrapper">
		 <div id="search_form" class="clearfix">
		<table width="980" border="0" align="center">

<tr>
<table width="700" align="center" border="1">
<tr>
<td bgcolor="#6699ff"><div align="center"><strong>ID</strong></div></td>
<td bgcolor="#6699ff"><div align="center"><strong>skill</strong></div></td>
<td bgcolor="#6699ff"><div align="center"><strong>edit</strong></div></td>

</tr>
</tr>
<%
for(skillmod rm:arr1)
{
%>
<tr>
<td><%=rm.getSkillid()%></td>
<td><%=rm.getSkill()%></td>
<td><a href="skilledit.jsp?id=<%=rm.getSkillid()%>">Edit</a></td>


</tr>
<%} %>
</table>
</tr>
</td>
</tr> 
</table>
<tr>
</td>
</tr> 
</table>
		
        </div>
   </div> 
</div>	
<br>
<br>

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