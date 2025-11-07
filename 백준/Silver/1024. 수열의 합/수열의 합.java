import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken()); 
        int L = Integer.parseInt(st.nextToken());

        boolean found = false;

        for (int len = L; len <= 100; len++) {
            long numerator = N - (long) len * (len - 1) / 2;

            if (numerator < 0) break;

            if (numerator % len == 0) {
                long start = numerator / len;  // 첫 항 x

                if (start >= 0) {
                    for (int i = 0; i < len; i++) {
                        System.out.print((start + i) + " ");
                    }
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}