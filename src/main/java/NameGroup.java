public class NameGroup {


    public  String getNameGroup(String nameFile) {

        int from = nameFile.lastIndexOf('\\');
        return nameFile.substring(from+1, nameFile.indexOf('.'));
    }
}
