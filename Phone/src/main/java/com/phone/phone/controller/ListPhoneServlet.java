package com.phone.phone.controller;

import com.phone.phone.entity.Brand;
import com.phone.phone.entity.Phone;
import com.phone.phone.model.BrandModel;
import com.phone.phone.model.MySQLBrandModel;
import com.phone.phone.model.MySQLPhoneModel;
import com.phone.phone.model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListPhoneServlet extends HttpServlet {
    private PhoneModel phoneModel;
    private BrandModel brandModel;
    public ListPhoneServlet() {
        this.phoneModel = new MySQLPhoneModel();
        this.brandModel = new MySQLBrandModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Phone> list = phoneModel.findAll();
        List<Brand> listB = brandModel.findAll();
        request.setAttribute("title","List Phone");
        request.setAttribute("list",list);
        request.setAttribute("list1",listB);
        request.getRequestDispatcher("/admin/products/list.jsp").forward(request,response);
    }
}
