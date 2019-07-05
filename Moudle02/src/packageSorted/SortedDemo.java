package packageSorted;

public class SortedDemo {

    public static void main(String[] args) {

        int[] array = {78, 35, 52, 12, 3, 2, 9, 17, 4, 67, 7, 48};

        func01(array);

//        func02(array);

//        func03(array);

//        func04(array);

//        func05(array);
    }

    /**
     * 插入排序练习
     * @param array
     */
    private static void func05(int[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            int tmp = array[i];
            int j = i;

            while (j >= 1 && array[j - 1] > tmp)
            {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = tmp;
        }

        for (int value : array)
        {
            System.out.print(value + ", ");
        }
    }


    /**
     * 插入排序(在大多数情况下，插入排序比冒泡快一倍左右，也比选择排序快一些)
     * @param array
     */
    private static void func04(int[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            int valueI = array[i];

            int j = i;

            while (j >= 1 && valueI < array[j - 1])
            {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = valueI;
        }

        for (int value : array) {
            System.out.print(value + ", ");
        }
    }

    /// 3 4 5 6

    /**
     * 选择排序改进版本，找到值最小的那个索引，跟外层循环的i的位置交换
     * @param array
     */
    private static void func03(int[] array)
    {
        int minIndex = 0;

        for (int i = 0; i < array.length - 1; i++)
        {
            minIndex = i;

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

        for (int value : array) {

            System.out.print(value + ", ");
        }
    }


    /**
     * 选择排序 版本1
     * @param array
     */
    private static void func02(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
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

        for (int value : array) {
            System.out.print(value + ", ");
        }
    }

    /**
     * 冒泡
     * @param array
     */
    private static void func01(int[] array)
    {
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

        for (int value : array)
        {
            System.out.print(value + ", ");
        }
    }

}
