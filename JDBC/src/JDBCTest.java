import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =null;
        try {
            // 1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8","root","123456");
            // 3、获取数据库操作对象
            stmt = conn.createStatement();
            // 4、执行sql
            String sql = "UPDATE student SET NAME = 'FF' WHERE id = 4";
            int execute = stmt.executeUpdate(sql);
            System.out.println(execute == 1 ? "修改成功" : "修改失败");
            // 5、处理查询结果集
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 6、释放资源
            if(rs !=null){
                try{
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(stmt !=null){
                try{
                    stmt.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(conn !=null){
                try{
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


    }
}
