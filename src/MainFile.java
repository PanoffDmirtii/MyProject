import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\XS\\basejava");
        toDirectory(file, "");
    }

    private static void toDirectory(File file, String space) {
        String point = "..........".concat(space);
        File[] dir = file.listFiles();
        for (File element : dir) {
            if (element.isDirectory()){
                System.out.println("Directory: " + point + element);
                toDirectory(element, point);
            }
        }
    }
}
