package servlet;

import model.Collect;
import model.Song;
import model.User;
import service.CollectService;
import service.SongService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MusicPlayServlet", urlPatterns = "/music_play")
public class MusicPlayServlet extends HttpServlet {
  Collect collect = new Collect();
  SongService songService = new SongService();
  CollectService collectService = new CollectService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //获取播放的歌曲id
      int sid = Integer.parseInt(request.getParameter("id"));
      Song s = songService.getSongById(sid);
      request.setAttribute("s",s);

      //获取 用户id 会话,判断该用户是否已经收藏该歌曲来决定加载 “收藏❤” 的方式
      User user = null;
      if(request.getSession().getAttribute("user")!=null){
        user = (User) request.getSession().getAttribute("user");
        if(collectService.isFavor(user,sid)){
            request.getSession().setAttribute("collect",collect);
        }else {
          request.getSession().removeAttribute("collect");
        }
      }
      request.getRequestDispatcher("/music_play.jsp").forward(request,response);
  }
}
