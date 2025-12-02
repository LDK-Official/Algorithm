import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            countMap.put(title, countMap.getOrDefault(title, 0) + 1);
        }

        String answer = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String title = entry.getKey();
            int cnt = entry.getValue();

            if (cnt > maxCount) {
                maxCount = cnt;
                answer = title;
            } else if (cnt == maxCount) {
                if (title.compareTo(answer) < 0) {
                    answer = title;
                }
            }
        }

        System.out.println(answer);
    }
}