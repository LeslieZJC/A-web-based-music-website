package service;

import Dao.UserDao;
import model.Page;
import model.Song;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();
    //  注册业务
    public boolean register(User user){
    //用户是否注册
      try {
        if(userDao.isUsernameExist(user.getUser_name())){
          return false;
        }
        userDao.addUser(user);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
    //  登录业务
    public  User login(String username, String password){
        User user = null;
        try {
          user = userDao.selectUsernamePassword(username,password);
        } catch (SQLException e) {
          e.printStackTrace();
        }
        if(user != null){
          return user;
        }
        return user;
    }
    //  分页展示
    public Page getUserPage(int pageNumber) {
      Page p = new Page();
      p.setPageNumber(pageNumber);
      int totalCount = 0;
      try {
        totalCount = userDao.getCountOfUser();
      }catch (SQLException e) {
        e.printStackTrace();
      }
      p.SetPageSizeAndTotalCount(8, totalCount);
      List list=null;
      try {
        list = userDao.getAllUsers();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      p.setList(list);
      return p;
    }

    //  通过id获取用户数据的业务
    public User getUserById(int id) {
      User u=null;
      try {
        u = userDao.getUserById(id);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return u;
    }

  //更新用户信息
  public void update(User user) {
    try {
      int id = user.getUser_id();
      userDao.delete(id);
      userDao.addUser(user);
      user.setUser_id(id);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  //删除用户
  public void delete(int id) {
    try {
      userDao.delete(id);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  //插入新用户
  public void insert(User user) {
    try {
      userDao.insert(user);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
    //修改密码
    public void updatePwd(User user) {
        try {
            userDao.updatePwd(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
