<%-- 
    Document   : getLocalities
    Created on : 07 Jan 2017, 1:01:40 PM
    Author     : LQwabe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%


StressMeasurementService stressMeasurementService = new StressMeasurementService();

String query = (String) request.getParameter("q");

List<String> localities = stressMeasurementService.searchByLocality(query);
for (String locality : localities) {
        out.print(locality+"\n");
}




%>
