package servlet;

import model.Song;
import model.User;
import service.SongService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminUserEditShowServlet", urlPatterns = "/admin/user_edit_show")
public class AdminUserEditShowServlet extends HttpServlet {
  private UserService uService = new UserService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    User u = uService.getUserById(id);
    request.setAttribute("u", u);
    request.getRequestDispatcher("/admin/user_edit.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }
}
