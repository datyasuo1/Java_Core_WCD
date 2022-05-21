package com.t2010a.javashopping.controller.admin.product;

import com.t2010a.javashopping.entity.Product;
import com.t2010a.javashopping.model.MySqlProductModel;
import com.t2010a.javashopping.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class EditProductServlet extends HttpServlet {
    private ProductModel productModel;

    public EditProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = productModel.findById(id);

        if (product == null){
            req.setAttribute("message","Data not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req,resp);
        }else {
            req.setAttribute("title", "Edit Product");
            req.setAttribute("product",product);
            req.setAttribute("action",2);
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        Product productModelById = productModel.findById(id);
        if (productModelById == null){
            req.setAttribute("message","Data not found!");
            req.getRequestDispatcher("/admin/error/404.jsp").forward(req,resp);
        }else {
            String name = req.getParameter("name");
            double price = Double.valueOf(req.getParameter("price"));
            String content = req.getParameter("content");
            String size = req.getParameter("size");
            int qty = Integer.parseInt(req.getParameter("qty"));
            int sku = Integer.parseInt(req.getParameter("sku"));
            String category = req.getParameter("category");
            String tag = req.getParameter("tag");
            Product product = new Product(id, name, price, content,size,qty,sku,category,tag );

            if (productModel.update(id, product) != null) {
                resp.sendRedirect("/admin/products/list");
            } else {
                req.setAttribute("title", "Edit Product");
                req.setAttribute("product", price);
                req.setAttribute("action", 2);
                req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            }

        }
    }
}
