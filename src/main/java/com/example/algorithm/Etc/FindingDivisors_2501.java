package com.example.algorithm.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindingDivisors_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());       //정수
        int K = Integer.parseInt(st.nextToken());       //K번째

        int divisor = 0;

        for (int i = 1; i <= N; i++){
            int solve = N % i;
            if (solve == 0){
                divisor++;
                if (divisor == K){
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(0);      // 약수의 개수가 K개 보다 적어서 K번째 약수가 존재 안하면 0출력
    }
}
