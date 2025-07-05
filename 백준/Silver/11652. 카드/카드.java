import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long answer = 0;
        int maxCount = 0;

        for (long key : map.keySet()) {
            int count = map.get(key);

            if (count > maxCount) {
                maxCount = count;
                answer = key;
            } else if (count == maxCount) {
                if (key < answer) {
                    answer = key;
                }
            }
        }
        System.out.println(answer);
    }
}