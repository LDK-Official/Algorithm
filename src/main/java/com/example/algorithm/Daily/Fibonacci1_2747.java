package com.example.algorithm.Daily;


import java.util.Scanner;

public class Fibonacci1_2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n){
        int[] arr = new int[46];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i < arr.length; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }

        return arr[n];
    }

}
