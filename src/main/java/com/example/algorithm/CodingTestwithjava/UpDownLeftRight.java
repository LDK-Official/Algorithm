package com.example.algorithm.CodingTestwithjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UpDownLeftRight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = 1, y = 1;

        while(st.hasMoreTokens()){
            char move = st.nextToken().charAt(0);
            int nx = x, ny = y;

            switch (move) {
                case 'L' : ny -= 1; break;
                case 'R' : ny += 1; break;
                case 'U' : nx -= 1; break;
                case 'D' : nx += 1; break;
            }

            if (nx >= 1 && ny >= 1 && nx <= N && ny <= N){
                x = nx;
                y = ny;
            }
        }

        System.out.println(x + " " + y);

    }
}
