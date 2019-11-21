import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PullerGroup {
    private static final String NAME = "SG15DDhe11";
    private static final String URL = "jdbc:mysql://remotemysql.com/" + NAME;
    private static final String USER = "SG15DDhe11";
    private static final String PASSWORD = "k1Ehx8akH4";

    public ArrayList<Group> puller(){
        ArrayList<Group> listGroup = new ArrayList<Group>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Groupp ORDER BY id DESC LIMIT 100");
            while (resultSet.next()){

                Group group = new Group();
                group.setId(resultSet.getLong("id"));
                group.setGroupName(resultSet.getString("groupName"));
                listGroup.add(group);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listGroup;
        }
    }
