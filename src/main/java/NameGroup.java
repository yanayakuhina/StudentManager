public class NameGroup {


    public  String getNameGroup(String nameFile) {

        int from = nameFile.lastIndexOf('\\');
        System.out.println(from);
        return nameFile.substring(from, nameFile.indexOf('.'));
    }
}
