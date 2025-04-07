// 백준 1987 - 알파벳

import java.util.*;
import java.io.*;

class Main {
    static int r;
    static int c;
    static char[][] board;
    static boolean[] alpha;
    static int[][] vis;
    static int answer;
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        for(int i=0;i<r;i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j=0;j<c;j++) {
                board[i][j] = tmp[j];
            }
        }
        answer = 0;
        alpha = new boolean[26];
        vis = new int[r][c];
        dfs(0,0,1);
        System.out.print(answer);
    }
    static void dfs(int nx, int ny, int cnt) {
        if(nx<0||r<=nx||ny<0||c<=ny) return;
        if(vis[nx][ny]>0) return;
        if(alpha[board[nx][ny]-'A']) return;
        vis[nx][ny] = 1;
        alpha[board[nx][ny]-'A'] = true;
        answer = Math.max(answer, cnt);
        dfs(nx+1,ny,cnt+1);
        dfs(nx,ny+1,cnt+1);
        dfs(nx-1,ny,cnt+1);
        dfs(nx,ny-1,cnt+1);
        vis[nx][ny] = 0;
        alpha[board[nx][ny]-'A'] = false;
    }
}
