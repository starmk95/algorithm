// 백준 20310 - 타노스

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        int zeros = 0;
        int ones = 0;
        for(char c : s) {
            if(c=='0') zeros++;
            else ones++;
        }
        zeros/=2;
        ones/=2;

        for(int i=0;i<s.length;i++) {
            if(ones==0) break;
            if(s[i]=='1') {
                s[i] = 'X';
                ones--;
            }
        }
        for(int i=s.length-1;0<=i;i--) {
            if(zeros==0) break;
            if(s[i]=='0') {
                s[i] = 'X';
                zeros--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : s) {
            if(c!='X') {
                sb.append(c);
            }
        }
        String answer = sb.toString();
        System.out.print(answer);
    }
}
