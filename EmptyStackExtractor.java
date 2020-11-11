import java.util.ArrayList;
import java.util.HashSet;

public class EmptyStackExtractor {
    private PDA pda;
    private NFA_TransitionSet transitionSet;
    public EmptyStackExtractor(PDA pda) {
        this.pda = pda;
        transitionSet = new NFA_TransitionSet(pda.getNumOfStates());
    }
    public NFA extract(){
        setEpsilonLabels();
        setNonEpsilonLabels();
//        System.out.println(transitionSet.toString());
        NFA nfa = new NFA(pda.getNumOfStates(),pda.getAcceptStates(),new ArrayList<NFA_Transition>(transitionSet.getTransitions()));
        return nfa;
    }


    private void setNonEpsilonLabels(){
        HashSet<NFA_Transition> toMergeTransitions = new HashSet<>();
        for (NFA_Transition nfaTransition : transitionSet.getTransitions()) {
            for (PDA_Transition pdaTransition : pda.getTransitions()) {
                if (pdaTransition.getFromState()==nfaTransition.getToState() && pdaTransition.getPopElement()!='-'){
                    toMergeTransitions.add(new NFA_Transition(nfaTransition.getFromState(),pdaTransition.getToState(),pdaTransition.getPopElement()));
                }
            }
        }
        transitionSet.addAll(toMergeTransitions);
    }


    public void setEpsilonLabels(){
        setnoPushPop();
        transitionSet.checkTransitive();
        int size = 0;
        while(size!=transitionSet.getSize()){
            size = transitionSet.getSize();
            prune();
            transitionSet.checkTransitive();
        }
//        System.out.println("\n,,,,,,,,,,,,,\n" + transitionSet.toString());
    }

    public void prune(){
        HashSet<NFA_Transition> toMergeTransitions = new HashSet<>();
        char label;
        for (NFA_Transition nfaTransition : transitionSet.getTransitions()) {
            for (PDA_Transition lefTransition : pda.getTransitions()) {
                if (lefTransition.getToState()==nfaTransition.fromState & lefTransition.getPushElement()!='-'){
//                    System.out.println("////////////\n" + lefTransition + "\n.........");
                    label = lefTransition.getPushElement();
                    for (PDA_Transition rightTransition : pda.getTransitions()) {
                        if (rightTransition.getFromState()==nfaTransition.toState & rightTransition.getPopElement()==label){
//                            System.out.println(rightTransition + "\n..........+\n" + new NFA_Transition(lefTransition.getFromState(),rightTransition.getToState(),'-') + "\n//////////\n");
                            toMergeTransitions.add(new NFA_Transition(lefTransition.getFromState(),rightTransition.getToState(),'-'));
                        }
                    }
                }
            }
        }
//        System.out.println(toMergeTransitions);
        transitionSet.addAll(toMergeTransitions);
    }

    private void setnoPushPop(){
        for (PDA_Transition transition : pda.getTransitions()) {
            if (transition.getPopElement()=='-'&transition.getPushElement()=='-')
                transitionSet.add(new NFA_Transition(transition.fromState,transition.getToState(),'-'));
        }
    }


}
