package com.jobclasses;

import com.base.BaseJob;
import com.classes.JobDescription;
import com.enums.JobState;
import com.enums.Priority;
import com.utils.ConsoleUtils;

public class DwhJob extends BaseJob {

    private String sqlText = "";

    public DwhJob(JobDescription jobDescription) {
        super();
        if (jobDescription.getScheduledDate() != null) {
            setScheduledDate(jobDescription.getScheduledDate());
        }
        if (jobDescription.getInterVal() != null) {
            setInterval(jobDescription.getInterVal());
        }
        if (!"".equals(jobDescription.getRunStatement()) && jobDescription.getRunStatement() != null) {
            setRunStatement(jobDescription.getRunStatement());
        }
        if (!"".equals(jobDescription.getSqlText()) && jobDescription.getSqlText() != null) {
            setSqlText(jobDescription.getSqlText());
        }
        if (!"".equals(jobDescription.getName()) && jobDescription.getName() != null) {
            setJobName(jobDescription.getName());
        }
        if (!"".equals(jobDescription.getPriority()) && jobDescription.getPriority() != null) {
            setPriority(Priority.fromString(jobDescription.getPriority()));
        }


    }


    @Override
    public void runJob() {
        this.setJobState(JobState.RUNNING);
        //System.out.println("Job Run Name is:"+getJobName());
        //BORA: String.format yada printf üzerinden gidersen daha etkili olur.
        ConsoleUtils.writeLine(String.format("Job Run Name is : %s", getJobName()));
        if (sqlText != "") {
            callSqlStatement();
        }
    }

    private void callSqlStatement() {
        //System.out.println("call a sqlStatement"+getSqlText());
        ConsoleUtils.writeLine(String.format("call a sqlStatement %s", getSqlText()));
    }

    public String getSqlText() {
        return sqlText;
    }


    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }
}
