/*
 * Created by Adham Ibrahim on 11/6/2020
 */

import java.util.Arrays;
import java.util.List;

public class TuringMachine {
    public static void main(String[] args) {
        State right = new State();
        State carry = new State();
        State done = new State();

        right.addTransition(Value.ZERO, new Transition(right, Tape.Direction.RIGHT));
        right.addTransition(Value.ONE, new Transition(right, Tape.Direction.RIGHT));
        right.addTransition(Value.BLANK, new Transition(carry, Tape.Direction.LEFT));

        carry.addTransition(Value.ONE, new Transition(carry, Tape.Direction.LEFT, Value.ZERO));
        carry.addTransition(Value.ZERO, new Transition(done, Tape.Direction.LEFT, Value.ONE));
        carry.addTransition(Value.BLANK, new Transition(done, Tape.Direction.LEFT, Value.ONE));

        List<String> initValues = Arrays.asList("1", "0", "1", "1");

        Program program = new Program(right, done, Tape.fromStrings(initValues));
        program.execute();

        System.out.println(program.result());
    }
}
