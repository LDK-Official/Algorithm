import java.io.*;
import java.util.*;

public class Main {
    static class Tower {
        int height;
        int index;
        Tower(int h, int i) {
            height = h;
            index = i;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && stack.peek().height <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek().index).append(" ");
            }

            stack.push(new Tower(arr[i], i + 1));
        }

        System.out.println(sb);
    }
}