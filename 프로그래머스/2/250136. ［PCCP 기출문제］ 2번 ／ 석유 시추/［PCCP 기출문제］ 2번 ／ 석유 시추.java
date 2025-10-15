import java.util.*;

class Solution {
    static int N, M;
    static int[][] land;
    static int[][] visited;
    static int[] colOilSum;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land) {
        this.land = land;
        this.N = land.length;
        this.M = land[0].length;
        
        this.visited = new int[N][M];
        
        this.colOilSum = new int[M];
        
        int clusterId = 1;

        // 모든 칸을 순회하며 석유 덩어리 탐색
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                // 석유가 있고 아직 방문하지 않은 칸
                if (land[r][c] == 1 && visited[r][c] == 0) {
                    // 새로운 덩어리 탐색 시작
                    bfs(r, c, clusterId);
                    clusterId++;
                }
            }
        }

        int maxOil = 0;
        for (int sum : colOilSum) {
            maxOil = Math.max(maxOil, sum);
        }

        return maxOil;
    }

    static void bfs(int startR, int startC, int clusterId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = clusterId;
        int currentSize = 0;
        
        // 덩어리가 포함하는 열을 저장하는 Set
        Set<Integer> colsInCluster = new HashSet<>();
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currR = current[0];
            int currC = current[1];
            
            currentSize++;
            colsInCluster.add(currC); // 현재 칸이 속한 열을 기록
            
            for (int i = 0; i < 4; i++) {
                int nr = currR + dx[i];
                int nc = currC + dy[i];
                
                // 경계 조건 확인
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    // 석유가 있고 아직 방문하지 않음
                    if (land[nr][nc] == 1 && visited[nr][nc] == 0) {
                        visited[nr][nc] = clusterId; // 방문 처리
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        // 덩어리 탐색 완료 후 해당 덩어리가 포함하는 모든 열에 덩어리 크기를 합산
        for (int col : colsInCluster) {
            colOilSum[col] += currentSize;
        }
    }
}