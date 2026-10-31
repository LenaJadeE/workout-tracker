package com.pluralsight;

public class Workouts {
    private final String name;
    private final String type;
    private final int minutes;
    private final boolean favorite;

    public Workouts(String name, String type, int minutes, boolean favorite) {
        this.name = name;
        this.type = type;
        this.minutes = minutes;
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isFavorite() {
        return favorite;
    }
}
