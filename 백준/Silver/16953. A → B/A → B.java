import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long value;
        int count;

        Node(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        bfs(A, B);
    }

    public static void bfs(long A, long B) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(A, 1)); // 시작 값, 연산 횟수 1부터 시작 (A 포함)

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.value == B) {
                System.out.println(current.count);
                return;
            }

            long next1 = current.value * 2;
            if (next1 <= B) {
                queue.offer(new Node(next1, current.count + 1));
            }

            long next2 = current.value * 10 + 1;
            if (next2 <= B) {
                queue.offer(new Node(next2, current.count + 1));
            }
        }

        // 만들 수 없는 경우
        System.out.println(-1);
    }
}