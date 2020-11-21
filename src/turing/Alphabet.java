package turing;

/*
 * Created by Adham Ibrahim on 11/20/2020
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Alphabet {

    private Set<String> symbols;

    public Alphabet(final List<String> symbolList) {
        this.symbols = new HashSet<>();
        this.symbols.addAll(symbolList);
        this.symbols.add(" ");
    }

    public boolean isSymbol(String symbol) {
        return symbols.contains(symbol);
    }

}
