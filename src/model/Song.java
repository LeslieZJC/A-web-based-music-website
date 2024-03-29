package model;

public class Song {
  private int song_id;
  private String song_name;
  private String info;
  private String image_url;
  private String audio_url;

  public Song() {
  }

  public Song(int song_id, String song_name, String info, String image_url, String audio_url) {
    this.song_id = song_id;
    this.song_name = song_name;
    this.info = info;
    this.image_url = image_url;
    this.audio_url = audio_url;
  }

  @Override
  public String toString() {
    return "Song{" +
      "song_id=" + song_id +
      ", song_name='" + song_name + '\'' +
      ", info='" + info + '\'' +
      ", image_url='" + image_url + '\'' +
      ", audio_url='" + audio_url + '\'' +
      '}';
  }

  public int getSong_id() {
    return song_id;
  }

  public void setSong_id(int song_id) {
    this.song_id = song_id;
  }

  public String getSong_name() {
    return song_name;
  }

  public void setSong_name(String song_name) {
    this.song_name = song_name;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public String getImage_url() {
    return image_url;
  }

  public void setImage_url(String image_url) {
    this.image_url = image_url;
  }

  public String getAudio_url() {
    return audio_url;
  }

  public void setAudio_url(String audio_url) {
    this.audio_url = audio_url;
  }
}
