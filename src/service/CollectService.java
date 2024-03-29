package service;

import Dao.CollectDao;
import model.Collect;
import model.Song;
import model.User;

import java.sql.SQLException;

public class CollectService {

    private CollectDao collectDao = new CollectDao();
    //  收藏业务
    public boolean clickFavor(User user, int sid){
      try {
        // 判断 歌曲是否已被当前用户收藏
        if(collectDao.isCollectExist(user.getUser_id(),sid)){
            return false;
        }
        //  调用Dao层进行收藏操作
        collectDao.addCollect(user.getUser_id(),sid);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
    //  取消收藏业务
    public boolean cancelFavor(User user, int sid){
        //  歌曲是否已被当前用户收藏
        try {
          if(!collectDao.isCollectExist(user.getUser_id(),sid)){
            return false;
          }
          collectDao.cancelCollect(user.getUser_id(),sid);
          return true;
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return false;
    }
    //  判断是否存在收藏记录
    public  boolean isFavor(User user,int sid){
      //  歌曲是否已被当前用户收藏
      try {
        if(!collectDao.isCollectExist(user.getUser_id(),sid)){
          return false;
        }
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
}
