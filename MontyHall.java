/*
 * MontyHall.java
 *
 * Version 0.1
 *
 * 2012/05/08
 *
 * Copyright (c) 2012 Matt Heard.
 */

/**
 *
 * Prints a comparison of the probabilities of success between switching and not
 *   switching in the Monty Hall Problem.
 *
 * @version 0.1 2012/05/08
 * @author  Matt Heard
 */

public class MontyHall {
    public static void main(String[] args) {
        // Calculate the probability of success when switching.
        probSwitchSuccess();

        // Calculate the probability of success when not switching.
        probNotSwitchSuccess();

        // Compare the two probabilities.
        compareProb(0, 0);

        // Identify the more successful strategy.
        betterStrategy(0, 0, 0);
    }

    // Calculate the probability of success when switching.
    // @return int Probability of success permille.
    public static int probSwitchSuccess() {

        // Run the experiment 1000 times.
        int success = 0;
        int failure = 0;

        for (int i = 0; i < 1000; i++) {

            // There are three doors.
            // Two doors have a goat behind them, while one door has a
            //   sportscar.
            // The door with a sportscar behind it is randomly chosen.
            int sportscar;
            sportscar = (int) (Math.random() * 3);

            // The player picks a door randomly. (The player picks door 1.)
            int player = 0;

            // There are two doors which haven't been picked. At least one of
            //   these doors has a goat behind it. The host opens an unpicked
            //   door with a goat behind it. The player is offered the choice to
            //   switch her choice to the other closed door. (It doesn't make
            //   sense to switch to the opened door with a goat behind it.)

            int goat;
            if (sportscar == 1)
                goat = 2;
            else
                goat = 1; 

            // The olayer switches to the other closed Door.
            if (goat == 1)
                player = 2;
            else
                player = 1;

            // The doors are all opened to reveal the player's prize.
            // If the player won the sportscar, increment the success tally.
            if (player == sportscar)
                success++;

            // If the player won the goat, increment the failure tally.
            else
                failure++;
        }

        // Check that the successes and failures total to 1000.
        assert(success + failure == 1000);

        // Return the number of successes.
        return success;
    }

    // Calculate the probability of success when not switching.
    // @return int Probability of success permille.
    public static int probNotSwitchSuccess() {
        return 0;
    }

    // Compare two probabilities.
    // @param int First probability permille.
    // @param int Second probability permille.
    // @return int 0 if the first probability is greater, 1 if the second
    public static int compareProb(int firstProb, int secondProb) {
        return 0;
    }

    // Identify the more successful strategy.
    // @param int Strategy with higher probability.
    // @param int First Probability permille.
    // @param int Second Probability permille.
    public static void betterStrategy (int betterStrategy, int firstProb,
            int secondProb) {
    }
}
