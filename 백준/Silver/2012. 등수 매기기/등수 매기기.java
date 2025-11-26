import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] expect = new int[N];

        for (int i = 0; i < N; i++) {
            expect[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expect);

        long total = 0;
        for (int i = 0; i < N; i++) {
            int realRank = i + 1;
            total += Math.abs(expect[i] - realRank);
        }

        System.out.println(total);
    }
}