package controller.servlet;

import model.bean.Product;
import model.bean.Item;
import model.helper.Database;
import model.helper.Cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String page = request.getParameter("page");
        String result = "/view/store/error.jsp";

        Database db = new Database();
        if (page != null) {
            if (page.equals("product")) {
                List<Product> productList = db.getProducts();
                request.setAttribute("productList", productList);
                result = "/view/store/product.jsp";
            } else if (page.equals("cart")) {
                try {
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    Integer quantity = Integer.parseInt(request.getParameter("quantity"));
                    String action = request.getParameter("action");

                    //find product
                    Product product = db.findProduct(id);
                    Item item = new Item(id, product.getName(), product.getUnitPrice(), quantity);

                    //check cart
                    HttpSession session = request.getSession();
                    Object cartObj = session.getAttribute("cart");
                    Cart cart;
                    if (cartObj != null) {
                        cart = (Cart) cartObj;
                    } else {
                        cart = new Cart();
                    }
                    //action
                    if (action != null) {
                        if (action.equals("add")) {
                            cart.addItem(item);
                        } else if (action.equals("remove")) {
                            cart.removeItem(item);
                        }
                        session.setAttribute("cart", cart);
                    }
                    result = "/view/store/cart.jsp";
                } catch (Exception e) {
                    request.setAttribute("errMsg", e.getMessage());
                }

            } else if (page.equals("checkout")) {
                //System.out.println("Go to checkout page ...");
                result = "/view/user/checkout.jsp";
            } else if (page.equals("login")) {
                //System.out.println("Go to login page ...");
                result = "/view/store/login.jsp";
            } else if (page.equals("process")) {
                //System.out.println("Go to confirmation page ...");
                result = "/view/store/process.jsp";
            }

        } else {
            request.setAttribute("errMsg", "Request is null");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(result);
        requestDispatcher.forward(request, response);
    }
}