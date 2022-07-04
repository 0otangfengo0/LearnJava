import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Pro {
    public static void main(String[] args) throws IOException {
        String file = "db.properties";

//        创建Properties实例；
        Properties props = new Properties();
//        调用load()读取文件；
        props.load(new FileInputStream("src\\com\\Proper\\db.properties"));

//        调用getProperty()获取配置。
        String name = props.getProperty("uesrname");
        String password = props.getProperty("password");
        System.out.println("name:" +name+"\npassword:"+password);

    }
}
