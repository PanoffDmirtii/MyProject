import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\XS\\basejava");
        toDirecotory(file);
    }

    private static void toDirecotory(File file) {
        File[] dir = file.listFiles();
        for (File element : dir) {
            if (element.isDirectory()){
                toDirecotory(element);
            }
            System.out.println(element);
        }
    }
}
