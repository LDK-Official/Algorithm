package com.example.algorithm.AivleStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Resignation_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] dp = new int[N + 3];

        for (int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >0; i--){
            int nextDay = i + T[i];

            if (nextDay <= N + 1){
                dp[i] = Math.max(dp[nextDay] + P[i], dp[i + 1]);
            }else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);

    }
}
