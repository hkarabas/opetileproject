package com.classes;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "JOBS")
@XmlAccessorType(XmlAccessType.FIELD)
public class JobDescripeList {

    @XmlElement(name = "JOB")
    List<JobDescription> jobDescriptionList = null;

    public List<JobDescription> getJobDescriptionList() {
        return jobDescriptionList;
    }

    public void setJobDescriptionList(List<JobDescription> jobDescriptionList) {
        this.jobDescriptionList = jobDescriptionList;
    }
}
