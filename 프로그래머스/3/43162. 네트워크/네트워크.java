import java.util.*;

class Solution {

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];

        int networkCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                networkCount++;
                bfs(i, computers, visited);
            }
        }

        return networkCount;
    }
    
    private void bfs(int start, int[][] computers, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next = 0; next < computers.length; next++) {

                if (computers[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}