<%-- 
    Document   : test2
    Created on : 08 Dec 2016, 9:20:14 AM
    Author     : LQwabe
--%>

<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html
    <!DOCTYPE html>
    <html>
        <head>
            <title></title>


            <!-- Ignite UI Required Combined CSS Files -->
            <link href="assets/css/infragistics.theme.css" rel="stylesheet" />
            <link href="assets/css/infragistics.css" rel="stylesheet" />
                <link href="http://www.igniteui.com/css/bootstrap/bootstrap.min.css" rel="stylesheet" />

            <script src="assets/js/modernizr-2.8.3.js"></script>
            <script src="assets/js/jquery-1.11.3.min.js"></script>
            <script src="assets/js/jquery-ui.min.js"></script>

            <!-- Ignite UI Required Combined JavaScript Files -->
            <script src="assets/js/infragistics.core.js"></script>
            <script src="assets/js/infragistics.lob.js"></script>


            <style>
                #grid_container
                {
                    width: 100%;

                }
            </style>

        </head>
        <body>


            <%StressMeasurementService stressMeasurementService = new StressMeasurementService();

                request.setAttribute("listStressMeasurements", stressMeasurementService.getAllStressMeasurements());

            %>
            <br>
            <br>
            <br>
            <table id="grid">
                <thead>
                    <tr>
                        <th >SM ID</th>	
                        <th>AVG	</th>	
                        <th>GG	</th>	
                        <th>IG	</th>	
                        <th>COUNTRY</th>		
                        <th>PROVINCE</th>		
                        <th>LOCALITY</th>		
                        <th>SITE</th>		
                        <th>LOCATION</th>		
                        <th>LONGITUDE</th>		
                        <th>LATITUDE</th>		
                        <th>DATE</th>		
                        <th>METHOD</th>		
                        <th>DEPTH</th>		
                        <th>BS1	</th>	
                        <th>BS2	</th>	
                        <th>BS3	</th>	
                        <th>DIPS1</th>		
                        <th>DIPS2</th>		
                        <th>DIPS3</th>		
                        <th>S1	</th>	
                        <th>S2	</th>	
                        <th>S3	</th>	
                        <th>SOB</th>		
                        <th>SX	</th>	
                        <th>SY	</th>	
                        <th>SZ	</th>	
                        <th>SXY	</th>	
                        <th>SYZ	</th>	
                        <th>SZX	</th>	
                        <th>SH1	</th>	
                        <th>SH3	</th>	
                        <th>BSH1</th>		
                        <th>K1	</th>	
                        <th>K3	</th>	
                        <th>KX	</th>	
                        <th>KZ	</th>	
                        <th>NO	</th>	
                        <th>E	</th>	
                        <th>PR	</th>	
                        <th>ROCK</th>		
                        <th>SEQ	</th>	
                        <th>REFF</th>		
                        <th>NOTES</th>		
                        <th>AVGB</th>	

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listStressMeasurements}" var="list">
                        <tr>
                            <td><c:out value="${list.smId}" /></td>
                            <td><c:out value="${list.avg}" /></td>
                            <td><c:out value="${list.gg}" /></td>
                            <td><c:out value="${list.ig}" /></td>
                            <td><c:out value="${list.country}" /></td>
                            <td><c:out value="${list.province}" /></td>
                            <td><c:out value="${list.locality}" /></td>
                            <td><c:out value="${list.site}" /></td>
                            <td><c:out value="${list.location}" /></td>
                            <td><c:out value="${list.longitude}" /></td>
                            <td><c:out value="${list.latitude}" /></td>
                            <td><c:out value="${list.date}" /></td>
                            <td><c:out value="${list.method}" /></td>
                            <td><c:out value="${list.depth}" /></td>
                            <td><c:out value="${list.bs1}" /></td>
                            <td><c:out value="${list.bs2}" /></td>
                            <td><c:out value="${list.bs3}" /></td>
                            <td><c:out value="${list.dips1}" /></td>
                            <td><c:out value="${list. dips2}" /></td>
                            <td><c:out value="${list.dips3}" /></td>
                            <td><c:out value="${list.s1}" /></td>
                            <td><c:out value="${list.s2}" /></td>
                            <td><c:out value="${list.s3}" /></td>
                            <td><c:out value="${list.sob}" /></td>
                            <td><c:out value="${list.sx}" /></td>
                            <td><c:out value="${list.sy}" /></td>
                            <td><c:out value="${list.sz}" /></td>
                            <td><c:out value="${list.sxy}" /></td>
                            <td><c:out value="${list.syz}" /></td>
                            <td><c:out value="${list.szx}" /></td>
                            <td><c:out value="${list.sh1}" /></td>
                            <td><c:out value="${list.sh3}" /></td>
                            <td><c:out value="${list.bsh1}" /></td>
                            <td><c:out value="${list.k1}" /></td>
                            <td><c:out value="${list.k3}" /></td>
                            <td><c:out value="${list.kx}" /></td>
                            <td><c:out value="${list.kz}" /></td>
                            <td><c:out value="${list.no}" /></td>
                            <td><c:out value="${list.e}" /></td>
                            <td><c:out value="${list.pr}" /></td>
                            <td><c:out value="${list.rock}" /></td>
                            <td><c:out value="${list.seq}" /></td>
                            <td><c:out value="${list.reff}" /></td>
                            <td><c:out value="${list.notes}" /></td>
                            <td><c:out value="${list.avgb}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br />





            <script>
                $("#grid").igGrid({
                    autoGenerateColumns: true,
                    columns: [
                        {headerText: "SM ID", key: "SM ID",pinned: true, dataType: "number"},
                        {headerText: "AVG", key: "AVG", dataType: "string"},
                    ],
                    defaultColumnWidth: 100,
                    features: [
                        {
                            name: 'Sorting',
                            type: 'local'
                        },
                         {
                        name: "Responsive",
                         enableVerticalRendering: false
                                },
                        {
                        name: 'Paging',
                        type: "local",
                        pageSize: 10
                    },
//                    {
//                        name: "ColumnFixing",
//                        fixingDirection: "left"
//                       
//                    },
                        {    
                        name: "Filtering",
                        type: "local",
                        mode: "simple"
                            
//                           name: 'Filtering',
//                            //displayMode: 'showWithAncestorsAndDescendants'
//                           displayMode: 'showWithAncestors'
                        }
                    ]
                });


            </script>

        </body>
    </html>