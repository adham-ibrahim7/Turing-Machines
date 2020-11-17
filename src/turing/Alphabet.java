package turing;

/*
 * Created by Adham Ibrahim on 11/16/2020
 */

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    private List<String> elements;

    public Alphabet(String... elementsArray) {
        this.elements = new ArrayList<>();

        for (String element : elementsArray) {
            this.elements.add(element);
        }

        //every alphabet needs a blank
        this.elements.add(" ");
    }

    public Symbol get(String valueString) {
        return null;
    }

}
