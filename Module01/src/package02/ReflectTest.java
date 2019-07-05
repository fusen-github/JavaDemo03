package package02;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 测试反射类
 */
public class ReflectTest {

    public static void main(String[] args) {

        getClassInfo(args);
    }

    static void getClassInfo(String[] args)
    {
        String name;

        if (args.length > 0)
        {
            name = args[0];
        }
        else
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入类名:");
            name = scanner.next();
        }

        try {
            Class cl = Class.forName(name);

            Class superClass = cl.getSuperclass();

            /// 修饰语
            String mdf = Modifier.toString(cl.getModifiers());

            if (mdf.length() > 0)
            {
                System.out.print(mdf + " ");
            }

            System.out.print("class " + name);

            if (superClass != null && superClass != Object.class)
            {
                System.out.print(" extends " + superClass.getName());
            }

            System.out.print("\n{\n");

            printConstructors(cl);

            printMethod(cl);

            printField(cl);

            System.out.println("};");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印构造方法
     * @param cls 类对象
     */
    static void printConstructors(Class cls)
    {
        Constructor[] constructors = cls.getConstructors();

        for (Constructor obj : constructors) {

            String name = obj.getName();

            System.out.print("  ");

            /// 修饰符
            String mod = Modifier.toString(obj.getModifiers());

            if (mod.length() > 0)
            {
                System.out.print(mod + " ");
            }

            System.out.print(name + "(");

            Class[] parameterTypes = obj.getParameterTypes();

            for (int i = 0; i < parameterTypes.length; i++)
            {
                Class aClass = parameterTypes[i];

                System.out.print(aClass.getName());

                if (i < parameterTypes.length - 1)
                {
                    System.out.print(", ");
                }
            }

            System.out.println(");\n");
        }
    }

    static void printMethod(Class cls)
    {
        Method[] methods = cls.getMethods();

        for (Method mObj : methods)
        {
            Class retType = mObj.getReturnType();
            String mName = mObj.getName();

            System.out.print("  ");

            String mod = Modifier.toString(mObj.getModifiers());

            if (mod.length() > 0)
            {
                System.out.print((mod + " "));
            }

            System.out.print(retType + " " + mName + "(");

            Class<?>[] parameterTypes = mObj.getParameterTypes();

            for (int i = 0; i < parameterTypes.length; i++) {

                Class type = parameterTypes[i];

                String name = type.getName();

                if (i < parameterTypes.length - 1)
                {
                    name = name + ", ";
                }

                System.out.print(name);
            }

            System.out.print(");\n");
        }

        System.out.println();
    }

    static void printField(Class cls)
    {
        Field[] fields = cls.getFields();

        for (Field var : fields)
        {
            System.out.print("  ");

            String mod = Modifier.toString(var.getModifiers());

            System.out.print(mod);

            Class type = var.getType();

            System.out.print(" " + type + " " + var.getName() + ";\n");
        }
    }

}
