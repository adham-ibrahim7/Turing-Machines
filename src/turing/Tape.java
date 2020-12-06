package turing;

/*
 * Created by Adham Ibrahim on 11/6/2020
 */

import java.util.ArrayList;
import java.util.List;

public class Tape {

    private Alphabet alphabet;

    private List<String> contents;
    private int pointer;

    private Tape(List<String> initialValues, Alphabet alphabet) {
        this.contents = new ArrayList<>();
        this.pointer = 0;
        this.alphabet = alphabet;
        for (String symbol : initialValues) {
            if (!alphabet.isSymbol(symbol)) {
                throw new IllegalArgumentException("Illegal initial tape: contains " + symbol + " that is not in alphabet.");
            }
            contents.add(symbol);
        }
    }

    public static Tape fromStrings(final List<String> valueStrings, Alphabet alphabet) {
        return new Tape(valueStrings, alphabet);
    }

    public String read() {
        if (pointer < 0 || pointer >= contents.size())
            throw new RuntimeException("Attempting to read out of bounds: " + pointer);

        return contents.get(pointer);
    }

    public void write(final String symbol) {
        if (symbol == null)
            return;

        contents.set(pointer, symbol);
    }

    public void move(final Direction direction) {
        if (direction == Direction.NULL) {
            return;
        }

        if (direction == Direction.LEFT) {
            moveLeft();
        } else if (direction == Direction.RIGHT) {
            moveRight();
        }
    }

    private void moveLeft() {
        if (pointer == 0) {
            contents.add(0, " ");
        } else {
            pointer--;
        }
    }

    private void moveRight() {
        if (pointer == contents.size()-1) {
            //TODO remove hardcoded blank
            contents.add(contents.size(), " ");
        } else {
            pointer++;
        }
    }

    public enum Direction {
        LEFT("L"),
        RIGHT("R"),
        NULL("NULL");

        private String directionName;

        private Direction(String directionName) {
            this.directionName = directionName;
        }

        @Override
        public String toString() {
            return directionName;
        }

        public static Direction get(String transitionDirectionString) {
            for (Direction direction : values()) {
                if (direction.toString().equals(transitionDirectionString)) {
                    return direction;
                }
            }

            throw new IllegalArgumentException("No such direction: " + transitionDirectionString);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("|");
        for (String symbol : this.contents) {
            builder.append(symbol).append("|");
        }
        return new String(builder);
    }

}
