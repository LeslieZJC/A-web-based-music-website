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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UserCenterServlet", urlPatterns = "/user_center")
public class UserCenterServlet extends HttpServlet {
  CollectService collectService = new CollectService();
  SongService songService = new SongService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获取 用户 会话
    User user = null;
    Song song = null;
//      List songList = new ArrayList<>();
    if(request.getSession().getAttribute("user")!=null){
      user = (User) request.getSession().getAttribute("user");
      //获取登录用户对象,并获得uid
      request.getSession().setAttribute("u",user);
      int uid = user.getUser_id();
      //获取用户收藏的歌曲list
      SongService songService = new SongService();
      List<Song> songList = songService.getSongsByUid(uid);
      request.setAttribute("songList",songList);

      request.getRequestDispatcher("/user_center.jsp").forward(request,response);
    }else {
      request.setAttribute("LoginTip","请先登录!");
      request.getRequestDispatcher("/index.jsp").forward(request,response);
      return;
    }
  }
}
