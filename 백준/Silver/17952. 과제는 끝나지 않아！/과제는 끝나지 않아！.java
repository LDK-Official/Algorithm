import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();
        int total = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());

            if (flag == 1) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                stack.push(new int[]{score, time});
            }


            if (!stack.isEmpty()) {
                stack.peek()[1]--;
                if (stack.peek()[1] == 0) {
                    total += stack.pop()[0];
                }
            }
        }

        System.out.println(total);
    }
}