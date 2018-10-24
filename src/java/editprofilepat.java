/*
 *  Author     : Levi Llewellyn
 */

import dentist.Patients;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * This servlet is to edit the profile info for patients
 */
@WebServlet(urlPatterns = {"/editprofilepat"})
public class editprofilepat extends HttpServlet {

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

        // Pulling the patient object from session
        Patients pt;
        HttpSession session = request.getSession();
        pt = (Patients) session.getAttribute("pt");

        String id;
        String pw;
        String fn;
        String ln;
        String add;
        String em;
        String in;
        
        id = request.getParameter("patid");
        pw = request.getParameter("patpw");
        fn = request.getParameter("patfn");
        ln = request.getParameter("patln");
        add = request.getParameter("patadd");
        em = request.getParameter("patem");
        in = request.getParameter("patin");
        
        

        pt.setpatid(id);
        pt.setpatpw(pw);
        pt.setpatfn(fn);
        pt.setpatln(ln);
        pt.setpatadd(add);
        pt.setpatem(em);
        pt.setpatinsco(in);
        pt.updateDB();

        
        session.setAttribute("pt", pt);

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
