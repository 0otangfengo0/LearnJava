# Properties 使用
在编写应用程序的时候，经常需要读写配置文件。
它的Key-Value一般都是String-String类型的，因此我们完全可以用Map<String, String>来表示它。
Java集合库提供了一个Properties来表示一组“配置”
Properties内部本质上是一个Hashtable
## 。properties文件
配置文件以.properties为扩展名，每行以key=value表示，以#课开头的是注释。以下是一个典型的配置文件：
```properties
#setting
username=LF 
password=123456
```
## 读取Properties文件
三步
* 创建Properties实列
* 调用load()读取文件
* 调用getProperty()获取配置

```java
package com.Proper;

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

```