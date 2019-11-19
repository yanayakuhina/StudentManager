import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

    private static final String NAME = "SG15DDhe11";
    private static final String URL = "jdbc:mysql://remotemysql.com/" + NAME;
    private static final String USER = "SG15DDhe11";
    private static final String PASSWORD = "k1Ehx8akH4";

    public void insert(Student student){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection
                    .prepareStatement("" +
                            "INSERT INTO Student (firstName, secondName, lastName, birthdayDate, groupId) " +
                            "SELECT ?, ?, ?, ?, id from Groupp where groupName = ?"
                    );
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getSecondName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.getBirthdayDate());
            statement.setString(5, student.getGroupName());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
