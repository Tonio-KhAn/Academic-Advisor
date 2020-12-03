package recommender;

import java.util.*;
import java.io.*;

public class Degree {
    private CourseList electiveCourses;
    private CourseList coreCourses;
    private CourseList foundationCourses;
    private String degreeName;

    public Degree(String core, String elective, String foundation, String name) {
        this.degreeName = name;
        this.coreCourses = new CourseList(core);
        this.electiveCourses = new CourseList(elective);
        this.foundationCourses = new CourseList(foundation);;
    }

    /**Returns all core courses in Degree
     * 
     * @return CourseList object
     */
    public CourseList sendcore() {
        return this.coreCourses;
    }

    /**
     * Gets Electives given a Semester and a Year
     * @param s
     * @param year 
     * 
     * @return CourseList object
     */
    public CourseList getElectives(String s, int year) {
        CourseList temp = new CourseList();
        for (int x = 0; x < electiveCourses.getSize(); x = x + 1) {
            if (electiveCourses.get(x).inSemester(s) && electiveCourses.get(x).inYear(year)) {
                temp.addCourse(electiveCourses.get(x));
            }
        }
        return temp;

    }

     /**
     * Gets Core Courses given a Semester and a Year
     * @param s
     * @param year
     * 
     * @return CourseList object
     */
    public CourseList getCore(String s, int year) {
        CourseList temp = new CourseList();

        for (int x = 0; x < coreCourses.getSize(); x = x + 1) {
            if (coreCourses.get(x).inSemester(s) && coreCourses.get(x).inYear(year)) {
                temp.addCourse(coreCourses.get(x));
            }
        }
        return temp;
    }

     /**
     * Gets Foundation given a Semester and a Year
     * @param s 
     * @param year 
     * 
     * @return CourseList object
     */
    public CourseList getFoundations(String s, int year) {
        CourseList temp = new CourseList();
        for (int x = 0; x < foundationCourses.getSize(); x = x + 1) {
            if (foundationCourses.get(x).inSemester(s)) {
                temp.addCourse(foundationCourses.get(x));
            }
        }
        return temp;

    }

    /** Compares a given string with degreeName
     * @param name
     * @return boolean object
     */
    public boolean compare(String name) {
        return this.degreeName.equals(name);
    }

  
    /**
     * Returns All Course Info for the Course specified by courseCode
     * @param courseCode
     * @return String object
     */
    public String getCourseInfo(String courseCode){
        return coreCourses.getCourseInfo(courseCode) + electiveCourses.getCourseInfo(courseCode) + foundationCourses.getCourseInfo(courseCode);
    }

    /**Returns degree name
     * 
     * @return String object
     */
    @Override
    public String toString() {
        return degreeName;
    }

}
