package recommender;

import java.util.*;

public class IndividualCourse implements Course{
    private final String courseName;
    private final ArrayList<String> prerequisits;
    private final String semester;
    private final String description;
    private final String courseCode;
    private final int year;

    public IndividualCourse(String name, ArrayList<String> prerequisits, String semester, String description,
            String courseCode, int year) {
        this.courseName = name;
        this.prerequisits = prerequisits;
        this.semester = semester;
        this.description = description;
        this.courseCode = courseCode;
        this.year = year;

    }

    /**
     * checks to see if semester given s id equal to the course semester
     * @param s
     * @return boolean object
     */
    public boolean inSemester(String s) {
        if (this.semester.equals("1 and 2")) {
            return true;
        }
        return this.semester.equals(s);
    }

    /**
     * Checks if given year is more less than or equal to the course year
     * @param year
     * @return boolean object
     */
    public boolean inYear(int year) {
        return(year >= this.year);
    }

    /**
     * Checks if List of passed courses have the prerequisite for the course
     * @param passedCourses
     * @return boolean object
     */
    public boolean hasPrerequisits(List<String> passedCourses) {
        if (prerequisits.get(0).equals("NONE")) {
            return true;
        }
        for (int x = 0; x < prerequisits.size(); x = x + 1) {
            for (int y = 0; y < passedCourses.size(); y = y + 1) {
                if (passedCourses.get(y).equals(prerequisits.get(x))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *  Returns courseCode
     * @return String object
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     *
     * @return String object
     */
    @Override
    public String displayInformation() {
        return courseCode + " - " + courseName;
    }

    /**
     * 
     * @return String object
     */
    @Override
    public String toString() {
        String text;
        text = courseCode + "\n" + courseName + "\nSEMESTER" + semester + "\nPRE-REQUISITES: " + prerequisits
                + "\nCOURSE DESCRIPTION \n" + description;
        return text;
    }

    
}
