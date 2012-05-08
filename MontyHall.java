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
        System.out.println("By running a simulation of the Monty Hall problem");
        System.out.print("we can see that ");

        int switchSuccess = probSwitchSuccess();
        int notSwitchSuccess = probNotSwitchSuccess();
        if (switchSuccess > notSwitchSuccess) {
            System.out.println("SWITCHING is the better strategy.");
            System.out.print("The player who always switches wins about ");
            System.out.print(((double) switchSuccess) / 10);
            System.out.print("% of the time, \nwhile the player who never ");
            System.out.print("switches wins only about ");
            System.out.print(((double) notSwitchSuccess) / 10);
            System.out.print("% of the time.");
        } else if (switchSuccess < notSwitchSuccess) {
            System.out.println("NOT SWITCHING is the better strategy.");
            System.out.print("The player who never switches wins about ");
            System.out.print(((double) notSwitchSuccess) / 10);
            System.out.print("% of the time, \nwhile the player who always ");
            System.out.print("switches wins only about ");
            System.out.print(((double) switchSuccess) / 10);
            System.out.print("% of the time.");
        } else {
            System.out.println("both strategies are equally good.");
            System.out.print("The player who always switches wins about ");
            System.out.print(((double) switchSuccess) / 10);
            System.out.print("% of the time, while the player who never ");
            System.out.print("switches also wins about ");
            System.out.print(((double) notSwitchSuccess) / 10);
            System.out.print("% of the time.");
        }
        System.out.println();
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

            // The player switches to the other closed Door.
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

        // Run the experiment 1000 times.
        int success = 0;
        int failure = 0;

        for (int i = 0; i < 1000; i++) {

            int sportscar;
            sportscar = (int) (Math.random() * 3);
            int player = 0;
            int goat;
            if (sportscar == 1)
                goat = 2;
            else
                goat = 1;

            // The player does not switch.

            if (player == sportscar)
                success++;
            else
                failure++;
        }

        assert(success + failure == 1000);

        return success;
    }
}
