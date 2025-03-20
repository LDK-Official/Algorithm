package com.example.algorithm.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CupHolder_2810 {
    // 좌석수 N
    // 양끝 좌석은 컵홀더가 하나씩 더 있다.
    // 커플석은 사이에 컵홀더가 없다
    // S는 일반, LL은 커플석
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());       // 좌석 수

        String st = br.readLine();                   // 좌석 형태
        String seatState = st.replace("LL", "C");

//        int coupleSeat = 0;

//        for (int i = 0; i < seat.length(); i++){
//            if (seat.charAt(i) == 'L'){
//                coupleSeat++;
//                i++;
//            }
//        }

        int count = seatState.length() + 1;

        System.out.println(Math.min(N, count));
    }
}
