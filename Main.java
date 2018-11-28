import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        InputReader inputReader = new InputReader();
        inputReader.readFromFASTAQ();

        CodingType codingType = new CodingType();
        codingType.findType(inputReader.lineList);

        CGCounter cgCounter = new CGCounter();
        cgCounter.countCG(inputReader.lineList);
        System.out.println("reads/percentace");
        int a=0,b=10;
        for (int percent: cgCounter.percentQuantity
             ) {
            System.out.println("From "+a+" to "+b+"%: "+percent);
            a+=10;
            b+=10;
        }
    }
}
