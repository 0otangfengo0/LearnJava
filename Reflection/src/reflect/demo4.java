package reflect;

import domain.Persion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class demo4 {
    public static void main(String[] args) throws  Exception {
        Class persionClass = Persion.class;
        
//1.        获取成员方法
        Method eat = persionClass.getMethod("eat");
        Persion p = new Persion();
        //执行方法
        Object invoke = eat.invoke(p);
        //eat

//2.        获取成员方法 含有参数
        Method eat1 = persionClass.getMethod("eat",String.class);
//执行方法
        Object invoke1 = eat1.invoke(p, "大肘子");
        //eat大肘子

//3.    getMethods
        Method[] methods = persionClass.getMethods();
        for (Method i:
             methods) {
            System.out.println(i);
            /*
            public java.lang.String domain.Persion.getName()
            public java.lang.String domain.Persion.toString()
            public void domain.Persion.setName(java.lang.String)
            public int domain.Persion.getAge()
            public void domain.Persion.eat(java.lang.String)
            public void domain.Persion.eat()
            public void domain.Persion.setAge(int)
            public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
            public final void java.lang.Object.wait() throws java.lang.InterruptedException
            public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
            public boolean java.lang.Object.equals(java.lang.Object)
            public native int java.lang.Object.hashCode()
            public final native java.lang.Class java.lang.Object.getClass()
            public final native void java.lang.Object.notify()
            public final native void java.lang.Object.notifyAll()
            * */
        }
        System.out.println("-----");
        Method[] methods1 = persionClass.getDeclaredMethods();
        for (Method i:
             methods1) {
            System.out.println(i);
            /*
            public java.lang.String domain.Persion.getName()
            public java.lang.String domain.Persion.toString()
            public void domain.Persion.setName(java.lang.String)
            public void domain.Persion.eat(java.lang.String)
            public void domain.Persion.eat()
            public void domain.Persion.setAge(int)
            private void domain.Persion.drink()
            public int domain.Persion.getAge()
            * */
        }
        System.out.println("00000000000");
        Method drink = persionClass.getDeclaredMethod("drink");
        //暴力反射
        drink.setAccessible(true);
        //执行函数
        Object invoke2 = drink.invoke(p);
        //drink

    }
}
