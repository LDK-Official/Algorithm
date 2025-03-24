package com.example.algorithm.AivleStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sequence_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int max = 1;
        int ic = 1; //연속 증가 횟수
        int dc = 1; //연속 감소 횟수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++){
            if (arr[i] >= arr[i - 1]){
                ic++;
            } else {
                ic = 1;
            }

            if (arr[i] <= arr[i - 1]){
                dc++;
            } else {
                dc = 1;
            }

            max = Math.max(max, Math.max(ic, dc));
        }

        System.out.println(max);
    }
}
