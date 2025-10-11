import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;       // 세로 길이
        int m = maps[0].length;    // 가로 길이
        
        // 4방향 이동 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); 
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (maps[nx][ny] != 1) continue;

                maps[nx][ny] = maps[x][y] + 1;

                q.offer(new int[]{nx, ny});
            }
        }
        
        return maps[n-1][m-1] == 1 ? -1 : maps[n-1][m-1];
    }
}