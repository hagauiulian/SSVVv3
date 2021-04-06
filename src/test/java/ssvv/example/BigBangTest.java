package ssvv.example;

import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import org.junit.Before;
import org.junit.Test;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;

import java.io.IOException;

import Repository.XMLFileRepository.StudentXMLRepo;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BigBangTest {

    private StudentXMLRepo studentRepo;
    private NotaXMLRepo notaRepo;
    private TemaLabXMLRepo temaRepo;
    private StudentXMLService stsrv;
    private TemaLabXMLService tmsrv;
    private NotaXMLService ntsrv;


    @Before
    public void setup() {
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        stsrv=new StudentXMLService(strepo);
        tmsrv=new TemaLabXMLService(tmrepo);
        ntsrv=new NotaXMLService(ntrepo);
    }

    @Test
    public void test_addStudent(){
        String[] params = {"1", "Name", "100", "email@domain.com", "Prof Univ"};
        try {
            stsrv.add(params);
            assertTrue(true);
        }
        catch (ValidatorException ex) {
            fail();
        }
    }

    @Test
    public void test_addAssignment(){
//        Nota n=new Nota(Integer.parseInt(params[0]),params[1],Integer.parseInt(params[2]),Double.parseDouble(params[3]), LocalDateTime.parse(params[4]));
        String[] params = {"1", "1", "1", "10", "(2007-12-03T10:15:30)"};
        try {
            tmsrv.add(params);
            assertTrue(true);
        }
        catch (ValidatorException ex) {
            fail();
        }
    }

    @Test
    public void test_addGrade(){
        String idt = "1";
        String val = "10.0";
        String[] params={"1","1",idt,val,"2007-12-03T10:15:30"};
        try{
            ntsrv.add(params);
//            ntsrv.printAllNotes(tmsrv);
        }catch (ValidatorException ex){
            fail();
        }

    }

    @Test
    public void test_integration(){
        String[] params = {"1", "Name", "100", "email@domain.com", "Prof Univ"};
        try {
            stsrv.add(params);
            assertTrue(true);
        }
        catch (ValidatorException ex) {
            fail();
        }
        String[] params2 = {"1", "1", "1", "10", "(2007-12-03T10:15:30)"};
        try {
            tmsrv.add(params2);
            assertTrue(true);
        }
        catch (ValidatorException ex) {
            fail();
        }
        String idt = "1";
        String val = "10";
        String[] params3={"1","1",idt,val,"2007-12-03T10:15:30"};
        try{
            ntsrv.add(params3);
//            ntsrv.printAllNotes(tmsrv);
        }catch (ValidatorException ex){
            fail();
        }
    }

}