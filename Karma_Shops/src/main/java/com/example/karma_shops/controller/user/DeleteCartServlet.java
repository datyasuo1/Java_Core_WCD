package com.example.karma_shops.controller.user;

import com.example.karma_shops.entity.Product;
import com.example.karma_shops.entity.shoppingcart.ShoppingCart;
import com.example.karma_shops.model.MySqlProductModel;
import com.example.karma_shops.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteCartServlet extends HttpServlet {
    private ProductModel productModel;
    public DeleteCartServlet(){
        this.productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        int productId =Integer.parseInt( req.getParameter("id"));
        Product product = productModel.findById(productId);
        if (product == null){
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/user/error/404.jsp").forward(req,resp);
            return;
        }
        shoppingCart.remove(product);
        session.setAttribute("shoppingCart",shoppingCart);
        resp.sendRedirect("/cart/show");
    }
}
