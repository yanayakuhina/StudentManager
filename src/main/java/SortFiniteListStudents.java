import java.util.*;
import java.util.stream.Collectors;

public class SortFiniteListStudents {

    public Map<String, ArrayList> sortByGroups(ArrayList<Student> listStudent){
        Map<String, ArrayList> mapStudents = new HashMap<>();
        ArrayList<String> list;
        for (Student student : listStudent){
            String stud = student.getLastName() + " " + student.getFirstName() + " " + student.getSecondName() + " " +  student.getBirthdayDate();
            if(mapStudents.containsKey(student.getGroupName())){
                list = mapStudents.get(student.getGroupName());
                list.add(stud);
            } else {
                list = new ArrayList<String>();
                list.add(stud);
                mapStudents.put(student.getGroupName(), list);
            }
        }
    return mapStudents;
    }

}
