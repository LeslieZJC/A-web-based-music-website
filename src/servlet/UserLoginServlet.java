package servlet;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/user_login")
public class UserLoginServlet extends HttpServlet {
  private UserService userService = new UserService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//      接受请求    接受参数username  password
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//      调用业务层     login =>  user
        User user = userService.login(username,password);
        if(user == null){
            request.setAttribute("failMsg","用户名或者密码错误，请重新登录！");
            request.getRequestDispatcher("/user_login.jsp").forward(request,response);
        }else{
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
  }
}
