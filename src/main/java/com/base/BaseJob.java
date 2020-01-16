package com.base;

import com.enums.JobState;
import com.enums.Priority;

import java.util.Date;

public abstract class BaseJob {

    private JobState jobState;
    private Priority priority;
    private Date scheduledDate;
    private String runStatement;
    private Long interval; // minutes
    private String jobName;


    public BaseJob() {
        this.jobState = JobState.QUEUED;
        this.priority = Priority.LOW;
        this.scheduledDate = null;
        this.runStatement = "";
        this.interval = Long.valueOf(0);
    }

    public abstract void runJob();

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public JobState getJobState() {
        return jobState;
    }

    public void setJobState(JobState jobState) {
        this.jobState = jobState;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getRunStatement() {
        return runStatement;
    }

    public void setRunStatement(String runStatement) {
        this.runStatement = runStatement;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

}
