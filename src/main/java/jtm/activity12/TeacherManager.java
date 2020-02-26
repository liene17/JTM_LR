package jtm.activity12;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class TeacherManager {

    public static void main(String[] args) {
        System.out.println(new TeacherManager().findTeacher(1));
    }

    protected Connection conn;

    public TeacherManager() {
        //TODO
		  //When new TeacherManager is created, create connection to the database server:
        try {
         	Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false&characterEncoding=utf8", "admin", "abcd1234"
            );
            conn.setAutoCommit(false); //Use conn.commit() after each Insert/Update/Delete call

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Returns a Teacher instance represented by the specified ID.
     */
    public Teacher findTeacher(int id) {
        /*
         TODO
         Execute an SQL statement that searches teacher by ID.
         If teacher is found return Teacher object with values from DB
         If teacher is not found return null */


        try {
            PreparedStatement  stmt = conn.prepareStatement("select Id, firstName, lastName from Teacher where Id=" + id);
            ResultSet rs = stmt.executeQuery();

            if (rs.first()) {
                id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                System.out.println(firstName + " " + lastName);

                Teacher teacher = new Teacher(id, firstName, lastName);
                return teacher;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns a list of Teacher objects.
     */
    public List<Teacher> findTeacher(String firstName, String lastName) {
        /* TODO
           Write an sql statement that searches teacher by first and last name and returns results as ArrayList<Teacher>.
           Result list should include all partial results as well, e.g. if first name is matching but last name is not
           still include, the teacher in result list, same applies for lastName
           If nothing is found return empty list! */
        try {
            String sql = "select * from Teacher where firstName=? or lastName=?";
            PreparedStatement  stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            ResultSet rs = stmt.executeQuery();
            List<Teacher> teachersList = new ArrayList<>();

            while (rs.next() == true) {
                int id = rs.getInt(1);
                firstName = rs.getString(2);
                lastName = rs.getString(3);
                System.out.println(firstName + " " + lastName);

                Teacher teacher = new Teacher(id, firstName, lastName);
                teachersList.add(teacher);
            }
            return teachersList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Insert an new teacher (first name and last name) into the table.
     */
    public boolean insertTeacher(String firstName, String lastName) {
        /* TODO
           Execute an SQL statement that inserts teacher in database.
           SQL statement should contain only firstName and lastName, ID should be automatically generated by DB */
        try {
        String sql = "insert into Teacher (FirstName, lastName) values ( ?, ?)";
        PreparedStatement  stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            int rs = stmt.executeUpdate();
            conn.commit();
            if(rs == 1){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Insert teacher object into database
     */
    public boolean insertTeacher(Teacher teacher) {
        /*
        TODO
        Execute an SQL statement that inserts teacher in database.
        SQL statement should contain all fields: id, firstName and lastName
        If teacher is inserted successfully return true, otherwise false */

        try {
            String sql = "insert into Teacher(Id, firstName, lastName) values(?, ?, ?)";
            PreparedStatement  stmt = conn.prepareStatement(sql);
            stmt.setInt(1, teacher.getId());
            stmt.setString(2, teacher.getFirstName());
            stmt.setString(3, teacher.getLastName());

            int rs = stmt.executeUpdate();
            conn.commit();
            if(rs == 1){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    /**
     * Updates an existing Teacher in the repository with the values represented by the Teacher object.
     */
    public boolean updateTeacher(Teacher teacher) {
        /*
            TODO
            Execute an SQL statement that updates teacher information.
            Update teacher in database by it's ID
            If ONE teacher is successfully updated, return true, otherwise false */
        try {
            String sql = "update Teacher set FirstName=?, lastName=? where Id=?";
            PreparedStatement  stmt = conn.prepareStatement(sql);
            stmt.setInt(3, teacher.getId());
            stmt.setString(1, teacher.getFirstName());
            stmt.setString(2, teacher.getLastName());

            int rs = stmt.executeUpdate();
            conn.commit();
            if(rs == 1){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteTeacher(int id) {
        /*
            TODO
            Execute an SQL statement that deletes teacher from database.
            Delete teacher by it's ID
            If one teacher is successfully deleted, return true
            If no teacher is deleted return false */
        try {
            String sql = "delete from Teacher where Id=?";
            PreparedStatement  stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rs = stmt.executeUpdate();
            conn.commit();
            if(rs == 1){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void closeConnection() {
        /*
            TODO
            Close connection to the database server and reset conn object to null */

        try {
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
            conn = null;
    }
}
