package ssvv.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private StudentXMLRepo repo;
    private StudentXMLService service;

    @Test
    public void tc_1_AddStudentsValid() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["1", "Name", "100", "email@domain.com", "Prof Univ"]);
            assertTrue();
        } catch (ValidatorException ex) {
            assertFalse();
        }
    }

    @Test
    public void tc_2_InvalidGroup() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["1", "Name", "abc", "email@domain.com", "Prof Univ"]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }
    }

    @Test
    public void tc_3_AddStudentInvalidGroupBVA_MinusOne () {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add["2", "Name", "-1", "email@domain.com", "Prof Univ"]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }
    }

    public void tc_4_AddStudentInvalidGroupBVA_One() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add["3", "Name", "1", "email@domain.com", "Prof Univ"]);
            assertTrue();
        } catch (ValidatorException ex) {
            assertFalse();
        }
    }

    public void tc_5_AddStudentInvalidGroupBVA_Zero() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add["4", "Name", "0", "email@domain.com", "Prof Univ"]);
            assertTrue();
        } catch (ValidatorException ex) {
            assertFalse();
        }
    }

    public void tc_6_AddStudentInvalidIDBVA_MinusOne() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["-1", "Name", "100", "email@domain.com", "Prof Univ"]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }
    }

    public void tc_7_AddStudentInvalidIDBVA_One() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["1", "Name", "100", "email@domain.com", "Prof Univ"]);
            assertTrue();
        } catch (ValidatorException ex) {
            assertFalse();
        }
    }

    public void tc_8_AddStudentInvalidIDBVA_Zero() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["0", "Name", "100", "email@domain.com", "Prof Univ"]);
            assertTrue();
        } catch (ValidatorException ex) {
            assertFalse();
        }
    }

    public void tc_9_AddStudentInvalidIDBVA_NotInteger() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["abc", "Name", "100", "email@domain.com", "Prof Univ"]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }
    }

    public void tc_10_AddStudentInvalidEmail_NotAt() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["1", "Name", "100", "emaildomain.com", "Prof Univ"]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }
    }

    public void tc_11_AddStudentInvalidEmail_NotDot() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["1", "Name", "100", "email@domaincom", "Prof Univ"]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }
    }

    public void tc_12_AddStudentInvalidEmail_DotAtTheEnd() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["1", "Name", "100", "email@domain.", "Prof Univ"]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }
    }

    public void tc_13_AddStudentInvalidTeacher_NotSpace() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["1", "Name", "100", "email@domain.com", "ProfUniv"]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }
    }

    public void tc_14_AddStudentInvalidID_MultipleIDs() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["1", "Name", "100", "email@domain.com", "Prof Univ"]);
            assertTrue();
        } catch (ValidatorException ex) {
            assertFalse();
        }
        try {
            service.add(["1", "Name2", "100", "email@domain.com", "Prof Univ"]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }

    }

    public void tc_15_AddStudentInvalidName_NotString() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["1", 3, "100", "email@domain.com", "Prof Univ"]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }
    }


    public void tc_16_AddStudentInvalidEmail_NotString() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["1", "Name", "100", 3, "Prof Univ"]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }
    }

    public void tc_17_AddStudentInvalidTeacherName_NotString() {
        repo = new StudentXMLRepo(vs, "StudentiXML.xml");
        service = new StudentXMLService(repo);
        try {
            service.add(["1", "Name", "100", "email@domain.com", 3]);
            assertFalse();
        } catch (ValidatorException ex) {
            assertTrue();
        }
    }


}
