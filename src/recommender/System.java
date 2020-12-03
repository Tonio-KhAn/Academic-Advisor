package recommender;

import java.util.*;

public class System {
    private Degree currentDegree;
    private final ArrayList<Degree> degrees;
    private final GetCourses getCourses;
    private IndividualStudent currentStudent;
    private final StudentList studentList;

    public System() {
        degrees = new ArrayList<>();
        Degree infotech = new Degree("ITcore", "ITelective", "Foun", "B.Sc. Information Technology (Special)");
        degrees.add(infotech);
        Degree compsci = new Degree("CScore", "CSelective", "Foun", "B.Sc. Computer Science (Special)");
        degrees.add(compsci);
        studentList = new StudentList("Student");
        getCourses = new GetCourses();

    }

    /**
     * 
     * @param studentID
     * @param semester
     * @return String object
     */
    public String requestRecommendation(String studentID, String semester) {

        if (!setCurrentStudent(studentID)) {
           return ("NO Student with that ID exist");
        }
        setCurrentDegree(currentStudent.getDegree());
        this.currentStudent = getCourses.execute(semester, this.currentStudent, this.currentDegree);
        return "Hello " + currentStudent.displayInformation() + "\n" + currentStudent.getRecommendedCourses();
    }

    /**
     * @param id
     * @return boolean object
     */
    private boolean setCurrentStudent(String id) {
        for (int x = 0; x < studentList.getSize(); x = x + 1) {
            java.lang.System.out.println(studentList.get(x).compare(id));
            if (studentList.get(x).compare(id)) {
                currentStudent = studentList.get(x);
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param courseCode
     * @return String object
     */
    public String getCourseInfo(String courseCode){
        String info = ""; 
        for ( int x=0;x< degrees.size(); x=x+1){
           info = degrees.get(x).getCourseInfo(courseCode);
           if (!info.equals("")){
               return info;
           }
        }
        return ("Course does not exist");
    }

    /**
     * Mutator
     * @param name
     */
    private void setCurrentDegree(String name) {
        for (int x = 0; x < degrees.size(); x = x + 1) {
            if (degrees.get(x).compare(name)) {
                currentDegree = degrees.get(x);
            }
        }
    }

   
}
