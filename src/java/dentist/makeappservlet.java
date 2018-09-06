/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dentist;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * This is the servlet to make new appointments
 */
@WebServlet(name = "makeappservlet", urlPatterns = {"/makeappservlet"})
public class makeappservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Patients pt;
        HttpSession session = request.getSession();
        pt = (Patients) session.getAttribute("pt");
   
          Procedure pd;
          pd = (Procedure) session.getAttribute("pd");
          

        String month, date, time, year, dentid, patid, ins, pro, apptdate;
        month = request.getParameter("month");
        date = request.getParameter("date");
        year = request.getParameter("year");
        time = request.getParameter("time");
        
        ins = request.getParameter("ins");
        pro = request.getParameter("pro");
        patid = pt.getpatid();
       
        dentid = request.getParameter("dentid");
        
    
        
        apptdate = month + " "+date+" "+ year+ " "+time;

        Appoint ap = new Appoint();
        ap.setapptime(apptdate);
        ap.setdenit(dentid +" ");
        ap.setpatida(patid + " ");
        ap.setprocode(pro);
        ap.insertDB();
        System.out.println("insert method for appointment call");
       
        pd.selectDBP(pro);
        String des = pd.getpdes();
        
       
        session.setAttribute("ap", ap);
        session.setAttribute("pd", pd);
        
        RequestDispatcher rd = request.getRequestDispatcher("PatDisp.jsp");
            rd.forward(request, response);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
