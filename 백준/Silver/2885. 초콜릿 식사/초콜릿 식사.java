import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int chocolate = 1;
        while (chocolate < K) chocolate *= 2;

        int temp = K, pieces = 0;
        while (temp > 0) {
            if ((temp & 1) == 1) pieces++;
            temp >>= 1;
        }

        int splitCount = 0;
        int size = chocolate;
        int count = 0;
        temp = K;
        while (K > 0) {
            if (K < size) {
                splitCount++;
                size /= 2;
            } else {
                K -= size;
            }
        }
        System.out.println(chocolate + " " + splitCount);
    }
}
