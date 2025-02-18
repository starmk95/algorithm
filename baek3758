// 백준 3758번 - KCPC

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 팀의 개수
            int k = Integer.parseInt(st.nextToken());   // 문제의 개수
            int t = Integer.parseInt(st.nextToken());   // 팀 ID
            int m = Integer.parseInt(st.nextToken());   // 로그 엔트리의 개수

            int[][] stats = new int[n+1][4];    // 각 팀의 최종 점수, 제출 횟수, 마지막 제출 시간, 팀 ID를 저장
            for(int i=0;i<n+1;i++) stats[i][3] = i;
            int[][] questions = new int[n+1][k+1];  // 각 팀별 문제를 푼 현황 - 0이면 아직 안품
            int time = 0;
            while(m-->0) {
                time++;
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());  // 팀 ID
                int qn = Integer.parseInt(st.nextToken());  // 문제 번호
                int score = Integer.parseInt(st.nextToken());   // 획득한 점수

                if(score>questions[id][qn]) {
                    stats[id][0] += score - questions[id][qn];
                    questions[id][qn] = score;
                }
                stats[id][1]++;
                stats[id][2] = time;
            }
            Arrays.sort(stats, (a, b) -> {
                if(a[0]>b[0]) return -1;
                else if(a[0]==b[0]) {
                    if(a[1]<b[1]) return -1;
                    else if(a[1]==b[1]) {
                        if(a[2]<b[2]) return -1;
                        else return 1;
                    }
                    else return 1;
                }
                else return 1;
            });
            for(int i=0;i<n;i++) {
                if(stats[i][3]==t) {
                    bw.write((i + 1) + "\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
