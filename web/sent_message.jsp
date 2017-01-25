<%-- 
    Document   : sent_message
    Created on : 25 Jan 2017, 11:26:12 AM
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
        <title>Sent Message</title>
        <style>
        .email{ float: left;
                    width:500px;
                    -moz-border-radius: 4px; border-radius: 4px;
                    border: 1px solid #000 }
        </style>
    </head>
    <body>
        <%
        NotificationService notificationService = new NotificationService();
        
           
            

           Integer  messageId = Integer.parseInt(request.getParameter("messageId"));
           Message message = notificationService.getMessageById(messageId);
           User userTo = message.getRecipientId();
           request.setAttribute("messageId", messageId);
            request.setAttribute("userTo", userTo);
            request.setAttribute("message", message);
        %>
        <div id="myModal" class="message_modal">

            <!-- Modal content -->
            <div class="modal-content">
                <div class="modal-header">
                    <span class="close">×</span>
                    <p><center>Sent Message</center></p>
                </div>
                <center>
                    <div class="modal-body">
                        <center>

                            <table border="0" cellpadding = "2" cellspacing="7" >
                                <tbody>

                                    <tr>                            
                                        <td><label >To:</label></td><td><input type="text" class="email" id="recipient"  name="recipient" value="${userTo.emailAddress}"/> </td>
                                    </tr>
                                    <tr>                            
                                        <td><label >Subject:</label></td><td><input type="text" class="email" id="subject"  name="subject" value="${message.subject}"/> </td>
                                    </tr>
                                    <tr> 
                                        <td><label >Message Text:</label></td><td><textarea  class="email" rows="12" cols="80" name="content">${message.content}</textarea><br/></td>
                                    </tr>

                                </tbody>
                            </table>
                        </center>

                        <br>


                    </div>
                </center>

            </div>
        </div>
        <script>
// 

// Get the <span> element that closes the modal
            var span = document.getElementsByClassName("close")[0];




// When the user clicks on <span> (x), close the modal
            span.onclick = function () {
               
                location = '/StressMeasurement/ad_sent.jsp';
            }

// When the user clicks anywhere outside of the modal, close it
           
        </script>

    </body>
</html>
