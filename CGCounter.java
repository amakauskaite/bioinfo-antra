public class CGCounter {

    int percentQuantity[] = new int[10];

    public float[] countCG(String[] lineList)
    {
        float percents[] = new float[(lineList.length/4)+1];
        String line;
        int k=0;
        for (int i=1; i<lineList.length; i+=4)
        {
            line = lineList[i];
            for (int j=0; j<line.length(); j++)
            {
                if (j+1<line.length())
                if (line.substring(j, j+1).equals("C") || line.substring(j, j+1).equals("G"))
                {
                    percents[k]++;
                }
            }
            percents[k] = percents[k] / line.length();
            countPercents(percents[k]);
            k++;
        }

        return percents;
    }

    private void countPercents(float percent){

        if (percent<0.1)
            percentQuantity[0]++;
        else if (percent<0.2)
            percentQuantity[1]++;
        else if (percent<0.3)
            percentQuantity[2]++;
        else if (percent<0.4)
            percentQuantity[3]++;
        else if (percent<0.5)
            percentQuantity[4]++;
        else if (percent<0.6)
            percentQuantity[5]++;
        else if (percent<0.7)
            percentQuantity[6]++;
        else if (percent<0.8)
            percentQuantity[7]++;
        else if (percent<0.9)
            percentQuantity[8]++;
        else
            percentQuantity[9]++;
    }
}
