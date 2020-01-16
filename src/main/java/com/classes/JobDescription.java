package com.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "JOB")
@XmlAccessorType(XmlAccessType.FIELD)
public class JobDescription {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "jobType")
    private String jobType; // email , dwh

    @XmlElement(name = "scheduledDate")
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    private Date scheduledDate;

    @XmlElement(name = "interVal")
    private Long interVal;

    @XmlElement(name = "priority")
    private String priority;

    @XmlElement(name = "runStatement")
    private String runStatement;

    @XmlElement(name = "sqlText")
    private String sqlText;

    @XmlElement(name = "emailStrs")
    private String emailStrs;

    @XmlElement(name = "bodyStrs")
    private String bodyStrs;

    @XmlElement(name = "subjectStrs")
    private String subjectStrs;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Long getInterVal() {
        return interVal;
    }

    public void setInterVal(Long interVal) {
        this.interVal = interVal;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRunStatement() {
        return runStatement;
    }

    public void setRunStatement(String runStatement) {
        this.runStatement = runStatement;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
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
