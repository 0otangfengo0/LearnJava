package reflect;

import domain.Persion;

import java.lang.reflect.Constructor;

public class demo03 {
    public static void main(String[] args) throws  Exception {
        Class persionClass = Persion.class;

//        获取构造方法
        Constructor constructor = persionClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        //public domain.Persion(java.lang.String,int)

//        newInstance(Object... initargs)
//        利用这 Constructor对象创建和初始化的构造函数的声明类的一个新实例构造函数，用指定的初始化参数。

        Object obj1 = constructor.newInstance("孙悟空", 18);
        System.out.println(obj1);
        //Persion{name='孙悟空', age=18, a=0, b=0, c=0, d=0}

        System.out.println("-------");
        Constructor constructor1 = persionClass.getConstructor();
        Object obj2 = constructor1.newInstance();
        System.out.println(obj2);
        //Persion{name='null', age=0, a=0, b=0, c=0, d=0}
        System.out.println("-------");
        Object o = persionClass.newInstance();
        System.out.println(o);
        //Persion{name='null', age=0, a=0, b=0, c=0, d=0}

    }
}
