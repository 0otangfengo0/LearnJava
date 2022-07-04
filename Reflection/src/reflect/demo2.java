package reflect;

import domain.Persion;

import java.lang.reflect.Field;

public class demo2 {
    public static void main(String[] args) throws  Exception {

        Class persionClass = Persion.class;
//        获取成员变量
//        Field getField(String name)  返回一个 Field对象反映的类或接口的 类对象表示的指定公共成员
//        Field[] getFields() 返回一个数组包含 Field物体反射的类或接口的 类对象代表所有可访问的公共领域。
        Field[] fields = persionClass.getFields();
        for (Field i: fields
             ) {
            System.out.println(i);
        }
        // public int domain.Persion.a

        Field a = persionClass.getField("a");
         //获取成员变量a的值
        Persion p = new Persion();
        Object res = a.get(p);
        System.out.println(res);
        //0

        //设置a
        a.set(p,123);
        System.out.println(p);
        //Persion{name='null', age=0, a=123, b=0, c=0}
        System.out.println("------------");
        Field[] declaredFields = persionClass.getDeclaredFields();
        for (Field i: declaredFields
             ) {
            System.out.println(i);
        }
        /*
            private java.lang.String domain.Persion.name
            private int domain.Persion.age
            public int domain.Persion.a
            protected int domain.Persion.b
            int domain.Persion.c
            private int domain.Persion.d
        * */


        Field d = persionClass.getDeclaredField("d");
        //忽略访问修饰符的安全检查
        d.setAccessible(true); //暴力反射
        Object res2 = d.get(p);
        System.out.println(res2);
        //0
        d.set(p,911);
        System.out.println(p);
        //Persion{name='null', age=0, a=123, b=0, c=0, d=911}

    }
}
