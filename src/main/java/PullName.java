import java.io.File;
import java.util.ArrayList;

public class PullName {

    public ArrayList<String> pullNameFile(String[] args) throws Exception {
        File dir = new File(String.valueOf(args[0]));
        System.out.println(args[0]);
        if (!dir.isDirectory()) {
            throw new Exception("Передан неправильный путь к директории");
        }

        ArrayList<String> files = new ArrayList<>();
        for(File fileCsv: dir.listFiles()){
            if(fileCsv.getName().endsWith(".csv")){

                files.add((fileCsv.getAbsolutePath()));
            }
        }
        return files;
    }
}
