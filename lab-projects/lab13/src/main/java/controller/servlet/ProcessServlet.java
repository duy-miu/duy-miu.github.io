package controller.servlet;

import model.helper.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class ProcessServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Database db = new Database();
        //db.updateStock(productId, quantity);
        request.setAttribute("message","Process successfully!!! Thank you for your shopping!!!");
        //remove session
        request.getSession().invalidate();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
        requestDispatcher.forward(request, response);

    }
}