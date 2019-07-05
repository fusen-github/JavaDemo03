package packageInterface;

//import java.security.Principal;

public class Person implements Comparable<Person> {

    private int age = 0;

    private String name = "";

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Person(String name)
    {
        this.name = name;
    }

    public Person()
    {

    }

    public int getAge()
    {
        return this.age;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public int compareTo(Person o) {

        return this.age - o.age;
    }
}
