<%-- 
    Document   : new_user
    Created on : Jan 26, 2017, 12:00:07 AM
    Author     : LQwabe
--%>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.autocomplete.js"></script>
        <script src="js/jquery-editable-select.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css" /> 
        <link rel="stylesheet" type="text/css" href="css/jquery-editable-select.css" />
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />


        <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
              rel = "stylesheet">

        <script type="text/javascript">
            function showTd(elem) {
                if (elem.value == "South Africa") {
                    document.getElementById('hide_province').style.display = "table-row";

                } else {
                    document.getElementById('hide_province').style.display = "none";

                }
                element.style.visiblity = 'inherit';
            }
        </script>
        <script type="text/javascript">
            jQuery(function () {

                $("#location").autocomplete("autocomplete/getLocations.jsp");
                $("#method").autocomplete("autocomplete/getMethods.jsp");
                $("#rock").autocomplete("autocomplete/getRocks.jsp");
                $("#seq").autocomplete("autocomplete/getSeqs.jsp");
                $("#reff").autocomplete("autocomplete/getReffs.jsp");
                $("#site").autocomplete("autocomplete/getSites.jsp");
                $("#locality").autocomplete("autocomplete/getLocalities.jsp");
                $("#gg").autocomplete("autocomplete/getGroupGrades.jsp");

            });
        </script>
        <script type="text/javascript">
//            $(document).ready(function () {
//                $('#country').editableSelect({effects: 'default'});
//            });

        </script>
        <!-- Javascript -->
        <script>
            $(function () {
                $("#date").datepicker({
                    dateFormat: 'yy-mm-dd'
                });

            });
        </script>

        <script>
            $(document).ready(function () {
                $('#Calculate').click(function (event) { 
                    event.preventDefault();
                    $.ajax({
                        url: 'CalculateStress',
                        type: 'post',
                        dataType: 'json',
                        data: {
                            sx: $('#sx').val(),
                            sy: $('#sy').val(),
                            sz: $('#sz').val(),
                            sxy: $('#sxy').val(),
                            syz: $('#syz').val(),
                            szx: $('#szx').val()
                        },
                        success: function (responseText) {

                            $('#s1').val(responseText.s1);
                            $('#s2').val(responseText.s2);
                            $('#s3').val(responseText.s3);
                            $('#bs1').val(responseText.bs1);
                            $('#bs2').val(responseText.bs2);
                            $('#bs3').val(responseText.bs3);
                            $('#dips1').val(responseText.dips1);
                            $('#dips2').val(responseText.dips2);
                            $('#dips3').val(responseText.dips3);
                            $('#bsh1').val(responseText.bsh1);
                            $('#sh1').val(responseText.sh1);
                            $('#sh3').val(responseText.sh3);
                            $('#k1').val(responseText.k1);
                            $('#k3').val(responseText.k3);
                            $('#kx').val(responseText.kx);
                            $('#kz').val(responseText.kz);

                        },
                        error: function (responseText) {

                             alert("Something went wrong " + "Please make sure that Normal stress(Syy) in Y (Up) is not equal to zero "+"Then try again ");
                            // Somehow process the validation messages,
                            // like you seem to be doing already.
                        }
                    });
                });
            });</script> 
        <title>Register New User</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/main.css" type="text/css" media="all" />

        <style>
            label{
                color: #555555;
                font-weight: bold;
                font-size:12px;
                font:  HelveticaNeue, Verdana, Arial,bold, Helvetica, sans-serif;
                display: block;
                /*                width: 60px;*/

            }
            .label1 {
                color: #B4886B;
                font-weight: bold;
                font-size:13px;
                font:  HelveticaNeue, Verdana, Arial,bold, Helvetica, sans-serif;
                display: block;
                width: 150px;

            }
            .label2 {
                color: #B4886B;
                font-weight: bold;
                font-size:13px;
                font:  HelveticaNeue, Verdana, Arial,bold, Helvetica, sans-serif;
                display: block;
                width: 150px;

            }
            .label3 {
                color: #B4886B;
                font-weight: bold;
                font-size:13px;
                font:  HelveticaNeue, Verdana, Arial,bold, Helvetica, sans-serif;
                display: block;
                width: 150px;

            }
            input, textarea, select{ float: left;
                                     width:150px;
                                     -moz-border-radius: 4px; border-radius: 4px;
                                     border: 1px solid #555555 }
            .button2 { float: left;
                       width:150px;
                       -moz-border-radius: 4px; border-radius: 4px;
                       border: 1px solid #fff }
            .floatedTable {
                float:left;
            }
            .inlineTable {
                display: inline-block;
            }


            .formLegend { 

                background-color: #B4886B;
                font-weight: bold;
                font-size:12px;
                color: white; -webkit-border-radius: 4px; 
                -moz-border-radius: 4px; border-radius: 4px;
                box-shadow: 2px 2px 4px #888; 
                -moz-box-shadow: 2px 2px 4px #888;
                -webkit-box-shadow: 2px 2px 4px #888 }
            .dashed_fieldset {
                border: 1px dashed #555555;

            }
            fieldset.inline {
                display: inline;
                margin-right:40px;
                margin-left:40px;
                -webkit-border-radius: 8px; 
                -moz-border-radius: 8px; 
                border-radius:8px;
                box-shadow: 3px 3px 10px #ccc;
                -moz-box-shadow: 3px 3px 10px #ccc; 
                -webkit-box-shadow: 3px 3px 10px #ccc
            }

            fieldset.inline2 {
                -webkit-border-radius: 8px; 
                -moz-border-radius: 8px; 
                border-radius:8px;
                box-shadow: 3px 3px 10px #ccc;
                -moz-box-shadow: 3px 3px 10px #ccc; 
                -webkit-box-shadow: 3px 3px 10px #ccc;

                top: 0px;
                padding-bottom: -75px;

                display: inline-block;/* leave a space to position for the labels */
            }
            .tooltip {

                display: inline;

            }

            .tooltip .tooltiptext {
                visibility: hidden;
                width: 120px;
                background-color: #ba4c32;
                color: #fff;
                font-weight: bold;
                text-align: center;
                border-radius: 6px;
                padding: 5px 0;

                /* Position the tooltip */
                position: absolute;
                z-index: 1;
            }

            .tooltip:hover .tooltiptext {
                visibility: visible;
            }
        </style>

    </head>
    <body>
        <%StressMeasurementService stressMeasurementService = new StressMeasurementService();
            List<String> list = stressMeasurementService.getAllCountries();
            List<StressMeasurement> StressMeasurements = stressMeasurementService.getAllStressMeasurements();
            int new_record_Id = StressMeasurements.size() + 1;
            int new_record_Index = stressMeasurementService.getMaxIndexOfRecord() + 1;
            request.setAttribute("countries", list);
            request.setAttribute("new_record_Id", new_record_Id);
            request.setAttribute("new_record_Index", new_record_Index);
            User user;

            if (session.getAttribute("admin")!= null) {
                user = (User) session.getAttribute("admin");
                String firstname = user.getFirstname();
                String lastname = user.getLastname();
                request.setAttribute("firstname", firstname);
                request.setAttribute("lastname", lastname);
                request.setAttribute("user", user);
            } else {

                request.setAttribute("session_expired", "session_expired");
            }


        %>
        <c:if test="${not empty session_expired}">
            <script type="text/javascript" >

                alert('Your session has expired. please login again.');
                location = 'measurementList.jsp';
            </script>
        </c:if>
        <!-- Header -->
        <div id="header">
            <div class="shell">
                <!-- Logo + Top Nav -->
                <div id="top">
                    <h1 id="logo" style="font-family: sans-serif; font-weight:bold ">Stress Measurements Record</h1>

                    <div id="top-navigation"> <a href="#"><strong><b>Administrator </b></strong></a> <span><b>|</b></span> <a href="#">Help</a> <span><b>|</b></span> <a href="#">Profile Settings</a> <span><b>|</b></span> <a href="logout.jsp">Log out</a> </div>
                </div>
                <!-- End Logo + Top Nav -->
                <!-- Main Nav -->
                <div id="navigation">
                    <ul>
                        <li><a href="measurementList_ad.jsp" ><span>Home</span></a></li>
                        <li><a href="ad_notifications.jsp" class="active"><span>Notifications</span></a></li>
                        <li><a href="list_users.jsp"><span>User Management</span></a></li>
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

        <div id="container">
            <div class="shell">
                <!-- Small Nav -->
                <div class="small-nav"> <a href="measurementList_ad.jsp">Home</a> <span>&gt;</span> New User</div>
                <!-- End Small Nav -->
            </div>
            <!-- Content -->
            <center>
                <div id="login" style="width: 1000px;height: 400px; ">

                    <!-- Box -->
                    <div class="box">
                        <!-- Box Head -->
                        <div class="box-head">
                            <h2 class="left"><strong>New User</strong></h2>
                        </div>
                        <!-- End Box Head-->
                        <div class="box-content"> 
                            <div class="cl">&nbsp;</div>
                            <fieldset class="dashed_fieldset">
                                <br/>
                                <div style="display:block; width:100%">
                                    <div style="margin:0 auto;">
                                        <center>
                                            <form  id="register_user"    action ="RegisterUser"method="POST"  autocomplete="off">
                                                <table border="0" cellpadding = "2" cellspacing="7">
                                                    <tbody>
                                                        <tr>
                                                            <td><label>Username<span  style="color:red">*</span></label></td> <td><input type="text" name="username" maxlength="45" class="form-control"  required/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><label>Password<span  style="color:red">*</span></label></td> <td><input type="text" id="password"  name="password" maxlength="45" class="form-control"  required/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><label>First Name<span  style="color:red">*</span></label></td> <td><input type="text" id="firstName" name="firstName" maxlength="45" class="form-control" required/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><label>Last Name<span  style="color:red">*</span></label></td> <td><input type="text"  id="lastName" name="lastName" maxlength="45" class="form-control" required/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><label>Email Address<span  style="color:red">*</span></label></td> <td><input type="text" id="emailAddress"   name="emailAddress" maxlength="45" required /></td>
                                                        </tr>
                                                        <tr>
                                                            <td><label>Mine Name<span  style="color:red">*</span></label></td> <td><input type="text" id="mineName" name="mineName" maxlength="45"  /></td>
                                                        </tr>
                                                        <tr>
                                                            <td><label>Role<span  style="color:red">*</span></label></td> 
                                                            <td><select id="role" name= "role"  required > 
                                                                    <option value="">Select Role</option>

                                                                    <option value="1"> Admin</option>
                                                                    <option value="0"> Other</option>  


                                                                </select>        </td>
                                                        </tr>

                                                        <tr>
                                                            <td></td> <td><button  class="button" name ="action" value="addUser"  >Save</button> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<button type="reset" class="button"name="clear_text" value="Clear All">Clear All</button></td>
                                                        </tr>

                                                    </tbody>
                                                </table>
                                            </form>
                                        </center>
                                    </div>
                                </div> 
                                <center>

                                    &nbsp;
                                </center>

                                <p><span style="color:red; font-weight: bold;">* required field.</span></p>
                            </fieldset>
                            <br/>
                        </div>
                    </div> 
            </center>
            <br/>

        </div>
    </div>
</div>
</center>
<!-- End Box -->
</div>
<!-- End Container -->
<!-- Footer -->
<div id="footer">
    <div class="" style="text-align: center;"> <span class="center">Copyright &copy; CSIR 2017. All Rights Reserved.</span> <span class="right"></span> </div>
</div>
<!-- End Footer -->
</body>
</html>
