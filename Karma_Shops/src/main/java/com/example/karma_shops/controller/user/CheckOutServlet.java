package com.example.karma_shops.controller.user;


import com.example.karma_shops.entity.Product;
import com.example.karma_shops.entity.shoppingcart.*;
import com.example.karma_shops.model.MySqlProductModel;
import com.example.karma_shops.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CheckOutServlet extends HttpServlet {
    private ShoppingCartModel shoppingCartModel;
    private CartItemModel cartItemModel;

    public CheckOutServlet() {
        this.shoppingCartModel = new MySQLShoppingCartModel();
        this.cartItemModel = new MySQLCartItemModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }
        req.setAttribute("cart_item", shoppingCart);
        req.getRequestDispatcher("/user/page/checkout.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if (shoppingCart == null){
            req.setAttribute("message","Error!!");
            req.getRequestDispatcher("/user/errors/404.jsp").forward(req,resp);
            return;
        }
        try{
            String shipName = req.getParameter("firstname")+ " " + req.getParameter("lastname");
            String shipPhone = req.getParameter("shipPhone");
            String shipAddress = req.getParameter("shipAddress");
            String shipNote = req.getParameter("shipNote");
            double totalPrice = Double.parseDouble(req.getParameter("totalPrice"));
            ShoppingCart shoppingCart1 = new ShoppingCart();
            shoppingCart1.setUserId(1);
            shoppingCart1.setShipName(shipName);
            shoppingCart1.setShipPhone(shipPhone);
            shoppingCart1.setShipAddress(shipAddress);
            shoppingCart1.setShipNote(shipNote);
            shoppingCart1.setTotalPrice(totalPrice);
            if (!shoppingCart1.isValid()){

                req.getRequestDispatcher("/user/cart/checkout.jsp").forward(req,resp);
            }
            if (shoppingCartModel.save(shoppingCart1) != null){
                List<CartItem> items = shoppingCart.getListItems();
                for (int i = 0; i < items.size(); i++) {
                    cartItemModel.save(items.get(i));
                }
                session.removeAttribute("shoppingCart");
                resp.sendRedirect("/product");
            }else {
                req.getRequestDispatcher("/user/page/checkout.jsp").forward(req,resp);
            }

        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("message","Error!!");
            req.getRequestDispatcher("/user/errors/500.jsp").forward(req,resp);
        }

    }
}
