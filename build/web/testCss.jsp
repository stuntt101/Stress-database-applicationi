<%-- 
    Document   : index
    Created on : 17 Jan 2017, 9:03:33 AM
    Author     : ERavhengani
--%>


<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>DataTables example - File export</title>
        <link rel="shortcut icon" type="image/png" href="/media/images/favicon.png">




        <script type="text/javascript" src="testJs/jquery-1.12.4.js"></script>
        <script type="text/javascript" src="testJs/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="testJs/dataTables.buttons.min.js"></script>
        <script type="text/javascript" src="testJs/buttons.flash.min.js"></script>
        <script type="text/javascript" src="testJs/jszip.min.js"></script>
        <script type="text/javascript" src="testJs/pdfmake.min.js"></script>
        <script type="text/javascript" src="testJs/vfs_fonts.js"></script>
        <script type="text/javascript" src="testJs/buttons.html5.min.js"></script>
        <script type="text/javascript" src="testJs/buttons.print.min.js"></script>
        <script type="text/javascript" src="testJs/buttons.colVis.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/buttons.dataTables.min.css"/>
        <link rel="stylesheet" href="css/styles.css" />





        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>

        <script type="text/javascript" class="init">
            $(document).ready(function () {
                $('#example').DataTable({
                    dom: 'Bfrtip',
                    buttons: [
                        {
                            extend: 'print',
                            exportOptions: {
                                columns: ':visible'
                            }
                        },
                        'colvis',
                         'copy', 'csv', 'excel', 'pdf', 'print'
                         
                    ],
                    columnDefs: [{
                            targets: -1,
                            visible: false
                        }]
                });
            });
        </script>

    </head>

    <body>

        <%
           StressMeasurementService stressMeasurementService = new StressMeasurementService();

            String verified = "Yes";
            request.setAttribute("listStressMeasurements", stressMeasurementService.findByVerified(verified));


        %>  


        %>
        <div id="header">
            <div id="header-wrap">
                <table width="100%" height="40%" border="0" style="background-color: #004a8d; top: 0;">
                    <tr align=”left”>

                        <td style="vertical-align:bottom;text-align:right; background-color: #004a8d;"><span style="float: left;"><img src="images/new_logo.jpg"  width="120" height="122" style="float: right;" alt="Logo" /></span></td>
                        <td style="background-color: #004a8d; color: white;">
                    <center> <b> <h2><strong>Mining Activities Feedback Form</strong></h2></b> </center></td>
                    <td style="vertical-align: bottom; background-color: #004a8d;text-align:right; width: 47%; color: white;">   <div id="top"> Welcome <strong>${firstname} ${lastname}</strong> <span>|</span> <a href="logout.jsp" style="color: red;">Log out</a> </div>  </br>  
                    </td>
                    </tr>
                </table>
            </div>
        </div>
        <br>
        <br>
        <p>&nbsp;</p>

        <table id="example" class="display nowrap" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>SM_ID</th>	
                                <th>AVG</th>	
                                <th>GG</th>	
                                <th>IG</th>	
                                <th>COUNTRY</th>		
                                <th>PROVINCE</th>		
                                <th>LOCALITY</th>		
                                <th>SITE</th>		
                                <th>LOCATION</th>		
                                <th>LONGITUDE(°)</th>		
                                <th>LATITUDE(°)</th>		
                                <th>DATE</th>		
                                <th>METHOD</th>		
                                <th>DEPTH(m)</th>		
                                <th>BS1(°)</th>	
                                <th>BS2(°)</th>	
                                <th>BS3(°)</th>	
                                <th>DIPS1(°)</th>		
                                <th>DIPS2(°)</th>		
                                <th>DIPS3(°)</th>		
                                <th>S1(MPa)</th>	
                                <th>S2(MPa)</th>	
                                <th>S3(MPa)</th>	
                                <th>SOB(MPa)</th>		
                                <th>SX(MPa)</th>	
                                <th>SY(MPa)</th>	
                                <th>SZ(MPa)</th>	
                                <th>SXY(MPa)</th>	
                                <th>SYZ(MPa)</th>	
                                <th>SZX(MPa)</th>	
                                <th>SH1(MPa)</th>	
                                <th>SH3(MPa)</th>	
                                <th>BSH1(MPa)</th>		
                                <th>K1(°)</th>	
                                <th>K3(°)</th>	
                                <th>KX(°)</th>	
                                <th>KZ(°)</th>	
                                <th>NO</th>	
                                <th>E(GPa)</th>	
                                <th>PR</th>	
                                <th>ROCK</th>		
                                <th>SEQ</th>	
                                <th>REFF</th>		
                                <th>NOTES</th>		
                                <th>AVGB</th>
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <th>SM_ID</th>	
                                <th>AVG</th>	
                                <th>GG</th>	
                                <th>IG</th>	
                                <th>COUNTRY</th>		
                                <th>PROVINCE</th>		
                                <th>LOCALITY</th>		
                                <th>SITE</th>		
                                <th>LOCATION</th>		
                                <th>LONGITUDE(°)</th>		
                                <th>LATITUDE(°)</th>		
                                <th>DATE</th>		
                                <th>METHOD</th>		
                                <th>DEPTH(m)</th>		
                                <th>BS1(°)</th>	
                                <th>BS2(°)</th>	
                                <th>BS3(°)</th>	
                                <th>DIPS1(°)</th>		
                                <th>DIPS2(°)</th>		
                                <th>DIPS3(°)</th>		
                                <th>S1(MPa)</th>	
                                <th>S2(MPa)</th>	
                                <th>S3(MPa)</th>	
                                <th>SOB(MPa)</th>		
                                <th>SX(MPa)</th>	
                                <th>SY(MPa)</th>	
                                <th>SZ(MPa)</th>	
                                <th>SXY(MPa)</th>	
                                <th>SYZ(MPa)</th>	
                                <th>SZX(MPa)</th>	
                                <th>SH1(MPa)</th>	
                                <th>SH3(MPa)</th>	
                                <th>BSH1(MPa)</th>		
                                <th>K1(°)</th>	
                                <th>K3(°)</th>	
                                <th>KX(°)</th>	
                                <th>KZ(°)</th>	
                                <th>NO</th>	
                                <th>E(GPa)</th>	
                                <th>PR</th>	
                                <th>ROCK</th>		
                                <th>SEQ</th>	
                                <th>REFF</th>		
                                <th>NOTES</th>		
                                <th>AVGB</th>
                </tr>
            </tfoot>
            <tbody>
                <c:forEach items="${listStressMeasurements}" var="list">
                                <fmt:formatDate value='${list.date}' pattern='dd/MM/yyyy' var="date" />
                                <tr >
                                    <td nowrap align="center"><c:out value="${list.smId}" /></td>
                                    <td nowrap align="center"><c:out value="${list.avg}" /></td>
                                    <td nowrap align="center"><c:out value="${list.gg}" /></td>
                                    <td nowrap align="center"><c:out value="${list.ig}" /></td>
                                    <td nowrap align="center"> <button name="button1" id="button1" value="${list.smId}"><c:out value="${list.country}" /></button></td>
                                    <td nowrap align="center"><c:out value="${list.province}" /></td>
                                    <td nowrap align="center"><c:out value="${list.locality}" /></td>
                                    <td nowrap align="center"><c:out value="${list.site}" /></td>
                                    <td nowrap align="center"><c:out value="${list.location}" /></td>
                                    <td nowrap align="center"><c:out value="${list.longitude}" /></td>
                                    <td nowrap align="center"><c:out value="${list.latitude}" /></td>                               
                                    <td nowrap align="center"><c:out value="${date}" /></td>                  
                                    <td nowrap align="center"><c:out value="${list.method}" /></td>
                                    <td nowrap align="center"><c:out value="${list.depth}" /></td>
                                    <td nowrap align="center"><c:out value="${list.bs1}" /></td>
                                    <td nowrap align="center"><c:out value="${list.bs2}" /></td>
                                    <td nowrap align="center"><c:out value="${list.bs3}" /></td>
                                    <td nowrap align="center"><c:out value="${list.dips1}" /></td>
                                    <td nowrap align="center"><c:out value="${list. dips2}" /></td>
                                    <td nowrap align="center"><c:out value="${list.dips3}" /></td>
                                    <td nowrap align="center"><c:out value="${list.s1}" /></td>
                                    <td nowrap align="center"><c:out value="${list.s2}" /></td>
                                    <td nowrap align="center"><c:out value="${list.s3}" /></td>
                                    <td nowrap align="center"><c:out value="${list.sob}" /></td>
                                    <td nowrap align="center"><c:out value="${list.sx}" /></td>
                                    <td nowrap align="center"><c:out value="${list.sy}" /></td>
                                    <td nowrap align="center"><c:out value="${list.sz}" /></td>
                                    <td nowrap align="center"><c:out value="${list.sxy}" /></td>
                                    <td nowrap align="center"><c:out value="${list.syz}" /></td>
                                    <td nowrap align="center"><c:out value="${list.szx}" /></td>
                                    <td nowrap align="center"><c:out value="${list.sh1}" /></td>
                                    <td nowrap align="center"><c:out value="${list.sh3}" /></td>
                                    <td nowrap align="center"><c:out value="${list.bsh1}" /></td>
                                    <td nowrap align="center"><c:out value="${list.k1}" /></td>
                                    <td nowrap align="center"><c:out value="${list.k3}" /></td>
                                    <td nowrap align="center"><c:out value="${list.kx}" /></td>
                                    <td nowrap align="center"><c:out value="${list.kz}" /></td>
                                    <td nowrap align="center"><c:out value="${list.no}" /></td>
                                    <td nowrap align="center"><c:out value="${list.e}" /></td>
                                    <td nowrap align="center"><c:out value="${list.pr}" /></td>
                                    <td nowrap align="center"><c:out value="${list.rock}" /></td>
                                    <td nowrap align="center"><c:out value="${list.seq}" /></td>
                                    <td nowrap align="center"><c:out value="${list.reff}" /></td>
                                    <td nowrap align="center"><c:out value="${list.notes}" /></td>
                                    <td nowrap align="center"><c:out value="${list.avgb}" /></td>

                                </tr>
                            </c:forEach>
            </tbody>
        </table>

        <div id="footer">
            <div class="shell" style="text-align: center;"> <span class="center">Copyright &copy; CSIR 2017. All Rights Reserved.</span> <span class="right"></span> </div>

        </div>
    </body>

</html>
