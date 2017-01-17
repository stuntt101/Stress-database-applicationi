<%-- 
    Document   : newjsp
    Created on : 12 Jan 2017, 9:11:24 AM
    Author     : LQwabe
--%>

<%@page import="java.util.List"%>
<%@page import="com.stressmeasurement.service.StressMeasurementService"%>
<%@page import="com.stressmeasurement.entity.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>New Record</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.autocomplete.js"></script>
        <script src="js/jquery-editable-select.js"></script>
        <link rel="stylesheet" type="text/css" href="css/main.css" /> 
        <link rel="stylesheet" type="text/css" href="css/jquery-editable-select.css" />
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />


        <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
              rel = "stylesheet">

        <script type="text/javascript">
            function showTd(elem) {
                if (elem.value == "South Africa") {
                    document.getElementById('hide_td1').style.display = "table-cell";
                    document.getElementById('province').style.display = "table-cell";
                } else {
                    document.getElementById('hide_td1').style.display = "none";
                    document.getElementById('province').style.display = "none";
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

<style>
        label {
            color: #B4886B;
            font-weight: bold;
            font-size:13px;
            font:  HelveticaNeue, Verdana, Arial,bold, Helvetica, sans-serif;
            display: block;
            width: 85px;
            float: left;
        }
        input, textarea, select { float: left;
                                  width:150px;
                                  -moz-border-radius: 4px; border-radius: 4px;
                                  border: 1px solid #BB221E }
        </style>

</head>
<body>
    <%StressMeasurementService stressMeasurementService = new StressMeasurementService();
                List<String> list = stressMeasurementService.getAllCountries();
                request.setAttribute("countries", list);
            %>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- Header -->
<div id="header">
  <div class="shell">
    <!-- Logo + Top Nav -->
    <div id="top">
      <h1 id="logo" >Stress Measurements Record</h1>
      <div id="top-navigation">  <span></span> <a href="#">Help</a> </div>
    </div>
    <!-- End Logo + Top Nav -->
    <!-- Main Nav -->
    <div id="navigation">
      <ul>
        <li><a href="/StressMeasurement" class="active"><span>Home</span></a></li>
        <li><a href="#"><span>Publications</span></a></li>
        <li><a href="#"><span>Conferences</span></a></li>
        <li><a href="#"><span>FAQs</span></a></li>
        <li><a href="#"><span>Photo Gallery</span></a></li>
        
      </ul>
    </div>
    <!-- End Main Nav -->
  </div>
</div>
<!-- End Header -->
<!-- Container -->


<div id="container">
  <div class="shell">
    <!-- Small Nav -->
    <div class="small-nav"> <a href="/StressMeasurement">Home</a> <span>&gt;</span> New Record</div>
    <!-- End Small Nav -->
     </div>
    <br />
    <br />
    <br />
     <center>
         <!-- Message Error -->
    
    <!-- End Message Error -->
    <!-- Main -->
    <div id="main">
         </div>
      <div class="cl">&nbsp;</div>
      <!-- Content -->
      <center>
      <div id="login" style="width: 1000px;height: 600px; ">

    
          <!-- Box -->
        <div class="box">
          <!-- Box Head -->
          <div class="box-head">
            <h2 class="left"><strong>New Record</strong></h2>
          </div>
          <!-- End Box Head-->
          <div class="box-content"> 
            <div class="cl">&nbsp;</div>
            <form action="RegisterStressMeasurements" method="POST">
            <fieldset>
                <center>
                    <table  cellpadding = "2" cellspacing="7" >
                        <tbody>
                            <tr>
                                 <td><label>COUNTRY</label></td><td><select  id="country" name="country"onchange="showTd(this)">
                                    <option selected value="">Select Country</option>
                                    <c:forEach items="${countries}" var="list">
                                        <option value="<c:out value="${list}"/>"><c:out value="${list}"/></option>
                                    </c:forEach>
                                </select> 
                            </td>
                                
                                 <td><label>METHOD</label></td><td><input type="text" id="method" name="method"/> </td>
                      <td><label>LONGITUDE</label></td><td><input type="text" id="longitude"  name="longitude" ></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>

                            </tr>
                            <tr>
                               
                            <td  ><label id="hide_td1" style="display: none;">PROVINCE</label></td><td  ><select  style="display: none;"id="province"  name="province">
                                    <option value="">Select Province</option> 
                                    <option value="G"/>Gauteng</option>
                                    <option value="KZN"/>KwaZulu-Natal</option>
                                    <option value="WC"/>Western Cape</option>
                                    <option value="EC"/>Eastern Cape</option>
                                    <option value="NC"/>Northern Cape</option>
                                    <option value="FS"/>Free State</option>
                                    <option value="MP"/>Mpumalanga</option>
                                    <option value="NP"/>Limpopo (Northern Province)</option>
                                    <option value="NW"/>North West</option>
                                </select> 
                            </td>
                            <td><label>IG</label></td><td><input type="text"  id="ig" name="ig"/> </td>
                            <td><label>LATITUDE</label></td><td><input type="text" id="latitude"  name="latitude"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                                                       

                            
                        </tr>
                        <tr>

                            <td><label>LOCALITY</label></td><td><input type="text" id="locality" name="locality"/> </td>
                      <td><label>GG</label></td><td><input type="text" id="gg" name="gg" /> </td> 
                      <td><label>DEPTH</label></td><td><input type="text"  id="depth"  name="depth"></input><span style="margin-left:-35px; color: #bdbdbd;">(m)</span> </td>
                        </tr>


                        <tr>
                          <td><label>SITE</label></td><td><input type="text" id="site" name="site"/> </td>
                           
                             <td><label title="This is my tooltip">AVG</label></td><td><input type="text" id="avg" name="avg"/> </td>
                                                         <td><label>DATE</label></td><td><input type="text" id="date" name="date" /> </td>

                            
                           

                        </tr>
                        <tr> 
                           <td><label>LOCATION</label></td><td><input type="text" id="location" name="location"/> </td>
                           <td></td><td></td>
                            <td></td><td></td>
                            <td></td><td></td>
                        </tr> 
                    </tbody>
                </table>
            </center>
        </fieldset>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <fieldset>
            <center>
                <table  cellpadding = "2" cellspacing="7" >
                    <tbody>
                        <tr>

                            <td><label>BS3</label></td><td><input type="text" id="bs3"  name="bs3" ></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                            <td><label>DIPS1</label></td><td><input type="text" id="dips1"  name="dips1" ></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                            <td><label>DIPS2</label></td><td><input type="text"  id="dips2"  name="dips2"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                        </tr>
                        <tr>

                            <td><label>DIPS3</label></td><td><input type="text" id="dips3"  name="dips3"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                            <td><label>S1</label></td><td><input type="text"  id="s1"  name="s1"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>S2</label></td><td><input type="text" id="s2"  name="s2"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>

                        </tr>
                        <tr>

                            <td><label>S3</label></td><td><input type="text"  id="s3"  name="s3"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SOB</label></td><td><input type="text" id="sob"  name="sob"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SX</label></td><td><input type="text" id="sx"  name="sx"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                        </tr>
                        <tr>

                            <td><label>SY</label></td><td><input type="text" id="sy"  name="sy"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SZ</label></td><td><input type="text" id="sz"  name="sz"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SXY</label></td><td><input type="text" id="sxy"  name="sxy"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span></td>
                        </tr>

                        <tr>

                            <td><label>SYZ</label></td><td><input type="text" id="syz"  name="syz"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SZX</label></td><td><input type="text" id="szx"  name="szx"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>SH1</label></td><td><input type="text" id="sh1"  name="sh1"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                        </tr>
                    </tbody>
                </table>
            </center>
        </fieldset>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <fieldset>
            <center>
                <table  cellpadding = "2" cellspacing="7" >
                    <tbody>
                        <tr>

                            <td><label>SH3</label></td><td><input type="text" id="sh3"  name="sh3"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>BSH1</label></td><td><input type="text" id="bsh1"  name="bsh1"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            <td><label>K1</label></td><td><input type="text" id="k1"  name="k1"/> </td>
                        </tr>
                        <tr>

                            <td><label>K3</label></td><td><input type="text" id="k3"  name="k3"/> </td>
                            <td><label>KX</label></td><td><input type="text" id="kx"  name="kx"/> </td>
                            <td><label>KZ</label></td><td><input type="text" id="kz"  name="kz"/> </td>
                        </tr>
                        <tr>

                            <td><label>NO</label></td><td><input type="text" id="no"  name="no"/> </td>
                            <td><label>E</label></td><td><input type="text" id="e"  name="e"></input><span style="margin-left:-35px; color: #bdbdbd;">GPa</span> </td>
                            <td><label>PR</label></td><td><input type="text" id="pr"  name="pr"/> </td>
                        </tr>
                        <tr>

                            <td><label>ROCK</label></td><td><input type="text" id="rock" name="rock"/> </td>
                            <td><label>SEQ</label></td><td><input type="text" id="seq" name="seq"/> </td>
                            <td><label>REFF</label></td><td><input type="text" id="reff" name="reff"/> </td>
                        </tr>
                        <tr>

                            <td><label>NOTES</label></td><td><textarea type="text" id="notes"  name="notes"/></textarea> </td>
                            <td><label>AVGB</label></td><td><input type="text" id="avgb"  name="avgb"/> </td>
                            <td><label></label></td><td> </td>
                        </tr>
                    <tbody>
                </table>
            </center>
        </fieldset>
         <center>
           
             <button type="reset" class="button"name="clear_text" value="Clear All"/>Clear All</button>
             <button type="submit"  class="button"name="submit"  />Save</button>
            
           </center>
        </form>
            </div>
            
          </div>
        </div>
      </center>
        <!-- End Box -->
        
     </center>
      <!-- End Content -->
      <!-- Sidebar -->
      <div id="sidebar">
        
      </div>
      <!-- End Sidebar -->
      <div class="cl">&nbsp;</div>
   
    <!-- Main -->
  </div>

<!-- End Container -->
<!-- Footer -->
<div id="footer">
  <div class="shell" style="text-align: center;"> <span class="center">Copyright &copy; CSIR 2017. All Rights Reserved.</span> <span class="right"></span> </div>
</div>
<!-- End Footer -->
</body>
</html>
