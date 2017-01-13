<%-- 
    Document   : login
    Created on : Jan 7, 2017, 9:44:42 PM
    Author     : Lungelo
--%>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login </title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

<style>
        label {
            color: #B4886B;
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
                                  border: 1px solid #BB221E }
        </style>

</head>
<body>
<!-- Header -->
<div id="header">
  <div class="shell">
    <!-- Logo + Top Nav -->
    <div id="top">
      <h1 id="logo" >Stress Measurements Record</h1>
      <div id="top-navigation">  <span></span> <a href="#">Help</a> </div>
    </div>
    <!-- End Logo + Top Nav -->
    <!-- Main Nav -->
    <div id="navigation">
      <ul>
        <li><a href="/StressMeasurement" class="active"><span>Home</span></a></li>
        <li><a href="#"><span>Publications</span></a></li>
        <li><a href="#"><span>Conferences</span></a></li>
        <li><a href="#"><span>FAQs</span></a></li>
        <li><a href="#"><span>Photo Gallery</span></a></li>
        
      </ul>
    </div>
    <!-- End Main Nav -->
  </div>
</div>
<!-- End Header -->
<!-- Container -->


<div id="container">
  <div class="shell">
    <!-- Small Nav -->
    <div class="small-nav"> <a href="/StressMeasurement">Home</a> <span>&gt;</span> Login</div>
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
      <div id="login" style="width: 1000px;height: 200px; ">

    
          <!-- Box -->
        <div class="box">
          <!-- Box Head -->
          <div class="box-head">
            <h2 class="left"><strong>New Record</strong></h2>
          </div>
          <!-- End Box Head-->
          <div class="box-content"> 
             
            <div class="cl">&nbsp;</div>
            
            <form method="post" action="LoginServlet" autocomplete="off">
                
                    <fieldset>
            <center>
                <table  cellpadding = "2" cellspacing="7" >
                    <tbody>
                        <fi>
                            <fieldset>

                            <td><label>BS3</label></td><td><input type="text" id="bs3"  name="bs3" ></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td> </tr>
                             <tr><td><label>DIPS1</label></td><td><input type="text" id="dips1"  name="dips1" ></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td> </tr>
                             <tr><td><label>DIPS2</label></td><td><input type="text"  id="dips2"  name="dips2"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td> </tr>
                       </fieldset>
                        <tr>

                            <td><label>DIPS3</label></td><td><input type="text" id="dips3"  name="dips3"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                            <td><label>S1</label></td><td><input type="text"  id="s1"  name="s1"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>S2</label></td><td><input type="text" id="s2"  name="s2"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>

                        </tr>
                        <tr>

                            <td><label>S3</label></td><td><input type="text"  id="s3"  name="s3"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SOB</label></td><td><input type="text" id="sob"  name="sob"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SX</label></td><td><input type="text" id="sx"  name="sx"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                        </tr>
                        <tr>

                            <td><label>SY</label></td><td><input type="text" id="sy"  name="sy"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SZ</label></td><td><input type="text" id="sz"  name="sz"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SXY</label></td><td><input type="text" id="sxy"  name="sxy"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span></td>
                        </tr>

                        <tr>

                            <td><label>SYZ</label></td><td><input type="text" id="syz"  name="syz"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SZX</label></td><td><input type="text" id="szx"  name="szx"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SH1</label></td><td><input type="text" id="sh1"  name="sh1"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                        </tr>
                    </tbody>
                </table>
            </center>
            </fieldset>
            </div>
            
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
