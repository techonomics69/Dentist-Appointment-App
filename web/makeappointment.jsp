<%@page import="dentist.Appoint"%>
<%@page import="dentist.Patients"%>
0<%-- 
    Document   : makeappointment
    Created on : Jul 25, 2018, 12:34:26 AM
    Author     : Kiaito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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


        <h1> Hello <%=pt.getpatfn() + "  " + pt.getpatln()%> </h1>

        <h5> Make your appointment below</h5>
        <div class="form">
            <form action="makeappservlet" method="Post">

                Month:
                <select name="month">
                    <option value="Jan">January</option> <option value="Feb">February</option>
                    <option value="Mar">March</option> <option value="Apr">April</option>
                    <option value="May">May</option> <option value="Jun">June</option>
                    <option value="Jul">July</option> <option value="Aug">August</option>
                    <option value="Sep">September</option> <option value="Oct">October</option>
                    <option value="Nov">November</option> <option value="Dec">December</option>
                </select>

                Date:
                <select name="date">
                    <option value="1">1</option> <option value="2">2</option> <option value="3">3</option>
                    <option value="4">4</option> <option value="5">5</option> <option value="6">6</option>
                    <option value="7">7</option> <option value="8">8</option> <option value="9">9</option>
                    <option value="10">10</option> <option value="11">11</option> <option value="12">12</option>
                    <option value="13">13</option> <option value="14">14</option> <option value="15">15</option>
                    <option value="16">16</option> <option value="17">17</option> <option value="18">18</option>
                    <option value="19">19</option> <option value="20">20</option> <option value="21">21</option>
                    <option value="22">22</option> <option value="23">23</option> <option value="24">24</option>
                    <option value="25">25</option> <option value="26">26</option> <option value="27">27</option>
                    <option value="28">28</option> <option value="29">29</option> <option value="30">30</option>
                    <option value="31">31</option>

                </select>


                Year:
                <input type="text"  readonly="readonly" value= "2018"  name="year">

                Time
                <select name="time">
                    <option value="9:00am">9:00 am</option> <option value="10:00am">10:00 am</option>
                    <option value="11:00am">11.00 am</option> <option value="12:00pm">12.00 pm</option>
                    <option value="1:00pm">1:00 pm</option> <option value="2:00pm">2:00 pm</option>
                    <option value="3:00pm">3:00 pm</option> <option value="4:00pm">4.00 pm</option>
                    <option value="5:00pm">5:00 pm</option> 

                </select>
                <br><br>
                Dentist:
                <select name="dentid">
                    <option value="D201 ">Frank Martin</option>
                    <option value="D202 ">Susan Cassidy</option>
                    <option value="D203 ">Jerry York</option>
                    <option value="D204 ">Wayne Patterson</option>
                </select>

                Insurance:
                <select name="ins">
                    <option value="Cigna">Cigna</option>
                    <option value="Aetna">Aetna</option>
                    <option value="Blue Cross">Blue Cross</option>

                </select>

                Procedures:
                <select name="pro">
                    <option value="P114">Cleaning/Exam ($99.99)</option>
                    <option value="P119">Xrays ($320.00)</option>
                    <option value="P122">Whitening (129.99)</option>
                    <option value="P321">Cavity ($319.00)</option>
                    <option value="P650">Top Dentures ($1950.00)</option>
                    <option value="P660">Bottom Dentures ($1950.00)</option>
                    <option value="P780">Crown ($795.00)</option>
                    <option value="P790">Root Canal ($1019.00)</option>

                </select>

                <br><br>

                <button type="submit" value="Submit" name="Submit" class="butt">Submit</button>

                <br><br>

            </form>
        </div>

    </body>
</html>
