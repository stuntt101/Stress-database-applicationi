<%-- 
    Document   : measurementList
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
/*            @import "media/css/demo_page.css";*/
            @import "media/css/demo_table_jui.css";
            @import "media/css/redmond/jquery-ui.custom.css";
        </style>
        <!--         <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">-->
        <!--                <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />-->
        <link href="css/jquery.datatables.yadcf.css" rel="stylesheet" type="text/css" />
        <script src="media/js/jquery-ui.lightness.min.js" type="text/javascript"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script type="text/javascript" charset="utf8" src="js/jquery.dataTables.min.js"></script>
        <script src="js/jquery.dataTables.yadcf.js"></script>
        <script src="js/tableHeadFixer.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
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
                #parent {
                    height: 380px;
/*                    background:url(images/body_background.jpg);*/
                    overflow:hidden;
                   width: 100%; 
                    overflow: auto;
                    z-index: -1;

                }

                #measurements {
                    width: 100% !important;
/*                    background:url(images/body_background.jpg);*/
                }
               #measurements tbody {
    
    overflow-y: auto;
    overflow-x: hidden;
}
                #measurements_filter 
                {
                    display:none;
                }
                .dataTables_length
                {
                    visibility: hidden;
                }
                .dataTables_paginate{
                    
                    
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
                $(document).ready(function () {
                    $("#measurements").tableHeadFixer({
                        "left": 5});
                });
            </script>
            <script type="text/javascript">
                $(document).ready(function () {
                    $("#measurements").dataTable(({
                        "bJQueryUI": true,
                         "scrollY":"200px",
                       scrollX: '50vh',
                        fixedHeader: true,
                        scrollCollapse: true,
                        "pagingType": "full_numbers",
                        "sPaginationType": "full_numbers"


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
                        {column_number: 41, filter_type: "multi_select", filter_default_label: "--select--", filter_container_id: "seq"},
                        {column_number: 44, filter_type: "range_number", filter_container_id: "avgb"}

                    ]);
                     $("#NewPaginationContainer").append($(".dataTables_paginate"));
                      $("#NewPaginationContainer").append($(".dataTables_info"));
                     
                    $("#hide_show_all").on("change", function () {
                        var hide = !$(this).is(":checked");
                        $(".hide_show").prop("checked", hide);

                        if (hide) {
                            $('#measurements tr th').hide(100);
                            $('#measurements tr td').hide(100);
                        } else {
                            $('#measurements tr th').show(100);
                            $('#measurements tr td').show(100);
                        }
                    });
                    var tr_hidden = [];
                    $(document).on("click change keyup", ".paginate_button, .sorting_asc input ", function () {
                        console.log(tr_hidden);
                        $('#measurements tr td, #measurements tr th').show();
                        $.each(tr_hidden, function (ti) {
                            var i = ti;
                            $('#measurements tr').each(function () {
                                //$('td, th', this).show();
                                $('td:eq(' + i + ')', this).hide();
                                $('th:eq(' + i + ')', this).hide();

                            });
                        });
                    });
                    $(".hide_show").on("click change", function () {
                        var hide = !$(this).is(":checked");

                        var all_ch = $(".hide_show:checked").length == $(".hide_show").length;

                        var ti = $(this).index(".hide_show");

                        $('#measurements tr').each(function () {
                            if (hide) {
                                $('td:eq(' + ti + ')', this).hide(100);
                                $('th:eq(' + ti + ')', this).hide(100);
                                if (tr_hidden.indexOf(ti) == -1)
                                    tr_hidden.push(ti);
                            } else {

                                $('td:eq(' + ti + ')', this).show(100);
                                $('th:eq(' + ti + ')', this).show(100);
                                if (tr_hidden.indexOf(ti) > -1) {
                                    tr_hidden.splice(tr_hidden.indexOf(ti), 1);
                                }
                            }
                        });
                    });

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
                    window.location = 'measurementList.jsp';
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
                            $("#javaquery").html(splitted[0]);
                            //                        $("#map_longitute").html(longitute).val();
                            $('#map_longitute').val(longitute);
                            $('#map_latitude').val(latitute);
                            //                        $("#map_latitude").html(latitute).val();;
                        });
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
            </script>
            <style>
                .containerDiv {
/*	width: 30em;*/
          height: 355px;
	  overflow-x: auto;
	  white-space: nowrap;
         
background: #5c9ccc url(images/ui-bg_gloss-wave_55_5c9ccc_500x100.png) 50% 50% repeat-x;

font-weight: bold;
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
            </style>
            <script type="text/javascript">
                $(window).load(function () {
                    $(".loader").fadeOut("slow");
                })
            </script>
             <script>
                $(document).ready(function () {
                    // Change the selector if needed//
                    var $table = $('table.scroll'),
                            $bodyCells = $table.find('tbody tr:first').children(),
                            colWidth;

// Adjust the width of thead cells when window resizes
                    $(window).resize(function () {
                        // Get the tbody columns width array
                        colWidth = $bodyCells.map(function () {
                            return $(this).width();
                        }).get();

                        // Set the width of thead columns
                        $table.find('thead tr').children().each(function (i, v) {
                            $(v).width(colWidth[i]);
                        });
                    }).resize(); // Trigger resize handler


                });

            </script>

    </head>
    <body>
        <div class="loader"></div>
        <%StressMeasurementService stressMeasurementService = new StressMeasurementService();

            String verified = "Yes";
            request.setAttribute("listStressMeasurements", stressMeasurementService.findByVerified(verified));


        %>  

        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBQZWgKPoDDQ_RYDhmls5AivINjg6boL8I&callback=initMap">
        </script>

        <!-- Header -->
        <div id="header">
            <div class="shell">
                <!-- Logo + Top Nav -->
                <div id="top">
                    <h1 id="logo" style="font-family: sans-serif; font-weight:bold ">Stress Measurements Record</h1>

                    <div id="top-navigation">  <span></span> <a href="#">Help</a> <span>|</span>  <a href="login.jsp">Login</a> </div></div>
                <!-- End Logo + Top Nav -->
                <!-- Main Nav -->
                <div id="navigation">
                    <ul>
                        <li><a href="measurementList.jsp" class="active"><span>Home</span></a></li>
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
            <div class="small-nav"> <a href="measurementList.jsp">Home</a> <span>&gt;</span>Measurements Record </div>
            <!-- End Small Nav -->
        </div>
        <!--        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>-->
        <div  class="container">
            <div class="row">
                <div class="col-md-12">

                    <table id="bootstrap" style="float: left;">
                        <tr>
                            <td><button onclick="toggler('myContent');"  type="button" id="update" class="button "><i class="glyphicon glyphicon-cog"></i>Show/Hide columns</button></td>
                            <td> <button onclick="toggler('map');
                                    initMap();"  type="button" id="update_two" class="button"><i class="glyphicon glyphicon-cog"></i>Show Maps</button></td>
                            <td><div   class="btn-group"><button class="dropdown-toggle button" data-toggle="dropdown"><i class="fa fa-bars "></i> Export Table Data</button>
                                    <ul   class="dropdown-menu " role="menu">
                                        <li><a  onClick ="$('#measurements').tableExport({type: 'xml', escape: 'false'});"> <img src='assets/images/icons/xml.png' width='24px'> XML</a></li>
                                        <li><a  onClick ="$('#measurements').tableExport({type: 'sql'});"> <img src='assets/images/icons/sql.png' width='24px'> SQL</a></li>
                                        <li><a  onClick ="$('#measurements').tableExport({type: 'csv', escape: 'false', footers: 'false'});"> <img src='assets/images/icons/csv.png' width='24px'> CSV</a></li>
                                        <li><a  onClick ="$('#measurements').tableExport({type: 'txt', escape: 'false'});"> <img src='assets/images/icons/txt.png' width='24px'> TXT</a></li>
                                        <li><a  onClick ="$('#measurements').tableExport({type: 'excel', escape: 'false', footers: false});"> <img src='assets/images/icons/xls.png' width='24px'> XLS</a></li>
                                        <li><a  onClick ="$('#measurements').tableExport({type: 'doc', escape: 'false', footers: 'false'});"> <img src='assets/images/icons/word.png' width='24px'> Word</a></li>
                                    </ul>
                                </div> 
                            </td>
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



                    <div id="myContent" >
                        <div> 
                            <br/>


                            <!--                                <p>&nbsp;</p>-->
                            <!-- Content -->
                            <div id="show_content"  >
                                <!-- Box -->
                                <p Style ="color:red;font-weight: bold;">Please  Select Columns and click Show/Hide columns</p>
                                <center > 
                                    <div class="box" >
                                        <!-- Box Head -->
                                        <div class="box-head">
                                            <center> <h2 >Columns</h2> </center> 

                                        </div>
                                        <!-- End Box Head -->
                                        <!-- Table -->
                                        <div class="table">
                                            <table  width=100% border="0" cellspacing="0" cellpadding="0">
                                                <tbody>
                                                    <tr>
                                                        <td><label><input type="checkbox" class="hide_show checkbox" checked="checked"/> SM ID</label></td>
                                                        <td><label><input type="checkbox" class="hide_show checkbox" checked="checked"/> AVG</label></td>
                                                        <td><label><input type="checkbox" class="hide_show checkbox" checked="checked"/> GG</label></td>
                                                        <td><label><input type="checkbox" class="hide_show checkbox"  checked="checked"/> IG</label></td>
                                                        <td><label><input type="checkbox" class="hide_show checkbox" checked="checked"/> COUNTRY</label></td>
                                                        <td><label><input type="checkbox" class="hide_show checkbox" checked="checked"/> PROVINCE</label></td>
                                                        <td><label><input type="checkbox" class="hide_show checkbox" checked="checked"/> LOCALITY</label></td>
                                                        <td><label><input type="checkbox" class="hide_show checkbox" checked="checked"/> SITE</label></td>
                                                        <td><label><input type="checkbox" class="hide_show checkbox" checked="checked"/> LOCATION</label></td>
                                                    </tr>
                                                    <tr>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> LONGITUDE</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> LATITUDE</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> DATE</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> METHOD</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> DEPTH</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> BS1</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> BS2</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> BS3</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked" /> DIPS1</label></td>
                                                    </tr>
                                                    <tr>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> DIPS2</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> DIPS3</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> S1</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> S2</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> S3</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> SOB</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> SX</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> SY</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> SZ</label></td>
                                                    </tr>
                                                    <tr>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> SXY</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> SYZ</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> SZX</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> SH1</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> SH3</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> BSH1</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> K1</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> K3</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> KX</label></td>
                                                    </tr>
                                                    <tr>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> KZ</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> NO</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> E</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> PR</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> ROCK</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> SEQ</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> REFF</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> NOTES</label></td>
                                                        <td><label><input type="checkbox" class="hide_show" checked="checked"/> AVGB</label></td>
                                                    </tr>
                                                    <tr>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>
                                                </tbody>
                                            </table>

                                        </div>
                                        <!-- Table -->
                                        <br />

                                        <div class="row">
                                            <center>
                                                <div class="col-xs-12">
                                                    <button id="clear_all" class="btn btn-warning btn-fltr-clearAll btn-xs button">Clear All</button>
                                                    <button id="select_all"class="btn btn-primary btn-fltr-selectAll btn-xs button">Select All</button>
                                                </div>
                                            </center>
                                            <br />
                                        </div>
                                    </div>
                                </center> 
                                <br />
                                <!-- End Box -->


                                <!-- End Content -->

                            </div>
                        </div> 
                    </div>
                   
                    <center>


                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                        <div id="map">

                        </div> 
                        <div ><input type="hidden" id="map_longitute" value=""></div>
                        <div ><input type="hidden" id="map_latitude" value=""></div>
                    </center>
                    <div class="col-md-12">



                    </div>

                </div>

                <br/>
                <br/>
                <div  id="parent" >
                    <div class="containerDiv">
                   
                    <table id="measurements" class="display " width="100%" >


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
                                <!--                            <th>VERIFIED</th>-->
                            </tr>
                        </thead>
                        <tbody >
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
                                <th id="avgb">AVGB</th>
                            </tr>
                        </tfoot>
                    </table>
                </div>

            </div>
            <!-- Main -->
            <div id="main">
                </dsiv>
                <div class="cl"></div>
                <!-- Content -->
                <center

        </div>

        <!-- End Box -->
        <!-- End Content -->
        <!-- Sidebar -->
        <!-- End Sidebar -->
        <!-- Main -->
        <!-- End Container -->
        <!-- Footer -->
        <div id="footer">
            <div class="shell" style="text-align: center;font-weight: bold"> <span class="center">Copyright &copy; CSIR 2017. All Rights Reserved.</span> <span class="right"></span> </div>
        </div>
        <!-- End Footer -->
</body>
</html>
