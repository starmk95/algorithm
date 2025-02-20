// 백준 5972번 - 택배 배송
import java.util.*;
import java.io.*;

class Main {
    static int[] dis;
    static ArrayList<Integer>[] costs;
    static ArrayList<Integer>[] lines;
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        costs = new ArrayList[n+1];
        lines = new ArrayList[n+1];
        for(int i=0;i<=n;i++) {
            costs[i] = new ArrayList<>();
            lines[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp = Integer.parseInt(st.nextToken());
            costs[a].add(tmp);
            costs[b].add(tmp);
            lines[a].add(b);
            lines[b].add(a);
        }
        dis = new int[n+1];
        for(int i=2;i<=n;i++) dis[i] = 50000001;
        dikj();
        System.out.print(dis[n]);
    }
    // 다익스트라 알고리즘 이용 
    // 우선순위큐 사용 -> O((V+E)logV)
    /*
        1. 시작 정점을 설정하고, 모든 정점까지의 거리를 **무한대(∞)**로 설정.
            단, 시작 정점의 거리는 0으로 설정.
        2. 우선순위 큐(Heap)에 시작 정점을 삽입하고, 거리 0으로 설정.
        3. 현재 방문한 노드를 기준으로, 인접한 노드들의 거리를 갱신.
        4. 가장 가까운 노드를 선택하여 방문하고, 다시 인접한 노드들의 거리를 갱신.
        5. 모든 노드를 방문할 때까지 반복.
    */
    static void dikj() {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2) -> n1.cost - n2.cost);
        pq.add(new Node(1,0));
        dis[1]=0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            for(int i=0;i<lines[cur.n].size();i++) {
                int nxt = lines[cur.n].get(i);
                int cost = costs[cur.n].get(i);
                if(dis[nxt]>dis[cur.n]+cost) {
                    dis[nxt] = dis[cur.n]+cost;
                    pq.add(new Node(nxt,dis[nxt]));
                }
            }
        }
    }
}

class Node {
    int n;
    int cost;

    public Node(int n, int c) {
        this.n = n;
        this.cost = c;
    }
}
