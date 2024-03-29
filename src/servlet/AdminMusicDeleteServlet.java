package servlet;

import model.Song;
import service.SongService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminMusicDeleteServlet", urlPatterns = "/admin/music_delete")
public class AdminMusicDeleteServlet extends HttpServlet {
  private SongService gService = new SongService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    gService.delete(id);
    request.getRequestDispatcher("/admin/music_list.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }
}
