package servlet;

import model.Song;
import service.SongService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminMusicEditShowServlet", urlPatterns = "/admin/music_edit_show")
public class AdminMusicEditShowServlet extends HttpServlet {
  private SongService gService = new SongService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    Song g = gService.getSongById(id);
    request.setAttribute("g", g);
    request.getRequestDispatcher("/admin/music_edit.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }
}
