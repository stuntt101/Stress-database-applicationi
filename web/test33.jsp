<%-- 
    Document   : test33
    Created on : 21 Feb 2017, 10:47:25 AM
    Author     : LQwabe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
<form action="" method="post">
<script type="text/javascript">
    function ValidateExtension() {
        var allowedFiles = [".doc", ".docx", ".pdf",".png",".jpeg",".jpg",".gif",".xls","xlsx",".csv"];
        
       
        var fileUpload = document.getElementById("fileUpload");
        //var lblError = document.getElementById("lblError");
        var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
        if (!regex.test(fileUpload.value.toLowerCase())) {
            
           alert("Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.");
           fileUpload.value="";
        }
        
    }
</script>
<input id="fileUpload" type="file"  onchange="return ValidateExtension()"/>
<!--<br />
<span id="lblError" style="color: red;"></span>
<br />-->
<!--<input type="submit" id="btnUpload" value="Upload" onclick="return ValidateExtension()" />-->
</form>

    </body>
</html>
