import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] books = new int[N];

        int count = 1;

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                books[i] = Integer.parseInt(st.nextToken());
            }
        } else {
            System.out.println(0);
            return;
        }

        int weight = 0;
        for (int i = 0; i < N; i++) {
            weight += books[i];
            if (weight > M) {
                count++;
                weight = books[i];
            }
        }
        System.out.println(count);
    }
}