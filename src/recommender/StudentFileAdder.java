/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommender;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tonio
 */
public class StudentFileAdder extends FileAdder{
    /*Accepts a name of a text file with students and places the files content into an  ArrayList<IndividualCourse>
     * 
     * @return CourseList object
     */
     public final ArrayList<IndividualStudent> execute(String name){
        return scanStream(getFileStream(name), name);
    }
      /*Places input for students from an InputStream ArrayList<IndividualCourse>
     * 
     * @return CourseList object
     */
    protected ArrayList<IndividualStudent> scanStream(InputStream is, String name){
        IndividualStudent newStudent;
        ArrayList<IndividualStudent> students = new ArrayList<IndividualStudent>();
        try {
            //File compFile = new File("txtFiles/Student.txt");
            Scanner input = new Scanner(is);
            input.useDelimiter("\\?");

            while (input.hasNext()) {
                String studentID = input.next();
                String studentName = input.next();
                int studentYear = input.nextInt();
                ArrayList<String> passed = new ArrayList<String>();
                String tempPassed = input.next();
                while (!tempPassed.equals("$")) {
                    passed.add(tempPassed);
                    tempPassed = input.next();
                }
                String degree = input.next();
                double gpa = input.nextDouble();
                newStudent = new IndividualStudent(studentID, studentName, studentYear, passed, degree, gpa);
                students.add(newStudent);
            }
            input.close();
     } catch (Exception e) {
           java.lang.System.out.println(name + "File not found");
     }
        return students;
    }
}
