<%-- 
    Document   : list_users
    Created on : 01 Feb 2017, 9:48:40 AM
    Author     : LQwabe
--%>


<%@page import="com.stressmeasurement.entity.Message"%>
<%@page import="java.util.List"%>
<%@page import="com.stressmeasurement.service.UserService"%>
<%@page import="com.stressmeasurement.service.NotificationService"%>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Notification</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    </head>
    <body>


        <%
            StressMeasurementService stressMeasurementService = new StressMeasurementService();
            NotificationService notificationService = new NotificationService();
            UserService userServise = new UserService();
            User recipient = userServise.getUserByUsername("admin");
            User sender = userServise.getUserByUsername("admin");
            List<User> users = userServise.getAllUsers();
            int flagRDeleted = 0;
            int flagSDeleted = 0;
            int unReadMessages = 0;
            int ReadMessage = 1;

            request.setAttribute("users", users);

            if (session.getAttribute("admin") != null) {
                User user = (User) session.getAttribute("admin");
                String firstname = user.getFirstname();
                String lastname = user.getLastname();
                request.setAttribute("firstname", firstname);
                request.setAttribute("lastname", lastname);
                request.setAttribute("user", user);
            } else {

                request.setAttribute("session_expired", "session_expired");
            }


        %>
        <c:if test="${not empty session_expired}">
            <script type="text/javascript" >

                alert('Your session has expired. please login again.');
                location = 'measurementList.jsp';
            </script>
        </c:if>




        <c:if test="${not empty sent}">
            <script type="text/javascript" >

                alert('New message successfully sent');
                location = 'ad_notifications.jsp';
            </script>
        </c:if>
        <c:if test="${not empty messsage_deleted}">
            <script type="text/javascript" >

                alert('Message successfully deleted');
                location = 'ad_notifications.jsp';
            </script>
        </c:if>
        <c:if test="${not empty verified}">
            <script type="text/javascript" >

                alert('New stress Measurement record successfully verified');
                location = 'ad_notifications.jsp';
            </script>
        </c:if>

        <!-- Header -->
        <div id="header">
            <div class="shell">
                <!-- Logo + Top Nav -->
                <div id="top">
                    <h1 id="logo" style="font-family: sans-serif; font-weight:bold ">Stress Measurements Record</h1>

                    <div id="top-navigation"> <a href="#"><strong>Administrator</strong></a> <span>|</span> <a href="#">Help</a> <span>|</span> <a href="#">Profile Settings</a> <span>|</span> <a href="logout.jsp">Log out</a> </div>
                </div>
                <!-- End Logo + Top Nav -->
                <!-- Main Nav -->
                <div id="navigation">
                    <ul>
                        <li><a href="measurementList_ad.jsp" ><span>Home</span></a></li>
                        <li><a href="ad_notifications.jsp"><span>Notifications</span></a></li>
                        <li><a href="list_users.jsp" class="active"><span>User Management</span></a></li>
                        <li><a href="#"><span>Publications</span></a></li>
                        <li><a href="#"><span>Conferences</span></a></li>
                        <li><a href="#"><span>FAQs</span></a></li>
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
                <div class="small-nav"> <a href="ad_notifications.jsp">User Management</a> <span>&gt;</span>manage users</div>
                <!-- End Small Nav -->
                <!--        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>-->
                <div align="right" ><a href="new_user.jsp"  class="add-button" ><span><b>Add New User</b></span></a></div>
                <br />
                <!-- Main -->
                <div id="main">
                    <div class="cl">&nbsp;</div>
                    <!-- Content -->
                    <div id="content2">
                        <!-- Box -->
                        <div class="box">
                            <!-- Box Head -->
                            <div class="box-head">
                                <h2 ><center>Users</center></h2>

                            </div>
                            <!-- End Box Head -->
                            <!-- Table -->
                            <div class="table" >
                                <table width="100%" class="divHeight" border="0" cellspacing="0" cellpadding="0">
                                    <tr>

                                        <th>Username</th>
                                        <th>Password</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Email Address</th>
                                        <th>Mine Name</th>
                                        <th width="110" class="ac">Action</th>
                                    </tr>
                                    <c:forEach items="${users}" var="list">
                                        <tr>
                                            <td><c:out value="${list.username}"/></td>
                                            <td><c:out value="${list.password}"/></td>
                                            <td><c:out value="${list.firstname}"/></td>
                                            <td><c:out value="${list.lastname}"/></td>
                                            <td><c:out value="${list.emailAddress}"/></td>
                                            <td><c:out value="${list.mineName}"/></td>
                                            <td><a href="RegisterUser?action=delete&username=<c:out value="${list.username}"/>" class="ico del" onclick="return confirm('Are you sure that you want to delete ${list.username} ?');">Delete</a><a href="RegisterUser?action=edit&username=<c:out value="${list.username}"/>" class="ico edit">Edit</a></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                            <!-- Table -->
                        </div>
                        <!-- End Box -->
                    </div>
                    <!-- End Content -->
                    <!-- End Sidebar -->
                    <div class="cl">&nbsp;</div>
                </div>
                <!-- Main -->
            </div>
        </div>
        <!-- End Container -->
        <!-- Footer -->
        <div id="footer">
            <div class="shell" style="text-align: center;"> <span class="center">Copyright &copy; CSIR 2017. All Rights Reserved.</span> <span class="right"></span> </div>
        </div>
        <!-- End Footer --
        <!-- End Footer -->
    </body>
</html>
