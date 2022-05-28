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
import java.util.ArrayList;
import java.util.List;

public class FilterCategoryServlet extends HttpServlet {

    private ProductModel productModel ;
    private CategoryModel categoryModel;
    public FilterCategoryServlet(){
        this.productModel =  new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Product> products = productModel.findByCateId(id);
        if (products == null){
            products = new ArrayList<>();
        }
        req.setAttribute("products",products);
        req.setAttribute("categories",categoryModel.findAll());
        req.getRequestDispatcher("/user/page/filtercate.jsp").forward(req,resp);


    }
}
