<%-- 
    Document   : editp
    Created on : Jul 23, 2018, 6:04:56 PM
    Author     : Kiaito
--%>

<%@page import="dentist.Dentist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% Dentist dn;
            dn = (Dentist) session.getAttribute("dn"); 
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
                    <form action="editdprofile" method="Post">

                        Dentist Id:
                        <input type="text"  readonly="readonly"  value="<%=dn.getDenid() %>" name="denid">
                        <br><br>
                        Dentist Password:
                        <input type="text" value="<%=dn.getDenpass()%> " name="denpw">
                        <br><br>
                        Dentist First Name:
                        <input type="text" value="<%=dn.getDenfname()%> " name="denfname">
                        <br><br>
                        Dentist Last Name:
                        <input type="text" value="<%=dn.getDenlname()%> " name="denlname">
                        <br><br>
                        Dentist Email:
                        <input type="text" value="<%= dn.getDenemail()%>" name="denemail">
                        <br><br>
                        Dentist Office:
                        <input type="text" value=" <%= dn.getDenoffice()%>" name="denoffice">
                        <br><br>
                        
                        <button type="submit" value="Submit" name="Submit" class="butt">Submit</button>
                        
                        <br><br>

                    </form>
                </div>

    </body>
</html>
