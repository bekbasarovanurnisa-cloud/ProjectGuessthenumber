
    package org.example;

import java.util.Random;

    public class Guess {

        private static int bestScore = -1;
        private final int MAX_NUMBER = 100;

        private final Input input;
        private final int ATTEMPTS_LIMIT = 10;

        public Guess(Input handler) {
            this.input = handler;
        }

        public void start() {
            boolean isPlaying = true;

            while (isPlaying) {
                playRound();
                showScores();
                isPlaying = input.askToPlayAgain();
            }
        }

        private void showScores() {
            System.out.println();
            if (bestScore != -1) {
                System.out.println("the best result: " + bestScore + " tries!");
            } else {
                System.out.println("The highscore table is empty. Play to set a highscore.");
            }
            System.out.println();
        }

        private void playRound() {
            Random random = new Random();

            int secretNumber = random.nextInt(MAX_NUMBER) + 1;
            int guess = 0;
            int attempts = 0;
            System.out.println();
            System.out.println("I'm thinking of a number between 1 and " + MAX_NUMBER + " Guess it!");


            while (guess != secretNumber) {
                if (attempts >= ATTEMPTS_LIMIT) {
                    System.out.println();
                    System.out.println("you have loosed.Running out of attempts(" + ATTEMPTS_LIMIT + ").");
                    System.out.println("The number hidden was:" + secretNumber);
                    System.out.println();
                    return;
                }
                attempts++;
                System.out.print("Attempt #" + attempts + " Enter a number.: ");
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
            System.out.println("🎉 VICTORY! The hidden number:" + secretNumber);
            System.out.println("You guessed it in  " + attempts + " tries ");

            if (bestScore == -1 || attempts < bestScore) {
                bestScore = attempts;
                System.out.println(" NEW BEST RESULT SET!");
            }
        }
    }

