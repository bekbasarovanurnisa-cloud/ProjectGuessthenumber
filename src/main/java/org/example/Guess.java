
    package org.example;

import java.util.Random;

    public class Guess {


        private final int MAX_NUMBER = 100;

        private final Input input;

        public Guess(Input handler) {
            this.input = handler;
        }

        public void start() {
            boolean isPlaying = true;

            while (isPlaying) {
                playRound();
                isPlaying = input.askToPlayAgain();
            }
        }

        private void playRound() {
            Random random = new Random();


            int secretNumber = random.nextInt(MAX_NUMBER) + 1;
            int guess = 0;
            int attempts = 0;
            System.out.println("I'm thinking of a number between 1 and "+MAX_NUMBER+" Guess it!");


            while (guess != secretNumber) {
                attempts++;
                System.out.print("Attempt #"+attempts+ " Enter a number.: ");
                guess = input.getValidInt();

                if (guess == -1) {
                    attempts--;
                    continue;
                }

                if (guess < secretNumber) {
                    System.out.println("too little.");
                } else if (guess > secretNumber) {
                    System.out.println("⬅️too big.");
                }
            }
            System.out.println();
            System.out.println("🎉 VICTORY! The hidden number:"+ secretNumber);
            System.out.println("You guessed it in  " + attempts+ " tries ");
        }
    }

