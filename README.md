# Turing-Machines
Simulating turing machine programs in java.

Reads in a program from a YAML file, runs it, and determines the 
final tapes configuration.

YAML format is as follows. See ./yaml-examples for example programs.

- set `alphabet` to be a list of strings, not including the blank
character
    - Ex: `alphabet = ['0', '1']`
- set `initial tape` to be a list of strings all contained in the alphabet, 
or the blank character
    - Ex: `initial tape = ['1', '0', '1', ' ', '1', '0']`
- set `start state` to a single string that is contained in the states mapping,
and `final states` to a list of strings contained in the states mapping
    - Ex: `start state = q0`, `final states = [q1, q2, q3]`
- set `states` to a mapping from a string to a list of transitions
    - Ex: `states = [q0: {...}, q1: {...}, q2: {...}`
- for each transition, the `read` field is required, while the `write`, `move tape`, and
`go to` fields are not
    - if `write` is omitted, the tape will not be written to
    - if `move tape` is omitted, the tape will not move
    - if `go to` is omitted, the execution will stay in the current state