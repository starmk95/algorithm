// 백준 2607번 - 비슷한 단어

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        int answer = 0;
        int[] cnt1 = new int[26];
        for(char c : s1.toCharArray()) cnt1[c-'A']++;
        for(int k=1;k<n;k++) {
            String s2 = br.readLine();
            int[] cnt2 = new int[26];
            for(char c : s2.toCharArray()) cnt2[c-'A']++;
            int diff = 0;
            for(int i=0;i<26;i++) {
                diff+=Math.abs(cnt1[i]-cnt2[i]);
            }
            if(s1.length() == s2.length()) {
                if(diff<=2) answer++;
            } else if(s1.length() == s2.length()+1) {
                if(diff==1) answer++;
            } else if(s1.length() == s2.length()-1) {
                if(diff==1) answer++;
            }
        }
        System.out.print(answer);
    }
}
