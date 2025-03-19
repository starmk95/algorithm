// 백준 2138번 - 전구와 스위치

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String tmp1 = br.readLine();
        String tmp2 = br.readLine();

        boolean[] cur = new boolean[n];
        boolean[] target = new boolean[n];

        for(int i=0;i<n;i++) {
            if(tmp1.charAt(i)=='0') {
                cur[i] = false;
            } else {
                cur[i] = true;
            }
            if(tmp2.charAt(i)=='0') {
                target[i] = false;
            } else {
                target[i] = true;
            }
        }
        boolean[] tmp = new boolean[n];
        for(int i=0;i<n;i++) {
            tmp[i] = cur[i];
        }

        int answer = -1;
        // 0번 스위치를 눌렀을 경우와 누르지 않았을 경우 오른쪽 스위치들이 처례로 어떻게 정해지는지 확인하면 됨
        // 그리디
        // 먼저 0번 스위치 누르지 않았을 경우,
        int cnt = 0;
        for(int i=1;i<n;i++) {
            if(tmp[i-1]==target[i-1]) continue;
            cnt++;
            tmp[i-1] = !tmp[i-1];
            tmp[i] = !tmp[i];
            if(i == n-1) {
                break;
            }
            tmp[i+1] = !tmp[i+1];
        }
        boolean flag = true;
        for(int i=0;i<n;i++) {
            if(tmp[i]!=target[i]) flag = false;
        }
        if(flag) answer = cnt;

        // 0번 스위치 눌렀을 경우,
        cur[0] = !cur[0];
        cur[1] = !cur[1];
        cnt = 1;
        for(int i=1;i<n;i++) {
            if(cur[i-1]==target[i-1]) continue;
            cnt++;
            cur[i-1] = !cur[i-1];
            cur[i] = !cur[i];
            if(i == n-1) {
                break;
            }
            cur[i+1] = !cur[i+1];
        }
        flag = true;
        for(int i=0;i<n;i++) {
            if(cur[i]!=target[i]) flag = false;
        }
        if(flag) {
            if(answer == -1) answer = cnt;
            else answer = Math.min(answer, cnt);
        }
        System.out.print(answer);
    }
}
