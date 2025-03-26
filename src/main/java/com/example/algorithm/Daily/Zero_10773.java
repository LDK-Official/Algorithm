package com.example.algorithm.Daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++){
            int number = Integer.parseInt(br.readLine());

            if (number == 0){
                stack.pop();
            } else {
                stack.add(number);
            }
        }

        int sum = 0;

        for (int i : stack){
            sum += i;
        }

        System.out.println(sum);
    }
}
