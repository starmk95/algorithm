// 백준 4485 - 녹색 옷 입은 애가 젤다지?

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }


class Main {

	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int cnt = 0;
        while(true) {
            cnt++;
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            int[][] board = new int[n][n];
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] dx = {1,0,-1,0};
            int[] dy = {0,1,0,-1};
            int[][] vis = new int[n][n];
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    vis[i][j] = Integer.MAX_VALUE;
                }
            }

            // 가중치 있는 그래프 -> 단순 bfs아닌 다익스트라 사용해야함
            PriorityQueue<Node> q = new PriorityQueue<>();
            vis[0][0] = board[0][0];
            q.offer(new Node(0,0,board[0][0]));
            while(!q.isEmpty()) {
                Node cur = q.poll();
                for(int dir=0;dir<4;dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if(nx<0||n<=nx||ny<0||n<=ny) continue;
                    if(cur.cost+board[nx][ny]>=vis[nx][ny]) continue;
                    vis[nx][ny] = cur.cost+board[nx][ny];
                    q.offer(new Node(nx,ny,vis[nx][ny]));
                }
            }
            bw.write("Problem " + cnt + ": " + vis[n-1][n-1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
