Task XXX is a java based project which aims to schedule and run specific tasks implemented by java. 
First of all, application reads following XML file(should be either resource file or a file specified via command line) in order to obtain list of the tasks and 
relevant configurations such as priority, name, interval...
 
<?xml version="1.0" encoding="utf-8" ?>
<JOBS>
    <JOB>
        <name>JDWH1</name>
        <jobType>DWH</jobType>
	<! Job is immediatelly executed if scheduleDate is empty>
        <scheduleDate>16-01-2020 13:35</scheduleDate>
        <interVal>0</interVal>
        <priority>LOW</priority>
        <runStatement>exec pck.der</runStatement>
        <sqlText>select * from class</sqlText>
    </JOB>
    <JOB>
        <name>EMAIL1</name>
        <jobType>EMAIL</jobType>
        <scheduleDate>16-01-2020 13:35</scheduleDate>
        <interVal>0</interVal>
        <priority>LOW</priority>
        <runStatement>exec pck.der</runStatement>
        <emailStrs>hkarabas@gmail.com</emailStrs>
        <bodyStrs>Hello Test Email</bodyStrs>
        <subjectStrs>Test</subjectStrs>
    </JOB>
</JOBS>

How to run
--------------------------------------------------------
c:\  mvn clean package
c:\ java -jar .......-all-dep jobs.xml

or 
via intelliJ ide run main.java


 

IMPORTANT:
 <scheduleDate></scheduleDate> if scheduleDate not null when run on scheduleDate value
else  scheduleDate  is null when immediately run 

result outputs are each  by jobname create xml files
example :
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<JOB>
    <name>EMAIL1</name>
    <runTime>2020-01-16T13:35:00.003+03:00</runTime>
    <state>SUCCESS</state>
    <error></error>
</JOB>



