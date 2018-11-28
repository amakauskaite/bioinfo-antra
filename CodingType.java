import java.io.UnsupportedEncodingException;

public class CodingType {

    private byte minValue = 104;
    private byte maxValue = 33;

    public void findType(String[] lineList) throws UnsupportedEncodingException {

        //by FASTAQ format, every 4th line contains quality values
        for (int i=3; i<lineList.length; i+=4)
        {
            findRowValues(lineList[i]);
        }

        //print min, max values and coding type
        printCodingInfo();
    }

    private void findRowValues(String codingValuesRow) throws UnsupportedEncodingException {

        //converts string to ascii value array
        byte[] asciiValues = codingValuesRow.getBytes("US-ASCII");
        //iterates through values to find min and max values
        //compares with already found values (or predetermined values, if first iteration)
        for (byte asciiValue : asciiValues) {
            if (asciiValue > maxValue)
                maxValue = asciiValue;
            if (asciiValue < minValue)
                minValue = asciiValue;
        }
    }

    private void printCodingInfo()
    {
        System.out.println("Min value: "+minValue);
        System.out.println("Max value: "+maxValue);
        System.out.println("Type: " + getType(minValue, maxValue));
    }

    private String getType(byte min, byte max)
    {
        if (max<=73 && min>=67)
            return "Impossible to tell";
        if (max>74)
        {
            //not Sanger
            //not Ilumina 1.8
            if (min<64)
                return "Solexa Solexa+64";
            else if (min<66)
                return "Illumina 1.3+ Phred+64";
            else return "Illumina 1.5+ Phred+64";
        }
        //the only way to distinguish Illumina 1.8 from Sanger is that only Illumina 1.8 can have 'J' as a value
        else if (max==74)
            return "Illumina 1.8+ Phred+33";
        //otherwise - impossible to distinguish
        else return "Sanger Phred+33 ('Illumina 1.8+ Phred+33' is also a possiblility)";
    }
}
