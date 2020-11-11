import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Parser {

    private Scanner scanner;
    private String stateAndAlphabetLine;
    private String acceptedStatesLine;
    private String transitionFunctionLine;

    public Parser(){
        scanner = new Scanner(System.in);
    }

    public PDA parse(){

        // Parsed Elements
        int numOfStates;
        int numOfAlphabets;
        ArrayList<Integer> acceptStates = new ArrayList<>();
        int numOfTransitions;
        ArrayList<PDA_Transition> transitions = new ArrayList<>();

        // Parsing the Actual Elements

        stateAndAlphabetLine = scanner.nextLine();
        List<Integer> tmpStateAndAlphabet = Arrays.stream(stateAndAlphabetLine.split(" ")).map(item->Integer.valueOf(item.trim())).collect(Collectors.toList());
        numOfStates = tmpStateAndAlphabet.get(0);
        numOfAlphabets = tmpStateAndAlphabet.get(1);


        acceptedStatesLine = scanner.nextLine();
        if (!acceptedStatesLine.equals(""))
            acceptStates  = (ArrayList) Arrays.stream(acceptedStatesLine.split(" ")).map(item->Integer.valueOf(item.trim())).collect(Collectors.toList());

        numOfTransitions = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfTransitions; i++) {
            transitionFunctionLine = scanner.nextLine();
            String[] splitedLine = transitionFunctionLine.split("\\s+");
            int fromState = Integer.parseInt(splitedLine[0]);
            char popElement = splitedLine[1].charAt(0);
            char input = splitedLine[2].charAt(0);
            int toState = Integer.parseInt(splitedLine[3]);
            char pushElement = splitedLine[4].charAt(0);
            transitions.add(new PDA_Transition(fromState,toState,input,popElement,pushElement));
        }

        // Creating the DFA
        PDA pda = new PDA(transitions,numOfStates,numOfAlphabets,acceptStates);
//        System.out.println("------------------------------- Parsing Started -------------------------------------\nResults:");
//        System.out.println(pda + "\n------------------------------- Parsing Finished -------------------------------------");
        return pda;
    }

}
