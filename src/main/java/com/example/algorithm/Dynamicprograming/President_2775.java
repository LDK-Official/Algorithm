package com.example.algorithm.Dynamicprograming;

import java.util.Scanner;

public class President_2775 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   //테스트 케이스 수

        for (int t = 0; t < T; t++){
            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(Residents(k, n));
        }
    }

    public static int Residents(int k, int n){
        int [][] apt = new int[k+1][n+1];

        for (int i = 1; i <= n; i++ ){
            apt[0][i] = i;
        }

        for (int floor = 1; floor <= k; floor++){
            for (int room = 1; room <= n; room++){
                apt[floor][room] = apt[floor][room - 1] + apt[floor -1][room];
            }
        }

        return apt[k][n];
    }
}
