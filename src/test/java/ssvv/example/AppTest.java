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

    @Test
    public void tc_2_InvalidGroup() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"1", "Name", "abc", "email@domain.com", "Prof Univ"};
        try {
            service.add(params);
            fail();
        } catch (NullPointerException | ValidatorException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void tc_3_AddStudentInvalidGroupBVA_MinusOne () {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"2", "Name", "-1", "email@domain.com", "Prof Univ"};

        try {
            service.add(params);
            fail();
        } catch (NullPointerException | ValidatorException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void tc_4_AddStudentInvalidGroupBVA_One() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"3", "Name", "1", "email@domain.com", "Prof Univ"};

        try {
            service.add(params);
            fail();
        } catch (NullPointerException | ValidatorException ex) {
            assertTrue(true);
        }
    }
    @Test
    public void tc_5_AddStudentInvalidGroupBVA_Zero() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"4", "Name", "0", "email@domain.com", "Prof Univ"};

        try {
            service.add(params);
            fail();
        } catch (NullPointerException | ValidatorException ex) {
            assertTrue(true);
        }
    }
    @Test
    public void tc_6_AddStudentInvalidIDBVA_MinusOne() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"-1", "Name", "100", "email@domain.com", "Prof Univ"};

        try {
            service.add(params);
            fail();
        } catch (NullPointerException | ValidatorException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void tc_7_AddStudentInvalidIDBVA_One() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"1", "Name", "100", "email@domain.com", "Prof Univ"};

        try {
            service.add(params);
            fail();
        } catch (NullPointerException | ValidatorException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void tc_8_AddStudentInvalidIDBVA_Zero() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"0", "Name", "100", "email@domain.com", "Prof Univ"};

        try {
            service.add(params);
            fail();
        } catch (ValidatorException | NullPointerException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void tc_9_AddStudentInvalidIDBVA_NotInteger() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"abc", "Name", "100", "email@domain.com", "Prof Univ"};

        try {
            service.add(params);
            fail();
        } catch (NullPointerException| ValidatorException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void tc_10_AddStudentInvalidEmail_NotAt() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"1", "Name", "100", "emaildomain.com", "Prof Univ"};

        try {
            service.add(params);
            fail();
        } catch (NullPointerException| ValidatorException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void tc_11_AddStudentInvalidEmail_NotDot() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"1", "Name", "100", "email@domaincom", "Prof Univ"};

        try {
            service.add(params);
            fail();
        } catch (NullPointerException | ValidatorException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void tc_12_AddStudentInvalidEmail_DotAtTheEnd() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"1", "Name", "100", "email@domain.", "Prof Univ"};

        try {
            service.add(params);
            fail();
        } catch (NullPointerException | ValidatorException ex) {
            assertTrue(true);
        }
    }
    @Test
    public void tc_13_AddStudentInvalidTeacher_NotSpace() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"1", "Name", "100", "email@domain.com", "ProfUniv"};

        try {
            service.add(params);
            fail();
        } catch (NullPointerException | ValidatorException ex) {
            assertTrue(true);
        }
    }
    @Test
    public void tc_14_AddStudentInvalidID_MultipleIDs() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        String[] params = {"1", "Name", "100", "email@domain.com", "Prof Univ"};

        try {
            service.add(params);
            fail();
        } catch (NullPointerException| ValidatorException ex) {
            assertTrue(true);

        }
        String[] params2 = {"1", "Name2", "100", "email@domain.com", "Prof Univ"};

        try {
            service.add(params2);
            fail();
        } catch (NullPointerException | ValidatorException ex) {
            assertTrue(true);
        }

    }

    @Test
    public void tc_15_AddStudentInvalidName_NotString() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
//        try {
//            String[] params = {"1", 3, "100", "email@domain.com", "ProfUniv"};
//            service.add(["1", 3, "100", "email@domain.com", "Prof Univ"]);
//            assertFalse();
//        } catch (ValidatorException ex) {
//            assertTrue();
//        }
    }

    @Test
    public void tc_16_AddStudentInvalidEmail_NotString() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
//        try {
//            service.add(["1", "Name", "100", 3, "Prof Univ"]);
//            assertFalse();
//        } catch (ValidatorException ex) {
//            assertTrue();
//        }
    }

    @Test
    public void tc_17_AddStudentInvalidTeacherName_NotString() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
//        try {
//            service.add(["1", "Name", "100", "email@domain.com", 3]);
//            assertFalse();
//        } catch (ValidatorException ex) {
//            assertTrue();
//        }
    }


}
