package turing;/*
 * Created by Adham Ibrahim on 11/5/2020
 */

public class Program {

    //TODO rethink names? start/initial state? ...
    private final State startState;
    //TODO multiple termination states?
    private final State terminationState;

    private boolean terminated;

    private Tape tape;
    private State currentState;

    public Program(State startState, State terminationState, Tape initialTape) {
        this.startState = startState;
        this.tape = initialTape;
        this.currentState = startState;
        this.terminationState = terminationState;
        this.terminated = false;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void next() {
        Symbol currentSymbol = tape.read();
        Transition transition = currentState.getTransition(currentSymbol);
        currentState = transition.getTransitionState();
        tape.write(transition.getWriteSymbol());
        tape.move(transition.getTransitionDirection());

        if (currentState == terminationState) {
            terminated = true;
        }
    }

    public void execute() {
        while (!isTerminated()) {
            next();
        }
    }

    public String result() {
        return tape.toString();
    }

}
