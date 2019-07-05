package packageThread;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    public static void main(String[] args) {

        func01();
    }

    private static void func02()
    {
        Lock lock = new ReentrantLock();

//        ConcurrentHashMap

        Hashtable hashtable = new Hashtable();
//        hashtable.put()

        HashMap map = new HashMap();
        HashMap<String, String> map1 = new HashMap<>();


    }


    private static void func01()
    {
        Thread thread = new Thread();

        Thread.State state = thread.getState();

        /*
        * 线程调度器
        *
        * */

        /*
        * 线程状态:
        * new,
        * runnable,
        * blocked
        * waiting
        * timed waiting
        * terminated
        * */


        /*
        * 线程属性:
        * 线程优先级
        * 守护线程
        * 线程组
        * 处理未捕获异常的处理器
        *
        * */

        

    }


}
