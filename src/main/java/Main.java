public class Main {



    public static void main(String[] args) throws Exception {
        ReaderFileCsv readerFileCsv = new ReaderFileCsv();
        PullName pullName = new PullName();
        NameGroup nameGroup = new NameGroup();
        InsertGroup insertGroup = new InsertGroup();
        Insert insert = new Insert();

        for(String f: pullName.pullNameFile(args)){
            String namegroup = nameGroup.getNameGroup(f);
            Group g = insertGroup.selectInGroup(namegroup);
            if (g == null){
                Group group = new Group();
                group.setGroupName(namegroup);
                insertGroup.insertGroup(group);
            }
            for(Student student: readerFileCsv.reader(namegroup, f)){
                    insert.insert(student);
        }

        }
    }
}

