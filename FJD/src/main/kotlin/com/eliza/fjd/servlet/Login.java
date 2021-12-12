package com.eliza.fjd.servlet;

import com.eliza.fjd.dal.UserDal;
import com.eliza.fjd.model.UserModel;
import com.eliza.fjd.utils.ConstantDef;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login.do")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.getSession().removeAttribute(ConstantDef.USER_SESSION);
        String userName = request.getParameter("uname");
        String pwd = request.getParameter("password");
        try {
            UserModel model = new UserDal().login(userName, pwd);
            if(model!=null) {
                request.getSession().setAttribute(ConstantDef.USER_SESSION,model);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else{
//                response.getWriter().append("<script language='javascript'>alert('用户名或密码错误！');window.location.href='login.jsp';</script>");
                JOptionPane.showMessageDialog(null, "用户名或密码错误！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {

        }
    }
}
