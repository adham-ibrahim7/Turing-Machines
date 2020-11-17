package turing;

/*
 * Created by Adham Ibrahim on 11/5/2020
 */

import java.util.HashMap;
import java.util.Map;

public class State {

    //TODO ensure unique names
    private final String name;

    final Map<Symbol, Transition> transitions;

    public State(String name) {
        this.name = name;
        transitions = new HashMap<>();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof State)) {
            return false;
        }

        State s = (State) o;

        return this.name.equals(s.name);
    }

    public String getName() {
        return this.name;
    }

    public Transition getTransition(Symbol symbol) {
        return transitions.get(symbol);
    }

    public void addTransition(Symbol symbol, Transition transition) {
        transitions.put(symbol, transition);
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (! (o instanceof turing.State)) {
            return false;
        }

        turing.State s = (turing.State) o;

        return this.name.equals(s.name);
    }*/

}
