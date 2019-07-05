package packageGeneric;

public class GenericTest {

    public static void main(String[] args) {

        func01();
    }

    private static void func02()
    {

    }

    private static void func01()
    {
        /// 泛型类
        Pair<String> aPair = new Pair<>("123", "456");

        String one = aPair.getOne();

        String another = aPair.getAnother();

        System.out.println(one);
        System.out.println(another);
    }
}
