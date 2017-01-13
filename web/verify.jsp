<%-- 
    Document   : verify
    Created on : 08 Jan 2017, 12:41:22 PM
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


        <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
              rel = "stylesheet">

        <script type="text/javascript">
            function showTd(elem) {
                if (elem.value == "South Africa") {
                    document.getElementById('hide_td1').style.display = "table-cell";
                    document.getElementById('hide_td2').style.display = "table-cell";
                } else {
                    document.getElementById('hide_td1').style.display = "none";
                    document.getElementById('hide_td2').style.display = "none";
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
            $(document).ready(function () {
                $('#country').editableSelect({effects: 'default'});
            });

        </script>
        <!-- Javascript -->
        <script>
            $(function () {
                $("#date").datepicker({
                    dateFormat: 'yy-mm-dd'
                });

            });
        </script>
        <title>JSP Page</title>
    </head>
    <style>
        label {
            color: #B4886B;
            font-weight: bold;
            font: 90%/1.45em "Helvetica Neue", HelveticaNeue, Verdana, Arial,bold, Helvetica, sans-serif;
            display: block;
            width: 100px;
            float: left;
        }
        input, textarea, select { float: left;
                                  width:150px;
                                  -moz-border-radius: 4px; border-radius: 4px;
                                  border: 1px solid #d9d9d9 }
        </style>
        <body>
            <%StressMeasurementService stressMeasurementService = new StressMeasurementService();
                List<String> list = stressMeasurementService.getAllCountries();
                request.setAttribute("countries", list);
            %>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <form action="StressMeasurementController" method="POST">
                <fieldset>
                    <center>
                        <input type="hidden" id="smId" name="smId" value="${stressMeasurement.smId}"/> 
                    <table >
                        <tbody>
                            <tr>
                                <td><label>AVG</label></td><td><input type="text" id="avg" name="avg" value="${stressMeasurement.avg}"/> </td>
                                <td><label>GG</label></td><td><input type="text" id="gg" name="gg" value="${stressMeasurement.gg}"/> </td>
                                <td><label>IG</label></td><td><input type="text"  id="ig" name="ig" value="${stressMeasurement.ig}"/> </td>
                            </tr>
                            <tr>
                                <td><label>COUNTRY</label></td><td><select id="country" name="country"onchange="showTd(this)">
                                        <option value="<c:out value="${stressMeasurement.country}"/>"><c:out value="${stressMeasurement.country}"/></option>

                                    </select> 
                                </td>


                                <td  id="hide_td1" style="display: none;"><label>PROVINCE</label></td><td  id="hide_td2" style="display: none;"><select id="province"  name="province">
                                        <option value="<c:out value="${stressMeasurement.province}"/>"><c:out value="${stressMeasurement.province}"/></option>
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
                                <td><label>LOCALITY</label></td><td><input type="text" id="locality" name="locality" value="${stressMeasurement.locality}"/> </td>
                            </tr>
                            <tr>

                                <td><label>SITE</label></td><td><input type="text" id="site" name="site" value="${stressMeasurement.site}"/> </td>
                                <td><label>LOCATION</label></td><td><input type="text" id="location" name="location" value="${stressMeasurement.location}"/> </td>
                                <td><label>LONGITUDE</label></td><td><input type="text" id="longitude"  name="longitude"  value="${stressMeasurement.longitude}"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                            </tr>


                            <tr>

                                <td><label>LATITUDE</label></td><td><input type="text" id="latitude"  name="latitude" value="${stressMeasurement.latitude}"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                                <td><label>DATE</label></td><td><input type="text" id="date" name="date"  value="${stressMeasurement.date}"/> </td>
                                <td><label>METHOD</label></td><td><input type="text" id="method" name="method" value="${stressMeasurement.method}"/> </td>

                            </tr>
                            <tr> 

                                <td><label>DEPTH</label></td><td><input type="text"  id="depth"  name="depth" value="${stressMeasurement.depth}"></input><span style="margin-left:-35px; color: #bdbdbd;">(m)</span> </td>
                                <td><label>BS1</label></td><td><input type="text" id="bs1"  name="bs1" value="${stressMeasurement.bs1}"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                                <td><label>BS2</label></td><td><input type="text" id="bs2"  name="bs2" value="${stressMeasurement.bs2}"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                            </tr> 
                        </tbody>
                    </table>
                </center>
            </fieldset>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <fieldset>
                <center>
                    <table>
                        <tbody>
                            <tr>

                                <td><label>BS3</label></td><td><input type="text" id="bs3"  name="bs3" value="${stressMeasurement.bs3}"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                                <td><label>DIPS1</label></td><td><input type="text" id="dips1"  name="dips1" value="${stressMeasurement.dips1}"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                                <td><label>DIPS2</label></td><td><input type="text"  id="dips2"  name="dips2" value="${stressMeasurement.dips2}"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                            </tr>
                            <tr>

                                <td><label>DIPS3</label></td><td><input type="text" id="dips3"  name="dips3" value="${stressMeasurement.dips3}"></input><span style="margin-left:-35px; color: #bdbdbd;">deg</span> </td>
                                <td><label>S1</label></td><td><input type="text"  id="s1"  name="s1" value="${stressMeasurement.s1}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                                <td><label>S2</label></td><td><input type="text" id="s2"  name="s2" value="${stressMeasurement.s2}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>

                            </tr>
                            <tr>

                                <td><label>S3</label></td><td><input type="text"  id="s3"  name="s3" value="${stressMeasurement.s3}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                                <td><label>SOB</label></td><td><input type="text" id="sob"  name="sob" value="${stressMeasurement.sob}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                                <td><label>SX</label></td><td><input type="text" id="sx"  name="sx" value="${stressMeasurement.sx}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            </tr>
                            <tr>

                                <td><label>SY</label></td><td><input type="text" id="sy"  name="sy" value="${stressMeasurement.sy}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                                <td><label>SZ</label></td><td><input type="text" id="sz"  name="sz" value="${stressMeasurement.sz}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                                <td><label>SXY</label></td><td><input type="text" id="sxy"  name="sxy" value="${stressMeasurement.sxy}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span></td>
                            </tr>

                            <tr>

                                <td><label>SYZ</label></td><td><input type="text" id="syz"  name="syz" value="${stressMeasurement.syz}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                                <td><label>SZX</label></td><td><input type="text" id="szx"  name="szx" value="${stressMeasurement.szx}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                                <td><label>SH1</label></td><td><input type="text" id="sh1"  name="sh1" value="${stressMeasurement.sh1}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                            </tr>
                        </tbody>
                    </table>
                </center>
            </fieldset>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <fieldset>
                <center>
                    <table> 
                        <tbody>
                            <tr>

                                <td><label>SH3</label></td><td><input type="text" id="sh3"  name="sh3" value="${stressMeasurement.sh3}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                                <td><label>BSH1</label></td><td><input type="text" id="bsh1"  name="bsh1" value="${stressMeasurement.bsh1}"></input><span style="margin-left:-35px; color: #bdbdbd;">MPa</span> </td>
                                <td><label>K1</label></td><td><input type="text" id="k1"  name="k1"  value="${stressMeasurement.k1}"/> </td>
                            </tr>
                            <tr>

                                <td><label>K3</label></td><td><input type="text" id="k3"  name="k3" value="${stressMeasurement.k3}"/> </td>
                                <td><label>KX</label></td><td><input type="text" id="kx"  name="kx" value="${stressMeasurement.kx}"/> </td>
                                <td><label>KZ</label></td><td><input type="text" id="kz"  name="kz" value="${stressMeasurement.kz}"/> </td>
                            </tr>
                            <tr>

                                <td><label>NO</label></td><td><input type="text" id="no"  name="no" value="${stressMeasurement.no}"/> </td>
                                <td><label>E</label></td><td><input type="text" id="e"  name="e" value="${stressMeasurement.e}"></input><span style="margin-left:-35px; color: #bdbdbd;">GPa</span> </td>
                                <td><label>PR</label></td><td><input type="text" id="pr"  name="pr" value="${stressMeasurement.pr}"/> </td>
                            </tr>
                            <tr>

                                <td><label>ROCK</label></td><td><input type="text" id="rock" name="rock" value="${stressMeasurement.rock}"/> </td>
                                <td><label>SEQ</label></td><td><input type="text" id="seq" name="seq" value="${stressMeasurement.seq}"/> </td>
                                <td><label>REFF</label></td><td><input type="text" id="reff" name="reff" value="${stressMeasurement.reff}"/> </td>
                            </tr>
                            <tr>

                                <td><label>NOTES</label></td><td><textarea type="text" id="notes"  name="notes" />${stressMeasurement.notes}</textarea> </td>
                                <td><label>AVGB</label></td><td><input type="text" id="avgb"  name="avgb" value="${stressMeasurement.avgb}"/> </td>
                                <td><label></label></td><td> </td>
                            </tr>
                        <tbody>
                    </table>
                </center>
            </fieldset>
            <center>
                
             <button type="submit" name="action" value="verify" >Verify</button>
                <button  name="action" value="cancel"/>Cancel</button>
            </center>
        </form>
    </body>
</html>
