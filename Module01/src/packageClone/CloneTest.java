package packageClone;

public class CloneTest {

    public static void main(String[] args) {

        func01();
    }

    private static void func01()
    {
        Person p = new Person("sen", 28);

        try {

            Person clone_p = p.clone();


        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }



}

/*
* Cloneable接口不是一个一般意义上的接口
* 该接口中没有声明任何方法，因为clone方法已经被Object类定义为protected了
* 该接口可以理解成是一个标签接口，标识某个类的对象可以被clone，
* 当一个类的对象可以被clone时，需要重写clone()方法，并修改限定符为public
* clone()方法会抛出一个异常，方法调用者要对这个异常做处理
* */

class Person  implements Cloneable
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
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

    @Override
    public Person clone() throws CloneNotSupportedException {

        Person p = (Person) super.clone();

        return p;
    }

}
