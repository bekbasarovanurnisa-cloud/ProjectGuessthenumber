package org.example;

import java.util.Scanner;

    public class Input {

        private final Scanner scanner;

        public Input(Scanner sc) {

            this.scanner = sc;
        }

        public int getValidInt() {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
                return number;
            } else {

                String badInput = scanner.nextLine();
                System.out.println(" Error!"+ badInput+"  is not a number. Try again.");
                return -1;
            }
        }


        public boolean askToPlayAgain() {
            String answer;
            while (true) {
                System.out.println();
                System.out.print("Do you want to play again? (y/n): ");
                answer = scanner.nextLine().trim().toLowerCase();

                if (answer.equals("y")) {
                    return true;
                } else if (answer.equals("n")) {
                    return false;
                } else {
                    System.out.println("Please enter 'y' (yes) or 'n' (no).");
                }
            }
        }
    }

