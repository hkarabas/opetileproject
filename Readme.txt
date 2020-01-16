How  is work project.
first jobs.xml structer below.

<?xml version="1.0" encoding="utf-8" ?>
<JOBS>
    <JOB>
        <name>JDWH1</name>
        <jobType>DWH</jobType>
        <scheduledDate>16-01-2020 13:35</scheduledDate>
        <interVal>0</interVal>
        <priority>LOW</priority>
        <runStatement>exec pck.der</runStatement>
        <sqlText>select * from class</sqlText>
    </JOB>
    <JOB>
        <name>EMAIL1</name>
        <jobType>EMAIL</jobType>
        <scheduledDate>16-01-2020 13:35</scheduledDate>
        <interVal>0</interVal>
        <priority>LOW</priority>
        <runStatement>exec pck.der</runStatement>
        <emailStrs>hkarabas@gmail.com</emailStrs>
        <bodyStrs>Hello Test Email</bodyStrs>
        <subjectStrs>Test</subjectStrs>
    </JOB>
</JOBS>
 
IMPORTANT:
if <scheduledDate></scheduledDate> is not empty waiting  that scheduledDate value
else is empty  immediately run 
result outputs are each  by jobname create xml file: 
example :
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<JOB>
    <name>EMAIL1</name>
    <runTime>2020-01-16T13:35:00.003+03:00</runTime>
    <state>SUCCESS</state>
    <error></error>
</JOB>


there are two types run  
first via intelliJ ide run main.java
second  via console command Example : project\target\java -jar CaseStudy-1.0-SNAPSHOT.jar jobs.xml

