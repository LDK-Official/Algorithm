package com.example.algorithm.CodingTestwithjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Time {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for (int hour = 0; hour <= N; hour++){
            for (int minute = 0; minute < 60; minute++){
                for (int seconds = 0; seconds < 60; seconds++){
                    if (String.valueOf(hour).contains("3")
                    || String.valueOf(minute).contains("3")
                    || String.valueOf(seconds).contains("3")){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
