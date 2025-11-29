
package org.example;

import java.util.Scanner;

    public class Main {


        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            Input handler = new Input(sc);
            Guess game = new Guess(handler);

            System.out.println("Welcome to the game 'guess the number'!");
            game.start();

            sc.close();
            System.out.println("Thank you for the game!");
        }
    }



