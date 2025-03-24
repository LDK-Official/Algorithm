package com.example.algorithm.AivleStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Fibonacci4_10826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(N));
    }

    public static BigInteger fibonacci(int N){
        if (N == 0) return BigInteger.ZERO;
        if (N == 1 || N == 2) return BigInteger.ONE;

        BigInteger[] dp = new BigInteger[N + 1];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;

        for (int i = 3; i < dp.length; i++){
            dp[i] = dp[i -2].add(dp[i -1]);
        }

        return dp[N];
    }
}
