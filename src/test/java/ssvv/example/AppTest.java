package ssvv.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private StudentXMLRepo repo;
    private StudentXMLService service;
    @Test
    public void tc_1_AddStudentsValid(){
        repo =new StudentXMLRepo(vs,"StudentiXML.xml");
        service=new StudentXMLService(repo);
        try{
            service.add(["1", "Name", "100", "email@domain.com", "Prof Univ"]);
            assertTrue();
        }
        catch(ValidatorException ex){
            assertFalse();
        }
    }
    @Test
    public void tc_2_InvalidGroup(){
        repo =new StudentXMLRepo(vs,"StudentiXML.xml");
        service=new StudentXMLService(repo);
        try{
            service.add(["1", "Name", "abc", "email@domain.com", "Prof Univ"]);
            assertFalse();
        }
        catch(ValidatorException ex){
            assertTrue();
        }
    }


}
