package com.example.algorithm.AivleStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CreamPasta_25214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 배열의 크기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minValue = Integer.MAX_VALUE;
        int maxDiff = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (i > 0) {
                maxDiff = Math.max(maxDiff, num - minValue);
                sb.append(maxDiff).append(" ");
            } else {
                sb.append(0).append(" ");
            }

            minValue = Math.min(minValue, num);

        }

        System.out.println(sb.toString().trim());

    }
}