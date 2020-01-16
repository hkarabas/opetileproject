package com.enums;

public enum Priority {

    URGENT("URGENT"),
    HIGH("HIGH"),
    MEDIUM("MEDIUM"),
    LOW("LOW");


    String priority;

    Priority(String priority) {
        this.priority = priority;
    }


    public static Priority fromString(String text) {
        for (Priority b : Priority.values()) {
            if (b.priority.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }


}