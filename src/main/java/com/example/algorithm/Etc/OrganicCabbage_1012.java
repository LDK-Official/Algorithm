package com.example.algorithm.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OrganicCabbage_1012 {
static int[][] map;
static boolean[][] visited;
static int M, N, K; // 가로, 세로, 배추 수

// 상하좌우
static int[] dx = {-1, 1, 0, 0};
static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 수

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());   //가로
            N = Integer.parseInt(st.nextToken());   //세로
            K = Integer.parseInt(st.nextToken());   //배추 수

            // 초기화
            map = new int[N][M];
            visited = new boolean[N][M];

            //배추 위치
            for (int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int count = 0;

            // 지렁이 탐색
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (map[i][j] == 1 && !visited[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1){
                dfs(nx, ny);
            }
        }
    }
}
