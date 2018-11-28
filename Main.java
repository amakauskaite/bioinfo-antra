import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        InputReader inputReader = new InputReader();
        inputReader.readFromFASTAQ();

        CodingType codingType = new CodingType();
        codingType.findType(inputReader.lineList);
    }
}
