package domain;

public class Persion {
    private String name;
    private int age;

    public int a;
    protected int b;
    int c;
    private int d;

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }

    public Persion() {
    }

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("eat");
    }
    public void eat(String s){
        System.out.println("eat"+s);
    }

    private void drink(){
        System.out.println("drink");
    }
}
