package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;

public class LoginServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String logout = (String) session.getAttribute("logout");
        String username = (String) session.getAttribute("username");

        if (username != null && logout == null) {
            response.sendRedirect("home");
            
        } else if (logout != null) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("logout", logout);
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean invalid;

        if (username.equals("") || password.equals("")) {
           invalid = true;
           
        } else {
            User user =  new AccountService().login(username, password);
            if (user == null) {
                invalid = true;
                
            } else {
                invalid = false;
                session.setAttribute("username", username);
                response.sendRedirect("home");
            }
        }
       
        if (invalid == true) {
            request.setAttribute("invalid", true);
            request.setAttribute("username", username);
            request.setAttribute("password", password); 

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
         }
    }        
        

}
