package servlet;

import data.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //check login input
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        System.out.println("remember:"+remember);

        Database db = new Database();
        boolean result =  db.checkLogin(new User(username,password));

        //output
        PrintWriter out = response.getWriter();
        if(result) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username",username);
            out.print("<p>Login Successfully!</p>" +
                    "      <hr/>" +
                    "      <h3>Welcome " + username + "</h3>" +
                    "      <p>View session information in another web page, please click to the link: <a href=\"check\">Check</a></p>" +
                    "      <p><a href=\"logout\">Log out</a></p>");

            if(remember !=null && remember.equals("on")){

                //create cookies
                Cookie [] cookies = new Cookie[2];
                cookies[0] = new Cookie("username",username);
                cookies[1] = new Cookie("password",password);
                for (Cookie c: cookies) {
                    //c.setDomain("localhost:8080/lab12_war");
                    c.setMaxAge(30*24*60*60);
                    //c.setPath("/login");
                    //c.setComment("Test");
                    //c.setVersion(123);
                    //c.setSecure(false);
                    //c.setHttpOnly(false);
                    response.addCookie(c);
                    System.out.println("A cookie has been created!");
                }

                //create a persistent cookie named promo and save value $100 inside the cookie that last for a month in user's machine
                Cookie pCookie = new Cookie("promo" , "$100");
                //pCookie.setMaxAge();
                response.addCookie(pCookie);

                out.close();
            }


        }else{
            out.print("<p>Login Failed!</p>" +
                    "      <hr/>" +
                    "      <p>Please try again !!! <a href=\"login\">Log in</a></p>");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html>\n" +
                "  <head>\n" +
                "    <title>Login</title>\n" +
                "    <script src=\"login.js\" language=\"javascript\"></script>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <h3>Login</h3>\n" +
                "    <form method=\"post\" action=\"login\">\n" +
                "      <table>\n" +
                "        <tr>\n" +
                "          <td><label for=\"username\">User Name</label></td>\n" +
                "          <td><input type=\"text\" name=\"username\" id=\"username\"></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td><label for=\"password\">Password</label></td>\n" +
                "          <td><input type=\"password\" name=\"password\" id=\"password\"></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td align=\"right\"><input type=\"checkbox\" name=\"remember\" id=\"remember\"></td>\n" +
                "          <td><label for=\"remember\">Remember Me</label></td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "      <input type=\"submit\" id=\"login\" value=\"Login\">\n" +
                "    </form>\n" +
                "  </body>\n" +
                "</html>");

    }
}
