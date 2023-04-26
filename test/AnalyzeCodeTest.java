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
    void readFileTestWithoutComments() {
        File codeFile = new File("test\\HelloWorld.java");
        AnalyzeCode analyzeCode = new AnalyzeCode();
        String[] mainParameters = {codeFile.getAbsolutePath()};
        assertEquals( expectedCode, analyzeCode.main(mainParameters), "A difference has occurred");
    }

    @org.junit.jupiter.api.Test
    void readFileTestWitComments() {
        File codeFile = new File("test\\HelloWorldWithComments.java");
        AnalyzeCode analyzeCode = new AnalyzeCode();
        String[] mainParameters = {codeFile.getAbsolutePath()};
        assertEquals( expectedCodeWithoutComments, analyzeCode.main(mainParameters), "A difference has occurred");
    }
}