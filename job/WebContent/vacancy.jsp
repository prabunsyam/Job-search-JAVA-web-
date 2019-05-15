<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.dismod"%>
<%@page import="services.dservice"%>
<%@page import="model.qualimod"%>
<%@page import="services.qualiservice"%>
<%@page import="model.skillmod"%>
<%@page import="services.skservice"%>
<%@page import="model.postmod"%>
<%@page import="services.postservices"%>
<%@page import="model.commod"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.comservice"%>
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
		       
		        <li><a href="comppof.jsp">back</a></li>
		        
	        </ul>
	    </div>
	    <div class="clearfix"> </div>
	  </div>
	    <!--/.navbar-collapse-->
	</nav>
<div class="banner_1">
	<div class="container">
		<div id="search_wrapper1">
		   <div id="search_form" class="clearfix">
		    <h1>Start your job search</h1>
		    <p>
			 <input type="text" class="text" placeholder=" " value="Enter Keyword(s)" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Keyword(s)';}">
			 <input type="text" class="text" placeholder=" " value="Location" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Location';}">
			 <label class="btn2 btn-2 btn2-1b"><input type="submit" value="Find Jobs"></label>
			</p>
           </div>
		</div>
   </div> 
</div>	
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
<div class="container">
    <div class="single">  
	   <div class="form-container">
        <h2>ADD A VACANCY</h2>
       <form method="post"action="vacservlet">
        
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">COMPANY</label>
                <div class="col-md-5">
                    <select path="state" name="com" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(commod sm:arr1){%>
                        <option value="<%=sm.getCompanyid()%>"><%=sm.getCname() %></option>
                        <%} %>
                          </select>
                </div>
            </div>
         </div>
       	 <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">post</label>
                <div class="col-md-5">
                    <select path="state" name="post" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(postmod sm:arr2){%>
                        <option value="<%=sm.getPostid()%>"><%=sm.getPost() %></option>
                        <%} %>
                          </select>
                </div>
            </div>
         </div>
          <div class="row">
            <div class="form-group col-md-12">
             <form method="post"action="skservlet">
         
        <label class="col-md-3 control-lable" for="ql">vacancy number</label>
                <div class="col-md-5">
                    <input type="text" path="vcc" name="vcc"id="vcc" class="form-control input-sm"/>
                   
                </div>
            </div>
         </div>           
          <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">skil</label>
                <div class="col-md-5">
                    <select path="state" name="skill" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(skillmod sm:arr3){%>
                        <option value="<%=sm.getSkillid()%>"><%=sm.getSkill() %></option>
                        <%} %>
                          </select>
                </div>
            </div>
         </div>         
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">qualification</label>
                <div class="col-md-5">
                    <select path="state" name="qli" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(qualimod sm:arr4){%>
                        <option value="<%=sm.getQualificationid()%>"><%=sm.getQualification() %></option>
                        <%} %>
                          </select>
                </div>
            </div>
         </div>                  
           <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">district</label>
                <div class="col-md-5">
                    <select path="state" name="dis" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(dismod sm:arr5){%>
                        <option value="<%=sm.getDisid()%>"><%=sm.getDistname() %></option>
                        <%} %>
                          </select>
                </div>
            </div>
         </div>                  
         <div class="row">
            <div class="form-group col-md-12">
             <form method="post"action="skservlet">
         
        <label class="col-md-3 control-lable" for="ql">percentage</label>
                <div class="col-md-5">
                    <input type="text" path="per" name="per"id="per" class="form-control input-sm"/>
                   
                </div>
            </div>
         </div>                     
        
		     
		
        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" name="operation"id="button"value="POST" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form>
    </div>
 </div>
</div>
</div>
<div class="footer">
	<div class="container">
		<div class="col-md-3 grid_3">
			<h4>Navigate</h4>
			<ul class="f_list f_list1">
				<li><a href="index.html">Home</a></li>
				<li><a href="login.html">Sign In</a></li>
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