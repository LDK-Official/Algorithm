import java.io.*;
import java.util.*;

class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int bx = Integer.parseInt(st.nextToken());
		int by = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int gx = Integer.parseInt(st.nextToken());
		int gy = Integer.parseInt(st.nextToken());

		int count = 0;
		if(Math.sqrt(Math.pow(gx - bx, 2) + Math.pow(gy - by, 2)) < 5) {
			System.out.println("NO");
			return;
		} else{
			int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if(x < gx && x < bx || x > gx && x > bx || y < gy && y < by || y > gy && y > by){
				count = count;
			} else{
				count++;
				}
			}

			if(count >= 3){
				System.out.println("YES");
			} else{
				System.out.println("NO");
			}
		}
	}
}