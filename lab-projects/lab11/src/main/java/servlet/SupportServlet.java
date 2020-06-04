package servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class SupportServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //input
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String supportEmail = getServletContext().getInitParameter("support_email");
        long supportTicketId = System.currentTimeMillis();
        //output
        PrintWriter out = response.getWriter();
        out.print("<p>\n" +
                "      Thank you! " + name + " for contacting us. We should receive reply from us with in 24 hrs in\n" +
                "      your email address " + email + ". Let us know in our support email " + supportEmail +" if\n" +
                "      you don’t receive reply within 24 hrs. Please be sure to attach your reference\n" +
                "      " + supportTicketId +" in your email.\n" +
                "    </p>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html>\n" +
                "  <head>\n" +
                "    <title>CS Tech Support</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <h1>CS Tech Support Form</h1>\n" +
                "    <form method=\"post\" action=\"support\">\n" +
                "      <table>\n" +
                "        <tr>\n" +
                "          <td><label for=\"name\">Name</label></td>\n" +
                "          <td><input type=\"text\" name=\"name\" id=\"name\"></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td><label for=\"email\">Email Address</label></td>\n" +
                "          <td><input type=\"text\" name=\"email\" id=\"email\"></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td><label for=\"problem\">Problem</label></td>\n" +
                "          <td><input type=\"text\" name=\"problem\" id=\"problem\"></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td><label for=\"description\">Problem Description</label></td>\n" +
                "          <td><textarea name=\"description\" id=\"description\" rows=\"5\" cols=\"30\"></textarea></td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "      <input type=\"submit\" value=\"Help\">\n" +
                "    </form>\n" +
                "  </body>\n" +
                "</html>");

    }
}
