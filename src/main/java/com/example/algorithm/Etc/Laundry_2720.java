package com.example.algorithm.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Laundry_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());   // 테스트 케이스 수

        int quarter = 25;   // 쿼터 25센트
        int dime = 10;      // 다임 10센트
        int nickel = 5;     // 니켈 5센트
        int penny = 1;      // 페니 1센트

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());   // 거스름돈

            int q = C / quarter;
            C %= quarter;   // 나머지 저장
            sb.append(q).append(" ");

            int d = C / dime;
            C %= dime;
            sb.append(d).append(" ");

            int n = C / nickel;
            C %= nickel;
            sb.append(n).append(" ");

            int p = C / penny;
            sb.append(p).append("\n");
        }

        System.out.println(sb);

    }
}
