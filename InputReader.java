import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class InputReader {

    String[] lineList;

    // Reads line by line from the fastaq file and converts lines to an array of Strings
    void readFromFASTAQ() throws IOException {
        String fileName = "reads_for_analysis.fastq";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            //stream.forEach(System.out::println);
            lineList = stream.toArray(String[]::new);
        }
    }
}
