import java.util.HashSet;

public class NFA_TransitionSet {
    private HashSet<NFA_Transition> transitions;

    public NFA_TransitionSet(){
        transitions = new HashSet<>();
    }
    public NFA_TransitionSet(int numOfStates){
        this();
        for (int i = 1; i < numOfStates + 1; i++) {
            transitions.add(new NFA_Transition(i,i,'-'));
        }
    }

    public HashSet<NFA_Transition> getTransitions() {
        return transitions;
    }

    public int getSize(){
        return transitions.size();
    }
    public void add(NFA_Transition transition){
        transitions.add(transition);
    }
    public void addAll(HashSet<NFA_Transition> transitions){
        this.transitions.addAll(transitions);
    }

    public boolean isMember(NFA_Transition transition){
        return transitions.contains(transition);
    }

    public void checkTransitive(){
        int s;
        HashSet<NFA_Transition> toMerge = new HashSet<>();
        for (NFA_Transition leftTransition : transitions) {
            s = leftTransition.toState;
            for (NFA_Transition rightTransition : transitions) {
                if (rightTransition.fromState==s){
                    toMerge.add(new NFA_Transition(leftTransition.fromState,rightTransition.toState,'-'));
                }
            }
        }
        transitions.addAll(toMerge);
    }

    @Override
    public String toString() {
        String output = "";
        for (NFA_Transition transition : transitions) {
            output = output + transition + "\n";
        }
        return output;
    }
}
