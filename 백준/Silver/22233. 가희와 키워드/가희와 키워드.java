import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> memo = new HashSet<>();

        for (int i = 0; i < N; i++) {
            memo.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String line = br.readLine();

            String[] keywords = line.split(",");

            for (String key : keywords) {
                memo.remove(key);
            }

            sb.append(memo.size()).append("\n");
        }

        System.out.print(sb);
    }
}

