package servlet;

import data.Database;
import data.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //destroy session
        HttpSession session = request.getSession();
        session.invalidate();

        //redirect to login page
        response.sendRedirect("login");
    }
}
