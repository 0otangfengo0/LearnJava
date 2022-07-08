import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
* 1、需求：
*       模拟用户登录
*
* 2、业务描述：
*       程序 运行提供一个输入的入口，可以让用户输入用户名和密码
*   提交信息后，java程序收集用户信息，连接数据库验证用户合法性
*   合法：显示登录成功
*   不合法：显示登录失败
* */


public class JDBCdemo {
    public static void main(String[] args) throws  Exception {
        //初始化一个界面
        Map<String,String> userLoginInf =  initUI();
        //验证用户名和密码
        Boolean loginSuccess =  login(userLoginInf);
        //输出结果信息
        System.out.println(loginSuccess ? "登录成功" : "登录失败");
    }

    /**
     *验证用户名和密码
     * @param userLoginInf  用户登录信息
     * @return ture 登录成功，false 登录失败
     */

    private static Boolean login(Map<String, String> userLoginInf) throws  Exception  {
        boolean loginSuccess = false;
        String userName = userLoginInf.get("userName");
        String userPwd = userLoginInf.get("userPwd");

        Class.forName("com.mysql.jdbc.Driver");

        Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8","root","123456" );

        Statement state = conect.createStatement();

        String sql = "SELECT * FROM userLogin WHERE userName = '"+userName+"' AND userPwd = '"+userPwd+"'";
        ResultSet rs = state.executeQuery(sql);

        if(rs.next()){
            loginSuccess = true;
        }
        rs.close();
        state.close();
        conect.close();

        return loginSuccess;
    }

    /**
     * 初始化用户界面
     * @return 用户输入的用户名和密码
     */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.println("用户名：");
        String userName = s.nextLine();
        System.out.println("密码：");
        String userPwd = s.nextLine();

        HashMap<String, String> userLoginInf = new HashMap<>();
        userLoginInf.put("userName",userName);
        userLoginInf.put("userPwd",userPwd);

        return userLoginInf;
    }
}
