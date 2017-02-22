package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.stressmeasurement.service.StressMeasurementService;
import com.stressmeasurement.entity.*;

public final class measurementList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatDate_var_value_pattern_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatDate_var_value_pattern_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_fmt_formatDate_var_value_pattern_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("    <head>\n");
      out.write("        <title>Central Stress Measurement Record</title>\n");
      out.write("        <meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("\n");
      out.write("        <!-- to change the theme replace \"redmond\" with \"le-frog\", \"start\", \"ui-lightness\" or \"smoothness\"  -->\n");
      out.write("        <style type=\"text/css\" title=\"currentStyle\">\n");
      out.write("/*            @import \"media/css/demo_page.css\";*/\n");
      out.write("            @import \"media/css/demo_table_jui.css\";\n");
      out.write("            @import \"media/css/redmond/jquery-ui.custom.css\";\n");
      out.write("        </style>\n");
      out.write("        <!--         <link rel=\"stylesheet\" type=\"text/css\" href=\"http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css\">-->\n");
      out.write("        <!--                <link href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/base/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\" />-->\n");
      out.write("        <link href=\"css/jquery.datatables.yadcf.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <script src=\"media/js/jquery-ui.lightness.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-ui.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" charset=\"utf8\" src=\"js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.dataTables.yadcf.js\"></script>\n");
      out.write("        <script src=\"js/tableHeadFixer.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("            <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("            <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("            \n");
      out.write("            <script type=\"text/javascript\" src=\"js/tableExport.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"js/jquery.base64.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"js/FileSaver.min.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"jspdf/libs/sprintf.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"jspdf/jspdf.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"jspdf/jspdf.min.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"jspdf/jspdf.plugin.autotable.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"jspdf/libs/base64.js\"></script>\n");
      out.write("            <script type=\"text/javascript\" src=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyBQZWgKPoDDQ_RYDhmls5AivINjg6boL8Isensor=false\"></script>\n");
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <script type=\"text/javascript\" src=\"testJs/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"testJs/dataTables.buttons.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"testJs/buttons.flash.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"testJs/jszip.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"testJs/pdfmake.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"testJs/vfs_fonts.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"testJs/buttons.html5.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"testJs/buttons.print.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"testJs/buttons.colVis.min.js\"></script>\n");
      out.write("\n");
      out.write("<!--        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/jquery.dataTables.min.css\"/>-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/buttons.dataTables.min.css\"/>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    $(\"#measurements tr\").click(function () {\n");
      out.write("                        $(\"#measurements tr\").css(\"background-color\", \"white\");\n");
      out.write("                        $(this).css(\"background-color\", \"#ddd\");\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("             \n");
      out.write("\n");
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    /* TOGGLE FUNCTION */\n");
      out.write("                    $(\".toggle\").on(\"click\", function () {\n");
      out.write("                        var elm = $(\"#\" + $(this).data(\"toggle\"));\n");
      out.write("                        if (elm.is(\":visible\"))\n");
      out.write("                            elm.addClass(\"hidden\").removeClass(\"show\");\n");
      out.write("                        else\n");
      out.write("                            elm.addClass(\"show\").removeClass(\"hidden\");\n");
      out.write("\n");
      out.write("                        return false;\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("            <style type=\"text/css\">\n");
      out.write("                #parent {\n");
      out.write("                    height: 380px;\n");
      out.write("/*                    background:url(images/body_background.jpg);*/\n");
      out.write("                    overflow:hidden;\n");
      out.write("                   width: 100%; \n");
      out.write("                    overflow: auto;\n");
      out.write("                    z-index: -1;\n");
      out.write("\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                #measurements {\n");
      out.write("                    width: 100% !important;\n");
      out.write("/*                    background:url(images/body_background.jpg);*/\n");
      out.write("                }\n");
      out.write("               #measurements tbody {\n");
      out.write("    \n");
      out.write("    overflow-y: auto;\n");
      out.write("    overflow-x: hidden;\n");
      out.write("}\n");
      out.write("                #measurements_filter \n");
      out.write("                {\n");
      out.write("                    display:none;\n");
      out.write("                }\n");
      out.write("                .dataTables_length\n");
      out.write("                {\n");
      out.write("                    visibility: hidden;\n");
      out.write("                }\n");
      out.write("                .dataTables_paginate{\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("                .glyphicon-refresh-animate {\n");
      out.write("                    -webkit-animation-name: rotateThis;\n");
      out.write("                    -webkit-animation-duration: 2s;\n");
      out.write("                    -webkit-animation-iteration-count: infinite;\n");
      out.write("                    -webkit-animation-timing-function: linear;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                #myContent {\n");
      out.write("                    display:none;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                #map {\n");
      out.write("                    height: 200px;\n");
      out.write("                    width: 400px;\n");
      out.write("                    display: none;\n");
      out.write("                }\n");
      out.write("                div.container {\n");
      out.write("                    min-width: 980px;\n");
      out.write("                    margin: 0 auto;\n");
      out.write("                }\n");
      out.write("                #button1 {\n");
      out.write("                    background-color: Transparent;\n");
      out.write("                    background-repeat:no-repeat;\n");
      out.write("                    border: none;\n");
      out.write("                    cursor:pointer;\n");
      out.write("                    overflow: hidden;\n");
      out.write("                    outline:none;\n");
      out.write("                }\n");
      out.write("            </style>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    $(\"#update\").on(\"click\", function (e) {\n");
      out.write("                        var $icon = $(this).find(\".glyphicon.glyphicon-refresh\"),\n");
      out.write("                                animateClass = \"glyphicon-refresh-animate\";\n");
      out.write("\n");
      out.write("                        $icon.addClass(animateClass);\n");
      out.write("                        // setTimeout is to indicate some async operation\n");
      out.write("                        window.setTimeout(function () {\n");
      out.write("                            $icon.removeClass(animateClass);\n");
      out.write("                        }, 9000);\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    $(\"#measurements\").tableHeadFixer({\n");
      out.write("                        \"left\": 5});\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    $(\"#measurements\").dataTable(({\n");
      out.write("                        \"bJQueryUI\": true,\n");
      out.write("                         \"scrollY\":\"200px\",\n");
      out.write("                       scrollX: '50vh',\n");
      out.write("                        fixedHeader: true,\n");
      out.write("                        scrollCollapse: true,\n");
      out.write("                        \"pagingType\": \"full_numbers\",\n");
      out.write("                        \"sPaginationType\": \"full_numbers\",\n");
      out.write("                         dom: 'Bfrtip',\n");
      out.write("                    buttons: [\n");
      out.write("                        {\n");
      out.write("                            extend: 'print',\n");
      out.write("                            exportOptions: {\n");
      out.write("                                columns: ':visible'\n");
      out.write("                            }\n");
      out.write("                        },\n");
      out.write("                        'colvis',\n");
      out.write("                         'copy', 'csv', 'excel', 'pdf', 'print'\n");
      out.write("                         \n");
      out.write("                    ],\n");
      out.write("                    columnDefs: [{\n");
      out.write("                            targets: -1,\n");
      out.write("                            visible: false\n");
      out.write("                        }]\n");
      out.write("\n");
      out.write("\n");
      out.write("                    })).yadcf([\n");
      out.write("                        {column_number: 4, data: [\"Botswana\", \"Lesotho\", \"Namibia\", \"Malawi\", \"Mozambique\", \"Mozambique off-sho\", \"SA Offshore\", \"South Africa\", \"Tanzania\", \"Zambia\", \"Zimbabwe\"], filter_type: \"multi_select\", filter_default_label: \"--select--\", filter_container_id: \"country\"},\n");
      out.write("                        {column_number: 5, filter_type: \"multi_select\", filter_default_label: \"--select-- \", filter_container_id: \"province\"},\n");
      out.write("                        {column_number: 6, filter_type: \"multi_select\", filter_default_label: \"--select--\", filter_container_id: \"locality\"},\n");
      out.write("                        {column_number: 7, filter_type: \"multi_select\", filter_default_label: \"--select--\", filter_container_id: \"site\"},\n");
      out.write("                        {column_number: 8, filter_type: \"multi_select\", filter_default_label: \"--select-- \", filter_container_id: \"location\"},\n");
      out.write("                        {column_number: 11, filter_type: \"range_date\", filter_container_id: \"date\"},\n");
      out.write("                        {column_number: 12, filter_type: \"multi_select\", filter_default_label: \"--select--\", filter_container_id: \"method\"},\n");
      out.write("                        {column_number: 13, filter_type: \"range_number\", filter_container_id: \"depth\"},\n");
      out.write("                        {column_number: 14, filter_type: \"range_number\", filter_container_id: \"bs1\"},\n");
      out.write("                        {column_number: 15, filter_type: \"range_number\", filter_container_id: \"bs2\"},\n");
      out.write("                        {column_number: 16, filter_type: \"range_number\", filter_container_id: \"bs3\"},\n");
      out.write("                        {column_number: 17, filter_type: \"range_number\", filter_container_id: \"dips1\"},\n");
      out.write("                        {column_number: 18, filter_type: \"range_number\", filter_container_id: \"dips2\"},\n");
      out.write("                        {column_number: 19, filter_type: \"range_number\", filter_container_id: \"dips3\"},\n");
      out.write("                        {column_number: 20, filter_type: \"range_number\", filter_container_id: \"s1\"},\n");
      out.write("                        {column_number: 21, filter_type: \"range_number\", filter_container_id: \"s2\"},\n");
      out.write("                        {column_number: 22, filter_type: \"range_number\", filter_container_id: \"s3\"},\n");
      out.write("                        {column_number: 23, filter_type: \"range_number\", filter_container_id: \"sob\"},\n");
      out.write("                        {column_number: 24, filter_type: \"range_number\", filter_container_id: \"sx\"},\n");
      out.write("                        {column_number: 25, filter_type: \"range_number\", filter_container_id: \"sy\"},\n");
      out.write("                        {column_number: 26, filter_type: \"range_number\", filter_container_id: \"sz\"},\n");
      out.write("                        {column_number: 27, filter_type: \"range_number\", filter_container_id: \"sxy\"},\n");
      out.write("                        {column_number: 28, filter_type: \"range_number\", filter_container_id: \"syz\"},\n");
      out.write("                        {column_number: 29, filter_type: \"range_number\", filter_container_id: \"szx\"},\n");
      out.write("                        {column_number: 30, filter_type: \"range_number\", filter_container_id: \"sh1\"},\n");
      out.write("                        {column_number: 31, filter_type: \"range_number\", filter_container_id: \"sh3\"},\n");
      out.write("                        {column_number: 32, filter_type: \"range_number\", filter_container_id: \"bsh1\"},\n");
      out.write("                        {column_number: 33, filter_type: \"range_number\", filter_container_id: \"k1\"},\n");
      out.write("                        {column_number: 34, filter_type: \"range_number\", filter_container_id: \"k3\"},\n");
      out.write("                        {column_number: 35, filter_type: \"range_number\", filter_container_id: \"kx\"},\n");
      out.write("                        {column_number: 36, filter_type: \"range_number\", filter_container_id: \"kz\"},\n");
      out.write("                        {column_number: 37, filter_type: \"range_number\", filter_container_id: \"no\"},\n");
      out.write("                        {column_number: 38, filter_type: \"range_number\", filter_container_id: \"e\"},\n");
      out.write("                        {column_number: 39, filter_type: \"range_number\", filter_container_id: \"pr\"},\n");
      out.write("                        {column_number: 40, filter_type: \"multi_select\", filter_default_label: \"--select--\", filter_container_id: \"rock\"},\n");
      out.write("                        {column_number: 41, filter_type: \"multi_select\", filter_default_label: \"--select--\", filter_container_id: \"seq\"},\n");
      out.write("                        {column_number: 44, filter_type: \"range_number\", filter_container_id: \"avgb\"}\n");
      out.write("\n");
      out.write("                    ]);\n");
      out.write("                     $(\"#NewPaginationContainer\").append($(\".dataTables_paginate\"));\n");
      out.write("                      $(\"#NewPaginationContainer\").append($(\".dataTables_info\"));\n");
      out.write("                     \n");
      out.write("                    $(\"#hide_show_all\").on(\"change\", function () {\n");
      out.write("                        var hide = !$(this).is(\":checked\");\n");
      out.write("                        $(\".hide_show\").prop(\"checked\", hide);\n");
      out.write("\n");
      out.write("                        if (hide) {\n");
      out.write("                            $('#measurements tr th').hide(100);\n");
      out.write("                            $('#measurements tr td').hide(100);\n");
      out.write("                        } else {\n");
      out.write("                            $('#measurements tr th').show(100);\n");
      out.write("                            $('#measurements tr td').show(100);\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                    var tr_hidden = [];\n");
      out.write("                    $(document).on(\"click change keyup\", \".paginate_button, .sorting_asc input \", function () {\n");
      out.write("                        console.log(tr_hidden);\n");
      out.write("                        $('#measurements tr td, #measurements tr th').show();\n");
      out.write("                        $.each(tr_hidden, function (ti) {\n");
      out.write("                            var i = ti;\n");
      out.write("                            $('#measurements tr').each(function () {\n");
      out.write("                                //$('td, th', this).show();\n");
      out.write("                                $('td:eq(' + i + ')', this).hide();\n");
      out.write("                                $('th:eq(' + i + ')', this).hide();\n");
      out.write("\n");
      out.write("                            });\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("                    $(\".hide_show\").on(\"click change\", function () {\n");
      out.write("                        var hide = !$(this).is(\":checked\");\n");
      out.write("\n");
      out.write("                        var all_ch = $(\".hide_show:checked\").length == $(\".hide_show\").length;\n");
      out.write("\n");
      out.write("                        var ti = $(this).index(\".hide_show\");\n");
      out.write("\n");
      out.write("                        $('#measurements tr').each(function () {\n");
      out.write("                            if (hide) {\n");
      out.write("                                $('td:eq(' + ti + ')', this).hide(100);\n");
      out.write("                                $('th:eq(' + ti + ')', this).hide(100);\n");
      out.write("                                if (tr_hidden.indexOf(ti) == -1)\n");
      out.write("                                    tr_hidden.push(ti);\n");
      out.write("                            } else {\n");
      out.write("\n");
      out.write("                                $('td:eq(' + ti + ')', this).show(100);\n");
      out.write("                                $('th:eq(' + ti + ')', this).show(100);\n");
      out.write("                                if (tr_hidden.indexOf(ti) > -1) {\n");
      out.write("                                    tr_hidden.splice(tr_hidden.indexOf(ti), 1);\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    //To hide the table when Clear All clicked\n");
      out.write("                    $(\"#clear_all\").click(function () {\n");
      out.write("                        $('.hide_show').prop('checked', false);\n");
      out.write("                        $('#measurements tr td, #measurements tr th').hide(\"fast\");\n");
      out.write("                    });\n");
      out.write("                    //To show the table when Select all clicked\n");
      out.write("                    $(\"#select_all\").click(function () {\n");
      out.write("                        $('.hide_show').prop('checked', true);\n");
      out.write("                        $('#measurements tr td, #measurements tr th').show(\"fast\");\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                function refresh() {\n");
      out.write("                    window.location = 'measurementList.jsp';\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("            <script>\n");
      out.write("                function toggler(divId) {\n");
      out.write("                    $(\"#\" + divId).toggle()\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("                var map;\n");
      out.write("\n");
      out.write("                var latitute = -28.2833;\n");
      out.write("                var longitute = 26.7667;\n");
      out.write("                function initMap() {\n");
      out.write("\n");
      out.write("                    var latlgn = {lat: latitute, lng: longitute};\n");
      out.write("\n");
      out.write("                    map = new google.maps.Map(document.getElementById('map'), {\n");
      out.write("                        zoom: 4,\n");
      out.write("                        center: latlgn\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                }\n");
      out.write("                $(document).ready(function () {\n");
      out.write("\n");
      out.write("                    $(document).on('click', \"#button1\", function (e) {\n");
      out.write("                        e.preventDefault();\n");
      out.write("                        //                 $(\"#users\").change(function(){\n");
      out.write("                        var value = $(this).val();\n");
      out.write("\n");
      out.write("                        var splitted = null;\n");
      out.write("                        $.get(\"data.jsp\", {q: value}, function (data) {\n");
      out.write("                            splitted = data.split(\",\");\n");
      out.write("                            longitute = splitted[1];\n");
      out.write("                            latitute = splitted[2];\n");
      out.write("                            $(\"#javaquery\").html(splitted[0]);\n");
      out.write("                            //                        $(\"#javaquery1\").html(longitute).val();\n");
      out.write("                            $('#javaquery1').val(longitute);\n");
      out.write("                            $('#javaquery2').val(latitute);\n");
      out.write("                            //                        $(\"#javaquery2\").html(latitute).val();;\n");
      out.write("                        });\n");
      out.write("                        latitute = parseFloat(document.getElementById(\"javaquery2\").value);\n");
      out.write("                        longitute = parseFloat(document.getElementById(\"javaquery1\").value);\n");
      out.write("                        var latlgn = {lat: latitute, lng: longitute};\n");
      out.write("                        map = new google.maps.Map(document.getElementById('map'), {\n");
      out.write("                            zoom: 4,\n");
      out.write("                            center: latlgn\n");
      out.write("                        });\n");
      out.write("                        var marker = new google.maps.Marker({\n");
      out.write("                            position: latlgn,\n");
      out.write("                            map: map,\n");
      out.write("                            title: \"Latitude: \" + latitute + \" , \" + \"Longitude: \" + longitute\n");
      out.write("                                    //                    animation: google.maps.Animation.BOUNCE\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("            <style>\n");
      out.write("                .containerDiv {\n");
      out.write("/*\twidth: 30em;*/\n");
      out.write("          height: 355px;\n");
      out.write("\t  overflow-x: auto;\n");
      out.write("\t  white-space: nowrap;\n");
      out.write("         \n");
      out.write("background: #5c9ccc url(images/ui-bg_gloss-wave_55_5c9ccc_500x100.png) 50% 50% repeat-x;\n");
      out.write("\n");
      out.write("font-weight: bold;\n");
      out.write("}\n");
      out.write("                \n");
      out.write("                .loader {\n");
      out.write("                    position: fixed;\n");
      out.write("                    left: 0px;\n");
      out.write("                    top: 0px;\n");
      out.write("                    width: 100%;\n");
      out.write("                    height: 100%;\n");
      out.write("                    z-index: 9999;\n");
      out.write("                    background: url('images/page-loader.gif') 50% 50% no-repeat rgb(249,249,249);\n");
      out.write("                }\n");
      out.write("                label {\n");
      out.write("\n");
      out.write("                    font-weight: bold;}\n");
      out.write("                tfoot input, textarea, select{\n");
      out.write("                    width:150px;\n");
      out.write("                    font-weight: bold;\n");
      out.write("                    -moz-border-radius: 4px; border-radius: 4px;\n");
      out.write("                    border: 1px solid #555555 }\n");
      out.write("                table.scroll {\n");
      out.write("    width: 100%;\n");
      out.write("    /* border-collapse: collapse; */\n");
      out.write("    border-spacing: 0;\n");
      out.write("    border: 0px solid black;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table.scroll tbody,\n");
      out.write("table.scroll thead { display: block; }\n");
      out.write("\n");
      out.write("table.scroll thead tr th { \n");
      out.write("    height: 20px;\n");
      out.write("    line-height: 30px;\n");
      out.write("    text-align: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table.scroll tbody {\n");
      out.write("    height: 250px;\n");
      out.write("    overflow-y: auto;\n");
      out.write("    \n");
      out.write("}\n");
      out.write("\n");
      out.write("table.scroll tbody { border-top: 0px solid black; }\n");
      out.write("\n");
      out.write(" table.scroll tbody td, thead th {\n");
      out.write("    width: 290px;  \n");
      out.write("    border-right: 0px solid black;\n");
      out.write("}\n");
      out.write("\n");
      out.write(" table.scroll tbody td:last-child, thead th:last-child {\n");
      out.write("    border-right: none;\n");
      out.write("}\n");
      out.write("                label {\n");
      out.write("                    font-weight: bold;\n");
      out.write("           color: #2e6e9e;\n");
      out.write("                  }\n");
      out.write("                tfoot input, textarea, select{\n");
      out.write("                    width:150px;\n");
      out.write("                     font-weight: bold;\n");
      out.write("                    color: #2e6e9e;\n");
      out.write("                    -moz-border-radius: 4px; border-radius: 4px;\n");
      out.write("                    border: 1px solid #2e6e9e }\n");
      out.write("            </style>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                $(window).load(function () {\n");
      out.write("                    $(\".loader\").fadeOut(\"slow\");\n");
      out.write("                })\n");
      out.write("            </script>\n");
      out.write("             <script>\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    // Change the selector if needed//\n");
      out.write("                    var $table = $('table.scroll'),\n");
      out.write("                            $bodyCells = $table.find('tbody tr:first').children(),\n");
      out.write("                            colWidth;\n");
      out.write("\n");
      out.write("// Adjust the width of thead cells when window resizes\n");
      out.write("                    $(window).resize(function () {\n");
      out.write("                        // Get the tbody columns width array\n");
      out.write("                        colWidth = $bodyCells.map(function () {\n");
      out.write("                            return $(this).width();\n");
      out.write("                        }).get();\n");
      out.write("\n");
      out.write("                        // Set the width of thead columns\n");
      out.write("                        $table.find('thead tr').children().each(function (i, v) {\n");
      out.write("                            $(v).width(colWidth[i]);\n");
      out.write("                        });\n");
      out.write("                    }).resize(); // Trigger resize handler\n");
      out.write("\n");
      out.write("\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"loader\"></div>\n");
      out.write("        ");
StressMeasurementService stressMeasurementService = new StressMeasurementService();

            String verified = "Yes";
            request.setAttribute("listStressMeasurements", stressMeasurementService.findByVerified(verified));


        
      out.write("  \n");
      out.write("\n");
      out.write("        <script async defer src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBQZWgKPoDDQ_RYDhmls5AivINjg6boL8I&callback=initMap\">\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <!-- Header -->\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <div class=\"shell\">\n");
      out.write("                <!-- Logo + Top Nav -->\n");
      out.write("                <div id=\"top\">\n");
      out.write("                    <h1 id=\"logo\" style=\"font-family: sans-serif; font-weight:bold \">Stress Measurements Record</h1>\n");
      out.write("                    <div id=\"top-navigation\">  <span></span> <a href=\"#\">Help</a> <span>|</span>  <a href=\"login.jsp\">Login</a> </div></div>\n");
      out.write("                <!-- End Logo + Top Nav -->\n");
      out.write("                <!-- Main Nav -->\n");
      out.write("                <div id=\"navigation\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"measurementList.jsp\" class=\"active\"><span>Home</span></a></li>\n");
      out.write("                        <li><a href=\"#\"><span>Publications</span></a></li>\n");
      out.write("                        <li><a href=\"#\"><span>Conferences</span></a></li>\n");
      out.write("                        <li><a href=\"#\"><span>FAQs</span></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <!-- End Main Nav -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <hr style=\"height:3px;border:none;color:#5c9ccc;background-color:#5c9ccc; \" />\n");
      out.write("        <!-- End Header -->\n");
      out.write("        <!-- Container -->\n");
      out.write("        <div id=\"container\"></div>\n");
      out.write("        <div class=\"shell\">\n");
      out.write("            <!-- Small Nav -->\n");
      out.write("            <div class=\"small-nav\"> <a href=\"measurementList.jsp\">Home</a> <span>&gt;</span>Measurements Record </div>\n");
      out.write("            <!-- End Small Nav -->\n");
      out.write("        </div>\n");
      out.write("        <!--        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>-->\n");
      out.write("        <div  class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("\n");
      out.write("                    <table id=\"bootstrap\" style=\"float: left;\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td><button onclick=\"toggler('myContent');\"  type=\"button\" id=\"update\" class=\"button \"><i class=\"glyphicon glyphicon-cog\"></i>Show/Hide columns</button></td>\n");
      out.write("                            <td> <button onclick=\"toggler('map');\n");
      out.write("                                    initMap();\"  type=\"button\" id=\"update_two\" class=\"button\"><i class=\"glyphicon glyphicon-cog\"></i>Show Maps</button></td>\n");
      out.write("                            <td><div   class=\"btn-group\"><button class=\"dropdown-toggle button\" data-toggle=\"dropdown\"><i class=\"fa fa-bars \"></i> Export Table Data</button>\n");
      out.write("                                    <ul   class=\"dropdown-menu \" role=\"menu\">\n");
      out.write("                                        <li><a  onClick =\"$('#measurements').tableExport({type: 'xml', escape: 'false'});\"> <img src='assets/images/icons/xml.png' width='24px'> XML</a></li>\n");
      out.write("                                        <li><a  onClick =\"$('#measurements').tableExport({type: 'sql'});\"> <img src='assets/images/icons/sql.png' width='24px'> SQL</a></li>\n");
      out.write("                                        <li><a  onClick =\"$('#measurements').tableExport({type: 'csv', escape: 'false', footers: 'false'});\"> <img src='assets/images/icons/csv.png' width='24px'> CSV</a></li>\n");
      out.write("                                        <li><a  onClick =\"$('#measurements').tableExport({type: 'txt', escape: 'false'});\"> <img src='assets/images/icons/txt.png' width='24px'> TXT</a></li>\n");
      out.write("                                        <li><a  onClick =\"$('#measurements').tableExport({type: 'excel', escape: 'false', footers: false});\"> <img src='assets/images/icons/xls.png' width='24px'> XLS</a></li>\n");
      out.write("                                        <li><a  onClick =\"$('#measurements').tableExport({type: 'doc', escape: 'false', footers: 'false'});\"> <img src='assets/images/icons/word.png' width='24px'> Word</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div> \n");
      out.write("                            </td>\n");
      out.write("                            <td> <button onclick=\"refresh()\" style=\"float: right;\" type=\"button\" id=\"update\" class=\"button \"><i class=\"glyphicon glyphicon-refresh\"></i> Refresh</button></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                    <script>\n");
      out.write("                        $(\"#update_two\").click(function () {\n");
      out.write("                            $(this).text(function (i, v) {\n");
      out.write("                                return v === 'Hide Maps' ? 'Show Maps' : 'Hide Maps'\n");
      out.write("                            })\n");
      out.write("                        });\n");
      out.write("                    </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div id=\"myContent\" >\n");
      out.write("                        <div> \n");
      out.write("                            <br/>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <!--                                <p>&nbsp;</p>-->\n");
      out.write("                            <!-- Content -->\n");
      out.write("                            <div id=\"show_content\"  >\n");
      out.write("                                <!-- Box -->\n");
      out.write("                                <p Style =\"color:red;font-weight: bold;\">Please  Select Columns and click Show/Hide columns</p>\n");
      out.write("                                <center > \n");
      out.write("                                    <div class=\"box\" >\n");
      out.write("                                        <!-- Box Head -->\n");
      out.write("                                        <div class=\"box-head\">\n");
      out.write("                                            <center> <h2 >Columns</h2> </center> \n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <!-- End Box Head -->\n");
      out.write("                                        <!-- Table -->\n");
      out.write("                                        <div class=\"table\">\n");
      out.write("                                            <table  width=100% border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("                                                <tbody>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show checkbox\" checked=\"checked\"/> SM ID</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show checkbox\" checked=\"checked\"/> AVG</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show checkbox\" checked=\"checked\"/> GG</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show checkbox\"  checked=\"checked\"/> IG</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show checkbox\" checked=\"checked\"/> COUNTRY</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show checkbox\" checked=\"checked\"/> PROVINCE</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show checkbox\" checked=\"checked\"/> LOCALITY</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show checkbox\" checked=\"checked\"/> SITE</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show checkbox\" checked=\"checked\"/> LOCATION</label></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> LONGITUDE</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> LATITUDE</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> DATE</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> METHOD</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> DEPTH</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> BS1</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> BS2</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> BS3</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\" /> DIPS1</label></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> DIPS2</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> DIPS3</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> S1</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> S2</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> S3</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> SOB</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> SX</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> SY</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> SZ</label></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> SXY</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> SYZ</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> SZX</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> SH1</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> SH3</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> BSH1</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> K1</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> K3</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> KX</label></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> KZ</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> NO</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> E</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> PR</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> ROCK</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> SEQ</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> REFF</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> NOTES</label></td>\n");
      out.write("                                                        <td><label><input type=\"checkbox\" class=\"hide_show\" checked=\"checked\"/> AVGB</label></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td></td>\n");
      out.write("                                                        <td></td>\n");
      out.write("                                                        <td></td>\n");
      out.write("                                                        <td></td>\n");
      out.write("                                                        <td></td>\n");
      out.write("                                                        <td></td>\n");
      out.write("                                                        <td></td>\n");
      out.write("                                                        <td></td>\n");
      out.write("                                                        <td></td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </tbody>\n");
      out.write("                                            </table>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <!-- Table -->\n");
      out.write("                                        <br />\n");
      out.write("\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <center>\n");
      out.write("                                                <div class=\"col-xs-12\">\n");
      out.write("                                                    <button id=\"clear_all\" class=\"btn btn-warning btn-fltr-clearAll btn-xs button\">Clear All</button>\n");
      out.write("                                                    <button id=\"select_all\"class=\"btn btn-primary btn-fltr-selectAll btn-xs button\">Select All</button>\n");
      out.write("                                                </div>\n");
      out.write("                                            </center>\n");
      out.write("                                            <br />\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </center> \n");
      out.write("                                <br />\n");
      out.write("                                <!-- End Box -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <!-- End Content -->\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div> \n");
      out.write("                    </div>\n");
      out.write("                   \n");
      out.write("                    <center>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\n");
      out.write("                        <div id=\"map\">\n");
      out.write("\n");
      out.write("                        </div> \n");
      out.write("                        <div ><input type=\"hidden\" id=\"javaquery1\" value=\"\"></div>\n");
      out.write("                        <div ><input type=\"hidden\" id=\"javaquery2\" value=\"\"></div>\n");
      out.write("                    </center>\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <br/>\n");
      out.write("                <br/>\n");
      out.write("                <div  id=\"parent\" >\n");
      out.write("                    <div class=\"containerDiv\">\n");
      out.write("                   \n");
      out.write("                    <table id=\"measurements\" class=\"display \" width=\"100%\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("\n");
      out.write("                                <th>SM_ID</th>\t\n");
      out.write("                                <th>AVG</th>\t\n");
      out.write("                                <th>GG</th>\t\n");
      out.write("                                <th>IG</th>\t\n");
      out.write("                                <th>COUNTRY</th>\t\t\n");
      out.write("                                <th>PROVINCE</th>\t\t\n");
      out.write("                                <th>LOCALITY</th>\t\t\n");
      out.write("                                <th>SITE</th>\t\t\n");
      out.write("                                <th>LOCATION</th>\t\t\n");
      out.write("                                <th>LONGITUDE(°)</th>\t\t\n");
      out.write("                                <th>LATITUDE(°)</th>\t\t\n");
      out.write("                                <th>DATE</th>\t\t\n");
      out.write("                                <th>METHOD</th>\t\t\n");
      out.write("                                <th>DEPTH(m)</th>\t\t\n");
      out.write("                                <th>BS1(°)</th>\t\n");
      out.write("                                <th>BS2(°)</th>\t\n");
      out.write("                                <th>BS3(°)</th>\t\n");
      out.write("                                <th>DIPS1(°)</th>\t\t\n");
      out.write("                                <th>DIPS2(°)</th>\t\t\n");
      out.write("                                <th>DIPS3(°)</th>\t\t\n");
      out.write("                                <th>S1(MPa)</th>\t\n");
      out.write("                                <th>S2(MPa)</th>\t\n");
      out.write("                                <th>S3(MPa)</th>\t\n");
      out.write("                                <th>SOB(MPa)</th>\t\t\n");
      out.write("                                <th>SX(MPa)</th>\t\n");
      out.write("                                <th>SY(MPa)</th>\t\n");
      out.write("                                <th>SZ(MPa)</th>\t\n");
      out.write("                                <th>SXY(MPa)</th>\t\n");
      out.write("                                <th>SYZ(MPa)</th>\t\n");
      out.write("                                <th>SZX(MPa)</th>\t\n");
      out.write("                                <th>SH1(MPa)</th>\t\n");
      out.write("                                <th>SH3(MPa)</th>\t\n");
      out.write("                                <th>BSH1(MPa)</th>\t\t\n");
      out.write("                                <th>K1(°)</th>\t\n");
      out.write("                                <th>K3(°)</th>\t\n");
      out.write("                                <th>KX(°)</th>\t\n");
      out.write("                                <th>KZ(°)</th>\t\n");
      out.write("                                <th>NO</th>\t\n");
      out.write("                                <th>E(GPa)</th>\t\n");
      out.write("                                <th>PR</th>\t\n");
      out.write("                                <th>ROCK</th>\t\t\n");
      out.write("                                <th>SEQ</th>\t\n");
      out.write("                                <th>REFF</th>\t\t\n");
      out.write("                                <th>NOTES</th>\t\t\n");
      out.write("                                <th>AVGB</th>\n");
      out.write("                                <!--                            <th>VERIFIED</th>-->\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody >\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                    </div>\n");
      out.write("                <div id=\"NewPaginationContainer\"></div>\n");
      out.write("                <div style=\"overflow: scroll; width: 100%; overflow: auto\">\n");
      out.write("                    <table>\n");
      out.write("                        <tfoot>\n");
      out.write("                            <tr>\n");
      out.write("                                <th id=\"sm_id\"></th>\t\n");
      out.write("                                <th id=\"avg\" ></th>\t\n");
      out.write("                                <th id=\"gg\"></th>\t\n");
      out.write("                                <th id=\"ig\">Filter By</th>\n");
      out.write("                                <th id=\"country\">COUNTRY</th>\t\t\n");
      out.write("                                <th id=\"province\">PROVINCE</th>\t\t\n");
      out.write("                                <th id=\"locality\">LOCALITY</th>\t\t\n");
      out.write("                                <th id=\"site\">SITE</th>\t\t\n");
      out.write("                                <th id=\"location\">LOCATION</th>\t\t\n");
      out.write("                                <th id=\"longitude\"></th>\t\t\n");
      out.write("                                <th id=\"latitude\"></th>\t\t\n");
      out.write("                                <th id=\"date\">DATE</th>\t\t\n");
      out.write("                                <th id=\"method\">METHOD</th>\t\t\n");
      out.write("                                <th id =\"depth\">DEPTH</th>\t\t\n");
      out.write("                                <th id=\"bs1\">BS1</th>\t\n");
      out.write("                                <th id=\"bs2\">BS2</th>\t\n");
      out.write("                                <th id=\"bs3\">BS3</th>\t\n");
      out.write("                                <th id=\"dips1\">DIPS1</th>\t\t\n");
      out.write("                                <th id=\"dips2\">DIPS2</th>\t\t\n");
      out.write("                                <th id=\"dips3\">DIPS3</th>\t\t\n");
      out.write("                                <th id=\"s1\">S1</th>\t\n");
      out.write("                                <th id=\"s2\">S2</th>\t\n");
      out.write("                                <th id=\"s3\">S3</th>\t\n");
      out.write("                                <th id=\"sob\">SOB</th>\t\t\n");
      out.write("                                <th id=\"sx\">SX</th>\t\n");
      out.write("                                <th id=\"sy\">SY</th>\t\n");
      out.write("                                <th id=\"sz\">SZ</th>\t\n");
      out.write("                                <th id=\"sxy\">SXY</th>\t\n");
      out.write("                                <th id=\"syz\">SYZ</th>\t\n");
      out.write("                                <th id=\"szx\">SZX</th>\t\n");
      out.write("                                <th id=\"sh1\">SH1</th>\t\n");
      out.write("                                <th id=\"sh3\">SH3</th>\t\n");
      out.write("                                <th id=\"bsh1\">BSH1</th>\t\t\n");
      out.write("                                <th id=\"k1\">K1</th>\t\n");
      out.write("                                <th id=\"k3\">K3</th>\t\n");
      out.write("                                <th id=\"kx\">KX</th>\t\n");
      out.write("                                <th id=\"kz\">KZ</th>\t\n");
      out.write("                                <th id=\"no\">NO</th>\t\n");
      out.write("                                <th id=\"e\">E</th>\t\n");
      out.write("                                <th id=\"pr\">PR</th>\t\n");
      out.write("                                <th id=\"rock\">ROCK</th>\t\t\n");
      out.write("                                <th id=\"seq\">SEQ</th>\t\n");
      out.write("                                <th id=\"reff\"></th>\t\t\n");
      out.write("                                <th></th>\t\t\n");
      out.write("                                <th id=\"avgb\">AVGB</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </tfoot>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- Main -->\n");
      out.write("            <div id=\"main\">\n");
      out.write("                </dsiv>\n");
      out.write("                <div class=\"cl\"></div>\n");
      out.write("                <!-- Content -->\n");
      out.write("                <center\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- End Box -->\n");
      out.write("        <!-- End Content -->\n");
      out.write("        <!-- Sidebar -->\n");
      out.write("        <!-- End Sidebar -->\n");
      out.write("        <!-- Main -->\n");
      out.write("        <!-- End Container -->\n");
      out.write("        <!-- Footer -->\n");
      out.write("        <div id=\"footer\">\n");
      out.write("            <div class=\"shell\" style=\"text-align: center;font-weight: bold\"> <span class=\"center\">Copyright &copy; CSIR 2017. All Rights Reserved.</span> <span class=\"right\"></span> </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- End Footer -->\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listStressMeasurements}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("list");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                ");
          if (_jspx_meth_fmt_formatDate_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                <tr >\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\"> <button name=\"button1\" id=\"button1\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.smId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_out_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</button></td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_9((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_10((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>                               \n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_11((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>                  \n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_12((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_13((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_14((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_15((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_16((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_17((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_18((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_19((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_20((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_21((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_22((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_23((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_24((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_25((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_26((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_27((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_28((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_29((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_30((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_31((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_32((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_33((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_34((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_35((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_36((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_37((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_38((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_39((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_40((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_41((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_42((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_43((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                    <td nowrap align=\"center\">");
          if (_jspx_meth_c_out_44((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("\n");
          out.write("                                </tr>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_formatDate_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_var_value_pattern_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_fmt_formatDate_0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.date}", java.util.Date.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatDate_0.setPattern("dd/MM/yyyy");
    _jspx_th_fmt_formatDate_0.setVar("date");
    int _jspx_eval_fmt_formatDate_0 = _jspx_th_fmt_formatDate_0.doStartTag();
    if (_jspx_th_fmt_formatDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatDate_var_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
      return true;
    }
    _jspx_tagPool_fmt_formatDate_var_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.smId}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.avg}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.gg}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
    return false;
  }

  private boolean _jspx_meth_c_out_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_3.setPageContext(_jspx_page_context);
    _jspx_th_c_out_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.ig}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_3 = _jspx_th_c_out_3.doStartTag();
    if (_jspx_th_c_out_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
    return false;
  }

  private boolean _jspx_meth_c_out_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_4.setPageContext(_jspx_page_context);
    _jspx_th_c_out_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.country}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_4 = _jspx_th_c_out_4.doStartTag();
    if (_jspx_th_c_out_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
    return false;
  }

  private boolean _jspx_meth_c_out_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_5.setPageContext(_jspx_page_context);
    _jspx_th_c_out_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.province}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_5 = _jspx_th_c_out_5.doStartTag();
    if (_jspx_th_c_out_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_5);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_5);
    return false;
  }

  private boolean _jspx_meth_c_out_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_6.setPageContext(_jspx_page_context);
    _jspx_th_c_out_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.locality}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_6 = _jspx_th_c_out_6.doStartTag();
    if (_jspx_th_c_out_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_6);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_6);
    return false;
  }

  private boolean _jspx_meth_c_out_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_7 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_7.setPageContext(_jspx_page_context);
    _jspx_th_c_out_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.site}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_7 = _jspx_th_c_out_7.doStartTag();
    if (_jspx_th_c_out_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_7);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_7);
    return false;
  }

  private boolean _jspx_meth_c_out_8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_8 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_8.setPageContext(_jspx_page_context);
    _jspx_th_c_out_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.location}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_8 = _jspx_th_c_out_8.doStartTag();
    if (_jspx_th_c_out_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_8);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_8);
    return false;
  }

  private boolean _jspx_meth_c_out_9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_9 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_9.setPageContext(_jspx_page_context);
    _jspx_th_c_out_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.longitude}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_9 = _jspx_th_c_out_9.doStartTag();
    if (_jspx_th_c_out_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_9);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_9);
    return false;
  }

  private boolean _jspx_meth_c_out_10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_10 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_10.setPageContext(_jspx_page_context);
    _jspx_th_c_out_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_10.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.latitude}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_10 = _jspx_th_c_out_10.doStartTag();
    if (_jspx_th_c_out_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_10);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_10);
    return false;
  }

  private boolean _jspx_meth_c_out_11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_11 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_11.setPageContext(_jspx_page_context);
    _jspx_th_c_out_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_11.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${date}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_11 = _jspx_th_c_out_11.doStartTag();
    if (_jspx_th_c_out_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_11);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_11);
    return false;
  }

  private boolean _jspx_meth_c_out_12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_12 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_12.setPageContext(_jspx_page_context);
    _jspx_th_c_out_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_12.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.method}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_12 = _jspx_th_c_out_12.doStartTag();
    if (_jspx_th_c_out_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_12);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_12);
    return false;
  }

  private boolean _jspx_meth_c_out_13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_13 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_13.setPageContext(_jspx_page_context);
    _jspx_th_c_out_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_13.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.depth}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_13 = _jspx_th_c_out_13.doStartTag();
    if (_jspx_th_c_out_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_13);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_13);
    return false;
  }

  private boolean _jspx_meth_c_out_14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_14 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_14.setPageContext(_jspx_page_context);
    _jspx_th_c_out_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_14.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.bs1}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_14 = _jspx_th_c_out_14.doStartTag();
    if (_jspx_th_c_out_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_14);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_14);
    return false;
  }

  private boolean _jspx_meth_c_out_15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_15 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_15.setPageContext(_jspx_page_context);
    _jspx_th_c_out_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_15.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.bs2}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_15 = _jspx_th_c_out_15.doStartTag();
    if (_jspx_th_c_out_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_15);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_15);
    return false;
  }

  private boolean _jspx_meth_c_out_16(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_16 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_16.setPageContext(_jspx_page_context);
    _jspx_th_c_out_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_16.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.bs3}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_16 = _jspx_th_c_out_16.doStartTag();
    if (_jspx_th_c_out_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_16);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_16);
    return false;
  }

  private boolean _jspx_meth_c_out_17(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_17 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_17.setPageContext(_jspx_page_context);
    _jspx_th_c_out_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_17.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.dips1}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_17 = _jspx_th_c_out_17.doStartTag();
    if (_jspx_th_c_out_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_17);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_17);
    return false;
  }

  private boolean _jspx_meth_c_out_18(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_18 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_18.setPageContext(_jspx_page_context);
    _jspx_th_c_out_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_18.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list. dips2}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_18 = _jspx_th_c_out_18.doStartTag();
    if (_jspx_th_c_out_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_18);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_18);
    return false;
  }

  private boolean _jspx_meth_c_out_19(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_19 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_19.setPageContext(_jspx_page_context);
    _jspx_th_c_out_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_19.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.dips3}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_19 = _jspx_th_c_out_19.doStartTag();
    if (_jspx_th_c_out_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_19);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_19);
    return false;
  }

  private boolean _jspx_meth_c_out_20(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_20 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_20.setPageContext(_jspx_page_context);
    _jspx_th_c_out_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_20.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.s1}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_20 = _jspx_th_c_out_20.doStartTag();
    if (_jspx_th_c_out_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_20);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_20);
    return false;
  }

  private boolean _jspx_meth_c_out_21(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_21 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_21.setPageContext(_jspx_page_context);
    _jspx_th_c_out_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_21.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.s2}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_21 = _jspx_th_c_out_21.doStartTag();
    if (_jspx_th_c_out_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_21);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_21);
    return false;
  }

  private boolean _jspx_meth_c_out_22(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_22 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_22.setPageContext(_jspx_page_context);
    _jspx_th_c_out_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_22.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.s3}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_22 = _jspx_th_c_out_22.doStartTag();
    if (_jspx_th_c_out_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_22);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_22);
    return false;
  }

  private boolean _jspx_meth_c_out_23(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_23 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_23.setPageContext(_jspx_page_context);
    _jspx_th_c_out_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_23.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.sob}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_23 = _jspx_th_c_out_23.doStartTag();
    if (_jspx_th_c_out_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_23);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_23);
    return false;
  }

  private boolean _jspx_meth_c_out_24(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_24 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_24.setPageContext(_jspx_page_context);
    _jspx_th_c_out_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_24.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.sx}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_24 = _jspx_th_c_out_24.doStartTag();
    if (_jspx_th_c_out_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_24);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_24);
    return false;
  }

  private boolean _jspx_meth_c_out_25(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_25 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_25.setPageContext(_jspx_page_context);
    _jspx_th_c_out_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_25.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.sy}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_25 = _jspx_th_c_out_25.doStartTag();
    if (_jspx_th_c_out_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_25);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_25);
    return false;
  }

  private boolean _jspx_meth_c_out_26(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_26 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_26.setPageContext(_jspx_page_context);
    _jspx_th_c_out_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_26.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.sz}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_26 = _jspx_th_c_out_26.doStartTag();
    if (_jspx_th_c_out_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_26);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_26);
    return false;
  }

  private boolean _jspx_meth_c_out_27(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_27 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_27.setPageContext(_jspx_page_context);
    _jspx_th_c_out_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_27.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.sxy}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_27 = _jspx_th_c_out_27.doStartTag();
    if (_jspx_th_c_out_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_27);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_27);
    return false;
  }

  private boolean _jspx_meth_c_out_28(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_28 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_28.setPageContext(_jspx_page_context);
    _jspx_th_c_out_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_28.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.syz}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_28 = _jspx_th_c_out_28.doStartTag();
    if (_jspx_th_c_out_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_28);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_28);
    return false;
  }

  private boolean _jspx_meth_c_out_29(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_29 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_29.setPageContext(_jspx_page_context);
    _jspx_th_c_out_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_29.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.szx}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_29 = _jspx_th_c_out_29.doStartTag();
    if (_jspx_th_c_out_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_29);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_29);
    return false;
  }

  private boolean _jspx_meth_c_out_30(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_30 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_30.setPageContext(_jspx_page_context);
    _jspx_th_c_out_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_30.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.sh1}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_30 = _jspx_th_c_out_30.doStartTag();
    if (_jspx_th_c_out_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_30);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_30);
    return false;
  }

  private boolean _jspx_meth_c_out_31(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_31 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_31.setPageContext(_jspx_page_context);
    _jspx_th_c_out_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_31.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.sh3}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_31 = _jspx_th_c_out_31.doStartTag();
    if (_jspx_th_c_out_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_31);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_31);
    return false;
  }

  private boolean _jspx_meth_c_out_32(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_32 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_32.setPageContext(_jspx_page_context);
    _jspx_th_c_out_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_32.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.bsh1}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_32 = _jspx_th_c_out_32.doStartTag();
    if (_jspx_th_c_out_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_32);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_32);
    return false;
  }

  private boolean _jspx_meth_c_out_33(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_33 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_33.setPageContext(_jspx_page_context);
    _jspx_th_c_out_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_33.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.k1}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_33 = _jspx_th_c_out_33.doStartTag();
    if (_jspx_th_c_out_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_33);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_33);
    return false;
  }

  private boolean _jspx_meth_c_out_34(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_34 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_34.setPageContext(_jspx_page_context);
    _jspx_th_c_out_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_34.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.k3}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_34 = _jspx_th_c_out_34.doStartTag();
    if (_jspx_th_c_out_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_34);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_34);
    return false;
  }

  private boolean _jspx_meth_c_out_35(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_35 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_35.setPageContext(_jspx_page_context);
    _jspx_th_c_out_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_35.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.kx}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_35 = _jspx_th_c_out_35.doStartTag();
    if (_jspx_th_c_out_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_35);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_35);
    return false;
  }

  private boolean _jspx_meth_c_out_36(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_36 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_36.setPageContext(_jspx_page_context);
    _jspx_th_c_out_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_36.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.kz}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_36 = _jspx_th_c_out_36.doStartTag();
    if (_jspx_th_c_out_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_36);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_36);
    return false;
  }

  private boolean _jspx_meth_c_out_37(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_37 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_37.setPageContext(_jspx_page_context);
    _jspx_th_c_out_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_37.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.no}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_37 = _jspx_th_c_out_37.doStartTag();
    if (_jspx_th_c_out_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_37);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_37);
    return false;
  }

  private boolean _jspx_meth_c_out_38(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_38 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_38.setPageContext(_jspx_page_context);
    _jspx_th_c_out_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_38.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.e}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_38 = _jspx_th_c_out_38.doStartTag();
    if (_jspx_th_c_out_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_38);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_38);
    return false;
  }

  private boolean _jspx_meth_c_out_39(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_39 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_39.setPageContext(_jspx_page_context);
    _jspx_th_c_out_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_39.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.pr}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_39 = _jspx_th_c_out_39.doStartTag();
    if (_jspx_th_c_out_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_39);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_39);
    return false;
  }

  private boolean _jspx_meth_c_out_40(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_40 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_40.setPageContext(_jspx_page_context);
    _jspx_th_c_out_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_40.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.rock}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_40 = _jspx_th_c_out_40.doStartTag();
    if (_jspx_th_c_out_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_40);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_40);
    return false;
  }

  private boolean _jspx_meth_c_out_41(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_41 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_41.setPageContext(_jspx_page_context);
    _jspx_th_c_out_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_41.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.seq}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_41 = _jspx_th_c_out_41.doStartTag();
    if (_jspx_th_c_out_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_41);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_41);
    return false;
  }

  private boolean _jspx_meth_c_out_42(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_42 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_42.setPageContext(_jspx_page_context);
    _jspx_th_c_out_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_42.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.reff}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_42 = _jspx_th_c_out_42.doStartTag();
    if (_jspx_th_c_out_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_42);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_42);
    return false;
  }

  private boolean _jspx_meth_c_out_43(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_43 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_43.setPageContext(_jspx_page_context);
    _jspx_th_c_out_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_43.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.notes}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_43 = _jspx_th_c_out_43.doStartTag();
    if (_jspx_th_c_out_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_43);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_43);
    return false;
  }

  private boolean _jspx_meth_c_out_44(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_44 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_44.setPageContext(_jspx_page_context);
    _jspx_th_c_out_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_44.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list.avgb}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_44 = _jspx_th_c_out_44.doStartTag();
    if (_jspx_th_c_out_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_44);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_44);
    return false;
  }
}
