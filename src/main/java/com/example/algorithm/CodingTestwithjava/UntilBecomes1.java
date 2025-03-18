package com.example.algorithm.CodingTestwithjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UntilBecomes1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // target
        int M = Integer.parseInt(st.nextToken());  // 나눌 정수
        
        int count = 0;
        
        while (N > 1) {
            if ((N % M)== 0) {
                N /= M;
            } else {
                N -= 1;
            }
            count++;
        }
        System.out.println(count);
    }
}
