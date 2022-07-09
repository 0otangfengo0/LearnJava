import jdbc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 使用编写的util JDBC类
 * 实现模糊查询
 */

public class JDBCTest02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps= null;
        ResultSet rs= null;

        try {
            //获取连接
            conn = DBUtil.getConnection();
            //获取预编译的数据库操作对象
//            String sql = "SELECT username FROM userlogin WHERE username LIKE '?%'";
//            ps = conn.prepareStatement(sql);
//            ps.setString(1,"z");
            String sql = "SELECT username FROM userlogin WHERE username LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"j%");
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            DBUtil.close(conn,ps,rs);
        }
    }
}
