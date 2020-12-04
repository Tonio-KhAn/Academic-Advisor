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
public class IndividualStudentTest {
    private static IndividualStudent test;

    public IndividualStudentTest() {

    }

    @BeforeAll
    public static void setUpClass() {
        ArrayList<String> list = new ArrayList<>();
        list.add("test passed course");
        test = new IndividualStudent("123456789", "test", 2, list, "testDegree", 4.0);
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
    public void addStudentTest() {
        assertNotNull(test);
    }

    @Test
    @Order(1)
    public void getDegreeTest() {
        assertEquals(test.getDegree(), "testDegree");
    }

    @Test
    @Order(1)
    public void getGPATest() {
        assertEquals(test.getGpa(), 4.0);
    }

    @Test
    @Order(1)
    public void setRecommendedXoursesTest() {
        test.setRecommendedCourses("testString");
        assertEquals(test.getRecommendedCourses(), "testString");
    }

    @Test
    @Order(1)
    public void getYearTest() {
        assertEquals(test.getStudentYear(), 2);
    }

    @Test
    @Order(1)
    public void compareTest() {
        assertTrue(test.compare("123456789"));
    }

    @Test
    @Order(1)
    public void getPassedCoursesTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("test passed course");
        assertEquals(test.getPassedCourses(), list);
    }

    @Test
    @Order(1)
    public void displayInfomationTest() {
        assertEquals(test.displayInformation(), "test");
    }

}