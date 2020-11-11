public class PDA_Transition extends Transition{
    private char popElement;
    private char pushElement;

    public PDA_Transition(int fromState, int toState, char input, char popElement, char pushElement) {
        super(fromState, toState, input);
        this.popElement = popElement;
        this.pushElement = pushElement;
    }

    public char getPopElement() {
        return popElement;
    }

    public void setPopElement(char popElement) {
        this.popElement = popElement;
    }

    public char getPushElement() {
        return pushElement;
    }

    public void setPushElement(char pushElement) {
        this.pushElement = pushElement;
    }

    @Override
    public String toString() {
        String output;
        output = this.fromState + " " + this.popElement + " " + this.input + " " + this.toState + " " + this.pushElement;
        return output;
    }
}
