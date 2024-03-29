package Dao;

import model.Song;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class SongDao {
  //  根据id获取Song歌曲所有数据
  public Song getSongById(int id) throws SQLException {
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select song_id,song_name,info,image_url,audio_url from Song  where song_id = ? ";
    return r.query(sql, new BeanHandler<Song>(Song.class),id);
  }
  //  (新) 根据uid查询指定歌曲
  public List<Song> getSongsByUid(int uid) throws SQLException{
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select Song.* from Song,Collect where Collect.user_id = ? and Collect.song_id = Song.song_id";
    return r.query(sql,new BeanListHandler<Song>(Song.class),uid);
  }
  //  (新) 查询所有歌曲
  public List<Song> getAllSongs() throws SQLException{
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select * from Song";
    return r.query(sql,new BeanListHandler<Song>(Song.class));
  }

  //歌曲添加
  public void insert(Song g) throws SQLException {
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "insert into song(song_name,info,image_url,audio_url) values(?,?,?,?)";
    r.update(sql,g.getSong_name(),g.getInfo(),g.getImage_url(),g.getAudio_url());
  }

  //查询歌曲数量
  public int getCountOfSong() throws SQLException {
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select count(*) from song";
    return r.query(sql, new ScalarHandler<Long>()).intValue();
  }

  //根据uid更新歌曲信息
  public void update(Song g) throws SQLException {
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "update song set song_name=?,info=?,image_url=?,audio_url=? where song_id=?";
    r.update(sql,g.getSong_name(),g.getInfo(),g.getImage_url(),g.getAudio_url(),g.getSong_id());
  }

  //根据uid删除歌曲信息
  public void delete(int id) throws SQLException {
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "delete from song where song_id = ?";
    r.update(sql,id);
  }
  //根据keyword查询歌曲
  public List<Song> selectSearchMusic(String keyword) throws SQLException{
    QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select * from song where song_name like ? ";
    System.out.println(sql);
    return r.query(sql, new BeanListHandler<Song>(Song.class),"%"+keyword+"%");
  }
}
