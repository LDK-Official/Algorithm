package com.example.algorithm.CodingTestwithjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberCardGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 행의 수
        int M = Integer.parseInt(st.nextToken());       // 열의 수

        int maxMinValue = 0;    // 가장 큰 '최솟값' 저장

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int minInRow = Integer.MAX_VALUE;       //최솟값 저장( 아주 큰 값으로 초기화해야 비교하기 올바름)
            for (int j = 0; j < M; j++){
                int num = Integer.parseInt(st.nextToken());
                minInRow = Math.min(minInRow, num);
            }

            maxMinValue = Math.max(maxMinValue, minInRow);
        }
        System.out.println(maxMinValue);
    }
}
