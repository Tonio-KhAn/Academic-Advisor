package recommender;

public class GetRecommendation {

    public IndividualStudent execute(CourseList core, CourseList elective, CourseList foundation,
            IndividualStudent student) {
        String recommendation;
        recommendation = getNumOfCoursesAllowed(student.getGpa());
        recommendation = recommendation + coreToString(core);
        recommendation = recommendation + electiveToString(student.getGpa(), elective, core, foundation);
        student.setRecommendedCourses(recommendation);
        java.lang.System.out.println(student);
        return student;
    }
    /**
     * get number of courses a student is allowed to do 
     * @param gpa
     * @return String
     */
    private String getNumOfCoursesAllowed(double gpa) {
        if (gpa >= 2.0) {
            return "Pick atleast 4 courses no more than 5 courses if you wish to do 6 courses you must request an override\n";
        }
        return "Pick three courses in total\n";
    }
/**
     * converts the coreCourses to a string 
     * @param core
     */
    private String coreToString(CourseList core) {
        return "\nCore Courses\n" + core.displayInformation();
    }
/**
     * converts the electiveCourses to a string 
     * @param gpa
     * @param elective
     * @param core
     * @param foundation
     * @return String
     */
    private String electiveToString(double gpa, CourseList elective, CourseList core, CourseList foundation) {
        if (gpa >= 2.0) {
            return overThreeElectives(elective, core, foundation);
        }
        return underThreeElectives(elective, core, foundation);
    }
/**
     * converts the electiveCourses to a string if student can do more than three courses
     * @param elective
     * @param core
     * @param foundation
     * @return String
     */
    private String overThreeElectives(CourseList elective, CourseList core, CourseList foundation) {
        if (core.getSize() > 5) {
            return "You cannot choose any more coureses";
        }
        if (core.getSize() == 5) {
            return "\nChoose an elective or a foundation course if you wish to do a 6th course\n" + "Electives\n\n" + elective.displayInformation()
                    + "\nFoundation\n " + foundation.displayInformation();
        }
        return "\nChoose " + otherCourses(core.getSize())
                + " more coures to make up 5 courses either from Electives of Foundation Courses\n" + "Electives\n\n"
                + elective.displayInformation() + "Foundation\n " + foundation.displayInformation();

    }
/**
     * converts the electiveCourses to a string if student can only do three courses
     * @param elective
     * @param core
     * @param foundation
     * @return String
     */
    private String underThreeElectives(CourseList elective, CourseList core, CourseList foundation) {
        if (core.getSize() >= 3) {
            return "\nYou cannot choose any other coureses";
        }
        return "\nChoose " + otherCourses(core.getSize())
                + " more coures to make up 3 courses either from Electives of Foundation Courses\n\n"
                + "Electives\n\n" + elective.displayInformation() +  "Foundation\n " + foundation.displayInformation();

    }
    
/**
     * 
     * @param size
     * @return String
     */
    private String otherCourses(int size) {
        return Integer.toString(5 - size);
    }
}
