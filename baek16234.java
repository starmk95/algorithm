// 백준 16234번 - 인구 이동

import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int l;
    static int r;
    static int[][] board;
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while(true) {
            boolean flag = check();
            if(flag) answer++;
            else break;
        }
        System.out.print(answer);
    }

    static public boolean check() {
        // 연합을 이룰 나라가 있는지 확인하는 flag
        boolean flag = false;
        // 연합 구분을 위한 배열 (+ 방문 확인)
        int[][] vis = new int[n][n];
        int un = 0;
        // 각 나라에 대해 연결된 나라(연합)를 구하기 위한 bfs 실행
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(vis[i][j]!=0) continue;
                // 같은 연합에 속한 나라 수 세고, 리스트에 저장
                int cnt = 1;
                List<int[]> list = new ArrayList<>();
                // 같은 연합의 인구 수의 합도 저장
                int sum = board[i][j];
                list.add(new int[]{i,j});
                // 연합 구분을 위한 숫자
                un++;
                vis[i][j] = un;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i,j});
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    for(int dir=0;dir<4;dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if(nx<0||n<=nx||ny<0||n<=ny) continue;
                        if(vis[nx][ny]!=0) continue;
                        int sub = Math.abs(board[nx][ny]-board[x][y]);
                        if(sub<l||r<sub) continue;
                        vis[nx][ny] = un;
                        q.offer(new int[]{nx,ny});
                        list.add(new int[]{nx,ny});
                        cnt++;
                        sum+=board[nx][ny];
                        flag = true;
                    }
                }
                // 하나의 연합 모두 구했으면 인구 배분하기
                int pop = sum/cnt;
                for(int[] tmp : list) {
                    board[tmp[0]][tmp[1]] = pop;
                }
            }
        }
        return flag;
    }
}
