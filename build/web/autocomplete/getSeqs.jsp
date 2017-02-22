<%-- 
    Document   : getSeqs
    Created on : 07 Jan 2017, 12:43:21 PM
    Author     : LQwabe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%


StressMeasurementService stressMeasurementService = new StressMeasurementService();

String query = (String) request.getParameter("q");

List<String> seqs = stressMeasurementService.searchBySEQ(query);
for (String seq : seqs) {
        out.print(seq+"\n");
}




%>
