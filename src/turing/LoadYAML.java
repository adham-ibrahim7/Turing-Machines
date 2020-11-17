package turing;

/*
 * Created by Adham Ibrahim on 11/6/2020
 */

import org.yaml.snakeyaml.Yaml;
import turing.Tape.Direction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadYAML {
    private static Yaml yaml = new Yaml();

    public static Program load(String filepath) throws FileNotFoundException {
        InputStream file = new FileInputStream(filepath);
        Map<String, Object> programMap = yaml.load(file);

        //TODO read in alphabet?
        List<String> alphabet = (List<String>) programMap.get("alphabet");

        List<String> initialTapeStrings = (List<String>) programMap.get("initial tape");

        String startStateName = (String) programMap.get("start state");
        List<String> finalStateNames = (List<String>) programMap.get("final states");

        Map<String, Object> stateObjects = (Map<String, Object>) programMap.get("states");

        Map<String, State> states = new HashMap<String, State>();

        for (String currentStateName : stateObjects.keySet()) {
            if (states.containsKey(currentStateName)) {
                //TODO rename these exceptions?
                throw new IllegalArgumentException("Cannot have two states with the same name!");
            }

            states.put(currentStateName, new State(currentStateName));
        }

        for (String currentStateName : stateObjects.keySet()) {
            List<Map<String, String>> transitions = (List<Map<String, String>>) stateObjects.get(currentStateName);

            for (Map<String, String> transitionInfo : transitions) {
                if (!transitionInfo.containsKey("read")) {
                    if (transitionInfo.size() == 0) {
                        // TODO empty state transitions?
                        continue;
                    }

                    throw new IllegalArgumentException("State transition doesn't contain read value?");
                }

                String readSymbolString = transitionInfo.get("read");
                String writeSymbolString = transitionInfo.getOrDefault("write", "NULL");
                String transitionDirectionString = transitionInfo.getOrDefault("move tape", "NULL");
                String transitionStateName = transitionInfo.getOrDefault("go to", currentStateName);

                Transition transition = new Transition(Symbol.get(writeSymbolString), Direction.get(transitionDirectionString), states.get(transitionStateName));

                states.get(currentStateName).addTransition(Symbol.get(readSymbolString), transition);
            }
        }

        State startState = states.get(startStateName);

        List<State> finalStates = new ArrayList<>();
        for (String finalStateName : finalStateNames) {
            finalStates.add(states.get(finalStateName));
        }

        Tape tape = Tape.fromStrings(initialTapeStrings);

        return new Program(startState, finalStates, tape);

    }
}
