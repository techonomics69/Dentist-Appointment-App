/*
 *  Author     : Levi Llewellyn
 */

import dentist.Dentist;
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
 * This servlet is to edit the dentist profile info
 */
@WebServlet(urlPatterns = {"/editdprofile"})
public class editdprofile extends HttpServlet {

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
    
        // Pulling the business object from the sessions
    Dentist dn;
    HttpSession session = request.getSession();
    dn = (Dentist) session.getAttribute("dn"); 
    
            
            String pw;
            String fn;
            String ln;
            String em;
            String off;
            
            pw = request.getParameter("denpw");
            fn = request.getParameter("denfname");
            ln = request.getParameter("denlname");
            em = request.getParameter("denemail");
            off = request.getParameter("denoffice");
            
            dn.setDenpass(pw);
            dn.setDenfname(fn);
            dn.setDenlname(ln);
            dn.setDenemail(em);
            dn.setDenoffice(off);
            dn.updateDB();
            
           // HttpSession ses4 = request.getSession();
        session.setAttribute("dn", dn);
          
        
            RequestDispatcher rd = request.getRequestDispatcher("DenInfopage.jsp");
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
