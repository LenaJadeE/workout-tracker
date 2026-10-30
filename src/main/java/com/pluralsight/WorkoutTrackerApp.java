package com.pluralsight;

import java.util.Scanner;

public class WorkoutTrackerApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Workout Tracker App!");
        runHomeScreen();
    }

    private static void runHomeScreen() {
        String command;
        do {
            System.out.println();
            System.out.println(" Home ");
            System.out.println("N) New Workout");
            System.out.println("W) Workouts");
            System.out.println("X) Exit");
            System.out.println("Enter command: ");
            command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "N" -> addWorkouts();
                case "W" -> runWorkoutsScreen();
                case "X" -> System.out.println("Goodbye!");
                default -> System.out.println("That isn't a command. Try again.");
            }
        } while (!command.equals("X"));
    }

    private static void runWorkoutsScreen() {
        String command;
        do {
            System.out.println();
            System.out.println(" Workouts ");
            System.out.println("A) All Workouts");
            System.out.println("Q) Quick Workouts");
            System.out.println("F) Favorites");
            System.out.println("S) Search");
            System.out.println("H) Home");
            System.out.println("Enter a command: ");
            command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "A" -> displayAllWorkouts();
                case "Q" -> displayQuickWorkouts();
                case "F" -> displayFavoriteWorkouts();
                case "S" -> runSearchScreen();
                case "H" -> System.out.println("Back to Home");
                default -> System.out.println("That isn't a command. Try again.");
            }
        } while (!command.equals("H"));
    }

    private static void runSearchScreen() {
        String command;
        do {

        }
    }
}
