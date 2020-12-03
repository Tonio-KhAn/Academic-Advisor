package recommender;

import java.util.*;
import java.io.*;

public class StudentList implements Student{
    private ArrayList<IndividualStudent> students;

    public StudentList(String file) {
        students = new ArrayList<>();
        StudentFileAdder adder= new StudentFileAdder();
        students = adder.execute(file);

    }

    /**
     * Mutator
     * @param s
     */
    public void addCourse(IndividualStudent s) {
        students.add(s);
    }

    /**
     * Accessor
     * @param x
     * @return IndividualStudent object
     */
    public IndividualStudent get(int x) {
        return students.get(x);
    }

    /**
     * Accessor
     * @return integer object
     */
    public int getSize() {
        return students.size();
    }

    
    
    /**
     * Accessor
     * @return String object
     */
    @Override
    public String displayInformation() {
        String text = "";
        for (int x = 0; x < students.size(); x = x + 1) {
            text = text + students.get(x).getDegree() + "\n";
        }
        return text;
    }

}
