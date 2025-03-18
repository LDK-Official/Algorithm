package com.example.algorithm.CodingTestwithjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameDevelopment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //맵의 세로 크기
        int M = Integer.parseInt(st.nextToken());   //맵의 가로 크기

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());   //캐릭터 현재 x 좌표
        int y = Integer.parseInt(st.nextToken());   //캐릭터 현재 y 좌표
        int direction = Integer.parseInt(st.nextToken());   //바라보는 방향

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;   //초기 방문위치 저장
        int count =1;

        //북0, 동1, 남2, 서3
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int turnTime = 0;

        while (true) {
            //왼쪽으로 회전
            direction = (direction + 3) % 4;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 이동가능하면 이동
            if (!visited[nx][ny] && map[nx][ny] == 0) {
                visited[nx][ny] = true;
                x = nx;
                y = ny;
                count++;
                turnTime = 0;
                continue;
            } else {
                turnTime++;
            }

            if (turnTime == 4){
                nx = x - dx[direction];
                nx = y - dy[direction];

                if (map[nx][ny] == 0){
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
                turnTime = 0;
            }
        }

        System.out.println(count);
    }
}
