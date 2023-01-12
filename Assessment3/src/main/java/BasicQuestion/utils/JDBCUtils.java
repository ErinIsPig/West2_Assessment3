package BasicQuestion.utils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils {
    private static DataSource druidSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();
    static {

        try {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);
            druidSource = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static Connection getConnection()  {
        Connection connection = null;
        try {
            connection = druidSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;

    }
    public static void closeResource(Connection connection){
        try {
            connection.close();
            conns.remove();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
