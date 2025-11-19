import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() < M) continue;

            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<String> words = new ArrayList<>(freq.keySet());

        words.sort((a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);

            if (fa != fb) return fb - fa;
            if (a.length() != b.length())
                return b.length() - a.length();
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w).append("\n");
        }
        System.out.println(sb);
    }
}

