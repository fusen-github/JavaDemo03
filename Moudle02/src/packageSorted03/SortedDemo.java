package packageSorted03;

import java.io.*;

public class SortedDemo {

    public static void main(String[] args) throws IOException {

        int[] array;

        /// 冒泡排序
        array = func02();
        sorted01(array);
        writeToFile(array, "冒泡排序");

        /// 选择排序
        array = func02();
        sorted02(array);
        writeToFile(array, "选择排序");

        array = func02();
        sorted03(array);
        writeToFile(array, "选择(优化版)");

        array = func02();
        sorted04(array);
        writeToFile(array, "插入排序");

        array = func02();
        sorted05(array);
        writeToFile(array, "归并排序");

    }

    /**
     * 归并排序
     * @param array
     */
    private static void sorted05(int[] array)
    {
        long start = System.currentTimeMillis();

        recursionSorted(array, 0, array.length - 1);

        long end = System.currentTimeMillis();

        System.out.println("归并排序耗时: " + (end - start));
    }

    private static void recursionSorted(int[] array, int lower, int upper)
    {
        if (lower < upper)
        {
            int mid = (lower + upper) / 2;

            recursionSorted(array, lower, mid);

            recursionSorted(array, mid + 1, upper);

            recursionMerge(array, lower, mid, upper);
        }
    }

    private static void recursionMerge(int[] array, int lower, int mid, int upper)
    {
        int[] tmpArray = new int[upper - lower + 1];

        int i = lower;

        int j = mid + 1;

        int index = 0;

        while (i <= mid && j <= upper)
        {
            if (array[i] < array[j])
            {
                tmpArray[index++] = array[i++];
            }
            else
            {
                tmpArray[index++] = array[j++];
            }
        }

        while (i <= mid)
        {
            tmpArray[index++] = array[i++];
        }

        while (j <= upper)
        {
            tmpArray[index++] = array[j++];
        }

        for (int k = 0; k < tmpArray.length; k++)
        {
            array[lower + k] = tmpArray[k];
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
            int j = i;

            int value = array[i];

            while (j >= 1 && value < array[j - 1])
            {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = value;
        }

        long end = System.currentTimeMillis();

        System.out.println("插入排序耗时: " + (end - start));
    }

    /**
     * 选择排序优化版
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

        System.out.println("选择排序(优化)耗时: " + (end - start));
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

        System.out.println("选择排序耗时: " + (end - start));

    }


    /**
     * 冒泡排序
     * @param array 待排序数组
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
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("冒泡排序耗时: " + (end - start));
    }

    private static void writeToFile(int[] array, String title) throws IOException {

        String path = "Moudle02/src/packageSorted03/" + title + ".txt";

        File file = new File(path);

        FileWriter writer = new FileWriter(file);

        for (int value : array) {

            writer.write(value + "\n");
        }

        writer.close();
    }

    /**
     * 获取数据源
     * @return 排序前的数组
     * @throws IOException
     */
    private static int[] func02()throws IOException
    {
        int[] array = new int[100000];

        File file = new File("array.txt");

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

}
