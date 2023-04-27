import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzeCodeTest {
    String expectedCode = "public class HelloWorld {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Hallo Welt!\");\n" +
            "    }\n" +
            "}\n";

    String expectedCodeWithoutComments = "public class HelloWorldWithComments {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Hallo Welt!\");\n" +
            "    }\n" +
            "}\n";

    @org.junit.jupiter.api.Test
    void readFileWithoutCommentsTest() {
        File codeFile = new File("test\\HelloWorld.java");
        String[] mainParameters = {codeFile.getAbsolutePath()};
        assertEquals(expectedCode, AnalyzeCode.readFile(mainParameters[0]), "A difference has occurred");
    }

    @org.junit.jupiter.api.Test
    void readFileWitCommentsTest() {
        File codeFile = new File("test\\HelloWorldWithComments.java");
        String[] mainParameters = {codeFile.getAbsolutePath()};
        assertEquals(expectedCodeWithoutComments, AnalyzeCode.readFile(mainParameters[0]), "A difference has occurred");
    }

    @org.junit.jupiter.api.Test
    void mainCountLinesTest() {
        File codeFile = new File("test\\HelloWorld.java");
        String[] mainParameters = {codeFile.getAbsolutePath()};
        assertEquals(5, AnalyzeCode.main(mainParameters), "A difference has occurred");
        codeFile = new File("test\\HelloWorldWithComments.java");
        mainParameters[0] = codeFile.getAbsolutePath();
        assertEquals(5, AnalyzeCode.main(mainParameters), "A difference has occurred");
    }
}