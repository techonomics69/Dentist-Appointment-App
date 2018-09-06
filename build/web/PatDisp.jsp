<%-- 
    Document   : Disinfop
    Created on : Jul 17, 2018, 4:18:52 PM
    Author     : Kiaito
--%>

<%@page import="dentist.Procedure"%>
<%@page import="dentist.Appoint"%>
<%@page import="dentist.Patients"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="mycss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <% Patients pt;
            pt = (Patients) session.getAttribute("pt");

            Appoint ap;
            ap = (Appoint) session.getAttribute("ap");

            Procedure pd;
            pd = (Procedure) session.getAttribute("pd");
        %>
        <h2> Hello <%= pt.getpatfn() + " " + pt.getpatln()%> </h2>



        <h5> User Id: <%= pt.getpatid()%> </h5>
        <h5> First Name: <%= pt.getpatfn()%> 
            Last Name: <%= pt.getpatln()%> </h5>
        <h5> Address: <%= pt.getpatadd()%> </h5>
        <h5> User Email: <%= pt.getpatem()%> </h5>
        <h5> User Insurance: <%= pt.getpatinsco()%> </h5>
        <h5> Appointment Time: <%= ap.getapptime()%> </h5>
        <h5> Dentist Id: <%= ap.getdenit()%> </h5>
        <h5> Procedure Code: <%= ap.getprocode()%> </h5>
        <h5> Procedure Description: <%=pd.getpdes()%> </h5>

        <h5> <a href="editpatient.jsp">Edit your info here</a></h5>


        <% if (ap.getapptime() == null) {%>
        <h5> <a href="makeappointment.jsp">make your appointment</a></h5> 

        <%  }%>

    </body>
</html>
