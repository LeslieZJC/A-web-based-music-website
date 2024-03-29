package model;

public class Collect {
  private String user_id;
  private String song_id;

  public Collect() {
  }

  public Collect(String user_id, String song_id) {
    this.user_id = user_id;
    this.song_id = song_id;
  }

  @Override
  public String toString() {
    return "Collect{" +
      "user_id='" + user_id + '\'' +
      ", song_id='" + song_id + '\'' +
      '}';
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getSong_id() {
    return song_id;
  }

  public void setSong_id(String song_id) {
    this.song_id = song_id;
  }
}
