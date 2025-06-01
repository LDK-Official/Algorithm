import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static ArrayList<Integer> busTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 버스의 개수
        T = Integer.parseInt(st.nextToken());   // 터미널 도착 시간

        busTime = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());   // 버스 시작 시각
            int I = Integer.parseInt(st.nextToken());   // 버스 간격
            int C = Integer.parseInt(st.nextToken());   // 버스 대수

            for (int j = 0; j < C; j++) {
                busTime.add(S + I * j); // 버스 시간 입력
            }
        }

        Collections.sort(busTime);

        int left = 0;
        int right = busTime.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (busTime.get(mid) >= T) {
                result = busTime.get(mid) - T;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}