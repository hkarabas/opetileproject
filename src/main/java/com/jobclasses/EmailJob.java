package com.jobclasses;

import com.base.BaseJob;
import com.classes.JobDescription;
import com.enums.JobState;
import com.enums.Priority;
import com.utils.ConsoleUtils;


public class EmailJob extends BaseJob {


    private String emailStrs = "";
    private String bodyStrs = "";
    private String subjectStrs = "";


    public EmailJob(JobDescription jobDescription) {
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
        if (!"".equals(jobDescription.getName()) && jobDescription.getName() != null) {
            setJobName(jobDescription.getName());
        }

        if (!"".equals(jobDescription.getEmailStrs()) && jobDescription.getEmailStrs() != null) {
            setEmailStrs(jobDescription.getEmailStrs());
        }

        if (!"".equals(jobDescription.getBodyStrs()) && jobDescription.getBodyStrs() != null) {
            setBodyStrs(jobDescription.getBodyStrs());
        }
        if (!"".equals(jobDescription.getSubjectStrs()) && jobDescription.getSubjectStrs() != null) {
            setSubjectStrs(jobDescription.getSubjectStrs());
        }
        if (!"".equals(jobDescription.getPriority()) && jobDescription.getPriority() != null) {
            setPriority(Priority.fromString(jobDescription.getPriority()));
        }


    }

    @Override
    public void runJob() {
        this.setJobState(JobState.RUNNING);

        if (emailStrs != "" && bodyStrs != "" && subjectStrs != "") {
            sendEmail();
        }
    }

    private void sendEmail() {
        String strs = "Sending email messages...:" + "\n+" + "--email adress:" + getEmailStrs() + "--Subject:"
                + "\n" + getSubjectStrs() + "\n" + "Body:" + "\n" + getBodyStrs();

        ConsoleUtils.writeLine(strs);
        //System.out.println(strs);

    }


    public String getEmailStrs() {
        return emailStrs;
    }

    public void setEmailStrs(String emailStrs) {
        this.emailStrs = emailStrs;
    }

    public String getBodyStrs() {
        return bodyStrs;
    }

    public void setBodyStrs(String bodyStrs) {
        this.bodyStrs = bodyStrs;
    }

    public String getSubjectStrs() {
        return subjectStrs;
    }

    public void setSubjectStrs(String subjectStrs) {
        this.subjectStrs = subjectStrs;
    }
}
