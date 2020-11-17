package turing;

/*
 * Created by Adham Ibrahim on 11/6/2020
 */

import turing.Tape.Direction;

public class Transition {

    private final State transitionState;
    private final Direction transitionDirection;
    private final Symbol writeSymbol;

    public Transition(Symbol writeSymbol, Direction transitionDirection, State transitionState) {
        this.writeSymbol = writeSymbol;
        this.transitionDirection = transitionDirection;
        this.transitionState = transitionState;
    }

    public Symbol getWriteSymbol() {
        return writeSymbol;
    }

    public Direction getTransitionDirection() {
        return transitionDirection;
    }

    public State getTransitionState() {
        return transitionState;
    }

}
