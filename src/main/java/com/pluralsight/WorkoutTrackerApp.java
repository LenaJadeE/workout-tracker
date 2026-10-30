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
            System.out.println();
            System.out.println(" Search ");
            System.out.println("1) By Name");
            System.out.println("2) By Type");
            System.out.println("3) By Length");
            System.out.println("0) Back");
            System.out.println("Enter a command:");
            command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "1" -> searchByName();
                case "2" -> searchByType();
                case "3" -> searchByLength();
                case "0" -> System.out.println("Back to Workouts");
                default -> System.out.println("That isn't a command. Try again.");
            }
        } while (!command.equals("0"));
    }

    private static void addWorkouts() {
        String name = promptForString("Name: ");
        int minutes = promptForInt("Length in minutes: ");
        while (minutes <= 0) {
            System.out.println("The length must be more than 0 minutes.");
            minutes = promptForInt("Length in minutes: ");

        }

        System.out.println("Added " + name + " (" + minutes + " minutes)");
        pressEnterToContinue();
    }

    private static void displayAllWorkouts() {
        System.out.println("TODO: display all workouts");
        pressEnterToContinue();
    }

    private static void displayQuickWorkouts() {
        System.out.println("TODO: display quick workouts (30 minutes or less)");
        pressEnterToContinue();
    }

    private static void displayFavoriteWorkouts() {
        System.out.println("TODO: display favorite workouts");
        pressEnterToContinue();
    }

    private static void searchByName() {
        String name = promptForString("Name to search for: ");
        System.out.println("TODO: display the workouts whose name matches " + name);
        pressEnterToContinue();
    }

    private  static void searchByType() {

    }

    private static void pressEnterToContinue() {
        System.out.println();
        System.out.print("Press Enter to go back to the menu...");
        scanner.nextLine();
    }

    private static String promptForString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("This can't be blank.");
            } else if (input.contains("|")) {
                System.out.println("Please don't use the | character.");
            } else  {
                return input;
            }
        }
    }
}
