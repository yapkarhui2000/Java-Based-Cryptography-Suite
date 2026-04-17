# Java-Based-Cryptography-Suite

A modular Java application that implements classical encryption and decryption algorithms. This project demonstrates the practical application of Object-Oriented Programming (OOP) principles, including inheritance, abstraction, and the use of efficient data structures for character mapping.

🚀Key Features
Caesar Cipher: Implements a shift-based substitution cipher with support for both uppercase and lowercase character rotation.

Mono-alphabetic Substitution: Utilizes a translation table approach for character-to-character mapping.

Vigenere Cipher: A polyalphabetic substitution cipher that uses a keyword to apply a sequence of different Caesar shifts.Command Line 

Interface: All ciphers include a main method, allowing for direct interaction via terminal arguments for encryption and decryption.

🛠Technical Architecture

This project was architected to follow clean coding standards and Java best practices:Interface-Driven Design: Developed a core Cipher interface that defines the contract for any encryption/decryption logic.Abstract Classes: Utilized an abstract Substitution class to handle the boilerplate logic of iterating through strings, while delegating specific character-level encryption to subclasses.Advanced OOP (Polymorphism): The Vigenere cipher demonstrates advanced object composition by managing an array of Caesar objects to perform shifting logic based on a keyword.Efficient Data Structures: Employed HashMap within the MonoAlphaSubstitution class to store encryption and decryption tables, ensuring $O(1)$ time complexity for character lookups.

💻 Usage

To run the ciphers from the command line, compile the files and use the following syntax:

Caesar Cipher

Usage: java Caesar [encrypt/decrypt] [shift_value] "[text]"
java Caesar encrypt 3 "Hello World"

Vigenere Cipher
Usage: java Vigenere [encrypt/decrypt] [keyword] "[text]"
java Vigenere encrypt SECRET "Hello World"

