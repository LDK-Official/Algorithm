import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] req = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            req[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        int left = 0;
        int right = Arrays.stream(req).max().getAsInt();
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for (int r : req) {
                sum += Math.min(r, mid);
            }

            if (sum <= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
