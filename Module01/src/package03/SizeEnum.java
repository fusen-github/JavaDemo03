package package03;

public enum SizeEnum {

    SMALL("s"),
    MEDIUM("m"),
    LARGE("l"),
    EXTRA_LARGE("xl");

    private String id;

    private SizeEnum(String id)
    {
        this.id = id;
    }

}
