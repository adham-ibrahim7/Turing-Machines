/*
 * Created by Adham Ibrahim on 11/6/2020
 */

public class Transition {

    private final State transitionState;
    private final Tape.Direction transitionDirection;
    private final Value writeValue;

    public Transition(State transitionState, Tape.Direction transitionDirection) {
        this(transitionState, transitionDirection, Value.SKIP_WRITE);
    }

    public Transition(State transitionState, Tape.Direction transitionDirection, Value writeValue) {
        this.transitionState = transitionState;
        this.transitionDirection = transitionDirection;
        this.writeValue = writeValue;
    }

    public State getTransitionState() {
        return transitionState;
    }

    public Tape.Direction getTransitionDirection() {
        return transitionDirection;
    }

    public Value getWriteValue() {
        return writeValue;
    }

}
