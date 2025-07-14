import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int day = 1;
            long sum = 0;

            for (int j = 0; j < 6; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            while (sum <= N) {
                sum *= 4;
                ++day;
            }

            sb.append(day).append("\n");
        }
        System.out.println(sb);
    }
}