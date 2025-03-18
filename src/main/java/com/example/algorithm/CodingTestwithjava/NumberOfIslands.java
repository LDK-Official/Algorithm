package com.example.algorithm.CodingTestwithjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfIslands {
    static int[][] map;
    static boolean[][] visited;
    static int w, h;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            //너비, 높이
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0){
                break;
            }

            map = new int[h][w];    //자바 2차원 배열이 행을 먼저 열을 나중에 저장하기때문에 h,w
            visited = new boolean[h][w];

            // 지도 입력
            for (int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    if (map[i][j] == 1 && !visited[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    //DFS 탐색
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < h && ny < w){
                if (map[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx, ny);
                }
            }
        }
    }
}
