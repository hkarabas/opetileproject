package com.classes;


import com.utils.ConsoleUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class RunJob {

    public static List<JobDescription> getJobDescriptionList(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(JobDescripeList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();


        JobDescripeList jobDescripeList = (JobDescripeList) jaxbUnmarshaller.unmarshal(file);
        return jobDescripeList.getJobDescriptionList();
    }

    public void writeOutJob(JobDescriptionOutput jobDescriptionOutput) {
        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(JobDescriptionOutput.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File(jobDescriptionOutput.getName() + ".xml");

            //Writes XML file to file-system
            jaxbMarshaller.marshal(jobDescriptionOutput, file);
        } catch (JAXBException e) {
            ConsoleUtils.writeException(e);
        }
    }


}
