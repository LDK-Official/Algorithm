import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i <= 45;  i++) {
            for (int j = 0; j < i; j++) {
                list.add(i);
            }
        }

        int sum = 0;
        for (int i = start - 1; i < end; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}