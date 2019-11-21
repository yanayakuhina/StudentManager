import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PullerStudents {

    private static final String NAME = "SG15DDhe11";
    private static final String URL = "jdbc:mysql://remotemysql.com/" + NAME;
    private static final String USER = "SG15DDhe11";
    private static final String PASSWORD = "k1Ehx8akH4";

    public ArrayList<Student> pullEndMakesMapS(){
        ArrayList<Student> listStudent = new ArrayList<Student>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student ORDER BY id DESC LIMIT 100");
            while (resultSet.next()){
                ArrayList<String> listStudents = new ArrayList<>();
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setGroupId(resultSet.getLong("groupId"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setSecondName(resultSet.getString("secondName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setBirthdayDate(resultSet.getString("birthdayDate"));

                listStudent.add(student);

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listStudent;
    }
}
