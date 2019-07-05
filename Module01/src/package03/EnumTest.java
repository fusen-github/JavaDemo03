package package03;

public class EnumTest {

    public static void main(String[] args) {

        func01();
    }

    private static void func01()
    {
        String mon = WeekType.Monday.toString();

        System.out.println(mon);

        WeekType type = WeekType.valueOf(mon);

        System.out.println(type);


    }

}
