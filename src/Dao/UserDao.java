package Dao;

import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

//    add方法：
    public void addUser(User user) throws SQLException {
//    拿到执行者对象
      QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
//    sql
      String sql = "insert into User(user_name,password,nick_name,motto,is_admin,is_valid)"+
       "values(?,?,?,?,?,?)";
//    执行
      r.update(sql,user.getUser_name(),user.getPassword(),user.getNick_name(),user.getMotto(),
                user.isIs_admin(),user.isIs_valid());
    }
//    判断username是否存在
    public boolean isUsernameExist(String username) throws SQLException {
      QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
      String sql = "select * from User where user_name =?";
      User user = r.query(sql, new BeanHandler<User>(User.class),username);
      if (user == null){
        return false;
      }else {
        return true;
      }
    }
//    username   password
    public User selectUsernamePassword(String username,String password)throws SQLException{
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from User where user_name = ? and password =?";
        return r.query(sql,new BeanHandler<User>(User.class),username,password);
    }


  //  (新) 查询所有用户
  public List<User> getAllUsers() throws SQLException{
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select * from User";
    return r.query(sql,new BeanListHandler<User>(User.class));
  }
  //查询用户数量  (z)
  public int getCountOfUser() throws SQLException {
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select count(*) from user";
    return r.query(sql, new ScalarHandler<Long>()).intValue();
  }
  //  根据id获取User用户所有数据
  public User getUserById(int id) throws SQLException {
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select user_id,user_name,password,nick_name,motto,is_admin,is_valid from User  where user_id = ? ";
    return r.query(sql, new BeanHandler<User>(User.class),id);
  }

  //用户添加
  public void insert(User u) throws SQLException {
      this.addUser(u);
  }

  //根据uid更新用户信息
  public void update(User u) throws SQLException {
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "update user set user_name=?,password=?,nick_name=?,motto=? where user_id=?";
    r.update(sql,u.getUser_name(),u.getPassword(),u.getNick_name(),u.getMotto());
  }

  //根据uid删除用户信息
  public void delete(int id) throws SQLException {
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "delete from user where user_id = ?";
    r.update(sql,id);
  }

  //根据uid修改密码
  public void updatePwd(User user) throws SQLException {
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql ="update user set password = ? where id = ?";
    r.update(sql,user.getPassword(),user.getUser_id());
  }
}
