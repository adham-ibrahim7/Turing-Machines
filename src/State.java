/*
 * Created by Adham Ibrahim on 11/5/2020
 */

import java.util.HashMap;
import java.util.Map;

public class State {

    //TODO ensure unique names
    private final String name;
    final Map<Value, Transition> transitions;

    public State() {
        name = null;
        transitions = new HashMap<>();
    }

    public Transition getTransition(Value value) {
        return transitions.get(value);
    }

    public void addTransition(Value value, Transition transition) {
        transitions.put(value, transition);
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (! (o instanceof State)) {
            return false;
        }

        State s = (State) o;

        return this.name.equals(s.name);
    }*/

}
