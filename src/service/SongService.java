package service;

import Dao.SongDao;
import model.Page;
import model.Song;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongService {
  private SongDao songDao = new SongDao();
  //  通过id获取歌曲数据的业务
  public Song getSongById(int id) {
    Song s=null;
    try {
      s = songDao.getSongById(id);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return s;
  }

  // (新)  通过uid 获取歌曲list的业务
  public List<Song> getSongsByUid(int uid){
    List<Song> list = new ArrayList<>();
    try {
      list = songDao.getSongsByUid(uid);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }
  // (新)  获取所有歌曲list的业务
  public List<Song> getAllSongs(){
    List<Song> list = new ArrayList<>();
    try {
      list = songDao.getAllSongs();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }
  //插入新歌曲 (z)
  public void insert(Song goods) {
    try {
      songDao.insert(goods);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  //分页展示 (z)
  public Page getSongPage(int pageNumber) {
    Page p = new Page();
    p.setPageNumber(pageNumber);
    int totalCount = 0;
    try {
      totalCount = songDao.getCountOfSong();
    }catch (SQLException e) {
      e.printStackTrace();
    }
    p.SetPageSizeAndTotalCount(8, totalCount);
    List list=null;
    try {
      list = songDao.getAllSongs();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    p.setList(list);
    return p;
  }

  //更新歌曲信息
  public void update(Song song) {
    try {
      songDao.update(song);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  //删除歌曲
  public void delete(int id) {
    try {
      songDao.delete(id);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  //根据关键字查询歌曲
  public Page getSearchMusic(String keyword) {
    List list=null;
    Page p = new Page();
    try {
      list = songDao.selectSearchMusic(keyword);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    p.setList(list);
    return p;
  }
}
