package com.example.algorithm.CodingTestwithjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NightOfKingdom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String position = br.readLine();
        int col = position.charAt(0) - 'a' + 1; //'a'가 1이 되도록 반환
        int row = position.charAt(1) - '0';       // 문자 숫자를 정수로 변환

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        int count = 0;

        for (int i = 0; i < 8; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8){
                count++;
            }
        }

        System.out.println(count);
    }
}
