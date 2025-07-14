import java.io.*;
import java.util.*;
class Main {
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> students = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("add")) {
                students.add(cmd.substring(4));
            } else if (cmd.startsWith("find")) {
                String prefix = cmd.substring(5);
                int count = 0;
                for (String name : students) {
                    if (name.startsWith(prefix)) count++;
                }
                sb.append(count).append('\n');
            }
        }
        
        System.out.print(sb);
    }
}