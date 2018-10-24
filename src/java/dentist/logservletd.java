
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
  *  Author     : Levi Llewellyn
 * This is the servlet class for the dentist login
 */
@WebServlet(name = "logservletd", urlPatterns = {"/logservletd"})
public class logservletd extends HttpServlet {

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
   
     
         String id, pass, valid;

        id = request.getParameter("id");
        pass = request.getParameter("pass");
        System.out.println(id + pass);

        Dentist dn = new Dentist();
        dn.selectDB(id);
        String pwdb = dn.getDenpass();
        
        HttpSession ses4 = request.getSession();
        ses4.setAttribute("dn", dn);
        
        
        Appoint az = new Appoint();
        az.selectDBD(id);
        String des = az.getprocode();
        System.out.println("This is the test"+ des);
        
        HttpSession ses5;
        ses5 = request.getSession();
        ses5.setAttribute("az", az);

         //System.out.println(id + pwdb + pass);
        if ((pass.equals(pwdb))) {
            
            RequestDispatcher rd = request.getRequestDispatcher("DenInfopage.jsp");
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
    }
}


        
        
        
        
  