package turing;

/*
 * Created by Adham Ibrahim on 11/6/2020
 */

import turing.Tape.Direction;

public class Transition {

    private final State transitionState;
    private final Direction transitionDirection;
    private final String writeSymbol;

    private final String cachedToString;

    public Transition(String writeSymbol, Direction transitionDirection, State transitionState) {
        this.writeSymbol = writeSymbol;
        this.transitionDirection = transitionDirection;
        this.transitionState = transitionState;

        this.cachedToString = cacheToString();
    }

    public String getWriteSymbol() {
        return writeSymbol;
    }

    public Direction getTransitionDirection() {
        return transitionDirection;
    }

    public State getTransitionState() {
        return transitionState;
    }

    private String cacheToString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("write: " + writeSymbol + ", ");
        builder.append("move tape: " + transitionDirection.toString() + ", ");
        builder.append("go to: " + transitionState.toString());
        return new String(builder);
    }

    @Override
    public String toString() {
        return cachedToString;
    }

}
