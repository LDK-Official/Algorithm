import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] x = new long[N + 1];
        long[] y = new long[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        x[N] = x[0];
        y[N] = y[0];

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < N; i++) {
            sum1 += x[i] * y[i + 1];
            sum2 += y[i] * x[i + 1];
        }

        double area = Math.abs(sum1 - sum2) / 2.0;

        System.out.println(String.format("%.1f", area));
    }
}