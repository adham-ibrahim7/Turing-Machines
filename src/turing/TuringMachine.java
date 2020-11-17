package turing;/*
 * Created by Adham Ibrahim on 11/6/2020
 */

import java.util.Arrays;
import java.util.List;

public class TuringMachine {
    public static void main(String[] args) {
        State right = new State("");
        State carry = new State("");
        State done = new State("");

        /*
        right.addTransition(Symbol.ZERO, new Transition(right, Tape.Direction.RIGHT, Symbol.NULL));
        right.addTransition(Symbol.ONE, new Transition(right, Tape.Direction.RIGHT));
        right.addTransition(Symbol.BLANK, new Transition(carry, Tape.Direction.LEFT));

        carry.addTransition(Symbol.ONE, new Transition(carry, Tape.Direction.LEFT, Symbol.ZERO));
        carry.addTransition(Symbol.ZERO, new Transition(done, Tape.Direction.LEFT, Symbol.ONE));
        carry.addTransition(Symbol.BLANK, new Transition(done, Tape.Direction.LEFT, Symbol.ONE));*/

        List<String> initValues = Arrays.asList("1", "0", "1", "1");

        Program program = new Program(right, done, Tape.fromStrings(initValues));
        program.execute();

        System.out.println(program.result());
    }
}
