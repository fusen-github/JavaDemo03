package package01;

import java.util.Date;


public class Demo01 {

    int anInt;

    char aChar;

    public static void main(String[] args)
    {
        Demo01 obj = new Demo01();
        obj.func04();
    }


    public int func01(int a, int b)
    {
        return a + b;
    }

    private void func02()
    {
        System.out.println(anInt);
        System.out.println(aChar);

        /// 使用了未初始化的局部变量，会抛出异常
        int x = 1;
        System.out.println(x);
    }

    private void func03()
    {
        String rst = Integer.toBinaryString(3);
        System.out.println(rst);
    }

    private void func04()
    {
        Integer max = Integer.MAX_VALUE;

        System.out.println(max);

        max = max * 4;

        System.out.println(max);
    }
}
