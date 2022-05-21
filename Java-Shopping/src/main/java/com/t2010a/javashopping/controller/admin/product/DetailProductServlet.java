package com.t2010a.javashopping.controller.admin.product;

import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.model.MySqlProductModel;
import com.t2010a.javashopping.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DetailProductServlet extends HttpServlet {
    private ProductModel productModel;

    public DetailProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("title", "Detail Product");
        Product product = productModel.findById(id);

        if (product == null) {
            req.setAttribute("message", "Data not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            //ArrayList<Product> recentView = (ArrayList<Product>) session.getAttribute("recentView");
            /*if (recentView == null){
                recentView = new ArrayList<Customer>();
            }
            boolean exists = false;
            for (int i = 0; i < recentView.size();i++){
                if (recentView.get(i).getId().equals(customer.getId()));{
                    exists = true;
                }
            }
            if (!exists){
                recentView.add(customer);
                session.setAttribute("recentView",recentView);
            }*/
            req.setAttribute("product", product);
            req.getRequestDispatcher("/admin/products/detail.jsp").forward(req, resp);
        }
    }
}
