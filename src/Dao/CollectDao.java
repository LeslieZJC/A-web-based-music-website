package Dao;

import model.Collect;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;

public class CollectDao {

  //    点击收藏add方法
    public void addCollect(int uid,int sid) throws SQLException{
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into Collect(user_id,song_id)values(?,?)";
        r.update(sql,uid,sid);
    }

  //    取消收藏cancel方法
    public void cancelCollect(int uid,int sid) throws SQLException{
          QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
          String sql = "delete from Collect where user_id = ? and song_id= ? ";
          r.update(sql,uid,sid);
    }

  //    判断是否已存在收藏记录
    public boolean isCollectExist(int uid,int sid) throws SQLException {
      QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
      String sql = "select * from Collect where user_id = ? and song_id = ?";
      Collect collect = r.query(sql,new BeanHandler<Collect>(Collect.class),uid,sid);
      if(collect == null){
        return false;
      }else {
        return true;
      }
    }

}
