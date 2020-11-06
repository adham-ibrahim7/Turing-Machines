/*
 * Created by Adham Ibrahim on 11/5/2020
 */

public enum Value {

    ZERO {
        @Override
        public String toString() {
            return "0";
        }
    },
    ONE {
        @Override
        public String toString() {
            return "1";
        }
    },
    BLANK {
        @Override
        public String toString() {
            return "_";
        }
    },
    //TODO add method isValid()
    SKIP_WRITE{};

    //TODO clean this up?
    public static Value fromString(String stringValue) {
        if (stringValue.equals(Value.ONE.toString())) {
            return Value.ONE;
        } else if (stringValue.equals(Value.ZERO.toString())) {
            return Value.ZERO;
        } else if (stringValue.equals(Value.BLANK.toString())) {
            return Value.BLANK;
        } else {
            throw new IllegalArgumentException("No corresponding valid value: " + stringValue);
        }
    }

}
