package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession session = request.getSession();
        
        String username = (String) session.getAttribute("username");
 
        if (username == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
         
        } else {
           request.setAttribute("username", username);   
           getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
           
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       HttpSession session = request.getSession();
        
        String logout = request.getParameter("logout");
        
        if (logout != null) {
           session.setAttribute("logout", logout);
           response.sendRedirect("login");
     
        }

    }

}
