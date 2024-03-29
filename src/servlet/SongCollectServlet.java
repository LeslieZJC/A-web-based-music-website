package servlet;

import model.Song;
import model.User;
import service.CollectService;
import service.SongService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "collect_song", urlPatterns = "/collect_song")
public class SongCollectServlet extends HttpServlet {
  private CollectService collectService = new CollectService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //获取 用户 会话
      User user = null;
      if(request.getSession().getAttribute("user")!=null){
        user = (User) request.getSession().getAttribute("user");
      }else {
          response.getWriter().print("noUser");
          return;
      }
      //获取 前台歌曲id参数:  sid
      int sid = Integer.parseInt(request.getParameter("sid"));
      //点击收藏
      if(collectService.clickFavor(user,sid)){
          response.getWriter().print("ok");
      }else{
          response.getWriter().print("fail");
      }
  }
}
