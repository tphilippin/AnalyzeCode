import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * reads the program code and returns it without comments
 * @author Tobias Philippin
 * @version 1.0.0
 */
public class AnalyzeCode {

    public static String main(String[] args) {
        return readFile(args[0]);
    }

    /**
     * reads the file
     * @param filename
     * @return code
     */
    private static String readFile(String filename) {
        String code = "";
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                code = code.concat(line).concat("\n");
                System.out.println(line);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return replaceComments(code);
    }

    /**
     * replace Comments
     * @param  code
     * @return codeWithoutLineComments
     */
    private static String replaceComments (String code){
        String codeWithoutMultiLineComments = code.replaceAll("(\\r?\\n?\\s)+/\\*[\\s\\S]*?\\*/", "");
        return codeWithoutMultiLineComments.replaceAll("(\\r?\\n?\\s)+//.*", "");
    }
}