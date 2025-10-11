import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;         // 지역의 높이 정보
    static boolean[][] visited; // 방문 체크
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int maxHeight = 0; 
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int answer = 0;
        for (int h = 0; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int count = 0; 

            // 모든 좌표 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (!visited[i][j] && map[i][j] > h) {
                        bfs(i, j, h);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
    
    static void bfs(int x, int y, int height) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                
                if (!visited[nx][ny] && map[nx][ny] > height) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
