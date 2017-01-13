<%-- 
    Document   : data.jsp
    Created on : 21 Dec 2016, 9:50:28 AM
    Author     : LQwabe
--%>

<%@page import="com.stressmeasurement.entity.StressMeasurement"%>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   String name = "";
   Float lng =null;
    Float lat =null;
    Integer q2=null;
    Integer q = Integer.parseInt(request.getParameter("q"));
   //String q = request.getParameter("q");
   StressMeasurementService service = new StressMeasurementService();
   StressMeasurement stressMeasurement=service.getStressMeasurementById(q);
   name=stressMeasurement.getCountry();
   lng=stressMeasurement.getLongitude();
   lat=stressMeasurement.getLatitude();
   q2=stressMeasurement.getSmId();
 %>
<%out.print(q2+",");%>
<%out.print(lng+",");%>
<%out.print("-"+lat);%>

