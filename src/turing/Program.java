package turing;/*
 * Created by Adham Ibrahim on 11/5/2020
 */

import java.util.List;

public class Program {

    //TODO rethink names? start/initial state? ...
    private final State startState;
    private final List<State> finalStates;

    private boolean terminated;

    private Tape tape;
    private State currentState;

    public Program(State startState, List<State> finalStates, Tape initialTape) {
        this.startState = startState;
        this.tape = initialTape;
        this.currentState = startState;
        this.finalStates = finalStates;
        this.terminated = false;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void next() {
        String currentSymbol = tape.read();
        Transition transition = currentState.getTransition(currentSymbol);
        currentState = transition.getTransitionState();
        tape.write(transition.getWriteSymbol());
        tape.move(transition.getTransitionDirection());

        if (finalStates.contains(currentState)) {
            terminated = true;
        }
    }

    public void execute() {
        while (!isTerminated()) {
            next();
        }
    }

    public String getTapeContents() {
        return tape.toString();
    }

    public State getCurrentState() {return currentState;}

}
