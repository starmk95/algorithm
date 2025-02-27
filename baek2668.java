// 백준 2668 - 숫자고르기

import java.util.*;
import java.io.*;

class Main {
    static int[] board;
    static TreeSet<Integer> answer;
    static boolean[] vis;
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n+1];
        for(int i=1;i<=n;i++) {
            board[i] = Integer.parseInt(br.readLine());
        }
        
        // 정렬된 상태로 출력하기 위해 HashSet이 아닌 TreeSet 사용
        answer = new TreeSet<>();
        vis = new boolean[n+1];
        for(int i=1;i<=n;i++) {
            vis[i] = true;
            dfs(i,i);
            vis[i] = false;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer.size() + "\n");
        for(int num : answer) {
            bw.write(num+"\n");
        }
        bw.flush();
        bw.close();
    }

    // 사이클 발생하는 숫자 -> 같은 집합 형성
    static void dfs(int num, int start) {
        int tmp = board[num];
        if(!vis[tmp]) {
            vis[tmp] = true;
            dfs(tmp, start);
            vis[tmp] = false;
        }
        if(tmp == start) {
            answer.add(start);
        }
    }
}
