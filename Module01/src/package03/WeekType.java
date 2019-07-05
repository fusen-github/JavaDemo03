package package03;

public enum WeekType {

    Monday(1),
    Tuesday(2),
    Wednesday(3),
    Thursday(4),
    Friday(5),
    Sataday(6),
    Sunday(7);

    private int value;

    private WeekType(int value)
    {
        this.value = value;
    }

}
