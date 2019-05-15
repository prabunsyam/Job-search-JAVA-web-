<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.qualimod"%>
<%@page import="services.qualiservice"%>
<%@page import="model.dismod"%>
<%@page import="services.dservice"%>
<%@page import="model.statemod"%>
<%@page import="java.util.ArrayList"%>
<%@page import="services.stateservice"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seeking an Job Portal</title>
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
		       
		        <li><a href="login.jsp">Login</a></li>
		        
	        </ul>
	    </div>
	    <div class="clearfix"> </div>
	  </div>
	   
	</nav>
<div class="banner_1">
	<div class="container">
		<div id="search_wrapper1">
		   <div id="search_form" class="clearfix">
		   
           </div>
		</div>
   </div> 
</div>	
 <%stateservice rs=new stateservice();
	   ArrayList<statemod>arr=rs.selectAllRegistration();
	   %>
	   
	   
	   <%dservice rr=new dservice();
	   ArrayList<dismod>arr1=rr.selectAllRegistration();
	   %>
	     <%qualiservice ar=new qualiservice();
	   ArrayList<qualimod>arr2=ar.selectAllRegistration();
	   %>	
<div class="container">
    <div class="single">  
	   <div class="form-container">
        <h2>Register Form</h2>
        <form method="post"action="userservlet" enctype="multipart/form-data">
          <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">Name</label>
                <div class="col-md-9">
                    <input type="text" path="name"name="name" id="name" class="form-control input-sm"/>
                </div>
            </div>
         </div>
     <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="address">Address</label>
                <div class="col-md-9">
                    <input type="text" path="address" id="address" name="address"class="form-control input-sm"/>
                </div>
            </div>
         </div>
		  <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="state">State</label>
                <div class="col-md-9">
                    <select path="state" name="state" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(statemod sm:arr){%>
                        <option value="<%=sm.getSid()%>"><%=sm.getState() %></option>
                        
                        	
                    
                   <%} %>
                   </select>
              </div>
            </div>
         </div>
     <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="district">District</label>
                <div class="col-md-9">
                     <select path="state" name="district" id="state" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(dismod sm:arr1){%>
                        <option value="<%=sm.getDisid()%>"><%=sm.getDistname()%></option>
                        
                        	
                    
                   <%} %>
                   </select>
                </div>
            </div>
         </div>
   
	
		  <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="sex">Sex</label>
                <div class="col-md-9" class="form-control input-sm">
                    <div class="radios">
				        <label for="radio-01" class="label_radio">
				            <input type="radio" name="gender"value="male"> Male
				        </label>
				        <label for="radio-02" class="label_radio">
				            <input type="radio" name="gender"value="female"> Female
				        </label>
	                </div>
                </div>
            </div>
        </div>
		 <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="dob">Date of birth</label>
               <div class="col-md-9">
                    <input type="date" name="dob">
               </div>
            </div>
        </div>
		 <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="age">Age</label>
                <div class="col-md-9">
                    <input type="text" path="age" name="age"id="age" class="form-control input-sm"/>
                </div>
            </div>
        </div>
		
    
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="ph">Mobile Number</label>
                <div class="col-md-9">
                    <input type="text" name="ph"path="ph" id="ph" class="form-control input-sm"/>
                </div>
            </div>
        </div>
		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="qlf">Education</label>
                <div class="col-md-9">
                    <select path="ql" name="qlf" id="ql" class="form-control input-sm">
                        <option value="">Select</option>
                        <%for(qualimod sm:arr2){%>
                        <option value="<%=sm.getQualificationid()%>"><%=sm.getQualification() %></option>
                        
                        	
                    
                   <%} %>
                   </select>
               </div>
            </div>
        </div>
		 <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="yrps">Year of pass</label>
                <div class="col-md-9">
                    <input type="text" name="yrps"path="yrps" id="yrps" class="form-control input-sm"/>
                </div>
            </div>
        </div>
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="sex">experience</label>
                <div class="col-md-9" class="form-control input-sm">
                    <div class="radios">
				        <label for="radio-01" class="label_radio">
				            <input type="radio" name="expr"value="fresher"> fresher
				        </label>
				        <label for="radio-02" class="label_radio">
				            <input type="radio" name="expr"value="experienced"> experienced
				        </label>
	                </div>
                </div>
            </div>
        </div>
        
        
        
        
        
        
        
        
        
   
      
       
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Email</label>
                <div class="col-md-9">
                    <input type="text" path="email" id="email" name="mail"class="form-control input-sm"/>
                </div>
            </div>
        </div>       
		
  <!--  <div class="single">  
	   <div class="form-container">
       <label class="col-md-3 control-lable" for="resume">Resume</label>
        <div class="search_form1">
		   
			  <input type="file"path="resume"id="resume" name="resume">
			   
	    </div>
    </div>
 </div>
</div> --> 


 <h2>SET YOUR USERNAME&PASSWORD</h2>
       <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">username</label>
                <div class="col-md-5">
                    <input type="text" path="name" id="name" name="user"class="form-control input-sm"/>
                </div>
            </div>
         </div>
       <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">password</label>
                <div class="col-md-5">
                    <input type="password" path="name" id="name" name="pass"class="form-control input-sm"/>
                </div>
            </div>
         </div>
       
        
        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" name="operation"value="Register" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form>
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
				
				<li><a href="contact.html">Contact Us</a></li>
			</ul>
			<ul class="f_list">
				
				
				
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
			
			<form>
				<input type="text" class="form-control" placeholder="Enter your email">
				<button type="button" class="btn red">Subscribe now!</button>
		    </form>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<div class="footer_bottom">	
 ss
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