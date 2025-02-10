// 백준 17484 - 진우의 달 여행(small)

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
        dp[i][j][b] = b방향으로 i,j칸에 도달하는 최소값
        b = 0,1,2   - 순서대로 좌측하단, 중앙하단, 우측하단

        <초기값>
        dp[0][j][b] = board[0][j]

        <점화식>
        dp[i][j][0] = min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + board[i][j]
        dp[i][j][1] = min(dp[i-1][j][0], dp[i-1][j][2]) + board[i][j]
        dp[i][j][2] = min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + board[i][j]

        */
        int[][][] dp = new int[n][m][3];
        for(int i=0;i<m;i++) {
            dp[0][i][0] = board[0][i];
            dp[0][i][1] = board[0][i];
            dp[0][i][2] = board[0][i];
        }
        for(int i=1;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(j==0) {
                    // 2번 방향은 인덱스 밖이므로 고려X
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + board[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + board[i][j];
                }
                else if(j==m-1) {
                    // 0번 방향은 인덱스 밖이므로 고려X
                    dp[i][j][1] = dp[i-1][j][2] + board[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + board[i][j];
                }
                else {
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + board[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + board[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + board[i][j];
                }
            }
        }
        /// 최소값 구하려면 마지막 행 모든 칸의 모든 방향에 대한 최소값 비교해야됨
        int answer = dp[n-1][0][0];
        for(int b=0;b<3;b++) {
            for(int i=0;i<m;i++) {
                if(dp[n-1][i][b]!=0) answer = Math.min(dp[n-1][i][b], answer);
            }
        }
        System.out.println(answer);
    }
}
