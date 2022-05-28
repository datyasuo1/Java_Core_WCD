package com.example.karma_shops.controller.admin.product;

import com.example.karma_shops.entity.Product;
import com.example.karma_shops.model.CategoryModel;
import com.example.karma_shops.model.MySqlCategoryModel;
import com.example.karma_shops.model.MySqlProductModel;
import com.example.karma_shops.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailProductServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;

    public DetailProductServlet() {
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
            req.getRequestDispatcher("/admin/products/detail.jsp").forward(req, resp);
        }
    }


}
