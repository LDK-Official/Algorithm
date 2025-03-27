package com.example.algorithm.Daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card1_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // ex) N=4면 1234 => 1버리고 234남음 2를 아래로 옮기고 342 그러면 3을 버리고 4를 아래로
        // 옮기면 24 2를 버리면 남는건 4
        // N = 7이면 1234567 => 1버리고 234567 2를 아래로 345672 3버리고 4 아래로 56724
        // 5버리고 6아래로 7246 7버리고 2아래로 462 4버리고 6아래로 26 2버리면 남는건 6
        // 따라서 버려진 카드들은 1,3,5,7,4,2,6

        Queue<Integer> queue = new LinkedList<>();  // int형 큐

        for (int i = 1; i <= N; i++){
            queue.add(i);
        }

        while(queue.size() > 1){
            sb.append(queue.poll()).append(" ");    // 처음 카드 버리기
            queue.add(queue.poll());                // 다음카드 맨밑으로 보내기
        }
        sb.append(queue.poll());                    // 마지막 남은 카드

        System.out.println(sb);
    }
}
