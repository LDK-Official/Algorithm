import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static int[] subtreeSize;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int R = Integer.parseInt(st.nextToken()); 
        int Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        
        countSubtreeNodes(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int queryNode = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[queryNode]).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void countSubtreeNodes(int currentNode) {
        visited[currentNode] = true;
        subtreeSize[currentNode] = 1;

        for (int neighbor : adj[currentNode]) {
            if (!visited[neighbor]) {
                countSubtreeNodes(neighbor);
                subtreeSize[currentNode] += subtreeSize[neighbor];
            }
        }
    }
}