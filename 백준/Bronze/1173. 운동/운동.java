import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 운동 1분 단위로 함 운동 or 휴식
        // 기존 맥박 : X
        // 운동 : 맥박 T만큼 증가 => X + T
        // 운동시에 맥박이 M을 넘으면 안댐 => X + T <= M
        // 휴식 : 맥박이 R만큼 감소 => X - R
        // 휴식할때 맥박이 m을 내려가면 안댐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 운동 시간
        int m = Integer.parseInt(st.nextToken());   // 초기 맥박
        int M = Integer.parseInt(st.nextToken());   // 맥박 최댓값
        int T = Integer.parseInt(st.nextToken());   // 증가 맥박
        int R = Integer.parseInt(st.nextToken());   // 감소 맥박

        if (m + T > M) {
            System.out.println(-1);     // 운동 불가 상태
            return;
        }

        int pulse = m;
        int minute = 0;  // 운동 누적 시간
        for (int i = 0; ; i++) {
            if (minute == N) {
                System.out.println(i);
                break;
            }

            if (pulse + T <= M) {
                pulse += T;
                minute++;
            } else {
                pulse -= R;
                if (pulse < m) {
                    pulse = m;
                }
            }
        }
    }
}