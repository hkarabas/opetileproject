package com.main;

import com.classes.JobDescription;
import com.classes.JobExecutorThread;
import com.classes.RunJob;
import com.enums.Priority;
import com.jobclasses.DwhJob;
import com.jobclasses.EmailJob;
import com.utils.ConsoleUtils;
import com.utils.ResourceUtils;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main {
    ClassLoader classLoadertest = null;
    File filetest = null;

    public Main(String xmlFileName) {
        ClassLoader classLoadertest = this.getClass().getClassLoader();
        filetest = new File(classLoadertest.getResource(xmlFileName).getFile());
    }

    public Main() {

    }

    public static void main(String[] args) {
            File file = null;
            if (args.length>0) {
                 String filename = args[0];
                  try {
                      System.out.println(filename);
                      file = new File(filename);
                  } catch (Exception e) {
                      e.printStackTrace();
                      return;
                  }
            }
            else {
                try {
                    String fileName = "jobs.xml";
                    file = ResourceUtils.getResourceFile(fileName);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return;
                }
            }
            try {
            List<JobDescription> jobDescriptionList = RunJob.getJobDescriptionList(file);
            if (!jobDescriptionList.isEmpty()) {
                ExecutorService executorService = Executors.newFixedThreadPool(jobDescriptionList.size());
                for (Priority priority : Priority.values()) {
                    // System.out.println(priority.toString() );
                    List<JobDescription> jobDescriptionListFilter = jobDescriptionList.stream().filter(k -> k.getPriority().equals(priority.toString())).collect(Collectors.toList());
                    // filter order by priority

                    for (JobDescription jobDescription : jobDescriptionListFilter) {

                        if (jobDescription.getJobType().equals("DWH")) {
                            DwhJob jobDwh = new DwhJob(jobDescription);
                            JobExecutorThread jobExecutorThread = new JobExecutorThread(jobDwh);
                            executorService.submit(jobExecutorThread);

                        } else if (jobDescription.getJobType().equals("EMAIL")) {
                            EmailJob jobEmail = new EmailJob(jobDescription);
                            JobExecutorThread jobExecutorThread = new JobExecutorThread(jobEmail);
                            executorService.submit(jobExecutorThread);

                        }
                    }


                }
                executorService.shutdown();

            }
        } catch (JAXBException e) {
            ConsoleUtils.writeException(e);
            //e.printStackTrace();
        }

    }

    public void TestMain() {

        try {
            List<JobDescription> jobDescriptionList = RunJob.getJobDescriptionList(filetest);
            if ( !jobDescriptionList.isEmpty()) {
                ExecutorService executorService = Executors.newFixedThreadPool(jobDescriptionList.size());
                for (Priority priority : Priority.values()) {
                    // System.out.println(priority.toString() );
                    List<JobDescription> jobDescriptionListFilter = jobDescriptionList.stream().filter(k -> k.getPriority().equals(priority.toString())).collect(Collectors.toList());
                    // filter order by priority

                    for (JobDescription jobDescription : jobDescriptionListFilter) {

                        if (jobDescription.getJobType().equals("DWH")) {
                            DwhJob jobDwh = new DwhJob(jobDescription);
                            JobExecutorThread jobExecutorThread = new JobExecutorThread(jobDwh);
                            executorService.submit(jobExecutorThread);

                        } else if (jobDescription.getJobType().equals("EMAIL")) {
                            EmailJob jobEmail = new EmailJob(jobDescription);
                            JobExecutorThread jobExecutorThread = new JobExecutorThread(jobEmail);
                            executorService.submit(jobExecutorThread);

                        }
                    }


                }
                executorService.shutdown();

            }
        } catch (JAXBException e) {
            ConsoleUtils.writeException(e);
        }


    }
}
