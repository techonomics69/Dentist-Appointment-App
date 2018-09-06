<%-- 
    Document   : DenInfopage
    Created on : Jul 19, 2018, 12:11:25 AM
    Author     : Kiaito
--%>

<%@page import="dentist.Dentist"%>
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

        <% Dentist dn;
            dn = (Dentist) session.getAttribute("dn");

            dn.display();


        %>

        <h2> Hello <%= dn.getDenfname() + " " + dn.getDenlname()%> </h2>


        <h5> User Id: <%= dn.getDenid()%> </h5>
        <h5> First Name:  <%= dn.getDenfname()%>  &nbsp; Last Name: <%= dn.getDenlname()%> </h5>
        <h5> Email: <%= dn.getDenemail()%> &nbsp; office: <%= dn.getDenoffice()%> </h5>



        <%--  <% for (int i = 0; i < dn.alists.count; i++) {
              
                  out.println("<h1> Appointment time and date is "+ dn.alists.alist[i].getapptime()+ "Your Dentist code is "+ dn.alists.alist[i].getdenit() ); 
          
          %> <br><% }%> --%>

        <%for (int i = 0; i < dn.alists.count; i++) {
                int x = i + 1;
                out.println("<h4>Appointment #" + x + dn.alists.alist[i].getapptime() + " Patient id: " + dn.alists.alist[i].getpatida()
                        + " Procode is: " + dn.alists.alist[i].getprocode());
        %><br><%  }%>

        <h6> <a href="editdentist.jsp">Edit your info here</a></h6>

    </body>
</html>
