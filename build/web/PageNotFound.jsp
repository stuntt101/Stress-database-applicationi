<%-- 
    Document   : PageNotFound
    Created on : 17 Mar 2017, 2:09:21 PM
    Author     : LQwabe
--%>

<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> </title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

<style>
        label {
            color: #555555;
            font-weight: bold;
            font-size:13px;
            font:  HelveticaNeue, Verdana, Arial,bold, Helvetica, sans-serif;
            display: block;
            width: 100px;
            float: left;
        }
        input, textarea, select { float: left;
                                  width:150px;
                                  -moz-border-radius: 4px; border-radius: 4px;
                                  border: 1px solid #555555 }
        </style>

</head>
<body>
<!-- Header -->
<div id="header">
  <div class="shell">
    <!-- Logo + Top Nav -->
    <div id="top">
      <h1 id="logo" style="font-family: sans-serif; font-weight:bold ">Stress Measurements Record</h1>

      <div id="top-navigation">  <span></span> <a href="#">Help</a> </div>
    </div>
    <!-- End Logo + Top Nav -->
    <!-- Main Nav -->
    <div id="navigation">
      <ul>
        <li><a href="measurementList.jsp" class="active"><span>Home</span></a></li>
        <li><a href="#"><span>Publications</span></a></li>
        <li><a href="#"><span>Conferences</span></a></li>
        <li><a href="#"><span>FAQs</span></a></li>
        <li><a href="#"><span>Photo Gallery</span></a></li>
        
      </ul>
    </div>
    <!-- End Main Nav -->
  </div>
</div>
<hr style="height:3px;border:none;color:#5c9ccc;background-color:#5c9ccc; " />
<!-- End Header -->
<!-- Container -->


<div id="container">
  <div class="shell">
    <!-- Small Nav -->
    <div class="small-nav"> <a href="measurementList.jsp">Home</a> <span>&gt;</span> Error</div>
    <!-- End Small Nav -->
     </div>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    
     <center>
         <!-- Message Error -->
    
    <!-- End Message Error -->
    <!-- Main -->
    <div id="main">
         </div>
      <div class="cl">&nbsp;</div>
      <!-- Content -->
      <center>
      <div id="login" style="width: 450px;height: 200px; ">

    <div class=" msg msg-error" style="width: 450px ;">
                    <p> <img src="images/favicon-32x32.png" alt="alt text" style="float: left"></img><strong>Sorry! Your session may be expired/or You  don't have permission to access this page. Please Try again.   <a href="login.jsp" style="color: blue;">Log in</a></strong></p>
                </div>

       
        </div>
      </center>
        <!-- End Box -->
        
     </center>
      <!-- End Content -->
      <!-- Sidebar -->
      <div id="sidebar">
        
      </div>
      <!-- End Sidebar -->
      <div class="cl">&nbsp;</div>
   
    <!-- Main -->
  </div>

<!-- End Container -->
<!-- Footer -->
<div id="footer">
  <div class="shell" style="text-align: center;"> <span class="center">Copyright &copy; CSIR 2017. All Rights Reserved.</span> <span class="right"></span> </div>
</div>
<!-- End Footer -->
</body>
</html>
