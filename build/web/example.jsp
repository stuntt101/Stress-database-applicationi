<%-- 
    Document   : index
    Created on : 05 Dec 2016, 10:42:30 AM
    Author     : LQwabe
--%>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  
<!--<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">-->
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.datatables.yadcf.css" rel="stylesheet" type="text/css" />

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script src="js/jquery.dataTables.yadcf.js"></script>

<style>
.label {
  padding: 0px 10px 0px 10px;
	border: 1px solid #ccc;
	-moz-border-radius: 1em; /* for mozilla-based browsers */
	-webkit-border-radius: 1em; /* for webkit-based browsers */
	border-radius: 1em; /* theoretically for *all* browsers*/
}

.label.lightblue {
	background-color: #99CCFF;
}

#external_filter_container_wrapper {
  margin-bottom: 20px;
}

#external_filter_container {
  display: inline-block;
}
#parent {
                height: 500px;
            }

            #measurements {
                width: 1800px !important;
            }
            .glyphicon-refresh-animate {
                -webkit-animation-name: rotateThis;
                -webkit-animation-duration: 2s;
                -webkit-animation-iteration-count: infinite;
                -webkit-animation-timing-function: linear;
            }

            @-webkit-keyframes "rotateThis" {
                from { 
                    -webkit-transform: rotate( 0deg );  
                }
                to  { 
                    -webkit-transform: rotate( 360deg ); 
                }
            }
            body {
                font: 90%/1.45em "Helvetica Neue", HelveticaNeue, Verdana, Arial, Helvetica, sans-serif;
                margin: 0;
                padding: 0;
                color: #333;
                background-color: #fff;
            }
            .ColVis{
                padding-right:10px;
                padding-top:5px;

            }

            div.container {
                min-width: 980px;
                margin: 0 auto;
            }
            #myContent {
                display:none;
            }
             #example {
                width: 1800px !important;
            }
             #button1 {
                background-color: Transparent;
                background-repeat:no-repeat;
                border: none;
                cursor:pointer;
                overflow: hidden;
                outline:none;
            }
</style>  

<script>
$(document).ready(function(){
  $('#example').dataTable().yadcf([
	    
	    {column_number : 4, data: ["Botswana", "Lesotho", "Namibia","Malawi","Mozambique","Mozambique off-sho","SA Offshore","South Africa","Tanzania","Zambia","Zimbabwe"], filter_type:"multi_select",filter_default_label: "Select countries", filter_container_id: "country"},
            {column_number : 5,filter_type:"multi_select",filter_default_label: "Select ", filter_container_id: "province"},
            {column_number : 6,filter_type:"multi_select",filter_default_label: "Select ", filter_container_id: "locality"},
            {column_number : 7,filter_type:"multi_select",filter_default_label: "Select ", filter_container_id: "site"},
            {column_number : 8,filter_type:"multi_select",filter_default_label: "Select ", filter_container_id: "location"},
	    {column_number : 11, filter_type: "range_date" , filter_container_id:"date"},
            {column_number : 12,filter_type:"multi_select",filter_default_label: "Select ", filter_container_id: "method"},
            {column_number : 13,filter_type:"range_number", filter_container_id: "depth"},
            {column_number : 14,filter_type:"range_number", filter_container_id: "bs1"},
            {column_number : 15,filter_type:"range_number", filter_container_id: "bs2"},
            {column_number : 16,filter_type:"range_number", filter_container_id: "bs3"},
            {column_number : 17,filter_type:"range_number", filter_container_id: "dips1"},
            {column_number : 18,filter_type:"range_number", filter_container_id: "dips2"},
            {column_number : 19,filter_type:"range_number", filter_container_id: "dips3"},
            {column_number : 20,filter_type:"range_number", filter_container_id: "s1"},
            {column_number : 21,filter_type:"range_number", filter_container_id: "s2"},
            {column_number : 22,filter_type:"range_number", filter_container_id: "s3"},
            {column_number : 23,filter_type:"range_number", filter_container_id: "sob"},
            {column_number : 24,filter_type:"range_number", filter_container_id: "sx"},
            {column_number : 25,filter_type:"range_number", filter_container_id: "sy"},
            {column_number : 26,filter_type:"range_number", filter_container_id: "sz"},
            {column_number : 27,filter_type:"range_number", filter_container_id: "sxy"},
            {column_number : 28,filter_type:"range_number", filter_container_id: "sxz"},
            {column_number : 29,filter_type:"range_number", filter_container_id: "szx"},
            {column_number : 30,filter_type:"range_number", filter_container_id: "sh1"},
            {column_number : 31,filter_type:"range_number", filter_container_id: "sh3"},
            {column_number : 32,filter_type:"range_number", filter_container_id: "bsh1"},
            {column_number : 33,filter_type:"range_number", filter_container_id: "k1"},
            {column_number : 34,filter_type:"range_number", filter_container_id: "k3"},
            {column_number : 35,filter_type:"range_number", filter_container_id: "kx"},
            {column_number : 36,filter_type:"range_number", filter_container_id: "kz"},
            {column_number : 37,filter_type:"range_number", filter_container_id: "no"},
            {column_number : 38,filter_type:"range_number", filter_container_id: "e"},
            {column_number : 39,filter_type:"range_number", filter_container_id: "pr"},
            {column_number : 40,filter_type:"multi_select",filter_default_label: "Select ", filter_container_id: "rock"},
            {column_number : 41,filter_type:"multi_select",filter_default_label: "Select ", filter_container_id: "seq"},
            {column_number : 44,filter_type:"range_number", filter_container_id: "avgb"}
        
        ]);
});



</script>
<meta charset=utf-8 />
<title>Datatable testing</title>
</head>
 <body >
      <%StressMeasurementService stressMeasurementService = new StressMeasurementService();

            request.setAttribute("listStressMeasurements", stressMeasurementService.getAllStressMeasurements());

        %>
        <br>
        <br>
        <br>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    <div id="container">
        <div  id="parent">
      <table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	        <thead>
                        <tr>
                            <th>SM ID</th>	
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
                            <th>DEPTH</th>		
                            <th>BS1</th>	
                            <th>BS2</th>	
                            <th>BS3</th>	
                            <th>DIPS1</th>		
                            <th>DIPS2</th>		
                            <th>DIPS3</th>		
                            <th>S1</th>	
                            <th>S2</th>	
                            <th>S3</th>	
                            <th>SOB</th>		
                            <th>SX</th>	
                            <th>SY</th>	
                            <th>SZ</th>	
                            <th>SXY</th>	
                            <th>SYZ</th>	
                            <th>SZX</th>	
                            <th>SH1</th>	
                            <th>SH3</th>	
                            <th>BSH1</th>		
                            <th>K1</th>	
                            <th>K3</th>	
                            <th>KX</th>	
                            <th>KZ</th>	
                            <th>NO</th>	
                            <th>E</th>	
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
                            <th id="sm_id">SM_ID</th>	
                            <th id="avg" >AVG</th>	
                            <th id="gg">GG</th>	
                            <th id="ig">IG</th>
                            <th id="country">COUNTRY</th>		
                            <th id="province">PROVINCE</th>		
                            <th id="locality">LOCALITY</th>		
                            <th id="site">SITE</th>		
                            <th id="location">LOCATION</th>		
                            <th id="longitude">LONGITUDE</th>		
                            <th id="latitude">LATITUDE</th>		
                            <th id="date">DATE</th>		
                            <th id="method">METHOD</th>		
                            <th id ="depth">DEPTH</th>		
                            <th id="bs1">BS1</th>	
                            <th id="bs2">BS2</th>	
                            <th id="bs3">BS3</th>	
                            <th id="dips1">DIPS1</th>		
                            <th id="dips2">DIPS2</th>		
                            <th id="dips3">DIPS3</th>		
                            <th id="s1">S1</th>	
                            <th id="s2">S2</th>	
                            <th id="s3">S3</th>	
                            <th id="sob">SOB</th>		
                            <th id="sx">SX</th>	
                            <th id="sy">SY</th>	
                            <th id="sz">SZ</th>	
                            <th id="sxy">SXY</th>	
                            <th id="sxz">SYZ</th>	
                            <th id="szx">SZX</th>	
                            <th id="sh1">SH1</th>	
                            <th id="sh3">SH3</th>	
                            <th id="bsh1">BSH1</th>		
                            <th id="k1">K1</th>	
                            <th id="k3">K3</th>	
                            <th id="kx">KX</th>	
                            <th id="kz">KZ</th>	
                            <th id="no">NO</th>	
                            <th id="e">E</th>	
                            <th id="pr">PR</th>	
                            <th id="rock">ROCK</th>		
                            <th id="seq">SEQ</th>	
                            <th id="reff">REFF</th>		
                            <th>NOTES</th>		
                            <th id="avgb">AVGB</th>	
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach items="${listStressMeasurements}" var="list">
                            <tr>
                                <td><c:out value="${list.smId}" /></td>
                                <td><c:out value="${list.avg}" /></td>
                                <td><c:out value="${list.gg}" /></td>
                                <td><c:out value="${list.ig}" /></td>
                                <td> <button name="button1" id="button1" value="${list.smId}"><c:out value="${list.country}" /></button></td>
                                <td><c:out value="${list.province}" /></td>
                                <td><c:out value="${list.locality}" /></td>
                                <td><c:out value="${list.site}" /></td>
                                <td><c:out value="${list.location}" /></td>
                                <td><c:out value="${list.longitude}" /></td>
                                <td><c:out value="${list.latitude}" /></td>  
                                
                                <td><fmt:formatDate pattern="dd/MM/yyyy" 
            value="${list.date}" /></td>
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
            </div>

    </div>
  </body>
</html>
