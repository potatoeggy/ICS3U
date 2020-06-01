import java.io.*;
import java.util.*;

public class tester {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.toString().replace("[", "").replace(",", "").replace("]", ""));

        int[][] array = new int[10][20];

        for (int[] list2 : array) {
            Arrays.fill(list2, 5);
        }
        System.out.println(Arrays.deepToString(array).replace("], ", "\n").replace("]", "").replace(",", "").replace("[", ""));
        
    }

}
