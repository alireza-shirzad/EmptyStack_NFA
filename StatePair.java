import java.util.Objects;

public class StatePair {
    private int a;
    private int b;
    public StatePair(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getFirstValue() {
        return a;
    }

    public void setFirstValue(int a) {
        this.a = a;
    }

    public int getSecondValue() {
        return b;
    }

    public void setSecondValue(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatePair statePair = (StatePair) o;
        return a == statePair.a &&
                b == statePair.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "(" + a + "," + b + ")";
    }
}
