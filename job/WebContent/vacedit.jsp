<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.loginmod"%>
<%@page import="model.vacmod"%>
<%@page import="services.vacservice"%>
<%@page import="model.postmod"%>
<%@page import="services.postservices"%>
<%@page import="model.statemod"%>
<%@page import="services.stateservice"%>
<%@page import="model.dismod"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.dservice"%>
<%@page import="services.comservice"%>
<%@page import="model.commod"%>
<%@page import="services.skservice"%>
<%@page import="model.skillmod"%>
<%@page import="services.qualiservice"%>
<%@page import="model.qualimod"%>
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
		        
		      <li><a href="admin.jsp">Administrator</a></li>
		    
	        </ul>
	    </div>
	    <div class="clearfix"> </div>
	  </div>
	    <!--/.navbar-collapse-->
	</nav>
	<%
int Id=Integer.parseInt(request.getParameter("id"));
System.out.println("jsp test"+Id);
vacservice rss=new vacservice();
vacmod rm=rss.selectByid(Id);
%>

 <%loginmod lm=(loginmod)session.getAttribute("username");
 vacservice rs5=new vacservice();
	   ArrayList<vacmod>arr=rs5.selectAllRegistration(lm.getId());
	   %>
	<%comservice rs=new comservice();
	   ArrayList<commod>arr1=rs.selectAllRegistration();
	   %>
	<%postservices rs1=new postservices();
	   ArrayList<postmod>arr2=rs1.selectAllRegistration();
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
		<table width="980" border="0" align="center">

<tr>

<form method="post"action="vacservlet">
<table width="600"border="1">
<tr>
<td colspan="2"><div align="center"><strong>EDIT vacancy</strong></div></td>
</tr>


<tr>
<td width="236">company</td>
<td>
  <select path="state" name="com" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(commod sm:arr1){%>
                        <option value="<%=sm.getCompanyid()%>"><%=sm.getCname() %></option>
                    
                   <%} %>
                   </select>
                    </td>
</tr>
<tr>
<td width="236">post</td>
<td>
  <select path="state" name="po" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(postmod sm:arr2){%>
                        <option value="<%=sm.getPostid()%>"><%=sm.getPost() %></option>
                    
                   <%} %>
                   </select>
                    </td>
</tr>
<tr>
 <td width="236">vacancynumber</td>
<td width="348"><label><input type="text" name="vacc"id="vacc"value="<%=rm.getVaccno()%>"/></label></td>
</tr> 
<tr>
<td width="236">skill</td>
<td>
  <select path="state" name="sk" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(skillmod sm:arr3){%>
                        <option value="<%=sm.getSkillid()%>"><%=sm.getSkill() %></option>
                    
                   <%} %>
                   </select>
                    </td>
</tr>
<tr>
<td width="236">qualification</td>
<td>
  <select path="state" name="ql" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(qualimod sm:arr4){%>
                        <option value="<%=sm.getQualificationid()%>"><%=sm.getQualification()%></option>
                    
                   <%} %>
                   </select>
                    </td>
</tr>
<tr>
<td width="236">district</td>
<td>
  <select path="state" name="dst" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(dismod sm:arr5){%>
                        <option value="<%=sm.getDisid()%>"><%=sm.getDistname()%></option>
                    
                   <%} %>
                   </select>
                    </td>
</tr>
<tr>
 <td width="236">percentage</td>
<td width="348">
<label><input type="text" name="per"id="per"value="<%=rm.getPercentage()%>"/></label></td>
</tr> 
<td><div align="center">
<label><input type="hidden"name="id"value="<%=rm.getVacid() %>"/>
<input type="submit"name="operation"id="button1"value="Update"tabindex="8"/>
</tr>

</label>

</div>

</td>

</table>
</form>

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