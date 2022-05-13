package com.example.customer.controller;

import com.example.customer.entity.Customer;
import com.example.customer.model.CustomerModel;
import com.example.customer.model.MySqlCustomerModel;
import com.example.customer.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class EditCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;
    public EditCustomerServlet(){
        customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Id = req.getParameter("id");
        // kiểm tra trong database xem có tồn tại không.
        Customer customer = customerModel.findById(Id);
        // nếu không trả về trang 404
        if (customer == null) {
            req.setAttribute("message", "Customer not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            // nếu có trả về trang detail
            req.setAttribute("customer", customer);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //xử lý validate và save.
        String Id = req.getParameter("Id");
        String Name = req.getParameter("Name");
        String Phone = req.getParameter("Phone");
        String Image = req.getParameter("Image");
        String stringBirthday = req.getParameter("birthday");
        LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
        Customer customer = new Customer(Id,Name,Phone,Image,birthday);
        // validate dữ liệu
        if (customerModel.update(Id,customer) != null){
            resp.sendRedirect("/admin/customers/list");
        }else {
            // nếu có trả về trang form
            req.setAttribute("customer", customer);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }
    }
}
