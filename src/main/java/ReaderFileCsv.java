import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class ReaderFileCsv {

    public  ArrayList<Student> reader(String groupName, String nameFile) {

    ArrayList<Student> listX = new ArrayList<>();
        try {
        CSVReader reader = new CSVReader(new FileReader(nameFile));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            Student student = new Student();
            student.setLastName(nextLine[0]);
            student.setFirstName(nextLine[1]);
            student.setSecondName(nextLine[2]);
            student.setBirthdayDate(nextLine[3]);
            student.setGroupName(groupName);
            listX.add(student);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        return listX;
}
}
