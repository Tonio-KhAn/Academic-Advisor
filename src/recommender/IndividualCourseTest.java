
package recommender;

import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.MethodOrderer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IndividualCourseTest {
    private static IndividualCourse test;

    public IndividualCourseTest() {

    }

    @BeforeAll
    public static void setUpClass() {
        ArrayList<String> list = new ArrayList<>();
        list.add("test Prerequisite");
        test = new IndividualCourse("test", list, "2", "this is a test", "TEST 1000", 2);
    }

    @BeforeEach
    public void setUp() {

    }

    @AfterAll
    public static void tearDownClass() {

    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    @Order(1)
    public void addCourseTest() {
        assertNotNull(test);
    }

    @Test
    @Order(1)
    public void inSemesterTest() {
        assertTrue(test.inSemester("2"));
    }

    @Test
    @Order(1)
    public void hasPrerequisiteTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("test Prerequisite");
        assertTrue(test.hasPrerequisits(list));
    }

    @Test
    @Order(1)
    public void inYearTest() {
        assertTrue(test.inYear(2));
    }

    @Test
    @Order(1)
    public void getCourseCodeTest() {
        assertEquals(test.getCourseCode(), "TEST 1000");
    }

    @Test
    @Order(1)
    public void displayInfomationTest() {
        assertEquals(test.displayInformation(), "TEST 1000 - test");
    }

}