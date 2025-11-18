import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());       
        int M = Integer.parseInt(br.readLine());        

        int[] x = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            x[i] = Integer.parseInt(st.nextToken());   
        }

        int answer = 0;
        
        answer = Math.max(answer, x[0]);
        
        answer = Math.max(answer, N - x[M - 1]);

        for (int i = 0; i < M - 1; i++) {
            int gap = x[i + 1] - x[i];
            int need = (gap + 1) / 2;
            answer = Math.max(answer, need);
        }

        System.out.println(answer);
    }
}