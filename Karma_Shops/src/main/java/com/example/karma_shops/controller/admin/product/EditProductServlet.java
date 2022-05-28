package com.example.karma_shops.controller.admin.product;

import com.example.karma_shops.entity.Product;
import com.example.karma_shops.entity.myenum.ProductStatus;
import com.example.karma_shops.model.CategoryModel;
import com.example.karma_shops.model.MySqlCategoryModel;
import com.example.karma_shops.model.MySqlProductModel;
import com.example.karma_shops.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProductServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;

    public EditProductServlet() {
        this.categoryModel = new MySqlCategoryModel();
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(id);
        // nếu không trả về trang 404
        if (product == null) {
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            // nếu có trả về trang detail
            req.setAttribute("category", categoryModel.findAll());
            req.setAttribute("title","Edit Product");
            req.setAttribute("obj", product);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Product productModelById = productModel.findById(id);
        if (productModelById == null) {
            req.setAttribute("message", "Data not found!");
            req.getRequestDispatcher("/admin/error/404.jsp").forward(req, resp);
        }else{
        String name = req.getParameter("name");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        String thumbnail = req.getParameter("thumbnail");
        double price =Double.parseDouble(req.getParameter("price"));
        int qty = Integer.parseInt(req.getParameter("qty"));
        int status = Integer.parseInt(req.getParameter("status"));
        Product product = new Product();
        product.setName(name);
        product.setCategoryId(categoryId);
        product.setDescription(description);
        product.setDetail(detail);
        product.setThumbnail(thumbnail);
        product.setPrice(price);
        product.setQty(qty);
        product.setStatus(ProductStatus.of(status));
        if (!product.isValid()) {
            req.setAttribute("category", categoryModel.findAll());
            req.setAttribute("obj", product);
            req.setAttribute("action", 2);
            req.setAttribute("errors", product.getErrors());
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            return;
        }
        if (productModel.update(id,product) != null){
            resp.sendRedirect("/admin/products/list");
        }else {
            req.setAttribute("category", categoryModel.findAll());
            req.setAttribute("title","Edit Product");
            req.setAttribute("obj", product);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            }
        }
    }
}
