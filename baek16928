// 백준 16928 - 뱀과 사다리 게임

import java.util.*;
import java.io.*;

// dp로 못품.. bfs문제
class Main {
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] portals = new int[101];
        int[] vis = new int[101];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            portals[x] = y;
        }
    for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            portals[x] = y;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur==100) break;
            for(int i=1;i<=6;i++) {
                int nxt = cur+i;
                if(nxt>100) continue;
                if(portals[nxt]!=0) nxt = portals[nxt];
                if(vis[nxt]!=0) continue;
                vis[nxt] = vis[cur]+1;
                q.offer(nxt);
            }
        }
        System.out.print(vis[100]);
    }
}
