package com.example.karma_shops.controller.user;

import com.example.karma_shops.entity.Category;
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
import java.util.List;

public class ListProductUserServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;

    public ListProductUserServlet(){
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productModel.findAll();
        List<Category> categories = categoryModel.findAll();
        req.setAttribute("products",products);
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/user/page/products.jsp").forward(req,resp);
    }
}
