<%-- 
    Document   : measurementList_us
    Created on : 05 Dec 2016, 10:42:30 AM
    Author     : LQwabe
--%>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Central Stress Measurement Record</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

        <!-- to change the theme replace "redmond" with "le-frog", "start", "ui-lightness" or "smoothness"  -->
        <style type="text/css" title="currentStyle">
            @import "media/css/demo_page.css";
            @import "media/css/demo_table_jui.css";
            @import "media/css/redmond/jquery-ui.custom.css";
        </style>

        <!-- <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">-->
        <!--        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />-->
        <link href="css/jquery.datatables.yadcf.css" rel="stylesheet" type="text/css" />
        <script src="media/js/jquery-ui.lightness.min.js" type="text/javascript"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script type="text/javascript" charset="utf8" src="js/jquery.dataTables.min.js"></script>
        <script src="js/jquery.dataTables.yadcf.js"></script>
        <script src="js/tableHeadFixer.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
            <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
            <script src="js/bootstrap.min.js"></script>

            <script type="text/javascript" src="js/tableExport.js"></script>
            <script type="text/javascript" src="js/jquery.base64.js"></script>
            <script type="text/javascript" src="js/FileSaver.min.js"></script>
            <script type="text/javascript" src="jspdf/libs/sprintf.js"></script>
            <script type="text/javascript" src="jspdf/jspdf.js"></script>
            <script type="text/javascript" src="jspdf/jspdf.min.js"></script>
            <script type="text/javascript" src="jspdf/jspdf.plugin.autotable.js"></script>
            <script type="text/javascript" src="jspdf/libs/base64.js"></script>
            <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBQZWgKPoDDQ_RYDhmls5AivINjg6boL8Isensor=false"></script>

            <script type="text/javascript" src="testJs/jquery.dataTables.min.js"></script>
            <script type="text/javascript" src="testJs/dataTables.buttons.min.js"></script>
            <script type="text/javascript" src="testJs/buttons.flash.min.js"></script>
            <script type="text/javascript" src="testJs/jszip.min.js"></script>
            <script type="text/javascript" src="testJs/pdfmake.min.js"></script>
            <script type="text/javascript" src="testJs/vfs_fonts.js"></script>
            <script type="text/javascript" src="testJs/buttons.html5.min.js"></script>
            <script type="text/javascript" src="testJs/buttons.print.min.js"></script>
            <script type="text/javascript" src="testJs/buttons.colVis.min.js"></script>

            <!--        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css"/>-->
            <link rel="stylesheet" type="text/css" href="css/buttons.dataTables.min.css"/>


            <script type="text/javascript">
                $(document).ready(function () {
                    $("#measurements tr").click(function () {
                        $("#measurements tr").css("background-color", "white");
                        $(this).css("background-color", "#ddd");
                    });
                });

            </script>




            <script type="text/javascript">

                $(document).ready(function () {
                    /* TOGGLE FUNCTION */
                    $(".toggle").on("click", function () {
                        var elm = $("#" + $(this).data("toggle"));
                        if (elm.is(":visible"))
                            elm.addClass("hidden").removeClass("show");
                        else
                            elm.addClass("show").removeClass("hidden");

                        return false;
                    });
                });
            </script>
            <style type="text/css">
                body {
                    background-image: url("images/white_background.jpg");
                }
                .containerDiv {
                    /*	width: 30em;*/
                    height: 300px;
                    /*                    overflow-x: auto;*/
                    white-space: nowrap;

                    background: #5c9ccc url(images/ui-bg_gloss-wave_55_5c9ccc_500x100.png) 20% 20% repeat-x;

                    font-weight: bold;
                    -moz-box-shadow:    inset 0 0 10px #000000;
                    -webkit-box-shadow: inset 0 0 10px #000000;
                    box-shadow:         inset 0 0 10px #000000;
                }


                .loader {
                    position: fixed;
                    left: 0px;
                    top: 0px;
                    width: 100%;
                    height: 100%;
                    z-index: 9999;
                    background: url('images/page-loader.gif') 50% 50% no-repeat rgb(249,249,249);
                }
                label {

                    font-weight: bold;}
                tfoot input, textarea, select{
                    width:150px;
                    font-weight: bold;
                    -moz-border-radius: 4px; border-radius: 4px;
                    border: 1px solid #555555 }
                table.scroll {
                    width: 100%;
                    /* border-collapse: collapse; */
                    border-spacing: 0;
                    border: 0px solid black;
                }

                table.scroll tbody,
                table.scroll thead { display: block; }

                table.scroll thead tr th { 
                    height: 20px;
                    line-height: 30px;
                    text-align: left;
                }

                table.scroll tbody {
                    height: 250px;
                    overflow-y: auto;

                }

                table.scroll tbody { border-top: 0px solid black; }

                table.scroll tbody td, thead th {
                    width: 290px;  
                    border-right: 0px solid black;
                }

                table.scroll tbody td:last-child, thead th:last-child {
                    border-right: none;
                }
                label {
                    font-weight: bold;
                    color: #2e6e9e;
                }
                tfoot input, textarea, select{
                    width:150px;
                    font-weight: bold;
                    color: #2e6e9e;
                    -moz-border-radius: 4px; border-radius: 4px;
                    border: 1px solid #2e6e9e }

                .dt-button-collection a.buttons-columnVisibility:before,
                .dt-button-collection a.buttons-columnVisibility.active span:before {
                    display:block;
                    position:absolute;
                    top:1.2em;
                    left:0;
                    width:12px;
                    height:12px;
                    box-sizing:border-box;
                }

                .dt-button-collection a.buttons-columnVisibility:before {
                    content:' ';
                    margin-top:-6px;
                    margin-left:10px;
                    border:1px solid black;
                    border-radius:3px;
                }

                .dt-button-collection a.buttons-columnVisibility.active span:before {
                    content:'\2714';
                    margin-top:-11px;
                    margin-left:12px;
                    text-align:center;
                    text-shadow:1px 1px #DDD, -1px -1px #DDD, 1px -1px #DDD, -1px 1px #DDD;
                }

                .dt-button-collection a.buttons-columnVisibility span {
                    margin-left:20px;    
                }
                #parent {
                    /*                    height: 500px;
                                                            background:url(images/body_background.jpg);
                                        overflow:hidden;
                                        width: 100%; 
                                        overflow: auto;
                                        z-index: -1;*/

                }

                #measurements {
                    width: 100% !important;
                    height: 500px;
                    /*                    background:url(images/body_background.jpg);*/
                }
                #measurements tbody {

                    overflow-y: auto;
                    overflow-x: hidden;
                }

                #measurements tr {
                    cursor: pointer;}


                #measurements_filter 
                {
                    display:none;
                }
                .dataTables_length
                {
                    visibility: hidden;
                }
                .dataTables_paginate{


                }.buttons-collection{
                    display: inline-table;

                }
                .glyphicon-refresh-animate {
                    -webkit-animation-name: rotateThis;
                    -webkit-animation-duration: 2s;
                    -webkit-animation-iteration-count: infinite;
                    -webkit-animation-timing-function: linear;
                }

                #myContent {
                    display:none;
                }

                #map {
                    height: 200px;
                    width: 400px;
                    display: none;
                }
                div.container {
                    min-width: 980px;
                    margin: 0 auto;
                }
                #button1 {
                    background-color: Transparent;
                    background-repeat:no-repeat;
                    border: none;
                    cursor:pointer;
                    overflow: hidden;
                    outline:none;
                }
                .dataTables_info{
                    font-weight: bold;
                    color:black;
                    font-size: 12px;

                }
            </style>
            <script type="text/javascript">
                $(document).ready(function () {
                    $("#update").on("click", function (e) {
                        var $icon = $(this).find(".glyphicon.glyphicon-refresh"),
                                animateClass = "glyphicon-refresh-animate";

                        $icon.addClass(animateClass);
                        // setTimeout is to indicate some async operation
                        window.setTimeout(function () {
                            $icon.removeClass(animateClass);
                        }, 9000);
                    });

                });
            </script>
            <script type="text/javascript">
//                $(document).ready(function () {
//                    $("#measurements").tableHeadFixer({
//                        "left": 5});
//                });
            </script>
            <script type="text/javascript">
                $(document).ready(function () {
                    $("#measurements").dataTable(({
                        "bJQueryUI": true,
                        "scrollY": "200px",
                        scrollX: '50vh',
                        fixedHeader: true,
                        scrollCollapse: true,
                        "pagingType": "full_numbers",
                        "pageLength": 50,
                        "sPaginationType": "full_numbers",
                        dom: 'Bfrtip',
                        buttons: [
                            {
                                extend: 'collection',
                                text: ' <p style="font-size:11px" >  <i   style="font-size:11px" class="fa fa-th-list"></i> Export<p>',
                                buttons: [
                                    {
                                        extend: 'copy',
                                        text: '<i   style="font-size:15px" class="fa fa-copy"></i> Copy',
                                        exportOptions: {
                                            columns: ':visible'
                                        }
                                    },
                                    {
                                        extend: 'excelHtml5',
                                        text: '<i   style="font-size:15px" class="fa fa-file-excel-o"></i> Excel',
                                        title: 'Data export',
                                        exportOptions: {
                                            columns: ':visible'
                                        }
                                    },
                                    {
                                        extend: 'csvHtml5',
                                        text: '<i   style="font-size:15px" class="fa fa-file-text-o"></i> CSV',
                                        title: 'Data export',
                                        exportOptions: {
                                            columns: ':visible'
                                        }
                                    }
                                ]
                            },
                            {
                                extend: 'colvis',
                                text: ' <p style="font-size:11px" >  <i   style="font-size:11px" class="fa fa-cog"></i> Show/Hide Columns<p>',
                                postfixButtons: ['colvisRestore'],
                                columns: ':not(.disable)',
                                collectionLayout: 'fixed four-column'
                            }

                        ],
                        columnDefs: [{
                                targets: -1,
                                visible: false
                            }]

                    })).yadcf([
                        {column_number: 4, data: ["Botswana", "Lesotho", "Namibia", "Malawi", "Mozambique", "Mozambique off-sho", "SA Offshore", "South Africa", "Tanzania", "Zambia", "Zimbabwe"], filter_type: "multi_select", filter_default_label: "--select--", filter_container_id: "country"},
                        {column_number: 5, filter_type: "multi_select", filter_default_label: "--select-- ", filter_container_id: "province"},
                        {column_number: 6, filter_type: "multi_select", filter_default_label: "--select--", filter_container_id: "locality"},
                        {column_number: 7, filter_type: "multi_select", filter_default_label: "--select--", filter_container_id: "site"},
                        {column_number: 8, filter_type: "multi_select", filter_default_label: "--select-- ", filter_container_id: "location"},
                        {column_number: 11, filter_type: "range_date", filter_container_id: "date"},
                        {column_number: 12, filter_type: "multi_select", filter_default_label: "--select--", filter_container_id: "method"},
                        {column_number: 13, filter_type: "range_number", filter_container_id: "depth"},
                        {column_number: 14, filter_type: "range_number", filter_container_id: "bs1"},
                        {column_number: 15, filter_type: "range_number", filter_container_id: "bs2"},
                        {column_number: 16, filter_type: "range_number", filter_container_id: "bs3"},
                        {column_number: 17, filter_type: "range_number", filter_container_id: "dips1"},
                        {column_number: 18, filter_type: "range_number", filter_container_id: "dips2"},
                        {column_number: 19, filter_type: "range_number", filter_container_id: "dips3"},
                        {column_number: 20, filter_type: "range_number", filter_container_id: "s1"},
                        {column_number: 21, filter_type: "range_number", filter_container_id: "s2"},
                        {column_number: 22, filter_type: "range_number", filter_container_id: "s3"},
                        {column_number: 23, filter_type: "range_number", filter_container_id: "sob"},
                        {column_number: 24, filter_type: "range_number", filter_container_id: "sx"},
                        {column_number: 25, filter_type: "range_number", filter_container_id: "sy"},
                        {column_number: 26, filter_type: "range_number", filter_container_id: "sz"},
                        {column_number: 27, filter_type: "range_number", filter_container_id: "sxy"},
                        {column_number: 28, filter_type: "range_number", filter_container_id: "syz"},
                        {column_number: 29, filter_type: "range_number", filter_container_id: "szx"},
                        {column_number: 30, filter_type: "range_number", filter_container_id: "sh1"},
                        {column_number: 31, filter_type: "range_number", filter_container_id: "sh3"},
                        {column_number: 32, filter_type: "range_number", filter_container_id: "bsh1"},
                        {column_number: 33, filter_type: "range_number", filter_container_id: "k1"},
                        {column_number: 34, filter_type: "range_number", filter_container_id: "k3"},
                        {column_number: 35, filter_type: "range_number", filter_container_id: "kx"},
                        {column_number: 36, filter_type: "range_number", filter_container_id: "kz"},
                        {column_number: 37, filter_type: "range_number", filter_container_id: "no"},
                        {column_number: 38, filter_type: "range_number", filter_container_id: "e"},
                        {column_number: 39, filter_type: "range_number", filter_container_id: "pr"},
                        {column_number: 40, filter_type: "multi_select", filter_default_label: "--select--", filter_container_id: "rock"},
                        {column_number: 41, filter_type: "multi_select", filter_default_label: "--select--", filter_container_id: "seq"}
                    ]);

                    $("#NewPaginationContainer").append($(".dataTables_paginate"));
                    $("#NewPaginationContainer").append($(".dataTables_info"));
//                     $("#bootstrap").append($(".dt-buttons"));
                });
            </script>
            <script type="text/javascript">
                $(document).ready(function () {
                    //To hide the table when Clear All clicked
                    $("#clear_all").click(function () {
                        $('.hide_show').prop('checked', false);
                        $('#measurements tr td, #measurements tr th').hide("fast");
                    });
                    //To show the table when Select all clicked
                    $("#select_all").click(function () {
                        $('.hide_show').prop('checked', true);
                        $('#measurements tr td, #measurements tr th').show("fast");
                    });

                });
            </script>
            <script type="text/javascript">
                function refresh() {
                    window.location = 'measurementList_us.jsp';
                }
            </script>
            <script>
                function toggler(divId) {
                    $("#" + divId).toggle()
                }
            </script>
            <script type="text/javascript">

                var map;

                var latitute = -28.2833;
                var longitute = 26.7667;
                function initMap() {

                    var latlgn = {lat: latitute, lng: longitute};

                    map = new google.maps.Map(document.getElementById('map'), {
                        zoom: 4,
                        center: latlgn
                    });
                }
                $(document).ready(function () {
                    $(document).on('click', "#button1", function (e) {
                        e.preventDefault();
                        //                 $("#users").change(function(){
                        var value = $(this).val();

                        var splitted = null;
                        $.get("data.jsp", {q: value}, function (data) {
                            splitted = data.split(",");
                            longitute = splitted[1];
                            latitute = splitted[2];
//                            $("#javaquery").html(splitted[0]);
                            //                        $("#map_longitute").html(longitute).val();
                            $('#map_longitute').val(longitute);
                            $('#map_latitude').val(latitute);
                            //                        $("#map_latitude").html(latitute).val();;

                            latitute = parseFloat(document.getElementById("map_latitude").value);
                            longitute = parseFloat(document.getElementById("map_longitute").value);
                            var latlgn = {lat: latitute, lng: longitute};
                            map = new google.maps.Map(document.getElementById('map'), {
                                zoom: 4,
                                center: latlgn
                            });
                            var marker = new google.maps.Marker({
                                position: latlgn,
                                map: map,
                                title: "Latitude: " + latitute + " , " + "Longitude: " + longitute
                                        //                    animation: google.maps.Animation.BOUNCE
                            });

                        });

                    });
                });
            </script>

            <script type="text/javascript">
                $(window).load(function () {
                    $(".loader").fadeOut("slow");
                })
            </script>

    </head>
    <body><div class="loader"></div>
        <%StressMeasurementService stressMeasurementService = new StressMeasurementService();
            User user = null;
            if (session.getAttribute("user") != null) {

                user = (User) session.getAttribute("user");
            }

            String firstname = user.getFirstname();
            String lastname = user.getLastname();
            int role = user.getRole();

            String verified = "Yes";
            request.setAttribute("listStressMeasurements", stressMeasurementService.findByVerified(verified));
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
            request.setAttribute("user", user);
            request.setAttribute("role", role);
        %>

        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBQZWgKPoDDQ_RYDhmls5AivINjg6boL8I&callback=initMap">
        </script>

        <!-- Header -->
        <div id="header">
            <div class="shell">
                <!-- Logo + Top Nav -->
                <div id="top">
                    <h1 id="logo" style="font-family: sans-serif; font-weight:bold ">Stress Measurements Record</h1>


                    <div id="top-navigation"> Welcome <a href="#"><strong>${firstname} ${lastname}</strong></a> <span>|</span><a href="#">Profile Settings</a> <span>|</span> <a href="logout.jsp">Log out</a> </div>    </div>   


                <!-- End Logo + Top Nav -->
                <!-- Main Nav -->
                <div id="navigation">
                    <ul>

                        <li><a href="measurementList_us.jsp" class="active"><span>Home</span></a></li>
                        <li><a href="us_notifications.jsp" ><span>Notifications</span></a></li>
                        <li><a href="#"><span>Publications</span></a></li>
                        <li><a href="#"><span>Conferences</span></a></li>
                        <li><a href="#"><span>FAQs</span></a></li>



                    </ul>
                </div>
                <!-- End Main Nav -->
            </div>
        </div>
        <hr style="height:3px;border:none;color:#5c9ccc;background-color:#5c9ccc; " />
        <!-- End Header -->
        <!-- Container -->
        <div id="container"></div>
        <div class="shell">
            <!-- Small Nav -->
            <div class="small-nav"> <a href="measurementList_us.jsp">Home</a> <span>&gt;</span>Measurements Record </div>
            <!-- End Small Nav -->
        </div>
        <!--        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>-->
        <div align="right" ><a href="newEntry.jsp"  class="add-button" ><span><b>Add New Record</b></span></a></div>





        <!--        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>-->
         <div  class="container" style="height:560px; overflow: auto;">
            <div class="row">
                <div class="col-md-12">

                    <table id="bootstrap" style="float: left;">
                        <tr>
                            <td> <button onclick="toggler('map'); initMap();"  type="button" id="update_two" class="button"><i class="glyphicon glyphicon-cog"></i>Show Maps</button></td>
                            <td> <button onclick="refresh()" style="float: right;" type="button" id="update" class="button "><i class="glyphicon glyphicon-refresh"></i> Refresh</button></td>
                        </tr>
                    </table>

                    <script>
                        $("#update_two").click(function () {
                            $(this).text(function (i, v) {
                                return v === 'Hide Maps' ? 'Show Maps' : 'Hide Maps'
                            })
                        });
                    </script>
                    <center>


                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <div id="map"></div> 
                        <div ><input type="hidden" id="map_longitute" value=""></div>
                        <div ><input type="hidden" id="map_latitude" value=""></div>
                    </center> 
                </div>
                <br/>
                <br/>
                <div  id="parent" >
                    <div class="containerDiv">
                        <table id="measurements" class="display" width="100%">

                            <thead style="background-color: white;">
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
                                    <th>Supporting Document</th>
                                    <th class="disable">AVGB</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listStressMeasurements}" var="list">
                                    <fmt:formatDate value='${list.date}' pattern='dd/MM/yyyy' var="date" />
                                    <c:set var="fileUploaded" value="${list.fileUploaded}" />

                                    <tr class="first">

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
                                        <c:if test="${empty fileUploaded}">
                                            <td nowrap align="center">No document</td> 
                                        </c:if>
                                        <c:if test="${not empty fileUploaded}">
                                            <td nowrap align="center"> <a href="DownloadServlet?action=us_download&smId=<c:out value="${list.smId}"/>" >Download</a></td>
                                        </c:if> 
                                        <td nowrap align="center"><c:out value="${list.avgb}" /></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div id="NewPaginationContainer"></div>
                <div style="overflow: scroll; width: 100%; overflow: auto">
                    <table>
                        <tfoot>
                            <tr>
                                <th id="sm_id"></th>	
                                <th id="avg" ></th>	
                                <th id="gg"></th>	
                                <th id="ig">Filter By</th>
                                <th id="country">COUNTRY</th>		
                                <th id="province">PROVINCE</th>		
                                <th id="locality">LOCALITY</th>		
                                <th id="site">SITE</th>		
                                <th id="location">LOCATION</th>		
                                <th id="longitude"></th>		
                                <th id="latitude"></th>		
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
                                <th id="syz">SYZ</th>	
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
                                <th id="reff"></th>		
                                <th></th>		
                                <th id="avgb"></th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
        <!-- End Container -->
        <!-- Footer -->
        <div id="footer">
            <div  style="text-align: center;"> Copyright &copy; CSIR 2017. All Rights Reserved.</div>
        </div>
        <!-- End Footer -->
    </body>
</html>
