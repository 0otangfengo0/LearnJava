# 反射
反射就是Reflection，Java的反射是指程序在运行期可以拿到一个对象的所有信息。<br>
为了解决在运行期，对某个实例一无所知的情况下，如何调用其方法。
## 获取Class类对象的方式
* Class.forname("全类名")
  * 配置文件
* 类名.class
  * 参数的传递
* 对象.getclass()
    * 多用于对象的获取字节码的方式 

举例 ：REflectdemo1 <br>
同一个字节码文件（*.class）在一次程序运行过程中，只会被加载一次，获取到的Class的对象都是同一个
<br>

## Class对象功能
* 获取成员变量
  * Field getField(String name)
    * 返回一个 Field对象反映的类或接口的 类对象表示的指定公共成员。
  * Field[] getFields()
    * 返回一个数组包含 Field物体反射的类或接口的 类对象代表所有可访问的公共领域。
      <br><br>
  * Field getDeclaredField(String name)
    * 返回一个 Field对象反映的类或接口的 类对象表示的指定公共成员。
  * Field[] getDeclaredFields()
    * 返回一个数组包含 Field物体反射的类或接口的 类对象代表所有可访问的公共领域。      <br><br>
* 获取构造方法
  * Constructor<T> getConstructor(类<?>... parameterTypes)  
    * 返回一个 Constructor对象反映指定的公共构造函数的 类对象表示的类。
  * Constructor<?>[] getConstructors() 
    * 返回一个数组包含 Constructor物体反射所有的 类对象表示的类的公共构造函数。
      <br><br>
  * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
    * 返回一个 Constructor对象反映指定的构造函数的类或接口的 类对象表示。
  * Constructor<?>[] getDeclaredConstructors()
    * 返回 Constructor物体反射所有的构造函数通过 类对象表示的类中声明一个数组。    <br><br>
* 获取成员方法
  * Method getMethod(String name, 类<?>... parameterTypes)
    * 返回一个 方法对象反映的类或接口的 类对象表示的指定公共成员方法。  
  * Method[] getMethods()
    * 返回一个数组包含 方法物体反射所有的类或接口的 类对象表示的公共方法，包括那些由类或接口的超类和超接口继承的声明。
      <br><br>
  * Method getDeclaredMethod(String name, 类<?>... parameterTypes) 
  * Method[] getDeclaredMethods()
* 获取类名
  * string getName()


举例：
获取成员变量--demo2<br>
获取构造方法--demo3<br>
Declared get时可以使用：
```java
        //忽略访问修饰符的安全检查
        d.setAccessible(true); //暴力反射
```
如果使用空参数创建对象，可以简化操作：Class对象的newInstance


 ## 案例
* 需求：写一个“框架”，在不改变类的任何代码前提下。可以创建任意类的对象，可以执行任意方法<br>

* 实现：
  * 1.配置文件
  * 2.反射
* 步骤：
  * 1.将创建的对象的全类名和需要执行的方法定义在配置文件中
  * 2.在程序中加载读取配置文件
  * 3.使用反射加载类文件进内存
  * 4.创建对象
  * 5.执行方法