package jtm.activity12;

/*
    Use this class to test your implemented methods in TeacherManager class
 */
public class Main {

    public static void main(String[] args){
        TeacherManager teacherManager = new TeacherManager();

        //Check Teacher table in MySQL workbench if insert works

        Teacher teacher = new Teacher(100,"Roman","Franklin");
        //teacherManager.insertTeacher();
        //teacherManager.findTeacher("John", "Doe");
        teacherManager.insertTeacher("Lilly", "Smth");
       // teacherManager.updateTeacher();

        //Use same approach for other methods
    }
}
