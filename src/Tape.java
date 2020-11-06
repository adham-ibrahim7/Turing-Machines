/*
 * Created by Adham Ibrahim on 11/6/2020
 */


import java.util.ArrayList;
import java.util.List;

public class Tape {

    private List<Value> values;
    private int pointer;

    private Tape() {
        values = new ArrayList<>();
        pointer = 0;
    }

    /*public Tape(List<Value> initialValues) {
        values = new ArrayList<>(initialValues);
        pointer = 0;
    }*/

    private Tape(List<String> initialValueStrings) {
        this();
        for (String valueString : initialValueStrings) {
            values.add(Value.fromString(valueString));
        }
    }

    public static Tape fromStrings(List<String> valueStrings) {
        return new Tape(valueStrings);
    }

    public Value read() {
        if (pointer < 0 || pointer >= values.size())
            throw new RuntimeException("Attempting to read out of bounds: " + pointer);

        return values.get(pointer);
    }

    public void write(final Value value) {
        if (value == Value.SKIP_WRITE)
            return;

        values.set(pointer, value);
    }

    public void move(Direction direction) {
        if (direction == Direction.LEFT) {
            moveLeft();
        } else if (direction == Direction.RIGHT) {
            moveRight();
        }
    }

    private void moveLeft() {
        if (pointer == 0) {
            values.add(0, Value.BLANK);
        } else {
            pointer--;
        }
    }

    private void moveRight() {
        if (pointer == values.size()-1) {
            values.add(values.size(), Value.BLANK);
        } else {
            pointer++;
        }
    }

    public enum Direction {
        LEFT,
        RIGHT
    }

    @Override
    public String toString() {
        return values.toString();
    }

}
