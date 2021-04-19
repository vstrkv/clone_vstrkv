import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Another {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\vstrk\\IdeaProjects\\job\\GTR";
//        File file = new File(path);
//        System.out.println(file.createNewFile()); //true
//        try (FileOutputStream fos = new FileOutputStream(path)){
//
//        }
        File f = new File(path);
        f.mkdir();

    }
}
