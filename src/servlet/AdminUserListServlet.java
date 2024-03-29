package servlet;

import model.Page;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminUserListServlet", urlPatterns = "/admin/user_list")
public class AdminUserListServlet extends HttpServlet {
  private UserService uService = new UserService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int pageNumber = 1;
    if(request.getParameter("pageNumber") != null) {
      try {
        pageNumber=Integer.parseInt(request.getParameter("pageNumber") ) ;
      }
      catch (Exception e) {}
    }
    Page p = uService.getUserPage(pageNumber);
    if(p.getTotalPage()==0) {
      p.setTotalPage(1);
      p.setPageNumber(1);
    }
    else {//根据查询到的用户数量进行分页
      if(pageNumber>=p.getTotalPage()+1) {
        p = uService.getUserPage(p.getTotalPage());
      }
    }
    request.setAttribute("p", p);
    request.getRequestDispatcher("/admin/user_list.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }
}
