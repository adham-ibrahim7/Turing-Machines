package turing;/*
 * Created by Adham Ibrahim on 11/6/2020
 */

import java.io.FileNotFoundException;

public class TuringMachine {
    public static void main(String[] args) throws FileNotFoundException {
        Program program = LoadYAML.load("yaml-examples/add_one.yaml");
        program.execute();
        System.out.println(program.result());
    }
}
