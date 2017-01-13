<%-- 
    Document   : newUser
    Created on : Jan 7, 2017, 10:40:15 PM
    Author     : Lungelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form  id="register_user"    action ="RegisterUser"method="POST"  autocomplete="off">
                                <fieldset >
                                    <legend class="formLegend"><b>New User</b></legend>

                                    <table   cellpadding = "10"  border="0"class="table table-hover table-bordered" >
                                        <tr>
                                            <td>User Name<span  style="color:red">*</span></td>
                                            <td><div class="col-lg-4"><input type="text" name="username" maxlength="45" class="form-control" />
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Password<span  style="color:red">*</span></td>
                                            <td>

                                                <div class="col-lg-4"><input type="text" name="password" maxlength="45" class="form-control"   /></div>

                                            </td>
                                        </tr>

                                        <td>First Name<span  style="color:red">*</span></td>
                                        <td> <div class="col-lg-4"><input type="text" name="firstName" maxlength="45" class="form-control" /></div>

                                        </td>
                                        </tr>
                                        <tr>
                                            <td> Last Name<span  style="color:red">*</span></td>
                                            <td><div class="col-lg-4"><input type="text" name="lastName" maxlength="45" class="form-control" /></div>

                                            </td>
                                        </tr>

                                        <tr>
                                            <td>Email Address <span  style="color:red">*</span></td>
                                            <td><div class="col-lg-4"><input type="text" name="email" maxlength="45" class="form-control" /></td></div>
                                        </tr>

                                        <tr>
                                            <td> Role <span  style="color:red">*</span></td>

                                            <td>

                                                <div class="col-lg-4">  <select id="role" name= "role"  class="form-control"" > 
                                                        <option value="">Select Role</option>
                                                       
                                                            <option value="1"> Admin</option>
                                                            <option value="0"> Other</option>  
                                                       

                                                    </select>                               

                                                </div>

                                            </td>
                                        </tr>
                                  


                                       

                                        <tr>
                                            <td></td>
                                            <td> <div class="col-lg-4"><button type="submit" > Add</button>
                                                    <button type="reset" >Clear All</button></div></td>
                                        </tr>

                                        </tr>
                                    </table>

                                    <p><span style="color:red">* required field.</span></p>
                                </fieldset>

                            </form>
    </body>
</html>
