<%-- 
    Document   : editpatient
    Created on : Jul 24, 2018, 9:12:48 AM
    Author     : Kiaito
--%>

<%@page import="dentist.Patients"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
    <% Patients pt;
            pt = (Patients) session.getAttribute("pt"); 
    %>
    <head>
        <link rel="stylesheet" type="text/css" href="mycss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div id="main">
                    <h2> Edit the fields below to update your profile info</h2>
                </div>
                <div class="form">
                    <form action="editprofilepat" method="Post">

                        Patient Id:
                        <input type="text"  readonly="readonly"  value="<%=pt.getpatid() %>" name="patid">
                        <br><br>
                        Patient Password:
                        <input type="text"  value="<%=pt.getpatpw() %> " name="patpw">
                        <br><br>
                        Patient First Name:
                        <input type="text" value="<%=pt.getpatfn()%> " name="patfn">
                        <br><br>
                        Patient Last Name:
                        <input type="text" value="<%=pt.getpatln() %> " name="patln">
                        <br><br>
                        Patient Address:
                        <input type="text" value="<%=pt.getpatadd() %> " name="patadd">
                        <br><br>
                        Patient Email:
                        <input type="text" value="<%=pt.getpatem()  %>" name="patem">
                        <br><br>
                        Patient Insurance:
                        <input type="text" value=" <%= pt.getpatinsco() %>" name="patin">
                        <br><br>
                        
                        <button type="submit" value="Submit" name="Submit" class="butt">Submit</button>
                        
                        <br><br>

                    </form>
                </div>

    </body>
</html>
