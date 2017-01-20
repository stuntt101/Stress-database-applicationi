<%-- 
    Document   : getGroupGrades
    Created on : 16 Jan 2017, 11:44:38 AM
    Author     : LQwabe
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%

StressMeasurementService stressMeasurementService = new StressMeasurementService();

String query = (String) request.getParameter("q");
List<String>  group_grades = stressMeasurementService.searchByGroupGrade(query);
for (String group_grade : group_grades) {
        out.print(group_grade+"\n");
}




%>
