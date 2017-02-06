<%-- 
    Document   : ad_sent
    Created on : 25 Jan 2017, 10:09:13 AM
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
        <title>Sent Notification</title>
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
            int flagRDeleted = 0;
            int flagSDeleted = 0;
            int unReadMessages = 0;
            int ReadMessage = 1;

            List<Message> newMessages = notificationService.getMessages(recipient, flagRDeleted, unReadMessages);
            List<Message> oldMessages = notificationService.getMessages(recipient, flagRDeleted, ReadMessage);

            List<Message> sentMessages = notificationService.getMessageBySenderId(sender, flagSDeleted);

            int noOfUnReadMessages = newMessages.size();
            int noOfSentMessages = sentMessages.size();

            request.setAttribute("sentMessages", sentMessages);
            request.setAttribute("noOfUnReadMessages", noOfUnReadMessages);
            request.setAttribute("noOfSentMessages", noOfSentMessages);
            
           


        %>

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
                    <h1 id="logo" >Stress Measurements Record</h1>
                    <div id="top-navigation"> <a href="#"><strong>Administrator</strong></a> <span>|</span> <a href="#">Help</a> <span>|</span> <a href="#">Profile Settings</a> <span>|</span> <a href="logout.jsp">Log out</a> </div>
                </div>
                <!-- End Logo + Top Nav -->
                <!-- Main Nav -->
                <div id="navigation">
                    <ul>
                        <li><a href="measurementList_ad.jsp" ><span>Home</span></a></li>
                        <li><a href="ad_notifications.jsp" class="active"><span>Notifications</span></a></li>
                        <li><a href="list_users.jsp"><span>User Management</span></a></li>
                        <li><a href="#"><span>Publications</span></a></li>
                        <li><a href="#"><span>Conferences</span></a></li>
                        <li><a href="#"><span>FAQs</span></a></li>
                    </ul>
                </div>
                <!-- End Main Nav -->
            </div>
        </div>
        <hr style="height:3px;border:none;color:#004a8d;background-color:#004a8d; " />
        <!-- End Header -->
        <!-- Container -->
        <div id="container">
            <div class="shell">
                <!-- Small Nav -->
                <div class="small-nav"> <a href="ad_notifications.jsp">Notifications</a> <span>&gt;</span>Sent Notifications list</div>
                <!-- End Small Nav -->


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
                                <h2 ><center>Sent Notifications</center></h2>

                            </div>
                            <!-- End Box Head -->
                            <!-- Table -->

                            <div class="table" >
                                <table width="100%" class="divHeight" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        
                                        <th>To</th>
                                        <th>Subject</th>
                                        <th>Date</th>
                                        <th width="110" class="ac">Content Control</th>
                                    </tr>
                                    <c:forEach items="${sentMessages}" var="list">
                                        <fmt:formatDate value='${list.sentDate}' pattern='yyyy-MM-dd HH:mm' var="date" />
                                        <tr>
                                            
                                            <td><a href="#"><c:out value="${list.recipientId.getFirstname()} ${list.recipientId.getLastname()}" /></a></td>
                                            <td><h3><a href="#"><c:out value="${list.subject}" />.</a></h3></td>
                                            <td><c:out value="${date}"/></td>
                                            <td><a></a><a  href="sent_message.jsp?messageId=${list.messageId}"id="myBtn"  class="ico edit">View</a></td>
                                        </tr>
                                    </c:forEach>


                                </table>

                            </div>
                       

                            <!-- Table -->
                        </div>
                        <!-- End Box -->

                    </div>
                    <!-- End Content -->
                    <!-- Sidebar -->
                    <div id="sidebar">
                        <!-- Box -->
                        <div class="box ">
                            <!-- Box Head -->
                            <div class="box-head">
                                <h2>Management</h2>
                            </div>
                            <!-- End Box Head-->
                            <div class="box-content"> 
                                <div class="cl">&nbsp;</div>

                                <p><a href="ad_notifications.jsp">New messages(${noOfUnReadMessages})</a></p>
                                <p><a href="ad_sent.jsp">Sent messages(${noOfSentMessages})</a></p>
                                <!-- Sort -->

                                <!-- End Sort -->
                            </div>
                        </div>
                        <!-- End Box -->
                    </div>
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
