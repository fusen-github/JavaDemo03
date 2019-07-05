package packageSorted;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.sql.SQLOutput;
import java.util.LinkedHashSet;
import java.util.Random;

public class SortedTest {

    public static void main(String[] args) throws IOException {

//        func01();
//        int[] array = {78, 102, 200, 35, 52, 100, 12, 3, -40, 2, 88, 9, 17, 4, 67, 7, 48,-20, -30};

        /// 测试冒泡
        int[] array = func02();
//        sorted01(array);
//        outputResult(array, "冒泡排序");

        /// 测试选择排序(未优化)
//        array = func02();
//        sorted02(array);
//        outputResult(array, "选择(未优化)");


        /// 测试选择排序(优化)
//        array = func02();
//        sorted03(array);
//        outputResult(array, "选择(优化)");


        /// 测试插入排序
//        array = func02();
//        sorted04(array);
//        outputResult(array, "插入排序");


        /// 测试链表排序
//        array = func02();
//        sorted05(array);
//        outputResult(array, "链表排序");


//        array = func02();
//        sorted06(array);
//        outputResult(array, "链表排序(优化)");

//        array = func02();
        sorted07(array);
        outputResult(array, "归并排序");

//        System.out.println("最大值: " + Integer.MAX_VALUE);
//        System.out.println("最小值: " + Integer.MIN_VALUE);
    }

    private static void outputResult(int[] array, String desc)
    {
        File file = new File(desc + ".txt");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int value : array) {

            try {
                fileWriter.write("" + value + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 归并排序
     * @param array
     */
    private static void sorted07(int[] array)
    {
        long start = System.currentTimeMillis();

        recMergeSorted(array, 0, array.length - 1);

        long end = System.currentTimeMillis();

        System.out.println("归并耗时: " + (end - start));
    }

    private static void recMergeSorted(int[] array, int lower, int upper)
    {
        if (lower < upper)
        {
            int mid = (lower + upper) / 2;

//            System.out.println("111");

            recMergeSorted(array, lower, mid);

//            System.out.println("2222");

            recMergeSorted(array, mid + 1, upper);

//            System.out.println("333333");

            merge(array, lower, mid, upper);

//            System.out.println("4444444444");
        }
    }

    private static void merge(int[] array, int lower, int mid, int upper)
    {
        int len = upper - lower + 1;

        int[] tmpArray = new int[len];

        int i = lower;

        int j = mid + 1;

        int k = 0;

        while (i <= mid && j <= upper)
        {
            if (array[i] < array[j])
            {
                tmpArray[k++] = array[i++];
            }
            else
            {
                tmpArray[k++] = array[j++];
            }
        }

        while (i <= mid)
        {
            tmpArray[k++] = array[i++];
        }

        while (j <= upper)
        {
            tmpArray[k++] = array[j++];
        }

        for (int index = 0; index < tmpArray.length; index++)
        {
            array[index + lower] = tmpArray[index];
        }

    }


    /**
     * 用链表排序(correct)
     * @param array
     */
    private static void sorted06(int[] array)
    {
        Integer[] objArray = new Integer[array.length];

        for (int i = 0; i < array.length; i++)
        {
            objArray[i] = array[i];
        }

        long start = System.currentTimeMillis();

        packageSorted02.SortedLink.sortedArray(objArray);

        long end = System.currentTimeMillis();

        System.out.println("链表排序(优化)耗时: " + (end - start));

        for (int i = 0; i < array.length; i++)
        {
            array[i] = objArray[i];
        }

    }

    /**
     * 用链表排序(error)
     * @param array
     */
    private static void sorted05(int[] array)
    {
        Integer[] objArray = new Integer[array.length];

        for (int i = 0; i < array.length; i++)
        {
            objArray[i] = array[i];
        }

        long start = System.currentTimeMillis();

        SortedLink link = new SortedLink();

        /// 排序前
        /*
        System.out.println("排序前:");

        for (Integer integer : objArray)
        {
            System.out.print(integer + ", ");
        }

        System.out.println();
        */

        link.sortedArray(objArray);

        long end = System.currentTimeMillis();

        System.out.println("链表排序耗时: " + (end - start));

        for (int i = 0; i < objArray.length; i++)
        {
            array[i] = objArray[i];
        }

        /*
        System.out.println();
        /// 排序后
        System.out.println("排序后:");

        for (Integer integer : objArray)
        {
            System.out.print(integer + ", ");
        }
        */
    }

    /**
     * 插入排序
     * @param array
     */
    private static void sorted04(int[] array)
    {
        long start = System.currentTimeMillis();

        for (int i = 1; i < array.length; i++)
        {
            int tmpValue = array[i];

            int j = i;

            while (j >= 1 && tmpValue < array[j - 1])
            {
                array[j] = array[j - 1];

                j--;
            }

            array[j] = tmpValue;
        }

        long end = System.currentTimeMillis();

        System.out.println("插入排序耗时: " + (end - start));
    }


    /**
     * 选择排序02（优化版）
     * @param array
     */
    private static void sorted03(int[] array)
    {
        long start = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++)
            {
                if (array[minIndex] > array[j])
                {
                    minIndex = j;
                }
            }

            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }

        long end = System.currentTimeMillis();

        System.out.println("选择排序(优化版)耗时: " + (end - start));
    }

    /**
     * 选择排序01
     * @param array
     */
    private static void sorted02(int[] array)
    {
        long start = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[i] > array[j])
                {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("选择排序耗时: " + (endTime - start));
    }

    /**
     * 冒泡排序
     * @param array 数组
     */
    private static void sorted01(int[] array)
    {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        long endTime = System.currentTimeMillis();

        // 用时: 1867743
        System.out.println("冒泡排序耗时: " + (endTime - startTime));
    }

    private static int[] func02() throws IOException {

        final int largeValue = 100000;

        int[] array = new int[largeValue];

        File file = new File("array.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = null;

        int i = 0;

        while ((line = reader.readLine()) != null)
        {
            int value = Integer.parseInt(line);

            array[i] = value;

            i++;

            if (i == largeValue) break;
        }

        return array;
    }

    /**
     * 生成一个1000000个数据的随机数组，并写入本地文件
     */
    private static void func01() throws IOException {

        final int largeValue = 100000;

        Random random = new Random();

        File file = new File("array.txt");

        FileWriter fileWriter = new FileWriter(file);

        for (int i = 0; i < largeValue; i++)
        {
            int value = random.nextInt(largeValue);

            fileWriter.write("" + value + "\n");
        }

        fileWriter.close();
    }

}
