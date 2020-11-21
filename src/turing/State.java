package turing;

/*
 * Created by Adham Ibrahim on 11/5/2020
 */

import java.util.HashMap;
import java.util.Map;

//TODO add StateBuilder
public class State {

    private final String name;

    final Map<String, Transition> transitions;

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

    public Transition getTransition(String symbol) {
        return transitions.get(symbol);
    }

    public void addTransition(String symbol, Transition transition) {
        transitions.put(symbol, transition);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name + ": [");
        for (String transitionSymbol : transitions.keySet()) {
            builder.append(transitionSymbol + "->" + transitions.get(transitionSymbol).toString() + ",");
        }
        builder.append("]");
        return new String(builder);
    }

}
