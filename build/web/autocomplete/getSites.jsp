<%-- 
    Document   : getSites
    Created on : 07 Jan 2017, 1:00:49 PM
    Author     : LQwabe
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%


StressMeasurementService stressMeasurementService = new StressMeasurementService();

String query = (String) request.getParameter("q");

List<String> sites = stressMeasurementService.searchBySite(query);
for (String site : sites) {
        out.print(site+"\n");
}




%>
