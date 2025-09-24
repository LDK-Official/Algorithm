import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {

        List<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int[] e : wires) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }

        int[] parent = new int[n + 1];
        int[] subSize = new int[n + 1];


        dfs(1, 0, g, parent, subSize);

        int ans = Integer.MAX_VALUE;
        for (int[] e : wires) {
            int a = e[0], b = e[1];

            int childSize;
            if (parent[b] == a) childSize = subSize[b];
            else if (parent[a] == b) childSize = subSize[a];
            else {
                continue;
            }
            int diff = Math.abs(n - 2 * childSize);
            ans = Math.min(ans, diff);
        }
        return ans;
    }

    private int dfs(int u, int p, List<Integer>[] g, int[] parent, int[] subSize) {
        parent[u] = p;
        int size = 1;
        for (int v : g[u]) {
            if (v == p) continue;
            size += dfs(v, u, g, parent, subSize);
        }
        return subSize[u] = size;
    }
}