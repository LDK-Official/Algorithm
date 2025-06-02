import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] lectures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());  // 강의 개수
        M = Integer.parseInt(st.nextToken());  // 블루레이 개수
        
        lectures = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxLecture = 0;  // 강의 중 가장 긴 시간
        int totalSum = 0;    // 전체 강의 시간 합
        
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            maxLecture = Math.max(maxLecture, lectures[i]);
            totalSum += lectures[i];
        }

        int left = maxLecture;
        int right = totalSum;
        int result = totalSum;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDivide(mid)) {
                result = mid;
                right = mid - 1;  // 블루레이 크기 줄이기
            } else {
                left = mid + 1;   // 블루레이 크기 늘리기
            }
        }

        System.out.println(result);
    }

    // mid 크기로 블루레이 M개 이하로 가능한지 확인
    static boolean canDivide(int size) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum + lectures[i] > size) {
                count++;
                sum = lectures[i];
            } else {
                sum += lectures[i];
            }
        }

        return count <= M;
    }
}