package jdbc.util;

import java.sql.*;

/**
 * @author LF
 * JDBC工具类 ，简化JDBC编程
 *
 */

public class DBUtil {
    /**
     *工具类的构造方法都是私有的
     * 工具类中的方法都是静态的，不需要new，直接采用类名调用
     */
    private DBUtil (){}

    /**
     * 静态代码块，在类加载时只执行一次
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     * @return Connection
     * @throws Exception
     */
    public static Connection getConnection() throws Exception  {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=true&amp;" +
                "useUnicode=true&amp;characterEncoding=UTF-8","root","123456" );

    }

    /**
     * 关闭资源
     * @param conn 数据库连接对象
     * @param ps 数据库操作对象
     * @param rs 结果集
     */
    public static void close (Connection conn, Statement ps , ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
