import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] score = new int[N + 1];
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int documentRank = Integer.parseInt(st.nextToken());
                int interviewRank = Integer.parseInt(st.nextToken());
                score[documentRank] = interviewRank;
            }

            int count = 1;
            int minInterviewRank = score[1];

            for (int i = 2; i <= N; i++) {
                if (score[i] < minInterviewRank) {
                    count++;
                    minInterviewRank = score[i];
                }
            }

            System.out.println(count);
        }
    }
}