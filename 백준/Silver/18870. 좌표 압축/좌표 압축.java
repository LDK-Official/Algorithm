import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] origin = new int[N];  
        int[] sorted = new int[N];  

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            origin[i] = x;
            sorted[i] = x;
        }

        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int r = 0;

        for (int i = 0; i < N; i++) {
            if (!rank.containsKey(sorted[i])) {
                rank.put(sorted[i], r);
                r++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(rank.get(origin[i])).append(" ");
        }

        System.out.println(sb);
    }
}