package controller.servlet;

import model.helper.Database;
import model.bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //check login input
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Database db = new Database();
        boolean result =  db.checkLogin(new User(username,password));

        //output
        PrintWriter out = response.getWriter();
        if(result) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user",username);
            //System.out.println("Login successfully!!!");
            request.setAttribute("message","Login successfully!!! Please waiting for a while...");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/user/success.jsp");
            requestDispatcher.forward(request, response);
        }else{
            out.print("<p>Login Failed!</p>" +
                    "      <hr/>" +
                    "      <p>Please try again !!! <a href=\"home?page=login\">Log in</a></p>");
        }
    }
}