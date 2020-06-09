package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckServlet extends HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        //check session information
        Object username = session.getAttribute("username");
        if(username !=null) {
            out.print("<p>There is a session variable 'username' = " + username + "</p>" +
                    "      <p><a href=\"logout\">Log out</a></p>");
        }else{
            out.print("<p>There is not a session variable 'username'</p>" +
                    "      <hr/>" +
                    "      <p>Please login !!! <a href=\"login\">Log in</a></p>");
        }
    }
}
