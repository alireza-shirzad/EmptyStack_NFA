import java.util.Objects;

public abstract class Transition {
    protected int fromState;
    protected int toState;
    protected char input;

    public Transition(int fromState, int toState, char input){
        this.fromState = fromState;
        this.toState = toState;
        this.input = input;
    }

    public int getFromState() {
        return fromState;
    }

    public void setFromState(int fromState) {
        this.fromState = fromState;
    }

    public int getToState() {
        return toState;
    }

    public void setToState(int toState) {
        this.toState = toState;
    }

    public char getInput() {
        return input;
    }

    public void setInput(char input) {
        this.input = input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return fromState == that.fromState &&
                toState == that.toState &&
                input == that.input;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromState, toState, input);
    }

    @Override
    public String toString() {
        return fromState + " " +input + " " + toState;
    }
}
