package com.enums;

public enum JobState {
    QUEUED("queued"),
    RUNNING("running"),
    SUCCESS("success"),
    FAILED("failed");

    String jobState;

    JobState(String jobState) {
        this.jobState = jobState;
    }

    public static JobState fromString(String text) {
        for (JobState b : JobState.values()) {
            if (b.jobState.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
