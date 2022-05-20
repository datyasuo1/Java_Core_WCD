package com.example.customer.controller;

import com.example.customer.entity.Customer;
import com.example.customer.model.CustomerModel;
import com.example.customer.model.MySqlCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DetailCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;
    public DetailCustomerServlet(){
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
            HttpSession session = req.getSession();
            ArrayList<Customer> recentView = (ArrayList<Customer>)session.getAttribute("recentView");
            if (recentView == null){
                recentView = new ArrayList<Customer>();
            }
            boolean exits = false;
            for (int i=0; i<recentView.size(); i++){
                if (recentView.get(i).getId().equals(customer.getId())){
                    exits = true;
                }
            }
            if (!exits){
                recentView.add(customer);
                session.setAttribute("recentView",recentView);
            }
            req.setAttribute("customer", customer);
            req.getRequestDispatcher("/admin/customers/detail.jsp").forward(req, resp);

        }
    }
}
