import java.io.*;
import java.util.*;
public class Main {
    
    // 체스판은 흰검흰검 배열이다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                char c = line.charAt(j);
                if ((i + j) % 2 == 0 && c == 'F') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
