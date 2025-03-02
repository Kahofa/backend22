package org.example;


public class Task {
    private final String title;
    private final boolean isUrgent;

    public Task(String title, boolean isUrgent) {
        this.title = title;
        this.isUrgent = isUrgent;
    }

    public String getTitle() {
        return title;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    @Override
    public String toString() {
        return (isUrgent ? "Срочная" : "Обычная") + " задача: " + title;
    }
}
