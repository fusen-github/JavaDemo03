package packageInterface;

import jdk.nashorn.internal.ir.IfNode;

import javax.sound.midi.Soundbank;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class InterfaceTest {

    public static void main(String[] args) {

        func03();
    }

    private static void func03()
    {
        ActionListener listener = new TimerPrinter();

        javax.swing.Timer timerObj = new javax.swing.Timer(1000, listener);

        timerObj.start();

        System.out.println("end");
    }

    private static void func02()
    {
        Comparable p = new Person();

        if (p instanceof Person)
        {
            System.out.println("p 是Person类型");
        }
        else
        {
            System.out.println("NO");
        }

        if (p instanceof Comparable)
        {
            System.out.println("p 实现了Comparable接口");
        }
        else
        {
            System.out.println("p 没有实现Comparable接口");
        }

    }

    private static void func01()
    {
        Person p1 = new Person("老李", 10);

        Person p2 = new Person("老赵", 20);

        Person p3 = new Person("老宋", 30);

        Person p4 = new Person("老王", 40);

        Person[] personArray = new Person[4];

        personArray[0] = p2;
        personArray[1] = p4;
        personArray[2] = p1;
        personArray[3] = p3;

        Arrays.sort(personArray);

        for (Person p : personArray) {
            System.out.println(p.getName() + p.getAge());
        }
    }

    public interface Moveable
    {
        void move(double x, double y);

        double CONST_VALUE = 100;

        double PI = 3.14;
    }

    public interface Second extends Moveable
    {

    }


}
