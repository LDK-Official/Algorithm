import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] map;
    static boolean[] visited;

    static class Node {
    int pos, cnt;

        Node(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs(a, b));
    }

    static int bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.pos == end) return cur.cnt;

            int jump = map[cur.pos];
            for (int dir : new int[]{-1, 1}) {
                int next = cur.pos + dir * jump;

                while (next >= 0 && next < N) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(new Node(next, cur.cnt + 1));
                    }
                    next += dir * jump;
                }
            }
        }
        return -1;
    }
}