import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
    private int min, max, checkSum, divSum;

    public int partOne() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String textline;

        while((textline = br.readLine()) != null) {
            String[] numbs = textline.split("/");
            int[] holder = toIntArray(numbs);
            min = getMin(holder);
            max = getMax(holder);
            checkSum += (max - min);
        }
        br.close();

        return checkSum;
    }

    public int partTwo() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
        String textline;

        while((textline = br.readLine()) != null) {
            String[] numbs = textline.split("/");
            int[] holder = toIntArray(numbs);
            divSum += getEvenDivider(holder);
        }
        br.close();

        return divSum;
    }

    public int getEvenDivider(int[] array) {
        int evenDivider = 0;

        for(int i = 0; i < array.length; i++) {
            int a = array[i];
            for(int j = 0; j < array.length; j++) {
                int b = array[j];
                evenDivider = (((b % a) == 0) && i != j) ? b/a : evenDivider;
            }
        }

        return evenDivider;
    }

    public int getMin(int[] array)  {
        int current = array[0];
        for(int i = 0; i < array.length; i++) current = (current > array[i]) ? array[i] : current;

        return current;
    }

    public int getMax(int[] array) {
        int currentHigh = array[0];
        for(int i = 0; i < array.length; i++) currentHigh = (currentHigh < array[i]) ? array[i] : currentHigh;

        return currentHigh;
    }

    public int[] toIntArray(String[] arr) {
        int[] array = new int[arr.length];
        for(int i = 0; i < arr.length; i++) array[i] = Integer.parseInt(arr[i]);
        return array;
    }
}
