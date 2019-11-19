import java.sql.*;

public class InsertGroup {



    private static final String NAME = "SG15DDhe11";
    private static final String URL = "jdbc:mysql://remotemysql.com/" + NAME;
    private static final String USER = "SG15DDhe11";
    private static final String PASSWORD = "k1Ehx8akH4";

    public Group selectInGroup(String groupName){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Groupp WHERE groupName = ?");
            statement.setString(1, groupName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                Group group = new Group();
                group.setId(resultSet.getLong("id"));
                group.setGroupName(resultSet.getString("groupName"));
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void insertGroup(Group group){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO Groupp (groupName) VALUES (?)");
            statement.setString(1,group.getGroupName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}