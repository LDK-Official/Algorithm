package com.example.algorithm.Daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yongsik_1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] count = new int[N];   //인당 공 받은 횟수
        int now = 0;                //지금 공 위치
        count[now] = 1;             //시작은 항상 1번
        int total = 0;              //공 던진 총 횟수

        while(true){
            if (count[now] == M) break;

            if (count[now] % 2 ==1) {
                now = (now + L) % N;
            }else{
                now = (now - L + N) % N;
            }

            count[now]++;
            total++;
        }

        System.out.println(total);
    }
}
