package packageData;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.*;

public class HashTableTest {

    public static void main(String[] args) {

        func08();
    }

    private static void func08()
    {
        WeakHashMap<String, String> map = new WeakHashMap<>();

        String key = "123";

        map.put(key, "abc");

        System.out.println(map);


    }

    private static void func07()
    {
        HashMap<String, String> map = new HashMap<>();

        map.put("key1", "value1");

        map.put("key2", "value2");

        Set<String> keySet = map.keySet();

        keySet.remove("key1");

        System.out.println(map);
    }

    private static void func06()
    {
        /* TreeMap: key:不能是null, value:可以是null
        *  TreeMap需要根据key进行排序,所有key不能是null
        * */
        TreeMap<String, String> map = new TreeMap<>();

        map.put("", null);

        System.out.println(map);
    }

    private static void func05()
    {
        /* HashMap: key:可以是null, value:可以是null */
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put(null, null);

        System.out.println(hashMap);
    }

    private static void func04()
    {
        LinkedList<String> names = new LinkedList<>();

        names.add("1");
        names.add("2");
        names.add("3");

        ListIterator<String> listIterator = names.listIterator();

        listIterator.previous();

        listIterator.set("x");

        System.out.println(names);

    }

    private static void func03()
    {
        LinkedList<String> names = new LinkedList<>();

        names.add("1");
        names.add("2");
        names.add("3");

        ListIterator<String> listIterator = names.listIterator();
//        listIterator.next();
//        listIterator.remove();

        listIterator.add("0");
//        String pre = listIterator.previous();
//        String next = listIterator.next();
//        System.out.println("pre = " + pre + ", " + "next = " + next);
        listIterator.previous();

        listIterator.add("-1");
        listIterator.previous();
        listIterator.add("-2");

        System.out.println(names);

        System.out.println(listIterator.next());
        listIterator.remove();
        System.out.println(names);


        /**
         * Removes from the list the last element that was returned by {@link
         * #next} or {@link #previous} (optional operation).  This call can
         * only be made once per call to {@code next} or {@code previous}.
         * It can be made only if {@link #add} has not been
         * called after the last call to {@code next} or {@code previous}.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *         operation is not supported by this list iterator
         * @throws IllegalStateException if neither {@code next} nor
         *         {@code previous} have been called, or {@code remove} or
         *         {@code add} have been called after the last call to
         *         {@code next} or {@code previous}
         */

    }

    private static void func02()
    {
        LinkedList<String> names = new LinkedList<>();

        names.add("1");
        names.add("2");
        names.add("3");

        Iterator<String> it = names.iterator();

        it.next();
        it.next();
        it.remove();

        System.out.println(names);

    }


    /*
    * 集合接口的继承关系
    * 1、Iterable -> Collection
    *
    * 2、Iterator ->
    *
    *
    *
    *
    * */


    private static void func01()
    {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        Iterator<String> it = arrayList.iterator();

        it.next();
        it.remove();
//        it.remove();

//        System.out.println(arrayList);

//        AbstractCollection

//        List


    }



}
