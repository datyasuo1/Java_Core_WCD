package com.example.karma_shops.controller.account;

import com.example.karma_shops.entity.Account;
import com.example.karma_shops.model.AccountModel;
import com.example.karma_shops.model.MySqlAccountModel;
import com.example.karma_shops.util.SHA512Hasher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private AccountModel accountModel;

    public RegisterServlet() {
        this.accountModel = new MySqlAccountModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("account", new Account());
        req.getRequestDispatcher("/user/page/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setPasswordConfirm(confirmPassword);
        account.setEmail(email);
        account.setPhone(phone);
        if (accountModel.findByUsername(username) != null) {
            account.addErrors("username", "Username is exist.");
        }
        if (accountModel.findByEmail(email) != null) {
            account.addErrors("email", "Email is exist.");
        }
        if (account.isValid()) {
            account.setSalt(SHA512Hasher.randomString(10));
            account.setPasswordHash(SHA512Hasher.encode(account.getPassword(), account.getSalt()));
            accountModel.save(account);
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("account", account);
            req.getRequestDispatcher("/user/page/register.jsp").forward(req, resp);
        }
    }
}
