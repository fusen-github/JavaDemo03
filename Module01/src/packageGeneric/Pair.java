package packageGeneric;

public class Pair<T extends Comparable> {

    private T one;
    private T another;

    public Pair(T one, T another)
    {
        this.one = one;
        this.another = another;
    }

    public T getOne() {
        return one;
    }

    public void setOne(T one) {
        this.one = one;
    }

    public T getAnother() {
        return another;
    }

    public void setAnother(T another) {
        this.another = another;
    }



}
