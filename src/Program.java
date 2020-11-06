/*
 * Created by Adham Ibrahim on 11/5/2020
 */

import java.util.List;

public class Program {

    private final State startState;
    //TODO refactor termination to instead be if a state reads a value it has no transition for
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
        Value currentValue = tape.read();
        Transition transition = currentState.getTransition(currentValue);
        currentState = transition.getTransitionState();
        tape.write(transition.getWriteValue());
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
