package turing;

/*
 * Created by Adham Ibrahim on 11/6/2020
 */

import java.io.FileNotFoundException;

public class Turing {
    public static void main(String[] args) throws FileNotFoundException {
        Program program = LoadYAML.load(args[0]);
        program.execute();
        System.out.println("Tape contents on termination: " + program.getTapeContents());
        System.out.println("Current state on termination: " + program.getCurrentState().getName());
    }
}
