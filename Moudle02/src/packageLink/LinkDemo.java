package packageLink;


import java.util.*;

public class LinkDemo {

    public static void main(String[] args) {

        func05();
    }


    private static void func05()
    {
        Hashtable<String, String> table = new Hashtable<>();

        table.put("", "");

        System.out.println(table);
    }

    private static void func04()
    {
        HashMap<String, String> map = new HashMap<>();

        map.put(null, null);
        String oldValue = map.put(null, "123");

        System.out.println(map);
        System.out.println(oldValue);
    }

    private static void func03()
    {
//        SortedSet(接口)
//        LinkedHashSet(实现类，(哈希表(数组+链表/红黑树)+链表)在不允许重复元素的基础上可以记录添加顺序)

//        Object

//        Map


    }

    /**
     * 翻转链表
     * @param header 表头
     */
    private static LinkNode func02(LinkNode header)
    {
        /// 前一个
        LinkNode newHeader = header;

        /// 初始值是第2个
        LinkNode node = header.next;

        header.next = null;

        while (node != null)
        {
            LinkNode tmpNext = node.next;

            node.next = newHeader;

            newHeader = node;

            node = tmpNext;
        }

        func01(newHeader);

        return newHeader;
    }

    /**
     * 打印链表
     * @param header 表头
     */
    private static void func01(LinkNode header)
    {
        LinkNode node = header;

        while (node != null)
        {
            Object data = node.getData();
            System.out.print(data + ", ");
            node = node.next;
        }
    }


    private static void func00()
    {
        LinkNode node1 = new LinkNode("1");
        LinkNode node2 = new LinkNode("2");
        LinkNode node3 = new LinkNode("3");
        LinkNode node4 = new LinkNode("4");
        LinkNode node5 = new LinkNode("5");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        func02(node1);
    }

}

class LinkTable
{

}

class LinkNode
{
    private Object data;
    public LinkNode next;
//    public LinkNode pre;

    public LinkNode(Object data)
    {
        this.data = data;
    }

    public Object getData() {
        return data;
    }



}
