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
 * The is the servlet the the patient login
 */
@WebServlet(name = "logservletp", urlPatterns = {"/logservletp"})
public class logservletp extends HttpServlet {

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

        String id, pass, valid;

        id = request.getParameter("id");
        pass = request.getParameter("pass");
        System.out.println(id + pass);

        Patients pt = new Patients();
        pt.selectDB(id);
        String pwdb = pt.getpatpw();
        
            HttpSession ses1;
        ses1 = request.getSession();
        //setting the object in session
        ses1.setAttribute("pt", pt);
        
        
        Appoint ap = new Appoint();
        ap.selectDBP(id);
        String des = ap.getprocode();
        System.out.println("Testing appointments code"+ des);
        
        HttpSession ses2;
        ses2 = request.getSession();
        ses2.setAttribute("ap", ap);
        
        Procedure pd = new Procedure();
        pd.selectDBP(des);
        
        HttpSession ses3;
        ses3 = request.getSession();
        ses3.setAttribute("pd", pd);
        
        
        //System.out.println(id + pwdb + pass);
        if ((pass.equals(pwdb))) {
            RequestDispatcher rd = request.getRequestDispatcher("PatDisp.jsp");
            rd.forward(request, response);
            
            
        } else {
             RequestDispatcher rd = request.getRequestDispatcher("/Errorpage.jsp");
             rd.forward(request, response);
        }
        
    
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
