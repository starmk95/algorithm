/*
    백준 15989번 - 1,2,3 더하기 4

    정수 n을 만든다고 할 때, 
    마지막에 1을 더할 경우, 2를 더할 경우, 3을 더할 경우의 수를 각각 나누어서 고려 
    (덧셈 수식이 오름차순으로 구성된다고 가정)
    
    <점화식>
    마지막에 1을 더할 경우 -> dp[n][1] = dp[n-1][1]
    마지막에 2를 더할 경우 -> dp[n][2] = dp[n-2][2] + dp[n-2][1]
    마지막에 3을 더할 경우 -> dp[n][3] = dp[n-3][3] + dp[n-3][2] + dp[n-3][1]
    3가지 경우 모두 더한 값 = 총 경우의 개수

    <기저값>
    dp[0][1] = 0, dp[0][2] = 0, dp[0][3] = 0,
    dp[1][1] = 1, dp[1][2] = 0, dp[1][3] = 0,
    dp[2][1] = 1, dp[2][2] = 1, dp[2][3] = 0,
    dp[3][1] = 1, dp[3][2] = 1, dp[3][3] = 1,
*/

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[10002][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        int checkpoint = 3;
        for(int t=0;t<T;t++) {
            int n = Integer.parseInt(br.readLine());
            if(checkpoint<n) {
                for(int i=checkpoint+1;i<=n;i++) {
                    dp[i][1] = dp[i-1][1];
                    dp[i][2] = dp[i-2][2] + dp[i-2][1];
                    dp[i][3] = dp[i-3][3] + dp[i-3][2] + dp[i-3][1];
                }
                checkpoint = n;
            }
            int answer = dp[n][1] + dp[n][2] + dp[n][3];
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
