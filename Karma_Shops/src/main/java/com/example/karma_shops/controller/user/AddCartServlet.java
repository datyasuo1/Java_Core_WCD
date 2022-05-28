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

public class AddCartServlet extends HttpServlet {
    private ProductModel productModel;
    public AddCartServlet(){
        this.productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if (shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }try {
            int productId =Integer.parseInt( req.getParameter("id"));
            int qty = Integer.parseInt(req.getParameter("qty"));
            Product product = productModel.findById(productId);
            if (product == null){
                req.getRequestDispatcher("/user/error/404.jsp").forward(req,resp);
                return;
            }
            if (qty <= 0){
                req.getRequestDispatcher("/user/error/404.jsp").forward(req,resp);
                return;
            }
            shoppingCart.add(product, qty);
            session.setAttribute("shoppingCart",shoppingCart);
            resp.sendRedirect("/cart/show");
        }catch (Exception e){
            e.printStackTrace();
            req.getRequestDispatcher("/user/error/500.jsp").forward(req,resp);
        }


    }
}
