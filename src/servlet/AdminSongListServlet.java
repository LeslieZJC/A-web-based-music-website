package servlet;

import model.Page;
import service.SongService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminSongListServlet", urlPatterns = "/admin/music_list")
public class AdminSongListServlet extends HttpServlet {
  private SongService gService = new SongService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int pageNumber = 1;
    if(request.getParameter("pageNumber") != null) {
      try {
        pageNumber=Integer.parseInt(request.getParameter("pageNumber") ) ;
      }
      catch (Exception e) {}
    }
    Page p = gService.getSongPage(pageNumber);
    if(p.getTotalPage()==0) {
      p.setTotalPage(1);
      p.setPageNumber(1);
    }
    else {//根据查询到的歌曲数量进行分页
      if(pageNumber>=p.getTotalPage()+1) {
        p = gService.getSongPage(p.getTotalPage());
      }
    }
    request.setAttribute("p", p);
    request.getRequestDispatcher("/admin/music_list.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }
}
