<%-- 
    Document   : index
    Created on : Jul 12, 2018, 7:06:35 PM
    Author     : Kiaito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="mycss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1> Error Logging in please try again</h1>
        <div id="form">
            <form method="Post" action="logservletp">
                Username:
                <input type="text" placeholder="User Id" name="id">
                <br><br>
                Password:
                <input type="password" placeholder="Password" name="pass">

                <br><br>
                <input type="submit" value="Sign IN" class="but">
                <br>
                <h6> <a href="dentlog.jsp">Dentist Login Here</a></h6>


                <br><br>
            </form>
        </div>
    </body>
</html>