package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtils {
  private static DataSource ds=new ComboPooledDataSource();

  //  数据源
  public static DataSource getDataSource()
  {
    return  ds;
  }
  //  获取到连接对象
  public static Connection getConnection() throws SQLException {
    return ds.getConnection();
  }
}
