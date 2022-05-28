package com.example.karma_shops.controller.user;

import com.example.karma_shops.entity.Product;
import com.example.karma_shops.model.CategoryModel;
import com.example.karma_shops.model.MySqlCategoryModel;
import com.example.karma_shops.model.MySqlProductModel;
import com.example.karma_shops.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ProductDetailServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;

    public ProductDetailServlet() {
        this.categoryModel = new MySqlCategoryModel();
        this.productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(id);
        if (product == null) {
            req.setAttribute("message", "Data not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            req.setAttribute("obj", product);
            req.setAttribute("category", categoryModel.findAll());
            req.getRequestDispatcher("/user/page/products_detail.jsp").forward(req, resp);
        }
    }
}
