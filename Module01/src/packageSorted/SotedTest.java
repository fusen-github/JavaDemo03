package packageSorted;

import javafx.geometry.VPos;

import java.util.Arrays;
import java.util.Comparator;

public class SotedTest {

    public static void main(String[] args) {

        func01();

    }

    private static void func01()
    {
        String[] names = new String[5];
        names[0] = "zhangsan";
        names[1] = "wanger";
        names[2] = "zhaoyi";
        names[3] = "lisi";
        names[4] = "xijinping";

        System.out.println("排序前:");
        printArray(names);

        Comparator obj = new LengthComparator();

        Arrays.sort(names, obj);
        System.out.println("排序后:");
        printArray(names);
    }

    private static void printArray(String[] arr)
    {
        for (String s : arr) {
            System.out.println(s);
        }
    }
}

class LengthComparator implements Comparator<String>
{
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
