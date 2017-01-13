<%-- 
    Document   : getMethods
    Created on : 07 Jan 2017, 12:42:49 PM
    Author     : LQwabe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%


StressMeasurementService stressMeasurementService = new StressMeasurementService();

String query = (String) request.getParameter("q");

List<String> methods = stressMeasurementService.searchByMethod(query);
for (String method : methods) {
        out.print(method+"\n");
}




%>

