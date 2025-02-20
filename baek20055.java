// 백준 20055번 컨베이어 벨트 위의 로봇

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dur = new int[2*n];
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i=0;i<2*n;i++) {
            dur[i] = Integer.parseInt(st.nextToken());
            if(dur[i]==0) cnt++;
        }
        boolean[] robot = new boolean[n];
        int indicator = 0;
        int phase = 1;
        while(true) {
            // 과정 1
            // 벨트 회전
            indicator--;
            if(indicator<0) indicator = 2*n-1;
            for(int i=n-2;0<=i;i--) {
                robot[i+1] = robot[i];
            }
            robot[0]=false;
            // n번째 자리에 있는 로못 하차
            if(robot[n-1]==true) robot[n-1] = false;

            // 과정 2
            for(int i=n-2;0<i;i--) {
                int idx = (indicator+i+1)%(2*n);
                if(robot[i] && !robot[i+1] && dur[idx]>0) {
                    robot[i+1] = true;
                    robot[i] = false;
                    dur[idx]--;
                    if(dur[idx]==0) cnt++;
                }
            }
            // n번째 자리에 있는 로못 하차
            if(robot[n-1]==true) robot[n-1] = false;
            
            // 과정 3
            if(dur[indicator]>0) {
                robot[0] = true;
                dur[indicator]--;
                if(dur[indicator]==0) cnt++;
            }

            // 과정 4
            if(cnt>=k) break;
            phase++;
        }
        System.out.print(phase);
    }
}
