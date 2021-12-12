package com.eliza.fjd.servlet;

import com.eliza.fjd.dal.UserDal;
import com.eliza.fjd.model.UserModel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Register", value = "/register.do")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String tel=request.getParameter("tel");
        String name = request.getParameter("name");
        String pwd = request.getParameter("psw");

        try {
            new UserDal().register(new UserModel(name,tel,pwd));
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
