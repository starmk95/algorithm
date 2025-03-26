// 백준 1863 - 스카이라인 쉬운거

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int answer = 0;
        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int tmp = Integer.parseInt(st.nextToken());
            if(s.isEmpty()) {
                s.push(tmp);
                continue;
            }
            if(s.peek()<tmp) {
                s.push(tmp);
            }
            else {
                while(!s.isEmpty()) {
                    if(s.peek()>tmp) {
                        s.pop();
                        answer++;
                    }
                    else if(s.peek() == tmp) {
                        break;
                    }
                    else {
                        s.push(tmp);
                        break;
                    }
                }
                if(s.isEmpty()) {
                    s.push(tmp);
                }
            }
        }
        while(!s.isEmpty()) {
            if(s.peek()==0) break;
            s.pop();
            answer++;
        }
        System.out.print(answer);
    }
}
