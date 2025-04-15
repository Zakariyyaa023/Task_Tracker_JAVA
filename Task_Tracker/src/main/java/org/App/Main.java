package org.App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        The Scanner is used through out the program to get user input.
        Scanner Input = new Scanner(System.in);
        new Menu(Input);
        Input.close();
    }
}