package turing;

/*
 * Created by Adham Ibrahim on 11/6/2020
 */

import java.util.ArrayList;
import java.util.List;

public class Tape {

    //private Alphabet alphabet;

    private List<Symbol> symbols;
    private int pointer;

    private Tape() {
        symbols = new ArrayList<>();
        pointer = 0;
    }

    private Tape(List<String> initialValues) {
        this();
        for (String symbolString : initialValues) {
            symbols.add(Symbol.get(symbolString));
        }
    }

    public static Tape fromStrings(final List<String> valueStrings) {
        return new Tape(valueStrings);
    }

    public Symbol read() {
        if (pointer < 0 || pointer >= symbols.size())
            throw new RuntimeException("Attempting to read out of bounds: " + pointer);

        return symbols.get(pointer);
    }

    public void write(final Symbol symbol) {
        if (symbol == Symbol.NULL)
            return;

        symbols.set(pointer, symbol);
    }

    public void move(final Direction direction) {
        if (direction == Direction.LEFT) {
            moveLeft();
        } else if (direction == Direction.RIGHT) {
            moveRight();
        }
    }

    private void moveLeft() {
        if (pointer == 0) {
            symbols.add(0, Symbol.BLANK);
        } else {
            pointer--;
        }
    }

    private void moveRight() {
        if (pointer == symbols.size()-1) {
            symbols.add(symbols.size(), Symbol.BLANK);
        } else {
            pointer++;
        }
    }

    public enum Direction {
        LEFT,
        RIGHT,
        //TODO add no movement
        NONE;

        public static Direction get(String transitionDirectionString) {
            //TODO add Direction.get()
            return null;
        }
    }

    @Override
    public String toString() {
        return symbols.toString();
    }

}