import java.util.ArrayList;

public class PDA {

    private ArrayList<PDA_Transition> transitions;
    private int numOfStates;
    private int numOfAlphabet;
    private ArrayList<Integer> acceptStates;


    public PDA(ArrayList<PDA_Transition> transitions, int numOfStates, int numOfAlphabet, ArrayList<Integer> acceptStates) {
        this.transitions = transitions;
        this.numOfStates = numOfStates;
        this.numOfAlphabet = numOfAlphabet;
        this.acceptStates = acceptStates;
    }

    public int getNumOfTransition(){
        return this.transitions.size();
    }

    public ArrayList<PDA_Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<PDA_Transition> transitions) {
        this.transitions = transitions;
    }

    public int getNumOfStates() {
        return numOfStates;
    }

    public void setNumOfStates(int numOfStates) {
        this.numOfStates = numOfStates;
    }

    public int getNumOfAlphabet() {
        return numOfAlphabet;
    }

    public void setNumOfAlphabet(int numOfAlphabet) {
        this.numOfAlphabet = numOfAlphabet;
    }

    public ArrayList<Integer> getAcceptStates() {
        return acceptStates;
    }

    public void setAcceptStates(ArrayList<Integer> acceptStates) {
        this.acceptStates = acceptStates;
    }

    @Override
    public String toString() {
        String output;
        output = numOfStates + " " + numOfAlphabet + "\n";
        for (int i = 0; i <acceptStates.size() ; i++) {
            if (i!=acceptStates.size()-1) output = output + acceptStates.get(i) + " ";
            else output = output + acceptStates.get(i) + "\n";
        }
        output = output + this.getNumOfTransition() + "\n" ;
        for (int i = 0; i < this.transitions.size(); i++) {
            if (i!=this.transitions.size()-1) output = output +  this.transitions.get(i).toString() + "\n";
            else output = output + this.transitions.get(i).toString();
        }
        return output;
    }
}
