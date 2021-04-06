package ssvv.example;

import Exceptions.ValidatorException;
import Repository.XMLFileRepository.StudentXMLRepo;
import Service.XMLFileService.StudentXMLService;
import Validator.StudentValidator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private StudentXMLRepo repo;
    private StudentXMLService service;
    private StudentValidator vs;

    @Test
    public void tc_1_AddStudentsValid() {
        vs = new StudentValidator();
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"1", "Name", "100", "email@domain.com", "Prof Univ"};
        try {
            service.add(params);
            assertTrue(true);
        }
        catch (ValidatorException ex) {
            fail();
        }
    }
//    @Test
//    public void tc_1_AddStudentsValid() {
//
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        vs = new StudentValidator();
//        try {
//            String[] params={"1", "Name", "100", "email@domain.com", "Prof Univ"};
//            service.add(params);
//            assertTrue(true);
//        } catch (ValidatorException ex) {
//        assertFalse(true);
//        }
//        }
//
//    @Test
//    public void tc_2_InvalidGroup() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"1", "Name", "abc", "email@domain.com", "Prof Univ"};
//            service.add(params);
//        } catch (ValidatorException ex) {
//            assertTrue(false);
//        }
//    }
//
//    @Test
//    public void tc_3_AddStudentInvalidGroupBVA_MinusOne () {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//            try {String[] params={"2", "Name", "-1", "email@domain.com", "Prof Univ"};
//                service.add(params);
//
//                    } catch (ValidatorException ex) {
//            assertTrue(false);
//        }
//    }
//    @Test
//    public void tc_4_AddStudentInvalidGroupBVA_One() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {String[] params={"2", "Name", "1", "email@domain.com", "Prof Univ"};
//            service.add(params);
//        } catch (ValidatorException ex) {
//            assertFalse(true);
//        }
//    }
//@Test
//    public void tc_5_AddStudentInvalidGroupBVA_Zero() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"2", "Name", "0", "email@domain.com", "Prof Univ"};
//            service.add(params);
//
//        } catch (ValidatorException ex) {
//            assertFalse(true);
//        }
//    }
//@Test
//    public void tc_6_AddStudentInvalidIDBVA_MinusOne() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"-1", "Name", "100", "email@domain.com", "Prof Univ"};
//            service.add(params);
//
//        } catch (ValidatorException ex) {
//            assertTrue(false);
//        }
//    }
//@Test
//    public void tc_7_AddStudentInvalidIDBVA_One() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"1", "Name", "100", "email@domain.com", "Prof Univ"};
//            service.add(params);
//
//        } catch (ValidatorException ex) {
//            assertFalse(true);
//        }
//    }
//@Test
//    public void tc_8_AddStudentInvalidIDBVA_Zero() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"0", "Name", "100", "email@domain.com", "Prof Univ"};
//            service.add(params);
//
//                    } catch (ValidatorException ex) {
//            assertFalse(true);
//        }
//    }
//@Test
//    public void tc_9_AddStudentInvalidIDBVA_NotInteger() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"abc", "Name", "100", "email@domain.com", "Prof Univ"};
//            service.add(params);
//
//        } catch (ValidatorException ex) {
//            assertTrue(false);
//        }
//    }
//@Test
//    public void tc_10_AddStudentInvalidEmail_NotAt() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"1", "Name", "100", "emaildomain.com", "Prof Univ"};
//            service.add(params);
//
//        } catch (ValidatorException ex) {
//            assertTrue(false);
//        }
//    }
//@Test
//    public void tc_11_AddStudentInvalidEmail_NotDot() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"1", "Name", "100", "email@domaincom", "Prof Univ"};
//            service.add(params);
//
//        } catch (ValidatorException ex) {
//            assertTrue(false);
//        }
//    }
//@Test
//    public void tc_12_AddStudentInvalidEmail_DotAtTheEnd() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"1", "Name", "100", "email@domain.", "Prof Univ"};
//            service.add(params);
//
//        } catch (ValidatorException ex) {
//            assertTrue(false);
//        }
//    }
//@Test
//    public void tc_13_AddStudentInvalidTeacher_NotSpace() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"1", "Name", "100", "email@domain.com", "ProfUniv"};
//            service.add(params);
//            assertFalse(true);
//        } catch (ValidatorException ex){
//        }
//    }
//@Test
//    public void tc_14_AddStudentInvalidID_MultipleIDs() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"1", "Name", "100", "email@domain.com", "Prof Univ"};
//            service.add(params);
//
//
//        } catch (ValidatorException ex) {
//            assertFalse(true);
//        }
//        try {
//
//            String[] params={"1", "Name", "100", "email@domain.com", "Prof Univ"};
//            service.add(params);
//            assertFalse(true);
//        } catch (ValidatorException ex) {
//        }
//
//    }
//@Test
//    public void tc_15_AddStudentInvalidName_NotString() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"1", "3", "100", "email@domain.com", "Prof Univ"};
//            service.add(params);
//            assertFalse(true);
//        } catch (ValidatorException ex) {
//
//        }
//    }
//
//@Test
//    public void tc_16_AddStudentInvalidEmail_NotString() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"1", "Name", "100", "3", "Prof Univ"};
//            service.add(params);;
//            assertFalse(true);
//        } catch (ValidatorException ex) {
//        }
//    }
//@Test
//    public void tc_17_AddStudentInvalidTeacherName_NotString() {
//        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
//        service = new StudentXMLService(repo);
//        try {
//            String[] params={"1", "Name", "100", "email@domain.com", "3"};
//            service.add(params);
//
//            assertFalse(true);
//        } catch (ValidatorException ex) {
//
//        }
//    }
//

    }

