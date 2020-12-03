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
public class CourseFileAdder extends FileAdder{
    /*Accepts a name of a text file with courses and places the files content into an  ArrayList<IndividualCourse>
     * 
     * @return CourseList object
     */
      public final ArrayList<IndividualCourse> execute(String name){
        return scanStream(getFileStream(name), name);
    }
      /*Places input for a course from an InputStream ArrayList<IndividualCourse>
     * 
     * @return CourseList object
     */
    protected ArrayList<IndividualCourse> scanStream(InputStream is, String name){
        IndividualCourse newCourse;
        ArrayList<IndividualCourse> course = new ArrayList<IndividualCourse>();
     try {
           
            Scanner input = new Scanner(is);
            input.useDelimiter("\\?");

            while (input.hasNext()) {
                input.next();
                String courseName = input.next();
                String semester = input.next();
                String description = input.next();
                String courseCode = input.next();
                ArrayList<String> prereq = new ArrayList<String>();
                String tempPrereq = input.next();
                while (!tempPrereq.equals("$")) {
                    prereq.add(tempPrereq);
                    tempPrereq = input.next();
                }
                int year = input.nextInt();
                newCourse = new IndividualCourse(courseName, prereq, semester, description, courseCode, year);
                course.add(newCourse);
            }
            input.close();
        } catch (Exception e) {
           java.lang.System.out.println(name + "File not found");
        }
        return course;
    }
    
}
