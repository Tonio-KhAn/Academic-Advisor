package recommender;

import java.util.*;

public class IndividualStudent implements Student{
    private final String studentID;
    private final String studentName;
    private final int studentYear;
    private final String degree;
    private final ArrayList<String> passedCourses;
    private final double gpa;
    private String recommendedCourses;

    public IndividualStudent(String studentID, String studentName, int studentYear, ArrayList<String> passedCourses,
            String degree, double gpa) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentYear = studentYear;
        this.passedCourses = passedCourses;
        this.recommendedCourses = "";
        this.gpa = gpa;
        this.degree = degree;
    }

    /**
     * 
     * @return String object
     */
    public String getDegree() {
        return this.degree;
    }

    /**
     * adds passes courses to list
     * @param courseCode
     */
    public void addPassedCourse(String courseCode) {
        this.passedCourses.add(courseCode);
    }

    /**
     * 
     * @return double object
     */
    public double getGpa() {
        return this.gpa;
    }

    /**
     * sets the recommended courses
     * @param recommendedCourses
     */
    public void setRecommendedCourses(String recommendedCourses) {
        this.recommendedCourses = recommendedCourses;
    }

    /**
     * gets the recommended courses
     * @return String object
     */
    public String getRecommendedCourses() {
        return this.recommendedCourses;
    }

    /**
     * 
     * @return integer object
     */
    public int getStudentYear() {
        return this.studentYear;
    }

    /** Checks if given id is equal to this.student id
     * @param id
     * @return boolean object
     */
    public boolean compare(String id) {
        return this.studentID.equals(id);
    }

    /**
     * 
     * @return ArrayList object
     */
    public ArrayList<String> getPassedCourses() {
        return passedCourses;
    }

    /**
     * 
     * @return String object
     */
    @Override
    public String displayInformation() {
        return this.studentName;
    }
}
