package turing;

/*
 * Created by Adham Ibrahim on 11/5/2020
 */

//TODO add support for any language not just {0, 1}
public enum Symbol {

    ZERO("0"),
    ONE("1"),
    NULL("NULL"),
    BLANK("_");

    private String stringRepresentation;

    Symbol(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }

    public static Symbol get(String symbolString) {
        for (final Symbol currentSymbol : Symbol.values()) {
            if (currentSymbol.toString().equals(symbolString)) {
                return currentSymbol;
            }
        }

        throw new IllegalArgumentException("No such symbol exists among the current alphabet: " + symbolString);
    }

}
