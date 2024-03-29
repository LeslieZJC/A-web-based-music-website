package model;

import java.security.SecureRandom;

public class User {

  private int user_id;
  private String user_name;
  private String password;
  private String nick_name;
  private String motto;
  private boolean is_admin=false;
  private boolean is_valid=true;

  @Override
  public String toString() {
    return "User{" +
      "user_id=" + user_id +
      ", user_name='" + user_name + '\'' +
      ", password='" + password + '\'' +
      ", nick_name='" + nick_name + '\'' +
      ", motto='" + motto + '\'' +
      ", is_admin=" + is_admin +
      ", is_valid=" + is_valid +
      '}';
  }

  public User() {
  }

  public User(int user_id, String user_name, String password, String nick_name, String motto, boolean is_admin, boolean is_valid) {
    this.user_id = user_id;
    this.user_name = user_name;
    this.password = password;
    this.nick_name = nick_name;
    this.motto = motto;
    this.is_admin = is_admin;
    this.is_valid = is_valid;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNick_name() {
    return nick_name;
  }

  public void setNick_name(String nick_name) {
    this.nick_name = nick_name;
  }

  public String getMotto() {
    return motto;
  }

  public void setMotto(String motto) {
    this.motto = motto;
  }

  public boolean isIs_admin() {
    return is_admin;
  }

  public void setIs_admin(boolean is_admin) {
    this.is_admin = is_admin;
  }

  public boolean isIs_valid() {
    return is_valid;
  }

  public void setIs_valid(boolean is_valid) {
    this.is_valid = is_valid;
  }
}
