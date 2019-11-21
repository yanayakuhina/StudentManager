import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ReaderFileCsv readerFileCsv = new ReaderFileCsv();
        PullName pullName = new PullName();
        NameGroup nameGroup = new NameGroup();
        InsertGroup insertGroup = new InsertGroup();
        Insert insert = new Insert();

        PullerGroup pullerGroup = new PullerGroup();
        PullerStudents pullerStudents = new PullerStudents();
        ArrayList<Student> finiteList = new ArrayList<Student>();
        SortFiniteListStudents sortFiniteListStudents = new SortFiniteListStudents();


            for (String f : pullName.pullNameFile(args)) {
                String namegroup = nameGroup.getNameGroup(f);
                Group g = insertGroup.selectInGroup(namegroup);
                if (g == null) {
                    Group group = new Group();
                    group.setGroupName(namegroup);
                    insertGroup.insertGroup(group);
                    for (Student student : readerFileCsv.reader(namegroup, f)) {
                        insert.insert(student);
                    }

                }
            }
            for (Group group : pullerGroup.puller()) {
                for (Student student : pullerStudents.pullEndMakesMapS()) {
                    if (group.getId() == student.getGroupId()) {
                        student.setGroupName(group.getGroupName());
                        finiteList.add(student);
                    }
                }
            }
            for (String group : sortFiniteListStudents.sortByGroups(finiteList).keySet()) {
                System.out.println(group);
                for (Object stud : sortFiniteListStudents.sortByGroups(finiteList).get(group)) {
                    System.out.println(stud);
                }
            }
        }
    }


