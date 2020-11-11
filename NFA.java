import java.util.ArrayList;

public class NFA {
    private int numOfStates;
    private ArrayList<Integer> acceptStates;
    private ArrayList<NFA_Transition> transitions;

    public NFA(int numOfStates, ArrayList<Integer> acceptStates, ArrayList<NFA_Transition> transitions) {
        this.numOfStates = numOfStates;
        this.acceptStates = acceptStates;
        this.transitions = transitions;
    }

    public int getNumOfTransition(){
        return this.transitions.size();
    }

    public int getNumOfStates() {
        return numOfStates;
    }

    public void setNumOfStates(int numOfStates) {
        this.numOfStates = numOfStates;
    }

    public ArrayList<Integer> getAcceptStates() {
        return acceptStates;
    }

    public void setAcceptStates(ArrayList<Integer> acceptStates) {
        this.acceptStates = acceptStates;
    }

    public ArrayList<NFA_Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<NFA_Transition> transitions) {
        this.transitions = transitions;
    }

    @Override
    public String toString() {
        String output;
        output = numOfStates + "\n";
        if (acceptStates.size()!=0) {
            for (int i = 0; i < acceptStates.size(); i++) {
                if (i != acceptStates.size() - 1) output = output + acceptStates.get(i) + " ";
                else output = output + acceptStates.get(i) + "\n";
            }
        }else{
            output = output + "\n";
        }
        output = output + this.getNumOfTransition() + "\n" ;
        for (int i = 0; i < this.transitions.size(); i++) {
            if (i!=this.transitions.size()-1) output = output +  this.transitions.get(i).toString() + "\n";
            else output = output + this.transitions.get(i).toString();
        }
        return output;
    }
}
