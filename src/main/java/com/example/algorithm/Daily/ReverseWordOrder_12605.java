package com.example.algorithm.Daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWordOrder_12605 {
    //단어를 반대순서대로 뒤집기
    // W개의 영단어
    // L개의 알파벳을 가짐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());       // 전체 케이스 개수

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++){
            String[] word = br.readLine().split(" ");   // 단어 분리

            sb.append("Case #").append(i).append(": ");     // Case # i:(출력 조건)

            for (int j = word.length -1; j >= 0; j--) {      // 단어 순서 바꾸는 중
                sb.append(word[j]);
                if (j != 0) {
                    sb.append(" ");                         // 한칸씩 띄우기
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
