package recommender;

import java.util.*;

public class GetCourses {
    private CourseList electives;
    private CourseList core;
    private CourseList foundation;
    private final GetRecommendation recommender;

    public GetCourses() {
        this.electives = new CourseList();
        this.core = new CourseList();
        this.foundation = new CourseList();
        this.recommender = new GetRecommendation();
    }
/**
     * to get Courses a student can do for the semester given 
     * @param semester
     * @param student
     * @param currentDegree
     * @return IndividualStudent object
     */
    public IndividualStudent execute(String semester, IndividualStudent student, Degree currentDegree) {
        getCoursesInSemester(currentDegree, semester, student.getStudentYear());
        getLegibleCourses(student.getPassedCourses());
        getAllCoursesToDo(student.getPassedCourses());
        java.lang.System.out.println(this.core);
        java.lang.System.out.println(this.electives);
        java.lang.System.out.println(this.foundation);

        return recommender.execute(this.core, this.electives, this.foundation, student);
    }
    
    /**
     * get Courses in the semester that student wishes 
     * @param semester
     * @param year
     * @param currentDegree
     * 
     */
    private void getCoursesInSemester(Degree currentDegree, String semester, int year) {
        this.core = currentDegree.getCore(semester, year);
        this.electives = currentDegree.getElectives(semester, year);
        this.foundation = currentDegree.getFoundations(semester, year);
    }
  /**
     * get Courses in the courses that a student is legible to do 
     * @param passedCourses
     * @param currentDegree
     * 
     */
    private void getLegibleCourses(ArrayList<String> passedCourses) {
        core = getSinglelegibleCourses(passedCourses, core);
        electives = getSinglelegibleCourses(passedCourses, electives);
        foundation = getSinglelegibleCourses(passedCourses, foundation);
    }

     /**
     * get Courses in the courses that a student is legible to do for an individual courseList
     * @param passedCourses
     * @param list
     * @return CourseList
     */
    private CourseList getSinglelegibleCourses(ArrayList<String> passedCourses, CourseList list) {
        CourseList temp = new CourseList();
        for (int x = 0; x < list.getSize(); x = x + 1) {
            if (list.get(x).hasPrerequisits(passedCourses)) {
                temp.addCourse(list.get(x));
            }
        }
        return temp;
    }
/**
     * get all Courses in the courses that a student needs to do for the semester
     * @param passedCourses
     */
    public void getAllCoursesToDo(ArrayList<String> passedCourses) {
        core = getCoursesToDo(passedCourses, core);
        electives = getCoursesToDo(passedCourses, electives);
        foundation = getCoursesToDo(passedCourses, foundation);
    }
/**
     * get all Courses in the courses that a student needs to do for the semester for an individual CourseList
     * @param passedCourses
     * @param list
     * @return CourseList
     */
    public CourseList getCoursesToDo(ArrayList<String> passedCourses, CourseList list) {
        CourseList temp = new CourseList();
        boolean check = false;
        for (int x = 0; x < list.getSize(); x = x + 1) {
            for (int y = 0; y < passedCourses.size(); y = y + 1) {
                if (passedCourses.get(y).equals(list.get(x).getCourseCode())) {
                    check = true;
                }
            }
            if (!check) {
                temp.addCourse(list.get(x));

            }
            check = false;
        }
        return temp;
    }
}
