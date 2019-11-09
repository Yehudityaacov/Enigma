# Enigma
A Packet Sniffer Attack Solution Imitation

In this assignment, we will implement an exact emulator of German Army Enigma M3 machine. In the next assignment,
we will implement this machine’s cryptanalysis, discover the
hidden machine settings used in Numberphile series, and break a real message. For that task
to be achievable, however, the emulation must be perfect.

Functionality
Functionally, Enigma works as follows: each letter is transformed through the plugboard,
right rotor, middle rotor, left rotor, reflector, left rotor (reverse direction), middle rotor (reverse direction),
right rotor (reverse direction), and plugboard again. When a key is pressed,
the rotors rotate before the translation.
An Enigma configuration is defined by the 3 selected rotors (out of 5), their initial offsets (visible in the small windows),
their internal setting (functionally similar to the offset), and plugboard configuration.
Each rotor defines a forward (right to left) and a reverse (left to right) permutation. In addition, 
each rotor has a turnover notch, that influences the rotor to its left during rotation —
similar to an analog clock, but not exactly (more on that later).
