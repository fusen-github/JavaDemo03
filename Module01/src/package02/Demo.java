package package02;

import sun.jvm.hotspot.debugger.NoSuchSymbolException;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Demo {

    public static void main(String[] args) {

        func07();
    }

    static void func07()
    {
        Student student = new Student("sen", 100);

        Class clsObj = student.getClass();

        System.out.println(clsObj);

        String clsName = clsObj.getName();

        Class tmp = null;

        try {
            tmp = Class.forName(clsName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            return;
        }

        if (tmp == clsObj)
        {
            System.out.println("==");
            try {
                Object obj = tmp.newInstance();

                System.out.println(obj);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("!=");
        }



        System.out.println(clsObj.getName());

//        Constructor

//        class  clsObj2 = Student.class;
//
//        System.out.println(clsObj2);
    }

    static void func06()
    {
        String str = "123";

//        int value = Integer.parseInt(str);

        int value = Integer.valueOf(str);

        System.out.println(value);
    }

    static void func05()
    {
        ArrayList<String> stringArrayList = new ArrayList<>(10);

        stringArrayList.ensureCapacity(1);

        stringArrayList.add("1");

        System.out.println(stringArrayList);

        stringArrayList.add(null);

        System.out.println(stringArrayList);

        stringArrayList.add("" + 23);
    }

    static void func04()
    {
        Student stu = new Student("sen",100);

        System.out.println(stu.getName());

        Student xiaoMing = new Student("123", 170);
    }

    static void func03()
    {
        Child child = new Child();

        Parent parent = new Parent();

        parent = child;

        child = (Child) parent;

        String string = new String("123");

        /// 没有父子关系的类型不允许强制类型转换(java这个设计很安全)
//        child = (Child) string;

        if (parent instanceof Child)
        {
            System.out.println("是子类");
        }
    }

    static  void  func02()
    {
        Child child = new Child();
        Parent parent = new Parent();

//        parent = child;

        child = (Child) parent;
    }


    static void func01()
    {
        Child childObj = new Child();

        childObj.setName("sen");

        System.out.println(childObj.name);

        Child[] children = new Child[3];

        children[1] = new Child();
    }
}

abstract class Person
{
    private String name;

    public Person(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public abstract String personDescription();
}

class Student extends Person {

    private float score;

    public Student()
    {
        super("");
        this.score = 0;
    }

    public Student(String name, float score)
    {
        super(name);
        this.score = score;
    }

    @Override
    public String personDescription() {
        return "你好，我是一个学生";
    }
}

enum MySize
{
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    MySize(String value)
    {
        this.m_value = value;
    }

    private String m_value;

}

