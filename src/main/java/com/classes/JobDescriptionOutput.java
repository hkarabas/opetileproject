package com.classes;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "JOB")
@XmlAccessorType(XmlAccessType.FIELD)
public class JobDescriptionOutput {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "runTime")
    private Date runTime;

    @XmlElement(name = "state")
    private String state;

    @XmlElement(name = "error")
    private String error;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRunTime() {
        return runTime;
    }

    public void setRunTime(Date runTime) {
        this.runTime = runTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
