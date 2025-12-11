import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] nums = new String[N];

        for (int i = 0; i < N; i++) {
            nums[i] = br.readLine().trim();
        }

        int len = nums[0].length();

        for (int k = 1; k <= len; k++) {
            Set<String> set = new HashSet<>();

            for (int i = 0; i < N; i++) {
                String s = nums[i];
                String suffix = s.substring(len - k);
                set.add(suffix);
            }

            if (set.size() == N) {
                System.out.println(k);
                return;
            }
        }
    }
}