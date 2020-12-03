package recommender;

import java.util.*;
    /**
     * 
     * 
     */
public class CourseList implements Course{
    private ArrayList<IndividualCourse> courses;

     public CourseList() {
        courses = new ArrayList<>();
    }
    public CourseList(String file) {
        courses = new ArrayList<>();
        CourseFileAdder adder= new CourseFileAdder();
        courses = adder.execute(file);
    }

    /**
     * Mutator which adds a course to the Course List
     * @param c
     *
     */
    public void addCourse(IndividualCourse c) {
        courses.add(c);
    }

    /**
     * Returns An Individual course in x location in the array 
     * @param x
     * @return IndividualCourse object
     */
    public IndividualCourse get(int x) {
        return courses.get(x);
    }

    /**
     * returns the size of the Array
     * @return inter
     */
    public int getSize() {
        return courses.size();
    }

    /**
     * Returns all course info for a course given the courseCode
     * @param courseCode
     * @return String object
     */
    public String getCourseInfo(String courseCode){
        for(int x = 0 ; x<courses.size();x=x+1){
            if (courseCode.equals(courses.get(x).getCourseCode())){
                return courses.get(x).toString();
            }
        }
        return "";
    }

    /**
     * 
     * @return String 
     */
    @Override
    public String displayInformation() {
        String text = "";
        for (int x = 0; x < courses.size(); x = x + 1) {
            text = text + courses.get(x).displayInformation() + "\n";
        }
        return text;
    }

    
}
