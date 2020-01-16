package com.classes;

import com.base.BaseJob;
import com.enums.JobState;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JobThread implements  Runnable {
    private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

       BaseJob baseJob;
       RunJob  runJob;

     public synchronized  void outFileJob(BaseJob baseJob,String error) {
         JobDescriptionOutput jobDescriptionOutput = new JobDescriptionOutput();
         jobDescriptionOutput.setName(baseJob.getJobName());
         jobDescriptionOutput.setState(baseJob.getJobState().toString());
         jobDescriptionOutput.setRunTime(new Date());
         jobDescriptionOutput.setError(error);
         runJob.writeOutJob(jobDescriptionOutput);
     }

    @Override
    public void run() {
        try {
            if (baseJob.getScheduledDate()!=null) {
                Boolean isDone = false ;
                while(isDone==false) {
                    String strSchJobDate = dateFormat.format(baseJob.getScheduledDate());
                    String strDate =  dateFormat.format(new Date());
                    if (strSchJobDate.equals(strDate)) {
                        baseJob.runJob();
                        baseJob.setJobState(JobState.SUCCESS);
                        isDone = true;
                    }
                }

            } else {
                baseJob.runJob();
                baseJob.setJobState(JobState.SUCCESS);
            }
            outFileJob(baseJob,"");
        }
        catch (Exception  e){
            baseJob.setJobState(JobState.FAILED);
            outFileJob(baseJob,e.getMessage());
        }


    }



    public JobThread(BaseJob baseJob) {
        this.baseJob = baseJob;
        this.runJob = new RunJob();

    }

    public BaseJob getBaseJob() {
        return baseJob;
    }

    public void setBaseJob(BaseJob baseJob) {
        this.baseJob = baseJob;
    }
}
