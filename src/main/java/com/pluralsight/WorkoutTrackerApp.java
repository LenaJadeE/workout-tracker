package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkoutTrackerApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int QuickWorkoutMinutes = 30;
    private static final String RowFormat = "%-24s  %-12s  %7s  %-8s%n";
    private static final List<Workouts> workouts = new ArrayList<>();

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
            System.out.print("Enter a command: ");
            command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "N" -> addWorkout();
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
            System.out.print("Enter a command: ");
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
            System.out.print("Enter a command: ");
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

    private static void addWorkout() {
        String name = promptForString("Name: ");
        String type = promptForString("Type (like cardio or strength): ");
        int minutes = promptForInt("Length in minutes: ");
        while (minutes <= 0) {
            System.out.println("The length must be more than 0 minutes.");
            minutes = promptForInt("Length in minutes: ");
        }

        boolean favorite = promptForFavorite();

        workouts.add(new Workouts(name, type, minutes, favorite));

        System.out.println("Added " + name + " (" + minutes + " minutes)");
        pressEnterToContinue();
    }

    private static void displayAllWorkouts() {
        displayWorkouts("All Workouts", workouts);
        pressEnterToContinue();
    }

    private static void displayQuickWorkouts() {
        List<Workouts> matches = new ArrayList<>();
        for (Workouts workout : workouts) {
            if (workout.getMinutes() <= QuickWorkoutMinutes) {
                matches.add(workout);
            }
        }
        displayWorkouts("Quick Workouts (" + QuickWorkoutMinutes + " minutes or less)", matches);
        pressEnterToContinue();
    }

    private static void displayFavoriteWorkouts() {
        List<Workouts> matches = new ArrayList<>();
        for (Workouts workout : workouts) {
            if (workout.isFavorite()) {
                matches.add(workout);
            }
        }
        displayWorkouts("Favorites", matches);
        pressEnterToContinue();
    }

    private static void searchByName() {
        String name = promptForString("Name to search for: ");
        List<Workouts> matches = new ArrayList<>();
        for (Workouts workout : workouts) {

            if (workout.getName().toLowerCase().contains(name.toLowerCase())) {
                matches.add(workout);
            }
        }

        displayWorkouts("Name: " + name, matches);
        pressEnterToContinue();
    }

    private static void searchByType() {
        String type = promptForString("Type to search for (like cardio or strength): ");

        List<Workouts> matches = new ArrayList<>();
        for (Workouts workout : workouts) {
            if (workout.getType().equalsIgnoreCase(type)) {
                matches.add(workout);
            }
        }

        displayWorkouts("Type: " + type, matches);
        pressEnterToContinue();
    }

    private static void searchByLength() {
        int minutes = promptForInt("The most minutes you have: ");
        while (minutes <= 0) {
            System.out.println("The minutes must be more than 0.");
            minutes = promptForInt("The most minutes you have: ");
        }

        List<Workouts> matches = new ArrayList<>();
        for (Workouts workout : workouts) {
            if (workout.getMinutes() <= minutes) {
                matches.add(workout);
            }
        }

        displayWorkouts(minutes + " minutes or less", matches);
        pressEnterToContinue();
    }

    private static void displayWorkouts(String title, List<Workouts> entries) {
        System.out.println("=== " + title + " ===");

        if (entries.isEmpty()) {
            System.out.println("No workouts found.");
            return;
        }
        System.out.printf(RowFormat, "Name", "Type", "Minutes", "Favorite");
        for (Workouts workout : entries) {
            System.out.printf(RowFormat, workout.getName(), workout.getType(), workout.getMinutes(),
                    workout.isFavorite() ? "Yes" : "No");
        }

        System.out.println();
        System.out.println(entries.size() + (entries.size() == 1 ? " workout" : " workouts"));
    }

    private static void pressEnterToContinue() {
        System.out.println();
        System.out.print("Press Enter to go back to the menu...");
        scanner.nextLine();
    }

    private static int promptForInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number, like 12.");
            }
        }
    }

    private static String promptForString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("This can't be blank.");
            } else if (input.contains("|")) {
                System.out.println("Please don't use the | character.");
            } else {
                return input;
            }
        }
    }

    private static boolean promptForFavorite() {
        while (true) {
            System.out.print("Is it a favorite? (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            }
            System.out.println("Please type Y or N.");
        }
    }

}
