package packageCollection;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args)
    {

    }

    private static void func04(int[] arr, int target)
    {
        int index_i = 0;
        int index_j = 0;

        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = 1; j < arr.length; j++)
            {
                if (arr[i] + arr[j] == target)
                {
                    index_i = i;
                    index_j = j;
                    break;
                }
            }
        }

        int[] xx = {index_i, index_j};
    }

    private static void func04()
    {
        LinkedHashSet<String> set = new LinkedHashSet<>();

        set.add("2");
        set.add("1");
        set.add("3");

        System.out.println(set);
    }


    private static void func03()
    {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("3");
        hashSet.add("1");
        hashSet.add("2");

        System.out.println(hashSet);
    }

    private static void func02()
    {
        TreeSet treeSet = new TreeSet();

        /* 如果set中已存在，就不再添加 */
        treeSet.add("3");
        treeSet.add("1");
        treeSet.add("2");

        boolean rst = treeSet.add("1");
        System.out.println(rst);
//        treeSet.add("2");

        System.out.println(treeSet);
    }

    private static void func01()
    {
//        Collection
    }
}


