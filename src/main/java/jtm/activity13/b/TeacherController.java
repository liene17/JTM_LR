package jtm.activity13.b;

import jtm.activity12.Teacher;
import jtm.activity12.TeacherManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    /*
        TODO
        Add @Component annotation to TeacherManager class in jtm.activity12 package
        Add @Autowired annotation to manager field below.
        Spring will automatically create TeacherManager object and inject object into manager field
     */
    @Autowired
    private TeacherManager manager;

    @GetMapping("/teacher/find/byId")
    public Teacher findTeacher(@RequestParam Integer id) {
        /* TODO
           Return Teacher object by Id from Teacher table in database  */
        return manager.findTeacher(id);
    }

    /*
        TODO set get mapping path to /teacher/find/byName
     */
    @GetMapping("/teacher/find/byName")
    public List<Teacher> findTeacher(@RequestParam String firstName,
                                     @RequestParam String lastName) {
        /* TODO
           Return list of Teacher objects by name and last name from Teacher table in database  */
        return manager.findTeacher(firstName, lastName);
    }

    /*
        TODO set get mapping path to /teacher/add
     */
    @GetMapping("/teacher/add")
    public StatusResponse insertTeacher(@RequestParam(required = false) Integer id,
                                        @RequestParam String firstName,
                                        @RequestParam String lastName) {
        /*
            TODO
            Insert new Teacher object into database, if ID parameter is not passed to request
            ID should be auto-generated
            Return StatusResponse object. If teacher is inserted set success to true,
            and message to "Success" otherwise false and "Failure"

         */
        if (id == null) {
            if (manager.insertTeacher(firstName, lastName) == true) {
                return new StatusResponse(true, "Success");
            } else {
                return new StatusResponse(false, "Failure");
            }
        } else {
            Teacher teacher = new Teacher(id, firstName, lastName);
            if (manager.insertTeacher(teacher) == true) {
                return new StatusResponse(true, "Success");
            } else {
                return new StatusResponse(false, "Failure");
            }
        }
    }

    /*
        TODO set get mapping path to /teacher/update
     */
    @GetMapping("/teacher/update")
    public StatusResponse updateTeacher(@RequestParam Integer id,
                                        @RequestParam String firstName,
                                        @RequestParam String lastName) {
        /*
            TODO
            Update teacher in database by ID
            Return StatusResponse object. If teacher is updated set success to true,
            and message to "Success" otherwise false and "Failure"
         */
        Teacher teacher = new Teacher(id, firstName, lastName);
        if (manager.updateTeacher(teacher) == true) {
            return new StatusResponse(true, "Success");
        } else {
            return new StatusResponse(false, "Failure");
        }
    }
}
