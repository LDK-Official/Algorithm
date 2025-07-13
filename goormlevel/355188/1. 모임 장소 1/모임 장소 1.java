import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] xs = new int[N];
		int[] ys = new int[N];

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			xs[i] = Integer.parseInt(st.nextToken());
			ys[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(xs);
		Arrays.sort(ys);

		long medianX = xs[N / 2];
		long medianY = ys[N / 2];

		long result = 0;
		for(int i = 0; i < N; i++){
			result += Math.abs(xs[i] - medianX);
			result += Math.abs(ys[i] - medianY);
		}

		System.out.println(result);
	}
}