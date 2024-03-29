package servlet;

import model.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "UserRegisterServlet", urlPatterns = "/user_register")
public class UserRegisterServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    获取前台数据  封装
      User user = new User();
      try {
        BeanUtils.copyProperties(user,request.getParameterMap());
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
      UserService userService = new UserService();

//    调用业务层   判断
      if(userService.register(user)){
          request.setAttribute("msg","注册成功，请登录!");
          request.getRequestDispatcher("/user_login.jsp").forward(request,response);
      }else {
          request.setAttribute("msg","用户名已存在，请重新填写");
          request.getRequestDispatcher("/user_register.jsp").forward(request,response);
      }
  }
}
