# EmptyStack_NFA
A java tool for finding the empty stack NFA (non deterministic finite automata) of a given PDA (Pushdown automata)

## Brief Overview
The empty stack language of a given PDA is the language constructed from it's stack alphabet, on which if the PDA starts, it ends up with an empty stack and will be in a final state. This language is regular and in this JAVA tool finds the proper NFA to detect this language.

## Input Format
NumOfStates AlphabetSize
<br>
FinalStates
<br>
NumrOfRules
<br>
{
<br>
Rules
<br>
}
<br>
* Note that epsilon is represented with -
* A rule is represented in the following manner: BeginingState StackPopElement InputCharacter TransitionState StackPushElement
## Output Format
NumOfStates
<br>
{Final States}
<br>
NumOfRules
<br>
{
<br>
Transitions
<br>
}
