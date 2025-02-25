// 백준 2467 - 용액

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 투포인터 활용
        int f = 0;
        int s = n-1;
        int[] num = new int[]{arr[f], arr[s]};
        int answer = Math.abs(arr[f]+arr[s]);
        while(f<s) {
            int sum = arr[f]+arr[s];
            if(Math.abs(sum)<answer) {
                num[0] = arr[f];
                num[1] = arr[s];
                answer = Math.abs(sum);
            }
            if(sum<0) {
                f++;
            }
            else {
                s--;
            }
        }
        System.out.print(num[0] + " " + num[1]);
    }
}
