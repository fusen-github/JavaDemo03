package packageSorted04;

import java.io.*;
import java.rmi.Remote;
import java.util.Random;

public class SortedDemo {

    private static final int arraySize = 10000000;

    public static void main(String[] args) throws IOException {

//        generateDataSource();

        sortedArrayFunc();
    }

    private static void sortedArrayFunc() throws IOException
    {
        int[] array;

        /// 冒泡排序
//        array = readArray();
//        sorted01(array);
//        writeToFile(array, "01冒泡");
//
//        /// 选择排序(未优化)
//        array = readArray();
//        sorted02(array);
//        writeToFile(array, "02选择(慢)");
//
//        /// 选择排序优化后
//        array = readArray();
//        sorted03(array);
//        writeToFile(array, "03选择(快)");
//
//        /// 插入排序
//        array = readArray();
//        sorted04(array);
//        writeToFile(array, "04插入排序");

        /// 归并排序
        array = readArray();
        sorted05(array);
        writeToFile(array, "05归并排序");

        /// 希尔排序
        array = readArray();
        sorted06(array);
        writeToFile(array, "06希尔排序");

        /// 快速排序
        array = readArray();
        sorted07(array);
        writeToFile(array, "07快速排序");
    }

    /**
     * 快速排序
     * @param array
     */
    private static void sorted07(int[] array)
    {
        long start = System.currentTimeMillis();

        fastSorted(array, 0, array.length - 1);

        long end = System.currentTimeMillis();

        System.out.println("快速排序耗时: " + (end - start));
    }

    private static void fastSorted(int[] array, int left, int right)
    {
        if (left >= right)
        {
            return;
        }

        int midValue = array[right];

        int newMidIndex = divideArray(array, left, right, midValue);

        fastSorted(array, left, newMidIndex - 1);

        fastSorted(array, newMidIndex + 1, right);
    }

    /**
     * 分组离数组，
     * @param array 待分离的数组
     * @param left  分组后数组最左边的索引
     * @param right 分组后数组最右边的索引
     * @param midValue 选取的分界线值
     * @return
     */
    private static int divideArray(int[] array, int left, int right, int midValue)
    {
        int tmpLeft = left - 1;
        int tmpRight = right;

        while (true)
        {
            while (array[++tmpLeft] < midValue)
            {

            }

            while (tmpRight > 0 && array[--tmpRight] > midValue)
            {

            }

            if (tmpLeft >= tmpRight)
            {
                int tmpValue = array[tmpLeft];
                array[tmpLeft] = array[right];
                array[right] = tmpValue;

                break;
            }

            int tmpValue = array[tmpLeft];
            array[tmpLeft] = array[tmpRight];
            array[tmpRight] = tmpValue;
        }

        return tmpLeft;
    }

    /**
     * 希尔排序
     * @param array
     */
    private static void sorted06(int[] array)
    {
        long start = System.currentTimeMillis();

        int h = 1;
        while (h < array.length / 3)
        {
            /// 固定公式
            h = 3 * h + 1;
        }

        while (h > 0)
        {
            for (int i = h; i < array.length; i++)
            {
                int tmpValue = array[i];
                int j = i;

                while (j >= h && tmpValue < array[j - h])
                {
                    array[j] = array[j - h];
                    j -= h;
                }

                array[j] = tmpValue;
            }

            h = (h - 1) / 3;
        }

        long end = System.currentTimeMillis();

        System.out.println("希尔排序: " + (end - start));
    }

    /**
     * 归并排序
     * @param array
     */
    private static void sorted05(int[] array)
    {
        long start = System.currentTimeMillis();

        reMerge(array, 0, array.length - 1);

        long end = System.currentTimeMillis();

        System.out.println("归并排序耗时: " + (end - start));
    }

    private static void reMerge(int[] array, int lower, int upper)
    {
        if (lower < upper)
        {
            int mid = (upper + lower) / 2;

            reMerge(array, lower, mid);

            reMerge(array, mid + 1, upper);

            mergeAction(array, lower, mid, upper);
        }
    }

    private static void mergeAction(int[] array, int lower, int mid, int upper)
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
            array[lower+index] = tmpArray[index];
//            System.out.println("index = " + (lower + index));
        }

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
            int value = array[i];

            int j = i;

            while (j >= 1 && value < array[j-1])
            {
                array[j] = array[j-1];
                j--;
            }

            array[j] = value;
        }

        long end = System.currentTimeMillis();

        System.out.println("插入排序: " + (end - start));
    }

    /**
     * 选择排序(优化)
     * @param array
     */
    private static void sorted03(int[] array)
    {
        long start = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++)
        {
            /// 最小值的索引
            int minIndex = i;

            for (int j = minIndex + 1; j < array.length; j++)
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

        System.out.println("选择排序(优化): " + (end - start));
    }

    /**
     * 选择排序(未优化)
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

        long end = System.currentTimeMillis();

        System.out.println("选择排序(慢): " + (end - start));
    }

    /**
     * 冒泡排序
     * @param array
     */
    private static void sorted01(int[] array)
    {
        long start = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    /* 1、以外层循环控制进度，内层循环做比较
                    *  2、内层循环走完后会得到一个应该在最右边的值
                    *  3、通过不断的交换和比较将最右边的值归位放到最右边的位置上
                    *  4、效率最慢
                    * */
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("冒泡排序耗时: " + (end - start));
    }


    private static void writeToFile(int[] array, String title) throws IOException
    {
        File file = new File("Moudle02/src/packageSorted04/" + title + ".txt");

        FileWriter fileWriter = new FileWriter(file);

        for (int value : array) {

            fileWriter.write(value + "\n");
        }

        fileWriter.close();
    }

    private static int[] readArray() throws IOException {

        int[] array = new int[arraySize];

        File file = new File("Moudle02/src/packageSorted04/array.txt");

        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        int index = 0;

        while ((line = bufferedReader.readLine()) != null)
        {
            int value = Integer.parseInt(line);

            array[index++] = value;
        }

        return array;
    }

    private static void generateDataSource() throws IOException
    {
        File file = new File("Moudle02/src/packageSorted04/array.txt");

        FileWriter fileWriter = new FileWriter(file);

        Random random = new Random();

        int largeNum = arraySize;

        for (int i = 0; i < largeNum; i++)
        {
            int value = random.nextInt(largeNum);

            fileWriter.write("" + value + "\n");
        }

        fileWriter.close();

    }

}
