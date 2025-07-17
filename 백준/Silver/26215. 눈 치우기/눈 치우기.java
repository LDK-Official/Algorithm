import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int snow = Integer.parseInt(st.nextToken());
            pq.offer(snow);
        }

        int result = 0;
        while (pq.size() > 0) {
            int first = pq.poll();
            int second = 0;
            if (!pq.isEmpty()) second = pq.poll();

            if (first == 0 && second == 0) break;
            if (first > 0) first--;
            if (second > 0) second--;
            result++;

            if (first > 0) pq.offer(first);
            if (second > 0) pq.offer(second);
        }

        if (result > 1440) System.out.println(-1);
        else System.out.println(result);
    }
}