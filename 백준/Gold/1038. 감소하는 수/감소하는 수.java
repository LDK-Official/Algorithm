import java.io.*;
import java.util.*;

public class Main {

    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            dfs(i, i);
        }

        Collections.sort(list);

        if (N >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
    }

    static void dfs(long lastDigit, long num) {
        list.add(num);

        for (long next = lastDigit - 1; next >= 0; next--) {
            dfs(next, num * 10 + next);
        }
    }
}