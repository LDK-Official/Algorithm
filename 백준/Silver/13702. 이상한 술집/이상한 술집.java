import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static long[] alcohols;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  
        K = Integer.parseInt(st.nextToken());  

        alcohols = new long[N];
        long max = 0;

        for (int i = 0; i < N; i++) {
            alcohols[i] = Long.parseLong(br.readLine());
            max = Math.max(max, alcohols[i]);  
        }

        long left = 1;
        long right = max;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < N; i++) {
                count += alcohols[i] / mid;  
            }

            if (count >= K) {  
                answer = mid;
                left = mid + 1;
            } else {  
                right = mid - 1;
            }
        }

        System.out.println(answer);  
    }
}