package recommender;

public class App {
    System newSystem;
    
    public App() {
        newSystem = new System();
    }

    public String recommend(String studentID, String semester) {
         if (semester.equals("1") || semester.equals("2")){
        return newSystem.requestRecommendation(studentID,semester);
         }
         else
         {
             return ("Incorrect Semester");
         }
    }
    public String getInfo(String courseCode){
        return newSystem.getCourseInfo(courseCode);
        }
}
