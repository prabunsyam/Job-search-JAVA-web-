<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="services.appservice"%>
<%@page import="model.appmod"%>
<%@page import="model.loginmod"%>
<%@page import="model.vacmod"%>
<%@page import="services.vacservice"%>
<%@page import="model.skillmod"%>
<%@page import="services.skservice"%>
<%@page import="model.qualimod"%>
<%@page import="services.qualiservice"%>
<%@page import="model.statemod"%>
<%@page import="services.stateservice"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seeking an Job Portal Category Flat Bootstrap Responsive Website Template | Register :: w3layouts</title>
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
		        
		     
		        <li><a href="admin.jsp">back</a></li>
		        
	        </ul>
	    </div>
	    <div class="clearfix"> </div>
	  </div>
	    <!--/.navbar-collapse-->
	</nav>
	
	 <%qualiservice ar=new qualiservice();
	   ArrayList<qualimod>arr2=ar.selectAllRegistration();
	   %>	
	   <%skservice rs2=new skservice();
	   ArrayList<skillmod>arr3=rs2.selectAllRegistration();
	   %>
	   <%loginmod lm=(loginmod)session.getAttribute("username"); %>
	   
<div class="container">
    <div class="single">  
	   <div class="form-container">
	  
        <h2>applicationview</h2>
        <form method="post"action="applview.jsp">
           <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="qli">qualification</label>
                <div class="col-md-5">
                    <select path="qli" name="qli" id="qli" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(qualimod sm:arr2){%>
                        <option value="<%=sm.getQualificationid()%>"><%=sm.getQualification()%></option>
                   <%} %>
                    </select>
                </div>
            </div></div>
             <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="sk">skill</label>
                <div class="col-md-5">
                    <select path="sk" name="sk" id="sk" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(skillmod sm:arr3){%>
                        <option value="<%=sm.getSkillid()%>"><%=sm.getSkill()%></option>
                   <%} %>
                    </select>
                </div>
            </div>
         </div>
        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" name="post"id="button"value="search" class="btn btn-primary btn-sm">
            </div>        </div>
    </form>
    </div>
    
 </div>
 <%
 String qul=request.getParameter("qli");
 String sk=request.getParameter("sk");
 System.out.println(qul+sk);
 if(qul!=null)
 {
	 int ql=Integer.parseInt(request.getParameter("qli"));
	 int skl=Integer.parseInt(request.getParameter("sk"));
	//int cid=Integer.parseInt(request.getParameter(""))
			System.out.println(ql+skl);
	 vacservice vs=new vacservice();
	 ArrayList<vacmod>arr6=vs.searchapp(ql, skl, lm.getId());
 appservice as=new appservice();
 %>
<tr>
<table width="700" align="center" border="1">
<tr>
<td bgcolor="#6699ff"><div align="center"><strong>ID</strong></div></td>
<td bgcolor="#6699ff"><div align="center"><strong>name</strong></div></td>
<td bgcolor="#6699ff"><div align="center"><strong>post</strong></div></td>
<td bgcolor="#6699ff"><div align="center"><strong>skill</strong></div></td>
<td bgcolor="#6699ff"><div align="center"><strong>qualification</strong></div></td>
<td bgcolor="#6699ff"><div align="center"><strong>details</strong></div></td>
</tr>
<%int i=0;
for(vacmod rm:arr6)
{
	i=i+1;
	int vid=rm.getVacid();
	ArrayList<appmod> arr8=as.searchapp(rm.getVacid());
	for(appmod am:arr8) 
{
	System.out.println("vacancy"+i);
	
	%>
	<tr>
<td><%out.println(i);%></td>
<td><%=am.getName()%></td>
<td><%=rm.getPost()%></td>
<td><%=rm.getSkill()%></td>
<td><%=rm.getQualification()%></td>

<%
int count=as.countappl(am.getUid(),lm.getId(), vid);
int rem=1-count;

if(count==1)
{
%>
<td>
<font color="red"><%out.println("alredy applied"); %></font>
</td>
<%}
else{
%>
<td align="center">
<a href="moredet.jsp?pid=<%=am.getUid() %>&vid=<%=am.getVid()%>"><font size"2px">More details</font></a>
</td>
</tr>
<%}
}
%>
</table>
</tr>

<%} }%>

<div class="footer">
	<div class="container">
		<div class="col-md-3 grid_3">
			<h4>Navigate</h4>
			<ul class="f_list f_list1">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="login.jsp">Sign In</a></li>
				<li><a href="login.html">Join Now</a></li>
				<li><a href="about.html">About</a></li>
			</ul>
			<ul class="f_list">
				<li><a href="features.html">Features</a></li>
				<li><a href="terms.html">Terms of use</a></li>
				<li><a href="contact.html">Contact Us</a></li>
				<li><a href="jobs.html">Post a Job</a></li>
			</ul>
			<div class="clearfix"> </div>
		</div>
		<div class="col-md-3 grid_3">
			<h4>Twitter Widget</h4>
			<div class="footer-list">
			  <ul>
				<li><i class="fa fa-twitter tw1"> </i><p><span class="yellow"><a href="#">@@@@@@@@</a></span> connect me on twitter</p></li>
				
			  </ul>
			</div>
		</div>
		<div class="col-md-3 grid_3">
			
		</div>
		<div class="col-md-3 grid_3">
			<h4>Sign up for our newsletter</h4>
			<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam.</p>
			<form>
				<input type="text" class="form-control" placeholder="Enter your email">
				<button type="button" class="btn red">Subscribe now!</button>
		    </form>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<div class="footer_bottom">	
 
  	<div class="col-sm-6 footer_text">
    
  	</div>
  	<div class="clearfix"> </div>
	<div class="copy">
		<p>Copyright © 2015 Seeking . All Rights Reserved . Design by <a href="http://w3layouts.com/" target="_blank">Prabunsyam</a> </p>
	</div>
  </div>
</div>
</body>
</html>