import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] C = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken()); 
            long B = Long.parseLong(st.nextToken());

            C[i] = B - A;
        }

        Arrays.sort(C);

        long result;

        if (N % 2 == 1) {
            result = 1;
        } else {
            long left = C[N / 2 - 1];
            long right = C[N / 2];

            result = right - left + 1;
        }

        System.out.println(result);
    }
}