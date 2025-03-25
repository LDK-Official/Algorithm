package com.example.algorithm.Daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stick_17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int count = 1;

        for (int i = 0; i < N; i++){
            stack.add(Integer.parseInt(br.readLine()));
        }

        int first = stack.pop();    // 처음 기준
        while(!stack.isEmpty()){
            int current = stack.pop();
            if (current > first){
                first = current;
                count++;
            }
        }
        System.out.println(count);
    }
}
