package com.example.algorithm.CodingTestwithjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LargeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //배열 크기
        int M = Integer.parseInt(st.nextToken());   //총 더하는 횟수
        int K = Integer.parseInt(st.nextToken());   //연속으로 더할수 있는 횟수

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i ++){
            numbers[i] = Integer.parseInt(st.nextToken());  // 입력받은 숫자 배열로 만들기
        }

        Arrays.sort(numbers);       // 배열 내림차순 정렬
        int first = numbers[N - 1]; // 가장 큰 수
        int second = numbers[N - 2];// 두번째로 큰 수

        int sum = 0;                // 최종 더한 값

        for (int i = 0; i < M; i ++){
            if (i % (K + 1) == K) {
                sum += second;
            } else {
                sum += first;
            }
        }

        System.out.println(sum);

    }
}
