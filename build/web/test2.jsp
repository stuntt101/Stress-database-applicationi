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
            int flagRDeleted = 0;
            int flagSDeleted=0;
            int unReadMessages = 0;
            int  ReadMessage = 1;
            
            
            List<Message> allMessages = notificationService.getMessageByRecipientId(recipient, flagRDeleted);
            List<Message> newMessages = notificationService.getReadMessages(recipient, unReadMessages);
            List<Message> sentMessages=notificationService.getMessageBySenderId(recipient, flagSDeleted);
             int noOfUnReadMessages=newMessages.size();
             int noOfSentMessages=sentMessages.size();
            String verified = "No";
            request.setAttribute("allMessages", allMessages);
             request.setAttribute("noOfUnReadMessages", noOfUnReadMessages);
             request.setAttribute("noOfUnReadMessages", noOfUnReadMessages);
             request.setAttribute("noOfSentMessages", noOfSentMessages);

        %>

        <!-- Header -->
        <div id="header">
            <div class="shell">
                <!-- Logo + Top Nav -->
                <div id="top">
                    <h1 id="logo" style="font-family: sans-serif; font-weight:bold ">Stress Measurements Record</h1>

                    <div id="top-navigation"> Welcome <a href="#"><strong>Administrator</strong></a> <span>|</span> <a href="#">Help</a> <span>|</span> <a href="#">Profile Settings</a> <span>|</span> <a href="#">Log out</a> </div>
                </div>
                <!-- End Logo + Top Nav -->
                <!-- Main Nav -->
                <div id="navigation">
                    <ul>
                        <li><a href="measurementList_us.jsp" ><span>Home</span></a></li>
                        <li><a href="us_notifications.jsp" class="active"><span>Notifications</span></a></li>
                        <li><a href="#"><span>Publications</span></a></li>
                        <li><a href="#"><span>Conferences</span></a></li>
                        <li><a href="#"><span>FAQs</span></a></li>
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
                <div class="small-nav"> <a href="us_notifications.jsp">Notifications</a> <span>&gt;</span>Notifications list</div>
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
                                <h2 ><center>Notifications</center></h2>

                            </div>
                            <!-- End Box Head -->
                            <!-- Table -->
                            <div class="table" >
                                <table width="100%" class="divHeight" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <th width="13"></th>
                                        <th>From</th>
                                        <th>Subject</th>
                                        <th>Date</th>
                                        <th width="110" class="ac">Content Control</th>
                                    </tr>
                                    <c:forEach items="${allMessages}" var="list">
                                         <fmt:formatDate value='${list.sentDate}' pattern='yyyy-MM-dd HH:mm' var="date" />
                                        <tr>
                                            <td><input type="checkbox" class="checkbox" /></td>
                                            <td><a href="#"><c:out value="${list.senderId.getFirstname()} ${list.senderId.getLastname()}" /></a></td>
                                            <td><h3><a href="#"><c:out value="${list.subject}" />.</a></h3></td>
                                            <td><c:out value="${date}" /></td>
                                            <td><a href="#" class="ico del">Delete</a><a href="StressMeasurementController?action=view_and_verify&smId=<c:out value="${list.dataReffId.getSmId()}"/>" class="ico edit">View</a></td>
                                        </tr>
                                    </c:forEach>

                                </table>
                                <!-- Pagging -->
                                <div class="pagging">
                                    <div class="left">Showing 1-12 of 44</div>
                                    <div class="right"> <a href="#">Previous</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">245</a> <span>...</span> <a href="#">Next</a> <a href="#">View all</a> </div>
                                </div>
                                <!-- End Pagging -->
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

                                <p><a href="test2.jsp">New messages(${noOfUnReadMessages})</a></p>
                                <p><a href="#">Sent messages(${noOfSentMessages})</a></p>
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
        <!-- Footer -->
        <div id="footer">
            <div class="shell" style="text-align: center;"> <span class="center">Copyright &copy; CSIR 2017. All Rights Reserved.</span> <span class="right"></span> </div>
        </div>
        <!-- End Footer --
        <!-- End Footer -->
    </body>
</html>
