// 백준 22251번 - 빌런 호석

import java.util.*;

class Main {
    static int n, k, p, x, answer;
    static int[][] board;
	static public void main(String []args) {
		Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        p = sc.nextInt();
        x = sc.nextInt();

        board = new int[][]{
        {0,4,3,3,4,3,2,3,1,2},
        {4,0,5,3,2,5,6,1,5,4},
        {3,5,0,2,5,4,3,4,2,3},
        {3,3,2,0,3,2,3,2,2,1},
        {4,2,5,3,0,3,4,3,3,2},
        {3,5,4,2,3,0,1,4,2,1},
        {2,6,3,3,4,1,0,5,1,2},
        {3,1,4,2,3,4,5,0,4,3},
        {1,5,2,2,3,2,1,4,0,1},
        {2,4,3,1,2,1,2,3,1,0}
        };

        dfs(0,0,0);

        System.out.print(answer-1);

    }

    static void dfs(int idx, int cur, int cnt) {
        if(cur>n || cnt>p) return;
        if(idx==k) {
            if(cur!=0) answer++;
            return;
        }
        for(int i=0;i<10;i++) {
            int tens = (int)Math.pow(10,idx);
            dfs(idx+1, i*tens+cur, cnt+board[x/tens%10][i]);
        }
    }
}
