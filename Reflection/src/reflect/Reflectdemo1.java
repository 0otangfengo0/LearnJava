package reflect;

import domain.Persion;

public class Reflectdemo1 {
    public static void main(String[] args) throws  Exception {
//    * Class.forname("全类名")
       Class cls1 = Class.forName("domain.Persion");
        System.out.println(cls1);
        // 打印 class domain.Persion

//    * 类名.class
        Class cls2 = Persion.class;
        System.out.println(cls2);
        // 打印 class domain.Persion

//    * 对象.getclass()
        Persion per1 = new Persion();
        Class  cls3 = per1.getClass();
        System.out.println(cls3);
        // 打印 class domain.Persion

        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
//        true
//        true
    }
}
