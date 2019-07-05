package package02;

import java.security.Principal;

public class Child extends Parent {

    public float height;

    public String name;

    private int age;

    private double weight;

    public Child()
    {
        this.name = "";
    }

    protected Child(String name)
    {
        this.name = name;
    }

    private Child(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Child(String name, int age, double weight)
    {
        super();
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public int func01()
    {
        return 0;
    }

    public void func02()
    {

    }

    public void func03(int a, double b)
    {

    }

    private void func04(int a)
    {

    }

}
